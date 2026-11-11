package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「预订退款失败通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810251}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_0274c0a7-c408-4f2d-bb03-0ed1bf40f09f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationRefundFailedMessage {

    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 原因。必填。
     */
    @JsonProperty("reason")
    private String reason;
}
