package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CachedMeituanTenantConfigStorage 的缓存、TTL、主动刷新与并发防击穿测试。
 */
class CachedMeituanTenantConfigStorageTest {

    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT = "tenant-a";
    /**
     * 底层租户配置被实际加载的次数。
     */
    private final AtomicInteger loadCount = new AtomicInteger();

    /**
     * 创建CachedMeituanTenantConfigStorage 的缓存、TTL、主动刷新与并发防击穿测试。的空实例。
     */
    CachedMeituanTenantConfigStorageTest() {
    }

    /**
     * 创建带指定授权 token 的测试租户配置。
     *
     * @param token 测试配置中的授权 token
     * @return 创建带指定授权 token 的测试租户配置的结果
     */
    private MeituanTenantConfig newConfig(String token) {
        MeituanTenantConfig config = new MeituanTenantConfig();
        config.setTenantId(TENANT);
        config.setAppAuthToken(token);
        return config;
    }

    /**
     * 创建记录实际加载次数的租户配置加载器。
     *
     * @return 创建记录实际加载次数的租户配置加载器的结果
     */
    private MeituanTenantConfigLoader countingLoader() {
        return tenantId -> {
            loadCount.incrementAndGet();
            return Optional.of(newConfig("token-" + loadCount.get()));
        };
    }

    /**
     * 初始化租户缓存及加载次数，隔离各测试场景。
     */
    @BeforeEach
    void setUp() {
        loadCount.set(0);
    }

    /**
     * 验证有效缓存中的配置被复用且不会重复加载。
     */
    @Test
    void shouldCacheAfterFirstLoadAndNotReloadWhileFresh() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ofMinutes(5));
        Optional<MeituanTenantConfig> first = storage.findByTenantId(TENANT);
        Optional<MeituanTenantConfig> second = storage.findByTenantId(TENANT);
        assertTrue(first.isPresent());
        assertSame(first.get(), second.get());
        assertEquals(1, loadCount.get(), "缓存命中不应重复加载");
        assertEquals(1, storage.size());
    }

    /**
     * 验证缓存超过存活时间后重新加载配置。
     */
    @Test
    void shouldReloadAfterTtlExpires() {
        // 用可控时钟模拟过期
        final long[] now = {1000L};
        Clock clock = Clock.fixed(java.time.Instant.EPOCH, java.time.ZoneId.systemDefault());
        Clock mutableClock = new Clock() {
            /**
             * {@inheritDoc}
             */
            @Override
            public java.time.ZoneId getZone() {
                return clock.getZone();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Clock withZone(java.time.ZoneId zone) {
                return this;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public long millis() {
                return now[0];
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public java.time.Instant instant() {
                return java.time.Instant.ofEpochMilli(now[0]);
            }
        };
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ofMinutes(5), mutableClock);
        storage.findByTenantId(TENANT);
        now[0] += Duration.ofMinutes(6).toMillis();
        Optional<MeituanTenantConfig> after = storage.findByTenantId(TENANT);
        assertTrue(after.isPresent());
        assertEquals(2, loadCount.get(), "TTL 过期后应重新加载");
        assertEquals("token-2", after.get().getAppAuthToken());
    }

    /**
     * 验证零存活时间表示缓存长期有效。
     */
    @Test
    void zeroTtlMeansNeverExpire() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ZERO);
        storage.findByTenantId(TENANT);
        storage.findByTenantId(TENANT);
        assertEquals(1, loadCount.get());
    }

    /**
     * 验证主动写入覆盖旧配置，刷新操作重新调用加载器。
     */
    @Test
    void putShouldOverwriteCacheAndRefreshShouldReload() {
        AtomicInteger count = new AtomicInteger();
        MeituanTenantConfigLoader loader = tenantId -> {
            count.incrementAndGet();
            return Optional.of(newConfig("loaded-" + count.get()));
        };
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(loader, Duration.ofMinutes(10));

        storage.put(TENANT, newConfig("manual-token"));
        assertEquals("manual-token", storage.findByTenantId(TENANT).get().getAppAuthToken());

        storage.refresh(TENANT);
        assertEquals("loaded-1", storage.findByTenantId(TENANT).get().getAppAuthToken());
    }

    /**
     * 验证单租户驱逐和全部清理均使缓存失效。
     */
    @Test
    void evictAndClearShouldInvalidateCache() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ZERO);
        storage.findByTenantId(TENANT);
        storage.evict(TENANT);
        assertEquals(0, storage.size());
        storage.findByTenantId(TENANT);
        assertEquals(2, loadCount.get());
        storage.clear();
        assertEquals(0, storage.size());
    }

    /**
     * 验证空白租户标识不会触发配置加载。
     */
    @Test
    void shouldReturnEmptyForBlankTenantId() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader());
        assertFalse(storage.findByTenantId("").isPresent());
        assertFalse(storage.findByTenantId(null).isPresent());
        assertEquals(0, loadCount.get());
    }

    /**
     * 验证同一租户并发缓存未命中时仅加载一次。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void concurrentMissShouldLoadOncePerTenant() throws Exception {
        // 慢加载器：放大并发窗口，验证租户级互斥锁防击穿
        List<String> calls = new ArrayList<>();
        MeituanTenantConfigLoader slowLoader = tenantId -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return Optional.of(newConfig("token-once"));
        };
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(slowLoader, Duration.ofMinutes(10));

        int threads = 8;
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        CountDownLatch start = new CountDownLatch(1);
        List<java.util.concurrent.Future<Optional<MeituanTenantConfig>>> futures = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            futures.add(pool.submit(() -> {
                start.await();
                return storage.findByTenantId(TENANT);
            }));
        }
        start.countDown();
        pool.shutdown();
        assertTrue(pool.awaitTermination(10, TimeUnit.SECONDS));

        // 并发后只能有一个实例（锁内双检保证同一实例被复用）
        MeituanTenantConfig first = futures.get(0).get().orElse(null);
        assertTrue(first != null);
        for (int i = 1; i < threads; i++) {
            MeituanTenantConfig other = futures.get(i).get().orElse(null);
            assertSame(first, other, "并发加载应复用同一实例");
        }
        assertEquals("token-once", first.getAppAuthToken());
    }

    /**
     * 验证不存在的租户返回空结果且不写入缓存。
     */
    @Test
    void missingTenantShouldReturnEmptyAndNotCache() {
        MeituanTenantConfigLoader loader = tenantId -> Optional.empty();
        CachedMeituanTenantConfigStorage storage = new CachedMeituanTenantConfigStorage(loader);
        assertFalse(storage.findByTenantId("no-such").isPresent());
        assertEquals(0, storage.size());
    }
}
