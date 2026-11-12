package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「俱乐部活动审核结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910101}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_cc1c6e1a-a79a-4886-b9b1-c11357283d58">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubActivityAuditResultMessage {

    /**
     * 创建美团「俱乐部活动审核结果通知」回调的业务内容。的空实例。
     */
    public ClubActivityAuditResultMessage() {
    }


    /**
     * 三方平台活动 ID。必填。
     */
    @JsonProperty("activityId")
    private String activityId;

    /**
     * 是否审核通过。必填。
     */
    @JsonProperty("success")
    private Boolean success;

    /**
     * 不通过原因。
     */
    @JsonProperty("failReason")
    private String failReason;
}
