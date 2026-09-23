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

    /**
     * 使用指定租户的开发者凭据执行不需要 appAuthToken 的官方请求。
     * <p>为避免静默忽略 tenantId 并误用其他租户凭据，默认实现采用 fail-closed 策略；
     * 自定义执行器必须覆盖本方法并按 tenantId 选择对应的开发者凭据。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择开发者凭据
     * @param <T>      官方 SDK response data 类型
     * @return 官方 SDK 响应对象
     */
    default <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request, String tenantId) {
        throw new UnsupportedOperationException(
                "Tenant-aware executeWithoutAuth must be implemented by custom executors"
        );
    }
}
