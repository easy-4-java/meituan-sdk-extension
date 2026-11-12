package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】配送单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810095}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_83cfd8f1-2ea8-49e9-84cb-3e9543e06190">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryOrderMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u914d\u9001\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public DeliveryOrderMessage() {
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
     * 配送单信息。必填。
     */
    @JsonProperty("bizData")
    private DeliveryOrderDTO bizData;

    /**
     * 配送单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeliveryOrderDTO {

        /**
         * 创建\u914d\u9001\u5355\u4fe1\u606f\u3002的空实例。
         */
        public DeliveryOrderDTO() {
        }


        /**
         * 配送单主单。必填。
         */
        @JsonProperty("item")
        private DeliveryOrderItemDTO item;

        /**
         * 配送单明细。必填。
         */
        @JsonProperty("details")
        private List<DeliveryOrderItemDetailDTO> details;

        /**
         * 配送单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DeliveryOrderItemDTO {

            /**
             * 创建\u914d\u9001\u5355\u4e3b\u5355\u3002的空实例。
             */
            public DeliveryOrderItemDTO() {
            }


            /**
             * 总部机构。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 单据编号。
             */
            @JsonProperty("itemSn")
            private String itemSn;

            /**
             * 订单日期。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 期望到货日期。
             */
            @JsonProperty("expectTime")
            private Long expectTime;

            /**
             * 发货时间。
             */
            @JsonProperty("deliverTime")
            private Long deliverTime;

            /**
             * 创建时间。
             */
            @JsonProperty("createTime")
            private Long createTime;

            /**
             * 更新时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 订货机构。
             */
            @JsonProperty("demandOrg")
            private OrgOpenDTO demandOrg;

            /**
             * 供货机构。
             */
            @JsonProperty("supplyOrg")
            private SupplyOrgDetails supplyOrg;

            /**
             * 送货机构。
             */
            @JsonProperty("deliverOrg")
            private OpenOppositeOrgDTO deliverOrg;

            /**
             * 收货机构。
             */
            @JsonProperty("receiveOrg")
            private ReceiveOrgDetails receiveOrg;

            /**
             * 收货相关。
             */
            @JsonProperty("receiverInfo")
            private OrgAddressOpenDTO receiverInfo;

            /**
             * 关联采购订单号。
             */
            @JsonProperty("relationPurchaseSn")
            private String relationPurchaseSn;

            /**
             * 来源订货单。
             */
            @JsonProperty("sourceSns")
            private List<String> sourceSns;

            /**
             * 下游出库单。
             */
            @JsonProperty("downstreamStockOutSn")
            private List<String> downstreamStockOutSn;

            /**
             * 生成的配送收货单。
             */
            @JsonProperty("generateReceiveOrderSn")
            private String generateReceiveOrderSn;

            /**
             * 订单金额(含税)。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 订单金额(不含税)。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private Long creator;

            /**
             * 状态列表。
             */
            @JsonProperty("status")
            private Integer status;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 业务模式。
             */
            @JsonProperty("bizModel")
            private Integer bizModel;

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
             * 预计到货时间。
             */
            @JsonProperty("expectArriveTime")
            private Long expectArriveTime;

            /**
             * 订货标签。
             */
            @JsonProperty("labels")
            private List<LongPairOpenDTO> labels;

            /**
             * 是否补发（配送单补发状态）。
             */
            @JsonProperty("replenishStatus")
            private PairDTO replenishStatus;

            /**
             * 备用联系人姓名。
             */
            @JsonProperty("backupContactName")
            private String backupContactName;

            /**
             * 备用联系人电话。
             */
            @JsonProperty("backupContactPhone")
            private String backupContactPhone;

            /**
             * 配送自定义费用。
             */
            @JsonProperty("customFee")
            private String customFee;

            /**
             * 订货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

                /**
                 * 创建\u8ba2\u8d27\u673a\u6784\u3002的空实例。
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
            public static class SupplyOrgDetails {

                /**
                 * 创建\u4f9b\u8d27\u673a\u6784\u3002的空实例。
                 */
                public SupplyOrgDetails() {
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
             * 送货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OpenOppositeOrgDTO {

                /**
                 * 创建\u9001\u8d27\u673a\u6784\u3002的空实例。
                 */
                public OpenOppositeOrgDTO() {
                }


                /**
                 * 对方机构类型,1.供应商,2.组织机构,3.外销客户。
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
                 * 对方机构类型,1.供应商,2.组织机构,3.外销客户。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class PairDTO {

                    /**
                     * 创建\u5bf9\u65b9\u673a\u6784\u7c7b\u578b,1.\u4f9b\u5e94\u5546,2.\u7ec4\u7ec7\u673a\u6784,3.\u5916\u9500\u5ba2\u6237\u3002的空实例。
                     */
                    public PairDTO() {
                    }


                    /**
                     * 状态 ID。
                     */
                    @JsonProperty("id")
                    private Integer id;

                    /**
                     * 状态名。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }

            /**
             * 收货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveOrgDetails {

                /**
                 * 创建\u6536\u8d27\u673a\u6784\u3002的空实例。
                 */
                public ReceiveOrgDetails() {
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
             * 收货相关。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgAddressOpenDTO {

                /**
                 * 创建\u6536\u8d27\u76f8\u5173\u3002的空实例。
                 */
                public OrgAddressOpenDTO() {
                }


                /**
                 * 主联系人姓名。
                 */
                @JsonProperty("contactName")
                private String contactName;

                /**
                 * 主联系人电话。
                 */
                @JsonProperty("phone")
                private String phone;

                /**
                 * 地址信息。
                 */
                @JsonProperty("address")
                private String address;

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
            }

            /**
             * 订货标签。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class LongPairOpenDTO {

                /**
                 * 创建\u8ba2\u8d27\u6807\u7b7e\u3002的空实例。
                 */
                public LongPairOpenDTO() {
                }


                /**
                 * 标签 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 标签名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 是否补发（配送单补发状态）。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PairDTO {

                /**
                 * 创建\u662f\u5426\u8865\u53d1\uff08\u914d\u9001\u5355\u8865\u53d1\u72b6\u6001\uff09\u3002的空实例。
                 */
                public PairDTO() {
                }


                /**
                 * 状态 ID。
                 */
                @JsonProperty("id")
                private Integer id;

                /**
                 * 状态名。
                 */
                @JsonProperty("name")
                private String name;
            }
        }

        /**
         * 配送单明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DeliveryOrderItemDetailDTO {

            /**
             * 创建\u914d\u9001\u5355\u660e\u7ec6\u3002的空实例。
             */
            public DeliveryOrderItemDetailDTO() {
            }


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
             * 物品信息。
             */
            @JsonProperty("goodsInfo")
            private GoodsOpenDTO goodsInfo;

            /**
             * 发货仓库。
             */
            @JsonProperty("deliverWarehouseInfo")
            private WarehouseOpenDTO deliverWarehouseInfo;

            /**
             * 基准单位。
             */
            @JsonProperty("baseUnit")
            private UnitOpenDTO baseUnit;

            /**
             * 业务单位。
             */
            @JsonProperty("bizUnit")
            private BizUnitDetails bizUnit;

            /**
             * 订货数量。
             */
            @JsonProperty("demandAmount")
            private MultiUnitAmountOpenDTO demandAmount;

            /**
             * 接单数量。
             */
            @JsonProperty("receiveOrderAmount")
            private ReceiveOrderAmountDetails receiveOrderAmount;

            /**
             * 发货数量。
             */
            @JsonProperty("deliverAmount")
            private DeliverAmountDetails deliverAmount;

            /**
             * 收货数量。
             */
            @JsonProperty("receiveAmount")
            private ReceiveAmountDetails receiveAmount;

            /**
             * 差异数量。
             */
            @JsonProperty("diffAmount")
            private DiffAmountDetails diffAmount;

            /**
             * 返货数量。
             */
            @JsonProperty("refundAmount")
            private RefundAmountDetails refundAmount;

            /**
             * 收发差异数量。
             */
            @JsonProperty("acceptDeliverDiffAmount")
            private AcceptDeliverDiffAmountDetails acceptDeliverDiffAmount;

            /**
             * 订货单价(含税)。
             */
            @JsonProperty("demandPrice")
            private String demandPrice;

            /**
             * 订货单价(不含税)。
             */
            @JsonProperty("demandNoTaxPrice")
            private String demandNoTaxPrice;

            /**
             * 基准单位单价(含税)。
             */
            @JsonProperty("baseUnitPrice")
            private String baseUnitPrice;

            /**
             * 发货金额(含税)。
             */
            @JsonProperty("deliverMoney")
            private String deliverMoney;

            /**
             * 发货金额(不含税)。
             */
            @JsonProperty("deliverNoTaxMoney")
            private String deliverNoTaxMoney;

            /**
             * 订货金额(含税)。
             */
            @JsonProperty("demandMoney")
            private String demandMoney;

            /**
             * 收货金额(含税)。
             */
            @JsonProperty("receiveMoney")
            private String receiveMoney;

            /**
             * 返货金额(含税)。
             */
            @JsonProperty("refundMoney")
            private String refundMoney;

            /**
             * 收发差异金额（含税）。
             */
            @JsonProperty("acceptDeliverDiffMoney")
            private String acceptDeliverDiffMoney;

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
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 折前单价(含税)。
             */
            @JsonProperty("originalPrice")
            private String originalPrice;

            /**
             * 折前金额(含税)。
             */
            @JsonProperty("originalMoney")
            private String originalMoney;

            /**
             * 折前单价(不含税)。
             */
            @JsonProperty("noTaxOriginalPrice")
            private String noTaxOriginalPrice;

            /**
             * 折前金额(不含税)。
             */
            @JsonProperty("noTaxOriginalMoney")
            private String noTaxOriginalMoney;

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
             * 发货单价。
             */
            @JsonProperty("actuallyPayPrice")
            private String actuallyPayPrice;

            /**
             * 支付折扣-优惠券。
             */
            @JsonProperty("couponPromotionMoney")
            private String couponPromotionMoney;

            /**
             * 支付折扣-赠送金额。
             */
            @JsonProperty("grantPaymentPromotionMoney")
            private String grantPaymentPromotionMoney;

            /**
             * 折后单价(含税)。
             */
            @JsonProperty("promotedPrice")
            private String promotedPrice;

            /**
             * 折后金额(含税)。
             */
            @JsonProperty("promotedMoney")
            private String promotedMoney;

            /**
             * 折后单价(不含税)。
             */
            @JsonProperty("noTaxPromotedPrice")
            private String noTaxPromotedPrice;

            /**
             * 折后金额(不含税)。
             */
            @JsonProperty("noTaxPromotedMoney")
            private String noTaxPromotedMoney;

            /**
             * 批次号。
             */
            @JsonProperty("physicalBatchNum")
            private String physicalBatchNum;

            /**
             * 生产日期。
             */
            @JsonProperty("productionDate")
            private Long productionDate;

            /**
             * 保质期(天)。
             */
            @JsonProperty("shelfLife")
            private Integer shelfLife;

            /**
             * 到期日期。
             */
            @JsonProperty("expirationDate")
            private Long expirationDate;

            /**
             * 是否赠品。
             */
            @JsonProperty("giftType")
            private Integer giftType;

            /**
             * 订发差异数量。
             */
            @JsonProperty("diffApplyDeliveryAmount")
            private String diffApplyDeliveryAmount;

            /**
             * 订发差异金额。
             */
            @JsonProperty("diffApplyDeliveryMoney")
            private String diffApplyDeliveryMoney;

            /**
             * 收货金额(含税)。
             */
            @JsonProperty("acceptMoney")
            private String acceptMoney;

            /**
             * 物品信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class GoodsOpenDTO {

                /**
                 * 创建\u7269\u54c1\u4fe1\u606f\u3002的空实例。
                 */
                public GoodsOpenDTO() {
                }


                /**
                 * 物品 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 物品编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 物品名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 分类信息。
                 */
                @JsonProperty("category")
                private CategoryOpenDTO category;

                /**
                 * 品牌。
                 */
                @JsonProperty("brand")
                private String brand;

                /**
                 * 规格。
                 */
                @JsonProperty("spec")
                private String spec;

                /**
                 * 基准单位名称。
                 */
                @JsonProperty("baseUnit")
                private UnitOpenDTO baseUnit;

                /**
                 * 支持的单位名称列表。
                 */
                @JsonProperty("units")
                private List<UnitsItem> units;

                /**
                 * 物品版本号。
                 */
                @JsonProperty("version")
                private Integer version;

                /**
                 * 基准单位名称。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitOpenDTO {

                    /**
                     * 创建\u57fa\u51c6\u5355\u4f4d\u540d\u79f0\u3002的空实例。
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

                /**
                 * 支持的单位名称列表。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitsItem {

                    /**
                     * 创建\u652f\u6301\u7684\u5355\u4f4d\u540d\u79f0\u5217\u8868\u3002的空实例。
                     */
                    public UnitsItem() {
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

            /**
             * 发货仓库。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WarehouseOpenDTO {

                /**
                 * 创建\u53d1\u8d27\u4ed3\u5e93\u3002的空实例。
                 */
                public WarehouseOpenDTO() {
                }


                /**
                 * 仓库编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 仓库名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 仓库 ID。
                 */
                @JsonProperty("id")
                private String id;
            }

            /**
             * 基准单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

                /**
                 * 创建\u57fa\u51c6\u5355\u4f4d\u3002的空实例。
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

            /**
             * 业务单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BizUnitDetails {

                /**
                 * 创建\u4e1a\u52a1\u5355\u4f4d\u3002的空实例。
                 */
                public BizUnitDetails() {
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

            /**
             * 订货数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class MultiUnitAmountOpenDTO {

                /**
                 * 创建\u8ba2\u8d27\u6570\u91cf\u3002的空实例。
                 */
                public MultiUnitAmountOpenDTO() {
                }


                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务单位数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 接单数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveOrderAmountDetails {

                /**
                 * 创建\u63a5\u5355\u6570\u91cf\u3002的空实例。
                 */
                public ReceiveOrderAmountDetails() {
                }


                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务单位数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 发货数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DeliverAmountDetails {

                /**
                 * 创建\u53d1\u8d27\u6570\u91cf\u3002的空实例。
                 */
                public DeliverAmountDetails() {
                }


                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务单位数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 收货数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveAmountDetails {

                /**
                 * 创建\u6536\u8d27\u6570\u91cf\u3002的空实例。
                 */
                public ReceiveAmountDetails() {
                }


                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务单位数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 差异数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DiffAmountDetails {

                /**
                 * 创建\u5dee\u5f02\u6570\u91cf\u3002的空实例。
                 */
                public DiffAmountDetails() {
                }


                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务单位数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 返货数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class RefundAmountDetails {

                /**
                 * 创建\u8fd4\u8d27\u6570\u91cf\u3002的空实例。
                 */
                public RefundAmountDetails() {
                }


                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务单位数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 收发差异数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AcceptDeliverDiffAmountDetails {

                /**
                 * 创建\u6536\u53d1\u5dee\u5f02\u6570\u91cf\u3002的空实例。
                 */
                public AcceptDeliverDiffAmountDetails() {
                }


                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务单位数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }
        }
    }
}
