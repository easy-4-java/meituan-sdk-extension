package io.github.easy4j.meituan.callback.model.biz52;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「收单开放平台支付产品开通结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=52}，消息类型为 {@code msgType=5210010}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_sdpt_e7192e69-a8de-4320-8557-f9dcf790cf10">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentProductActivationResultMessage {

    /**
     * 商户 ID。必填。
     */
    @JsonProperty("merchantId")
    private Long merchantId;

    /**
     * 商户编号。
     */
    @JsonProperty("merchantNo")
    private Long merchantNo;

    /**
     * 开通产品类型。必填。
     */
    @JsonProperty("productType")
    private Integer productType;

    /**
     * 开通状态：32开通成功，64开通失败。必填。
     */
    @JsonProperty("openStatus")
    private Integer openStatus;

    /**
     * 开通失败原因。
     */
    @JsonProperty("failReason")
    private String failReason;
}
