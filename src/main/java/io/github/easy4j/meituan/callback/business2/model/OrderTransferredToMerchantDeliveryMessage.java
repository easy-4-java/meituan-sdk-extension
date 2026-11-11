package io.github.easy4j.meituan.callback.business2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收美团配送转自配送消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210031}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_92f54148-a06c-452e-a9ec-52138f2518a5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTransferredToMerchantDeliveryMessage {

    /**
     * 订单配送方式转自配变更类型（1：美团配送转为自配送）。
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 配送方式（自配：0000）。
     */
    @JsonProperty("logisticsCode")
    private String logisticsCode;
}
