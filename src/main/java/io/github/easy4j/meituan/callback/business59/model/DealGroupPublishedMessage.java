package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「团单发布通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910109}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_bfc39315-dfd7-4046-b487-6d37b7e40aa9">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealGroupPublishedMessage {

    /**
     * 团单 ID。必填。
     */
    @JsonProperty("dealGroupId")
    private Long dealGroupId;

    /**
     * 是否发布成功。必填。
     */
    @JsonProperty("publishStatus")
    private Boolean publishStatus;

    /**
     * 商品上下架状态。
     */
    @JsonProperty("displayStatus")
    private String displayStatus;
}
