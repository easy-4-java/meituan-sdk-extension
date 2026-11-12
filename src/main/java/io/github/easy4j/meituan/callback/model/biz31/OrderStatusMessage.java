package io.github.easy4j.meituan.callback.model.biz31;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单状态回调消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=31}，消息类型为 {@code msgType=3110001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_peisongls_7db17451-dac6-4747-bd66-cd6268a37166">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderStatusMessage {

    /**
     * 创建美团「订单状态回调消息」回调的业务内容。的空实例。
     */
    public OrderStatusMessage() {
    }


    /**
     * 美团配送内部订单 ID。必填。
     */
    @JsonProperty("pkgId")
    private Long pkgId;

    /**
     * 商家订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 原平台商家订单号。
     */
    @JsonProperty("orderSourceNo")
    private String orderSourceNo;

    /**
     * 订单状态。必填。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 骑手姓名。
     */
    @JsonProperty("courierName")
    private String courierName;

    /**
     * 骑手手机号。
     */
    @JsonProperty("courierPhone")
    private String courierPhone;

    /**
     * 取消原因 ID。
     */
    @JsonProperty("cancelReasonId")
    private Integer cancelReasonId;

    /**
     * 取消原因。
     */
    @JsonProperty("cancelReason")
    private String cancelReason;
}
