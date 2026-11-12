package io.github.easy4j.meituan.callback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 使用嵌套 JSON 数据的回执，例如智能版会员优惠券核销和团购已支付订单推送。
 * 按消息文档填写状态说明；要求将业务数据序列化成字符串的回调使用
 * {@link MeituanCallbackResponse#successData(Object)}。
 *
 * @param <T> 该回调约定的业务响应类型
 * @param code 平台响应码，成功为 0
 * @param message 响应说明，例如智能版收银回执使用 {@code ok}
 * @param data 直接放入响应的业务对象
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MeituanObjectCallbackResponse<T>(
        @JsonProperty("code") int code,
        @JsonProperty("message") String message,
        @JsonProperty("data") T data) {
}
