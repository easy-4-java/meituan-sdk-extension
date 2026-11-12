package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「隐私号-降级回调接口【必须】」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210019}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_b5c80c79-d168-49c0-80b8-54b5303bedcf">官网消息文档</a>
 */
@CallbackPayload("")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrivacyNumberFallbackMessage {

    /**
     * 开发者 ID。
     */
    @JsonProperty("developerId")
    private String developerId;

    /**
     * 隐私号消息推送时间戳。
     */
    @JsonProperty("timestamp")
    private String timestamp;

    /**
     * 签名。
     */
    @JsonProperty("sign")
    private String sign;
}
