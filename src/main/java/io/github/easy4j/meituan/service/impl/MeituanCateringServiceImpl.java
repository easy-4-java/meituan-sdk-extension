package io.github.easy4j.meituan.service.impl;

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
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanCateringService;

/**
 * 餐饮系统默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanCateringServiceImpl extends AbstractMeituanService implements MeituanCateringService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanCateringServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouDealSkuMapping(TuangouDealSkuMappingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancannewOrderPushNotice(DiancannewOrderPushNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancannewOrderQueryOrder(DiancannewOrderQueryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancannewOrderQueryOrderDownloadUrl(DiancannewOrderQueryOrderDownloadUrlRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderChangeNotice(OrderChangeNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderFinish(OrderFinishRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderFullFillNotice(OrderFullFillNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderRefund(OrderRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> refundNotice(RefundNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouTradeQueryByPage(TuangouTradeQueryByPageRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> baseInfoQuery(BaseInfoQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodmopQueryByPage(QueryByPageRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryShops(QueryShopsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> relationBind(RelationBindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> relationUnbind(RelationUnbindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> reserveConfigUpdate(ReserveConfigUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> serveStatusUpdate(ServeStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopCustomization(ShopCustomizationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shoporproductUnboundQuery(ShoporproductUnboundQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> statusUpdate(StatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tagBind(TagBindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tagPush(TagPushRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tagQuery(TagQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchQuerySkuPrice(BatchQuerySkuPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateShopSkuStock(BatchUpdateShopSkuStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateSkuPrice(BatchUpdateSkuPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> create(CreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createComboS(CreateComboSRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> customruleCreate(CustomruleCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> premiumCreate(PremiumCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productUpdate(ProductUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryShopMenu(QueryShopMenuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryShopPremiumShelfStatus(QueryShopPremiumShelfStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryShopProductShelfStatus(QueryShopProductShelfStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryShopSaleAttributeShelfStatus(QueryShopSaleAttributeShelfStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVendorPremium(QueryVendorPremiumRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVendorPremiumCode(QueryVendorPremiumCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVendorSaleAttribute(QueryVendorSaleAttributeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVendorSaleAttributeCode(QueryVendorSaleAttributeCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVendorSkuCustomrule(QueryVendorSkuCustomruleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVendorSpu(QueryVendorSpuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVendorSpuPool(QueryVendorSpuPoolRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> saleattrCreate(SaleattrCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopmenuCreate(ShopmenuCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopmenuCreatespecial(ShopmenuCreatespecialRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopmenuDeleteSpecial(ShopmenuDeleteSpecialRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateComboPriceRule(UpdateComboPriceRuleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updatePremiumShelfStatus(UpdatePremiumShelfStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateSaleAttributeShelfStatus(UpdateSaleAttributeShelfStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateSkuPrice(UpdateSkuPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateSpuShelfStatus(UpdateSpuShelfStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> uploadPicture(UploadPictureRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> configDiningTime(ConfigDiningTimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> operateOrder(OperateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderBatchQuery(OrderBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryOrder(QueryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplyRuleQuery(SupplyRuleQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplyRuleSave(SupplyRuleSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplyRuleSaveBookingTimeRule(SupplyRuleSaveBookingTimeRuleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplyStockQuery(SupplyStockQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplyStockUpdate(SupplyStockUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateTableVisible(UpdateTableVisibleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> saveTable(SaveTableRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplySaveTable(SupplySaveTableRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplyTableDelete(SupplyTableDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> supplyTableQuery(SupplyTableQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tableDelete(TableDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tableDiningTimeUpdateNew(TableDiningTimeUpdateNewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tableFutureStatusUpdate(TableFutureStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tableStatusPush(TableStatusPushRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tableUpdate(TableUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tablestatusUpdate(TablestatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateTableStatus(UpdateTableStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishconnectQueryByPage(com.meituan.sdk.model.dishconnect.settle.queryByPage.QueryByPageRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponBatchConsume(CouponBatchConsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponBatchPrepare(CouponBatchPrepareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponBatchUnlock(CouponBatchUnlockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponCancel(CouponCancelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponMatchConsume(CouponMatchConsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryByMobile(CouponQueryByMobileRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryLocalList(CouponQueryLocalListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryProfitDetail(CouponQueryProfitDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponStatusQuery(CouponStatusQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> maitonOrderRefund(MaitonOrderRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchAuthorizePaidui(BatchAuthorizePaiduiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderClear(OrderClearRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderCreateBatchsync(OrderCreateBatchsyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderCreateCallback(OrderCreateCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderCreateSync(OrderCreateSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderIndexSync(OrderIndexSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderQuery(OrderQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderReset(OrderResetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderStatusUpdate(OrderStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> displayWaitTimeUpdate(DisplayWaitTimeUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> heartbeatSync(HeartbeatSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> onlineQueueConfigUpdate(OnlineQueueConfigUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tableTypeClear(TableTypeClearRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tableTypeSync(TableTypeSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tipsUpdate(TipsUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> userWxBind(UserWxBindRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
