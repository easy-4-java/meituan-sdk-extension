package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「支付结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910081}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_94529cae-263a-41ed-bbdc-4e5793ffcf50">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResultNotifiedMessage {

    /**
     * 创建美团「支付结果通知」回调的业务内容。的空实例。
     */
    public PaymentResultNotifiedMessage() {
    }


    /**
     * 通知创建时间，时间戳，精度毫秒。
     */
    @JsonProperty("createTime")
    private Long createTime;

    /**
     * 支付相关信息json字符串。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("msg")
    private MsgDetails msg;

    /**
     * 支付相关信息json字符串。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MsgDetails {

        /**
         * 创建支付相关信息json字符串。的空实例。
         */
        public MsgDetails() {
        }


        /**
         * 单次支付业务订单返回此信息。
         */
        @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
        @JsonProperty("orderInfoRes")
        private OrderInfoRes orderInfoRes;

        /**
         * 支付结果。
         */
        @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
        @JsonProperty("payInfo")
        private PayInfo payInfo;

        /**
         * 三方透传自定义支付参数。
         */
        @JsonProperty("vendorPayInfo")
        private String vendorPayInfo;

        /**
         * 单次支付业务订单返回此信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderInfoRes {

            /**
             * 创建单次支付业务订单返回此信息。的空实例。
             */
            public OrderInfoRes() {
            }


            /**
             * 美团订单 ID。
             */
            @JsonProperty("orderId")
            private Long orderId;

            /**
             * 商户订单号。
             */
            @JsonProperty("vendorOrderId")
            private String vendorOrderId;

            /**
             * 用户在商户侧的下单时间，时间戳。
             */
            @JsonProperty("vendorOrderTime")
            private Long vendorOrderTime;

            /**
             * 用户实付总金额。
             */
            @JsonProperty("payTotalAmount")
            private Long payTotalAmount;

            /**
             * 订单状态 UN_PAID：待支付 SUCCESS：成功 TRADE_FAIL：交易失败 CANCEL：已取消。
             */
            @JsonProperty("orderStatus")
            private String orderStatus;

            /**
             * 下单传递的商户订单扩展信息。
             */
            @JsonProperty("orderExt")
            private String orderExt;

            /**
             * 支付方式描述。
             */
            @JsonProperty("payTypeTxt")
            private String payTypeTxt;

            /**
             * 支付成功时间。
             */
            @JsonProperty("successTime")
            private Long successTime;

            /**
             * 收银台流水号。
             */
            @JsonProperty("tradeNo")
            private String tradeNo;
        }

        /**
         * 支付结果。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PayInfo {

            /**
             * 创建支付结果。的空实例。
             */
            public PayInfo() {
            }


            /**
             * 美团订单 ID。
             */
            @JsonProperty("orderId")
            private Long orderId;

            /**
             * 商户订单号。
             */
            @JsonProperty("vendorOrderId")
            private String vendorOrderId;

            /**
             * 美团订单支付 ID。
             */
            @JsonProperty("orderPaymentId")
            private String orderPaymentId;

            /**
             * 商户支付Id。
             */
            @JsonProperty("vendorPaymentId")
            private String vendorPaymentId;

            /**
             * 用户实付总金额。
             */
            @JsonProperty("payAmount")
            private Long payAmount;

            /**
             * 支付状态 UN_PAID：待支付 SUCCESS：成功。
             */
            @JsonProperty("payStatus")
            private String payStatus;

            /**
             * 支付方式描述。
             */
            @JsonProperty("payTypeTxt")
            private String payTypeTxt;

            /**
             * 支付成功时间 *支付成功状态时存在。
             */
            @JsonProperty("successTime")
            private Long successTime;

            /**
             * 收银台流水号。
             */
            @JsonProperty("tradeNo")
            private String tradeNo;

            /**
             * 分期支付号。
             */
            @JsonProperty("batchNo")
            private Integer batchNo;

            /**
             * 本次支付关联的消费项列表。
             */
            @JsonProperty("consumeItemList")
            private List<ConsumeItem> consumeItemList;

            /**
             * 本次支付关联的消费项列表。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ConsumeItem {

                /**
                 * 创建本次支付关联的消费项列表。的空实例。
                 */
                public ConsumeItem() {
                }


                /**
                 * 消费项 ID。
                 */
                @JsonProperty("consumeItemId")
                private Long consumeItemId;

                /**
                 * 商家sku id，如无则置空。
                 */
                @JsonProperty("vendorSkuId")
                private String vendorSkuId;

                /**
                 * 到店商品平台商品 ID，如无则置为默认值0L。
                 */
                @JsonProperty("skuId")
                private Long skuId;
            }
        }
    }
}
