package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】返货单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810099}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_18138616-36ac-41ab-9cd7-8fb1142134b6">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockReturnMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u8fd4\u8d27\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StockReturnMessage() {
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
     * 返货单信息。必填。
     */
    @JsonProperty("bizData")
    private DistributionRefundOrderDTO bizData;

    /**
     * 返货单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DistributionRefundOrderDTO {

        /**
         * 创建\u8fd4\u8d27\u5355\u4fe1\u606f\u3002的空实例。
         */
        public DistributionRefundOrderDTO() {
        }


        /**
         * 差异单主单。必填。
         */
        @JsonProperty("item")
        private RefundOrderItemDTO item;

        /**
         * 差异单明细。必填。
         */
        @JsonProperty("details")
        private List<RefundOrderItemDetailDTO> details;

        /**
         * 差异单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class RefundOrderItemDTO {

            /**
             * 创建\u5dee\u5f02\u5355\u4e3b\u5355\u3002的空实例。
             */
            public RefundOrderItemDTO() {
            }


            /**
             * 总部 ID。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 返货单据号。
             */
            @JsonProperty("orderSn")
            private String orderSn;

            /**
             * 来源单据（废弃）。
             */
            @JsonProperty("acceptanceOrderSn")
            private String acceptanceOrderSn;

            /**
             * 退货机构。
             */
            @JsonProperty("refundOrg")
            private OrgOpenDTO refundOrg;

            /**
             * 供货机构。
             */
            @JsonProperty("distributionOrg")
            private DistributionOrgDetails distributionOrg;

            /**
             * 送货机构。
             */
            @JsonProperty("deliverOrg")
            private JsonNode deliverOrg;

            /**
             * 退货日期。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 收货日期。
             */
            @JsonProperty("receiveTime")
            private Long receiveTime;

            /**
             * 含税金额。
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
             * 单据状态。
             */
            @JsonProperty("status")
            private PairDTO status;

            /**
             * 退货原因。
             */
            @JsonProperty("refundReason")
            private ReasonOpenDTO refundReason;

            /**
             * 下游单据。
             */
            @JsonProperty("downstreamSn")
            private List<String> downstreamSn;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 创建日期。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

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
             * 订货单号。
             */
            @JsonProperty("applyOrderSns")
            private List<String> applyOrderSns;

            /**
             * 附件信息。
             */
            @JsonProperty("files")
            private List<AttachmentOpenDTO> files;

            /**
             * 上游单据。
             */
            @JsonProperty("externalSourceOrderSns")
            private List<String> externalSourceOrderSns;

            /**
             * 订货标签。
             */
            @JsonProperty("labels")
            private List<JsonNode> labels;

            /**
             * 返货类型。
             */
            @JsonProperty("createType")
            private Integer createType;

            /**
             * 业务模式。
             */
            @JsonProperty("bizMode")
            private BizModeDetails bizMode;

            /**
             * 自定义字段信息。
             */
            @JsonProperty("customFields")
            private List<CustomFieldOpenDTO> customFields;

            /**
             * 删除状态。
             */
            @JsonProperty("deleteStatus")
            private Integer deleteStatus;

            /**
             * 返货模式。
             */
            @JsonProperty("refundMode")
            private RefundModeDetails refundMode;

            /**
             * 退货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

                /**
                 * 创建\u9000\u8d27\u673a\u6784\u3002的空实例。
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
             * 附件信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AttachmentOpenDTO {

                /**
                 * 创建\u9644\u4ef6\u4fe1\u606f\u3002的空实例。
                 */
                public AttachmentOpenDTO() {
                }


                /**
                 * 附件名称。
                 */
                @JsonProperty("fileName")
                private String fileName;

                /**
                 * 文件key。
                 */
                @JsonProperty("fileKey")
                private String fileKey;

                /**
                 * 附件链接。
                 */
                @JsonProperty("fileUrl")
                private String fileUrl;

                /**
                 * 附件上传的场景。
                 */
                @JsonProperty("attachmentType")
                private Integer attachmentType;

                /**
                 * 附件配置名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 附件描述。
                 */
                @JsonProperty("desc")
                private String desc;
            }

            /**
             * 业务模式。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BizModeDetails {

                /**
                 * 创建\u4e1a\u52a1\u6a21\u5f0f\u3002的空实例。
                 */
                public BizModeDetails() {
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
             * 自定义字段信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CustomFieldOpenDTO {

                /**
                 * 创建\u81ea\u5b9a\u4e49\u5b57\u6bb5\u4fe1\u606f\u3002的空实例。
                 */
                public CustomFieldOpenDTO() {
                }


                /**
                 * 自定义字段 ID。
                 */
                @JsonProperty("customFieldId")
                private String customFieldId;

                /**
                 * 自定义字段名称。
                 */
                @JsonProperty("customFieldName")
                private String customFieldName;

                /**
                 * 属性值。
                 */
                @JsonProperty("customFieldValue")
                private String customFieldValue;
            }

            /**
             * 返货模式。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class RefundModeDetails {

                /**
                 * 创建\u8fd4\u8d27\u6a21\u5f0f\u3002的空实例。
                 */
                public RefundModeDetails() {
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
         * 差异单明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class RefundOrderItemDetailDTO {

            /**
             * 创建\u5dee\u5f02\u5355\u660e\u7ec6\u3002的空实例。
             */
            public RefundOrderItemDetailDTO() {
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
            @JsonProperty("goods")
            private GoodsOpenDTO goods;

            /**
             * 退货数量。
             */
            @JsonProperty("submitAmount")
            private String submitAmount;

            /**
             * 退货基准单位数量。
             */
            @JsonProperty("submitBaseUnitAmount")
            private String submitBaseUnitAmount;

            /**
             * 回库数量+退回供应商数量。
             */
            @JsonProperty("receiveAmount")
            private String receiveAmount;

            /**
             * 回库基准单位数量。
             */
            @JsonProperty("receiveBaseAmount")
            private String receiveBaseAmount;

            /**
             * 驳回数量。
             */
            @JsonProperty("rejectAmount")
            private String rejectAmount;

            /**
             * 驳回基准单位数量。
             */
            @JsonProperty("rejectBaseAmount")
            private String rejectBaseAmount;

            /**
             * 报损数量。
             */
            @JsonProperty("damageAmount")
            private String damageAmount;

            /**
             * 报损基准单位数量。
             */
            @JsonProperty("damageBaseAmount")
            private String damageBaseAmount;

            /**
             * 报损原因。
             */
            @JsonProperty("damageReason")
            private String damageReason;

            /**
             * 收货仓库。
             */
            @JsonProperty("warehouse")
            private WarehouseOpenDTO warehouse;

            /**
             * 发货仓库。
             */
            @JsonProperty("deliveryWarehouse")
            private DeliveryWarehouseDetails deliveryWarehouse;

            /**
             * 退货单价(含税)。
             */
            @JsonProperty("price")
            private String price;

            /**
             * 退货单价（不含税。
             */
            @JsonProperty("noTaxPrice")
            private String noTaxPrice;

            /**
             * 退货金额(含税)。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 退货金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 退货-优惠信息。
             */
            @JsonProperty("refundPromotionInfo")
            private RefundOrderDetailPromotionInfoOpenDTO refundPromotionInfo;

            /**
             * 回库-优惠信息。
             */
            @JsonProperty("receivePromotionInfo")
            private ReceivePromotionInfoDetails receivePromotionInfo;

            /**
             * 驳回-优惠信息。
             */
            @JsonProperty("rejectPromotionInfo")
            private RejectPromotionInfoDetails rejectPromotionInfo;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

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
             * 成本信息。
             */
            @JsonProperty("costInfo")
            private List<JsonNode> costInfo;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 业务单位。
             */
            @JsonProperty("bizUnit")
            private UnitOpenDTO bizUnit;

            /**
             * 关联配送收货单。
             */
            @JsonProperty("acceptanceOrderSn")
            private String acceptanceOrderSn;

            /**
             * 附件信息。
             */
            @JsonProperty("files")
            private List<AttachmentOpenDTO> files;

            /**
             * 关联配送单。
             */
            @JsonProperty("deliveryOrderSn")
            private String deliveryOrderSn;

            /**
             * 原配送单物品明细 ID。
             */
            @JsonProperty("sourceDeliveryDetailId")
            private String sourceDeliveryDetailId;

            /**
             * 是否为赠品（1-手动赠品 2-非赠品 3-促销赠品）。
             */
            @JsonProperty("giftType")
            private Integer giftType;

            /**
             * 批次关联的供应商。
             */
            @JsonProperty("batchSupplierInfo")
            private SupplierOpenDTO batchSupplierInfo;

            /**
             * 批次关联的生产商。
             */
            @JsonProperty("batchProducerInfo")
            private ProducerOpenDTO batchProducerInfo;

            /**
             * 回库数量。
             */
            @JsonProperty("supplyOrgAmount")
            private String supplyOrgAmount;

            /**
             * 退回供应商数量。
             */
            @JsonProperty("refundSupplyOrgAmount")
            private String refundSupplyOrgAmount;

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
             * 发货仓库。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DeliveryWarehouseDetails {

                /**
                 * 创建\u53d1\u8d27\u4ed3\u5e93\u3002的空实例。
                 */
                public DeliveryWarehouseDetails() {
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
             * 退货-优惠信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class RefundOrderDetailPromotionInfoOpenDTO {

                /**
                 * 创建\u9000\u8d27-\u4f18\u60e0\u4fe1\u606f\u3002的空实例。
                 */
                public RefundOrderDetailPromotionInfoOpenDTO() {
                }


                /**
                 * 折前单价（含税）。
                 */
                @JsonProperty("originalPrice")
                private String originalPrice;

                /**
                 * 折前单价（不含税）。
                 */
                @JsonProperty("noTaxOriginalPrice")
                private String noTaxOriginalPrice;

                /**
                 * 折后单价（含税）。
                 */
                @JsonProperty("promotedPrice")
                private String promotedPrice;

                /**
                 * 折后单价（不含税）。
                 */
                @JsonProperty("noTaxPromotedPrice")
                private String noTaxPromotedPrice;

                /**
                 * 支付折扣金额-优惠券。
                 */
                @JsonProperty("couponPromotionMoney")
                private String couponPromotionMoney;

                /**
                 * 支付折扣金额-赠送金额。
                 */
                @JsonProperty("grantPaymentPromotionMoney")
                private String grantPaymentPromotionMoney;

                /**
                 * 折损金额。
                 */
                @JsonProperty("promotionCutMoney")
                private String promotionCutMoney;

                /**
                 * 折前金额（含税）。
                 */
                @JsonProperty("originalMoney")
                private String originalMoney;

                /**
                 * 折前金额(不含税）。
                 */
                @JsonProperty("noTaxOriginalMoney")
                private String noTaxOriginalMoney;

                /**
                 * 折后金额（含税）。
                 */
                @JsonProperty("promotedMoney")
                private String promotedMoney;

                /**
                 * 折后金额(不含税)。
                 */
                @JsonProperty("noTaxPromotedMoney")
                private String noTaxPromotedMoney;

                /**
                 * 手动折扣金额。
                 */
                @JsonProperty("manualPromotionMoney")
                private String manualPromotionMoney;

                /**
                 * 促销折扣金额。
                 */
                @JsonProperty("campaignPromotionMoney")
                private String campaignPromotionMoney;

                /**
                 * 税额（优惠后）。
                 */
                @JsonProperty("tax")
                private String tax;
            }

            /**
             * 回库-优惠信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceivePromotionInfoDetails {

                /**
                 * 创建\u56de\u5e93-\u4f18\u60e0\u4fe1\u606f\u3002的空实例。
                 */
                public ReceivePromotionInfoDetails() {
                }


                /**
                 * 折前单价（含税）。
                 */
                @JsonProperty("originalPrice")
                private String originalPrice;

                /**
                 * 折前单价（不含税）。
                 */
                @JsonProperty("noTaxOriginalPrice")
                private String noTaxOriginalPrice;

                /**
                 * 折后单价（含税）。
                 */
                @JsonProperty("promotedPrice")
                private String promotedPrice;

                /**
                 * 折后单价（不含税）。
                 */
                @JsonProperty("noTaxPromotedPrice")
                private String noTaxPromotedPrice;

                /**
                 * 支付折扣金额-优惠券。
                 */
                @JsonProperty("couponPromotionMoney")
                private String couponPromotionMoney;

                /**
                 * 支付折扣金额-赠送金额。
                 */
                @JsonProperty("grantPaymentPromotionMoney")
                private String grantPaymentPromotionMoney;

                /**
                 * 折损金额。
                 */
                @JsonProperty("promotionCutMoney")
                private String promotionCutMoney;

                /**
                 * 折前金额（含税）。
                 */
                @JsonProperty("originalMoney")
                private String originalMoney;

                /**
                 * 折前金额(不含税）。
                 */
                @JsonProperty("noTaxOriginalMoney")
                private String noTaxOriginalMoney;

                /**
                 * 折后金额（含税）。
                 */
                @JsonProperty("promotedMoney")
                private String promotedMoney;

                /**
                 * 折后金额(不含税)。
                 */
                @JsonProperty("noTaxPromotedMoney")
                private String noTaxPromotedMoney;

                /**
                 * 手动折扣金额。
                 */
                @JsonProperty("manualPromotionMoney")
                private String manualPromotionMoney;

                /**
                 * 促销折扣金额。
                 */
                @JsonProperty("campaignPromotionMoney")
                private String campaignPromotionMoney;

                /**
                 * 税额（优惠后）。
                 */
                @JsonProperty("tax")
                private String tax;
            }

            /**
             * 驳回-优惠信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class RejectPromotionInfoDetails {

                /**
                 * 创建\u9a73\u56de-\u4f18\u60e0\u4fe1\u606f\u3002的空实例。
                 */
                public RejectPromotionInfoDetails() {
                }


                /**
                 * 折前单价（含税）。
                 */
                @JsonProperty("originalPrice")
                private String originalPrice;

                /**
                 * 折前单价（不含税）。
                 */
                @JsonProperty("noTaxOriginalPrice")
                private String noTaxOriginalPrice;

                /**
                 * 折后单价（含税）。
                 */
                @JsonProperty("promotedPrice")
                private String promotedPrice;

                /**
                 * 折后单价（不含税）。
                 */
                @JsonProperty("noTaxPromotedPrice")
                private String noTaxPromotedPrice;

                /**
                 * 支付折扣金额-优惠券。
                 */
                @JsonProperty("couponPromotionMoney")
                private String couponPromotionMoney;

                /**
                 * 支付折扣金额-赠送金额。
                 */
                @JsonProperty("grantPaymentPromotionMoney")
                private String grantPaymentPromotionMoney;

                /**
                 * 折损金额。
                 */
                @JsonProperty("promotionCutMoney")
                private String promotionCutMoney;

                /**
                 * 折前金额（含税）。
                 */
                @JsonProperty("originalMoney")
                private String originalMoney;

                /**
                 * 折前金额(不含税）。
                 */
                @JsonProperty("noTaxOriginalMoney")
                private String noTaxOriginalMoney;

                /**
                 * 折后金额（含税）。
                 */
                @JsonProperty("promotedMoney")
                private String promotedMoney;

                /**
                 * 折后金额(不含税)。
                 */
                @JsonProperty("noTaxPromotedMoney")
                private String noTaxPromotedMoney;

                /**
                 * 手动折扣金额。
                 */
                @JsonProperty("manualPromotionMoney")
                private String manualPromotionMoney;

                /**
                 * 促销折扣金额。
                 */
                @JsonProperty("campaignPromotionMoney")
                private String campaignPromotionMoney;

                /**
                 * 税额（优惠后）。
                 */
                @JsonProperty("tax")
                private String tax;
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
             * 附件信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AttachmentOpenDTO {

                /**
                 * 创建\u9644\u4ef6\u4fe1\u606f\u3002的空实例。
                 */
                public AttachmentOpenDTO() {
                }


                /**
                 * 附件名称。
                 */
                @JsonProperty("fileName")
                private String fileName;

                /**
                 * 文件key。
                 */
                @JsonProperty("fileKey")
                private String fileKey;

                /**
                 * 附件链接。
                 */
                @JsonProperty("fileUrl")
                private String fileUrl;

                /**
                 * 附件上传的场景。
                 */
                @JsonProperty("attachmentType")
                private Integer attachmentType;

                /**
                 * 附件配置名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 附件描述。
                 */
                @JsonProperty("desc")
                private String desc;
            }

            /**
             * 批次关联的供应商。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SupplierOpenDTO {

                /**
                 * 创建\u6279\u6b21\u5173\u8054\u7684\u4f9b\u5e94\u5546\u3002的空实例。
                 */
                public SupplierOpenDTO() {
                }


                /**
                 * id。
                 */
                @JsonProperty("id")
                private String id;

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
            }

            /**
             * 批次关联的生产商。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ProducerOpenDTO {

                /**
                 * 创建\u6279\u6b21\u5173\u8054\u7684\u751f\u4ea7\u5546\u3002的空实例。
                 */
                public ProducerOpenDTO() {
                }


                /**
                 * id。
                 */
                @JsonProperty("id")
                private String id;

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
            }
        }
    }
}
