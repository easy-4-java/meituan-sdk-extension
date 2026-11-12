package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「用户撤销退款通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_3a4f32f3-1ee6-4db5-b411-031469e6df4f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundWithdrawnMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u7528\u6237\u64a4\u9500\u9000\u6b3e\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public RefundWithdrawnMessage() {
    }


    /**
     * 订单编号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
}
