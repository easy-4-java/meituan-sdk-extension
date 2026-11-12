package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「预订核销同步」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810031}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_927cf9da-5294-4e0a-83c1-665d06f31b47">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationRedemptionMessage {

    /**
     * 技术合作中心订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
    /**
     * 核销状态，2-核销成功。必填。
     */
    @JsonProperty("verifyStatus")
    private String verifyStatus;
    /**
     * 核销渠道，1-第三方平台核销，3-开店宝手动核销，4-超时自动核销。必填。
     */
    @JsonProperty("verifyChannel")
    private String verifyChannel;
    /**
     * 生活服务行业新增字段，其他行业不传，交易类型，枚举值：1-预订，2-团单（团购后预约），商家根据此属性字段识别交易类型，预订业务该字段非必传，团购后预约业务必传。
     */
    @JsonProperty("type")
    private String type;
    /**
     * 逗号分隔的券码。
     */
    @JsonProperty("serialNumber")
    private String serialNumber;

    /**
     * 创建美团「预订核销同步」回调的业务内容。的空实例。
     */
    public ReservationRedemptionMessage() {
    }
}
