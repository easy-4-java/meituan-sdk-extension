package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「店内菜品消息（总部）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18209}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_932df858-a920-4acc-b0cb-201a4151e791">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeadquartersDishMessage {

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
     * 菜品列表。
     */
    @JsonProperty("spus")
    private List<Spu4CTO> spus;

    /**
     * 套餐列表。
     */
    @JsonProperty("combos")
    private List<Combo4CTO> combos;

    /**
     * 分类列表。
     */
    @JsonProperty("categories")
    private List<Category4CTO> categories;

    /**
     * 硬删除数据标记。
     */
    @JsonProperty("deleted")
    private Boolean deleted;

    /**
     * 单位列表。
     */
    @JsonProperty("units")
    private List<Unit4CTO> units;

    /**
     * 做法列表。
     */
    @JsonProperty("methods")
    private List<Method4CTO> methods;

    /**
     * 规格列表。
     */
    @JsonProperty("specs")
    private List<Spec4CTO> specs;

    /**
     * 菜品列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Spu4CTO {

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
        }
    }

    /**
     * 套餐列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Combo4CTO {

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
         * 套餐名称。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 套餐价格。
         */
        @JsonProperty("price")
        private Long price;

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
    }

    /**
     * 分类列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Category4CTO {

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
         * 品牌 ID。
         */
        @JsonProperty("brandId")
        private Long brandId;

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
         * 删除标记。
         */
        @JsonProperty("deleted")
        private Integer deleted;
    }

    /**
     * 单位列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Unit4CTO {

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
    }

    /**
     * 做法列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Method4CTO {

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
    }

    /**
     * 规格列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Spec4CTO {

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
    }
}
