package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】配送价格消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810285}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_3eebad37-1020-42b2-a206-0ce5aca0973e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryPriceMessage {

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
     * 配送价格信息。必填。
     */
    @JsonProperty("bizData")
    private DistributionPriceRuleDetailOpenDTO bizData;

    /**
     * 配送价格信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DistributionPriceRuleDetailOpenDTO {

        /**
         * 总部机构。
         */
        @JsonProperty("org")
        private OrgOpenDTO org;

        /**
         * 配送价格规则编码。
         */
        @JsonProperty("ruleCode")
        private String ruleCode;

        /**
         * 规则名称。
         */
        @JsonProperty("ruleName")
        private String ruleName;

        /**
         * 供货机构。
         */
        @JsonProperty("supplyOrg")
        private SupplyOrgDetails supplyOrg;

        /**
         * 生效日期。
         */
        @JsonProperty("startTime")
        private Long startTime;

        /**
         * 终止日期。
         */
        @JsonProperty("endTime")
        private Long endTime;

        /**
         * 启用状态。
         */
        @JsonProperty("enableStatus")
        private PairDTO enableStatus;

        /**
         * 生效状态。
         */
        @JsonProperty("validStatus")
        private ValidStatusDetails validStatus;

        /**
         * 适用机构类型。
         */
        @JsonProperty("adaptOrgType")
        private AdaptOrgTypeDetails adaptOrgType;

        /**
         * 创建人。
         */
        @JsonProperty("creator")
        private UserOpenDTO creator;

        /**
         * 创建时间。
         */
        @JsonProperty("createTime")
        private Long createTime;

        /**
         * 物品维度信息。
         */
        @JsonProperty("goodsList")
        private List<DistributionPriceApplyGoods> goodsList;

        /**
         * 物品分类维度信息。
         */
        @JsonProperty("goodsCategoryList")
        private List<DistributionPriceApplyGoodsCategory> goodsCategoryList;

        /**
         * 适用机构。
         */
        @JsonProperty("adaptOrgList")
        private List<AdaptOrgListItem> adaptOrgList;

        /**
         * 总部机构。
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
        }

        /**
         * 供货机构。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SupplyOrgDetails {

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
        }

        /**
         * 生效状态。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ValidStatusDetails {

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
         * 适用机构类型。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdaptOrgTypeDetails {

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
         * 物品维度信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DistributionPriceApplyGoods {

            /**
             * 物品信息。
             */
            @JsonProperty("goodsInfo")
            private GoodsOpenDTO goodsInfo;

            /**
             * 订货单位。
             */
            @JsonProperty("unit")
            private UnitOpenDTO unit;

            /**
             * 定价方式。
             */
            @JsonProperty("priceAdjustmentType")
            private PairDTO priceAdjustmentType;

            /**
             * 价格类型。
             */
            @JsonProperty("priceType")
            private PriceTypeDetails priceType;

            /**
             * 取价来源供应商。
             */
            @JsonProperty("priceSourceSupplierInfos")
            private OpenOppositeOrgDTO priceSourceSupplierInfos;

            /**
             * 基础价格。
             */
            @JsonProperty("basePriceInfo")
            private String basePriceInfo;

            /**
             * 基准单位。
             */
            @JsonProperty("baseUnit")
            private BaseUnitDetails baseUnit;

            /**
             * 定价明细。
             */
            @JsonProperty("priceDetail")
            private String priceDetail;

            /**
             * 订货单价(含税)。
             */
            @JsonProperty("taxPrice")
            private String taxPrice;

            /**
             * 税率定义方式。
             */
            @JsonProperty("taxWay")
            private TaxWayDetails taxWay;

            /**
             * 税率定义。
             */
            @JsonProperty("comboDetailPrices")
            private List<ComboDetailPrice> comboDetailPrices;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 订货单价(不含税)。
             */
            @JsonProperty("noTaxPrice")
            private String noTaxPrice;

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
                 * 分类。
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
                 * 三方编码。
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
             * 订货单位。
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
             * 价格类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PriceTypeDetails {

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
             * 取价来源供应商。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OpenOppositeOrgDTO {

                /**
                 * 机构类型。
                 */
                @JsonProperty("type")
                private PairDTO type;

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
                 * id。
                 */
                @JsonProperty("id")
                private String id;
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
             * 税率定义方式。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TaxWayDetails {

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
             * 税率定义。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ComboDetailPrice {

                /**
                 * 物品信息。
                 */
                @JsonProperty("goodsInfo")
                private GoodsOpenDTO goodsInfo;

                /**
                 * 税率。
                 */
                @JsonProperty("taxRate")
                private String taxRate;

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
                     * 三方编码。
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
            }
        }

        /**
         * 物品分类维度信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DistributionPriceApplyGoodsCategory {

            /**
             * 分类信息。
             */
            @JsonProperty("goodsCategory")
            private SimpleCategoryOpenDTO goodsCategory;

            /**
             * 上级分类信息。
             */
            @JsonProperty("parentGoodsCategory")
            private ParentGoodsCategoryDetails parentGoodsCategory;

            /**
             * 定价方式。
             */
            @JsonProperty("priceAdjustmentType")
            private PairDTO priceAdjustmentType;

            /**
             * 价格类型。
             */
            @JsonProperty("priceType")
            private PriceTypeDetails priceType;

            /**
             * 取价来源供应商。
             */
            @JsonProperty("priceSourceSupplierInfoList")
            private List<OpenOppositeOrgDTO> priceSourceSupplierInfoList;

            /**
             * 定价明细。
             */
            @JsonProperty("priceDetail")
            private String priceDetail;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 上级分类信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ParentGoodsCategoryDetails {

                /**
                 * 分类 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 分类编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 分类名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 价格类型。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PriceTypeDetails {

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
             * 取价来源供应商。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OpenOppositeOrgDTO {

                /**
                 * 机构类型。
                 */
                @JsonProperty("type")
                private PairDTO type;

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
                 * id。
                 */
                @JsonProperty("id")
                private String id;
            }
        }

        /**
         * 适用机构。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdaptOrgListItem {

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
        }
    }
}
