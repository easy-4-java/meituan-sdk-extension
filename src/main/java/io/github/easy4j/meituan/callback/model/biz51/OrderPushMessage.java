package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「推单接口（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110013}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_a4d1b81e-3c9c-48d6-928c-52c9d43e3754">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPushMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u63a8\u5355\u63a5\u53e3\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderPushMessage() {
    }


    /**
     * MT订单 ID。必填。
     */
    @JsonProperty("openId")
    private String openId;

    /**
     * 10 - 点评 20 - 美团。必填。
     */
    @JsonProperty("platform")
    private Integer platform;

    /**
     * MT订单 ID。必填。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 商户门店编号。必填。
     */
    @JsonProperty("vendorShopId")
    private String vendorShopId;

    /**
     * 1—实时单 2—预约单。必填。
     */
    @JsonProperty("orderType")
    private Integer orderType;

    /**
     * 预约单的取餐时间，时间戳。
     */
    @JsonProperty("takeTime")
    private Long takeTime;

    /**
     * 美团生成的取餐口令 根据品牌需要，美团可生成取餐口令，品牌自己有则该字段为空。
     */
    @JsonProperty("mtTakeCode")
    private String mtTakeCode;

    /**
     * 订单商品原价,未优惠之前的。必填。
     */
    @JsonProperty("totalPrice")
    private Integer totalPrice;

    /**
     * 用户在线点实付金额。必填。
     */
    @JsonProperty("payPrice")
    private Integer payPrice;

    /**
     * 在线点平台补贴金额。必填。
     */
    @JsonProperty("mtMopDiscountPrice")
    private Integer mtMopDiscountPrice;

    /**
     * 团购券用户实付金额。必填。
     */
    @JsonProperty("dealPayPrice")
    private Integer dealPayPrice;

    /**
     * 团购券平台补贴金额。必填。
     */
    @JsonProperty("mtDealDiscountPrice")
    private Integer mtDealDiscountPrice;

    /**
     * 商家应收金额，单位分 （纯粹商家应收，不扣除佣金）； 商家应收金额=商家团购应收金额+商家在线点应收金额。必填。
     */
    @JsonProperty("vendorBillPrice")
    private Integer vendorBillPrice;

    /**
     * 商家团购应收金额。必填。
     */
    @JsonProperty("vendorDealBillPrice")
    private Integer vendorDealBillPrice;

    /**
     * 商家在线点应收金额。必填。
     */
    @JsonProperty("vendorMOPBillPrice")
    private Integer vendorMOPBillPrice;

    /**
     * 美团优惠金额：因法务问题，此字段固定为0，勿用。必填。
     */
    @JsonProperty("mtDiscountPrice")
    private Integer mtDiscountPrice;

    /**
     * 商户优惠金额=商户团购优惠金额+商户在线点优惠金额。必填。
     */
    @JsonProperty("vendorDiscountPrice")
    private Integer vendorDiscountPrice;

    /**
     * 商户团购优惠金额。购买团购券时的优惠金额。必填。
     */
    @JsonProperty("vendorDealDiscountPrice")
    private Integer vendorDealDiscountPrice;

    /**
     * 商户在线点优惠金额。必填。
     */
    @JsonProperty("vendorMOPDiscountPrice")
    private Integer vendorMOPDiscountPrice;

    /**
     * 用户下单时间，时间戳。必填。
     */
    @JsonProperty("orderTime")
    private Long orderTime;

    /**
     * 用户支付时间，时间戳。必填。
     */
    @JsonProperty("payTime")
    private Long payTime;

    /**
     * 是否打包（标记位）。必填。
     */
    @JsonProperty("packageOrder")
    private Boolean packageOrder;

    /**
     * 订单关联单品明细，拆到单份（sku、combo至少有一个）。
     */
    @JsonProperty("orderSkuDTOList")
    private List<OrderSkuDTO> orderSkuDTOList;

    /**
     * 订单关联套餐明细，拆到单份（sku、combo至少有一个） 团购券可以抵扣Combo 也可以 抵扣Sku，
     * 抵扣Combo时的优惠分摊不体现在OrderSkuDTO#skuActivityDTOList，
     * 体现在OrderComboDTO上,加购商品中有套餐商品时必有值。
     */
    @JsonProperty("orderComboDTOList")
    private List<OrderComboDTO> orderComboDTOList;

    /**
     * 团购券信息列表，拆到单份（团购券兑换时必有）。
     */
    @JsonProperty("dealInfoDTOList")
    private List<DealInfoDTO> dealInfoDTOList;

    /**
     * 订单行活动列表（整单优惠）：整单优惠是基于订单的，不会批价到sku#activityList，并且在美团内部除了积分抵扣配料之外，和其他营销都互斥的，
     * 也就是说使用了积分抵扣配料营销之外的活动商品都不参与整单优惠分摊 整单优惠最多只有一个，使用整单优惠的前提是订单中没有其他的优惠。
     */
    @JsonProperty("orderActivityList")
    private List<OrderActivityDTO> orderActivityList;

    /**
     * 10 - 门店餐具免费 20 - 门店餐具收费，用户选了无需餐具 30 - 餐具收费，订单不包含食品 40 - 餐具收费，
     * 用户已选择餐具 说明：只有当40时，会把餐具信息封装在orderSkuDTOList中。
     */
    @JsonProperty("shopTablewareType")
    private Integer shopTablewareType;

    /**
     * 订单扩展信息：商户根据需要自取，可按需扩展 remark ：订单备注，如用户填写且过审则有 traceId：请求追踪 ID，
     * 用于问题排查 receiptTimeOut：接单超时时间 virtualNumber：用户虚拟号，相关说明： - 如用户在美团侧无手机号，
     * 则为null - 如系统异常生成失败，则降级为null（不阻塞推单流程） - 字段示例：18366668888#1234，拨打#号前的号码，
     * 听到语音提示【请输入分机号】后，输入分机号1234即可,fulfillmentType 用户选择履约方式。1-堂食；2-打包；空-功能未开启；
     *  套餐新增。
     */
    @JsonProperty("orderExt")
    private String orderExt;

    /**
     * 业务类型 10-MOP。必填。
     */
    @JsonProperty("bizType")
    private Integer bizType;

    /**
     * 订单关联单品明细，拆到单份（sku、combo至少有一个）。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderSkuDTO {

        /**
         * 创建\u8ba2\u5355\u5173\u8054\u5355\u54c1\u660e\u7ec6\uff0c\u62c6\u5230\u5355\u4efd\uff08sku\u3001combo\u81f3\u5c11\u6709\u4e00\u4e2a\uff09\u3002的空实例。
         */
        public OrderSkuDTO() {
        }


        /**
         * 品牌商品编号。
         */
        @JsonProperty("spuId")
        private String spuId;

        /**
         * 品牌skuID编号。
         */
        @JsonProperty("skuId")
        private String skuId;

        /**
         * 唯一标识。
         */
        @JsonProperty("unique")
        private String unique;

        /**
         * spu名称。
         */
        @JsonProperty("spuName")
        private String spuName;

        /**
         * sku名称。
         */
        @JsonProperty("skuName")
        private String skuName;

        /**
         * 商品后台类目。
         */
        @JsonProperty("categoryCode")
        private String categoryCode;

        /**
         * combo所属分组 ID。
         */
        @JsonProperty("comboGroupId")
        private String comboGroupId;

        /**
         * 默认Sku价格。
         */
        @JsonProperty("skuPrice")
        private Integer skuPrice;

        /**
         * 默认Sku + 配料的价格。
         */
        @JsonProperty("totalPrice")
        private Integer totalPrice;

        /**
         * 商户优惠金额。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;

        /**
         * 商户团购优惠金额。
         */
        @JsonProperty("vendorDealDiscountPrice")
        private Integer vendorDealDiscountPrice;

        /**
         * 商户在线点优惠金额。
         */
        @JsonProperty("vendorMOPDiscountPrice")
        private Integer vendorMOPDiscountPrice;

        /**
         * 选购数量。
         */
        @JsonProperty("count")
        private Integer count;

        /**
         * 销售属性列表（eg：杯型、温度、咖啡豆等）。
         */
        @JsonProperty("saleAttrDTOList")
        private List<SaleAttrDTO> saleAttrDTOList;

        /**
         * Sku下的配料信息。
         */
        @JsonProperty("premiumDTOList")
        private List<PremiumDTO> premiumDTOList;

        /**
         * 菜品活动列表，一份sku上只能用一种优惠。
         */
        @JsonProperty("skuActivityDTOList")
        private List<SkuActivityDTO> skuActivityDTOList;

        /**
         * 商品上扩展信息。
         */
        @JsonProperty("skuExt")
        private String skuExt;

        /**
         * 新增，套餐单品抵扣金额 商品原价50元，套餐商品40元，相当于套餐商品优惠了10元；假设套餐内包含ABC三个商品分别为10元，15元，25元；
         * 当分摊规则为按原价分摊时，A商品对应的此值为2元，B商品3元，C商品5元。
         */
        @JsonProperty("comboProductPromotionPrice")
        private Integer comboProductPromotionPrice;

        /**
         * 销售属性列表（eg：杯型、温度、咖啡豆等）。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleAttrDTO {

            /**
             * 创建\u9500\u552e\u5c5e\u6027\u5217\u8868\uff08eg\uff1a\u676f\u578b\u3001\u6e29\u5ea6\u3001\u5496\u5561\u8c46\u7b49\uff09\u3002的空实例。
             */
            public SaleAttrDTO() {
            }


            /**
             * 销售属性Code。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 销售属性名称。
             */
            @JsonProperty("name")
            private String name;

            /**
             * 销售属性值。
             */
            @JsonProperty("value")
            private String value;
        }

        /**
         * Sku下的配料信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PremiumDTO {

            /**
             * 创建Sku\u4e0b\u7684\u914d\u6599\u4fe1\u606f\u3002的空实例。
             */
            public PremiumDTO() {
            }


            /**
             * 配料Id。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 配料名称。
             */
            @JsonProperty("name")
            private String name;

            /**
             * 订单价格。
             */
            @JsonProperty("orderPrice")
            private Integer orderPrice;

            /**
             * 数量。
             */
            @JsonProperty("count")
            private Integer count;

            /**
             * 配料类型 1：标准配料 2：特殊配料，目前只有【换购】是特殊配料 3：附加冷热配料 4: 做法。
             */
            @JsonProperty("type")
            private Integer type;
        }

        /**
         * 菜品活动列表，一份sku上只能用一种优惠。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SkuActivityDTO {

            /**
             * 创建\u83dc\u54c1\u6d3b\u52a8\u5217\u8868\uff0c\u4e00\u4efdsku\u4e0a\u53ea\u80fd\u7528\u4e00\u79cd\u4f18\u60e0\u3002的空实例。
             */
            public SkuActivityDTO() {
            }


            /**
             * 关联活动 ID，如果是团购券和DealInfoDTO#dealId做关联。
             */
            @JsonProperty("activityId")
            private String activityId;

            /**
             * 活动子 ID 活动类型为41、42：activitysubId对应DealInfoDTO中的dealCode。
             */
            @JsonProperty("activitySubId")
            private String activitySubId;

            /**
             * 活动名称。
             */
            @JsonProperty("activityName")
            private String activityName;

            /**
             * 活动类型 11-单品特价 21-Combo2.0折扣 22-Combo2.0特价 23-Combo2.0立减 30-整单满减券 31-圈商品池满减券 32-折扣券 33-一口价券 41-团购券抵扣单品 42-团购券抵扣套餐 51-星星抵扣。
             */
            @JsonProperty("activityType")
            private Integer activityType;

            /**
             * 活动作用的对用的 ID。
             */
            @JsonProperty("referId")
            private String referId;

            /**
             * SKU(1, "SKU"), PREMIUM(2, "配料");
             */
            @JsonProperty("referType")
            private Integer referType;

            /**
             * MT优惠金额，不会被赋值，勿用。
             */
            @JsonProperty("mtDiscountPrice")
            private Integer mtDiscountPrice;

            /**
             * 商家优惠金额 = 商户MOP优惠金额 + 商户Deal优惠金额。
             */
            @JsonProperty("vendorDiscountPrice")
            private Integer vendorDiscountPrice;

            /**
             * 商户MOP优惠金额。
             */
            @JsonProperty("vendorMopDiscountPrice")
            private Integer vendorMopDiscountPrice;

            /**
             * 商户Deal优惠金额。
             */
            @JsonProperty("vendorDealDiscountPrice")
            private Integer vendorDealDiscountPrice;

            /**
             * 使用会员积分。
             */
            @JsonProperty("memberPoint")
            private Integer memberPoint;

            /**
             * 活动扩展信息：具体数据结构见下说明。
             */
            @JsonProperty("activityExt")
            private JsonNode activityExt;
        }
    }

    /**
     * 订单关联套餐明细，拆到单份（sku、combo至少有一个） 团购券可以抵扣Combo 也可以 抵扣Sku，
     * 抵扣Combo时的优惠分摊不体现在OrderSkuDTO#skuActivityDTOList，
     * 体现在OrderComboDTO上,加购商品中有套餐商品时必有值。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderComboDTO {

        /**
         * 创建\u8ba2\u5355\u5173\u8054\u5957\u9910\u660e\u7ec6\uff0c\u62c6\u5230\u5355\u4efd\uff08sku\u3001combo\u81f3\u5c11\u6709\u4e00\u4e2a\uff09 \u56e2\u8d2d\u5238\u53ef\u4ee5\u62b5\u6263Combo \u4e5f\u53ef\u4ee5 \u62b5\u6263Sku\uff0c的空实例。
         */
        public OrderComboDTO() {
        }


        /**
         * combo的标识code。
         */
        @JsonProperty("comboCode")
        private String comboCode;

        /**
         * combo名称。
         */
        @JsonProperty("comboName")
        private String comboName;

        /**
         * 唯一标识符（拆份的唯一标识）。
         */
        @JsonProperty("unique")
        private String unique;

        /**
         * 活动id, 如果是团购券，则是dealId。
         */
        @JsonProperty("activityId")
        private String activityId;

        /**
         * 活动子 ID 当活动类型为41、42时：activitysubId对应DealInfoDTO中的dealCode。
         */
        @JsonProperty("activitySubId")
        private String activitySubId;

        /**
         * 活动类型 21-Combo2.0折扣 22-Combo2.0特价 23-Combo2.0立减 42-团购券抵扣套餐。
         */
        @JsonProperty("activityType")
        private Integer activityType;

        /**
         * combo原价。
         */
        @JsonProperty("totalPrice")
        private Integer totalPrice;

        /**
         * 是否combo活动。
         */
        @JsonProperty("promotion")
        private Boolean promotion;

        /**
         * 选购数量。
         */
        @JsonProperty("count")
        private Integer count;

        /**
         * 商户优惠金额，刨除团购券商家应收价格的商户优惠金额。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;

        /**
         * 商户团购优惠金额。
         */
        @JsonProperty("vendorDealDiscountPrice")
        private Integer vendorDealDiscountPrice;

        /**
         * 商户在线点优惠金额。
         */
        @JsonProperty("vendorMOPDiscountPrice")
        private Integer vendorMOPDiscountPrice;

        /**
         * combo sku列表： 如果activityType = 42 sku上不批价活动OrderSkuDTO#skuActivityDTOList 信息无。
         */
        @JsonProperty("comboSkuDTOList")
        private List<OrderSkuDTO> comboSkuDTOList;

        /**
         * combo扩展信息。
         */
        @JsonProperty("comboExt")
        private String comboExt;

        /**
         * 新增，套餐商品抵扣金额 商品原价50元，套餐商品40元，相当于套餐商品优惠了10元，这里会是10。
         */
        @JsonProperty("comboProductPromotionPrice")
        private Integer comboProductPromotionPrice;

        /**
         * combo sku列表： 如果activityType = 42 sku上不批价活动OrderSkuDTO#skuActivityDTOList 信息无。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderSkuDTO {

            /**
             * 创建combo sku\u5217\u8868\uff1a \u5982\u679cactivityType = 42 sku\u4e0a\u4e0d\u6279\u4ef7\u6d3b\u52a8OrderSkuDTO#skuActivityDTOList \u4fe1\u606f\u65e0\u3002的空实例。
             */
            public OrderSkuDTO() {
            }


            /**
             * 品牌商品编号。
             */
            @JsonProperty("spuId")
            private String spuId;

            /**
             * 品牌skuID编号。
             */
            @JsonProperty("skuId")
            private String skuId;

            /**
             * 唯一标识。
             */
            @JsonProperty("unique")
            private String unique;

            /**
             * spu名称。
             */
            @JsonProperty("spuName")
            private String spuName;

            /**
             * sku名称。
             */
            @JsonProperty("skuName")
            private String skuName;

            /**
             * 商品后台类目。
             */
            @JsonProperty("categoryCode")
            private String categoryCode;

            /**
             * combo所属分组 ID。
             */
            @JsonProperty("comboGroupId")
            private String comboGroupId;

            /**
             * 默认Sku价格。
             */
            @JsonProperty("skuPrice")
            private Integer skuPrice;

            /**
             * 默认Sku + 配料的价格。
             */
            @JsonProperty("totalPrice")
            private Integer totalPrice;

            /**
             * 商户优惠金额。
             */
            @JsonProperty("vendorDiscountPrice")
            private Integer vendorDiscountPrice;

            /**
             * 商户团购优惠金额。
             */
            @JsonProperty("vendorDealDiscountPrice")
            private Integer vendorDealDiscountPrice;

            /**
             * 商户在线点优惠金额。
             */
            @JsonProperty("vendorMOPDiscountPrice")
            private Integer vendorMOPDiscountPrice;

            /**
             * 选购数量。
             */
            @JsonProperty("count")
            private Integer count;

            /**
             * 销售属性列表（eg：杯型、温度、咖啡豆等）。
             */
            @JsonProperty("saleAttrDTOList")
            private List<SaleAttrDTO> saleAttrDTOList;

            /**
             * Sku下的配料信息。
             */
            @JsonProperty("premiumDTOList")
            private List<PremiumDTO> premiumDTOList;

            /**
             * 菜品活动列表，一份sku上只能用一种优惠。
             */
            @JsonProperty("skuActivityDTOList")
            private List<SkuActivityDTO> skuActivityDTOList;

            /**
             * 商品上扩展信息。
             */
            @JsonProperty("skuExt")
            private String skuExt;

            /**
             * 新增，套餐单品抵扣金额 商品原价50元，套餐商品40元，相当于套餐商品优惠了10元；假设套餐内包含ABC三个商品分别为10元，15元，25元；
             * 当分摊规则为按原价分摊时，A商品对应的此值为2元，B商品3元，C商品5元。
             */
            @JsonProperty("comboProductPromotionPrice")
            private Integer comboProductPromotionPrice;

            /**
             * 销售属性列表（eg：杯型、温度、咖啡豆等）。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SaleAttrDTO {

                /**
                 * 创建\u9500\u552e\u5c5e\u6027\u5217\u8868\uff08eg\uff1a\u676f\u578b\u3001\u6e29\u5ea6\u3001\u5496\u5561\u8c46\u7b49\uff09\u3002的空实例。
                 */
                public SaleAttrDTO() {
                }


                /**
                 * 销售属性Code。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 销售属性名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 销售属性值。
                 */
                @JsonProperty("value")
                private String value;
            }

            /**
             * Sku下的配料信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PremiumDTO {

                /**
                 * 创建Sku\u4e0b\u7684\u914d\u6599\u4fe1\u606f\u3002的空实例。
                 */
                public PremiumDTO() {
                }


                /**
                 * 配料Id。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 配料名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 订单价格。
                 */
                @JsonProperty("orderPrice")
                private Integer orderPrice;

                /**
                 * 数量。
                 */
                @JsonProperty("count")
                private Integer count;

                /**
                 * 配料类型 1：标准配料 2：特殊配料，目前只有【换购】是特殊配料 3：附加冷热配料 4: 做法。
                 */
                @JsonProperty("type")
                private Integer type;
            }

            /**
             * 菜品活动列表，一份sku上只能用一种优惠。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SkuActivityDTO {

                /**
                 * 创建\u83dc\u54c1\u6d3b\u52a8\u5217\u8868\uff0c\u4e00\u4efdsku\u4e0a\u53ea\u80fd\u7528\u4e00\u79cd\u4f18\u60e0\u3002的空实例。
                 */
                public SkuActivityDTO() {
                }


                /**
                 * 关联活动 ID，如果是团购券和DealInfoDTO#dealId做关联。
                 */
                @JsonProperty("activityId")
                private String activityId;

                /**
                 * 活动子 ID 活动类型为41、42：activitysubId对应DealInfoDTO中的dealCode。
                 */
                @JsonProperty("activitySubId")
                private String activitySubId;

                /**
                 * 活动名称。
                 */
                @JsonProperty("activityName")
                private String activityName;

                /**
                 * 活动类型 11-单品特价 21-Combo2.0折扣 22-Combo2.0特价 23-Combo2.0立减 30-整单满减券 31-圈商品池满减券 32-折扣券 33-一口价券 41-团购券抵扣单品 42-团购券抵扣套餐 51-星星抵扣。
                 */
                @JsonProperty("activityType")
                private Integer activityType;

                /**
                 * 活动作用的对用的 ID。
                 */
                @JsonProperty("referId")
                private String referId;

                /**
                 * SKU(1, "SKU"), PREMIUM(2, "配料");
                 */
                @JsonProperty("referType")
                private Integer referType;

                /**
                 * MT优惠金额，不会被赋值，勿用。
                 */
                @JsonProperty("mtDiscountPrice")
                private Integer mtDiscountPrice;

                /**
                 * 商家优惠金额 = 商户MOP优惠金额 + 商户Deal优惠金额。
                 */
                @JsonProperty("vendorDiscountPrice")
                private Integer vendorDiscountPrice;

                /**
                 * 商户MOP优惠金额。
                 */
                @JsonProperty("vendorMopDiscountPrice")
                private Integer vendorMopDiscountPrice;

                /**
                 * 商户Deal优惠金额。
                 */
                @JsonProperty("vendorDealDiscountPrice")
                private Integer vendorDealDiscountPrice;

                /**
                 * 使用会员积分。
                 */
                @JsonProperty("memberPoint")
                private Integer memberPoint;

                /**
                 * 活动扩展信息：具体数据结构见下说明。
                 */
                @JsonProperty("activityExt")
                private JsonNode activityExt;
            }
        }
    }

    /**
     * 团购券信息列表，拆到单份（团购券兑换时必有）。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DealInfoDTO {

        /**
         * 创建\u56e2\u8d2d\u5238\u4fe1\u606f\u5217\u8868\uff0c\u62c6\u5230\u5355\u4efd\uff08\u56e2\u8d2d\u5238\u5151\u6362\u65f6\u5fc5\u6709\uff09\u3002的空实例。
         */
        public DealInfoDTO() {
        }


        /**
         * 团购券批次 ID。
         */
        @JsonProperty("dealId")
        private String dealId;

        /**
         * 团购券用户券码。
         */
        @JsonProperty("dealCode")
        private String dealCode;

        /**
         * 团购券商家应收价格(券售价-商家优惠）。
         */
        @JsonProperty("dealPayPrice")
        private Integer dealPayPrice;

        /**
         * Deal售价。
         */
        @JsonProperty("totalPrice")
        private Integer totalPrice;

        /**
         * Deal商家优惠。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;
    }

    /**
     * 订单行活动列表（整单优惠）：整单优惠是基于订单的，不会批价到sku#activityList，并且在美团内部除了积分抵扣配料之外，和其他营销都互斥的，
     * 也就是说使用了积分抵扣配料营销之外的活动商品都不参与整单优惠分摊 整单优惠最多只有一个，使用整单优惠的前提是订单中没有其他的优惠。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderActivityDTO {

        /**
         * 创建\u8ba2\u5355\u884c\u6d3b\u52a8\u5217\u8868\uff08\u6574\u5355\u4f18\u60e0\uff09\uff1a\u6574\u5355\u4f18\u60e0\u662f\u57fa\u4e8e\u8ba2\u5355\u7684\uff0c\u4e0d\u4f1a\u6279\u4ef7\u5230sku#activityList\uff0c\u5e76\u4e14\u5728\u7f8e\u56e2\u5185\u90e8\u9664\u4e86\u79ef\u5206\u62b5\u6263\u914d\u6599\u4e4b\u5916\uff0c\u548c\u5176\u4ed6\u8425\u9500\u90fd\u4e92\u65a5\u7684\uff0c的空实例。
         */
        public OrderActivityDTO() {
        }


        /**
         * 活动 ID。
         */
        @JsonProperty("activityId")
        private String activityId;

        /**
         * 活动类型 30-整单满减券。
         */
        @JsonProperty("activityType")
        private Integer activityType;

        /**
         * 活动名称。
         */
        @JsonProperty("activityName")
        private String activityName;

        /**
         * 美团优惠金额，不会被赋值，勿用。
         */
        @JsonProperty("mtDiscountPrice")
        private Integer mtDiscountPrice;

        /**
         * 商户优惠金额。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;

        /**
         * 该活动订单总优惠金额。
         */
        @JsonProperty("discountPrice")
        private Integer discountPrice;

        /**
         * 活动作用的单品的商品行。
         */
        @JsonProperty("uniqueList")
        private List<String> uniqueList;
    }
}
