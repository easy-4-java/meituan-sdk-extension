package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「取消连续包月通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810241}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_dcc3a1b9-a6ab-4f0d-8d63-9c0d25938a0d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthlySubscriptionCancelledMessage {

    /**
     * 首单订单号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
}
