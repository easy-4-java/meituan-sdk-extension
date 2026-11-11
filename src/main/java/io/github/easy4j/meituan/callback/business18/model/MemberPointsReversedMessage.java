package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员积分冲正」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810067}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_d2e18e80-ddeb-44b0-9365-e0980e15ec9f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPointsReversedMessage {

    /**
     * 会员 ID。
     */
    @JsonProperty("memberId")
    private String memberId;

    /**
     * 卡 ID。
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
     * 撤销流水号。
     */
    @JsonProperty("bizId")
    private String bizId;

    /**
     * 原因。
     */
    @JsonProperty("reason")
    private String reason;
}
