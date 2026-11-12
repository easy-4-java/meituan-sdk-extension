package io.github.easy4j.meituan.callback.model.biz16;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收订单配送状态消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=16}，消息类型为 {@code msgType=16101}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_wmoperng_518e4127-0a7d-40ef-b4c3-5ea4c47969be">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDeliveryStatusMessage {

    /**
     * 创建美团「接收订单配送状态消息」回调的业务内容。的空实例。
     */
    public OrderDeliveryStatusMessage() {
    }


    /**
     * 订单 ID。必填。
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * 外卖订单展示号。必填。
     */
    @JsonProperty("wm_order_id_view")
    private String wmOrderIdView;

    /**
     * 时间。必填。
     */
    @JsonProperty("time")
    private String time;

    /**
     * 配送员姓名。必填。
     */
    @JsonProperty("dispatcher_name")
    private String dispatcherName;

    /**
     * 配送员手机号。必填。
     */
    @JsonProperty("dispatcher_mobile")
    private String dispatcherMobile;

    /**
     * 配送员手机号尾号。必填。
     */
    @JsonProperty("dispatcher_mobile_end")
    private String dispatcherMobileEnd;

    /**
     * 配送状态。必填。
     */
    @JsonProperty("logistics_status")
    private String logisticsStatus;

    /**
     * 配送员 ID。必填。
     */
    @JsonProperty("dispatcher_id")
    private String dispatcherId;
}
