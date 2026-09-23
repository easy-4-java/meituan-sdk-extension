package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import io.github.easy4j.meituan.model.freetry.FreetryLoadActivityRestrictionRequest;
import io.github.easy4j.meituan.model.freetry.FreetryLoadActivityRestrictionResponse;
import io.github.easy4j.meituan.model.freetry.FreetryLoadCouponRequest;
import io.github.easy4j.meituan.model.freetry.FreetryLoadCouponResponse;
import io.github.easy4j.meituan.model.freetry.FreetryPrepareVerifyRequest;
import io.github.easy4j.meituan.model.freetry.FreetryPrepareVerifyResponse;
import io.github.easy4j.meituan.model.freetry.FreetryQueryActivitiesByPoiRequest;
import io.github.easy4j.meituan.model.freetry.FreetryQueryActivitiesByPoiResponse;
import io.github.easy4j.meituan.model.freetry.FreetryQueryPoiCouponRequest;
import io.github.easy4j.meituan.model.freetry.FreetryQueryPoiCouponResponse;
import io.github.easy4j.meituan.model.freetry.FreetryVerifyCouponRequest;
import io.github.easy4j.meituan.model.freetry.FreetryVerifyCouponResponse;

/**
 * 免费试业务能力门面。
 * <p>官方 MtOpJavaSDK 当前未包含免费试模型，因此由扩展 SDK 提供兼容
 * {@code MeituanRequest} 的强类型请求，并负责按租户执行授权调用。</p>
 */
public interface MeituanFreetryService extends MeituanService {

    /**
     * 查询活动限制。
     *
     * @param request 查询请求
     * @param tenantId 租户标识
     * @return 官方 SDK 响应
     */
    default MeituanResponse<FreetryLoadActivityRestrictionResponse> loadActivityRestriction(
            FreetryLoadActivityRestrictionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 查询已验券码。
     *
     * @param request 查询请求
     * @param tenantId 租户标识
     * @return 官方 SDK 响应
     */
    default MeituanResponse<FreetryLoadCouponResponse> loadCoupon(
            FreetryLoadCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 查询门店验券历史。
     *
     * @param request 查询请求
     * @param tenantId 租户标识
     * @return 官方 SDK 响应
     */
    default MeituanResponse<FreetryQueryPoiCouponResponse> queryPoiCoupon(
            FreetryQueryPoiCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 执行验券。
     *
     * @param request 验券请求
     * @param tenantId 租户标识
     * @return 官方 SDK 响应
     */
    default MeituanResponse<FreetryVerifyCouponResponse> verifyCoupon(
            FreetryVerifyCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 查询门店活动映射。
     *
     * @param request 查询请求
     * @param tenantId 租户标识
     * @return 官方 SDK 响应
     */
    default MeituanResponse<FreetryQueryActivitiesByPoiResponse> queryActivitiesByPoi(
            FreetryQueryActivitiesByPoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 获取验券准备信息。
     *
     * @param request 验券准备请求
     * @param tenantId 租户标识
     * @return 官方 SDK 响应
     */
    default MeituanResponse<FreetryPrepareVerifyResponse> prepareVerify(
            FreetryPrepareVerifyRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
