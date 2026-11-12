package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员搜索」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810055}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_f4c3c8ac-0457-48e4-993e-bed7df3dc8ba">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberSearchMessage {

    /**
     * 搜索关键字。必填。
     */
    @JsonProperty("identity")
    private String identity;

    /**
     * 搜索类型。必填。
     */
    @JsonProperty("type")
    private Integer type;
}
