package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

import java.util.List;

/**
 * 美团「【供应链】查询外销退货单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810273}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_b67069a5-7c68-4fe8-87d4-8f853396031a">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalSalesReturnQueryMessage {

    /**
     * 根机构 ID。
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
     * 序列标识。
     */
    @JsonProperty("seqId")
    private Long seqId;
    /**
     * 大消息标记。
     */
    @JsonProperty("largeMessageTag")
    private Boolean largeMessageTag;
    /**
     * 销售退货单信息。必填。
     */
    @JsonProperty("bizData")
    private SaleOrderOpenDTO bizData;

    /**
     * 创建美团「【供应链】查询外销退货单消息」回调的业务内容。的空实例。
     */
    public ExternalSalesReturnQueryMessage() {
    }

    /**
     * 销售退货单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SaleOrderOpenDTO {

        /**
         * 销售退货单主单。
         */
        @JsonProperty("item")
        private SaleRefundOrderItemOpenDTO item;
        /**
         * 销售退货单明细。
         */
        @JsonProperty("details")
        private List<SaleRefundOrderDetailOpenDTO> details;

        /**
         * 创建销售退货单信息。的空实例。
         */
        public SaleOrderOpenDTO() {
        }

        /**
         * 销售退货单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleRefundOrderItemOpenDTO {

            /**
             * 销售退货单号。
             */
            @JsonProperty("saleRefundOrderSn")
            private String saleRefundOrderSn;
            /**
             * 来源外销发货单单据号。
             */
            @JsonProperty("sourceDeliveryOrderSn")
            private String sourceDeliveryOrderSn;
            /**
             * 来源外销订单单据号。
             */
            @JsonProperty("sourceSaleOrderSn")
            private String sourceSaleOrderSn;
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
             * 单据状态（601：未提交 602：待审核 603：已驳回 606：已完成）。
             */
            @JsonProperty("status")
            private PairDTO status;
            /**
             * 退货金额（含税）。
             */
            @JsonProperty("money")
            private String money;
            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;
            /**
             * 退货金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;
            /**
             * 地址。
             */
            @JsonProperty("orgAddress")
            private OrgAddressOpenDTO orgAddress;
            /**
             * 创建时间。
             */
            @JsonProperty("createdTime")
            private Long createdTime;
            /**
             * 最后操作时间。
             */
            @JsonProperty("modifiedTime")
            private Long modifiedTime;
            /**
             * 退货日期。
             */
            @JsonProperty("refundDate")
            private Long refundDate;
            /**
             * 退货原因名称。
             */
            @JsonProperty("reason")
            private String reason;
            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private UserOpenDTO creator;
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
            @JsonProperty("responsiblePerson")
            private ResponsiblePersonOpenDTO responsiblePerson;
            /**
             * 复审状态（1：未复审 2：已复审）。
             */
            @JsonProperty("reviewStatus")
            private ReviewStatusDetails reviewStatus;
            /**
             * 入库单单号。
             */
            @JsonProperty("stockInOrderSns")
            private String stockInOrderSns;

            /**
             * 创建销售退货单主单。的空实例。
             */
            public SaleRefundOrderItemOpenDTO() {
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

                /**
                 * 创建创建人。的空实例。
                 */
                public UserOpenDTO() {
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
                 * 备注。
                 */
                @JsonProperty("remark")
                private String remark;

                /**
                 * 创建业务员。的空实例。
                 */
                public ResponsiblePersonOpenDTO() {
                }
            }
        }

        /**
         * 销售退货单明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleRefundOrderDetailOpenDTO {

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
             * 销售数量。
             */
            @JsonProperty("salesAmount")
            private String salesAmount;
            /**
             * 可退数量。
             */
            @JsonProperty("refundableAmount")
            private String refundableAmount;
            /**
             * 退货单价(含税)。
             */
            @JsonProperty("price")
            private String price;
            /**
             * 退货数量。
             */
            @JsonProperty("refundAmount")
            private String refundAmount;
            /**
             * 审核数量。
             */
            @JsonProperty("auditAmount")
            private String auditAmount;
            /**
             * 基准单位退货数量。
             */
            @JsonProperty("refundBaseUnitAmount")
            private String refundBaseUnitAmount;
            /**
             * 基准单位审核数量。
             */
            @JsonProperty("auditBaseUnitAmount")
            private String auditBaseUnitAmount;
            /**
             * 退货金额(含税)。
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
             * 退货单价(不含税)。
             */
            @JsonProperty("noTaxPrice")
            private String noTaxPrice;
            /**
             * 退货金额(不含税)。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;
            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;
            /**
             * 上游销售发货单明细 ID。
             */
            @JsonProperty("deliveryDetailId")
            private String deliveryDetailId;
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
             * 创建销售退货单明细。的空实例。
             */
            public SaleRefundOrderDetailOpenDTO() {
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
