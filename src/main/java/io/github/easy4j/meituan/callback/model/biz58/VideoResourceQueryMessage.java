package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询视频资源」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810097}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_8ea56270-db80-4f0f-9e8c-60293f6e554d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoResourceQueryMessage {

    /**
     * 美团门店 ID（混淆）。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 用户手机号。必填。
     */
    @JsonProperty("phone")
    private String phone;
}
