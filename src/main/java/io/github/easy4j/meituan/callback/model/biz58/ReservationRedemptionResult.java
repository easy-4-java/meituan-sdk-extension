package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「预订核销同步」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_927cf9da-5294-4e0a-83c1-665d06f31b47">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationRedemptionResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u9884\u8ba2\u6838\u9500\u540c\u6b65\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationRedemptionResult() {
    }


    /**
     * 订单ID。
     */
    @JsonProperty("orderId")
    private String orderId;
}
