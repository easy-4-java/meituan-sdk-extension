package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】差异单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810097}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_413654d3-7a8f-4cef-9e41-3226148f3a6f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockDiscrepancyMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u5dee\u5f02\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StockDiscrepancyMessage() {
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
     * 差异单信息。必填。
     */
    @JsonProperty("bizData")
    private DiffOrderDTO bizData;

    /**
     * 差异单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DiffOrderDTO {

        /**
         * 创建\u5dee\u5f02\u5355\u4fe1\u606f\u3002的空实例。
         */
        public DiffOrderDTO() {
        }


        /**
         * 差异单主单。必填。
         */
        @JsonProperty("item")
        private DiffOrderItemDTO item;

        /**
         * 差异单明细。必填。
         */
        @JsonProperty("details")
        private List<DiffOrderItemDetailDTO> details;

        /**
         * 差异单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DiffOrderItemDTO {

            /**
             * 创建\u5dee\u5f02\u5355\u4e3b\u5355\u3002的空实例。
             */
            public DiffOrderItemDTO() {
            }


            /**
             * 总部机构。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 归属机构。
             */
            @JsonProperty("belongOrg")
            private OrgOpenDTO belongOrg;

            /**
             * 供货机构。
             */
            @JsonProperty("distributionOrg")
            private DistributionOrgDetails distributionOrg;

            /**
             * 差异单号。
             */
            @JsonProperty("diffOrderSn")
            private String diffOrderSn;

            /**
             * 配送申请单号。
             */
            @JsonProperty("distributionApplyOrderSns")
            private List<String> distributionApplyOrderSns;

            /**
             * 上游发货单号。
             */
            @JsonProperty("deliveryOrderSn")
            private String deliveryOrderSn;

            /**
             * 上游收货单号。
             */
            @JsonProperty("acceptanceOrderSn")
            private String acceptanceOrderSn;

            /**
             * 差异申请金额。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 状态。
             */
            @JsonProperty("status")
            private PairDTO status;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 差异原因。
             */
            @JsonProperty("reason")
            private ReasonOpenDTO reason;

            /**
             * 下游单据。
             */
            @JsonProperty("downstreamSn")
            private List<String> downstreamSn;

            /**
             * 订单时间。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 差异处理时间。
             */
            @JsonProperty("dealTime")
            private Long dealTime;

            /**
             * 更新时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

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
             * 送货机构。
             */
            @JsonProperty("deliveryOrg")
            private OpenOppositeOrgDTO deliveryOrg;

            /**
             * 供货机构NEW。
             */
            @JsonProperty("distributionOrgNew")
            private DistributionOrgNewDetails distributionOrgNew;

            /**
             * 处理机构。
             */
            @JsonProperty("dealOrg")
            private DealOrgDetails dealOrg;

            /**
             * 退费金额-退货机构收。
             */
            @JsonProperty("feeRefundMoneySum")
            private String feeRefundMoneySum;

            /**
             * 退费金额-供货机构收。
             */
            @JsonProperty("supplyOrgFeeRefundMoneySum")
            private String supplyOrgFeeRefundMoneySum;

            /**
             * 集团承担金额。
             */
            @JsonProperty("actualDiffMoney")
            private String actualDiffMoney;

            /**
             * 差异单处理前优惠信息汇总。
             */
            @JsonProperty("promotionInfo")
            private DistributionOrderPromotionInfoOpenDTO promotionInfo;

            /**
             * 差异单处理后优惠信息汇总（多收场景包含出库、少收场景包含报损和回库）。
             */
            @JsonProperty("actualDealPromotionInfo")
            private ActualDealPromotionInfoDetails actualDealPromotionInfo;

            /**
             * 归属机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

                /**
                 * 创建\u5f52\u5c5e\u673a\u6784\u3002的空实例。
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
                 * 机构类型。
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
                 * id。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 机构类型。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class PairDTO {

                    /**
                     * 创建\u673a\u6784\u7c7b\u578b\u3002的空实例。
                     */
                    public PairDTO() {
                    }


                    /**
                     * 类型 ID。
                     */
                    @JsonProperty("id")
                    private Integer id;

                    /**
                     * 类型名称。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }

            /**
             * 供货机构NEW。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DistributionOrgNewDetails {

                /**
                 * 创建\u4f9b\u8d27\u673a\u6784NEW\u3002的空实例。
                 */
                public DistributionOrgNewDetails() {
                }


                /**
                 * 机构类型。
                 */
                @JsonProperty("type")
                private PairDTO type;

                /**
                 * 名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * id。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 机构类型。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class PairDTO {

                    /**
                     * 创建\u673a\u6784\u7c7b\u578b\u3002的空实例。
                     */
                    public PairDTO() {
                    }


                    /**
                     * 类型 ID。
                     */
                    @JsonProperty("id")
                    private Integer id;

                    /**
                     * 类型名称。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }

            /**
             * 处理机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DealOrgDetails {

                /**
                 * 创建\u5904\u7406\u673a\u6784\u3002的空实例。
                 */
                public DealOrgDetails() {
                }


                /**
                 * 机构 ID。
                 */
                @JsonProperty("orgId")
                private Long orgId;

                /**
                 * 总部机构 ID。
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
             * 差异单处理前优惠信息汇总。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DistributionOrderPromotionInfoOpenDTO {

                /**
                 * 创建\u5dee\u5f02\u5355\u5904\u7406\u524d\u4f18\u60e0\u4fe1\u606f\u6c47\u603b\u3002的空实例。
                 */
                public DistributionOrderPromotionInfoOpenDTO() {
                }


                /**
                 * 折前金额。
                 */
                @JsonProperty("originalMoney")
                private String originalMoney;

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
                 * 折后金额。
                 */
                @JsonProperty("promotedMoney")
                private String promotedMoney;
            }

            /**
             * 差异单处理后优惠信息汇总（多收场景包含出库、少收场景包含报损和回库）。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ActualDealPromotionInfoDetails {

                /**
                 * 创建\u5dee\u5f02\u5355\u5904\u7406\u540e\u4f18\u60e0\u4fe1\u606f\u6c47\u603b\uff08\u591a\u6536\u573a\u666f\u5305\u542b\u51fa\u5e93\u3001\u5c11\u6536\u573a\u666f\u5305\u542b\u62a5\u635f\u548c\u56de\u5e93\uff09\u3002的空实例。
                 */
                public ActualDealPromotionInfoDetails() {
                }


                /**
                 * 折前金额。
                 */
                @JsonProperty("originalMoney")
                private String originalMoney;

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
                 * 折后金额。
                 */
                @JsonProperty("promotedMoney")
                private String promotedMoney;
            }
        }

        /**
         * 差异单明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DiffOrderItemDetailDTO {

            /**
             * 创建\u5dee\u5f02\u5355\u660e\u7ec6\u3002的空实例。
             */
            public DiffOrderItemDetailDTO() {
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
             * 物品明细。
             */
            @JsonProperty("goods")
            private GoodsOpenDTO goods;

            /**
             * 价格。
             */
            @JsonProperty("price")
            private String price;

            /**
             * 价格（不含税）。
             */
            @JsonProperty("noTaxPrice")
            private String noTaxPrice;

            /**
             * 差异申请数量。
             */
            @JsonProperty("diffAmount")
            private String diffAmount;

            /**
             * 差异申请基准单位数量。
             */
            @JsonProperty("diffBaseUnitAmount")
            private String diffBaseUnitAmount;

            /**
             * 发货数量。
             */
            @JsonProperty("deliveryAmount")
            private String deliveryAmount;

            /**
             * 发货基准单位数量。
             */
            @JsonProperty("deliveryBaseUnitAmount")
            private String deliveryBaseUnitAmount;

            /**
             * 收货数量。
             */
            @JsonProperty("receiveAmount")
            private String receiveAmount;

            /**
             * 收货基准单位数量。
             */
            @JsonProperty("receiveBaseUnitAmount")
            private String receiveBaseUnitAmount;

            /**
             * 差异申请金额。
             */
            @JsonProperty("diffMoney")
            private String diffMoney;

            /**
             * 差异申请金额（不含税）。
             */
            @JsonProperty("diffNoTaxMoney")
            private String diffNoTaxMoney;

            /**
             * 差异金额。
             */
            @JsonProperty("actualDiffMoney")
            private String actualDiffMoney;

            /**
             * 差异金额（不含税）。
             */
            @JsonProperty("actualDiffNoTaxMoney")
            private String actualDiffNoTaxMoney;

            /**
             * 送货机构-出库数量。
             */
            @JsonProperty("supplierStockOutAmount")
            private String supplierStockOutAmount;

            /**
             * 送货机构-出库基准单位数量。
             */
            @JsonProperty("supplierStockOutBaseUnitAmount")
            private String supplierStockOutBaseUnitAmount;

            /**
             * 订货机构-入库数量。
             */
            @JsonProperty("stockInAmount")
            private String stockInAmount;

            /**
             * 订货机构-入库基准单位数量。
             */
            @JsonProperty("stockInBaseUnitAmount")
            private String stockInBaseUnitAmount;

            /**
             * 供货机构-入库数量。
             */
            @JsonProperty("supplierStockInAmount")
            private String supplierStockInAmount;

            /**
             * 供货机构-入库基准单位数量。
             */
            @JsonProperty("supplierStockInBaseUnitAmount")
            private String supplierStockInBaseUnitAmount;

            /**
             * 供货机构-报损数量。
             */
            @JsonProperty("damageAmount")
            private String damageAmount;

            /**
             * 供货机构-报损基准单位数量。
             */
            @JsonProperty("damageBaseUnitAmount")
            private String damageBaseUnitAmount;

            /**
             * 物品报损原因。
             */
            @JsonProperty("damageReason")
            private ReasonOpenDTO damageReason;

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
             * 业务单位。
             */
            @JsonProperty("bizUnit")
            private UnitOpenDTO bizUnit;

            /**
             * 是否为赠品（1-手动赠品 2-非赠品 3-促销赠品）。
             */
            @JsonProperty("giftType")
            private Integer giftType;

            /**
             * 收货仓库。
             */
            @JsonProperty("receiveWarehouse")
            private WarehouseOpenDTO receiveWarehouse;

            /**
             * 门店收货仓库。
             */
            @JsonProperty("applyReceiveWarehouse")
            private ApplyReceiveWarehouseDetails applyReceiveWarehouse;

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
             * 差异单处理前优惠信息。
             */
            @JsonProperty("promotionInfo")
            private DistributionOrderDetailPromotionInfoOpenDTO promotionInfo;

            /**
             * 差异单处理后优惠信息（多收场景包含出库、少收场景包含报损和回库）。
             */
            @JsonProperty("actualDealPromotionInfo")
            private ActualDealPromotionInfoDetails actualDealPromotionInfo;

            /**
             * 物品明细。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class GoodsOpenDTO {

                /**
                 * 创建\u7269\u54c1\u660e\u7ec6\u3002的空实例。
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
             * 业务单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

                /**
                 * 创建\u4e1a\u52a1\u5355\u4f4d\u3002的空实例。
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
             * 收货仓库。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WarehouseOpenDTO {

                /**
                 * 创建\u6536\u8d27\u4ed3\u5e93\u3002的空实例。
                 */
                public WarehouseOpenDTO() {
                }


                /**
                 * 仓库 ID。
                 */
                @JsonProperty("id")
                private String id;

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
            }

            /**
             * 门店收货仓库。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ApplyReceiveWarehouseDetails {

                /**
                 * 创建\u95e8\u5e97\u6536\u8d27\u4ed3\u5e93\u3002的空实例。
                 */
                public ApplyReceiveWarehouseDetails() {
                }


                /**
                 * 仓库 ID。
                 */
                @JsonProperty("id")
                private String id;

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
            }

            /**
             * 差异单处理前优惠信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DistributionOrderDetailPromotionInfoOpenDTO {

                /**
                 * 创建\u5dee\u5f02\u5355\u5904\u7406\u524d\u4f18\u60e0\u4fe1\u606f\u3002的空实例。
                 */
                public DistributionOrderDetailPromotionInfoOpenDTO() {
                }


                /**
                 * 促销折扣金额。
                 */
                @JsonProperty("campaignPromotionMoney")
                private String campaignPromotionMoney;

                /**
                 * 手动折扣金额。
                 */
                @JsonProperty("manualPromotionMoney")
                private String manualPromotionMoney;

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
                @JsonProperty("noTaxOriginalPrice")
                private String noTaxOriginalPrice;

                /**
                 * 折前金额（不含税）。
                 */
                @JsonProperty("noTaxOriginalMoney")
                private String noTaxOriginalMoney;

                /**
                 * 折后单价(含税）。
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
            }

            /**
             * 差异单处理后优惠信息（多收场景包含出库、少收场景包含报损和回库）。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ActualDealPromotionInfoDetails {

                /**
                 * 创建\u5dee\u5f02\u5355\u5904\u7406\u540e\u4f18\u60e0\u4fe1\u606f\uff08\u591a\u6536\u573a\u666f\u5305\u542b\u51fa\u5e93\u3001\u5c11\u6536\u573a\u666f\u5305\u542b\u62a5\u635f\u548c\u56de\u5e93\uff09\u3002的空实例。
                 */
                public ActualDealPromotionInfoDetails() {
                }


                /**
                 * 促销折扣金额。
                 */
                @JsonProperty("campaignPromotionMoney")
                private String campaignPromotionMoney;

                /**
                 * 手动折扣金额。
                 */
                @JsonProperty("manualPromotionMoney")
                private String manualPromotionMoney;

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
                @JsonProperty("noTaxOriginalPrice")
                private String noTaxOriginalPrice;

                /**
                 * 折前金额（不含税）。
                 */
                @JsonProperty("noTaxOriginalMoney")
                private String noTaxOriginalMoney;

                /**
                 * 折后单价(含税）。
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
            }
        }
    }
}
