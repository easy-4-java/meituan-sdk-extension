package io.github.easy4j.meituan.callback.business92.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「提前还车检查」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210025}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_449cbd33-ca5b-4625-9483-9c63f123b37e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EarlyReturnCheckMessage {

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
     * 新还车时间。必填。
     */
    @JsonProperty("newDropOffTime")
    private String newDropOffTime;
}
