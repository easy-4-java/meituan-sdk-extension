package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;

import java.util.Optional;

/**
 * 租户授权配置存储抽象。
 * <p>SDK 通过该接口解耦租户配置来源，默认实现来自配置文件，业务系统也可以替换为数据库或配置中心实现。</p>
 */
public interface MeituanTenantConfigStorage {

    /**
     * 按租户标识查找美团授权配置。
     *
     * @param tenantId 租户标识
     * @return 存在则返回租户配置，否则返回空
     */
    Optional<MeituanTenantConfig> findByTenantId(String tenantId);
}
