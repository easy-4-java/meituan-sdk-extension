package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】（预）付款单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810237}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_131d7553-f640-4425-a7fc-42342e3cdf8d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplyPaymentMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\uff08\u9884\uff09\u4ed8\u6b3e\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public SupplyPaymentMessage() {
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
     * 大消息体标识。
     */
    @JsonProperty("largeMessageTag")
    private Boolean largeMessageTag;

    /**
     * 入库单信息。必填。
     */
    @JsonProperty("bizData")
    private PaymentOrderOpenDTO bizData;

    /**
     * 入库单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaymentOrderOpenDTO {

        /**
         * 创建\u5165\u5e93\u5355\u4fe1\u606f\u3002的空实例。
         */
        public PaymentOrderOpenDTO() {
        }


        /**
         * 单据基本信息。
         */
        @JsonProperty("paymentOrderItem")
        private PaymentOrderOpenItemDTO paymentOrderItem;

        /**
         * 对账单明细（普通付款）。
         */
        @JsonProperty("paymentOrderItemDetail")
        private List<PaymentOrderItemDetailOpenDTO> paymentOrderItemDetail;

        /**
         * 单据明细（预付款）。
         */
        @JsonProperty("verifyPlans")
        private List<PaymentOrderVerifyPlanOpenDTO> verifyPlans;

        /**
         * 物品明细（预付款）。
         */
        @JsonProperty("goodsDetails")
        private List<PaymentOrderGoodsDetailOpenDTO> goodsDetails;

        /**
         * 单据基本信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PaymentOrderOpenItemDTO {

            /**
             * 创建\u5355\u636e\u57fa\u672c\u4fe1\u606f\u3002的空实例。
             */
            public PaymentOrderOpenItemDTO() {
            }


            /**
             * 总部机构 ID。
             */
            @JsonProperty("rootOrgID")
            private Long rootOrgID;

            /**
             * 付款单号。
             */
            @JsonProperty("orderSn")
            private String orderSn;

            /**
             * 付款机构。
             */
            @JsonProperty("paymentOrg")
            private OrgOpenDTO paymentOrg;

            /**
             * 供货机构。
             */
            @JsonProperty("supplyOrg")
            private SupplierOpenDTO supplyOrg;

            /**
             * 付款日期。
             */
            @JsonProperty("bizTime")
            private Long bizTime;

            /**
             * 付款类型。
             */
            @JsonProperty("orderType")
            private PairDTO orderType;

            /**
             * 是否专款专用。
             */
            @JsonProperty("specialPurpose")
            private SpecialPurposeDetails specialPurpose;

            /**
             * 应付金额。
             */
            @JsonProperty("paymentMoney")
            private String paymentMoney;

            /**
             * 优惠金额。
             */
            @JsonProperty("discountMoney")
            private String discountMoney;

            /**
             * 实付金额。
             */
            @JsonProperty("actualPaymentMoney")
            private String actualPaymentMoney;

            /**
             * 已核销金额。
             */
            @JsonProperty("verifiedMoney")
            private String verifiedMoney;

            /**
             * 未核销金额。
             */
            @JsonProperty("unverifiedMoney")
            private String unverifiedMoney;

            /**
             * 供货机构银行账号。
             */
            @JsonProperty("bankAccount")
            private String bankAccount;

            /**
             * 供货机构账户名称。
             */
            @JsonProperty("accountName")
            private String accountName;

            /**
             * 供货机构银行名称。
             */
            @JsonProperty("bankName")
            private String bankName;

            /**
             * 附件。
             */
            @JsonProperty("accessoryFiles")
            private PaymentAttachmentOpenDTO accessoryFiles;

            /**
             * 单据状态。
             */
            @JsonProperty("orderStatus")
            private OrderStatusDetails orderStatus;

            /**
             * 核销状态。
             */
            @JsonProperty("verifiedStatus")
            private VerifiedStatusDetails verifiedStatus;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private JsonNode creator;

            /**
             * 创建时间。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

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
             * 供货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SupplierOpenDTO {

                /**
                 * 创建\u4f9b\u8d27\u673a\u6784\u3002的空实例。
                 */
                public SupplierOpenDTO() {
                }


                /**
                 * 供应商 ID。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供应商编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 供应商名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 是否专款专用。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SpecialPurposeDetails {

                /**
                 * 创建\u662f\u5426\u4e13\u6b3e\u4e13\u7528\u3002的空实例。
                 */
                public SpecialPurposeDetails() {
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
             * 附件。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PaymentAttachmentOpenDTO {

                /**
                 * 创建\u9644\u4ef6\u3002的空实例。
                 */
                public PaymentAttachmentOpenDTO() {
                }


                /**
                 * 附件 ID 列表。
                 */
                @JsonProperty("accessoryId")
                private String accessoryId;

                /**
                 * 附件url列表。
                 */
                @JsonProperty("accessoryUrl")
                private String accessoryUrl;
            }

            /**
             * 单据状态。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderStatusDetails {

                /**
                 * 创建\u5355\u636e\u72b6\u6001\u3002的空实例。
                 */
                public OrderStatusDetails() {
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
             * 核销状态。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class VerifiedStatusDetails {

                /**
                 * 创建\u6838\u9500\u72b6\u6001\u3002的空实例。
                 */
                public VerifiedStatusDetails() {
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

        /**
         * 对账单明细（普通付款）。
         */
        @Getter
        @Setter
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PaymentOrderItemDetailOpenDTO {

            /**
             * 创建\u5bf9\u8d26\u5355\u660e\u7ec6\uff08\u666e\u901a\u4ed8\u6b3e\uff09\u3002的空实例。
             */
            public PaymentOrderItemDetailOpenDTO() {
            }


            /**
             * 行 ID。
             */
            @JsonProperty("rowId")
            private Integer rowId;

            /**
             * 对账单号。
             */
            @JsonProperty("paymentOrderSn")
            private String paymentOrderSn;

            /**
             * 对账日期。
             */
            @JsonProperty("reconciliationTime")
            private Long reconciliationTime;

            /**
             * 对账机构。
             */
            @JsonProperty("orgInfo")
            private OrgOpenDTO orgInfo;

            /**
             * 单据金额。
             */
            @JsonProperty("reconciliationMoney")
            private String reconciliationMoney;

            /**
             * 可付款金额。
             */
            @JsonProperty("canPaiedMoney")
            private String canPaiedMoney;

            /**
             * 预付款锁定金额。
             */
            @JsonProperty("lockedSpecialMoney")
            private String lockedSpecialMoney;

            /**
             * 已付款金额，付款单为对账单的已付款金额。
             */
            @JsonProperty("paidMoney")
            private String paidMoney;

            /**
             * 已付款金额，对账单本身的已付款金额。
             */
            @JsonProperty("hasPaidMoney")
            private String hasPaidMoney;

            /**
             * 付款中金额。
             */
            @JsonProperty("payingMoney")
            private String payingMoney;

            /**
             * 未付款金额。
             */
            @JsonProperty("unpaidMoney")
            private String unpaidMoney;

            /**
             * 付款状态。
             */
            @JsonProperty("paymentStatus")
            private PairDTO paymentStatus;

            /**
             * 已核销发票未付款金额。
             */
            @JsonProperty("verifiedInvoiceButUnpaidMoney")
            private String verifiedInvoiceButUnpaidMoney;

            /**
             * 发票状态。
             */
            @JsonProperty("invoiceOrderStatus")
            private InvoiceOrderStatusDetails invoiceOrderStatus;

            /**
             * 本次付款金额，付款单为对账单的本次付款金额。
             */
            @JsonProperty("lockedMoney")
            private String lockedMoney;

            /**
             * 键值对。
             */
            @JsonProperty("PairDTO")
            private JsonNode pairDTO;

            /**
             * 对账机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

                /**
                 * 创建\u5bf9\u8d26\u673a\u6784\u3002的空实例。
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
             * 发票状态。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class InvoiceOrderStatusDetails {

                /**
                 * 创建\u53d1\u7968\u72b6\u6001\u3002的空实例。
                 */
                public InvoiceOrderStatusDetails() {
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

        /**
         * 单据明细（预付款）。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PaymentOrderVerifyPlanOpenDTO {

            /**
             * 创建\u5355\u636e\u660e\u7ec6\uff08\u9884\u4ed8\u6b3e\uff09\u3002的空实例。
             */
            public PaymentOrderVerifyPlanOpenDTO() {
            }


            /**
             * 行 ID。
             */
            @JsonProperty("rowId")
            private String rowId;

            /**
             * 采购订单号。
             */
            @JsonProperty("bizOrderSn")
            private String bizOrderSn;

            /**
             * 订单日期。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 收货机构。
             */
            @JsonProperty("orgInfo")
            private OrgOpenDTO orgInfo;

            /**
             * 订单总金额。
             */
            @JsonProperty("orderTotalMoney")
            private String orderTotalMoney;

            /**
             * 应付日期。
             */
            @JsonProperty("paymentTime")
            private Long paymentTime;

            /**
             * 应付金额。
             */
            @JsonProperty("paymentMoney")
            private String paymentMoney;

            /**
             * 优惠金额。
             */
            @JsonProperty("discountMoney")
            private String discountMoney;

            /**
             * 单据状态。
             */
            @JsonProperty("bizOrderStatus")
            private PairDTO bizOrderStatus;

            /**
             * 订单备注。
             */
            @JsonProperty("bizOrderRemark")
            private String bizOrderRemark;

            /**
             * 付款计划备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 收货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

                /**
                 * 创建\u6536\u8d27\u673a\u6784\u3002的空实例。
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

        /**
         * 物品明细（预付款）。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PaymentOrderGoodsDetailOpenDTO {

            /**
             * 创建\u7269\u54c1\u660e\u7ec6\uff08\u9884\u4ed8\u6b3e\uff09\u3002的空实例。
             */
            public PaymentOrderGoodsDetailOpenDTO() {
            }


            /**
             * 行 ID。
             */
            @JsonProperty("rowId")
            private String rowId;

            /**
             * 采购订单号。
             */
            @JsonProperty("purchaseOrderSn")
            private String purchaseOrderSn;

            /**
             * 订单日期。
             */
            @JsonProperty("bizOrderTime")
            private Long bizOrderTime;

            /**
             * 物品编码。
             */
            @JsonProperty("goodsCode")
            private String goodsCode;

            /**
             * 物品名称。
             */
            @JsonProperty("goodsName")
            private String goodsName;

            /**
             * 规格型号。
             */
            @JsonProperty("specification")
            private String specification;

            /**
             * 物品类别。
             */
            @JsonProperty("categoryName")
            private String categoryName;

            /**
             * 采购单位。
             */
            @JsonProperty("purchaseUnit")
            private UnitOpenDTO purchaseUnit;

            /**
             * 采购数量。
             */
            @JsonProperty("purchasePurchaseUnitAmount")
            private String purchasePurchaseUnitAmount;

            /**
             * 收货数量。
             */
            @JsonProperty("receiveAmount")
            private String receiveAmount;

            /**
             * 采购单价（含税）。
             */
            @JsonProperty("purchaseWithoutTaxPrice")
            private String purchaseWithoutTaxPrice;

            /**
             * 金额（含税）。
             */
            @JsonProperty("withTaxMoney")
            private String withTaxMoney;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 金额（不含税）。
             */
            @JsonProperty("withoutTaxMoney")
            private String withoutTaxMoney;

            /**
             * 是否赠品。
             */
            @JsonProperty("giftTag")
            private Boolean giftTag;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 采购单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

                /**
                 * 创建\u91c7\u8d2d\u5355\u4f4d\u3002的空实例。
                 */
                public UnitOpenDTO() {
                }


                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;
            }
        }
    }
}
