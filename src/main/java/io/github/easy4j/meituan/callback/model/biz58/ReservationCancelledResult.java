package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「取消预订」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_0b1a03ad-7027-4045-92e2-bcde392cfd4f">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCancelledResult {

    /**
     * 订单id。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
}
