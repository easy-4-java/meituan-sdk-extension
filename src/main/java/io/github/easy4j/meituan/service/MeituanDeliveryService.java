package io.github.easy4j.meituan.service;

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

/**
 * 配送服务业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanDeliveryService extends MeituanService {

    /**
     * 取消订单。
     * <p>官方接口：{@code /peisong/order/cancel}，API：{@code cancel_order}，版本：{@code 10004}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cancelOrder(CancelOrderRequest request, String tenantId);

    /**
     * 配送能力校验。
     * <p>官方接口：{@code /peisong/order/check}，API：{@code check}，版本：{@code 10012}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> check(CheckRequest request, String tenantId);

    /**
     * 订单创建(送货分拣方式)。
     * <p>官方接口：{@code /peisong/order/createByCoordinates}，API：{@code create_by_coordinates}，版本：{@code 10007}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createByCoordinates(CreateByCoordinatesRequest request, String tenantId);

    /**
     * 订单创建（门店方式）。
     * <p>官方接口：{@code /peisong/order/createByShop}，API：{@code create_by_shop}，版本：{@code 10023}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createByShop(CreateByShopRequest request, String tenantId);

    /**
     * 评价骑手。
     * <p>官方接口：{@code /peisong/order/evaluate}，API：{@code evaluate}，版本：{@code 10010}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> evaluate(EvaluateRequest request, String tenantId);

    /**
     * 获取骑手位置H5。
     * <p>官方接口：{@code /peisong/order/rider/location/h5url}，API：{@code h5url}，版本：{@code 10021}，businessId：{@code 19}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> h5url(H5urlRequest request, String tenantId);

    /**
     * 取餐码信息下发。
     * <p>官方接口：{@code /peisong/order/mealCode/saveMealCodeByPkgId}，API：{@code meal_code_save}，版本：{@code 10016}，businessId：{@code 19}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> mealCodeSave(MealCodeSaveRequest request, String tenantId);

    /**
     * 增加小费接口。
     * <p>官方接口：{@code /peisong/order/addTip}，API：{@code order_add_tip}，版本：{@code 10011}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderAddTip(OrderAddTipRequest request, String tenantId);

    /**
     * 订单修改。
     * <p>官方接口：{@code /peisong/order/modify}，API：{@code order_modify}，版本：{@code 10011}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderModify(OrderModifyRequest request, String tenantId);

    /**
     * 预发单接口。
     * <p>官方接口：{@code /peisong/order/preCreateByShop}，API：{@code pre_create_by_shop}，版本：{@code 10022}，businessId：{@code 19}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> preCreateByShop(PreCreateByShopRequest request, String tenantId);

    /**
     * 订单状态查询。
     * <p>官方接口：{@code /peisong/order/queryStatus}，API：{@code query_order_status}，版本：{@code 10024}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryOrderStatus(QueryOrderStatusRequest request, String tenantId);

    /**
     * 获取骑手当前位置。
     * <p>官方接口：{@code /peisong/order/rider/location}，API：{@code rider_location}，版本：{@code 10009}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> riderLocation(RiderLocationRequest request, String tenantId);

    /**
     * 查询合作方配送范围。
     * <p>官方接口：{@code /peisong/shop/area/query}，API：{@code area_query}，版本：{@code 10004}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> areaQuery(AreaQueryRequest request, String tenantId);

    /**
     * 创建配送门店。
     * <p>官方接口：{@code /peisong/shop/create}，API：{@code create_shop}，版本：{@code 10008}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createShop(CreateShopRequest request, String tenantId);

    /**
     * 查询门店信息。
     * <p>官方接口：{@code /peisong/shop/query}，API：{@code query_shop}，版本：{@code 10009}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryShop(QueryShopRequest request, String tenantId);

    /**
     * 修改门店。
     * <p>官方接口：{@code /peisong/shop/update}，API：{@code update_shop}，版本：{@code 10007}，businessId：{@code 19}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateShop(UpdateShopRequest request, String tenantId);

    /**
     * 模拟接单。
     * <p>官方接口：{@code /peisong/test/orderArrange}，API：{@code order_arrange}，版本：{@code 10003}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderArrange(OrderArrangeRequest request, String tenantId);

    /**
     * 模拟送达。
     * <p>官方接口：{@code /peisong/test/orderDeliver}，API：{@code order_deliver}，版本：{@code 10003}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderDeliver(OrderDeliverRequest request, String tenantId);

    /**
     * 模拟取货。
     * <p>官方接口：{@code /peisong/test/orderPickup}，API：{@code order_pickup}，版本：{@code 10003}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderPickup(OrderPickupRequest request, String tenantId);

    /**
     * 模拟改派。
     * <p>官方接口：{@code /peisong/test/orderRearrange}，API：{@code order_rearrange}，版本：{@code 10003}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRearrange(OrderRearrangeRequest request, String tenantId);

    /**
     * 模拟骑手上传异常。
     * <p>官方接口：{@code /peisong/test/orderReportException}，API：{@code order_report_exception}，版本：{@code 10003}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderReportException(OrderReportExceptionRequest request, String tenantId);

    /**
     * 模拟门店配送范围变更。
     * <p>官方接口：{@code /peisong/test/shop/area/callback}，API：{@code shop_area_callback}，版本：{@code 10004}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopAreaCallback(ShopAreaCallbackRequest request, String tenantId);

    /**
     * 模拟门店配送风险等级变更。
     * <p>官方接口：{@code /peisong/test/shop/deliveryRiskLevel/callback}，API：{@code shop_delivery_risk_level_callback}，版本：{@code 10005}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopDeliveryRiskLevelCallback(ShopDeliveryRiskLevelCallbackRequest request, String tenantId);

    /**
     * 模拟门店状态回调测试。
     * <p>官方接口：{@code /peisong/test/shopStatusCallback}，API：{@code shop_status_callback}，版本：{@code 10003}，businessId：{@code 19}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopStatusCallback(ShopStatusCallbackRequest request, String tenantId);

    /**
     * 门店配送规则更新自配配送费。
     * <p>官方接口：{@code /dcps/fulfill/poi/biz/deliveryRule/fee/update}，API：{@code group_delivery_poi_biz_delivery_rule_fee_update}，版本：{@code 10030}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiBizDeliveryRuleFeeUpdate(GroupDeliveryPoiBizDeliveryRuleFeeUpdateRequest request, String tenantId);

    /**
     * 门店配送规则更新自配配送范围。
     * <p>官方接口：{@code /dcps/fulfill/poi/biz/deliveryRule/range/update}，API：{@code group_delivery_poi_biz_delivery_rule_range_update}，版本：{@code 10031}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiBizDeliveryRuleRangeUpdate(GroupDeliveryPoiBizDeliveryRuleRangeUpdateRequest request, String tenantId);

    /**
     * 2.1.8.查询门店团购配送套餐列表。
     * <p>官方接口：{@code /dcps/fulfill/poi/deal/query}，API：{@code group_delivery_poi_deal_query}，版本：{@code 10034}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDealQuery(GroupDeliveryPoiDealQueryRequest request, String tenantId);

    /**
     * 2.1.3.更新门店配送规则基础信息。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/base/update}，API：{@code group_delivery_poi_delivery_rule_base_update}，版本：{@code 10033}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleBaseUpdate(GroupDeliveryPoiDeliveryRuleBaseUpdateRequest request, String tenantId);

    /**
     * 门店配送规则变更详情查询。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/change/query}，API：{@code group_delivery_poi_delivery_rule_change_query}，版本：{@code 10006}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleChangeQuery(GroupDeliveryPoiDeliveryRuleChangeQueryRequest request, String tenantId);

    /**
     * 门店配送规则创建。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/create}，API：{@code group_delivery_poi_delivery_rule_create}，版本：{@code 10001}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleCreate(GroupDeliveryPoiDeliveryRuleCreateRequest request, String tenantId);

    /**
     * 门店配送规则更新配送费折扣信息。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/feeDiscount/update}，API：{@code group_delivery_poi_delivery_rule_fee_discount_update}，版本：{@code 10003}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleFeeDiscountUpdate(GroupDeliveryPoiDeliveryRuleFeeDiscountUpdateRequest request, String tenantId);

    /**
     * 门店配送规则查询。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/query}，API：{@code group_delivery_poi_delivery_rule_query}，版本：{@code 10007}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleQuery(GroupDeliveryPoiDeliveryRuleQueryRequest request, String tenantId);

    /**
     * 门店配送规则更新配送范围。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/range/update}，API：{@code group_delivery_poi_delivery_rule_range_update}，版本：{@code 10005}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleRangeUpdate(GroupDeliveryPoiDeliveryRuleRangeUpdateRequest request, String tenantId);

    /**
     * 门店配送规则更新预约规则。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/reservation/update}，API：{@code group_delivery_poi_delivery_rule_reservation_update}，版本：{@code 10004}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleReservationUpdate(GroupDeliveryPoiDeliveryRuleReservationUpdateRequest request, String tenantId);

    /**
     * 门店配送规则更新切换配送服务。
     * <p>官方接口：{@code /dcps/fulfill/poi/deliveryRule/type/update}，API：{@code group_delivery_poi_delivery_rule_type_update}，版本：{@code 10029}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiDeliveryRuleTypeUpdate(GroupDeliveryPoiDeliveryRuleTypeUpdateRequest request, String tenantId);

    /**
     * 团购配送门店服务接口，用于获取门店信息。
     * <p>官方接口：{@code /dcps/fulfill/poi/getPoiInfo}，API：{@code group_delivery_poi_service}，版本：{@code 10000}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupDeliveryPoiService(GroupDeliveryPoiServiceRequest request, String tenantId);

    /**
     * 套餐配送-同意退款。
     * <p>官方接口：{@code /dcps/fulfill/agree/refund}，API：{@code groupbuy_agree_refund}，版本：{@code 10023}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyAgreeRefund(GroupbuyAgreeRefundRequest request, String tenantId);

    /**
     * 套餐配送-取消订单。
     * <p>官方接口：{@code /dcps/fulfill/cancel/order}，API：{@code groupbuy_cancel_order}，版本：{@code 10021}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyCancelOrder(GroupbuyCancelOrderRequest request, String tenantId);

    /**
     * 1.1.12配送信息回调。
     * <p>官方接口：{@code /dcps/fulfill/delivery/change/status}，API：{@code groupbuy_delivery_change_status}，版本：{@code 10039}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyDeliveryChangeStatus(GroupbuyDeliveryChangeStatusRequest request, String tenantId);

    /**
     * 套餐配送-自配完成。
     * <p>官方接口：{@code /dcps/fulfill/delivery/finish}，API：{@code groupbuy_delivery_finish}，版本：{@code 10025}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyDeliveryFinish(GroupbuyDeliveryFinishRequest request, String tenantId);

    /**
     * 1.1.11.电商发单。
     * <p>官方接口：{@code /dcps/fulfill/fill/tracking/number}，API：{@code groupbuy_fill_track_number}，版本：{@code 10037}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyFillTrackNumber(GroupbuyFillTrackNumberRequest request, String tenantId);

    /**
     * 套餐配送-出餐。
     * <p>官方接口：{@code /dcps/fulfill/meal/call/rider}，API：{@code groupbuy_meal_call_rider}，版本：{@code 10020}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyMealCallRider(GroupbuyMealCallRiderRequest request, String tenantId);

    /**
     * 1.1.9.查询订单详情。
     * <p>官方接口：{@code /dcps/fulfill/order/detail}，API：{@code groupbuy_order_detail}，版本：{@code 10036}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyOrderDetail(GroupbuyOrderDetailRequest request, String tenantId);

    /**
     * 套餐配送-查询轨迹。
     * <p>官方接口：{@code /dcps/fulfill/order/logs}，API：{@code groupbuy_order_logs}，版本：{@code 10027}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyOrderLogs(GroupbuyOrderLogsRequest request, String tenantId);

    /**
     * 套餐配送-接单。
     * <p>官方接口：{@code /dcps/fulfill/receive/order}，API：{@code groupbuy_receive_order}，版本：{@code 10028}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyReceiveOrder(GroupbuyReceiveOrderRequest request, String tenantId);

    /**
     * 套餐配送-拒绝接单。
     * <p>官方接口：{@code /dcps/fulfill/reject/receive/order}，API：{@code groupbuy_reject_receive_order}，版本：{@code 10022}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyRejectReceiveOrder(GroupbuyRejectReceiveOrderRequest request, String tenantId);

    /**
     * 套餐配送-拒绝退款。
     * <p>官方接口：{@code /dcps/fulfill/reject/refund}，API：{@code groupbuy_reject_refund}，版本：{@code 10024}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuyRejectRefund(GroupbuyRejectRefundRequest request, String tenantId);

    /**
     * 套餐配送-转自配。
     * <p>官方接口：{@code /dcps/fulfill/self/delivery}，API：{@code groupbuy_self_delivery}，版本：{@code 10019}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupbuySelfDelivery(GroupbuySelfDeliveryRequest request, String tenantId);

    /**
     * 4.1.1.三方云打印机状态（绑定解绑）回传。
     * <p>官方接口：{@code /dcps/print/printer/status/update}，API：{@code update_printer_status}，版本：{@code 10000}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updatePrinterStatus(UpdatePrinterStatusRequest request, String tenantId);

    /**
     * 查询结算结果。
     * <p>官方接口：{@code /dcps/settlement/querySettleResultForTGDeliver}，API：{@code query_settle_result}，版本：{@code 10000}，businessId：{@code 46}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> querySettleResult(QuerySettleResultRequest request, String tenantId);
}
