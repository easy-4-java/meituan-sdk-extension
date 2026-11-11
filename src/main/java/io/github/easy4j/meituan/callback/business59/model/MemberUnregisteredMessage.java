package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员注销」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910149}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_f34f7833-4633-4725-98ac-a3ee75ecd32e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberUnregisteredMessage {

    /**
     * 用户Id。必填。
     */
    @JsonProperty("opUserId")
    private String opUserId;

    /**
     * 平台来源，MT_SOURCE="MT" 或 DP_SOURCE="DP"。必填。
     */
    @JsonProperty("source")
    private String source;

    /**
     * 三方卡号。必填。
     */
    @JsonProperty("memberCard")
    private String memberCard;
}
