package io.github.easy4j.meituan.client;

import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.internal.exceptions.MtSdkException;
import io.github.easy4j.meituan.config.MeituanTenantConfig;
import io.github.easy4j.meituan.exception.MeituanJavaException;
import io.github.easy4j.meituan.tenant.MeituanTenantConfigStorage;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认请求执行器。
 * <p>该类是 SDK 多租户能力的核心入口：调用方只传入官方 {@link MeituanRequest}
 * 和业务租户标识，执行器负责找到租户应用密钥与授权 token，再委托官方 {@link MeituanClient} 发起请求。</p>
 */
public class DefaultMeituanRequestExecutor implements MeituanRequestExecutor {

    /**
     * 官方 MtOpJavaSDK client 工厂。
     */
    private final MeituanClientFactory meituanClientFactory;

    /**
     * 兼容单 client 注入场景的默认 client。
     */
    private final MeituanClient defaultMeituanClient;

    /**
     * 租户授权配置存储。
     */
    private final MeituanTenantConfigStorage tenantConfigStorage;

    /**
     * 按租户应用密钥缓存官方 client。
     */
    private final Map<String, MeituanClient> tenantClients = new ConcurrentHashMap<>();

    /**
     * 创建默认请求执行器。
     *
     * @param meituanClientFactory 官方 MtOpJavaSDK client 工厂
     * @param tenantConfigStorage 租户授权配置存储
     */
    public DefaultMeituanRequestExecutor(MeituanClientFactory meituanClientFactory, MeituanTenantConfigStorage tenantConfigStorage) {
        this.meituanClientFactory = Objects.requireNonNull(meituanClientFactory, "meituanClientFactory must not be null");
        this.defaultMeituanClient = null;
        this.tenantConfigStorage = Objects.requireNonNull(tenantConfigStorage, "tenantConfigStorage must not be null");
    }

    /**
     * 创建固定 client 的请求执行器，保留给单应用或测试场景使用。
     *
     * @param meituanClient       官方 MtOpJavaSDK client
     * @param tenantConfigStorage 租户授权配置存储
     */
    public DefaultMeituanRequestExecutor(MeituanClient meituanClient, MeituanTenantConfigStorage tenantConfigStorage) {
        this.meituanClientFactory = null;
        this.defaultMeituanClient = Objects.requireNonNull(meituanClient, "meituanClient must not be null");
        this.tenantConfigStorage = Objects.requireNonNull(tenantConfigStorage, "tenantConfigStorage must not be null");
    }

    /**
     * 使用指定租户的应用密钥和 appAuthToken 执行需要授权的美团 OpenAPI。
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于在 {@link MeituanTenantConfigStorage} 中查找授权信息
     * @param <T>      官方 SDK response data 类型
     * @return 官方 SDK 响应对象
     */
    @Override
    public <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId) {
        MeituanTenantConfig tenantConfig = tenantConfigStorage.findByTenantId(tenantId)
                .orElseThrow(() -> new MeituanJavaException("Meituan tenant config not found: " + tenantId));
        try {
            MeituanClient meituanClient = resolveClient(tenantConfig);
            return meituanClient.invokeApi(request, tenantConfig.getAppAuthToken());
        } catch (MtSdkException e) {
            throw new MeituanJavaException(buildRequestFailureMessage(tenantId, e), e);
        }
    }

    /**
     * 执行不需要 appAuthToken 的美团 OpenAPI。
     *
     * @param request 官方 MtOpJavaSDK 请求对象
     * @param <T>     官方 SDK response data 类型
     * @return 官方 SDK 响应对象
     */
    @Override
    public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request) {
        if (Objects.isNull(defaultMeituanClient)) {
            throw new MeituanJavaException("Meituan tenantId is required when no default client is configured");
        }
        try {
            return defaultMeituanClient.invokeApi(request);
        } catch (MtSdkException e) {
            throw new MeituanJavaException("Meituan request failed", e);
        }
    }

    /**
     * 根据租户密钥选择官方 client。
     */
    private MeituanClient resolveClient(MeituanTenantConfig tenantConfig) {
        if (Objects.nonNull(defaultMeituanClient)) {
            return defaultMeituanClient;
        }
        String cacheKey = buildClientCacheKey(tenantConfig);
        return tenantClients.computeIfAbsent(cacheKey, key -> meituanClientFactory.create(tenantConfig));
    }

    /**
     * 构造 client 缓存 key，避免在日志或异常中暴露 signKey 原文。
     */
    private String buildClientCacheKey(MeituanTenantConfig tenantConfig) {
        return tenantConfig.getDeveloperId() + ":" + Integer.toHexString(tenantConfig.getSignKey().hashCode());
    }

    /**
     * 保留官方 SDK 的错误码与错误信息，避免上层只能看到租户标识而无法定位参数、网络或签名问题。
     */
    private String buildRequestFailureMessage(String tenantId, MtSdkException exception) {
        return "Meituan request failed for tenant: " + tenantId
                + ", code=" + exception.getErrCode()
                + ", msg=" + exception.getErrMsg();
    }
}
