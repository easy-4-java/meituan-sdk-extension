package io.github.easy4j.meituan.client;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;

/**
 * 美团请求执行器抽象。
 * <p>业务 service 只依赖该接口，方便后续替换租户存储、调用链追踪、重试或限流逻辑。</p>
 */
public interface MeituanRequestExecutor {

    /**
     * 使用租户授权执行需要 appAuthToken 的官方请求。
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识
     * @param <T>      官方 SDK response data 类型
     * @return 官方 SDK 响应对象
     */
    <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId);

    /**
     * 执行不需要租户授权 token 的官方请求。
     *
     * @param request 官方 MtOpJavaSDK 请求对象
     * @param <T>     官方 SDK response data 类型
     * @return 官方 SDK 响应对象
     */
    <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request);
}
