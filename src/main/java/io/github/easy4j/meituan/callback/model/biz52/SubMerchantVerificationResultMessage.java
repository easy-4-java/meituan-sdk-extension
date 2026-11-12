package io.github.easy4j.meituan.callback.model.biz52;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「收单开放平台微信/支付宝子商户认证结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=52}，消息类型为 {@code msgType=5210011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_sdpt_7128c07e-d4dd-4f39-ada6-c014d622dc3f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubMerchantVerificationResultMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u6536\u5355\u5f00\u653e\u5e73\u53f0\u5fae\u4fe1/\u652f\u4ed8\u5b9d\u5b50\u5546\u6237\u8ba4\u8bc1\u7ed3\u679c\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public SubMerchantVerificationResultMessage() {
    }


    /**
     * 商户 ID。
     */
    @JsonProperty("merchantId")
    private Long merchantId;

    /**
     * 商编。
     */
    @JsonProperty("merchantNo")
    private Long merchantNo;

    /**
     * 申请单Id。
     */
    @JsonProperty("applyId")
    private String applyId;

    /**
     * 申请渠道。
     */
    @JsonProperty("payChannelType")
    private Integer payChannelType;

    /**
     * 认证状态。
     */
    @JsonProperty("authStatus")
    private Integer authStatus;

    /**
     * 驳回理由。
     */
    @JsonProperty("rejectReason")
    private String rejectReason;
}
