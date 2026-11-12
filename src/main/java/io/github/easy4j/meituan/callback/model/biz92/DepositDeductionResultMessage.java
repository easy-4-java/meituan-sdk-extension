package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「押金扣款结果回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210035}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_3b5ec62b-dfc5-4028-ac8a-9a3259996029">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositDeductionResultMessage {

    /**
     * 美团订单号。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;
    /**
     * 三方商订单号。必填。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;
    /**
     * 三方扣款流水号。必填。
     */
    @JsonProperty("thirdDeductId")
    private String thirdDeductId;
    /**
     * 美团扣款流水。必填。
     */
    @JsonProperty("mtDeductId")
    private String mtDeductId;
    /**
     * 状态见枚举DeductResult。必填。
     */
    @JsonProperty("deductResult")
    private String deductResult;
    /**
     * 扣款金额。必填。
     */
    @JsonProperty("amount")
    private Integer amount;

    /**
     * 创建美团「押金扣款结果回调」回调的业务内容。的空实例。
     */
    public DepositDeductionResultMessage() {
    }
}
