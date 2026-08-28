package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.dcpd.approval.batchAuthorizePaidui.BatchAuthorizePaiduiRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderClear.OrderClearRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderCreateBatchsync.OrderCreateBatchsyncRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderCreateCallback.OrderCreateCallbackRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderCreateSync.OrderCreateSyncRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderIndexSync.OrderIndexSyncRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderQuery.OrderQueryRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderReset.OrderResetRequest;
import com.meituan.sdk.model.dcpd.queueOrder.orderStatusUpdate.OrderStatusUpdateRequest;
import com.meituan.sdk.model.dcpd.queueShop.displayWaitTimeUpdate.DisplayWaitTimeUpdateRequest;
import com.meituan.sdk.model.dcpd.queueShop.heartbeatSync.HeartbeatSyncRequest;
import com.meituan.sdk.model.dcpd.queueShop.onlineQueueConfigUpdate.OnlineQueueConfigUpdateRequest;
import com.meituan.sdk.model.dcpd.queueShop.tableTypeClear.TableTypeClearRequest;
import com.meituan.sdk.model.dcpd.queueShop.tableTypeSync.TableTypeSyncRequest;
import com.meituan.sdk.model.dcpd.queueShop.tipsUpdate.TipsUpdateRequest;
import com.meituan.sdk.model.dcpd.queueShop.userWxBind.UserWxBindRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponBatchConsume.CouponBatchConsumeRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponBatchPrepare.CouponBatchPrepareRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponBatchUnlock.CouponBatchUnlockRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponCancel.CouponCancelRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponMatchConsume.CouponMatchConsumeRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponQueryByMobile.CouponQueryByMobileRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponQueryLocalList.CouponQueryLocalListRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponQueryProfitDetail.CouponQueryProfitDetailRequest;
import com.meituan.sdk.model.dishconnect.tuangou.couponStatusQuery.CouponStatusQueryRequest;
import com.meituan.sdk.model.dishconnect.tuangou.maitonOrderRefund.MaitonOrderRefundRequest;
import com.meituan.sdk.model.foodmop.market.tuangouDealSkuMapping.TuangouDealSkuMappingRequest;
import com.meituan.sdk.model.foodmop.order.diancannewOrderPushNotice.DiancannewOrderPushNoticeRequest;
import com.meituan.sdk.model.foodmop.order.diancannewOrderQueryOrder.DiancannewOrderQueryOrderRequest;
import com.meituan.sdk.model.foodmop.order.diancannewOrderQueryOrderDownloadUrl.DiancannewOrderQueryOrderDownloadUrlRequest;
import com.meituan.sdk.model.foodmop.order.orderChangeNotice.OrderChangeNoticeRequest;
import com.meituan.sdk.model.foodmop.order.orderFinish.OrderFinishRequest;
import com.meituan.sdk.model.foodmop.order.orderFullFillNotice.OrderFullFillNoticeRequest;
import com.meituan.sdk.model.foodmop.order.orderRefund.OrderRefundRequest;
import com.meituan.sdk.model.foodmop.order.refundNotice.RefundNoticeRequest;
import com.meituan.sdk.model.foodmop.pay.tuangouTradeQueryByPage.TuangouTradeQueryByPageRequest;
import com.meituan.sdk.model.foodmop.shop.baseInfoQuery.BaseInfoQueryRequest;
import com.meituan.sdk.model.foodmop.shop.queryByPage.QueryByPageRequest;
import com.meituan.sdk.model.foodmop.shop.queryShops.QueryShopsRequest;
import com.meituan.sdk.model.foodmop.shop.relationBind.RelationBindRequest;
import com.meituan.sdk.model.foodmop.shop.relationUnbind.RelationUnbindRequest;
import com.meituan.sdk.model.foodmop.shop.reserveConfigUpdate.ReserveConfigUpdateRequest;
import com.meituan.sdk.model.foodmop.shop.serveStatusUpdate.ServeStatusUpdateRequest;
import com.meituan.sdk.model.foodmop.shop.shopCustomization.ShopCustomizationRequest;
import com.meituan.sdk.model.foodmop.shop.shoporproductUnboundQuery.ShoporproductUnboundQueryRequest;
import com.meituan.sdk.model.foodmop.shop.statusUpdate.StatusUpdateRequest;
import com.meituan.sdk.model.foodmop.shop.tagBind.TagBindRequest;
import com.meituan.sdk.model.foodmop.shop.tagPush.TagPushRequest;
import com.meituan.sdk.model.foodmop.shop.tagQuery.TagQueryRequest;
import com.meituan.sdk.model.foodmop.sku.batchQuerySkuPrice.BatchQuerySkuPriceRequest;
import com.meituan.sdk.model.foodmop.sku.batchUpdateShopSkuStock.BatchUpdateShopSkuStockRequest;
import com.meituan.sdk.model.foodmop.sku.batchUpdateSkuPrice.BatchUpdateSkuPriceRequest;
import com.meituan.sdk.model.foodmop.sku.create.CreateRequest;
import com.meituan.sdk.model.foodmop.sku.createComboS.CreateComboSRequest;
import com.meituan.sdk.model.foodmop.sku.customruleCreate.CustomruleCreateRequest;
import com.meituan.sdk.model.foodmop.sku.premiumCreate.PremiumCreateRequest;
import com.meituan.sdk.model.foodmop.sku.productUpdate.ProductUpdateRequest;
import com.meituan.sdk.model.foodmop.sku.queryShopMenu.QueryShopMenuRequest;
import com.meituan.sdk.model.foodmop.sku.queryShopPremiumShelfStatus.QueryShopPremiumShelfStatusRequest;
import com.meituan.sdk.model.foodmop.sku.queryShopProductShelfStatus.QueryShopProductShelfStatusRequest;
import com.meituan.sdk.model.foodmop.sku.queryShopSaleAttributeShelfStatus.QueryShopSaleAttributeShelfStatusRequest;
import com.meituan.sdk.model.foodmop.sku.queryVendorPremium.QueryVendorPremiumRequest;
import com.meituan.sdk.model.foodmop.sku.queryVendorPremiumCode.QueryVendorPremiumCodeRequest;
import com.meituan.sdk.model.foodmop.sku.queryVendorSaleAttribute.QueryVendorSaleAttributeRequest;
import com.meituan.sdk.model.foodmop.sku.queryVendorSaleAttributeCode.QueryVendorSaleAttributeCodeRequest;
import com.meituan.sdk.model.foodmop.sku.queryVendorSkuCustomrule.QueryVendorSkuCustomruleRequest;
import com.meituan.sdk.model.foodmop.sku.queryVendorSpu.QueryVendorSpuRequest;
import com.meituan.sdk.model.foodmop.sku.queryVendorSpuPool.QueryVendorSpuPoolRequest;
import com.meituan.sdk.model.foodmop.sku.saleattrCreate.SaleattrCreateRequest;
import com.meituan.sdk.model.foodmop.sku.shopmenuCreate.ShopmenuCreateRequest;
import com.meituan.sdk.model.foodmop.sku.shopmenuCreatespecial.ShopmenuCreatespecialRequest;
import com.meituan.sdk.model.foodmop.sku.shopmenuDeleteSpecial.ShopmenuDeleteSpecialRequest;
import com.meituan.sdk.model.foodmop.sku.updateComboPriceRule.UpdateComboPriceRuleRequest;
import com.meituan.sdk.model.foodmop.sku.updatePremiumShelfStatus.UpdatePremiumShelfStatusRequest;
import com.meituan.sdk.model.foodmop.sku.updateSaleAttributeShelfStatus.UpdateSaleAttributeShelfStatusRequest;
import com.meituan.sdk.model.foodmop.sku.updateSkuPrice.UpdateSkuPriceRequest;
import com.meituan.sdk.model.foodmop.sku.updateSpuShelfStatus.UpdateSpuShelfStatusRequest;
import com.meituan.sdk.model.foodmop.sku.uploadPicture.UploadPictureRequest;
import com.meituan.sdk.model.resv2.config.configDiningTime.ConfigDiningTimeRequest;
import com.meituan.sdk.model.resv2.order.operateOrder.OperateOrderRequest;
import com.meituan.sdk.model.resv2.order.orderBatchQuery.OrderBatchQueryRequest;
import com.meituan.sdk.model.resv2.order.queryOrder.QueryOrderRequest;
import com.meituan.sdk.model.resv2.rule.supplyRuleQuery.SupplyRuleQueryRequest;
import com.meituan.sdk.model.resv2.rule.supplyRuleSave.SupplyRuleSaveRequest;
import com.meituan.sdk.model.resv2.rule.supplyRuleSaveBookingTimeRule.SupplyRuleSaveBookingTimeRuleRequest;
import com.meituan.sdk.model.resv2.stock.supplyStockQuery.SupplyStockQueryRequest;
import com.meituan.sdk.model.resv2.stock.supplyStockUpdate.SupplyStockUpdateRequest;
import com.meituan.sdk.model.resv2.stock.updateTableVisible.UpdateTableVisibleRequest;
import com.meituan.sdk.model.resv2.table.saveTable.SaveTableRequest;
import com.meituan.sdk.model.resv2.table.supplySaveTable.SupplySaveTableRequest;
import com.meituan.sdk.model.resv2.table.supplyTableDelete.SupplyTableDeleteRequest;
import com.meituan.sdk.model.resv2.table.supplyTableQuery.SupplyTableQueryRequest;
import com.meituan.sdk.model.resv2.table.tableDelete.TableDeleteRequest;
import com.meituan.sdk.model.resv2.table.tableDiningTimeUpdateNew.TableDiningTimeUpdateNewRequest;
import com.meituan.sdk.model.resv2.table.tableFutureStatusUpdate.TableFutureStatusUpdateRequest;
import com.meituan.sdk.model.resv2.table.tableStatusPush.TableStatusPushRequest;
import com.meituan.sdk.model.resv2.table.tableUpdate.TableUpdateRequest;
import com.meituan.sdk.model.resv2.table.tablestatusUpdate.TablestatusUpdateRequest;
import com.meituan.sdk.model.resv2.table.updateTableStatus.UpdateTableStatusRequest;

