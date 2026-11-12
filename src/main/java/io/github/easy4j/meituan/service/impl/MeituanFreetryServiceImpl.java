package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.model.freetry.*;
import io.github.easy4j.meituan.service.MeituanFreetryService;

/**
 * 免费试默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanFreetryServiceImpl extends AbstractMeituanService implements MeituanFreetryService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanFreetryServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<FreetryLoadActivityRestrictionResponse> loadActivityRestriction(FreetryLoadActivityRestrictionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<FreetryLoadCouponResponse> loadCoupon(FreetryLoadCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<FreetryQueryPoiCouponResponse> queryPoiCoupon(FreetryQueryPoiCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<FreetryVerifyCouponResponse> verifyCoupon(FreetryVerifyCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<FreetryQueryActivitiesByPoiResponse> queryActivitiesByPoi(FreetryQueryActivitiesByPoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<FreetryPrepareVerifyResponse> prepareVerify(FreetryPrepareVerifyRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
