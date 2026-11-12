package io.github.easy4j.meituan.config;

import lombok.Data;

/**
 * 美团开放平台共享配置。
 * <p>这里只保存服务地址、协议、超时等所有租户共享的客户端默认值；
 * {@code developerId}、{@code signKey}、{@code appAuthToken} 等应用密钥由 {@link MeituanTenantConfig} 管理。</p>
 */
@Data
public class MeituanConfig {

    /**
     * 创建\u7f8e\u56e2\u5f00\u653e\u5e73\u53f0\u5171\u4eab\u914d\u7f6e\u3002的空实例。
     */
    public MeituanConfig() {
    }


    /**
     * 默认美团开放平台服务地址。
     */
    private static final String DEFAULT_SERVER_URL = "https://api-open-cater.meituan.com";

    /**
     * 默认请求字符集。
     */
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 默认接口协议版本号。
     */
    private static final String DEFAULT_VERSION = "2";

    /**
     * 美团开放平台服务地址。
     */
    private String serverUrl = DEFAULT_SERVER_URL;

    /**
     * 请求字符集。
     */
    private String charset = DEFAULT_CHARSET;

    /**
     * 接口协议版本号。
     */
    private String version = DEFAULT_VERSION;

    /**
     * 连接超时时间，单位毫秒。
     */
    private Integer connectTimeout;

    /**
     * 读取超时时间，单位毫秒。
     */
    private Integer readTimeout;

    /**
     * 是否启用 SSL 证书校验。
     */
    private Boolean needSslCheck;

}
