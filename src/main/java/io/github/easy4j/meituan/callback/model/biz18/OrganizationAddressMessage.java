package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】机构地址推送消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810111}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_ffa2fb38-a0f8-417c-a463-f430ea8650d2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationAddressMessage {

    /**
     * 总部机构。必填。
     */
    @JsonProperty("rootOrgId")
    private Long rootOrgId;
    /**
     * 推送事件Id。必填。
     */
    @JsonProperty("pushEventId")
    private String pushEventId;
    /**
     * 操作类型。必填。
     */
    @JsonProperty("opType")
    private Integer opType;
    /**
     * 消息时序Id。必填。
     */
    @JsonProperty("seqId")
    private Long seqId;
    /**
     * 机构地址信息。必填。
     */
    @JsonProperty("bizData")
    private CompleteOrgAddressDTO bizData;

    /**
     * 创建美团「【供应链】机构地址推送消息」回调的业务内容。的空实例。
     */
    public OrganizationAddressMessage() {
    }

    /**
     * 机构地址信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CompleteOrgAddressDTO {

        /**
         * 机构Id。
         */
        @JsonProperty("orgId")
        private Long orgId;
        /**
         * 机构编码。
         */
        @JsonProperty("orgCode")
        private String orgCode;
        /**
         * 机构名称。
         */
        @JsonProperty("orgName")
        private String orgName;
        /**
         * 机构类型。
         */
        @JsonProperty("orgType")
        private Integer orgType;
        /**
         * 主联系人姓名。
         */
        @JsonProperty("contactName")
        private String contactName;
        /**
         * 主联系人电话。
         */
        @JsonProperty("contactTelephone")
        private String contactTelephone;
        /**
         * 省。
         */
        @JsonProperty("provinceName")
        private String provinceName;
        /**
         * 市。
         */
        @JsonProperty("cityName")
        private String cityName;
        /**
         * 区。
         */
        @JsonProperty("districtName")
        private String districtName;
        /**
         * 详细地址。
         */
        @JsonProperty("addressDetail")
        private String addressDetail;
        /**
         * 是否默认地址。
         */
        @JsonProperty("defaultAddress")
        private Boolean defaultAddress;
        /**
         * 备用联系人姓名。
         */
        @JsonProperty("alternateContactName")
        private String alternateContactName;
        /**
         * 备用联系人电话。
         */
        @JsonProperty("alternateContactTelephone")
        private String alternateContactTelephone;

        /**
         * 创建机构地址信息。的空实例。
         */
        public CompleteOrgAddressDTO() {
        }
    }
}
