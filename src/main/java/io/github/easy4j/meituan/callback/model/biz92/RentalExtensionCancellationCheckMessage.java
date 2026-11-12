package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「续租取消检查」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210021}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_5dbbbbd2-153e-4a1a-9760-b8d86eb23c5c">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionCancellationCheckMessage {

    /**
     * 美团主订单 ID。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;
    /**
     * 美团续租订单Id。必填。
     */
    @JsonProperty("mtRenewalOrderId")
    private Long mtRenewalOrderId;
    /**
     * 三方主订单Id。必填。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;
    /**
     * 三方续租单订单号。必填。
     */
    @JsonProperty("thirdRenewalOrderId")
    private String thirdRenewalOrderId;

    /**
     * 创建美团「续租取消检查」回调的业务内容。的空实例。
     */
    public RentalExtensionCancellationCheckMessage() {
    }
}
