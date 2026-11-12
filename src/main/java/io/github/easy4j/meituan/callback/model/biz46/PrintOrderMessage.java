package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「指定打印机打印订单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=46}，消息类型为 {@code msgType=4610029}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_dcps_d36c3f46-442f-4189-ba83-36591af2f548">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrintOrderMessage {

    /**
     * 创建美团「指定打印机打印订单」回调的业务内容。的空实例。
     */
    public PrintOrderMessage() {
    }


    /**
     * 打印机服务商类型。
     */
    @JsonProperty("printerMerchantType")
    private Integer printerMerchantType;

    /**
     * 不同服务商设备唯一 ID（sn码），用于指定打印机器不同服务商设备唯一 ID（sn码），用于指定打印机器。必填。
     */
    @JsonProperty("deviceNumber")
    private String deviceNumber;

    /**
     * 预约单Id。必填。
     */
    @JsonProperty("bookingOrderId")
    private Long bookingOrderId;

    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private String orderId;
}
