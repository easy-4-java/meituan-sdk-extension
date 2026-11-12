package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单详情查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210031}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_1d80724b-a152-4d9f-9aa2-cec1e5b7e8a9">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8ba2\u5355\u8be6\u60c5\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderDetailQueryMessage() {
    }


    /**
     * 美团订单 ID。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 三方商家订单 ID （当由超时等原因不确定下单结果时，美团无法传商家订单号）。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;
}
