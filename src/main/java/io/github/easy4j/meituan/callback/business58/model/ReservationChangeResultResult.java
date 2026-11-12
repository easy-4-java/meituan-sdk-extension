package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「改约结果通知三方」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_a0fbb149-f754-444e-ae81-2792d460d6c6">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationChangeResultResult {

    /**
     * 平台订单id。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 三方订单id。
     */
    @JsonProperty("appOrderId")
    private String appOrderId;
}
