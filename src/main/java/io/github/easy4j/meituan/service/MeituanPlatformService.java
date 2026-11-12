package io.github.easy4j.meituan.service;

import com.meituan.sdk.CommonRequest;
import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.auth.MeituanTokenResponse;
import com.meituan.sdk.internal.exceptions.MtSdkException;
import io.github.easy4j.meituan.client.MeituanClientFactory;
import io.github.easy4j.meituan.config.MeituanTenantConfig;
import io.github.easy4j.meituan.exception.MeituanJavaException;
import io.github.easy4j.meituan.tenant.MeituanTenantConfigStorage;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * 按租户调用官方客户端的 OAuth、统一授权、通用请求及自定义超时接口。
 */
public final class MeituanPlatformService {

    private final MeituanClientFactory clientFactory;
    private final MeituanTenantConfigStorage tenantStorage;

    /**
     * 创建平台服务。
     * @param clientFactory 按租户开发者凭据创建官方客户端的工厂
     * @param tenantStorage 租户授权配置来源
     */
    public MeituanPlatformService(MeituanClientFactory clientFactory, MeituanTenantConfigStorage tenantStorage) {
        this.clientFactory = Objects.requireNonNull(clientFactory);
        this.tenantStorage = Objects.requireNonNull(tenantStorage);
    }

    /**
     * 用授权码换取 token，由调用方保存响应中的授权信息。
     * @param businessId 官方业务编号
     * @param code 美团授权码
     * @param tenantId 开发者所属租户
     * @return 官方授权响应
     */
    public MeituanTokenResponse getOAuthToken(Integer businessId, String code, String tenantId) {
        return invoke(tenantId, (client, config) -> client.getOAuthToken(businessId, code));
    }

    /**
     * 使用刷新凭证换取新的 token，由调用方保存新的凭证。
     * @param businessId 官方业务编号
     * @param refreshToken 上次授权返回的刷新凭证
     * @param tenantId 开发者所属租户
     * @return 官方刷新响应
     */
    public MeituanTokenResponse refreshToken(Integer businessId, String refreshToken, String tenantId) {
        return invoke(tenantId, (client, config) -> client.refreshToken(businessId, refreshToken));
    }

    /**
     * 使用租户 token 执行统一授权请求。
     * @param request 官方请求
     * @param tenantId 开发者所属租户
     * @param realOpBizCode 本次操作的授权实体 ID
     * @param <T> 响应数据类型
     * @return 官方响应
     */
    public <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId, String realOpBizCode) {
        return invoke(tenantId, (client, config) -> client.invokeApi(request, config.getAppAuthToken(), realOpBizCode));
    }

    /**
     * 使用租户 token 和本次调用的超时设置执行请求。
     * @param request 官方请求
     * @param tenantId 开发者所属租户
     * @param connectTimeout 连接超时（毫秒），null 沿用客户端配置
     * @param readTimeout 读取超时（毫秒），null 沿用客户端配置
     * @param <T> 响应数据类型
     * @return 官方响应
     */
    public <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId,
                                          Integer connectTimeout, Integer readTimeout) {
        return invoke(tenantId, (client, config) ->
                client.invokeApi(request, config.getAppAuthToken(), connectTimeout, readTimeout));
    }

    /**
     * 使用开发者凭据和本次调用的超时设置执行免 token 请求。
     * @param request 官方请求
     * @param tenantId 开发者所属租户
     * @param connectTimeout 连接超时（毫秒），null 沿用客户端配置
     * @param readTimeout 读取超时（毫秒），null 沿用客户端配置
     * @param <T> 响应数据类型
     * @return 官方响应
     */
    public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request, String tenantId,
                                                     Integer connectTimeout, Integer readTimeout) {
        return invoke(tenantId, (client, config) -> client.invokeApi(request, connectTimeout, readTimeout));
    }

    /**
     * 使用租户开发者凭据执行通用请求，授权 token 和实体 ID 按原请求发送。
     * @param request 官方通用请求，由调用方按接口要求填写授权字段
     * @param responseType 完整的 MeituanResponse 泛型类型
     * @param tenantId 开发者所属租户
     * @param <T> 响应数据类型
     * @return 官方响应
     */
    public <T> MeituanResponse<T> commonInvokeApi(CommonRequest request, Type responseType, String tenantId) {
        return invoke(tenantId, (client, config) -> client.commonInvokeApi(request, responseType));
    }

    private <R> R invoke(String tenantId, ClientCall<R> call) {
        MeituanTenantConfig config = tenantStorage.findByTenantId(tenantId)
                .orElseThrow(() -> new MeituanJavaException("Meituan tenant config not found: " + tenantId));
        // 官方客户端会修改实例的超时设置，按次创建以隔离同一租户的并发调用。
        MeituanClient client = clientFactory.create(config);
        try {
            return call.invoke(client, config);
        } catch (MtSdkException e) {
            throw new MeituanJavaException("Meituan platform request failed for tenant: " + tenantId
                    + ", code=" + e.getErrCode() + ", msg=" + e.getErrMsg(), e);
        }
    }

    @FunctionalInterface
    private interface ClientCall<R> {
        R invoke(MeituanClient client, MeituanTenantConfig config) throws MtSdkException;
    }
}
