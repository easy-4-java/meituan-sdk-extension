package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】门店调拨单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810339}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_e3bfdeab-e8cd-40cb-bce8-36339a757406">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreTransferOrderMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u3010\u4f9b\u5e94\u94fe\u3011\u95e8\u5e97\u8c03\u62e8\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StoreTransferOrderMessage() {
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
     * 业务数据。必填。
     */
    @JsonProperty("bizData")
    private StockAllotOpenDTO bizData;

    /**
     * 业务数据。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StockAllotOpenDTO {

        /**
         * 创建\u4e1a\u52a1\u6570\u636e\u3002的空实例。
         */
        public StockAllotOpenDTO() {
        }


        /**
         * 调拨单号。
         */
        @JsonProperty("allotOrderSn")
        private String allotOrderSn;

        /**
         * 调拨日期。
         */
        @JsonProperty("allotDate")
        private Long allotDate;

        /**
         * 调出门店。
         */
        @JsonProperty("allotOutOrg")
        private OrgOpenDTO allotOutOrg;

        /**
         * 调出仓库。
         */
        @JsonProperty("allotOutWarehouse")
        private WarehouseOpenDTO allotOutWarehouse;

        /**
         * 调拨出库日期。
         */
        @JsonProperty("allotOutTime")
        private Long allotOutTime;

        /**
         * 调入门店。
         */
        @JsonProperty("allotInOrg")
        private AllotInOrgDetails allotInOrg;

        /**
         * 调入仓库。
         */
        @JsonProperty("allotInWarehouse")
        private AllotInWarehouseDetails allotInWarehouse;

        /**
         * 调拨入库日期。
         */
        @JsonProperty("allotInTime")
        private Long allotInTime;

        /**
         * 金额。
         */
        @JsonProperty("money")
        private String money;

        /**
         * 状态。
         */
        @JsonProperty("status")
        private PairDTO status;

        /**
         * 业务员。
         */
        @JsonProperty("responsiblePerson")
        private ResponsiblePersonOpenDTO responsiblePerson;

        /**
         * 调出备注。
         */
        @JsonProperty("allotOutRemark")
        private String allotOutRemark;

        /**
         * 调入备注。
         */
        @JsonProperty("allotInRemark")
        private String allotInRemark;

        /**
         * 创建机构。
         */
        @JsonProperty("createdOrg")
        private CreatedOrgDetails createdOrg;

        /**
         * 创建人。
         */
        @JsonProperty("creator")
        private UserOpenDTO creator;

        /**
         * 创建时间。
         */
        @JsonProperty("createdTime")
        private Long createdTime;

        /**
         * 提交人。
         */
        @JsonProperty("submitter")
        private SubmitterDetails submitter;

        /**
         * 提交时间。
         */
        @JsonProperty("submitTime")
        private Long submitTime;

        /**
         * 审核人。
         */
        @JsonProperty("auditor")
        private AuditorDetails auditor;

        /**
         * 审核时间。
         */
        @JsonProperty("auditTime")
        private Long auditTime;

        /**
         * 发货人。
         */
        @JsonProperty("deliverer")
        private DelivererDetails deliverer;

        /**
         * 发货时间。
         */
        @JsonProperty("deliverTime")
        private Long deliverTime;

        /**
         * 明细信息。
         */
        @JsonProperty("details")
        private List<StockAllotDetailOpenDTO> details;

        /**
         * 调出门店。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrgOpenDTO {

            /**
             * 创建\u8c03\u51fa\u95e8\u5e97\u3002的空实例。
             */
            public OrgOpenDTO() {
            }


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
         * 调出仓库。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class WarehouseOpenDTO {

            /**
             * 创建\u8c03\u51fa\u4ed3\u5e93\u3002的空实例。
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
         * 调入门店。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AllotInOrgDetails {

            /**
             * 创建\u8c03\u5165\u95e8\u5e97\u3002的空实例。
             */
            public AllotInOrgDetails() {
            }


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
         * 调入仓库。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AllotInWarehouseDetails {

            /**
             * 创建\u8c03\u5165\u4ed3\u5e93\u3002的空实例。
             */
            public AllotInWarehouseDetails() {
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
                 * 员工账号(废弃)。
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
                 * 账号创建类型 2 总部创建, 3 门店创建。
                 */
                @JsonProperty("createType")
                private Integer createType;
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
        }

        /**
         * 创建机构。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CreatedOrgDetails {

            /**
             * 创建\u521b\u5efa\u673a\u6784\u3002的空实例。
             */
            public CreatedOrgDetails() {
            }


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
             * 员工账号(废弃)。
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
             * 账号创建类型 2 总部创建, 3 门店创建。
             */
            @JsonProperty("createType")
            private Integer createType;
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
             * 员工账号(废弃)。
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
             * 账号创建类型 2 总部创建, 3 门店创建。
             */
            @JsonProperty("createType")
            private Integer createType;
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
             * 员工账号(废弃)。
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
             * 账号创建类型 2 总部创建, 3 门店创建。
             */
            @JsonProperty("createType")
            private Integer createType;
        }

        /**
         * 发货人。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DelivererDetails {

            /**
             * 创建\u53d1\u8d27\u4eba\u3002的空实例。
             */
            public DelivererDetails() {
            }


            /**
             * id。
             */
            @JsonProperty("id")
            private String id;

            /**
             * 员工账号(废弃)。
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
             * 账号创建类型 2 总部创建, 3 门店创建。
             */
            @JsonProperty("createType")
            private Integer createType;
        }

        /**
         * 明细信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StockAllotDetailOpenDTO {

            /**
             * 创建\u660e\u7ec6\u4fe1\u606f\u3002的空实例。
             */
            public StockAllotDetailOpenDTO() {
            }


            /**
             * 物品详情信息。
             */
            @JsonProperty("goods")
            private GoodsOpenDTO goods;

            /**
             * 基准单位。
             */
            @JsonProperty("baseUnit")
            private UnitOpenDTO baseUnit;

            /**
             * 基准单位数量。
             */
            @JsonProperty("amount")
            private String amount;

            /**
             * 库存单位。
             */
            @JsonProperty("bizUnit")
            private BizUnitDetails bizUnit;

            /**
             * 调拨数量。
             */
            @JsonProperty("bizUnitAmount")
            private String bizUnitAmount;

            /**
             * 调拨单价（含税）。
             */
            @JsonProperty("bizUnitPrice")
            private String bizUnitPrice;

            /**
             * 金额。
             */
            @JsonProperty("money")
            private String money;

            /**
             * 调拨单价（不含税）。
             */
            @JsonProperty("bizUnitNoTaxPrice")
            private String bizUnitNoTaxPrice;

            /**
             * 调拨金额（不含税）。
             */
            @JsonProperty("noTaxMoney")
            private String noTaxMoney;

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
             * 成本单价（不含税）。
             */
            @JsonProperty("bizUnitStockPrice")
            private String bizUnitStockPrice;

            /**
             * 成本金额（不含税）。
             */
            @JsonProperty("stockMoney")
            private String stockMoney;

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
             * 保质期。
             */
            @JsonProperty("shelfLife")
            private Integer shelfLife;

            /**
             * 过期日期。
             */
            @JsonProperty("expirationDate")
            private Long expirationDate;

            /**
             * 辅助单位。
             */
            @JsonProperty("supplementaryUnit")
            private SupplementaryUnitDetails supplementaryUnit;

            /**
             * 辅助数量。
             */
            @JsonProperty("supplementaryUnitAmount")
            private String supplementaryUnitAmount;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 物品详情信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class GoodsOpenDTO {

                /**
                 * 创建\u7269\u54c1\u8be6\u60c5\u4fe1\u606f\u3002的空实例。
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
                 * 物品类别。
                 */
                @JsonProperty("category")
                private SimpleCategoryOpenDTO category;

                /**
                 * 品牌。
                 */
                @JsonProperty("brand")
                private String brand;

                /**
                 * 规格型号。
                 */
                @JsonProperty("spec")
                private String spec;

                /**
                 * 基准单位。
                 */
                @JsonProperty("baseUnit")
                private UnitOpenDTO baseUnit;

                /**
                 * 单位信息。
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
                 * 基准单位。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitOpenDTO {

                    /**
                     * 创建\u57fa\u51c6\u5355\u4f4d\u3002的空实例。
                     */
                    public UnitOpenDTO() {
                    }


                    /**
                     * 单位 ID。
                     */
                    @JsonProperty("id")
                    private String id;

                    /**
                     * 单位编码。
                     */
                    @JsonProperty("code")
                    private String code;

                    /**
                     * 单位名称。
                     */
                    @JsonProperty("name")
                    private String name;
                }

                /**
                 * 单位信息。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitsItem {

                    /**
                     * 创建\u5355\u4f4d\u4fe1\u606f\u3002的空实例。
                     */
                    public UnitsItem() {
                    }


                    /**
                     * 单位 ID。
                     */
                    @JsonProperty("id")
                    private String id;

                    /**
                     * 单位编码。
                     */
                    @JsonProperty("code")
                    private String code;

                    /**
                     * 单位名称。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }

            /**
             * 基准单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

                /**
                 * 创建\u57fa\u51c6\u5355\u4f4d\u3002的空实例。
                 */
                public UnitOpenDTO() {
                }


                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 库存单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BizUnitDetails {

                /**
                 * 创建\u5e93\u5b58\u5355\u4f4d\u3002的空实例。
                 */
                public BizUnitDetails() {
                }


                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 辅助单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SupplementaryUnitDetails {

                /**
                 * 创建\u8f85\u52a9\u5355\u4f4d\u3002的空实例。
                 */
                public SupplementaryUnitDetails() {
                }


                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;
            }
        }
    }
}
