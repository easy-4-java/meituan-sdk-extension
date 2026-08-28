package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * 基于内存 Map 的租户配置存储。
 * <p>适用于配置文件静态加载场景；如果后续要接数据库、Nacos 或配置中心，可实现
 * {@link MeituanTenantConfigStorage} 替换该实现。</p>
 */
public class InMemoryMeituanTenantConfigStorage implements MeituanTenantConfigStorage {

    /**
     * 租户配置 Map。
     */
    private final Map<String, MeituanTenantConfig> tenants = new LinkedHashMap<>();

    /**
     * 创建空的内存租户配置存储。
     */
    public InMemoryMeituanTenantConfigStorage() {
    }

    /**
     * 基于已有租户配置创建内存租户配置存储。
     *
     * @param tenants 初始租户配置 Map
     */
    public InMemoryMeituanTenantConfigStorage(Map<String, MeituanTenantConfig> tenants) {
        if (Objects.nonNull(tenants)) {
            tenants.forEach(this::addTenant);
        }
    }

    /**
     * 添加或覆盖租户配置。
     *
     * @param tenantId     租户标识
     * @param tenantConfig 租户授权配置
     */
    public void addTenant(String tenantId, MeituanTenantConfig tenantConfig) {
        if (Objects.isNull(tenantConfig)) {
            return;
        }
        tenantConfig.setTenantId(tenantId);
        this.tenants.put(tenantId, tenantConfig);
    }

    /**
     * 按租户标识查找授权配置。
     *
     * @param tenantId 租户标识
     * @return 存在则返回租户配置，否则返回空
     */
    @Override
    public Optional<MeituanTenantConfig> findByTenantId(String tenantId) {
        return Optional.ofNullable(this.tenants.get(tenantId));
    }

    /**
     * 返回只读租户配置视图，避免外部绕过 {@link #addTenant(String, MeituanTenantConfig)} 直接修改内部状态。
     *
     * @return 只读租户配置 Map
     */
    public Map<String, MeituanTenantConfig> getTenants() {
        return Collections.unmodifiableMap(tenants);
    }
}
