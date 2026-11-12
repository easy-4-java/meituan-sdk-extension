package io.github.easy4j.meituan.callback.model.biz49;

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
     * 创建\u7f8e\u56e2\u300c\u7528\u6237\u53d6\u6d88\u6392\u961f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public QueueTicketCancelledMessage() {
    }


    /**
     * 美团侧订单 ID。必填。
     */
    @JsonProperty("orderViewId")
    private String orderViewId;
}
