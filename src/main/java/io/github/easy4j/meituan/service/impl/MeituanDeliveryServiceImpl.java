package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiBizDeliveryRuleFeeUpdate.GroupDeliveryPoiBizDeliveryRuleFeeUpdateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiBizDeliveryRuleRangeUpdate.GroupDeliveryPoiBizDeliveryRuleRangeUpdateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDealQuery.GroupDeliveryPoiDealQueryRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleBaseUpdate.GroupDeliveryPoiDeliveryRuleBaseUpdateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleChangeQuery.GroupDeliveryPoiDeliveryRuleChangeQueryRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleCreate.GroupDeliveryPoiDeliveryRuleCreateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleFeeDiscountUpdate.GroupDeliveryPoiDeliveryRuleFeeDiscountUpdateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleQuery.GroupDeliveryPoiDeliveryRuleQueryRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleRangeUpdate.GroupDeliveryPoiDeliveryRuleRangeUpdateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleReservationUpdate.GroupDeliveryPoiDeliveryRuleReservationUpdateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiDeliveryRuleTypeUpdate.GroupDeliveryPoiDeliveryRuleTypeUpdateRequest;
import com.meituan.sdk.model.dcps.fulfill.groupDeliveryPoiService.GroupDeliveryPoiServiceRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyAgreeRefund.GroupbuyAgreeRefundRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyCancelOrder.GroupbuyCancelOrderRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyDeliveryChangeStatus.GroupbuyDeliveryChangeStatusRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyDeliveryFinish.GroupbuyDeliveryFinishRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyFillTrackNumber.GroupbuyFillTrackNumberRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyMealCallRider.GroupbuyMealCallRiderRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyOrderDetail.GroupbuyOrderDetailRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyOrderLogs.GroupbuyOrderLogsRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyReceiveOrder.GroupbuyReceiveOrderRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyRejectReceiveOrder.GroupbuyRejectReceiveOrderRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuyRejectRefund.GroupbuyRejectRefundRequest;
import com.meituan.sdk.model.dcps.fulfill.groupbuySelfDelivery.GroupbuySelfDeliveryRequest;
import com.meituan.sdk.model.dcps.print.updatePrinterStatus.UpdatePrinterStatusRequest;
import com.meituan.sdk.model.dcps.settlement.querySettleResult.QuerySettleResultRequest;
import com.meituan.sdk.model.peisong.order.cancelOrder.CancelOrderRequest;
import com.meituan.sdk.model.peisong.order.check.CheckRequest;
import com.meituan.sdk.model.peisong.order.createByCoordinates.CreateByCoordinatesRequest;
import com.meituan.sdk.model.peisong.order.createByShop.CreateByShopRequest;
import com.meituan.sdk.model.peisong.order.evaluate.EvaluateRequest;
import com.meituan.sdk.model.peisong.order.h5url.H5urlRequest;
import com.meituan.sdk.model.peisong.order.mealCodeSave.MealCodeSaveRequest;
import com.meituan.sdk.model.peisong.order.orderAddTip.OrderAddTipRequest;
import com.meituan.sdk.model.peisong.order.orderModify.OrderModifyRequest;
import com.meituan.sdk.model.peisong.order.preCreateByShop.PreCreateByShopRequest;
import com.meituan.sdk.model.peisong.order.queryOrderStatus.QueryOrderStatusRequest;
import com.meituan.sdk.model.peisong.order.riderLocation.RiderLocationRequest;
import com.meituan.sdk.model.peisong.shop.areaQuery.AreaQueryRequest;
import com.meituan.sdk.model.peisong.shop.createShop.CreateShopRequest;
import com.meituan.sdk.model.peisong.shop.queryShop.QueryShopRequest;
import com.meituan.sdk.model.peisong.shop.updateShop.UpdateShopRequest;
import com.meituan.sdk.model.peisong.test.orderArrange.OrderArrangeRequest;
import com.meituan.sdk.model.peisong.test.orderDeliver.OrderDeliverRequest;
import com.meituan.sdk.model.peisong.test.orderPickup.OrderPickupRequest;
import com.meituan.sdk.model.peisong.test.orderRearrange.OrderRearrangeRequest;
import com.meituan.sdk.model.peisong.test.orderReportException.OrderReportExceptionRequest;
import com.meituan.sdk.model.peisong.test.shopAreaCallback.ShopAreaCallbackRequest;
import com.meituan.sdk.model.peisong.test.shopDeliveryRiskLevelCallback.ShopDeliveryRiskLevelCallbackRequest;
import com.meituan.sdk.model.peisong.test.shopStatusCallback.ShopStatusCallbackRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanDeliveryService;

/**
 * 配送服务默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanDeliveryServiceImpl extends AbstractMeituanService implements MeituanDeliveryService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanDeliveryServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
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
    public MeituanResponse<?> check(CheckRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createByCoordinates(CreateByCoordinatesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createByShop(CreateByShopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> evaluate(EvaluateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> h5url(H5urlRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> mealCodeSave(MealCodeSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderAddTip(OrderAddTipRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderModify(OrderModifyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> preCreateByShop(PreCreateByShopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryOrderStatus(QueryOrderStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> riderLocation(RiderLocationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> areaQuery(AreaQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createShop(CreateShopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryShop(QueryShopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateShop(UpdateShopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderArrange(OrderArrangeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderDeliver(OrderDeliverRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderPickup(OrderPickupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderRearrange(OrderRearrangeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderReportException(OrderReportExceptionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopAreaCallback(ShopAreaCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopDeliveryRiskLevelCallback(ShopDeliveryRiskLevelCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopStatusCallback(ShopStatusCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiBizDeliveryRuleFeeUpdate(GroupDeliveryPoiBizDeliveryRuleFeeUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiBizDeliveryRuleRangeUpdate(GroupDeliveryPoiBizDeliveryRuleRangeUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDealQuery(GroupDeliveryPoiDealQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleBaseUpdate(GroupDeliveryPoiDeliveryRuleBaseUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleChangeQuery(GroupDeliveryPoiDeliveryRuleChangeQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleCreate(GroupDeliveryPoiDeliveryRuleCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleFeeDiscountUpdate(GroupDeliveryPoiDeliveryRuleFeeDiscountUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleQuery(GroupDeliveryPoiDeliveryRuleQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleRangeUpdate(GroupDeliveryPoiDeliveryRuleRangeUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleReservationUpdate(GroupDeliveryPoiDeliveryRuleReservationUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiDeliveryRuleTypeUpdate(GroupDeliveryPoiDeliveryRuleTypeUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupDeliveryPoiService(GroupDeliveryPoiServiceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyAgreeRefund(GroupbuyAgreeRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyCancelOrder(GroupbuyCancelOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyDeliveryChangeStatus(GroupbuyDeliveryChangeStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyDeliveryFinish(GroupbuyDeliveryFinishRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyFillTrackNumber(GroupbuyFillTrackNumberRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyMealCallRider(GroupbuyMealCallRiderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyOrderDetail(GroupbuyOrderDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyOrderLogs(GroupbuyOrderLogsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyReceiveOrder(GroupbuyReceiveOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyRejectReceiveOrder(GroupbuyRejectReceiveOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuyRejectRefund(GroupbuyRejectRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupbuySelfDelivery(GroupbuySelfDeliveryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updatePrinterStatus(UpdatePrinterStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> querySettleResult(QuerySettleResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
