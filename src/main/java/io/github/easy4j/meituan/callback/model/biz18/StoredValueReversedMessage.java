package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员储值冲正」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810071}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_9c5cf71e-e998-411b-9bcd-974022856214">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoredValueReversedMessage {

    /**
     * 会员 ID。必填。
     */
    @JsonProperty("memberId")
    private String memberId;
    /**
     * 卡 ID。必填。
     */
    @JsonProperty("cardId")
    private String cardId;
    /**
     * 卡号。
     */
    @JsonProperty("cardNo")
    private String cardNo;
    /**
     * localserver订单 ID。
     */
    @JsonProperty("localId")
    private String localId;
    /**
     * 撤销流水号。必填。
     */
    @JsonProperty("bizId")
    private String bizId;
    /**
     * 原因。必填。
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * 创建美团「会员储值冲正」回调的业务内容。的空实例。
     */
    public StoredValueReversedMessage() {
    }
}
