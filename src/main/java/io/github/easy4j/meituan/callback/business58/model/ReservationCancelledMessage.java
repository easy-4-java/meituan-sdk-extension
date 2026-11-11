package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「取消预订」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_0b1a03ad-7027-4045-92e2-bcde392cfd4f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCancelledMessage {

    /**
     * 取消类型，1-规则取消：用户正常规则下取消，2-非规则取消：除规则取消之外的其他取消，如用户通过开放平台客服强制取消 3：超退（客服退款）。必填。
     */
    @JsonProperty("cancelType")
    private String cancelType;

    /**
     * 技术合作中心上的订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 取消预订审核渠道，1-三方平台审核，2-技术合作中心审核。
     */
    @JsonProperty("auditChannel")
    private String auditChannel;

    /**
     * 取消预订原因。
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * 生活服务行业新增字段，其他行业不传，交易类型，枚举值，1-预订，2-团单（团购后预约），商家根据此属性字段识别交易类型，预订业务该字段非必传，团购后预约业务必传。
     */
    @JsonProperty("type")
    private String type;
}
