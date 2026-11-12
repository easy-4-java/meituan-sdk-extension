package io.github.easy4j.meituan.callback.model.biz18;

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
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u914d\u9001\u6536\u8d27\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public DeliveryReceiptMessage() {
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
         * 创建\u914d\u9001\u6536\u8d27\u5355\u4fe1\u606f\u3002的空实例。
         */
        public AcceptanceOrderOpenDTO() {
        }


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
             * 创建\u914d\u9001\u6536\u8d27\u5355\u4e3b\u5355\u3002的空实例。
             */
            public AcceptanceOrderItemDTO() {
            }


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
                 * 创建\u8ba2\u8d27\u673a\u6784\u4fe1\u606f\u3002的空实例。
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
             * 供货机构信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OpenOppositeOrgDTO {

                /**
                 * 创建\u4f9b\u8d27\u673a\u6784\u4fe1\u606f\u3002的空实例。
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
                 * 创建\u9001\u8d27\u673a\u6784\u4fe1\u606f\u3002的空实例。
                 */
                public SupplyOrgInfoDetails() {
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
                 * 创建\u6536\u8d27\u7c7b\u578b\u3002的空实例。
                 */
                public ReceiveTypeDetails() {
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
             * 配送机构信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DeliverOrgInfoDetails {

                /**
                 * 创建\u914d\u9001\u673a\u6784\u4fe1\u606f\u3002的空实例。
                 */
                public DeliverOrgInfoDetails() {
                }


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
                     * 创建\u7c7b\u578b\u3002的空实例。
                     */
                    public TypeDetails() {
                    }


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
             * 创建\u914d\u9001\u6536\u8d27\u5355\u660e\u7ec6\u3002的空实例。
             */
            public AcceptanceOrderItemDetailDTO() {
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
                 * 创建\u6536\u8d27\u4ed3\u5e93\u4fe1\u606f\u3002的空实例。
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
             * 订货单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

                /**
                 * 创建\u8ba2\u8d27\u5355\u4f4d\u3002的空实例。
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
             * 基准单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BaseUnitDetails {

                /**
                 * 创建\u57fa\u51c6\u5355\u4f4d\u3002的空实例。
                 */
                public BaseUnitDetails() {
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
             * 收货数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class MultiUnitAmountOpenDTO {

                /**
                 * 创建\u6536\u8d27\u6570\u91cf\u548c\u57fa\u51c6\u5355\u4f4d\u6570\u91cf\u3002的空实例。
                 */
                public MultiUnitAmountOpenDTO() {
                }


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
                 * 创建\u8ba2\u8d27\u6570\u91cf\u548c\u57fa\u51c6\u5355\u4f4d\u6570\u91cf\u3002的空实例。
                 */
                public DemandAmountDetails() {
                }


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
                 * 创建\u63a5\u5355\u6570\u91cf\u548c\u57fa\u51c6\u5355\u4f4d\u6570\u91cf\u3002的空实例。
                 */
                public ApplyAuditAmountDetails() {
                }


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
                 * 创建\u53d1\u8d27\u6570\u91cf\u548c\u57fa\u51c6\u5355\u4f4d\u6570\u91cf\u3002的空实例。
                 */
                public DeliverAmpuntDetails() {
                }


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
                 * 创建\u8ba2\u53d1\u5dee\u5f02\u6570\u91cf\u548c\u57fa\u51c6\u5355\u4f4d\u6570\u91cf\u3002的空实例。
                 */
                public DemandDeliverDiffAmountDetails() {
                }


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
