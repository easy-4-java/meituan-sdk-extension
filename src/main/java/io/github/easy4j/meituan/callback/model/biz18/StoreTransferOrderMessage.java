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
