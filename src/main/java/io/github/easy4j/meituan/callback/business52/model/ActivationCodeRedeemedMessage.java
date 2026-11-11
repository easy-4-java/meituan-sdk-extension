package io.github.easy4j.meituan.callback.business52.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「激活码核销的通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=52}，消息类型为 {@code msgType=5210006}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_sdpt_616c5363-83ee-4415-b05f-43216ae9fed9">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivationCodeRedeemedMessage {

    /**
     * 激活码。必填。
     */
    @JsonProperty("actCode")
    private String actCode;

    /**
     * 商户号，登录使用。必填。
     */
    @JsonProperty("tenantNo")
    private String tenantNo;

    /**
     * 激活状态，1未激活 2已激活。必填。
     */
    @JsonProperty("status")
    private Integer status;
}
