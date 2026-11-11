package io.github.easy4j.meituan.callback.business92.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「押金扣款退款结果回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210037}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_9a014959-e27d-42ae-b665-081ef730173d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositDeductionRefundResultMessage {

    /**
     * 美团订单号。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 供应商订单号。必填。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;

    /**
     * 商家扣款流水号。必填。
     */
    @JsonProperty("thirdDeductId")
    private String thirdDeductId;

    /**
     * 美团扣款退款流水号。必填。
     */
    @JsonProperty("mtRefundId")
    private String mtRefundId;

    /**
     * 商家扣款退款流水号。必填。
     */
    @JsonProperty("thirdRefundId")
    private String thirdRefundId;

    /**
     * 退款结果，详情见枚举RefundResult。必填。
     */
    @JsonProperty("refundResult")
    private String refundResult;

    /**
     * 退款金额。必填。
     */
    @JsonProperty("amount")
    private Integer amount;

    /**
     * 退款时间，格式 {@code yyyy-MM-dd HH:mm:ss}。必填。
     */
    @JsonProperty("time")
    private String time;
}
