package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * 美团「取消预订审核」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810013}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_dc9fb7af-c0a2-4702-a9f5-f55866ebfe97">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCancellationReviewMessage {

    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
    /**
     * 发起取消预订的原因。
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * 生活服务行业新增字段，其他行业不传，交易类型，枚举值：1-预订，2-团单（团购后预约），商家根据此属性字段识别交易类型，预订业务该字段非必传，团购后预约业务必传。
     */
    @JsonProperty("type")
    private String type;
    /**
     * 是否为阶梯退，true-是，false-不是。
     */
    @JsonProperty("isTieredRefund")
    private String isTieredRefund;
    /**
     * 是否收取取消罚金(仅用户发起退款时才可能会收取)，0-不收取，1-收取(棋牌统一为15%比例收取)。
     */
    @JsonProperty("isCancelPenalties")
    private String isCancelPenalties;
    /**
     * 订单关联的续时订单列表；当存在续时单是，此字段必传，当有多个订单时传多个值;JsonString格式。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("subOrderIds")
    private List<String> subOrderIds;

    /**
     * 创建美团「取消预订审核」回调的业务内容。的空实例。
     */
    public ReservationCancellationReviewMessage() {
    }
}
