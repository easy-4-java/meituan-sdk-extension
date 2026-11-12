package io.github.easy4j.meituan.callback.model.biz19;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单状态回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=19}，消息类型为 {@code msgType=19101}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_peisong_e0159351-5e6f-4911-bf86-51f4def71635">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryOrderStatusMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8ba2\u5355\u72b6\u6001\u56de\u8c03\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public DeliveryOrderStatusMessage() {
    }


    /**
     * 配送活动标识。必填。
     */
    @JsonProperty("delivery_id")
    private String deliveryId;

    /**
     * 美团配送内部订单 ID。必填。
     */
    @JsonProperty("mt_peisong_id")
    private String mtPeisongId;

    /**
     * 外部订单号。必填。
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 状态代码。必填。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 配送员姓名。必填。
     */
    @JsonProperty("courier_name")
    private String courierName;

    /**
     * 配送员电话。必填。
     */
    @JsonProperty("courier_phone")
    private String courierPhone;

    /**
     * 取消原因 ID。
     */
    @JsonProperty("cancel_reason_id")
    private Integer cancelReasonId;

    /**
     * 取消原因详情。
     */
    @JsonProperty("cancel_reason")
    private String cancelReason;

    /**
     * 订单预计送达时间。
     */
    @JsonProperty("predict_delivery_time")
    private String predictDeliveryTime;
}
