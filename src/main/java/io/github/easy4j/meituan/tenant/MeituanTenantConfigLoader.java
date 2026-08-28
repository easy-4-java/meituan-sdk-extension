package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;

import java.util.Optional;

/**
 * 租户配置外部加载器。
 * <p>业务系统可以用该接口对接数据库、Redis、Nacos 或内部配置中心，SDK 只负责调用该加载器并缓存结果。</p>
 */
@FunctionalInterface
public interface MeituanTenantConfigLoader {

    /**
     * 从外部存储加载租户配置。
     *
     * @param tenantId 租户标识
     * @return 存在则返回租户配置，否则返回空
     */
    Optional<MeituanTenantConfig> load(String tenantId);
}
