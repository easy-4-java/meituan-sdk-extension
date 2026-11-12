package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「核销状态查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810023}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_c22a6603-c6b6-4b47-83bb-9752288fd4dc">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedemptionStatusQueryMessage {

    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
}
