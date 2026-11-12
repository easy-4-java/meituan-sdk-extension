package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单续租预校验」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210019}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_9ee76877-45b1-4432-b44b-ed299e44175d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionPrecheckMessage {

    /**
     * 创建美团「订单续租预校验」回调的业务内容。的空实例。
     */
    public RentalExtensionPrecheckMessage() {
    }


    /**
     * 美团订单 ID。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 三方商家订单 ID。必填。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;

    /**
     * 报价Id。必填。
     */
    @JsonProperty("quoteId")
    private String quoteId;

    /**
     * 总金额。必填。
     */
    @JsonProperty("totalAmount")
    private Integer totalAmount;

    /**
     * 期望续租截止时间。必填。
     */
    @JsonProperty("newDropOffTime")
    private String newDropOffTime;

    /**
     * 美团续租订单 ID。
     */
    @JsonProperty("mtRenewalOrderId")
    private Long mtRenewalOrderId;
}
