package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.rhone.mtp.orderConsumeNotice.OrderConsumeNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.orderPayNotice.OrderPayNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.orderRefundNotice.OrderRefundNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.orderRescheduleNotice.OrderRescheduleNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.productLevelPriceNoticeV2.ProductLevelPriceNoticeV2Request;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanDistributionService;

/**
 * 站外分销默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanDistributionServiceImpl extends AbstractMeituanService implements MeituanDistributionService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanDistributionServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderConsumeNotice(OrderConsumeNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderPayNotice(OrderPayNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderRefundNotice(OrderRefundNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderRescheduleNotice(OrderRescheduleNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productLevelPriceNoticeV2(ProductLevelPriceNoticeV2Request request, String tenantId) {
        return execute(request, tenantId);
    }
}
