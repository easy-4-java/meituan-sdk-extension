package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员优惠券核销」回调的业务内容。
 *
 * <p>官网未给出消息类型，可向 {@code CallbackUtil.parse} 显式传入本类型。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_321e560e-f4c9-441f-8d56-ac3e391d87c2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberCouponRedemptionMessage {

    /**
     * 会员id。
     */
    @JsonProperty("memberId")
    private String memberId;

    /**
     * 卡id。
     */
    @JsonProperty("cardId")
    private String cardId;

    /**
     * 卡号。
     */
    @JsonProperty("cardNo")
    private String cardNo;

    /**
     * 待核销的券码（建议传入Long型数值信息，长度不超过19位）。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 本次核销凭证，后续冲正基于该凭证执行，由美团侧统一提供，全局唯一。
     */
    @JsonProperty("bizId")
    private String bizId;

    /**
     * 订单信息，不传递则不计算可用券、已使用券。
     */
    @JsonProperty("orderInfo")
    private MemberCouponDiscountAllocationMessage.OrderInfoDetails orderInfo;
}
