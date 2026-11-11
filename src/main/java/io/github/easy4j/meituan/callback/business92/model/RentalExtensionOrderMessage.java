package io.github.easy4j.meituan.callback.business92.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单续租下单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210039}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_56c92d5f-85c5-40e2-a1d1-942a6bc279eb">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionOrderMessage {

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
     * 美团续租单订单Id。必填。
     */
    @JsonProperty("mtRenewalOrderId")
    private Long mtRenewalOrderId;

    /**
     * 续租报价 ID。必填。
     */
    @JsonProperty("quoteId")
    private String quoteId;

    /**
     * 续租总金额。必填。
     */
    @JsonProperty("totalAmount")
    private Integer totalAmount;

    /**
     * 期望续租截止时间。必填。
     */
    @JsonProperty("newDropOffTime")
    private String newDropOffTime;

    /**
     * 共担优惠信息。
     */
    @JsonProperty("coCouponInfo")
    private List<CoCouponInfo> coCouponInfo;
}
