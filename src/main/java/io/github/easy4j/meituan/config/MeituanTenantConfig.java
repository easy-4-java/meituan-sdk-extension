package io.github.easy4j.meituan.config;

import lombok.Data;

/**
 * 租户级美团授权配置。
 * <p>一个租户通常对应一个美团应用授权，业务 service 调用时通过 tenantId 选择这里的应用密钥和 appAuthToken。</p>
 */
@Data
public class MeituanTenantConfig {

    /**
     * 业务侧租户标识。
     */
    private String tenantId;

    /**
     * 美团应用 ID。
     */
    private String appId;

    /**
     * 美团开放平台开发者 ID。
     */
    private Long developerId;

    /**
     * 美团开放平台签名密钥。
     */
    private String signKey;

    /**
     * 美团应用授权 token。
     */
    private String appAuthToken;

    /**
     * 美团业务线 ID。
     */
    private Integer businessId;

}
