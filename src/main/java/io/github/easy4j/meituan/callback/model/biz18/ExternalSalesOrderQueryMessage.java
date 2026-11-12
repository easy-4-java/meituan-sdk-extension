package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】查询外销订单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810269}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_12595847-1e02-4bce-ac29-b3a4fd120ac5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalSalesOrderQueryMessage {

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
     * 销售订单信息。必填。
     */
    @JsonProperty("bizData")
    private SaleOrderOpenDTO bizData;

    /**
     * 销售订单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SaleOrderOpenDTO {

        /**
         * 销售订单主单。
         */
        @JsonProperty("item")
        private SaleOrderItemOpenDTO item;

        /**
         * 销售定单物品明细。
         */
        @JsonProperty("details")
        private SaleOrderDetailOpenDTO details;

        /**
         * 销售订单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleOrderItemOpenDTO {

            /**
             * 销售订单单号。
             */
            @JsonProperty("saleOrderSn")
            private String saleOrderSn;

            /**
             * 下游单据（出库单号）。
             */
            @JsonProperty("deliveryOrderSns")
            private List<String> deliveryOrderSns;

            /**
             * 销售机构。
             */
            @JsonProperty("saleOrganization")
            private OrgOpenDTO saleOrganization;

            /**
             * 客户。
             */
            @JsonProperty("customer")
            private CustomerOpenDTO customer;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private UserOpenDTO creator;

            /**
             * 单据状态（201：待提交 202：待审核 203：已驳回 204：已关闭 209：已审核）。
             */
            @JsonProperty("status")
            private PairDTO status;

            /**
             * 分仓状态（10：待分仓 20：已分仓）。
             */
            @JsonProperty("distributedWarehouseStatus")
            private DistributedWarehouseStatusDetails distributedWarehouseStatus;

            /**
             * 收款状态（10：待收款 20：已收款待确认 30：已确认收款）。
             */
            @JsonProperty("payStatus")
            private PayStatusDetails payStatus;

            /**
             * 订单金额（含税）。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;

            /**
             * 地址。
             */
            @JsonProperty("orgAddress")
            private OrgAddressOpenDTO orgAddress;

            /**
             * 创建日期。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 最后操作时间。
             */
            @JsonProperty("modifiedTime")
            private Long modifiedTime;

            /**
             * 订单日期。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 期望到货日期。
             */
            @JsonProperty("expectReceiveTime")
            private Long expectReceiveTime;

            /**
             * 订单版本号。
             */
            @JsonProperty("version")
            private Integer version;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 业务员。
             */
            @JsonProperty("salesperson")
            private ResponsiblePersonOpenDTO salesperson;

            /**
             * 销售机构。
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
                 * 机构根节点 ID。
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
             * 创建人。
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
                 * 账号创建类型2 总部创建, 3 门店创建。
                 */
                @JsonProperty("createType")
                private Integer createType;
            }

            /**
             * 分仓状态（10：待分仓 20：已分仓）。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DistributedWarehouseStatusDetails {

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
             * 地址。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgAddressOpenDTO {

                /**
                 * 联系人姓名。
                 */
                @JsonProperty("contactName")
                private String contactName;

                /**
                 * 联系人电话。
                 */
                @JsonProperty("phone")
                private String phone;

                /**
                 * 地址信息。
                 */
                @JsonProperty("address")
                private String address;
            }

            /**
             * 业务员。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ResponsiblePersonOpenDTO {

                /**
                 * 主键 ID。
                 */
                @JsonProperty("id")
                private Long id;

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
                 * 状态。
                 */
                @JsonProperty("status")
                private JsonNode status;

                /**
                 * 备注。
                 */
                @JsonProperty("remark")
                private String remark;
            }
        }

        /**
         * 销售定单物品明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleOrderDetailOpenDTO {

            /**
             * 明细行 ID。
             */
            @JsonProperty("id")
            private String id;

            /**
             * 物品信息。
             */
            @JsonProperty("goods")
            private GoodsOpenDTO goods;

            /**
             * 销售单价(含税)。
             */
            @JsonProperty("price")
            private String price;

            /**
             * 销售数量。
             */
            @JsonProperty("amount")
            private String amount;

            /**
             * 审核数量。
             */
            @JsonProperty("auditAmount")
            private String auditAmount;

            /**
             * 基准单位销售审核单价。
             */
            @JsonProperty("auditPrice")
            private String auditPrice;

            /**
             * 基准单位销售数量。
             */
            @JsonProperty("baseUnitAmount")
            private String baseUnitAmount;

            /**
             * 基准单位审核数量。
             */
            @JsonProperty("auditBaseUnitAmount")
            private String auditBaseUnitAmount;

            /**
             * 销售金额(含税)。
             */
            @JsonProperty("money")
            private String money;

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
             * 销售单价(不含税)。
             */
            @JsonProperty("noTaxPrice")
            private String noTaxPrice;

            /**
             * 销售金额(不含税)。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 发货仓库。
             */
            @JsonProperty("deliveryWarehouse")
            private WarehouseOpenDTO deliveryWarehouse;

            /**
             * 套餐子项明细。
             */
            @JsonProperty("comboItems")
            private List<SaleComboItemOpenDTO> comboItems;

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
                private JsonNode baseUnit;

                /**
                 * 支持的单位名称列表。
                 */
                @JsonProperty("units")
                private JsonNode units;

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
            }

            /**
             * 发货仓库。
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
             * 套餐子项明细。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SaleComboItemOpenDTO {

                /**
                 * 主键 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 分组 ID。
                 */
                @JsonProperty("comboGroupId")
                private Long comboGroupId;

                /**
                 * 物品信息。
                 */
                @JsonProperty("goodsOpenDTO")
                private GoodsOpenDTO goodsOpenDTO;

                /**
                 * 物品数量。
                 */
                @JsonProperty("amount")
                private String amount;

                /**
                 * 物品价格(含税)。
                 */
                @JsonProperty("price")
                private String price;

                /**
                 * 物品价格(不含税)。
                 */
                @JsonProperty("noTaxPrice")
                private String noTaxPrice;

                /**
                 * 物品金额（含税）。
                 */
                @JsonProperty("money")
                private String money;

                /**
                 * 物品金额（不含税）。
                 */
                @JsonProperty("noTaxMoney")
                private String noTaxMoney;

                /**
                 * 物品税率。
                 */
                @JsonProperty("taxRatetaxRate")
                private String taxRatetaxRate;

                /**
                 * 物品税额。
                 */
                @JsonProperty("tax")
                private String tax;

                /**
                 * 物品基准单位数量。
                 */
                @JsonProperty("baseUnitAmount")
                private String baseUnitAmount;

                /**
                 * 物品审核基准单位数量。
                 */
                @JsonProperty("auditBaseUnitAmount")
                private String auditBaseUnitAmount;

                /**
                 * 物品审核单价。
                 */
                @JsonProperty("auditPrice")
                private String auditPrice;

                /**
                 * 物品审核数量。
                 */
                @JsonProperty("auditAmount")
                private String auditAmount;

                /**
                 * 物品审核金额。
                 */
                @JsonProperty("auditMoney")
                private String auditMoney;

                /**
                 * 前端物品行唯一标识uuid。
                 */
                @JsonProperty("uuid")
                private String uuid;

                /**
                 * 发货仓库。
                 */
                @JsonProperty("deliveryWarehouse")
                private WarehouseOpenDTO deliveryWarehouse;

                /**
                 * 物品是否入库。
                 */
                @JsonProperty("stockIn")
                private Boolean stockIn;

                /**
                 * 物品库存总数量，销售单位。
                 */
                @JsonProperty("stockAmount")
                private String stockAmount;

                /**
                 * 物品备注。
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
                    private JsonNode baseUnit;

                    /**
                     * 支持的单位名称列表支持的单位名称列表。
                     */
                    @JsonProperty("units")
                    private JsonNode units;

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
                }

                /**
                 * 发货仓库。
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
            }
        }
    }
}
