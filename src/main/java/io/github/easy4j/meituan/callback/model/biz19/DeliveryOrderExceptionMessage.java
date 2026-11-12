package io.github.easy4j.meituan.callback.model.biz19;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单异常回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=19}，消息类型为 {@code msgType=19102}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_peisong_ec826ab4-9996-4c23-b64e-b9f460f49e83">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryOrderExceptionMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8ba2\u5355\u5f02\u5e38\u56de\u8c03\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public DeliveryOrderExceptionMessage() {
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
     * 异常 ID。必填。
     */
    @JsonProperty("exception_id")
    private String exceptionId;

    /**
     * 订单异常代码。必填。
     */
    @JsonProperty("exception_code")
    private String exceptionCode;

    /**
     * 订单异常详细信息。必填。
     */
    @JsonProperty("exception_descr")
    private String exceptionDescr;

    /**
     * 配送员上报订单异常的时间。必填。
     */
    @JsonProperty("exception_time")
    private String exceptionTime;

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
}
