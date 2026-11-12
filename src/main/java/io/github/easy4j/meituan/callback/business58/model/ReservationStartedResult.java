package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开始预订」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_c08eb5f3-ba98-4c97-8579-7d95757df2b4">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationStartedResult {

    /**
     * 订单ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 第三方的订单号。
     */
    @JsonProperty("appOrderId")
    private String appOrderId;

    /**
     * 预订手机号。
     */
    @JsonProperty("mobile")
    private String mobile;
}
