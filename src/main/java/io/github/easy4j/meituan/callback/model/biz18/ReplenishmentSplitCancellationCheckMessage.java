package io.github.easy4j.meituan.callback.model.biz18;

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
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u95e8\u5e97\u8ba2\u8d27\u5355\u64a4\u9500\u5206\u5355\u4e09\u65b9\u6821\u9a8c\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReplenishmentSplitCancellationCheckMessage() {
    }


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
         * 创建orgInfo\u3002的空实例。
         */
        public ValidateOrgInfo() {
        }


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
