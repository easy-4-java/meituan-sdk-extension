package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「用户撤销退款通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_3a4f32f3-1ee6-4db5-b411-031469e6df4f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundWithdrawnMessage {

    /**
     * 订单编号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
}
