package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】物品类别档案消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810103}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_643906ec-1526-4e46-b9f1-c8e52136a0c2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemCategoryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u7269\u54c1\u7c7b\u522b\u6863\u6848\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ItemCategoryMessage() {
    }


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
     * 物品类别信息。必填。
     */
    @JsonProperty("bizData")
    private CompleteGoodsCategoryOpenDTO bizData;

    /**
     * 物品类别信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CompleteGoodsCategoryOpenDTO {

        /**
         * 创建\u7269\u54c1\u7c7b\u522b\u4fe1\u606f\u3002的空实例。
         */
        public CompleteGoodsCategoryOpenDTO() {
        }


        /**
         * 总部机构Id。
         */
        @JsonProperty("rootOrgId")
        private Long rootOrgId;

        /**
         * OrgOpenDTO。
         */
        @JsonProperty("belongOrg")
        private OrgOpenDTO belongOrg;

        /**
         * 分类 ID。
         */
        @JsonProperty("id")
        private String id;

        /**
         * 分类编码。
         */
        @JsonProperty("code")
        private String code;

        /**
         * 分类名称。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 父分类编码。
         */
        @JsonProperty("parentCode")
        private String parentCode;

        /**
         * 启用状态。
         */
        @JsonProperty("status")
        private JsonNode status;

        /**
         * 备注。
         */
        @JsonProperty("remark")
        private String remark;

        /**
         * OrgOpenDTO。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrgOpenDTO {

            /**
             * 创建OrgOpenDTO\u3002的空实例。
             */
            public OrgOpenDTO() {
            }


            /**
             * 机构 ID。
             */
            @JsonProperty("orgId")
            private Long orgId;

            /**
             * 机构根节点ID,即总部机构 ID。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 机构编码。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 机构名称。
             */
            @JsonProperty("name")
            private String name;
        }
    }
}
