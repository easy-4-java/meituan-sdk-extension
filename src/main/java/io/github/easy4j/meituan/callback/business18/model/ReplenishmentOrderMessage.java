package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】订货单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810115}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_ea015b0b-003b-4e37-87b5-651cd0e85c94">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplenishmentOrderMessage {

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
     * 门店订货单信息。必填。
     */
    @JsonProperty("bizData")
    private DemandOrderOpenDTO bizData;

    /**
     * 门店订货单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DemandOrderOpenDTO {

        /**
         * 主单。必填。
         */
        @JsonProperty("item")
        private DemandOrderItemOpenDTO item;

        /**
         * 明细。必填。
         */
        @JsonProperty("details")
        private List<DemandOrderItemDetailOpenDTO> details;

        /**
         * 主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DemandOrderItemOpenDTO {

            /**
             * 单据号。
             */
            @JsonProperty("orderSn")
            private String orderSn;

            /**
             * 期望到货日期。
             */
            @JsonProperty("expectReceiveTime")
            private Long expectReceiveTime;

            /**
             * 免付金额。
             */
            @JsonProperty("freeMoney")
            private String freeMoney;

            /**
             * 运费金额。
             */
            @JsonProperty("freightFee")
            private String freightFee;

            /**
             * 折后金额。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 不含税金额。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;

            /**
             * 订货机构。
             */
            @JsonProperty("orderingSubject")
            private OrgOpenDTO orderingSubject;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 初始订货单。
             */
            @JsonProperty("firstRequisitionOrderSn")
            private String firstRequisitionOrderSn;

            /**
             * 来源单据。
             */
            @JsonProperty("upstreamRequisitionOrderSn")
            private String upstreamRequisitionOrderSn;

            /**
             * 单据状态。
             */
            @JsonProperty("status")
            private PairDTO status;

            /**
             * 供货机构。
             */
            @JsonProperty("supplySubject")
            private SupplySubjectDetails supplySubject;

            /**
             * 单据提交时间。
             */
            @JsonProperty("submitTime")
            private Long submitTime;

            /**
             * 订单日期。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 创建时间。
             */
            @JsonProperty("createTime")
            private Long createTime;

            /**
             * 最后操作时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 预计发货日期。
             */
            @JsonProperty("expectDeliveryTime")
            private Long expectDeliveryTime;

            /**
             * 最后分单时间。
             */
            @JsonProperty("splitTime")
            private Long splitTime;

            /**
             * 是否加急单。
             */
            @JsonProperty("urgentType")
            private Boolean urgentType;

            /**
             * 是否预售。
             */
            @JsonProperty("preSale")
            private Boolean preSale;

            /**
             * 物品项目数。
             */
            @JsonProperty("itemCount")
            private Integer itemCount;

            /**
             * 付款金额。
             */
            @JsonProperty("payableMoney")
            private String payableMoney;

            /**
             * 折前金额。
             */
            @JsonProperty("originalMoney")
            private String originalMoney;

            /**
             * 订货标签。
             */
            @JsonProperty("requisitionOrderTags")
            private RequisitionOrderTagsDetails requisitionOrderTags;

            /**
             * 促销折扣。
             */
            @JsonProperty("campaignPromotionMoney")
            private String campaignPromotionMoney;

            /**
             * 手动折扣。
             */
            @JsonProperty("manualPromotionMoney")
            private String manualPromotionMoney;

            /**
             * 订货金额。
             */
            @JsonProperty("payableGoodsMoney")
            private String payableGoodsMoney;

            /**
             * 支付折扣。
             */
            @JsonProperty("paymentPromotionMoney")
            private String paymentPromotionMoney;

            /**
             * 配送自定义费用。
             */
            @JsonProperty("customFees")
            private CustomFeesOpenDTO customFees;

            /**
             * 是否代店下单。
             */
            @JsonProperty("createType")
            private CreateTypeDetails createType;

            /**
             * 创建来源。
             */
            @JsonProperty("sourceTerminalType")
            private SourceTerminalTypeDetails sourceTerminalType;

            /**
             * 运费重算。
             */
            @JsonProperty("feeRecalculateStatus")
            private FeeRecalculateStatusDetails feeRecalculateStatus;

            /**
             * 物流方式。
             */
            @JsonProperty("logisticsTypeNames")
            private List<String> logisticsTypeNames;

            /**
             * 创建类型。
             */
            @JsonProperty("orderOrderingType")
            private OrderOrderingTypeDetails orderOrderingType;

            /**
             * 创建方式。
             */
            @JsonProperty("sourceType")
            private SourceTypeDetails sourceType;

            /**
             * 拆单规则。
             */
            @JsonProperty("splitRule")
            private RuleIdentityOpenKey splitRule;

            /**
             * 分单状态。
             */
            @JsonProperty("splitStatus")
            private SplitStatusDetails splitStatus;

            /**
             * 付款方式。
             */
            @JsonProperty("payType")
            private PayTypeDetails payType;

            /**
             * 付款节点。
             */
            @JsonProperty("paymentNode")
            private PaymentNodeDetails paymentNode;

            /**
             * 付款状态。
             */
            @JsonProperty("payStatus")
            private PayStatusDetails payStatus;

            /**
             * 下游单据。
             */
            @JsonProperty("downstreamOrderSns")
            private List<String> downstreamOrderSns;

            /**
             * 提交人。
             */
            @JsonProperty("creatorId")
            private Long creatorId;

            /**
             * 收货机构。
             */
            @JsonProperty("receiveSubjectOrg")
            private ReceiveSubjectOrgDetails receiveSubjectOrg;

            /**
             * 版本号。
             */
            @JsonProperty("version")
            private Integer version;

            /**
             * 删除状态。
             */
            @JsonProperty("deleteStatus")
            private Integer deleteStatus;

            /**
             * 最大预计到货日期。
             */
            @JsonProperty("earliestExpectArriveTime")
            private Long earliestExpectArriveTime;

            /**
             * 最小预计到货日期。
             */
            @JsonProperty("latestExpectArriveTime")
            private Long latestExpectArriveTime;

            /**
             * 地址 ID。
             */
            @JsonProperty("addressId")
            private String addressId;

            /**
             * 主联系人姓名。
             */
            @JsonProperty("receiver")
            private String receiver;

            /**
             * 主联系人电话。
             */
            @JsonProperty("phone")
            private String phone;

            /**
             * 详细地址。
             */
            @JsonProperty("address")
            private String address;

            /**
             * 提交人。
             */
            @JsonProperty("submitter")
            private UserOpenDTO submitter;

            /**
             * 接单人。
             */
            @JsonProperty("auditor")
            private AuditorDetails auditor;

            /**
             * 接单时间。
             */
            @JsonProperty("auditTime")
            private Long auditTime;

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
             * 订货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

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
             * 单据状态。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PairDTO {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
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
            public static class SupplySubjectDetails {

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
             * 订货标签。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class RequisitionOrderTagsDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 配送自定义费用。
             */
            @Getter
            @Setter
            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                    isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CustomFeesOpenDTO {

                /**
                 * 自定义费用。
                 */
                @JsonProperty("ruleIdentityKey")
                private RuleIdentityOpenKey ruleIdentityKey;

                /**
                 * 值。
                 */
                @JsonProperty("String")
                private JsonNode string;

                /**
                 * 自定义费用。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class RuleIdentityOpenKey {

                    /**
                     * id。
                     */
                    @JsonProperty("id")
                    private Long id;

                    /**
                     * 版本。
                     */
                    @JsonProperty("version")
                    private Integer version;

                    /**
                     * name。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }

            /**
             * 是否代店下单。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CreateTypeDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 创建来源。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SourceTerminalTypeDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 运费重算。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class FeeRecalculateStatusDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 创建类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderOrderingTypeDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 创建方式。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SourceTypeDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 拆单规则。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class RuleIdentityOpenKey {

                /**
                 * id。
                 */
                @JsonProperty("id")
                private Long id;

                /**
                 * 版本。
                 */
                @JsonProperty("version")
                private Integer version;

                /**
                 * name。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 分单状态。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SplitStatusDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 付款方式。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PayTypeDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 付款节点。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PaymentNodeDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 付款状态。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PayStatusDetails {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 收货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveSubjectOrgDetails {

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
             * 提交人。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UserOpenDTO {

                /**
                 * id。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 真实名称。
                 */
                @JsonProperty("realName")
                private String realName;

                /**
                 * 员工账号。
                 */
                @JsonProperty("userName")
                private String userName;

                /**
                 * 员工编码。
                 */
                @JsonProperty("staffCode")
                private String staffCode;

                /**
                 * 员工手机号。
                 */
                @JsonProperty("phone")
                private String phone;

                /**
                 * 账号创建类型。
                 */
                @JsonProperty("createType")
                private String createType;
            }

            /**
             * 接单人。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AuditorDetails {

                /**
                 * id。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 真实名称。
                 */
                @JsonProperty("realName")
                private String realName;

                /**
                 * 员工账号。
                 */
                @JsonProperty("userName")
                private String userName;

                /**
                 * 员工编码。
                 */
                @JsonProperty("staffCode")
                private String staffCode;

                /**
                 * 员工手机号。
                 */
                @JsonProperty("phone")
                private String phone;

                /**
                 * 账号创建类型。
                 */
                @JsonProperty("createType")
                private String createType;
            }
        }

        /**
         * 明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DemandOrderItemDetailOpenDTO {

            /**
             * 明细 ID。
             */
            @JsonProperty("id")
            private String id;

            /**
             * 行号。
             */
            @JsonProperty("seqId")
            private Integer seqId;

            /**
             * 基准单位数量。
             */
            @JsonProperty("applyBaseUnitAmount")
            private String applyBaseUnitAmount;

            /**
             * 订货数量。
             */
            @JsonProperty("applyBizUnitAmount")
            private String applyBizUnitAmount;

            /**
             * 折后金额（含税）。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 折后金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 折后单价（含税）。
             */
            @JsonProperty("applyPrice")
            private String applyPrice;

            /**
             * 折后单价（不含税）。
             */
            @JsonProperty("applyNoTaxPrice")
            private String applyNoTaxPrice;

            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 订货机构。
             */
            @JsonProperty("belongOrg")
            private OrgOpenDTO belongOrg;

            /**
             * 创建时间。
             */
            @JsonProperty("createTime")
            private Long createTime;

            /**
             * 送货机构。
             */
            @JsonProperty("deliverySubject")
            private OpenOppositeOrgDTO deliverySubject;

            /**
             * 物品信息。
             */
            @JsonProperty("goods")
            private JsonNode goods;

            /**
             * 单据号。
             */
            @JsonProperty("orderSn")
            private String orderSn;

            /**
             * 发货仓库。
             */
            @JsonProperty("warehouse")
            private JsonNode warehouse;

            /**
             * 配送方式。
             */
            @JsonProperty("distributionType")
            private Integer distributionType;

            /**
             * 赠品标记。
             */
            @JsonProperty("giftType")
            private PairDTO giftType;

            /**
             * 订货单位。
             */
            @JsonProperty("selectPurchaseUnit")
            private JsonNode selectPurchaseUnit;

            /**
             * 接单数量。
             */
            @JsonProperty("auditBizUnitAmount")
            private String auditBizUnitAmount;

            /**
             * 订货仓库。
             */
            @JsonProperty("orderingWarehouse")
            private JsonNode orderingWarehouse;

            /**
             * 折前单价（含税）。
             */
            @JsonProperty("originalPrice")
            private String originalPrice;

            /**
             * 折前金额（含税）。
             */
            @JsonProperty("originalMoney")
            private String originalMoney;

            /**
             * 折前单价（不含税）。
             */
            @JsonProperty("originalNoTaxPrice")
            private String originalNoTaxPrice;

            /**
             * 折前金额（不含税）。
             */
            @JsonProperty("originalNoTaxMoney")
            private String originalNoTaxMoney;

            /**
             * 促销折扣。
             */
            @JsonProperty("campaignPromotionMoney")
            private String campaignPromotionMoney;

            /**
             * 手动折扣。
             */
            @JsonProperty("manualPromotionMoney")
            private String manualPromotionMoney;

            /**
             * 订货单价。
             */
            @JsonProperty("price")
            private String price;

            /**
             * 订货金额。
             */
            @JsonProperty("payableGoodsMoney")
            private String payableGoodsMoney;

            /**
             * 支付折扣。
             */
            @JsonProperty("paymentPromotionMoney")
            private String paymentPromotionMoney;

            /**
             * 辅助单位。
             */
            @JsonProperty("supplementaryUnitId")
            private JsonNode supplementaryUnitId;

            /**
             * 辅助单位换算关系。
             */
            @JsonProperty("conversionRateSupplementaryDesc")
            private String conversionRateSupplementaryDesc;

            /**
             * 辅助数量。
             */
            @JsonProperty("supplySubjectStockAmount")
            private String supplySubjectStockAmount;

            /**
             * 预计发货日期。
             */
            @JsonProperty("expectDeliveryTime")
            private Long expectDeliveryTime;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 预计到货日期。
             */
            @JsonProperty("expectArriveTime")
            private Long expectArriveTime;

            /**
             * 供货机构。
             */
            @JsonProperty("supplySubject")
            private SupplySubjectDetails supplySubject;

            /**
             * 订货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

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
             * 送货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OpenOppositeOrgDTO {

                /**
                 * 供货机构类型。
                 */
                @JsonProperty("type")
                private PairDTO type;

                /**
                 * 编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 标识符。
                 */
                @JsonProperty("id")
                private Long id;

                /**
                 * 供货机构类型。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class PairDTO {

                    /**
                     * 供货机构类型 ID 1: 供应商 2: 配送中心。
                     */
                    @JsonProperty("id")
                    private Integer id;

                    /**
                     * 供货机构类型描述。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }

            /**
             * 赠品标记。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PairDTO {

                /**
                 * 供货机构类型 ID 1: 供应商 2: 配送中心。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 供货机构类型描述。
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
            public static class SupplySubjectDetails {

                /**
                 * 供货机构类型。
                 */
                @JsonProperty("type")
                private PairDTO type;

                /**
                 * 编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 标识符。
                 */
                @JsonProperty("id")
                private Long id;

                /**
                 * 供货机构类型。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class PairDTO {

                    /**
                     * 供货机构类型 ID 1: 供应商 2: 配送中心。
                     */
                    @JsonProperty("id")
                    private Integer id;

                    /**
                     * 供货机构类型描述。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }
        }
    }
}
