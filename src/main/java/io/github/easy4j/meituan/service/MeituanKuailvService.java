package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.klOpen.goods.goodsPageSku.GoodsPageSkuRequest;
import com.meituan.sdk.model.klOpen.goods.goodsPageSpu.GoodsPageSpuRequest;
import com.meituan.sdk.model.klOpen.goods.queryGoodsSales.QueryGoodsSalesRequest;
import com.meituan.sdk.model.klOpen.order.cancelOrder.CancelOrderRequest;
import com.meituan.sdk.model.klOpen.order.createOrderSync.CreateOrderSyncRequest;
import com.meituan.sdk.model.klOpen.order.orderCreate.OrderCreateRequest;
import com.meituan.sdk.model.klOpen.order.orderDetail.OrderDetailRequest;

/**
 * 快驴业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanKuailvService extends MeituanService {

    /**
     * 分页查询sku。
     * <p>官方接口：{@code /kl/open/goods/page/sku}，API：{@code goods_page_sku}，版本：{@code 10002}，businessId：{@code 27}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> goodsPageSku(GoodsPageSkuRequest request, String tenantId);

    /**
     * 分页查询spu。
     * <p>官方接口：{@code /kl/open/goods/page/spu}，API：{@code goods_page_spu}，版本：{@code 10003}，businessId：{@code 27}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> goodsPageSpu(GoodsPageSpuRequest request, String tenantId);

    /**
     * 查询sku售卖信息。
     * <p>官方接口：{@code /kl/open/goods/sku/sales}，API：{@code query_goods_sales}，版本：{@code 10001}，businessId：{@code 27}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryGoodsSales(QueryGoodsSalesRequest request, String tenantId);

    /**
     * 申请取消订单。
     * <p>官方接口：{@code /kl/open/order/cancel}，API：{@code cancel_order}，版本：{@code 10006}，businessId：{@code 27}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cancelOrder(CancelOrderRequest request, String tenantId);

    /**
     * 快驴同步创建订单。
     * <p>官方接口：{@code /kl/open/order/create/sync}，API：{@code create_order_sync}，版本：{@code 10004}，businessId：{@code 27}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createOrderSync(CreateOrderSyncRequest request, String tenantId);

    /**
     * 快驴订单创建。
     * <p>官方接口：{@code /kl/open/order/create}，API：{@code order_create}，版本：{@code 10003}，businessId：{@code 27}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderCreate(OrderCreateRequest request, String tenantId);

    /**
     * 查询订单详细信息。
     * <p>官方接口：{@code /kl/open/order/detail}，API：{@code order_detail}，版本：{@code 10009}，businessId：{@code 27}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderDetail(OrderDetailRequest request, String tenantId);
}
