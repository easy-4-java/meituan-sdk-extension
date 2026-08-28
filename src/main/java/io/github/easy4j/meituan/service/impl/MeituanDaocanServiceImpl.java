package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.tuangouNg.atomgoods.brandChainPoiBind.BrandChainPoiBindRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.brandChainUpdate.BrandChainUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.orderUpload.OrderUploadRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productAddonUpdate.ProductAddonUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productBoxUpdate.ProductBoxUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productCategoryCreate.ProductCategoryCreateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productSideDishUpdate.ProductSideDishUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productSkuStockUpdate.ProductSkuStockUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productSpuUpdate.ProductSpuUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productSubjectPriceUpdate.ProductSubjectPriceUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productSubjectStatusUpdate.ProductSubjectStatusUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productTableStatusUpdate.ProductTableStatusUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.productTableUpdate.ProductTableUpdateRequest;
import com.meituan.sdk.model.tuangouNg.atomgoods.queryShopAuthInfo.QueryShopAuthInfoRequest;
import com.meituan.sdk.model.tuangouNg.comment.commentReply.CommentReplyRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponCancel.CouponCancelRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponConsume.CouponConsumeRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponPrepare.CouponPrepareRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponQueryDealAttr.CouponQueryDealAttrRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponQueryListByDate.CouponQueryListByDateRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponQueryLocalListByDate.CouponQueryLocalListByDateRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponQueryProfitByCode.CouponQueryProfitByCodeRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponQuerySetMealList.CouponQuerySetMealListRequest;
import com.meituan.sdk.model.tuangouNg.coupon.couponQuerySetMealListV1.CouponQuerySetMealListV1Request;
import com.meituan.sdk.model.tuangouNg.coupon.dishconnectBatchPrepare.DishconnectBatchPrepareRequest;
import com.meituan.sdk.model.tuangouNg.coupon.getCouponPriceInfo.GetCouponPriceInfoRequest;
import com.meituan.sdk.model.tuangouNg.coupon.msSuperConsume.MsSuperConsumeRequest;
import com.meituan.sdk.model.tuangouNg.coupon.msSuperPrepare.MsSuperPrepareRequest;
import com.meituan.sdk.model.tuangouNg.coupon.queryCouponById.QueryCouponByIdRequest;
import com.meituan.sdk.model.tuangouNg.coupon.queryReceiptsByReceiptIds.QueryReceiptsByReceiptIdsRequest;
import com.meituan.sdk.model.tuangouNg.coupon.receiptsByReceiptIds.ReceiptsByReceiptIdsRequest;
import com.meituan.sdk.model.tuangouNg.groupVoucher.couponQueryProfitByCodeMaidan.CouponQueryProfitByCodeMaidanRequest;
import com.meituan.sdk.model.tuangouNg.groupVoucher.groupvoucherOrderQuery.GroupvoucherOrderQueryRequest;
import com.meituan.sdk.model.tuangouNg.groupVoucher.groupvoucherOrderRefund.GroupvoucherOrderRefundRequest;
import com.meituan.sdk.model.tuangouNg.groupVoucher.groupvoucherOrderRelate.GroupvoucherOrderRelateRequest;
import com.meituan.sdk.model.tuangouNg.groupVoucher.groupvoucherShopMaidaniInfo.GroupvoucherShopMaidaniInfoRequest;
import com.meituan.sdk.model.tuangouNg.groupVoucher.groupvoucherShopManage.GroupvoucherShopManageRequest;
import com.meituan.sdk.model.tuangouNg.smar.batchUpsertProductApplicableRules.BatchUpsertProductApplicableRulesRequest;
import com.meituan.sdk.model.tuangouNg.smar.orderPushNotice.OrderPushNoticeRequest;
import com.meituan.sdk.model.tuangouNg.smar.orderRefund.OrderRefundRequest;
import com.meituan.sdk.model.tuangouNg.smar.productUploadComplete.ProductUploadCompleteRequest;
import com.meituan.sdk.model.tuangouNg.smar.shopConfigUpload.ShopConfigUploadRequest;
import com.meituan.sdk.model.tuangouNg.smar.shopInfoUpload.ShopInfoUploadRequest;
import com.meituan.sdk.model.tuangouNg.smar.shopTableUpload.ShopTableUploadRequest;
import com.meituan.sdk.model.tuangouNg.tradeDetail.tuangouCouponQueryTradeDetail.TuangouCouponQueryTradeDetailRequest;
import com.meituan.sdk.model.tuangouself.coupon.couponQuery.CouponQueryRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanDaocanService;

/**
 * 到店餐饮默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanDaocanServiceImpl extends AbstractMeituanService implements MeituanDaocanService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanDaocanServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> brandChainPoiBind(BrandChainPoiBindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> brandChainUpdate(BrandChainUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderUpload(OrderUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productAddonUpdate(ProductAddonUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productBoxUpdate(ProductBoxUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productCategoryCreate(ProductCategoryCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productSideDishUpdate(ProductSideDishUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productSkuStockUpdate(ProductSkuStockUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productSpuUpdate(ProductSpuUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productSubjectPriceUpdate(ProductSubjectPriceUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productSubjectStatusUpdate(ProductSubjectStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productTableStatusUpdate(ProductTableStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productTableUpdate(ProductTableUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryShopAuthInfo(QueryShopAuthInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commentReply(CommentReplyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouNgCouponCancel(CouponCancelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouNgCouponConsume(CouponConsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouNgCouponPrepare(CouponPrepareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryDealAttr(CouponQueryDealAttrRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryListByDate(CouponQueryListByDateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryLocalListByDate(CouponQueryLocalListByDateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryProfitByCode(CouponQueryProfitByCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQuerySetMealList(CouponQuerySetMealListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQuerySetMealListV1(CouponQuerySetMealListV1Request request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishconnectBatchPrepare(DishconnectBatchPrepareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getCouponPriceInfo(GetCouponPriceInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> msSuperConsume(MsSuperConsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> msSuperPrepare(MsSuperPrepareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryCouponById(QueryCouponByIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryReceiptsByReceiptIds(QueryReceiptsByReceiptIdsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> receiptsByReceiptIds(ReceiptsByReceiptIdsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQueryProfitByCodeMaidan(CouponQueryProfitByCodeMaidanRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupvoucherOrderQuery(GroupvoucherOrderQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupvoucherOrderRefund(GroupvoucherOrderRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupvoucherOrderRelate(GroupvoucherOrderRelateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupvoucherShopMaidaniInfo(GroupvoucherShopMaidaniInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> groupvoucherShopManage(GroupvoucherShopManageRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpsertProductApplicableRules(BatchUpsertProductApplicableRulesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderPushNotice(OrderPushNoticeRequest request, String tenantId) {
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
    public MeituanResponse<?> productUploadComplete(ProductUploadCompleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopConfigUpload(ShopConfigUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopInfoUpload(ShopInfoUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopTableUpload(ShopTableUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouCouponQueryTradeDetail(TuangouCouponQueryTradeDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouselfCouponCancel(com.meituan.sdk.model.tuangouself.coupon.couponCancel.CouponCancelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouselfCouponConsume(com.meituan.sdk.model.tuangouself.coupon.couponConsume.CouponConsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouselfCouponPrepare(com.meituan.sdk.model.tuangouself.coupon.couponPrepare.CouponPrepareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> couponQuery(CouponQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
