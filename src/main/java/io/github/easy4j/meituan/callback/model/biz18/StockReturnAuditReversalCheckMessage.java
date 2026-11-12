package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】门店返货单反审核三方校验」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810255}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_7b548983-084e-4d55-82ee-85a729a55b27">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockReturnAuditReversalCheckMessage {

    /**
     * 返货单号。必填。
     */
    @JsonProperty("refundOrderSn")
    private String refundOrderSn;

    /**
     * 机构信息。
     */
    @JsonProperty("orgInfo")
    private ValidateOrgInfo orgInfo;

    /**
     * 机构信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ValidateOrgInfo {

        /**
         * 机构类型 1:  供应商 2: 配送中心。
         */
        @JsonProperty("type")
        private String type;

        /**
         * 机构类型描述。
         */
        @JsonProperty("typeDesc")
        private String typeDesc;

        /**
         * 机构 ID。
         */
        @JsonProperty("orgId")
        private String orgId;

        /**
         * 机构名字。
         */
        @JsonProperty("orgName")
        private String orgName;

        /**
         * 机构编码。
         */
        @JsonProperty("orgCode")
        private String orgCode;
    }
}
