package io.github.easy4j.meituan.callback.business49.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「用户取消排队」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=49}，消息类型为 {@code msgType=4910003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_dcpd_67e64a98-431a-47d0-b8c0-f46300d1ffc3">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueueTicketCancelledMessage {

    /**
     * 美团侧订单 ID。必填。
     */
    @JsonProperty("orderViewId")
    private String orderViewId;
}
