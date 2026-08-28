package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.rhone.mtp.orderConsumeNotice.OrderConsumeNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.orderPayNotice.OrderPayNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.orderRefundNotice.OrderRefundNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.orderRescheduleNotice.OrderRescheduleNoticeRequest;
import com.meituan.sdk.model.rhone.mtp.productLevelPriceNoticeV2.ProductLevelPriceNoticeV2Request;

/**
 * 站外分销业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanDistributionService extends MeituanService {

    /**
     * 订单消费通知。
     * <p>官方接口：{@code /rhone/mtp/api/order/consume/notice}，API：{@code order_consume_notice}，版本：{@code 10022}，businessId：{@code 66}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderConsumeNotice(OrderConsumeNoticeRequest request, String tenantId);

    /**
     * 订单出票通知。
     * <p>官方接口：{@code /rhone/mtp/api/order/pay/notice}，API：{@code order_pay_notice}，版本：{@code 10027}，businessId：{@code 66}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderPayNotice(OrderPayNoticeRequest request, String tenantId);

    /**
     * 订单退款通知。
     * <p>官方接口：{@code /rhone/mtp/api/order/refund/notice}，API：{@code order_refund_notice}，版本：{@code 10021}，businessId：{@code 66}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRefundNotice(OrderRefundNoticeRequest request, String tenantId);

    /**
     * 订单改签通知。
     * <p>官方接口：{@code /rhone/mtp/api/order/reschedule/notice}，API：{@code order_reschedule_notice}，版本：{@code 10020}，businessId：{@code 66}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRescheduleNotice(OrderRescheduleNoticeRequest request, String tenantId);

    /**
     * 多层价格日历变化通知V2。
     * <p>官方接口：{@code /rhone/mtp/api/level/price/notice/v2}，API：{@code product_level_price_notice_v2}，版本：{@code 10023}，businessId：{@code 66}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productLevelPriceNoticeV2(ProductLevelPriceNoticeV2Request request, String tenantId);
}
