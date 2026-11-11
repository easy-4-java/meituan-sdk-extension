package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「退款消息推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810085}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_1aeca49f-7973-4aef-9107-bfa89c289eaa">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundNotificationMessage {

    /**
     * 组织机构 ID。必填。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 支付流水号。必填。
     */
    @JsonProperty("tradeno")
    private Long tradeno;

    /**
     * 退款单号。必填。
     */
    @JsonProperty("refundNo")
    private Long refundNo;

    /**
     * 外部退款单号。必填。
     */
    @JsonProperty("outRefundNo")
    private String outRefundNo;

    /**
     * 支付金额。必填。
     */
    @JsonProperty("totalFee")
    private Integer totalFee;

    /**
     * 支付状态。2：退款成功 3：退款失败。必填。
     */
    @JsonProperty("refundStatus")
    private Integer refundStatus;

    /**
     * 对外订单编号，外部订单号。
     */
    @JsonProperty("outOrderId")
    private String outOrderId;

    /**
     * 退款时间，支付成功的时间。必填。
     */
    @JsonProperty("refundTime")
    private String refundTime;

    /**
     * 渠道退款优惠信息。refundChannelSettleDiscount 平台支付优惠 refundChannelDiscountAmount 商家支付优惠。
     */
    @JsonProperty("refundDiscountDetailBO")
    private String refundDiscountDetailBO;
}
