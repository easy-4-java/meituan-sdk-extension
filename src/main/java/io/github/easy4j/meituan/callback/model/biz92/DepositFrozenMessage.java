package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「押金冻结通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210027}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_69082f18-a384-4785-a789-acf1a2c470b3">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositFrozenMessage {

    /**
     * 创建美团「押金冻结通知」回调的业务内容。的空实例。
     */
    public DepositFrozenMessage() {
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
     * 冻结订单号。必填。
     */
    @JsonProperty("freezeOrderId")
    private String freezeOrderId;

    /**
     * 冻结金额。必填。
     */
    @JsonProperty("amount")
    private Integer amount;

    /**
     * 详情见枚举DepositChannel。必填。
     */
    @JsonProperty("channel")
    private String channel;
}
