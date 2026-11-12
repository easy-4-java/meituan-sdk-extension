package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「美团在线支付结算明细推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810029}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_3e5b1e5e-f64e-4715-99cd-6ac2aeaeda50">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OnlinePaymentSettlementMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u7f8e\u56e2\u5728\u7ebf\u652f\u4ed8\u7ed3\u7b97\u660e\u7ec6\u63a8\u9001\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OnlinePaymentSettlementMessage() {
    }


    /**
     * 组织机构 ID。必填。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 结算日期。必填。
     */
    @JsonProperty("settleDate")
    private String settleDate;

    /**
     * 结算方式，0代表到卡，1代表到余额。必填。
     */
    @JsonProperty("settleType")
    private Integer settleType;

    /**
     * 退款金额。
     */
    @JsonProperty("refundMoney")
    private Long refundMoney;

    /**
     * 结算金额，精确到分。必填。
     */
    @JsonProperty("settleMoney")
    private Long settleMoney;

    /**
     * 手续费，精确到分。必填。
     */
    @JsonProperty("poundageMoney")
    private Long poundageMoney;

    /**
     * 交易金额，精确到分。必填。
     */
    @JsonProperty("tradeMoney")
    private Long tradeMoney;

    /**
     * 外部结算优惠金额，精确到分。必填。
     */
    @JsonProperty("channelSettleDiscountMoney")
    private Long channelSettleDiscountMoney;

    /**
     * 交易时间。必填。
     */
    @JsonProperty("tradeTime")
    private String tradeTime;

    /**
     * 支付方式。必填。
     */
    @JsonProperty("payType")
    private Integer payType;

    /**
     * 支付流水号。
     */
    @JsonProperty("payNo")
    private String payNo;

    /**
     * 退款流水号。
     */
    @JsonProperty("refundTradeNo")
    private String refundTradeNo;

    /**
     * 业务类型。必填。
     */
    @JsonProperty("businessType")
    private Integer businessType;

    /**
     * 第三方交易单号。
     */
    @JsonProperty("thirdOrderNo")
    private String thirdOrderNo;

    /**
     * 结算账户。必填。
     */
    @JsonProperty("merchantId")
    private Integer merchantId;
}
