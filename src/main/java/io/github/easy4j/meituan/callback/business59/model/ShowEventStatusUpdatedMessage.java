package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「演出项目状态更新通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910141}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_a2c040da-23e8-4d2a-9432-0068d355e541">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowEventStatusUpdatedMessage {

    /**
     * 演出项目 ID。
     */
    @JsonProperty("showEventId")
    private Long showEventId;

    /**
     * 商家演出项目 ID。必填。
     */
    @JsonProperty("thirdPartyShowEventId")
    private String thirdPartyShowEventId;

    /**
     * 1-演出项目上架，2-演出项目下架，3-演出项目已提交，4-演出项目提交失败。必填。
     */
    @JsonProperty("messageType")
    private Integer messageType;

    /**
     * 失败原因，提交失败时才有。
     */
    @JsonProperty("failReason")
    private String failReason;
}
