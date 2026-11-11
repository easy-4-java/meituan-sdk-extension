package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】门店订货单撤销分单三方校验」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810253}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_5aefd175-2ed7-4682-b087-a4d5a622af10">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplenishmentSplitCancellationCheckMessage {

    /**
     * 订货单号。必填。
     */
    @JsonProperty("demandOrderSn")
    private String demandOrderSn;

    /**
     * 机构信息。
     */
    @JsonProperty("orgInfo")
    private List<ValidateOrgInfo> orgInfo;

    /**
     * orgInfo。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ValidateOrgInfo {

        /**
         * 机构类型。
         */
        @JsonProperty("type")
        private String type;

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
