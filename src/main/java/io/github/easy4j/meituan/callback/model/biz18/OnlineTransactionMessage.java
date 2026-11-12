package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】在线交易流水」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810125}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_089d58b9-4ced-44e8-bb9d-77dabefdba88">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OnlineTransactionMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u5728\u7ebf\u4ea4\u6613\u6d41\u6c34\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OnlineTransactionMessage() {
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
     * 在线交易流水。必填。
     */
    @JsonProperty("OnlinePayItemDTO")
    private OnlinePayItemDTO onlinePayItemDTO;

    /**
     * 在线交易流水。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OnlinePayItemDTO {

        /**
         * 创建\u5728\u7ebf\u4ea4\u6613\u6d41\u6c34\u3002的空实例。
         */
        public OnlinePayItemDTO() {
        }


        /**
         * 总部机构。
         */
        @JsonProperty("rootOrgId")
        private Long rootOrgId;

        /**
         * 付款机构。
         */
        @JsonProperty("fromSubject")
        private OrgOpenDTO fromSubject;

        /**
         * 收款机构信息。
         */
        @JsonProperty("counterpartySubject")
        private OpenOppositeOrgDTO counterpartySubject;

        /**
         * 交易时间。
         */
        @JsonProperty("payTransTime")
        private Long payTransTime;

        /**
         * 订单号。
         */
        @JsonProperty("outerOrderNo")
        private String outerOrderNo;

        /**
         * 关联单号。
         */
        @JsonProperty("outerRelatedOrderNo")
        private String outerRelatedOrderNo;

        /**
         * 支付流水号。
         */
        @JsonProperty("payTransNo")
        private String payTransNo;

        /**
         * 付款金额。
         */
        @JsonProperty("payAmount")
        private String payAmount;

        /**
         * 支付费率。
         */
        @JsonProperty("feeRate")
        private String feeRate;

        /**
         * 手续费承担方。
         */
        @JsonProperty("handleFeeBearer")
        private PairDTO handleFeeBearer;

        /**
         * 手续费金额。
         */
        @JsonProperty("handleFee")
        private String handleFee;

        /**
         * 交易金额。
         */
        @JsonProperty("transAmount")
        private String transAmount;

        /**
         * 支付方式。
         */
        @JsonProperty("payType")
        private PayTypeDetails payType;

        /**
         * 支付状态。
         */
        @JsonProperty("payStatus")
        private PayStatusDetails payStatus;

        /**
         * 到账状态。
         */
        @JsonProperty("receiptStatus")
        private ReceiptStatusDetails receiptStatus;

        /**
         * 删除状态。
         */
        @JsonProperty("deleteStatus")
        private Integer deleteStatus;

        /**
         * 付款机构。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrgOpenDTO {

            /**
             * 创建\u4ed8\u6b3e\u673a\u6784\u3002的空实例。
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

        /**
         * 收款机构信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OpenOppositeOrgDTO {

            /**
             * 创建\u6536\u6b3e\u673a\u6784\u4fe1\u606f\u3002的空实例。
             */
            public OpenOppositeOrgDTO() {
            }


            /**
             * 机构 ID。
             */
            @JsonProperty("type")
            private PairDTO type;

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

        /**
         * 支付方式。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PayTypeDetails {

            /**
             * 创建\u652f\u4ed8\u65b9\u5f0f\u3002的空实例。
             */
            public PayTypeDetails() {
            }


            /**
             * id。
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
         * 到账状态。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ReceiptStatusDetails {

            /**
             * 创建\u5230\u8d26\u72b6\u6001\u3002的空实例。
             */
            public ReceiptStatusDetails() {
            }


            /**
             * id。
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
