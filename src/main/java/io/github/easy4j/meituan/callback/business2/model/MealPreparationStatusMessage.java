package io.github.easy4j.meituan.callback.business2.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「推送订单出餐状态」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210081}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_fc2e35f0-ce97-437a-be5f-3487518fb2a2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealPreparationStatusMessage {

    /**
     * 订单 ID。
     */
    @JsonProperty("order_id")
    private Long orderId;

    /**
     * 出餐状态：1-待出餐：此状态商家可上报出餐 2-已出餐：/ 3-未出餐：此状态商家不可上报出餐。
     */
    @JsonProperty("food_done_status")
    private Integer foodDoneStatus;

    /**
     * 该状态对应的时间。
     */
    @JsonProperty("update_time")
    private String updateTime;

    /**
     * 是否超时出餐：出餐状态=「已出餐」时有值 1-超时：上报出餐时间&gt;出餐考核时间 (0) 0-未超时：上报出餐时间&lt;=出餐考核时间 (1) 2-null：未上报出餐 (2)。
     */
    @JsonProperty("on_time_status")
    private Integer onTimeStatus;

    /**
     * 未出餐类型：1-骑手已取餐 2-订单完成 3-订单取消，备注：该类型不计入「未上报出餐考核」及「不准时出餐考核」。
     */
    @JsonProperty("not_on_time_reason_type")
    private Integer notOnTimeReasonType;
}
