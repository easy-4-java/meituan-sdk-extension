package io.github.easy4j.meituan.callback.business61.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「ORDER_CLOSE」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=61}，消息类型为 {@code msgType=6110003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_outdistribution_e43fa49a-cdce-4a21-89f8-7e0218601ff6">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCloseMessage {

    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private Long orderId;
}
