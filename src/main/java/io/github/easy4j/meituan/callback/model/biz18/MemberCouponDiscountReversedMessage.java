package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员券优惠冲正」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810063}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_3d21b3f7-ef83-47bc-b689-cce0173a3d3b">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberCouponDiscountReversedMessage {

    /**
     * 创建美团「会员券优惠冲正」回调的业务内容。的空实例。
     */
    public MemberCouponDiscountReversedMessage() {
    }


    /**
     * 核销凭证。
     */
    @JsonProperty("bizId")
    private String bizId;

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
     * 券码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * localserver订单 ID。
     */
    @JsonProperty("localId")
    private String localId;

    /**
     * 冲正原因。
     */
    @JsonProperty("reason")
    private String reason;
}
