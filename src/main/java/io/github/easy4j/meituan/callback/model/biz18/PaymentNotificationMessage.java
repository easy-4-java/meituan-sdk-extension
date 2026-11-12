package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「支付回调消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810083}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_5f5427a2-f4cf-4793-b29a-bf865a92c167">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentNotificationMessage {

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
     * 支付金额。必填。
     */
    @JsonProperty("totalFee")
    private Integer totalFee;
    /**
     * 支付状态。2：支付成功 3：支付失败 13：交易全退 14：支付关单 16：交易半退。必填。
     */
    @JsonProperty("payStatus")
    private Integer payStatus;
    /**
     * 对外订单编号，外部订单号。
     */
    @JsonProperty("outOrderId")
    private String outOrderId;
    /**
     * 交易时间，支付成功的时间。必填。
     */
    @JsonProperty("payTime")
    private String payTime;
    /**
     * 渠道单号，支付宝微信的支付单号。
     */
    @JsonProperty("pTradeno")
    private String pTradeno;
    /**
     * 用户信息，支付宝微信的用户 ID。必填。
     */
    @JsonProperty("openId")
    private String openId;
    /**
     * 渠道优惠信息，channelSettleDiscount 平台支付优惠 channelDiscountAmount 商家支付优惠。
     */
    @JsonProperty("discountDetailBO")
    private String discountDetailBO;

    /**
     * 创建美团「支付回调消息」回调的业务内容。的空实例。
     */
    public PaymentNotificationMessage() {
    }
}
