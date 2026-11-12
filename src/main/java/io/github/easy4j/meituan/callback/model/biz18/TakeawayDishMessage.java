package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「外卖菜品消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18206}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_6afea534-0a04-4905-9244-9afe745eeffe">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TakeawayDishMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5916\u5356\u83dc\u54c1\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public TakeawayDishMessage() {
    }


    /**
     * 租户 ID。必填。
     */
    @JsonProperty("tenantId")
    private Long tenantId;

    /**
     * 组织机构 ID。必填。
     */
    @JsonProperty("orgId")
    private Long orgId;

    /**
     * 门店 ID。必填。
     */
    @JsonProperty("poiId")
    private Long poiId;

    /**
     * 菜品列表。
     */
    @JsonProperty("spus")
    private List<PoiSpu4CTO> spus;

    /**
     * 分类列表。
     */
    @JsonProperty("categories")
    private List<PoiCategory4CTO> categories;

    /**
     * 外卖菜品来源。必填。
     */
    @JsonProperty("source")
    private Integer source;

    /**
     * 是否为删除操作。必填。
     */
    @JsonProperty("deleted")
    private Boolean deleted;

    /**
     * 菜品列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiSpu4CTO {

        /**
         * 创建\u83dc\u54c1\u5217\u8868\u3002的空实例。
         */
        public PoiSpu4CTO() {
        }


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
        private List<JsonNode> saleTimeList;

        /**
         * 多媒体信息列表。
         */
        @JsonProperty("multimedias")
        private List<JsonNode> multimedias;

        /**
         * 外卖菜品来源。
         */
        @JsonProperty("source")
        private Integer source;

        /**
         * sku规格列表。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PoiSku4CTO {

            /**
             * 创建sku\u89c4\u683c\u5217\u8868\u3002的空实例。
             */
            public PoiSku4CTO() {
            }


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
             * 外卖菜品来源。
             */
            @JsonProperty("source")
            private Integer source;

            /**
             * 删除标记。
             */
            @JsonProperty("deleted")
            private Integer deleted;
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
         * 创建\u5206\u7c7b\u5217\u8868\u3002的空实例。
         */
        public PoiCategory4CTO() {
        }


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
         * 外卖菜品来源。
         */
        @JsonProperty("source")
        private Integer source;

        /**
         * 删除标记。
         */
        @JsonProperty("deleted")
        private Integer deleted;
    }
}
