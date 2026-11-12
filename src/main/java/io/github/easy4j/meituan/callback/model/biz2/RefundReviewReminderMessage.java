package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收用户催商家审核退款消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210083}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_ca998471-e428-4ae4-9556-d181aedb0239">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundReviewReminderMessage {

    /**
     * 订单 ID。
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 退款单唯一标识。
     */
    @JsonProperty("refund_id")
    private String refundId;

    /**
     * 用户催促审核时间点。
     */
    @JsonProperty("urge_time")
    private String urgeTime;

    /**
     * 审核截止时间点。
     */
    @JsonProperty("left_time")
    private String leftTime;

    /**
     * 时间戳。
     */
    @JsonProperty("timestamp")
    private String timestamp;
}
