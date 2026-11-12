package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】采购订单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810105}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_ed3842bf-0e58-4e5b-90e6-9a3e30cb93a8">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseOrderMessage {

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
     * 采购订单信息。必填。
     */
    @JsonProperty("bizData")
    private PurchaseOrderDTO bizData;

    /**
     * 采购订单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PurchaseOrderDTO {

        /**
         * 采购订单主单。
         */
        @JsonProperty("item")
        private PurchaseOrderItemDTO item;

        /**
         * 采购订单明细。
         */
        @JsonProperty("details")
        private List<PurchaseOrderItemDetailDTO> details;

        /**
         * 采购订单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PurchaseOrderItemDTO {

            /**
             * 总部 ID。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 采购机构。
             */
            @JsonProperty("orgInfo")
            private OrgOpenDTO orgInfo;

            /**
             * 收货机构。
             */
            @JsonProperty("receiveOrgInfo")
            private ReceiveOrgInfoDetails receiveOrgInfo;

            /**
             * 供应商信息。
             */
            @JsonProperty("supplierInfo")
            private SupplierOpenDTO supplierInfo;

            /**
             * 单据号。
             */
            @JsonProperty("purchaseOrderSn")
            private String purchaseOrderSn;

            /**
             * 来源单据号。
             */
            @JsonProperty("sourceSn")
            private String sourceSn;

            /**
             * 单据状态。
             */
            @JsonProperty("orderStatus")
            private JsonNode orderStatus;

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
             * 业务日期。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 创建日期。
             */
            @JsonProperty("createTime")
            private Long createTime;

            /**
             * 订单联系人&amp;地址。
             */
            @JsonProperty("orgAddress")
            private OrgAddressOpenDTO orgAddress;

            /**
             * 订单备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 更新时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 期望到货日期。
             */
            @JsonProperty("expectTime")
            private Long expectTime;

            /**
             * 来源单据号集合。
             */
            @JsonProperty("sourceSnList")
            private List<String> sourceSnList;

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
             * 订单联系人信息分配维度（1.单据维度 2.明细维度）。
             */
            @JsonProperty("addressDimension")
            private Integer addressDimension;

            /**
             * 采购机构。
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
             * 收货机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveOrgInfoDetails {

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
             * 订单联系人&amp;地址。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgAddressOpenDTO {

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
        }

        /**
         * 采购订单明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PurchaseOrderItemDetailDTO {

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
             * 总部 ID。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;

            /**
             * 单据号。
             */
            @JsonProperty("purchaseOrderSn")
            private String purchaseOrderSn;

            /**
             * 是否赠品。
             */
            @JsonProperty("gift")
            private Boolean gift;

            /**
             * 物品信息。
             */
            @JsonProperty("goods")
            private GoodsOpenDTO goods;

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
             * 审核单价。
             */
            @JsonProperty("auditPrice")
            private String auditPrice;

            /**
             * 采购单价。
             */
            @JsonProperty("purchasePrice")
            private String purchasePrice;

            /**
             * 审核金额。
             */
            @JsonProperty("auditMoney")
            private String auditMoney;

            /**
             * 审核金额（不含税）。
             */
            @JsonProperty("auditNoTaxMoney")
            private String auditNoTaxMoney;

            /**
             * 采购金额。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 采购金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 审核数量。
             */
            @JsonProperty("auditAmount")
            private String auditAmount;

            /**
             * 审核基准单位数量。
             */
            @JsonProperty("auditBaseUnitAmount")
            private String auditBaseUnitAmount;

            /**
             * 采购数量。
             */
            @JsonProperty("purchaseAmount")
            private String purchaseAmount;

            /**
             * 采购基准单位数量。
             */
            @JsonProperty("purchaseBaseUnitAmount")
            private String purchaseBaseUnitAmount;

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
             * 订单联系人&amp;地址。
             */
            @JsonProperty("orgAddress")
            private OrgAddressOpenDTO orgAddress;

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
                private SimpleCategoryOpenDTO category;

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
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 订单联系人&amp;地址。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgAddressOpenDTO {

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
        }
    }
}
