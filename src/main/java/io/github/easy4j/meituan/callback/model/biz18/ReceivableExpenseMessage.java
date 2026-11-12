package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 美团「【供应链】应收费用单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810123}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_d413d051-9fc4-4c21-b6c1-c1426d596675">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceivableExpenseMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u5e94\u6536\u8d39\u7528\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReceivableExpenseMessage() {
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
     * 配送费用单。必填。
     */
    @JsonProperty("DeliveryFeeOpenDTO")
    private DeliveryFeeOpenDTO deliveryFeeOpenDTO;

    /**
     * 配送费用单。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeliveryFeeOpenDTO {

        /**
         * 创建\u914d\u9001\u8d39\u7528\u5355\u3002的空实例。
         */
        public DeliveryFeeOpenDTO() {
        }


        /**
         * 单据号。
         */
        @JsonProperty("orderSn")
        private String orderSn;

        /**
         * 供货机构。
         */
        @JsonProperty("SupplierOrgInfo")
        private OrgOpenDTO supplierOrgInfo;

        /**
         * 订货机构。
         */
        @JsonProperty("OrderingOrgInfo")
        private OrderingOrgInfoDetails orderingOrgInfo;

        /**
         * 单据类型。
         */
        @JsonProperty("orderCreateType")
        private PairDTO orderCreateType;

        /**
         * 费用类型。
         */
        @JsonProperty("feeType")
        private FeeArchiveOpenDTO feeType;

        /**
         * 费用金额。
         */
        @JsonProperty("feeMoney")
        private String feeMoney;

        /**
         * 可退金额。
         */
        @JsonProperty("refundableMoney")
        private String refundableMoney;

        /**
         * 关联费用单。
         */
        @JsonProperty("triggerOrderNo")
        private String triggerOrderNo;

        /**
         * 触发单据号。
         */
        @JsonProperty("outerOrderNo")
        private String outerOrderNo;

        /**
         * 单据状态。
         */
        @JsonProperty("status")
        private StatusDetails status;

        /**
         * 单据日期。
         */
        @JsonProperty("bizTime")
        private Long bizTime;

        /**
         * 单据创建时间。
         */
        @JsonProperty("orderCreateTime")
        private Long orderCreateTime;

        /**
         * 创建人。
         */
        @JsonProperty("creater")
        private Long creater;

        /**
         * 备注。
         */
        @JsonProperty("remark")
        private String remark;

        /**
         * 删除状态。
         */
        @JsonProperty("deleteStatus")
        private Integer deleteStatus;

        /**
         * 税率。
         */
        @JsonProperty("taxRate")
        private String taxRate;

        /**
         * 税额。
         */
        @JsonProperty("tax")
        private String tax;

        /**
         * 不含税金额。
         */
        @JsonProperty("noTaxMoney")
        private String noTaxMoney;

        /**
         * 供货机构。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrgOpenDTO {

            /**
             * 创建\u4f9b\u8d27\u673a\u6784\u3002的空实例。
             */
            public OrgOpenDTO() {
            }


            /**
             * 机构 ID。
             */
            @JsonProperty("orgId")
            private String orgId;

            /**
             * 机构根节点ID,即总部机构 ID。
             */
            @JsonProperty("rootOrgId")
            private JsonNode rootOrgId;

            /**
             * 机构编码。
             */
            @JsonProperty("code")
            private JsonNode code;

            /**
             * 机构名称。
             */
            @JsonProperty("name")
            private PairDTO name;

            /**
             * 机构名称。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PairDTO {

                /**
                 * 创建\u673a\u6784\u540d\u79f0\u3002的空实例。
                 */
                public PairDTO() {
                }


                /**
                 * ID。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 描述。
                 */
                @JsonProperty("name")
                private String name;
            }
        }

        /**
         * 订货机构。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderingOrgInfoDetails {

            /**
             * 创建\u8ba2\u8d27\u673a\u6784\u3002的空实例。
             */
            public OrderingOrgInfoDetails() {
            }


            /**
             * 机构 ID。
             */
            @JsonProperty("orgId")
            private String orgId;

            /**
             * 机构根节点ID,即总部机构 ID。
             */
            @JsonProperty("rootOrgId")
            private JsonNode rootOrgId;

            /**
             * 机构编码。
             */
            @JsonProperty("code")
            private JsonNode code;

            /**
             * 机构名称。
             */
            @JsonProperty("name")
            private PairDTO name;

            /**
             * 机构名称。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PairDTO {

                /**
                 * 创建\u673a\u6784\u540d\u79f0\u3002的空实例。
                 */
                public PairDTO() {
                }


                /**
                 * ID。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 描述。
                 */
                @JsonProperty("name")
                private String name;
            }
        }

        /**
         * 单据类型。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PairDTO {

            /**
             * 创建\u5355\u636e\u7c7b\u578b\u3002的空实例。
             */
            public PairDTO() {
            }


            /**
             * ID。
             */
            @JsonProperty("id")
            private Integer id;

            /**
             * 描述。
             */
            @JsonProperty("name")
            private String name;
        }

        /**
         * 费用类型。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class FeeArchiveOpenDTO {

            /**
             * 创建\u8d39\u7528\u7c7b\u578b\u3002的空实例。
             */
            public FeeArchiveOpenDTO() {
            }


            /**
             * id。
             */
            @JsonProperty("feeId")
            private Long feeId;

            /**
             * 编码。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 描述。
             */
            @JsonProperty("feeName")
            private String feeName;
        }

        /**
         * 单据状态。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StatusDetails {

            /**
             * 创建\u5355\u636e\u72b6\u6001\u3002的空实例。
             */
            public StatusDetails() {
            }


            /**
             * ID。
             */
            @JsonProperty("id")
            private Integer id;

            /**
             * 描述。
             */
            @JsonProperty("name")
            private String name;
        }
    }
}
