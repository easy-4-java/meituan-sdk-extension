package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员储值核销」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810069}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_4b56b8c3-8ea6-4d6c-848f-38847e3107ad">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoredValueRedeemedMessage {

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
     * 本次核销前，订单待支付金额/分。
     */
    @JsonProperty("receivable")
    private Long receivable;
    /**
     * 核销凭证。
     */
    @JsonProperty("bizId")
    private String bizId;
    /**
     * 期望使用资产的数量。
     */
    @JsonProperty("expectedUseCount")
    private Long expectedUseCount;
    /**
     * 期望资产抵扣的金额。
     */
    @JsonProperty("expectedUseAmount")
    private Long expectedUseAmount;

    /**
     * 创建美团「会员储值核销」回调的业务内容。的空实例。
     */
    public StoredValueRedeemedMessage() {
    }
}
