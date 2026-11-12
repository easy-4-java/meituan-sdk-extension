package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「退款结果回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210033}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_f5840e37-6390-4ec1-8634-a96a583d4fcf">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundResultMessage {

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
     * 商家退款流水Id。必填。
     */
    @JsonProperty("thirdRefundId")
    private String thirdRefundId;

    /**
     * 退款审核结果，详情见枚举RefundResult。必填。
     */
    @JsonProperty("refundResult")
    private String refundResult;

    /**
     * 退款金额。必填。
     */
    @JsonProperty("amount")
    private Integer amount;
}
