package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「店内菜品消息（单店）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18201}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_cbfdd2b4-bfef-4adf-89f6-2e1f04516f56">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDishMessage {

    /**
     * 租户 ID。必填。
     */
    @JsonProperty("tenantId")
    private Long tenantId;
    /**
     * 组织机构 ID。
     */
    @JsonProperty("orgId")
    private Long orgId;
    /**
     * 门店 ID。
     */
    @JsonProperty("poiId")
    private Long poiId;
    /**
     * 菜品列表。
     */
    @JsonProperty("spus")
    private List<PoiSpu4CTO> spus;
    /**
     * 套餐列表。
     */
    @JsonProperty("combos")
    private List<PoiCombo4CTO> combos;
    /**
     * 分类列表。
     */
    @JsonProperty("categories")
    private List<PoiCategory4CTO> categories;
    /**
     * 硬删除数据标记。
     */
    @JsonProperty("deleted")
    private Boolean deleted;
    /**
     * 单位列表。
     */
    @JsonProperty("units")
    private List<PoiUnit4CTO> units;
    /**
     * 做法列表。
     */
    @JsonProperty("methods")
    private List<PoiMethod4CTO> methods;
    /**
     * 规格列表。
     */
    @JsonProperty("specs")
    private List<PoiSpec4CTO> specs;

    /**
     * 创建美团「店内菜品消息（单店）」回调的业务内容。的空实例。
     */
    public StoreDishMessage() {
    }

    /**
     * 菜品列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiSpu4CTO {

        /**
         * 商品 ID。
         */
        @JsonProperty("spuId")
        private Long spuId;
        /**
         * 商品名称。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 商品类型。
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 描述。
         */
        @JsonProperty("memo")
        private String memo;
        /**
         * 分类 ID。
         */
        @JsonProperty("categoryId")
        private Long categoryId;
        /**
         * 分类名称。
         */
        @JsonProperty("categoryName")
        private String categoryName;
        /**
         * 分类等级。
         */
        @JsonProperty("categoryLevel")
        private Integer categoryLevel;
        /**
         * 父分类 ID。
         */
        @JsonProperty("categoryParentId")
        private Long categoryParentId;
        /**
         * 父分类名称。
         */
        @JsonProperty("categoryParentName")
        private String categoryParentName;
        /**
         * 分类排序。
         */
        @JsonProperty("categoryRank")
        private Long categoryRank;
        /**
         * 辣度。
         */
        @JsonProperty("spicyDegree")
        private Integer spicyDegree;
        /**
         * 标签列表。
         */
        @JsonProperty("tagList")
        private List<String> tagList;
        /**
         * 单位名称。
         */
        @JsonProperty("unit")
        private String unit;
        /**
         * 做法列表。
         */
        @JsonProperty("methodList")
        private List<String> methodList;
        /**
         * 售卖状态。
         */
        @JsonProperty("saleStatus")
        private Integer saleStatus;
        /**
         * 是否删除。
         */
        @JsonProperty("deleted")
        private Integer deleted;
        /**
         * sku规格列表。
         */
        @JsonProperty("skuList")
        private List<PoiSku4CTO> skuList;
        /**
         * 售卖时段。
         */
        @JsonProperty("saleTimeList")
        private List<PoiSaleTime4CTO> saleTimeList;
        /**
         * 多媒体信息列表。
         */
        @JsonProperty("multimedias")
        private List<PoiMultimedia4CTO> multimedias;
        /**
         * 商品别名。
         */
        @JsonProperty("aliasName")
        private String aliasName;
        /**
         * 备注信息。
         */
        @JsonProperty("remarks")
        private List<PoiRemark4CTO> remarks;
        /**
         * 条形码信息。
         */
        @JsonProperty("barcodeList")
        private List<String> barcodeList;
        /**
         * 菜品详细描述。
         */
        @JsonProperty("detailMemo")
        private String detailMemo;

        /**
         * 创建菜品列表。的空实例。
         */
        public PoiSpu4CTO() {
        }

        /**
         * sku规格列表。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PoiSku4CTO {

            /**
             * sku id。
             */
            @JsonProperty("skuId")
            private Long skuId;
            /**
             * 规格名称。
             */
            @JsonProperty("spec")
            private String spec;
            /**
             * 价格（售价）。
             */
            @JsonProperty("price")
            private Long price;
            /**
             * 会员价。
             */
            @JsonProperty("memberPrice")
            private Long memberPrice;
            /**
             * 删除标记。
             */
            @JsonProperty("deleted")
            private Integer deleted;
            /**
             * 规格 ID。
             */
            @JsonProperty("specsId")
            private Long specsId;
            /**
             * 条形码。
             */
            @JsonProperty("barcodeList")
            private List<String> barcodeList;
            /**
             * 自定义规格。
             */
            @JsonProperty("thirdPartySkuId")
            private String thirdPartySkuId;
            /**
             * 菜品来源。
             */
            @JsonProperty("source")
            private Integer source;

            /**
             * 创建sku规格列表。的空实例。
             */
            public PoiSku4CTO() {
            }
        }

        /**
         * 备注信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PoiRemark4CTO {

            /**
             * 备注code。
             */
            @JsonProperty("code")
            private Long code;
            /**
             * 备注内容。
             */
            @JsonProperty("value")
            private String value;

            /**
             * 创建备注信息。的空实例。
             */
            public PoiRemark4CTO() {
            }
        }
    }

    /**
     * 套餐列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiCombo4CTO {

        /**
         * 套餐 ID。
         */
        @JsonProperty("comboId")
        private Long comboId;
        /**
         * 分类 ID。
         */
        @JsonProperty("categoryId")
        private Long categoryId;
        /**
         * 分类名称。
         */
        @JsonProperty("categoryName")
        private String categoryName;
        /**
         * 分类等级。
         */
        @JsonProperty("categoryLevel")
        private Integer categoryLevel;
        /**
         * 父分类 ID。
         */
        @JsonProperty("categoryParentId")
        private Long categoryParentId;
        /**
         * 父分类名称。
         */
        @JsonProperty("categoryParentName")
        private String categoryParentName;
        /**
         * 售卖状态。
         */
        @JsonProperty("saleStatus")
        private Integer saleStatus;
        /**
         * 删除标记。
         */
        @JsonProperty("deleted")
        private Integer deleted;
        /**
         * 套餐分组列表。
         */
        @JsonProperty("comboGroups")
        private List<PoiComboGroup4CTO> comboGroups;
        /**
         * 最后修改时间。
         */
        @JsonProperty("modifiedTime")
        private Long modifiedTime;
        /**
         * 商品别名。
         */
        @JsonProperty("aliasName")
        private String aliasName;
        /**
         * 备注信息。
         */
        @JsonProperty("remarks")
        private List<PoiRemark4CTO> remarks;
        /**
         * 条形码信息。
         */
        @JsonProperty("barcodeList")
        private List<String> barcodeList;
        /**
         * 菜品详细描述。
         */
        @JsonProperty("detailMemo")
        private String detailMemo;
        /**
         * 自定义菜品规格编码。
         */
        @JsonProperty("thirdPartySkuId")
        private String thirdPartySkuId;

        /**
         * 创建套餐列表。的空实例。
         */
        public PoiCombo4CTO() {
        }

        /**
         * 备注信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PoiRemark4CTO {

            /**
             * 备注code。
             */
            @JsonProperty("code")
            private Long code;
            /**
             * 备注内容。
             */
            @JsonProperty("value")
            private String value;

            /**
             * 创建备注信息。的空实例。
             */
            public PoiRemark4CTO() {
            }
        }
    }

    /**
     * 分类列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiCategory4CTO {

        /**
         * 分类 ID。
         */
        @JsonProperty("categoryId")
        private Long categoryId;
        /**
         * 分类名称。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 分类类型。
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 默认排序。
         */
        @JsonProperty("defaultRank")
        private Integer defaultRank;
        /**
         * 点餐排序。
         */
        @JsonProperty("diancanRank")
        private Integer diancanRank;
        /**
         * pos排序。
         */
        @JsonProperty("posRank")
        private Integer posRank;
        /**
         * 父分类。
         */
        @JsonProperty("parentId")
        private Long parentId;
        /**
         * 菜品来源。
         */
        @JsonProperty("source")
        private Integer source;
        /**
         * 删除标记。
         */
        @JsonProperty("deleted")
        private Integer deleted;
        /**
         * 最后修改时间。
         */
        @JsonProperty("modifiedTime")
        private Long modifiedTime;

        /**
         * 创建分类列表。的空实例。
         */
        public PoiCategory4CTO() {
        }
    }

    /**
     * 单位列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiUnit4CTO {

        /**
         * 单位 id。
         */
        @JsonProperty("id")
        private Long id;
        /**
         * 单位名称。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 排序。
         */
        @JsonProperty("rank")
        private Integer rank;
        /**
         * 是否默认。
         */
        @JsonProperty("systemDefault")
        private Integer systemDefault;
        /**
         * 来源。
         */
        @JsonProperty("publishType")
        private Integer publishType;
        /**
         * 最后修改时间。
         */
        @JsonProperty("modifiedTime")
        private Long modifiedTime;
        /**
         * 删除标记。
         */
        @JsonProperty("deleted")
        private Integer deleted;

        /**
         * 创建单位列表。的空实例。
         */
        public PoiUnit4CTO() {
        }
    }

    /**
     * 做法列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiMethod4CTO {

        /**
         * 做法 id。
         */
        @JsonProperty("id")
        private Long id;
        /**
         * 做法名称。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 做法分组 id。
         */
        @JsonProperty("groupId")
        private Long groupId;
        /**
         * 做法分组名称。
         */
        @JsonProperty("groupName")
        private String groupName;
        /**
         * 排序。
         */
        @JsonProperty("rank")
        private Integer rank;
        /**
         * 是否默认。
         */
        @JsonProperty("systemDefault")
        private Integer systemDefault;
        /**
         * 加价类型。
         */
        @JsonProperty("flexiblePriceType")
        private Integer flexiblePriceType;
        /**
         * 加价值。
         */
        @JsonProperty("flexiblePriceValue")
        private Long flexiblePriceValue;
        /**
         * 来源。
         */
        @JsonProperty("publishType")
        private Integer publishType;
        /**
         * 最后修改时间。
         */
        @JsonProperty("modifiedTime")
        private Long modifiedTime;
        /**
         * 删除标记。
         */
        @JsonProperty("deleted")
        private Integer deleted;

        /**
         * 创建做法列表。的空实例。
         */
        public PoiMethod4CTO() {
        }
    }

    /**
     * 规格列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiSpec4CTO {

        /**
         * 规格 id。
         */
        @JsonProperty("id")
        private Long id;
        /**
         * 规格名称。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 排序。
         */
        @JsonProperty("rank")
        private Integer rank;
        /**
         * 是否默认。
         */
        @JsonProperty("systemDefault")
        private Integer systemDefault;
        /**
         * 来源。
         */
        @JsonProperty("publishType")
        private Integer publishType;
        /**
         * 最后修改时间。
         */
        @JsonProperty("modifiedTime")
        private Long modifiedTime;
        /**
         * 删除标记。
         */
        @JsonProperty("deleted")
        private Integer deleted;

        /**
         * 创建规格列表。的空实例。
         */
        public PoiSpec4CTO() {
        }
    }
}
