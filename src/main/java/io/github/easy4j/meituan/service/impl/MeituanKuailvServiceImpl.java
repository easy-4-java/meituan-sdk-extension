package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.klOpen.goods.goodsPageSku.GoodsPageSkuRequest;
import com.meituan.sdk.model.klOpen.goods.goodsPageSpu.GoodsPageSpuRequest;
import com.meituan.sdk.model.klOpen.goods.queryGoodsSales.QueryGoodsSalesRequest;
import com.meituan.sdk.model.klOpen.order.cancelOrder.CancelOrderRequest;
import com.meituan.sdk.model.klOpen.order.createOrderSync.CreateOrderSyncRequest;
import com.meituan.sdk.model.klOpen.order.orderCreate.OrderCreateRequest;
import com.meituan.sdk.model.klOpen.order.orderDetail.OrderDetailRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanKuailvService;

/**
 * 快驴默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanKuailvServiceImpl extends AbstractMeituanService implements MeituanKuailvService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanKuailvServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> goodsPageSku(GoodsPageSkuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> goodsPageSpu(GoodsPageSpuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryGoodsSales(QueryGoodsSalesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cancelOrder(CancelOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createOrderSync(CreateOrderSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderCreate(OrderCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderDetail(OrderDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
