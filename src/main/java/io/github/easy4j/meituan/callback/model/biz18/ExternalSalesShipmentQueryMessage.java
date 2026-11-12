package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

import java.util.List;

/**
 * 美团「【供应链】查询外销发货单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810271}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_09b3f340-8836-4439-afc3-904fd69d9361">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalSalesShipmentQueryMessage {

    /**
     * 总部机构。
     */
    @JsonProperty("rootOrgId")
    private Long rootOrgId;
    /**
     * 推送事件 ID。
     */
    @JsonProperty("pushEventId")
    private String pushEventId;
    /**
     * 操作类型。
     */
    @JsonProperty("opType")
    private Integer opType;
    /**
     * 消息时序Id。
     */
    @JsonProperty("seqId")
    private Long seqId;
    /**
     * 大消息体标识。
     */
    @JsonProperty("largeMessageTag")
    private Boolean largeMessageTag;
    /**
     * 销售发货单信息。
     */
    @JsonProperty("bizData")
    private SaleDeliveryOrderOpenDTO bizData;

    /**
     * 创建美团「【供应链】查询外销发货单消息」回调的业务内容。的空实例。
     */
    public ExternalSalesShipmentQueryMessage() {
    }

    /**
     * 销售发货单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SaleDeliveryOrderOpenDTO {

        /**
         * 销售发货单主单。
         */
        @JsonProperty("item")
        private SaleDeliverOrderItemOpenDTO item;
        /**
         * 销售发货单物品明细。
         */
        @JsonProperty("details")
        private List<SaleDeliverOrderDetailOpenDTO> details;

        /**
         * 创建销售发货单信息。的空实例。
         */
        public SaleDeliveryOrderOpenDTO() {
        }

        /**
         * 销售发货单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleDeliverOrderItemOpenDTO {

            /**
             * 销售发货单号。
             */
            @JsonProperty("saleDeliveryOrderSn")
            private String saleDeliveryOrderSn;
            /**
             * 来源销售订单编号。
             */
            @JsonProperty("sourceSaleOrderSn")
            private String sourceSaleOrderSn;
            /**
             * 销售机构。
             */
            @JsonProperty("saleOrganization")
            private OrgOpenDTO saleOrganization;
            /**
             * 客户信息。
             */
            @JsonProperty("customer")
            private CustomerOpenDTO customer;
            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private UserOpenDTO creator;
            /**
             * 账号创建类型2 总部创建, 3 门店创建。
             */
            @JsonProperty("createType")
            private Integer createType;
            /**
             * 单据状态（301：待发货 302：已关闭 303：已发货）。
             */
            @JsonProperty("status")
            private PairDTO status;
            /**
             * id。
             */
            @JsonProperty("tax")
            private Integer tax;
            /**
             * 描述。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;
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
            @JsonProperty("lastModifiedTime")
            private Long lastModifiedTime;
            /**
             * 发货日期。
             */
            @JsonProperty("deliveryTime")
            private Long deliveryTime;
            /**
             * 订单日期。
             */
            @JsonProperty("orderTime")
            private Long orderTime;
            /**
             * 期望到货日期。
             */
            @JsonProperty("expectedArrivalTime")
            private Long expectedArrivalTime;
            /**
             * 版本号。
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
             * 复审状态（1：未复审 2：已复审）。
             */
            @JsonProperty("reviewStatus")
            private ReviewStatusDetails reviewStatus;
            /**
             * 发货仓库。
             */
            @JsonProperty("deliveryWarehouse")
            private WarehouseOpenDTO deliveryWarehouse;
            /**
             * 发货金额（含税）。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 创建销售发货单主单。的空实例。
             */
            public SaleDeliverOrderItemOpenDTO() {
            }

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

                /**
                 * 创建销售机构。的空实例。
                 */
                public OrgOpenDTO() {
                }
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
                 * 名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 创建创建人。的空实例。
                 */
                public UserOpenDTO() {
                }
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

                /**
                 * 创建地址。的空实例。
                 */
                public OrgAddressOpenDTO() {
                }
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
                 * 创建业务员。的空实例。
                 */
                public ResponsiblePersonOpenDTO() {
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

                /**
                 * 创建发货仓库。的空实例。
                 */
                public WarehouseOpenDTO() {
                }
            }
        }

        /**
         * 销售发货单物品明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleDeliverOrderDetailOpenDTO {

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
             * 销售单价（含税）。
             */
            @JsonProperty("price")
            private String price;
            /**
             * 基准单位销售单价（含税）。
             */
            @JsonProperty("baseUnitPrice")
            private String baseUnitPrice;
            /**
             * 基准单位审核数量。
             */
            @JsonProperty("baseUnitAmount")
            private String baseUnitAmount;
            /**
             * 销售数量（审核数量）。
             */
            @JsonProperty("amount")
            private String amount;
            /**
             * 发货数量。
             */
            @JsonProperty("deliveryAmount")
            private String deliveryAmount;
            /**
             * 基准单位数量（发货数量）基准单位数量（发货数量）。
             */
            @JsonProperty("deliveryBaseUnitAmount")
            private String deliveryBaseUnitAmount;
            /**
             * 发货金额（含税）。
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
             * 销售单价（不含税）。
             */
            @JsonProperty("noTaxPrice")
            private String noTaxPrice;
            /**
             * 发货金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;
            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;
            /**
             * 批次号。
             */
            @JsonProperty("batchNum")
            private String batchNum;
            /**
             * 生产日期。
             */
            @JsonProperty("productionDate")
            private Long productionDate;
            /**
             * 到期日期。
             */
            @JsonProperty("expirationDate")
            private Long expirationDate;
            /**
             * 保质期（天）。
             */
            @JsonProperty("shelfLife")
            private Integer shelfLife;
            /**
             * 来源销售订单明细 ID。
             */
            @JsonProperty("saleOrderDetailId")
            private String saleOrderDetailId;

            /**
             * 创建销售发货单物品明细。的空实例。
             */
            public SaleDeliverOrderDetailOpenDTO() {
            }

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
                private String category;
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
                private List<JsonNode> units;
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
                 * 创建物品信息。的空实例。
                 */
                public GoodsOpenDTO() {
                }
            }
        }
    }
}
