package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「加价尾单核销通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810099}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_66fc027d-ab11-4fa0-b2eb-066b0acd7263">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurchargeOrderRedeemedMessage {

    /**
     * 用户手机号。必填。
     */
    @JsonProperty("phone")
    private String phone;

    /**
     * 团购 ID。必填。
     */
    @JsonProperty("dealGroupId")
    private Long dealGroupId;

    /**
     * 团购标题。必填。
     */
    @JsonProperty("dealName")
    private String dealName;

    /**
     * 订单总金额，金额=首单金额+尾单金额。必填。
     */
    @JsonProperty("amount")
    private String amount;

    /**
     * 首单订单 ID。必填。
     */
    @JsonProperty("firstOrderId")
    private String firstOrderId;

    /**
     * 首单券码，多个用“,”分割。必填。
     */
    @JsonProperty("firstOrderCode")
    private String firstOrderCode;

    /**
     * 首单实付金额。必填。
     */
    @JsonProperty("firstOrderActualPrice")
    private String firstOrderActualPrice;

    /**
     * 尾单订单 ID。必填。
     */
    @JsonProperty("finalOrderId")
    private String finalOrderId;

    /**
     * 尾单券码，多个用“,”分割。必填。
     */
    @JsonProperty("finalOrderCode")
    private String finalOrderCode;

    /**
     * 尾单实付金额。必填。
     */
    @JsonProperty("finalOrderActualPrice")
    private String finalOrderActualPrice;

    /**
     * 首单商家优惠金额。
     */
    @JsonProperty("firstOrderDiscountAmount")
    private String firstOrderDiscountAmount;

    /**
     * 尾单商家优惠金额。
     */
    @JsonProperty("finalOrderDiscountAmount")
    private String finalOrderDiscountAmount;

    /**
     * 团单价。
     */
    @JsonProperty("dealUnitAmount")
    private String dealUnitAmount;

    /**
     * 首单金额。必填。
     */
    @JsonProperty("firstOrderPrice")
    private String firstOrderPrice;

    /**
     * 尾单金额。必填。
     */
    @JsonProperty("finalOrderPrice")
    private String finalOrderPrice;
}
