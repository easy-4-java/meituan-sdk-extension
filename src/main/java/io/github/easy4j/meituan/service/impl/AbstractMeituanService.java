package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanService;

/**
 * 业务 service 默认基类。
 * <p>具体业务实现类只负责暴露强类型方法，真正的租户选择、异常包装和官方 SDK 调用统一交给
 * {@link MeituanRequestExecutor}。</p>
 */
public abstract class AbstractMeituanService implements MeituanService {

    /**
     * 多租户请求执行器。
     */
    private final MeituanRequestExecutor requestExecutor;

    /**
     * 创建业务 service 基类。
     *
     * @param requestExecutor 多租户请求执行器
     */
    protected AbstractMeituanService(MeituanRequestExecutor requestExecutor) {
        this.requestExecutor = requestExecutor;
    }

    /**
     * 委托请求执行器按租户授权执行请求。
     */
    @Override
    public <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId) {
        return requestExecutor.execute(request, tenantId);
    }

    /**
     * 委托请求执行器执行不需要授权 token 的请求。
     */
    @Override
    public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request) {
        return requestExecutor.executeWithoutAuth(request);
    }

    /**
     * 使用指定租户的开发者凭据执行不需要 appAuthToken 的请求。
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择开发者凭据
     * @param <T>      官方 SDK response data 类型
     * @return 官方 SDK 响应对象
     */
    protected <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request, String tenantId) {
        return requestExecutor.executeWithoutAuth(request, tenantId);
    }
}
