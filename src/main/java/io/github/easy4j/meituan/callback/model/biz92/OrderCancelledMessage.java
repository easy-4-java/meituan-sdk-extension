package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单取消」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210015}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_7279603f-72ae-4904-8fb4-81ba0362f4e5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCancelledMessage {

    /**
     * 美团订单 ID。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 三方商家订单 ID（当兜底给用户退款时，可能无商家订单号）。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;

    /**
     * 取消时间。必填。
     */
    @JsonProperty("cancelTime")
    private String cancelTime;

    /**
     * 取消类型，详情可见枚举。必填。
     */
    @JsonProperty("cancelType")
    private String cancelType;

    /**
     * 取消原因。
     */
    @JsonProperty("cancelReason")
    private String cancelReason;
}
