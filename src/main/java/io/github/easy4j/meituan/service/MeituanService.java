package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;

/**
 * 所有美团业务 service 的基础接口。
 * <p>提供通用执行入口，业务专用 service 会在此基础上暴露按官方 API 命名的强类型方法。</p>
 */
public interface MeituanService {

    /**
     * 使用指定租户授权执行官方请求。
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