/**
 * 餐饮系统业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanCateringService extends MeituanService {

    /**
     * 团购券菜品关系同步（使用团券兑换功能-必接）。
     * <p>官方接口：{@code /foodmop/market/tuangou/deal/sku/mapping}，API：{@code tuangou_deal_sku_mapping}，版本：{@code 10006}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouDealSkuMapping(TuangouDealSkuMappingRequest request, String tenantId);

    /**
     * 订单确认接口。
     * <p>官方接口：{@code /foodmop/order/diancannew/order/pushNotice}，API：{@code diancannew_order_push_notice}，版本：{@code 10010}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancannewOrderPushNotice(DiancannewOrderPushNoticeRequest request, String tenantId);

    /**
     * 品牌查询美团的单笔订单。
     * <p>官方接口：{@code /foodmop/order/diancannew/order/queryOrder}，API：{@code diancannew_order_query_order}，版本：{@code 10012}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancannewOrderQueryOrder(DiancannewOrderQueryOrderRequest request, String tenantId);

    /**
     * 品牌查询美团日全量订单下载地址。
     * <p>官方接口：{@code /foodmop/order/diancannew/order/queryOrderDownloadUrl}，API：{@code diancannew_order_query_order_download_url}，版本：{@code 10011}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancannewOrderQueryOrderDownloadUrl(DiancannewOrderQueryOrderDownloadUrlRequest request, String tenantId);

    /**
     * 订单修改审核结果通知。
     * <p>官方接口：{@code /foodmop/order/orderChangeNotice}，API：{@code order_change_notice}，版本：{@code 10006}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderChangeNotice(OrderChangeNoticeRequest request, String tenantId);

    /**
     * 品牌订单完成通知。
     * <p>官方接口：{@code /foodmop/order/diancannew/order/finish}，API：{@code order_finish}，版本：{@code 10007}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderFinish(OrderFinishRequest request, String tenantId);

    /**
     * 品牌订单状态变更通知。
     * <p>官方接口：{@code /foodmop/order/diancannew/order/fullFillNotice}，API：{@code order_full_fill_notice}，版本：{@code 10010}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderFullFillNotice(OrderFullFillNoticeRequest request, String tenantId);

    /**
     * 商家发起退款。
     * <p>官方接口：{@code /foodmop/order/refund}，API：{@code order_refund}，版本：{@code 10009}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRefund(OrderRefundRequest request, String tenantId);

    /**
     * 品牌方对美团发起的退款审核确认。
     * <p>官方接口：{@code /foodmop/order/refundNotice}，API：{@code refund_notice}，版本：{@code 10008}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> refundNotice(RefundNoticeRequest request, String tenantId);

    /**
     * 对账分页查询账单信息（非必接）。
     * <p>官方接口：{@code /foodmop/pay/tuangou/trade/queryByPage}，API：{@code tuangou_trade_query_by_page}，版本：{@code 10005}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouTradeQueryByPage(TuangouTradeQueryByPageRequest request, String tenantId);

    /**
     * 门店信息查询（选接）。
     * <p>官方接口：{@code /foodmop/shop/baseInfo/query}，API：{@code base_info_query}，版本：{@code 10020}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> baseInfoQuery(BaseInfoQueryRequest request, String tenantId);

    /**
     * 品牌查询全量门店Id列表（非必接）。
     * <p>官方接口：{@code /foodmop/shop/queryByPage}，API：{@code query_by_page}，版本：{@code 10011}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodmopQueryByPage(QueryByPageRequest request, String tenantId);

    /**
     * 门店配置查询（非必接）。
     * <p>官方接口：{@code /foodmop/shop/queryShops}，API：{@code query_shops}，版本：{@code 10010}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryShops(QueryShopsRequest request, String tenantId);

    /**
     * 绑定门店（必接）。
     * <p>官方接口：{@code /foodmop/shop/relation/bind}，API：{@code relation_bind}，版本：{@code 10022}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> relationBind(RelationBindRequest request, String tenantId);

    /**
     * 解绑门店（必接）。
     * <p>官方接口：{@code /foodmop/shop/relation/unbind}，API：{@code relation_unbind}，版本：{@code 10021}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> relationUnbind(RelationUnbindRequest request, String tenantId);

    /**
     * 门店“线上点”预约配置（非必接）。
     * <p>官方接口：{@code /foodmop/shop/reserve/config/update}，API：{@code reserve_config_update}，版本：{@code 10013}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> reserveConfigUpdate(ReserveConfigUpdateRequest request, String tenantId);

    /**
     * “线上点”门店营业状态批量变更（必接）。
     * <p>官方接口：{@code /foodmop/shop/serve/status/update}，API：{@code serve_status_update}，版本：{@code 10014}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> serveStatusUpdate(ServeStatusUpdateRequest request, String tenantId);

    /**
     * 门店定制化配置（非必接）。
     * <p>官方接口：{@code /foodmop/shop/customization/update}，API：{@code shop_customization}，版本：{@code 10016}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopCustomization(ShopCustomizationRequest request, String tenantId);

    /**
     * 查询秒提未开通的门店/未映射门店的团单。
     * <p>官方接口：{@code /foodmop/shop/orProduct/unbound/query}，API：{@code shoporproduct_unbound_query}，版本：{@code 10007}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shoporproductUnboundQuery(ShoporproductUnboundQueryRequest request, String tenantId);

    /**
     * 品牌同步门店线上点业务开通状态变更。
     * <p>官方接口：{@code /foodmop/shop/status/update}，API：{@code status_update}，版本：{@code 10015}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> statusUpdate(StatusUpdateRequest request, String tenantId);

    /**
     * 品牌门店打标签。
     * <p>官方接口：{@code /foodmop/shop/tag/bind}，API：{@code tag_bind}，版本：{@code 10018}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tagBind(TagBindRequest request, String tenantId);

    /**
     * 品牌门店标签推送。
     * <p>官方接口：{@code /foodmop/shop/tag/push}，API：{@code tag_push}，版本：{@code 10012}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tagPush(TagPushRequest request, String tenantId);

    /**
     * 品牌门店标签查询。
     * <p>官方接口：{@code /foodmop/shop/tag/query}，API：{@code tag_query}，版本：{@code 10019}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tagQuery(TagQueryRequest request, String tenantId);

    /**
     * 批量查询商品价格。
     * <p>官方接口：{@code /foodmop/sku/batchQuerySkuPrice}，API：{@code batch_query_sku_price}，版本：{@code 10058}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchQuerySkuPrice(BatchQuerySkuPriceRequest request, String tenantId);

    /**
     * 批量更新门店商品库存（非必接）。
     * <p>官方接口：{@code /foodmop/sku/batchUpdateSkuStock}，API：{@code batch_update_shop_sku_stock}，版本：{@code 10055}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateShopSkuStock(BatchUpdateShopSkuStockRequest request, String tenantId);

    /**
     * 批量更新门店维度 SKU 价格。
     * <p>官方接口：{@code /foodmop/sku/batchUpdateSkuPrice}，API：{@code batch_update_sku_price}，版本：{@code 10063}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateSkuPrice(BatchUpdateSkuPriceRequest request, String tenantId);

    /**
     * 创建或更新商品（必接）。
     * <p>官方接口：{@code /foodmop/sku/create}，API：{@code create}，版本：{@code 10065}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> create(CreateRequest request, String tenantId);

    /**
     * 商品上单新建套餐。
     * <p>官方接口：{@code /foodmop/sku/combo/create}，API：{@code create_combo_s}，版本：{@code 10066}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createComboS(CreateComboSRequest request, String tenantId);

    /**
     * 创建或更改商品客制化规则（必接）。
     * <p>官方接口：{@code /foodmop/sku/customrule/create}，API：{@code customrule_create}，版本：{@code 10048}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> customruleCreate(CustomruleCreateRequest request, String tenantId);

    /**
     * 创建或更新配料属性（必接）。
     * <p>官方接口：{@code /foodmop/sku/premium/create}，API：{@code premium_create}，版本：{@code 10050}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> premiumCreate(PremiumCreateRequest request, String tenantId);

    /**
     * 更新门店商品库存（必接）。
     * <p>官方接口：{@code /foodmop/sku/update}，API：{@code product_update}，版本：{@code 10046}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUpdate(ProductUpdateRequest request, String tenantId);

    /**
     * 查询门店菜谱。
     * <p>官方接口：{@code /foodmop/sku/queryShopMenu}，API：{@code query_shop_menu}，版本：{@code 10054}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryShopMenu(QueryShopMenuRequest request, String tenantId);

    /**
     * 查询门店上架的配料。
     * <p>官方接口：{@code /foodmop/sku/shelf/premium/query}，API：{@code query_shop_premium_shelf_status}，版本：{@code 10061}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryShopPremiumShelfStatus(QueryShopPremiumShelfStatusRequest request, String tenantId);

    /**
     * 查询门店上架的商品。
     * <p>官方接口：{@code /foodmop/sku/queryByShop}，API：{@code query_shop_product_shelf_status}，版本：{@code 10013}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryShopProductShelfStatus(QueryShopProductShelfStatusRequest request, String tenantId);

    /**
     * 查询门店上架的售卖属性。
     * <p>官方接口：{@code /foodmop/sku/shelf/saleattr/query}，API：{@code query_shop_sale_attribute_shelf_status}，版本：{@code 10060}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryShopSaleAttributeShelfStatus(QueryShopSaleAttributeShelfStatusRequest request, String tenantId);

    /**
     * 查询配料属性信息。
     * <p>官方接口：{@code /foodmop/sku/premium/query}，API：{@code query_vendor_premium}，版本：{@code 10062}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVendorPremium(QueryVendorPremiumRequest request, String tenantId);

    /**
     * 查询品牌所有配料编码。
     * <p>官方接口：{@code /foodmop/sku/premium/queryAll}，API：{@code query_vendor_premium_code}，版本：{@code 10057}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVendorPremiumCode(QueryVendorPremiumCodeRequest request, String tenantId);

    /**
     * 查询售卖属性信息。
     * <p>官方接口：{@code /foodmop/sku/saleattr/query}，API：{@code query_vendor_sale_attribute}，版本：{@code 10062}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVendorSaleAttribute(QueryVendorSaleAttributeRequest request, String tenantId);

    /**
     * 查询品牌所有售卖属性编码。
     * <p>官方接口：{@code /foodmop/sku/saleattr/queryAll}，API：{@code query_vendor_sale_attribute_code}，版本：{@code 10056}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVendorSaleAttributeCode(QueryVendorSaleAttributeCodeRequest request, String tenantId);

    /**
     * 查询商品客制化规则。
     * <p>官方接口：{@code /foodmop/sku/customrule/query}，API：{@code query_vendor_sku_customrule}，版本：{@code 10061}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVendorSkuCustomrule(QueryVendorSkuCustomruleRequest request, String tenantId);

    /**
     * 查询门店商品信息。
     * <p>官方接口：{@code /foodmop/sku/queryVendorSpu}，API：{@code query_vendor_spu}，版本：{@code 10043}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVendorSpu(QueryVendorSpuRequest request, String tenantId);

    /**
     * 查询品牌商品池。
     * <p>官方接口：{@code /foodmop/sku/queryVendorSpuPool}，API：{@code query_vendor_spu_pool}，版本：{@code 10054}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVendorSpuPool(QueryVendorSpuPoolRequest request, String tenantId);

    /**
     * 创建或更新售卖属性（必接）。
     * <p>官方接口：{@code /foodmop/sku/saleattr/create}，API：{@code saleattr_create}，版本：{@code 10051}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> saleattrCreate(SaleattrCreateRequest request, String tenantId);

    /**
     * 创建或更新门店菜谱（必接）。
     * <p>官方接口：{@code /foodmop/sku/shopmenu/create}，API：{@code shopmenu_create}，版本：{@code 10067}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopmenuCreate(ShopmenuCreateRequest request, String tenantId);

    /**
     * 创建或更新门店特殊类目（非必接）。
     * <p>官方接口：{@code /foodmop/sku/shopmenu/createSpecial}，API：{@code shopmenu_createspecial}，版本：{@code 10047}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopmenuCreatespecial(ShopmenuCreatespecialRequest request, String tenantId);

    /**
     * 删除门店特殊类目。
     * <p>官方接口：{@code /foodmop/sku/shopmenu/deleteSpecial}，API：{@code shopmenu_delete_special}，版本：{@code 10059}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopmenuDeleteSpecial(ShopmenuDeleteSpecialRequest request, String tenantId);

    /**
     * 商品上单价格同步。
     * <p>官方接口：{@code /foodmop/sku/combo/price/update}，API：{@code update_combo_price_rule}，版本：{@code 10053}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateComboPriceRule(UpdateComboPriceRuleRequest request, String tenantId);

    /**
     * 更新配料属性上下架状态（必接）。
     * <p>官方接口：{@code /foodmop/sku/shelf/premium/update}，API：{@code update_premium_shelf_status}，版本：{@code 10045}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updatePremiumShelfStatus(UpdatePremiumShelfStatusRequest request, String tenantId);

    /**
     * 更新售卖属性上下架状态（必接）。
     * <p>官方接口：{@code /foodmop/sku/diancannew/shelf/saleattr/update}，API：{@code update_sale_attribute_shelf_status}，版本：{@code 10044}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateSaleAttributeShelfStatus(UpdateSaleAttributeShelfStatusRequest request, String tenantId);

    /**
     * 更新门店维度 SKU 价格。
     * <p>官方接口：{@code /foodmop/sku/updateSkuPrice}，API：{@code update_sku_price}，版本：{@code 10049}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateSkuPrice(UpdateSkuPriceRequest request, String tenantId);

    /**
     * 更新商品上下架状态（必接）。
     * <p>官方接口：{@code /foodmop/sku/updateSpuShelfStatus}，API：{@code update_spu_shelf_status}，版本：{@code 10013}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateSpuShelfStatus(UpdateSpuShelfStatusRequest request, String tenantId);

    /**
     * 图片上传（必接）。
     * <p>官方接口：{@code /foodmop/sku/uploadPicture}，API：{@code upload_picture}，版本：{@code 10052}，businessId：{@code 51}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> uploadPicture(UploadPictureRequest request, String tenantId);

    /**
     * 新增或修改门店的营业时段信息。
     * <p>官方接口：{@code /resv2/config/update}，API：{@code config_dining_time}，版本：{@code 10000}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> configDiningTime(ConfigDiningTimeRequest request, String tenantId);

    /**
     * 向开放平台发起订单接单/拒单/确认到店/未到店/分配订单桌位操作。
     * <p>官方接口：{@code /resv2/order/operation}，API：{@code operate_order}，版本：{@code 10001}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> operateOrder(OperateOrderRequest request, String tenantId);

    /**
     * 订单批量查询。
     * <p>官方接口：{@code /resv2/order/batchQuery}，API：{@code order_batch_query}，版本：{@code 10005}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderBatchQuery(OrderBatchQueryRequest request, String tenantId);

    /**
     * 查询订单信息。
     * <p>官方接口：{@code /resv2/order/queryById}，API：{@code query_order}，版本：{@code 10004}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryOrder(QueryOrderRequest request, String tenantId);

    /**
     * 查询规则信息。
     * <p>官方接口：{@code /resv2/rule/supply/query}，API：{@code supply_rule_query}，版本：{@code 10000}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplyRuleQuery(SupplyRuleQueryRequest request, String tenantId);

    /**
     * 设置可订规则。
     * <p>官方接口：{@code /resv2/rule/supply/save}，API：{@code supply_rule_save}，版本：{@code 10002}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplyRuleSave(SupplyRuleSaveRequest request, String tenantId);

    /**
     * 设置门店预订时间规则。
     * <p>官方接口：{@code /resv2/rule/supply/saveBookingTimeRule}，API：{@code supply_rule_save_booking_time_rule}，版本：{@code 10003}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplyRuleSaveBookingTimeRule(SupplyRuleSaveBookingTimeRuleRequest request, String tenantId);

    /**
     * 查询库存。
     * <p>官方接口：{@code /resv2/stock/supply/queryStock}，API：{@code supply_stock_query}，版本：{@code 10001}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplyStockQuery(SupplyStockQueryRequest request, String tenantId);

    /**
     * 库存同步。
     * <p>官方接口：{@code /resv2/stock/supply/updateStock}，API：{@code supply_stock_update}，版本：{@code 10009}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplyStockUpdate(SupplyStockUpdateRequest request, String tenantId);

    /**
     * 清台/锁台。
     * <p>官方接口：{@code /resv2/stock/supply/updateTableVisible}，API：{@code update_table_visible}，版本：{@code 10004}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateTableVisible(UpdateTableVisibleRequest request, String tenantId);

    /**
     * 保存桌位。
     * <p>官方接口：{@code /resv2/table/save}，API：{@code save_table}，版本：{@code 10002}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> saveTable(SaveTableRequest request, String tenantId);

    /**
     * 保存/更新桌型桌位。
     * <p>官方接口：{@code /resv2/table/supply/saveOrUpdateTable}，API：{@code supply_save_table}，版本：{@code 10006}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplySaveTable(SupplySaveTableRequest request, String tenantId);

    /**
     * 删除桌型/桌位。
     * <p>官方接口：{@code /resv2/table/supply/deleteTable}，API：{@code supply_table_delete}，版本：{@code 10007}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplyTableDelete(SupplyTableDeleteRequest request, String tenantId);

    /**
     * 查询桌型桌位。
     * <p>官方接口：{@code /resv2/table/supply/queryTable}，API：{@code supply_table_query}，版本：{@code 10004}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> supplyTableQuery(SupplyTableQueryRequest request, String tenantId);

    /**
     * 删除桌位。
     * <p>官方接口：{@code /resv2/table/delete}，API：{@code table_delete}，版本：{@code 10003}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tableDelete(TableDeleteRequest request, String tenantId);

    /**
     * 上传门店营业餐段时间。
     * <p>官方接口：{@code /resv2/table/dining/time/update}，API：{@code table_dining_time_update_new}，版本：{@code 10030}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tableDiningTimeUpdateNew(TableDiningTimeUpdateNewRequest request, String tenantId);

    /**
     * 预订更新未来桌台使用状态。
     * <p>官方接口：{@code /resv2/table/future/status/update}，API：{@code table_future_status_update}，版本：{@code 10031}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tableFutureStatusUpdate(TableFutureStatusUpdateRequest request, String tenantId);

    /**
     * ERB桌态状态变更推送。
     * <p>官方接口：{@code /resv2/table/status/erbpush}，API：{@code table_status_push}，版本：{@code 10000}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tableStatusPush(TableStatusPushRequest request, String tenantId);

    /**
     * 预订上传桌台。
     * <p>官方接口：{@code /resv2/table/update}，API：{@code table_update}，版本：{@code 10032}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tableUpdate(TableUpdateRequest request, String tenantId);

    /**
     * 预订更新桌台使用状态(最新)。
     * <p>官方接口：{@code /resv2/table/status/upload}，API：{@code tablestatus_update}，版本：{@code 10024}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tablestatusUpdate(TablestatusUpdateRequest request, String tenantId);

    /**
     * 变更桌位状态。
     * <p>官方接口：{@code /resv2/table/status/update}，API：{@code update_table_status}，版本：{@code 10001}，businessId：{@code 7}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateTableStatus(UpdateTableStatusRequest request, String tenantId);

    /**
     * 分页查询账单流水。
     * <p>官方接口：{@code /dishconnect/settle/queryByPage}，API：{@code query_by_page}，版本：{@code 10012}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishconnectQueryByPage(com.meituan.sdk.model.dishconnect.settle.queryByPage.QueryByPageRequest request, String tenantId);

    /**
     * 券码跨订单核销。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/batchConsume}，API：{@code coupon_batch_consume}，版本：{@code 10029}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponBatchConsume(CouponBatchConsumeRequest request, String tenantId);

    /**
     * 券码批量预核销。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/batchPrepare}，API：{@code coupon_batch_prepare}，版本：{@code 10041}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponBatchPrepare(CouponBatchPrepareRequest request, String tenantId);

    /**
     * 券码批量解锁。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/batchUnlock}，API：{@code coupon_batch_unlock}，版本：{@code 10005}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponBatchUnlock(CouponBatchUnlockRequest request, String tenantId);

    /**
     * 券码撤销核销。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/cancel}，API：{@code coupon_cancel}，版本：{@code 10004}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponCancel(CouponCancelRequest request, String tenantId);

    /**
     * 券码匹配核销。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/matchConsume}，API：{@code coupon_match_consume}，版本：{@code 10038}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponMatchConsume(CouponMatchConsumeRequest request, String tenantId);

    /**
     * 通过手机号查询可用券。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/queryByMobile}，API：{@code coupon_query_by_mobile}，版本：{@code 10037}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryByMobile(CouponQueryByMobileRequest request, String tenantId);

    /**
     * 查询门店本地验券历史。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/queryLocalListByDate}，API：{@code coupon_query_local_list}，版本：{@code 10021}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryLocalList(CouponQueryLocalListRequest request, String tenantId);

    /**
     * 查询券码结算扩展明细。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/queryProfitDetail}，API：{@code coupon_query_profit_detail}，版本：{@code 10014}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryProfitDetail(CouponQueryProfitDetailRequest request, String tenantId);

    /**
     * 券码查询。
     * <p>官方接口：{@code /dishconnect/tuangou/coupon/status/query}，API：{@code coupon_status_query}，版本：{@code 10036}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponStatusQuery(CouponStatusQueryRequest request, String tenantId);

    /**
     * 一键买单订单退款。
     * <p>官方接口：{@code /dishconnect/tuangou/maiton/order/refund}，API：{@code maiton_order_refund}，版本：{@code 10001}，businessId：{@code 79}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> maitonOrderRefund(MaitonOrderRefundRequest request, String tenantId);

    /**
     * 批量门店授权接口-到餐排队。
     * <p>官方接口：{@code /dcpd/approval/batchAuthorize}，API：{@code batch_authorize_paidui}，版本：{@code 10000}，businessId：{@code 49}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchAuthorizePaidui(BatchAuthorizePaiduiRequest request, String tenantId);

    /**
     * 清空排队队列。
     * <p>官方接口：{@code /dcpd/queue/order/clear}，API：{@code order_clear}，版本：{@code 10016}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderClear(OrderClearRequest request, String tenantId);

    /**
     * 批量同步线下订单。
     * <p>官方接口：{@code /dcpd/queue/order/create/batchsync}，API：{@code order_create_batchsync}，版本：{@code 10012}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderCreateBatchsync(OrderCreateBatchsyncRequest request, String tenantId);

    /**
     * 取号结果回调。
     * <p>官方接口：{@code /dcpd/queue/order/create/callback}，API：{@code order_create_callback}，版本：{@code 10014}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderCreateCallback(OrderCreateCallbackRequest request, String tenantId);

    /**
     * 同步线下新订单。
     * <p>官方接口：{@code /dcpd/queue/order/create/sync}，API：{@code order_create_sync}，版本：{@code 10009}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderCreateSync(OrderCreateSyncRequest request, String tenantId);

    /**
     * 同步等位信息。
     * <p>官方接口：{@code /dcpd/queue/order/index/sync}，API：{@code order_index_sync}，版本：{@code 10015}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderIndexSync(OrderIndexSyncRequest request, String tenantId);

    /**
     * 查询订单。
     * <p>官方接口：{@code /dcpd/queue/order/query}，API：{@code order_query}，版本：{@code 10017}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderQuery(OrderQueryRequest request, String tenantId);

    /**
     * 归零排号。
     * <p>官方接口：{@code /dcpd/queue/order/reset}，API：{@code order_reset}，版本：{@code 10000}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderReset(OrderResetRequest request, String tenantId);

    /**
     * 更新订单状态。
     * <p>官方接口：{@code /dcpd/queue/order/status/update}，API：{@code order_status_update}，版本：{@code 10008}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderStatusUpdate(OrderStatusUpdateRequest request, String tenantId);

    /**
     * 等位时长显示开关。
     * <p>官方接口：{@code /dcpd/queue/shop/config/displayWaitTime/update}，API：{@code display_wait_time_update}，版本：{@code 10005}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> displayWaitTimeUpdate(DisplayWaitTimeUpdateRequest request, String tenantId);

    /**
     * 批量同步心跳。
     * <p>官方接口：{@code /dcpd/queue/shop/heartbeat/sync}，API：{@code heartbeat_sync}，版本：{@code 10002}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> heartbeatSync(HeartbeatSyncRequest request, String tenantId);

    /**
     * 修改线上取号配置接口。
     * <p>官方接口：{@code /dcpd/queue/shop/config/onlineQueue/update}，API：{@code online_queue_config_update}，版本：{@code 10008}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> onlineQueueConfigUpdate(OnlineQueueConfigUpdateRequest request, String tenantId);

    /**
     * 清空桌型。
     * <p>官方接口：{@code /dcpd/queue/shop/config/tableType/clear}，API：{@code table_type_clear}，版本：{@code 10001}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tableTypeClear(TableTypeClearRequest request, String tenantId);

    /**
     * 同步全量桌型。
     * <p>官方接口：{@code /dcpd/queue/shop/config/tableType/sync}，API：{@code table_type_sync}，版本：{@code 10000}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tableTypeSync(TableTypeSyncRequest request, String tenantId);

    /**
     * 设置商家提示语。
     * <p>官方接口：{@code /dcpd/queue/shop/config/tips/update}，API：{@code tips_update}，版本：{@code 10006}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tipsUpdate(TipsUpdateRequest request, String tenantId);

    /**
     * 绑定用户公众号。
     * <p>官方接口：{@code /dcpd/queue/shop/user/bind}，API：{@code user_wx_bind}，版本：{@code 10003}，businessId：{@code 49}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> userWxBind(UserWxBindRequest request, String tenantId);
}
