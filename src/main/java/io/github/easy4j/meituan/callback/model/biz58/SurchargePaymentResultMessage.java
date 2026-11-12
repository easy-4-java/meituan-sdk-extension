package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「补价支付结果」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810029}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_e1900c6f-df1d-435b-9c23-653562a5e1b2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurchargePaymentResultMessage {

    /**
     * 创建美团「补价支付结果」回调的业务内容。的空实例。
     */
    public SurchargePaymentResultMessage() {
    }


    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 补价支付结果。0-支付成功，1-支付超时。必填。
     */
    @JsonProperty("addPriceStatus")
    private String addPriceStatus;

    /**
     * 搬家行业必填，addPriceStatus=0时表示支付成功，有成功时间；addPriceStatus=1时表示支付失败，没有成功时间。
     */
    @JsonProperty("successTime")
    private String successTime;

    /**
     * 搬家行业必填，预支付时，三方传递的自定义支付参数，通知时回传。
     */
    @JsonProperty("thirdPartyPaymentInfo")
    private String thirdPartyPaymentInfo;

    /**
     * 券码。
     */
    @JsonProperty("serialNumber")
    private String serialNumber;

    /**
     * 金额。
     */
    @JsonProperty("amount")
    private String amount;
}
