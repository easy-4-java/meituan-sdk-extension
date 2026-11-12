package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「【供应链】盘点单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810341}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_80884496-1de4-4abe-b2f3-37a6f615fc49">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StocktakeOrderMessage {

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
    private StockCheckDTO bizData;

    /**
     * 创建美团「【供应链】盘点单消息」回调的业务内容。的空实例。
     */
    public StocktakeOrderMessage() {
    }

    /**
     * 业务数据。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StockCheckDTO {

        /**
         * 主单。
         */
        @JsonProperty("item")
        private StockCheckItemDTO item;
        /**
         * 明细列表。
         */
        @JsonProperty("details")
        private List<StockCheckItemDetailDTO> details;

        /**
         * 创建业务数据。的空实例。
         */
        public StockCheckDTO() {
        }

        /**
         * 主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StockCheckItemDTO {

            /**
             * 总部机构 ID。
             */
            @JsonProperty("rootOrgId")
            private Long rootOrgId;
            /**
             * 盘点单号。
             */
            @JsonProperty("stockCheckItemSn")
            private String stockCheckItemSn;
            /**
             * 机构信息。
             */
            @JsonProperty("orgInfo")
            private OrgOpenDTO orgInfo;
            /**
             * 仓库信息。
             */
            @JsonProperty("warehouseDTO")
            private WarehouseOpenDTO warehouseDTO;
            /**
             * 创建时间。
             */
            @JsonProperty("createdTime")
            private Long createdTime;
            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;
            /**
             * 盘点时间。
             */
            @JsonProperty("checkTime")
            private Long checkTime;
            /**
             * 版本。
             */
            @JsonProperty("version")
            private Integer version;
            /**
             * 关联单据出库号。
             */
            @JsonProperty("stockOutSn")
            private String stockOutSn;
            /**
             * 关联单据入库号。
             */
            @JsonProperty("stockInSn")
            private String stockInSn;
            /**
             * 盘点类型。
             */
            @JsonProperty("checkType")
            private PairDTO checkType;
            /**
             * 状态。
             */
            @JsonProperty("status")
            private StatusDetails status;
            /**
             * 总账面金额。
             */
            @JsonProperty("totalBookMoney")
            private String totalBookMoney;
            /**
             * 总盘点金额。
             */
            @JsonProperty("totalCheckMoney")
            private String totalCheckMoney;
            /**
             * 总盈亏金额。
             */
            @JsonProperty("totalWinOrLossMoney")
            private String totalWinOrLossMoney;
            /**
             * 盘点确认时间。
             */
            @JsonProperty("confirmCheckTime")
            private Long confirmCheckTime;
            /**
             * 创建来源【1：手动创建 2：月结创建】。
             */
            @JsonProperty("createSource")
            private CreateSourceDetails createSource;
            /**
             * 盘点方式【1：合批盘 2：分批盘】。
             */
            @JsonProperty("checkMode")
            private CheckModeDetails checkMode;
            /**
             * 关联单据。
             */
            @JsonProperty("thirdRelatedSn")
            private String thirdRelatedSn;
            /**
             * 修改时间。
             */
            @JsonProperty("modifiedTime")
            private Long modifiedTime;
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
             * 创建主单。的空实例。
             */
            public StockCheckItemDTO() {
            }

            /**
             * 机构信息。
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
                 * 总部机构 ID。
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
                 * 创建机构信息。的空实例。
                 */
                public OrgOpenDTO() {
                }
            }

            /**
             * 仓库信息。
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
                 * 创建仓库信息。的空实例。
                 */
                public WarehouseOpenDTO() {
                }
            }

            /**
             * 创建来源【1：手动创建 2：月结创建】。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CreateSourceDetails {

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

                /**
                 * 创建创建来源【1：手动创建 2：月结创建】。的空实例。
                 */
                public CreateSourceDetails() {
                }
            }

            /**
             * 盘点方式【1：合批盘 2：分批盘】。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CheckModeDetails {

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

                /**
                 * 创建盘点方式【1：合批盘 2：分批盘】。的空实例。
                 */
                public CheckModeDetails() {
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

                /**
                 * 创建创建人。的空实例。
                 */
                public UserOpenDTO() {
                }
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

                /**
                 * 创建提交人。的空实例。
                 */
                public SubmitterDetails() {
                }
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

                /**
                 * 创建审核人。的空实例。
                 */
                public AuditorDetails() {
                }
            }
        }

        /**
         * 明细列表。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StockCheckItemDetailDTO {

            /**
             * id。
             */
            @JsonProperty("id")
            private String id;
            /**
             * 排序字段。
             */
            @JsonProperty("seqId")
            private Integer seqId;
            /**
             * 物品信息。
             */
            @JsonProperty("goods")
            private GoodsOpenDTO goods;
            /**
             * 账面数量。
             */
            @JsonProperty("bookAmount")
            private String bookAmount;
            /**
             * 盘点数量。
             */
            @JsonProperty("checkAmount")
            private String checkAmount;
            /**
             * 盘盈数量。
             */
            @JsonProperty("winAmount")
            private String winAmount;
            /**
             * 盘亏数量。
             */
            @JsonProperty("lossAmount")
            private String lossAmount;
            /**
             * 盘盈金额。
             */
            @JsonProperty("winMoney")
            private String winMoney;
            /**
             * 盘亏金额。
             */
            @JsonProperty("lossMoney")
            private String lossMoney;
            /**
             * 账面金额。
             */
            @JsonProperty("bookMoney")
            private String bookMoney;
            /**
             * 盘点金额。
             */
            @JsonProperty("checkMoney")
            private String checkMoney;
            /**
             * 盈亏金额。
             */
            @JsonProperty("winOrLossMoney")
            private String winOrLossMoney;
            /**
             * 盈亏数量。
             */
            @JsonProperty("winOrLossAmount")
            private String winOrLossAmount;
            /**
             * 盘盈价格。
             */
            @JsonProperty("checkWinPrice")
            private String checkWinPrice;
            /**
             * 盘亏单价。
             */
            @JsonProperty("checkLossPrice")
            private String checkLossPrice;
            /**
             * 基准单位。
             */
            @JsonProperty("baseUnitInfo")
            private UnitOpenDTO baseUnitInfo;
            /**
             * 基准单位换算系数。
             */
            @JsonProperty("firstCheckConversionRateBaseFactor")
            private String firstCheckConversionRateBaseFactor;
            /**
             * 业务单位。
             */
            @JsonProperty("firstCheckUnitInfo")
            private FirstCheckUnitInfoDetails firstCheckUnitInfo;
            /**
             * 业务单位换算系数。
             */
            @JsonProperty("firstCheckConversionRateBizFactor")
            private String firstCheckConversionRateBizFactor;
            /**
             * 单位换算率信息。
             */
            @JsonProperty("firstCheckConversionRateDesc")
            private String firstCheckConversionRateDesc;
            /**
             * 业务单位盘点数量。
             */
            @JsonProperty("firstCheckUnitAmount")
            private String firstCheckUnitAmount;
            /**
             * 物品版本。
             */
            @JsonProperty("goodsVersion")
            private Integer goodsVersion;
            /**
             * 实物批次号。
             */
            @JsonProperty("physicalBatchNum")
            private String physicalBatchNum;
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
             * 系统默认批次标记。
             */
            @JsonProperty("physicalBatchDefaultFlag")
            private PairDTO physicalBatchDefaultFlag;
            /**
             * 明细生成方式。
             */
            @JsonProperty("generateType")
            private GenerateTypeDetails generateType;
            /**
             * 盈亏数量是否超过阈值。
             */
            @JsonProperty("overThreshold")
            private Boolean overThreshold;
            /**
             * 单位二。
             */
            @JsonProperty("secondCheckUnitInfo")
            private SecondCheckUnitInfoDetails secondCheckUnitInfo;
            /**
             * 单位二转换描述。
             */
            @JsonProperty("secondCheckConversionRateDesc")
            private String secondCheckConversionRateDesc;
            /**
             * 单位二基准单位转换率。
             */
            @JsonProperty("secondCheckConversionRateBaseFactor")
            private String secondCheckConversionRateBaseFactor;
            /**
             * 单位二业务单位转换率。
             */
            @JsonProperty("secondCheckConversionRateBizFactor")
            private String secondCheckConversionRateBizFactor;
            /**
             * 单位二盘点数量。
             */
            @JsonProperty("secondCheckUnitAmount")
            private String secondCheckUnitAmount;
            /**
             * 单位三。
             */
            @JsonProperty("thirdCheckUnitInfo")
            private ThirdCheckUnitInfoDetails thirdCheckUnitInfo;
            /**
             * 单位三转换描述。
             */
            @JsonProperty("thirdCheckConversionRateDesc")
            private String thirdCheckConversionRateDesc;
            /**
             * 单位三基准单位转换率。
             */
            @JsonProperty("thirdCheckConversionRateBaseFactor")
            private String thirdCheckConversionRateBaseFactor;
            /**
             * 单位三业务单位转换率。
             */
            @JsonProperty("thirdCheckConversionRateBizFactor")
            private String thirdCheckConversionRateBizFactor;
            /**
             * 单位三盘点数量。
             */
            @JsonProperty("thirdCheckUnitAmount")
            private String thirdCheckUnitAmount;
            /**
             * 汇总单位。
             */
            @JsonProperty("checkSummationUnitInfo")
            private CheckSummationUnitInfoDetails checkSummationUnitInfo;
            /**
             * 汇总单位基准单位转换率。
             */
            @JsonProperty("checkSummationUnitConversionRateBaseFactor")
            private String checkSummationUnitConversionRateBaseFactor;
            /**
             * 汇总单位业务单位转换率。
             */
            @JsonProperty("checkSummationUnitConversionRateBizFactor")
            private String checkSummationUnitConversionRateBizFactor;
            /**
             * 汇总单位账面数量。
             */
            @JsonProperty("summationUnitBookAmount")
            private String summationUnitBookAmount;
            /**
             * 汇总单位盘点数量。
             */
            @JsonProperty("summationUnitCheckAmount")
            private String summationUnitCheckAmount;
            /**
             * 汇总单位盘盈数量。
             */
            @JsonProperty("summationUnitWinAmount")
            private String summationUnitWinAmount;
            /**
             * 汇总单位盘亏数量。
             */
            @JsonProperty("summationUnitLossAmount")
            private String summationUnitLossAmount;
            /**
             * 汇总单位盈亏数量。
             */
            @JsonProperty("summationUnitWinOrLossAmount")
            private String summationUnitWinOrLossAmount;
            /**
             * 汇总单位盘盈单价。
             */
            @JsonProperty("summationUnitCheckWinPrice")
            private String summationUnitCheckWinPrice;
            /**
             * 汇总单位盘亏单价。
             */
            @JsonProperty("summationUnitCheckLossPrice")
            private String summationUnitCheckLossPrice;
            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 创建明细列表。的空实例。
             */
            public StockCheckItemDetailDTO() {
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
                 * 创建物品信息。的空实例。
                 */
                public GoodsOpenDTO() {
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

                    /**
                     * 创建基准单位。的空实例。
                     */
                    public UnitOpenDTO() {
                    }
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

                    /**
                     * 创建单位信息。的空实例。
                     */
                    public UnitsItem() {
                    }
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

                /**
                 * 创建基准单位。的空实例。
                 */
                public UnitOpenDTO() {
                }
            }

            /**
             * 业务单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class FirstCheckUnitInfoDetails {

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

                /**
                 * 创建业务单位。的空实例。
                 */
                public FirstCheckUnitInfoDetails() {
                }
            }

            /**
             * 明细生成方式。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class GenerateTypeDetails {

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

                /**
                 * 创建明细生成方式。的空实例。
                 */
                public GenerateTypeDetails() {
                }
            }

            /**
             * 单位二。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SecondCheckUnitInfoDetails {

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

                /**
                 * 创建单位二。的空实例。
                 */
                public SecondCheckUnitInfoDetails() {
                }
            }

            /**
             * 单位三。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ThirdCheckUnitInfoDetails {

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

                /**
                 * 创建单位三。的空实例。
                 */
                public ThirdCheckUnitInfoDetails() {
                }
            }

            /**
             * 汇总单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CheckSummationUnitInfoDetails {

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

                /**
                 * 创建汇总单位。的空实例。
                 */
                public CheckSummationUnitInfoDetails() {
                }
            }
        }
    }
}
