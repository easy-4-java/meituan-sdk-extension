package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】采购退货单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810107}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_104d68dc-8bff-4b27-a618-97333b2beab8">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseReturnMessage {

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
     * 采购退货单信息。必填。
     */
    @JsonProperty("bizData")
    private PurchaseReturnOrderDTO bizData;

    /**
     * 采购退货单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PurchaseReturnOrderDTO {

        /**
         * 退货单主单。
         */
        @JsonProperty("item")
        private ReturnOrderItemDTO item;

        /**
         * 退货单明细。
         */
        @JsonProperty("details")
        private List<ReturnOrderItemDetailDTO> details;

        /**
         * 退货单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ReturnOrderItemDTO {

            /**
             * 总部机构。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 单据号。
             */
            @JsonProperty("itemSn")
            private String itemSn;

            /**
             * 退货日期。
             */
            @JsonProperty("bizTime")
            private Long bizTime;

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
             * 退货机构信息。
             */
            @JsonProperty("returnOrgInfo")
            private OrgOpenDTO returnOrgInfo;

            /**
             * 供应商信息。
             */
            @JsonProperty("supplierInfo")
            private SupplierOpenDTO supplierInfo;

            /**
             * 退货状态列表。
             */
            @JsonProperty("status")
            private JsonNode status;

            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;

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
             * 业务模式。
             */
            @JsonProperty("bizModel")
            private Integer bizModel;

            /**
             * 来源单据号。
             */
            @JsonProperty("sourceSn")
            private String sourceSn;

            /**
             * 来源采购订单。
             */
            @JsonProperty("sourcePurchaseSn")
            private String sourcePurchaseSn;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 下游单据号。
             */
            @JsonProperty("downstreamSns")
            private List<String> downstreamSns;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private Long creator;

            /**
             * 版本号。
             */
            @JsonProperty("version")
            private Integer version;

            /**
             * 退货原因。
             */
            @JsonProperty("returnReason")
            private ReasonOpenDTO returnReason;

            /**
             * 删除状态。
             */
            @JsonProperty("deleteStatus")
            private Integer deleteStatus;

            /**
             * 退货机构信息。
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
        }

        /**
         * 退货单明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ReturnOrderItemDetailDTO {

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
             * 来源采购订单明细Id。
             */
            @JsonProperty("sourcePurchaseOrderDetailId")
            private String sourcePurchaseOrderDetailId;

            /**
             * 物品信息。
             */
            @JsonProperty("goodsInfo")
            private GoodsOpenDTO goodsInfo;

            /**
             * 退货仓库信息。
             */
            @JsonProperty("returnWarehouseInfo")
            private WarehouseOpenDTO returnWarehouseInfo;

            /**
             * 业务单位。
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
            @JsonProperty("receiveAmount")
            private MultiUnitAmountOpenDTO receiveAmount;

            /**
             * 退货数量和基准单位数量。
             */
            @JsonProperty("returnAmount")
            private ReturnAmountDetails returnAmount;

            /**
             * 退货金额(含税)。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 退货金额(不含税)。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 退货单价(含税)。
             */
            @JsonProperty("bizUnitPrice")
            private String bizUnitPrice;

            /**
             * 退货单价(不含税)。
             */
            @JsonProperty("bizUnitNoTaxPrice")
            private String bizUnitNoTaxPrice;

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
                private JsonNode category;

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
                 * 版本号。
                 */
                @JsonProperty("version")
                private Integer version;

                /**
                 * 第三方编码。
                 */
                @JsonProperty("thirdCode")
                private String thirdCode;

                /**
                 * 基准单位名称。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitOpenDTO {

                    /**
                     * 单位 ID。
                     */
                    @JsonProperty("id")
                    private String id;

                    /**
                     * 单位名称。
                     */
                    @JsonProperty("name")
                    private String name;

                    /**
                     * 单位编码。
                     */
                    @JsonProperty("code")
                    private String code;
                }

                /**
                 * 支持的单位名称列表。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitsItem {

                    /**
                     * 单位 ID。
                     */
                    @JsonProperty("id")
                    private String id;

                    /**
                     * 单位名称。
                     */
                    @JsonProperty("name")
                    private String name;

                    /**
                     * 单位编码。
                     */
                    @JsonProperty("code")
                    private String code;
                }
            }

            /**
             * 退货仓库信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WarehouseOpenDTO {

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
             * 业务单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 单位编码。
                 */
                @JsonProperty("code")
                private String code;
            }

            /**
             * 基准单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BaseUnitDetails {

                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 单位编码。
                 */
                @JsonProperty("code")
                private String code;
            }

            /**
             * 收货数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class MultiUnitAmountOpenDTO {

                /**
                 * 基准数量。
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
             * 退货数量和基准单位数量。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReturnAmountDetails {

                /**
                 * 基准数量。
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
