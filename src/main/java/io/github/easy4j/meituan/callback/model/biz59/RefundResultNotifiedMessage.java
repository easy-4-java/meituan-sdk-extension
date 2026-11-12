package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「退款结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910083}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_eda2b789-7728-4c6e-8318-45dc72afe83d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundResultNotifiedMessage {

    /**
     * 创建美团「退款结果通知」回调的业务内容。的空实例。
     */
    public RefundResultNotifiedMessage() {
    }


    /**
     * 通知创建时间，时间戳，精度毫秒。
     */
    @JsonProperty("createTime")
    private Long createTime;

    /**
     * 通知类型 REFUND.SUCCESS：退款成功通知。
     */
    @JsonProperty("type")
    private String type;

    /**
     * 退款相关信息json字符串。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("msg")
    private MsgDetails msg;

    /**
     * 退款相关信息json字符串。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MsgDetails {

        /**
         * 创建退款相关信息json字符串。的空实例。
         */
        public MsgDetails() {
        }


        /**
         * 美团退款单号。
         */
        @JsonProperty("refundId")
        private String refundId;

        /**
         * 商户退款号。
         */
        @JsonProperty("vendorRefundId")
        private String vendorRefundId;

        /**
         * 美团订单号。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 商户订单号。
         */
        @JsonProperty("vendorOrderId")
        private String vendorOrderId;

        /**
         * 退款成功时间，时间戳，精度毫秒 *退款成功状态时存在。
         */
        @JsonProperty("successTime")
        private Long successTime;

        /**
         * 退款申请时间，时间戳，精度毫秒。
         */
        @JsonProperty("createTime")
        private Long createTime;

        /**
         * 外部传入的自定义数据。
         */
        @JsonProperty("refundExt")
        private String refundExt;

        /**
         * 退给用户实付金额，单位：分，退款成功时存在。
         */
        @JsonProperty("totalRefundAmount")
        private Long totalRefundAmount;
    }
}
