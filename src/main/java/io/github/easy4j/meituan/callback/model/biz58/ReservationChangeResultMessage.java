package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「改约结果通知三方」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810007}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_a0fbb149-f754-444e-ae81-2792d460d6c6">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationChangeResultMessage {

    /**
     * 平台订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 平台商品 ID。必填。
     */
    @JsonProperty("productId")
    private String productId;

    /**
     * 改约结果，2-成功，3-失败。必填。
     */
    @JsonProperty("changeOrderResult")
    private String changeOrderResult;

    /**
     * 生活服务行业新增字段，其他行业不传，交易类型，枚举值：1-预订，2-团单（团购后预约），商家根据此属性字段识别交易类型，预订业务该字段非必传，团购后预约业务必传。
     */
    @JsonProperty("type")
    private String type;
}
