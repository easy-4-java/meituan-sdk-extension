package io.github.easy4j.meituan.callback.business3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 闪惠接收订单推送的回执。
 *
 * @param data 成功接收订单时固定为 {@code ok}
 * @see <a href="https://developer.meituan.com/docs/msg/msg_shanhuing_164350be-4000-43c9-ac87-892c907749c3">闪惠接收订单推送</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FlashOrderAcknowledgement(@JsonProperty("data") String data) {
}
