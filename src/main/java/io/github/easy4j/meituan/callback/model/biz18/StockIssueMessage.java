package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】出库单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810179}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_ec58ddbd-dbbb-420f-8d1a-3d2402a9bcf1">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockIssueMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u51fa\u5e93\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StockIssueMessage() {
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
     * 出库单信息。必填。
     */
    @JsonProperty("bizData")
    private StockOutDTO bizData;

    /**
     * 出库单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StockOutDTO {

        /**
         * 创建\u51fa\u5e93\u5355\u4fe1\u606f\u3002的空实例。
         */
        public StockOutDTO() {
        }


        /**
         * 主单信息。
         */
        @JsonProperty("item")
        private StockOutItemDTO item;

        /**
         * 明细信息。
         */
        @JsonProperty("details")
        private List<StockOutItemDetailDTO> details;

        /**
         * 主单信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StockOutItemDTO {

            /**
             * 创建\u4e3b\u5355\u4fe1\u606f\u3002的空实例。
             */
            public StockOutItemDTO() {
            }


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
             * 业务日期。
             */
            @JsonProperty("bizTime")
            private Long bizTime;

            /**
             * 机构信息。
             */
            @JsonProperty("org")
            private OrgOpenDTO org;

            /**
             * 归属机构。
             */
            @JsonProperty("belongOrg")
            private BelongOrgDetails belongOrg;

            /**
             * 仓库信息。
             */
            @JsonProperty("warehouse")
            private WarehouseOpenDTO warehouse;

            /**
             * 对方机构。
             */
            @JsonProperty("oppositeOrg")
            private OpenOppositeOrgDTO oppositeOrg;

            /**
             * 出库单审核状态。
             */
            @JsonProperty("status")
            private PairDTO status;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 出库类型。
             */
            @JsonProperty("type")
            private TypeDetails type;

            /**
             * 来源单据号。
             */
            @JsonProperty("sourceSn")
            private String sourceSn;

            /**
             * 创建时间。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 成本金额（不含税）。
             */
            @JsonProperty("stockMoney")
            private String stockMoney;

            /**
             * 金额（含税）。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 税率。
             */
            @JsonProperty("tax")
            private String tax;

            /**
             * 金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 修改时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 版本号。
             */
            @JsonProperty("version")
            private Integer version;

            /**
             * 第三方单据号。
             */
            @JsonProperty("thirdRelatedSn")
            private String thirdRelatedSn;

            /**
             * 删除状态。
             */
            @JsonProperty("deleteStatus")
            private Integer deleteStatus;

            /**
             * 调价标记。
             */
            @JsonProperty("adjusted")
            private Boolean adjusted;

            /**
             * 业务员。
             */
            @JsonProperty("responsiblePerson")
            private ResponsiblePersonOpenDTO responsiblePerson;

            /**
             * 成本金额（含税）。
             */
            @JsonProperty("stockMoneyWithTax")
            private String stockMoneyWithTax;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private UserOpenDTO creator;

            /**
             * 提交人。
             */
            @JsonProperty("submitter")
            private SubmitterDetails submitter;

            /**
             * 审核人。
             */
            @JsonProperty("auditor")
            private AuditorDetails auditor;

            /**
             * 提交时间。
             */
            @JsonProperty("submitTime")
            private Long submitTime;

            /**
             * 审核时间。
             */
            @JsonProperty("auditTime")
            private Long auditTime;

            /**
             * 业务类型。
             */
            @JsonProperty("bizType")
            private BizTypeOpenDTO bizType;

            /**
             * 机构信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

                /**
                 * 创建\u673a\u6784\u4fe1\u606f\u3002的空实例。
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
             * 仓库信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WarehouseOpenDTO {

                /**
                 * 创建\u4ed3\u5e93\u4fe1\u606f\u3002的空实例。
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
             * 业务员。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ResponsiblePersonOpenDTO {

                /**
                 * 创建\u4e1a\u52a1\u5458\u3002的空实例。
                 */
                public ResponsiblePersonOpenDTO() {
                }


                /**
                 * id。
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
                private PairDTO status;

                /**
                 * 备注。
                 */
                @JsonProperty("remark")
                private String remark;

                /**
                 * 绑定员工。
                 */
                @JsonProperty("bindStaff")
                private UserOpenDTO bindStaff;

                /**
                 * 适用机构列表。
                 */
                @JsonProperty("applicableOrganizations")
                private List<OrgOpenDTO> applicableOrganizations;

                /**
                 * 绑定员工。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UserOpenDTO {

                    /**
                     * 创建\u7ed1\u5b9a\u5458\u5de5\u3002的空实例。
                     */
                    public UserOpenDTO() {
                    }


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
                     * 员工账号。
                     */
                    @JsonProperty("userName")
                    private String userName;

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
                     * 智能版账号 ID。
                     */
                    @JsonProperty("bizAccountId")
                    private Long bizAccountId;
                }

                /**
                 * 适用机构列表。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class OrgOpenDTO {

                    /**
                     * 创建\u9002\u7528\u673a\u6784\u5217\u8868\u3002的空实例。
                     */
                    public OrgOpenDTO() {
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

            /**
             * 创建人。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UserOpenDTO {

                /**
                 * 创建\u521b\u5efa\u4eba\u3002的空实例。
                 */
                public UserOpenDTO() {
                }


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
                 * 员工账号。
                 */
                @JsonProperty("userName")
                private String userName;

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
                 * 智能版账号 ID。
                 */
                @JsonProperty("bizAccountId")
                private Long bizAccountId;
            }

            /**
             * 提交人。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SubmitterDetails {

                /**
                 * 创建\u63d0\u4ea4\u4eba\u3002的空实例。
                 */
                public SubmitterDetails() {
                }


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
                 * 员工账号。
                 */
                @JsonProperty("userName")
                private String userName;

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
                 * 智能版账号 ID。
                 */
                @JsonProperty("bizAccountId")
                private Long bizAccountId;
            }

            /**
             * 审核人。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AuditorDetails {

                /**
                 * 创建\u5ba1\u6838\u4eba\u3002的空实例。
                 */
                public AuditorDetails() {
                }


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
                 * 员工账号。
                 */
                @JsonProperty("userName")
                private String userName;

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
                 * 智能版账号 ID。
                 */
                @JsonProperty("bizAccountId")
                private Long bizAccountId;
            }

            /**
             * 业务类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BizTypeOpenDTO {

                /**
                 * 创建\u4e1a\u52a1\u7c7b\u578b\u3002的空实例。
                 */
                public BizTypeOpenDTO() {
                }


                /**
                 * 业务类型编码。
                 */
                @JsonProperty("bizTypeCode")
                private String bizTypeCode;

                /**
                 * 业务类型状态。
                 */
                @JsonProperty("bizTypeName")
                private String bizTypeName;

                /**
                 * 系统内置名称。
                 */
                @JsonProperty("systemName")
                private String systemName;

                /**
                 * 业务类型状态。
                 */
                @JsonProperty("status")
                private PairDTO status;

                /**
                 * 单据类型。
                 */
                @JsonProperty("ioType")
                private IoTypeDetails ioType;

                /**
                 * 原因编码。
                 */
                @JsonProperty("reasonCode")
                private String reasonCode;
            }
        }

        /**
         * 明细信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StockOutItemDetailDTO {

            /**
             * 创建\u660e\u7ec6\u4fe1\u606f\u3002的空实例。
             */
            public StockOutItemDetailDTO() {
            }


            /**
             * 明细 ID。
             */
            @JsonProperty("id")
            private String id;

            /**
             * 序号。
             */
            @JsonProperty("seqId")
            private Integer seqId;

            /**
             * 仓库信息。
             */
            @JsonProperty("warehouse")
            private WarehouseOpenDTO warehouse;

            /**
             * 物品信息。
             */
            @JsonProperty("goods")
            private GoodsOpenDTO goods;

            /**
             * 基准单位信息。
             */
            @JsonProperty("baseUnit")
            private String baseUnit;

            /**
             * 业务单位信息。
             */
            @JsonProperty("bizUnit")
            private String bizUnit;

            /**
             * 基准单位数量。
             */
            @JsonProperty("amount")
            private String amount;

            /**
             * 基准单位单价（含税）。
             */
            @JsonProperty("price")
            private String price;

            /**
             * 金额（含税）。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 基准单位单价（不含税）。
             */
            @JsonProperty("noTaxPrice")
            private String noTaxPrice;

            /**
             * 金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;

            /**
             * 差异金额。
             */
            @JsonProperty("diffMoney")
            private String diffMoney;

            /**
             * 基准单位成本单价（不含税）。
             */
            @JsonProperty("stockPrice")
            private String stockPrice;

            /**
             * 成本金额（不含税）。
             */
            @JsonProperty("stockMoney")
            private String stockMoney;

            /**
             * 数量。
             */
            @JsonProperty("bizUnitAmount")
            private String bizUnitAmount;

            /**
             * 单价（含税）。
             */
            @JsonProperty("bizUnitPrice")
            private String bizUnitPrice;

            /**
             * 单价（不含税）。
             */
            @JsonProperty("bizUnitNoTaxPrice")
            private String bizUnitNoTaxPrice;

            /**
             * 成本单价（不含税）。
             */
            @JsonProperty("bizUnitStockPrice")
            private String bizUnitStockPrice;

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
             * 条形码。
             */
            @JsonProperty("barCode")
            private String barCode;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 唯一键 ID。
             */
            @JsonProperty("uniqueId")
            private String uniqueId;

            /**
             * 赠品标识。
             */
            @JsonProperty("giftTag")
            private PairDTO giftTag;

            /**
             * 关联的上一级单据明细 ID。
             */
            @JsonProperty("sourceDetailId")
            private String sourceDetailId;

            /**
             * 成本单价（含税）。
             */
            @JsonProperty("bizUnitStockPriceWithTax")
            private String bizUnitStockPriceWithTax;

            /**
             * 成本金额（含税）。
             */
            @JsonProperty("stockMoneyWithTax")
            private String stockMoneyWithTax;

            /**
             * 业务类型。
             */
            @JsonProperty("bizType")
            private BizTypeOpenDTO bizType;

            /**
             * 仓库信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WarehouseOpenDTO {

                /**
                 * 创建\u4ed3\u5e93\u4fe1\u606f\u3002的空实例。
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
        }
    }
}
