package io.github.easy4j.meituan.service;

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

/**
 * 到店餐饮业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanDaocanService extends MeituanService {

    /**
     * 上传总部门店关系。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/brand/chain/poi/bind}，API：{@code brand_chain_poi_bind}，版本：{@code 10025}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> brandChainPoiBind(BrandChainPoiBindRequest request, String tenantId);

    /**
     * 上传总部信息。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/brand/chain/update}，API：{@code brand_chain_update}，版本：{@code 10016}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> brandChainUpdate(BrandChainUpdateRequest request, String tenantId);

    /**
     * 上传订单信息。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/order/upload}，API：{@code order_upload}，版本：{@code 10015}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderUpload(OrderUploadRequest request, String tenantId);

    /**
     * 创建或更新菜品加价属性信息。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/addon/update}，API：{@code product_addon_update}，版本：{@code 10023}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productAddonUpdate(ProductAddonUpdateRequest request, String tenantId);

    /**
     * 上传餐盒信息。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/box/update}，API：{@code product_box_update}，版本：{@code 10019}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productBoxUpdate(ProductBoxUpdateRequest request, String tenantId);

    /**
     * 上传菜品前台类目。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/category/create}，API：{@code product_category_create}，版本：{@code 10030}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productCategoryCreate(ProductCategoryCreateRequest request, String tenantId);

    /**
     * 创建或更新菜品加料信息。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/sideDish/update}，API：{@code product_side_dish_update}，版本：{@code 10028}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productSideDishUpdate(ProductSideDishUpdateRequest request, String tenantId);

    /**
     * 更新菜品主体库存。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/sku/stock/update}，API：{@code product_sku_stock_update}，版本：{@code 10033}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productSkuStockUpdate(ProductSkuStockUpdateRequest request, String tenantId);

    /**
     * 新增/更新菜品数据。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/spu/update}，API：{@code product_spu_update}，版本：{@code 10034}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productSpuUpdate(ProductSpuUpdateRequest request, String tenantId);

    /**
     * 更新菜品主体价格。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/subject/price/update}，API：{@code product_subject_price_update}，版本：{@code 10022}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productSubjectPriceUpdate(ProductSubjectPriceUpdateRequest request, String tenantId);

    /**
     * 更新菜品主体售卖状态。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/subject/status/update}，API：{@code product_subject_status_update}，版本：{@code 10020}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productSubjectStatusUpdate(ProductSubjectStatusUpdateRequest request, String tenantId);

    /**
     * 更新桌台使用状态。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/table/status/update}，API：{@code product_table_status_update}，版本：{@code 10036}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productTableStatusUpdate(ProductTableStatusUpdateRequest request, String tenantId);

    /**
     * 上传桌台信息。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/product/table/update}，API：{@code product_table_update}，版本：{@code 10039}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productTableUpdate(ProductTableUpdateRequest request, String tenantId);

    /**
     * 查询门店授权信息。
     * <p>官方接口：{@code /tuangou/ng/atomgoods/shop/auth/info/query}，API：{@code query_shop_auth_info}，版本：{@code 10029}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryShopAuthInfo(QueryShopAuthInfoRequest request, String tenantId);

    /**
     * 商家回复评论。
     * <p>官方接口：{@code /review/reply}，API：{@code comment_reply}，版本：{@code 10000}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commentReply(CommentReplyRequest request, String tenantId);

    /**
     * 撤销验券。
     * <p>官方接口：{@code /tuangou/coupon/cancel}，API：{@code coupon_cancel}，版本：{@code 10069}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouNgCouponCancel(CouponCancelRequest request, String tenantId);

    /**
     * 执行验券。
     * <p>官方接口：{@code /tuangou/coupon/consume}，API：{@code coupon_consume}，版本：{@code 10100}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouNgCouponConsume(CouponConsumeRequest request, String tenantId);

    /**
     * 验券准备。
     * <p>官方接口：{@code /tuangou/coupon/prepare}，API：{@code coupon_prepare}，版本：{@code 10101}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouNgCouponPrepare(CouponPrepareRequest request, String tenantId);

    /**
     * 查询团购项目限制条件接口。
     * <p>官方接口：{@code /tuangou/coupon/queryDealAttr}，API：{@code coupon_query_deal_attr}，版本：{@code 10095}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryDealAttr(CouponQueryDealAttrRequest request, String tenantId);

    /**
     * 门店验券历史。
     * <p>官方接口：{@code /tuangou/coupon/queryListByDate}，API：{@code coupon_query_list_by_date}，版本：{@code 10100}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryListByDate(CouponQueryListByDateRequest request, String tenantId);

    /**
     * 门店本地验券历史。
     * <p>官方接口：{@code /tuangou/coupon/queryLocalListByDate}，API：{@code coupon_query_local_list_by_date}，版本：{@code 10100}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryLocalListByDate(CouponQueryLocalListByDateRequest request, String tenantId);

    /**
     * 查询团购订单结算扩展明细。
     * <p>官方接口：{@code /tuangou/ng/coupon/externalProfitDetailRequire}，API：{@code coupon_query_profit_by_code}，版本：{@code 10115}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryProfitByCode(CouponQueryProfitByCodeRequest request, String tenantId);

    /**
     * 门店套餐映射。
     * <p>官方接口：{@code /tuangou/coupon/querySetMealList}，API：{@code coupon_query_set_meal_list}，版本：{@code 10092}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQuerySetMealList(CouponQuerySetMealListRequest request, String tenantId);

    /**
     * 门店套餐映射；相比于coupon_query_set_meal_list拆分了隐藏状态和售卖状态。
     * <p>官方接口：{@code /tuangou/ng/coupon/querySetMealListV1}，API：{@code coupon_query_set_meal_list_v1}，版本：{@code 10109}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQuerySetMealListV1(CouponQuerySetMealListV1Request request, String tenantId);

    /**
     * 直连批量预核销接口。
     * <p>官方接口：{@code /tuangou/ng/coupon/dishconnect/batchPrepare}，API：{@code dishconnect_batch_prepare}，版本：{@code 10113}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishconnectBatchPrepare(DishconnectBatchPrepareRequest request, String tenantId);

    /**
     * 查询团购券交易快照。
     * <p>官方接口：{@code /tuangou/ng/coupon/getCouponPriceInfo}，API：{@code get_coupon_price_info}，版本：{@code 10086}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getCouponPriceInfo(GetCouponPriceInfoRequest request, String tenantId);

    /**
     * 提供开放平台的验券接口，聚合商品数据信息。
     * <p>官方接口：{@code /tuangou/ng/coupon/msconsume}，API：{@code ms_super_consume}，版本：{@code 10119}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> msSuperConsume(MsSuperConsumeRequest request, String tenantId);

    /**
     * 提供开放平台的预验券接口，聚合商品数据信息。
     * <p>官方接口：{@code /tuangou/ng/coupon/msprepare}，API：{@code ms_super_prepare}，版本：{@code 10118}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> msSuperPrepare(MsSuperPrepareRequest request, String tenantId);

    /**
     * 已验券码查询。
     * <p>官方接口：{@code /tuangou/coupon/queryById}，API：{@code query_coupon_by_id}，版本：{@code 10100}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryCouponById(QueryCouponByIdRequest request, String tenantId);

    /**
     * 根据id批量查询团购券。
     * <p>官方接口：{@code /tuangou/coupon/queryReceiptsByReceiptIds}，API：{@code query_receipts_by_receipt_ids}，版本：{@code 10091}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryReceiptsByReceiptIds(QueryReceiptsByReceiptIdsRequest request, String tenantId);

    /**
     * 查询券结算信息。
     * <p>官方接口：{@code /tuangou/coupon/queryReceiptsByReceiptIds}，API：{@code receipts_by_receipt_ids}，版本：{@code 10000}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> receiptsByReceiptIds(ReceiptsByReceiptIdsRequest request, String tenantId);

    /**
     * 查询买单订单结算扩展明细。
     * <p>官方接口：{@code /tuangou/ng/group_voucher/externalProfitDetailRequireMaidan}，API：{@code coupon_query_profit_by_code_maidan}，版本：{@code 10013}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQueryProfitByCodeMaidan(CouponQueryProfitByCodeMaidanRequest request, String tenantId);

    /**
     * 查询代金券买单信息。
     * <p>官方接口：{@code /tuangou/ng/group_voucher/order/query}，API：{@code groupvoucher_order_query}，版本：{@code 10016}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupvoucherOrderQuery(GroupvoucherOrderQueryRequest request, String tenantId);

    /**
     * 代金券买单申请退款。
     * <p>官方接口：{@code /tuangou/ng/group_voucher/order/refund}，API：{@code groupvoucher_order_refund}，版本：{@code 10018}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupvoucherOrderRefund(GroupvoucherOrderRefundRequest request, String tenantId);

    /**
     * 代金券买单信息与厂商收银订单（或者收银键位）关联。
     * <p>官方接口：{@code /tuangou/ng/group_voucher/order/relate}，API：{@code groupvoucher_order_relate}，版本：{@code 10015}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupvoucherOrderRelate(GroupvoucherOrderRelateRequest request, String tenantId);

    /**
     * 门店一键买单配置信息查询。
     * <p>官方接口：{@code /tuangou/ng/group_voucher/shop/maidan_info}，API：{@code groupvoucher_shop_maidani_info}，版本：{@code 10011}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupvoucherShopMaidaniInfo(GroupvoucherShopMaidaniInfoRequest request, String tenantId);

    /**
     * 开通/关闭代金券买单。
     * <p>官方接口：{@code /tuangou/ng/group_voucher/shop/manage}，API：{@code groupvoucher_shop_manage}，版本：{@code 10003}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> groupvoucherShopManage(GroupvoucherShopManageRequest request, String tenantId);

    /**
     * 批量上传/更新团购映射/代金券适用规则。
     * <p>官方接口：{@code /tuangou/ng/smar/product/rule/upload}，API：{@code batch_upsert_product_applicable_rules}，版本：{@code 10002}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpsertProductApplicableRules(BatchUpsertProductApplicableRulesRequest request, String tenantId);

    /**
     * 美团推单后，品牌商家确认接单结果。
     * <p>官方接口：{@code /tuangou/ng/smar/order/pushNotice}，API：{@code order_push_notice}，版本：{@code 10012}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderPushNotice(OrderPushNoticeRequest request, String tenantId);

    /**
     * 商家请求订单退款。
     * <p>官方接口：{@code /tuangou/ng/smar/order/refund}，API：{@code order_refund}，版本：{@code 10011}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRefund(OrderRefundRequest request, String tenantId);

    /**
     * 商品数据推送完成通知【必接】。
     * <p>官方接口：{@code /tuangou/ng/smar/product/upload/complete}，API：{@code product_upload_complete}，版本：{@code 10003}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUploadComplete(ProductUploadCompleteRequest request, String tenantId);

    /**
     * 门店配置上传【必接】。
     * <p>官方接口：{@code /tuangou/ng/smar/shop/config/upload}，API：{@code shop_config_upload}，版本：{@code 10015}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopConfigUpload(ShopConfigUploadRequest request, String tenantId);

    /**
     * 上传门店信息【必接】。
     * <p>官方接口：{@code /tuangou/ng/smar/shop/info/upload}，API：{@code shop_info_upload}，版本：{@code 10008}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopInfoUpload(ShopInfoUploadRequest request, String tenantId);

    /**
     * 上传桌台【必接】。
     * <p>官方接口：{@code /tuangou/ng/smar/shop/table/upload}，API：{@code shop_table_upload}，版本：{@code 10017}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopTableUpload(ShopTableUploadRequest request, String tenantId);

    /**
     * 查询团购订单结算明细。
     * <p>官方接口：{@code /tuangou/coupon/queryTradeDetail}，API：{@code tuangou_coupon_query_trade_detail}，版本：{@code 10001}，businessId：{@code 1}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouCouponQueryTradeDetail(TuangouCouponQueryTradeDetailRequest request, String tenantId);

    /**
     * 撤销验券。
     * <p>官方接口：{@code /tuangouself/coupon/cancel}，API：{@code coupon_cancel}，版本：{@code 10015}，businessId：{@code 33}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouselfCouponCancel(com.meituan.sdk.model.tuangouself.coupon.couponCancel.CouponCancelRequest request, String tenantId);

    /**
     * 执行验券。
     * <p>官方接口：{@code /tuangouself/coupon/consume}，API：{@code coupon_consume}，版本：{@code 10026}，businessId：{@code 33}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouselfCouponConsume(com.meituan.sdk.model.tuangouself.coupon.couponConsume.CouponConsumeRequest request, String tenantId);

    /**
     * 验券准备。
     * <p>官方接口：{@code /tuangouself/coupon/prepare}，API：{@code coupon_prepare}，版本：{@code 10024}，businessId：{@code 33}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouselfCouponPrepare(com.meituan.sdk.model.tuangouself.coupon.couponPrepare.CouponPrepareRequest request, String tenantId);

    /**
     * 查询用户授权门店可核销券。
     * <p>官方接口：{@code /tuangouself/coupon/query}，API：{@code coupon_query}，版本：{@code 10025}，businessId：{@code 33}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> couponQuery(CouponQueryRequest request, String tenantId);
}
