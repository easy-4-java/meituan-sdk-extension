package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】物品档案消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810101}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_afe81c75-71c8-46e5-87fc-47f9c480cbb4">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemMasterMessage {

    /**
     * 创建美团「【供应链】物品档案消息」回调的业务内容。的空实例。
     */
    public ItemMasterMessage() {
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
     * 物品信息。必填。
     */
    @JsonProperty("bizData")
    private CompleteGoodsOpenDTO bizData;

    /**
     * 物品信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CompleteGoodsOpenDTO {

        /**
         * 创建物品信息。的空实例。
         */
        public CompleteGoodsOpenDTO() {
        }


        /**
         * 总部机构 ID。
         */
        @JsonProperty("rootOrgId")
        private Long rootOrgId;

        /**
         * 所属机构。
         */
        @JsonProperty("belongOrg")
        private OrgOpenDTO belongOrg;

        /**
         * 物品 ID。
         */
        @JsonProperty("goodsId")
        private String goodsId;

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
         * 物品品牌。
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
        private CompleteUnitOpenDTO baseUnit;

        /**
         * 支持的单位名称列表。
         */
        @JsonProperty("units")
        private List<UnitsItem> units;

        /**
         * 简称。
         */
        @JsonProperty("shortName")
        private String shortName;

        /**
         * 物品类型。
         */
        @JsonProperty("goodsType")
        private List<Integer> goodsType;

        /**
         * 助记码。
         */
        @JsonProperty("mnemonicCode")
        private String mnemonicCode;

        /**
         * 物品条形码。
         */
        @JsonProperty("barCode")
        private String barCode;

        /**
         * 生产参考成本。
         */
        @JsonProperty("costReferencePrice")
        private String costReferencePrice;

        /**
         * 统计类型。
         */
        @JsonProperty("statisticsType")
        private GoodsStatisticsTypeDTO statisticsType;

        /**
         * ABC分类。
         */
        @JsonProperty("abcCategory")
        private Integer abcCategory;

        /**
         * 库存下限。
         */
        @JsonProperty("minStock")
        private String minStock;

        /**
         * 库存上限。
         */
        @JsonProperty("maxStock")
        private String maxStock;

        /**
         * 状态。
         */
        @JsonProperty("status")
        private PairDTO status;

        /**
         * 第三方编码。
         */
        @JsonProperty("thirdCode")
        private String thirdCode;

        /**
         * 批次启用开关。
         */
        @JsonProperty("batchManagement")
        private Boolean batchManagement;

        /**
         * 保质期开关。
         */
        @JsonProperty("shelfLifeSwitch")
        private Boolean shelfLifeSwitch;

        /**
         * 提前预警天数。
         */
        @JsonProperty("shelfLifeWarnDay")
        private Integer shelfLifeWarnDay;

        /**
         * 保质期。
         */
        @JsonProperty("shelfLifeDay")
        private Integer shelfLifeDay;

        /**
         * 采购单位。
         */
        @JsonProperty("defaultPurchaseUnit")
        private DefaultPurchaseUnitDetails defaultPurchaseUnit;

        /**
         * 采购价格。
         */
        @JsonProperty("purchasePrice")
        private String purchasePrice;

        /**
         * 订货单位。
         */
        @JsonProperty("defaultOrderUnit")
        private DefaultOrderUnitDetails defaultOrderUnit;

        /**
         * 库存单位。
         */
        @JsonProperty("defaultStockUnit")
        private DefaultStockUnitDetails defaultStockUnit;

        /**
         * 成本单位。
         */
        @JsonProperty("defaultCostUnit")
        private DefaultCostUnitDetails defaultCostUnit;

        /**
         * 盘点单位。
         */
        @JsonProperty("checkUnitList")
        private List<CheckUnitListItem> checkUnitList;

        /**
         * 辅助单位开关。
         */
        @JsonProperty("enableSupplementaryUnit")
        private Boolean enableSupplementaryUnit;

        /**
         * 辅助单位。
         */
        @JsonProperty("supplementaryUnit")
        private SupplementaryUnitDetails supplementaryUnit;

        /**
         * 物品体积，此字段已废弃，建议体积参考物品单位中的体积。
         */
        @JsonProperty("volume")
        private String volume;

        /**
         * 物品重量，此字段已废弃，建议重量参考物品单位中的重量。
         */
        @JsonProperty("weight")
        private String weight;

        /**
         * 税目编码。
         */
        @JsonProperty("taxCode")
        private String taxCode;

        /**
         * 税目名称。
         */
        @JsonProperty("taxName")
        private String taxName;

        /**
         * taxRate。
         */
        @JsonProperty("taxRate")
        private String taxRate;

        /**
         * 盘点类型。
         */
        @JsonProperty("checkType")
        private List<Integer> checkType;

        /**
         * 是否可订货。
         */
        @JsonProperty("canOrder")
        private CanOrderDetails canOrder;

        /**
         * 订货转采购开关。
         */
        @JsonProperty("canOrderToPurchase")
        private Boolean canOrderToPurchase;

        /**
         * 分拣开关。
         */
        @JsonProperty("canSort")
        private Boolean canSort;

        /**
         * 组合加工开关。
         */
        @JsonProperty("canDisableCombineProcess")
        private Boolean canDisableCombineProcess;

        /**
         * 拆分加工开关。
         */
        @JsonProperty("canDisableSplitProcess")
        private Boolean canDisableSplitProcess;

        /**
         * 生产转采购开关。
         */
        @JsonProperty("canProductionToPurchase")
        private Boolean canProductionToPurchase;

        /**
         * 委外加工开关。
         */
        @JsonProperty("canOutSourceProcess")
        private Boolean canOutSourceProcess;

        /**
         * 最后更新时间。
         */
        @JsonProperty("lastModifyTime")
        private Long lastModifyTime;

        /**
         * 版本号。
         */
        @JsonProperty("version")
        private Integer version;

        /**
         * 禁止盘点。
         */
        @JsonProperty("forbidCheck")
        private Boolean forbidCheck;

        /**
         * 是否需上传批检报告。
         */
        @JsonProperty("canNeedBatchInspectionReport")
        private Boolean canNeedBatchInspectionReport;

        /**
         * 是否可报损。
         */
        @JsonProperty("canDamage")
        private Boolean canDamage;

        /**
         * 是否可调拨。
         */
        @JsonProperty("canAllot")
        private Boolean canAllot;

        /**
         * 物品类型 1-普通物品, 2:套餐。
         */
        @JsonProperty("goodsTypes")
        private List<Integer> goodsTypes;

        /**
         * 默认不盘点。
         */
        @JsonProperty("defaultNoCheck")
        private Boolean defaultNoCheck;

        /**
         * 图片Urls。
         */
        @JsonProperty("imageUrls")
        private List<GoodsMultiSpecImageOpenDTO> imageUrls;

        /**
         * 所属机构。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrgOpenDTO {

            /**
             * 创建所属机构。的空实例。
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
         * 基准单位。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CompleteUnitOpenDTO {

            /**
             * 创建基准单位。的空实例。
             */
            public CompleteUnitOpenDTO() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 支持的单位名称列表。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class UnitsItem {

            /**
             * 创建支持的单位名称列表。的空实例。
             */
            public UnitsItem() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 统计类型。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class GoodsStatisticsTypeDTO {

            /**
             * 创建统计类型。的空实例。
             */
            public GoodsStatisticsTypeDTO() {
            }


            /**
             * 统计类型 ID。
             */
            @JsonProperty("id")
            private String id;

            /**
             * 统计类型编码。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 统计类型名称。
             */
            @JsonProperty("name")
            private String name;
        }

        /**
         * 采购单位。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DefaultPurchaseUnitDetails {

            /**
             * 创建采购单位。的空实例。
             */
            public DefaultPurchaseUnitDetails() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 订货单位。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DefaultOrderUnitDetails {

            /**
             * 创建订货单位。的空实例。
             */
            public DefaultOrderUnitDetails() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 库存单位。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DefaultStockUnitDetails {

            /**
             * 创建库存单位。的空实例。
             */
            public DefaultStockUnitDetails() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 成本单位。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DefaultCostUnitDetails {

            /**
             * 创建成本单位。的空实例。
             */
            public DefaultCostUnitDetails() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 盘点单位。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CheckUnitListItem {

            /**
             * 创建盘点单位。的空实例。
             */
            public CheckUnitListItem() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 辅助单位。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SupplementaryUnitDetails {

            /**
             * 创建辅助单位。的空实例。
             */
            public SupplementaryUnitDetails() {
            }


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
             * 单位换算率基准系数。
             */
            @JsonProperty("conversionRateBaseFactor")
            private String conversionRateBaseFactor;

            /**
             * 单位换算率业务系数。
             */
            @JsonProperty("conversionRateBizFactor")
            private String conversionRateBizFactor;

            /**
             * 体积。
             */
            @JsonProperty("volume")
            private String volume;

            /**
             * 重量。
             */
            @JsonProperty("weight")
            private String weight;

            /**
             * 体积单位类型。
             */
            @JsonProperty("volumeUnitType")
            private PairDTO volumeUnitType;

            /**
             * 重量单位类型。
             */
            @JsonProperty("weightUnitType")
            private WeightUnitTypeDetails weightUnitType;

            /**
             * 重量单位类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WeightUnitTypeDetails {

                /**
                 * 创建重量单位类型。的空实例。
                 */
                public WeightUnitTypeDetails() {
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
        }

        /**
         * 是否可订货。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CanOrderDetails {

            /**
             * 创建是否可订货。的空实例。
             */
            public CanOrderDetails() {
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
         * 图片Urls。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class GoodsMultiSpecImageOpenDTO {

            /**
             * 创建图片Urls。的空实例。
             */
            public GoodsMultiSpecImageOpenDTO() {
            }


            /**
             * 图片序号。
             */
            @JsonProperty("imageSeq")
            private Integer imageSeq;

            /**
             * 图片规格 1: 1:1,2:16:9。
             */
            @JsonProperty("spec")
            private Integer spec;

            /**
             * 图片地址。
             */
            @JsonProperty("imageUrl")
            private String imageUrl;
        }
    }
}
