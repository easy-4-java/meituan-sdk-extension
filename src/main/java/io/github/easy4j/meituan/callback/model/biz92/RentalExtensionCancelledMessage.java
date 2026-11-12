package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「续租取消」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210023}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_ecc0df85-921a-4667-a7ae-465d8f96c2ac">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionCancelledMessage {

    /**
     * 创建美团「续租取消」回调的业务内容。的空实例。
     */
    public RentalExtensionCancelledMessage() {
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
     * 美团续租订单Id。必填。
     */
    @JsonProperty("mtRenewalOrderId")
    private Long mtRenewalOrderId;

    /**
     * 三方续租单订单号。必填。
     */
    @JsonProperty("thirdRenewalOrderId")
    private String thirdRenewalOrderId;

    /**
     * 取消时间。必填。
     */
    @JsonProperty("time")
    private String time;

    /**
     * 取消原因。
     */
    @JsonProperty("cancelReason")
    private String cancelReason;
}
