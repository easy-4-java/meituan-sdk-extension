package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「二次退款通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810245}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_5d5c559c-f667-4f69-8645-9338284c984b">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecondaryRefundMessage {

    /**
     * 创建美团「二次退款通知」回调的业务内容。的空实例。
     */
    public SecondaryRefundMessage() {
    }


    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 退款金额, 以分为单位。必填。
     */
    @JsonProperty("refundAmount")
    private Long refundAmount;

    /**
     * 退款原因。必填。
     */
    @JsonProperty("refundReason")
    private String refundReason;
}
