package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「美团平台订单状态变更通知（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_1578f703-51d9-408d-8115-81600e6bda31">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformOrderStatusChangeMessage {

    /**
     * 美团平台订单 ID。必填。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 商户门店编号。必填。
     */
    @JsonProperty("vendorShopId")
    private String vendorShopId;

    /**
     * 处理时间。必填。
     */
    @JsonProperty("handlerTime")
    private Long handlerTime;

    /**
     * 通知类型： APPLY_REFUND(1, "申请退款"), CONSUMED(2, "订单消费完成"), MODIFY(3, "修改订单") ； TIMEOUT_CLOSE(4, "接单超时")：！！！商家5min不接单美团会持续发起接单超时通知，商家收到此通知后需要调用订单确认接口，决策接单 or 拒单；CANCELED（5, "订单取消"）：若为超时自动取消，此时，操作人为“系统”，其余非必填字段不传，若为用户主动取消，此时，操作人为“C端用户”，其余非必填字段不传；REFUND_SUCCESS(6,"退款成功"): 支持商家对美团客服发起的退款免审核，免审退款的操作人类型字段会被设为“客服”，退款原因字段会被设为“门店已同意退款，美团客服代为操作”。必填。
     */
    @JsonProperty("actionType")
    private Integer actionType;

    /**
     * 操作人： USER(1, "C端用户"), CUSTOMER(2, "客服"), SYSTEM(3, "系统")。必填。
     */
    @JsonProperty("operatorType")
    private Integer operatorType;

    /**
     * 是否是错店取餐（在ActionTypeEnum是CONSUMED才有意义）。
     */
    @JsonProperty("takenInDiffPoi")
    private Boolean takenInDiffPoi;

    /**
     * 退款原因(在ActionTypeEnum等于APPLY_REFUND才有意义)。
     */
    @JsonProperty("refundReason")
    private String refundReason;

    /**
     * 订单修改类型（如果是修改订单时必传）： TAKE_TIME(1, "修改取餐时间"), ORDER_TYPE_FROM_BOOKING_TO_REAL(2, "预约单即刻取餐");
     */
    @JsonProperty("orderModifyType")
    private Integer orderModifyType;

    /**
     * 修改取餐时间（在ActionTypeEnum是MODIFY并且orderModifyType等于TAKE_TIME才有意义）。
     */
    @JsonProperty("takeTime")
    private Long takeTime;

    /**
     * 退款流水号，actionType=APPLY_REFUND的时候有值。
     */
    @JsonProperty("refundNumber")
    private String refundNumber;

    /**
     * 业务类型 10-MOP。必填。
     */
    @JsonProperty("bizType")
    private Integer bizType;
}
