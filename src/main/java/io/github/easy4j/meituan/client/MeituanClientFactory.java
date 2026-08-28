package io.github.easy4j.meituan.client;

import com.meituan.sdk.DefaultMeituanClient;
import com.meituan.sdk.MeituanClient;
import io.github.easy4j.meituan.config.MeituanConfig;
import io.github.easy4j.meituan.config.MeituanTenantConfig;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 官方 {@link MeituanClient} 工厂。
 * <p>封装 {@link DefaultMeituanClient.Builder} 的初始化细节。共享配置来自 {@link MeituanConfig}，
 * 开发者 ID 和签名密钥来自每次调用选择出的 {@link MeituanTenantConfig}。</p>
 */
public class MeituanClientFactory {

    /**
     * 共享美团开放平台配置。
     */
    private final MeituanConfig meituanConfig;

    /**
     * 创建官方 client 工厂。
     *
     * @param meituanConfig 共享美团开放平台配置
     */
    public MeituanClientFactory(MeituanConfig meituanConfig) {
        this.meituanConfig = Objects.requireNonNull(meituanConfig, "meituanConfig must not be null");
    }

    /**
     * 根据租户应用密钥和共享配置创建官方 SDK client。
     *
     * @param tenantConfig 租户级应用密钥配置
     * @return 已设置 developerId、signKey、serverUrl 等参数的官方 client
     */
    public MeituanClient create(MeituanTenantConfig tenantConfig) {
        validate(tenantConfig);
        DefaultMeituanClient.Builder builder = getBuilder(tenantConfig);
        if (Objects.nonNull(meituanConfig.getConnectTimeout())) {
            builder.connectTimeout(meituanConfig.getConnectTimeout());
        }
        if (Objects.nonNull(meituanConfig.getReadTimeout())) {
            builder.readTimeout(meituanConfig.getReadTimeout());
        }
        if (Objects.nonNull(meituanConfig.getNeedSslCheck())) {
            builder.needSSLCheck(meituanConfig.getNeedSslCheck());
        }
        return builder.build();
    }

    /**
     * 根据租户必填参数创建官方 client builder。
     *
     * @return 已设置基础平台参数的 builder
     */
    private DefaultMeituanClient.Builder getBuilder(MeituanTenantConfig tenantConfig) {
        DefaultMeituanClient.Builder builder = DefaultMeituanClient.builder(
                tenantConfig.getDeveloperId(),
                tenantConfig.getSignKey()
        );
        if (Objects.nonNull(meituanConfig.getServerUrl())) {
            builder.serverUrl(meituanConfig.getServerUrl());
        }
        if (Objects.nonNull(meituanConfig.getCharset())) {
            builder.charset(meituanConfig.getCharset());
        }
        if (Objects.nonNull(meituanConfig.getVersion())) {
            builder.version(meituanConfig.getVersion());
        }
        return builder;
    }

    /**
     * 校验创建官方 client 所需的租户级密钥。
     */
    private void validate(MeituanTenantConfig tenantConfig) {
        if (Objects.isNull(tenantConfig)) {
            throw new IllegalArgumentException("tenantConfig must not be null");
        }
        if (Objects.isNull(tenantConfig.getDeveloperId())) {
            throw new IllegalArgumentException("developerId must not be null");
        }
        if (!StringUtils.hasText(tenantConfig.getSignKey())) {
            throw new IllegalArgumentException("signKey must not be blank");
        }
    }
}
