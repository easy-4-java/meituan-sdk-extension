package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】配送收货单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810117}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_efc64380-c31f-46b4-b7d7-fff0407b206a">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryReceiptMessage {

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
     * 配送收货单信息。必填。
     */
    @JsonProperty("bizData")
    private AcceptanceOrderOpenDTO bizData;

    /**
     * 配送收货单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AcceptanceOrderOpenDTO {

        /**
         * 配送收货单主单。必填。
         */
        @JsonProperty("item")
        private AcceptanceOrderItemDTO item;

        /**
         * 配送收货单明细。必填。
         */
        @JsonProperty("details")
        private List<AcceptanceOrderItemDetailDTO> details;

        /**
         * 配送收货单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AcceptanceOrderItemDTO {

            /**
             * 机构Id。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 收货单号。
             */
            @JsonProperty("itemSn")
            private String itemSn;

            /**
             * 订货机构信息。
             */
            @JsonProperty("demandOrgInfo")
            private OrgOpenDTO demandOrgInfo;

            /**
             * 供货机构信息。
             */
            @JsonProperty("distributionOrg")
            private OpenOppositeOrgDTO distributionOrg;

            /**
             * 送货机构信息。
             */
            @JsonProperty("supplyOrgInfo")
            private SupplyOrgInfoDetails supplyOrgInfo;

            /**
             * 来源配送单号。
             */
            @JsonProperty("deliveryOrderSn")
            private String deliveryOrderSn;

            /**
             * 来源采购订单号。
             */
            @JsonProperty("purchaseOrderSn")
            private String purchaseOrderSn;

            /**
             * 来源订货单号。
             */
            @JsonProperty("applyOrderSns")
            private List<String> applyOrderSns;

            /**
             * 订单日期。
             */
            @JsonProperty("demandTime")
            private Long demandTime;

            /**
             * 期望到货日期。
             */
            @JsonProperty("expectReceiveTime")
            private Long expectReceiveTime;

            /**
             * 收货日期。
             */
            @JsonProperty("acceptTime")
            private Long acceptTime;

            /**
             * 创建时间。
             */
            @JsonProperty("createTime")
            private Long createTime;

            /**
             * 最后操作时间。
             */
            @JsonProperty("lastModifyTime")
            private Long lastModifyTime;

            /**
             * 收货金额。
             */
            @JsonProperty("acceptMoney")
            private String acceptMoney;

            /**
             * 配送运费。
             */
            @JsonProperty("freightFee")
            private String freightFee;

            /**
             * 业务模式。
             */
            @JsonProperty("bizModel")
            private PairDTO bizModel;

            /**
             * 收货类型。
             */
            @JsonProperty("receiveType")
            private ReceiveTypeDetails receiveType;

            /**
             * 单据状态。
             */
            @JsonProperty("status")
            private StatusDetails status;

            /**
             * 关联入库单。
             */
            @JsonProperty("generateStockInItemSns")
            private List<String> generateStockInItemSns;

            /**
             * 创建人。
             */
            @JsonProperty("cteator")
            private Long cteator;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

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
             * 配送机构信息。
             */
            @JsonProperty("deliverOrgInfo")
            private DeliverOrgInfoDetails deliverOrgInfo;

            /**
             * 订货机构信息。
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
             * 供货机构信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OpenOppositeOrgDTO {

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
                 * 机构名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 送货机构信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SupplyOrgInfoDetails {

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
                 * 机构名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 收货类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveTypeDetails {

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
             * 配送机构信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DeliverOrgInfoDetails {

                /**
                 * 类型。
                 */
                @JsonProperty("type")
                private TypeDetails type;

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
                 * 类型。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class TypeDetails {

                    /**
                     * 标识符。
                     */
                    @JsonProperty("id")
                    private Long id;

                    /**
                     * 名称。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }
        }

        /**
         * 配送收货单明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AcceptanceOrderItemDetailDTO {

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
             * 收货仓库信息。
             */
            @JsonProperty("acceptWarehouseInfo")
            private WarehouseOpenDTO acceptWarehouseInfo;

            /**
             * 订货单位。
             */
            @JsonProperty("bizUnit")
            private UnitOpenDTO bizUnit;

            /**
             * 基准单位。
             */
            @JsonProperty("baseUnit")
            private BaseUnitDetails baseUnit;

            /**
             * 收货数量和基准单位数量。
             */
            @JsonProperty("acceptAmount")
            private MultiUnitAmountOpenDTO acceptAmount;

            /**
             * 订货数量和基准单位数量。
             */
            @JsonProperty("demandAmount")
            private DemandAmountDetails demandAmount;

            /**
             * 接单数量和基准单位数量。
             */
            @JsonProperty("applyAuditAmount")
            private ApplyAuditAmountDetails applyAuditAmount;

            /**
             * 发货数量和基准单位数量。
             */
            @JsonProperty("deliverAmpunt")
            private DeliverAmpuntDetails deliverAmpunt;

            /**
             * 订发差异数量和基准单位数量。
             */
            @JsonProperty("demandDeliverDiffAmount")
            private DemandDeliverDiffAmountDetails demandDeliverDiffAmount;

            /**
             * 收货金额(不含税)。
             */
            @JsonProperty("acceptNoTaxMoney")
            private String acceptNoTaxMoney;

            /**
             * 收货金额(含税)。
             */
            @JsonProperty("acceptMoney")
            private String acceptMoney;

            /**
             * 订发差异金额(含税)。
             */
            @JsonProperty("demandDeliverDiffMoney")
            private String demandDeliverDiffMoney;

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
             * 实物批次号。
             */
            @JsonProperty("batchNum")
            private String batchNum;

            /**
             * 生产日期。
             */
            @JsonProperty("productionDate")
            private Long productionDate;

            /**
             * 过期日期。
             */
            @JsonProperty("expirationDate")
            private Long expirationDate;

            /**
             * 保质期。
             */
            @JsonProperty("shelfLife")
            private Integer shelfLife;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 物品信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class GoodsOpenDTO {

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
                 * 物品分类。
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
            }

            /**
             * 收货仓库信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WarehouseOpenDTO {

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
             * 订货单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

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
             * 基准单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BaseUnitDetails {

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
             * 收货数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class MultiUnitAmountOpenDTO {

                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 订货数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DemandAmountDetails {

                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 接单数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ApplyAuditAmountDetails {

                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 发货数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DeliverAmpuntDetails {

                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }

            /**
             * 订发差异数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DemandDeliverDiffAmountDetails {

                /**
                 * 基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 业务数量。
                 */
                @JsonProperty("bizUnitAmount")
                private String bizUnitAmount;
            }
        }
    }
}
