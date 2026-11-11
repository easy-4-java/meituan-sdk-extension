package io.github.easy4j.meituan.callback.business52.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「收单开放平台商户入驻结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=52}，消息类型为 {@code msgType=5210008}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_sdpt_ea08efbd-785e-4938-b07f-10c60a6cf001">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantOnboardingResultMessage {

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
     * 资质审核状态 1：待提审 8：待总部审核 32：总部审核通过 64：总部审核驳回 128： 等待签署异名授权书 129： 等待签署收单协议 256：签署异名授权书失败 257：签署收单协议失败 512：签署异名授权书成功 513：签署收单协议成功。
     * 必填。
     */
    @JsonProperty("auditStatus")
    private Integer auditStatus;

    /**
     * 驳回理由。
     */
    @JsonProperty("rejectReason")
    private String rejectReason;
}
