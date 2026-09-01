package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;
import io.github.easy4j.meituan.utils.StringUtils;

import java.time.Clock;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 带本地缓存的租户配置存储。
 * <p>该实现用于“配置维护在数据库/缓存/配置中心，但 SDK 调用要快速获得租户 token”的场景。
 * 首次访问时通过 {@link MeituanTenantConfigLoader} 加载配置，后续请求优先读取本地内存缓存；
 * 配置发生变更时，业务系统可以调用 {@link #evict(String)} 或 {@link #put(String, MeituanTenantConfig)}
 * 主动刷新单个租户。</p>
 */
public class CachedMeituanTenantConfigStorage implements MeituanTenantConfigStorage {

    /**
     * 本地租户配置缓存。
     */
    private final Map<String, CacheEntry> cachedTenants = new ConcurrentHashMap<>();

    /**
     * 按租户维度隔离的加载锁，避免同一租户缓存击穿。
     */
    private final Map<String, Object> tenantLocks = new ConcurrentHashMap<>();

    /**
     * 外部租户配置加载器。
     */
    private final MeituanTenantConfigLoader tenantConfigLoader;

    /**
     * 缓存有效期；零值或负值表示不过期。
     */
    private final Duration timeToLive;

    /**
     * 当前时间来源，便于测试控制缓存过期。
     */
    private final Clock clock;

    /**
     * 创建不过期的缓存型租户配置存储。
     *
     * @param tenantConfigLoader 外部租户配置加载器
     */
    public CachedMeituanTenantConfigStorage(MeituanTenantConfigLoader tenantConfigLoader) {
        this(tenantConfigLoader, Duration.ZERO);
    }

    /**
     * 创建支持 TTL 的缓存型租户配置存储。
     *
     * @param tenantConfigLoader 外部租户配置加载器
     * @param timeToLive         缓存有效期；为空或非正数表示不过期
     */
    public CachedMeituanTenantConfigStorage(MeituanTenantConfigLoader tenantConfigLoader, Duration timeToLive) {
        this(tenantConfigLoader, timeToLive, Clock.systemDefaultZone());
    }

    /**
     * 创建支持自定义时钟的缓存型租户配置存储，主要便于单元测试控制时间。
     *
     * @param tenantConfigLoader 外部租户配置加载器
     * @param timeToLive         缓存有效期；为空或非正数表示不过期
     * @param clock              时钟
     */
    public CachedMeituanTenantConfigStorage(MeituanTenantConfigLoader tenantConfigLoader, Duration timeToLive, Clock clock) {
        this.tenantConfigLoader = Objects.requireNonNull(tenantConfigLoader, "tenantConfigLoader must not be null");
        this.timeToLive = Objects.isNull(timeToLive) ? Duration.ZERO : timeToLive;
        this.clock = Objects.requireNonNull(clock, "clock must not be null");
    }

    /**
     * 优先从本地缓存查找租户配置，缓存缺失或过期时再调用外部加载器。
     *
     * @param tenantId 租户标识
     * @return 存在则返回租户配置，否则返回空
     */
    @Override
    public Optional<MeituanTenantConfig> findByTenantId(String tenantId) {
        if (!StringUtils.hasText(tenantId)) {
            return Optional.empty();
        }
        CacheEntry cacheEntry = cachedTenants.get(tenantId);
        if (Objects.nonNull(cacheEntry) && !cacheEntry.isExpired(now(), timeToLive)) {
            return Optional.of(cacheEntry.getTenantConfig());
        }
        return reloadWithTenantLock(tenantId);
    }

    /**
     * 写入或覆盖本地缓存。
     * <p>适用于业务系统在授权回调、管理后台保存配置后，立即把最新 token 推入 SDK 缓存。</p>
     *
     * @param tenantId     租户标识
     * @param tenantConfig 租户授权配置
     */
    public void put(String tenantId, MeituanTenantConfig tenantConfig) {
        if (!StringUtils.hasText(tenantId) || Objects.isNull(tenantConfig)) {
            return;
        }
        tenantConfig.setTenantId(tenantId);
        cachedTenants.put(tenantId, new CacheEntry(tenantConfig, now()));
    }

    /**
     * 主动重新加载并覆盖本地缓存。
     *
     * @param tenantId 租户标识
     * @return 外部加载器返回的最新租户配置
     */
    public Optional<MeituanTenantConfig> refresh(String tenantId) {
        if (!StringUtils.hasText(tenantId)) {
            return Optional.empty();
        }
        Object tenantLock = tenantLocks.computeIfAbsent(tenantId, key -> new Object());
        synchronized (tenantLock) {
            try {
                return reload(tenantId);
            } finally {
                tenantLocks.remove(tenantId, tenantLock);
            }
        }
    }

    /**
     * 删除单个租户缓存。
     *
     * @param tenantId 租户标识
     */
    public void evict(String tenantId) {
        if (StringUtils.hasText(tenantId)) {
            cachedTenants.remove(tenantId);
        }
    }

    /**
     * 清空全部租户缓存。
     */
    public void clear() {
        cachedTenants.clear();
        tenantLocks.clear();
    }

    /**
     * 返回当前本地缓存租户数量。
     *
     * @return 缓存租户数量
     */
    public int size() {
        return cachedTenants.size();
    }

    /**
     * 从外部加载器重新加载租户配置，并同步更新本地缓存。
     *
     * @param tenantId 租户标识
     * @return 外部加载器返回的租户配置
     */
    private Optional<MeituanTenantConfig> reload(String tenantId) {
        Optional<MeituanTenantConfig> tenantConfigOptional = tenantConfigLoader.load(tenantId);
        tenantConfigOptional.ifPresent(tenantConfig -> put(tenantId, tenantConfig));
        if (tenantConfigOptional.isEmpty()) {
            cachedTenants.remove(tenantId);
        }
        return tenantConfigOptional;
    }

    /**
     * 在租户级互斥锁内重新加载租户配置。
     *
     * @param tenantId 租户标识
     * @return 可用的租户配置
     */
    private Optional<MeituanTenantConfig> reloadWithTenantLock(String tenantId) {
        Object tenantLock = tenantLocks.computeIfAbsent(tenantId, key -> new Object());
        synchronized (tenantLock) {
            try {
                CacheEntry cacheEntry = cachedTenants.get(tenantId);
                if (Objects.nonNull(cacheEntry) && !cacheEntry.isExpired(now(), timeToLive)) {
                    return Optional.of(cacheEntry.getTenantConfig());
                }
                return reload(tenantId);
            } finally {
                tenantLocks.remove(tenantId, tenantLock);
            }
        }
    }

    /**
     * 获取当前时间戳。
     *
     * @return 当前毫秒时间戳
     */
    private long now() {
        return clock.millis();
    }

    /**
     * 单个租户配置缓存项。
     */
    private static class CacheEntry {

        /**
         * 租户授权配置。
         */
        private final MeituanTenantConfig tenantConfig;

        /**
         * 缓存写入时间戳。
         */
        private final long cachedAt;

        /**
         * 创建缓存项。
         *
         * @param tenantConfig 租户授权配置
         * @param cachedAt     缓存写入时间戳
         */
        private CacheEntry(MeituanTenantConfig tenantConfig, long cachedAt) {
            this.tenantConfig = tenantConfig;
            this.cachedAt = cachedAt;
        }

        /**
         * 获取租户授权配置。
         *
         * @return 租户授权配置
         */
        private MeituanTenantConfig getTenantConfig() {
            return tenantConfig;
        }

        /**
         * 判断缓存项是否已经过期。
         *
         * @param now        当前毫秒时间戳
         * @param timeToLive 缓存有效期
         * @return true 表示已过期，false 表示仍可使用
         */
        private boolean isExpired(long now, Duration timeToLive) {
            if (Objects.isNull(timeToLive) || timeToLive.isZero() || timeToLive.isNegative()) {
                return false;
            }
            return cachedAt + timeToLive.toMillis() < now;
        }
    }
}
