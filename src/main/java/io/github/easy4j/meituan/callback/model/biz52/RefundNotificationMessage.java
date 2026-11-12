package io.github.easy4j.meituan.callback.model.biz52;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「收单开放平台退款通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=52}，消息类型为 {@code msgType=5210013}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_sdpt_cec8a9b2-43a4-4b4c-b841-fcfc2884c409">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundNotificationMessage {

    /**
     * 服务商业务订单号。
     */
    @JsonProperty("outOrderNo")
    private String outOrderNo;

    /**
     * 退款单号，服务商对账主键。
     */
    @JsonProperty("refundNo")
    private String refundNo;

    /**
     * 原支付单号。
     */
    @JsonProperty("transactionId")
    private String transactionId;

    /**
     * 原订单金额，单位分。
     */
    @JsonProperty("totalFee")
    private Integer totalFee;

    /**
     * 本次退款金额，单位分。
     */
    @JsonProperty("refundFee")
    private Integer refundFee;

    /**
     * 退款完成时间，时间戳单位毫秒。
     */
    @JsonProperty("refundTime")
    private Long refundTime;

    /**
     * 门店 ID。
     */
    @JsonProperty("merchantId")
    private Long merchantId;

    /**
     * 支付平台订单号。
     */
    @JsonProperty("platformOrderId")
    private String platformOrderId;

    /**
     * 用户支付渠道订单号。
     */
    @JsonProperty("channelOrderId")
    private String channelOrderId;

    /**
     * 动态二维码单号，仅动态码退款返回。
     */
    @JsonProperty("dynamicCodePaymentOrderId")
    private String dynamicCodePaymentOrderId;

    /**
     * 退款状态，当前为 REFUND_SUCCESS 表示退款成功。
     */
    @JsonProperty("refundStatus")
    private String refundStatus;

    /**
     * 服务商退款单号（业务方传入的业务退款单号）。
     */
    @JsonProperty("refundRequestNo")
    private String refundRequestNo;
}
