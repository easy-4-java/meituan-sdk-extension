package io.github.easy4j.meituan.callback.model.biz1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「新订单推送（已支付）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1}，消息类型为 {@code msgType=110029}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_tuangoung_a598c633-ce85-4889-a688-41d372c40c10">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaidOrderCreatedMessage {

    /**
     * 创建美团「新订单推送（已支付）」回调的业务内容。的空实例。
     */
    public PaidOrderCreatedMessage() {
    }


    /**
     * 美团生成的openId，和品牌方会员 ID 一一对应。
     */
    @JsonProperty("openId")
    private String openId;

    /**
     * 10 - 点评 20 - 美团。必填。
     */
    @JsonProperty("platform")
    private Integer platform;

    /**
     * 订单 ID（数据库中请用bigint(20)存储此字段）；使用外卖orderIdView字段，外卖侧后续不使用该字段。必填。
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
     * 在线点平台补贴金额。
     */
    @JsonProperty("mtMopDiscountPrice")
    private Integer mtMopDiscountPrice;

    /**
     * 团购券平台补贴金额。
     */
    @JsonProperty("mtDealDiscountPrice")
    private Integer mtDealDiscountPrice;

    /**
     * 商家应收金额，单位分 （纯粹商家应收，不扣除佣金）； 商家应收金额=商家团购应收金额+商家在线点应收金额。必填。
     */
    @JsonProperty("vendorBillPrice")
    private Integer vendorBillPrice;

    /**
     * 商家团购应收金额。
     */
    @JsonProperty("vendorDealBillPrice")
    private Integer vendorDealBillPrice;

    /**
     * 商家在线点应收金额。
     */
    @JsonProperty("vendorMOPBillPrice")
    private Integer vendorMOPBillPrice;

    /**
     * 美团优惠金额：因法务问题，此字段固定为0，勿用。
     */
    @JsonProperty("mtDiscountPrice")
    private Integer mtDiscountPrice;

    /**
     * 商户优惠金额=商户团购优惠金额+商户在线点优惠金额。必填。
     */
    @JsonProperty("vendorDiscountPrice")
    private Integer vendorDiscountPrice;

    /**
     * 商户团购优惠金额。购买团购券时的优惠金额。
     */
    @JsonProperty("vendorDealDiscountPrice")
    private Integer vendorDealDiscountPrice;

    /**
     * 商户在线点优惠金额。
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
     * 是否打包（标记位）。
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
     * 抵扣Combo时的优惠分摊不体现在OrderSkuDTO#skuActivityDTOList，体现在OrderComboDTO上。
     */
    @JsonProperty("orderComboDTOList")
    private List<OrderComboDTO> orderComboDTOList;

    /**
     * 团购券信息列表，拆到单份（团购券兑换时必有）。
     */
    @JsonProperty("dealInfoDTOList")
    private List<DealInfoDTO> dealInfoDTOList;

    /**
     * 订单行活动 （整单优惠）：整单优惠是基于订单的，不会批价到sku#activityList，并且在美团内部除了积分抵扣配料之外，和其他营销都互斥的，
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
     * 听到语音提示【请输入分机号】后，输入分机号1234即可。
     */
    @JsonProperty("orderExt")
    private String orderExt;

    /**
     * 业务类型 10-MOP。必填。
     */
    @JsonProperty("bizType")
    private Integer bizType;

    /**
     * 智能点餐信息。必填。
     */
    @JsonProperty("smartOrderDTO")
    private SmartOrderDTO smartOrderDTO;

    /**
     * 订单关联单品明细，拆到单份（sku、combo至少有一个）。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderSkuDTO {

        /**
         * 创建订单关联单品明细，拆到单份（sku、combo至少有一个）。的空实例。
         */
        public OrderSkuDTO() {
        }


        /**
         * 品牌商品编号。必填。
         */
        @JsonProperty("spuId")
        private String spuId;

        /**
         * 品牌skuID编号。必填。
         */
        @JsonProperty("skuId")
        private String skuId;

        /**
         * 唯一标识。必填。
         */
        @JsonProperty("unique")
        private String unique;

        /**
         * spu名称。必填。
         */
        @JsonProperty("spuName")
        private String spuName;

        /**
         * sku名称。必填。
         */
        @JsonProperty("skuName")
        private String skuName;

        /**
         * bizType=30必传，菜品状态，2-已下单、3-已退菜。
         */
        @JsonProperty("skuStatus")
        private Integer skuStatus;

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
         * 默认Sku价格。必填。
         */
        @JsonProperty("skuPrice")
        private Integer skuPrice;

        /**
         * 默认Sku + 配料的价格。必填。
         */
        @JsonProperty("totalPrice")
        private Integer totalPrice;

        /**
         * 商户优惠金额。必填。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;

        /**
         * 商户团购优惠金额。
         */
        @JsonProperty("vendorDealDiscountPrice")
        private Integer vendorDealDiscountPrice;

        /**
         * 商户在线点优惠金额。必填。
         */
        @JsonProperty("vendorMOPDiscountPrice")
        private Integer vendorMOPDiscountPrice;

        /**
         * 选购数量。必填。
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
         * 1） ITEM_TYPE，String类型，必传，1-单菜品、2-加料菜、4-套餐头、5-餐盒； 2）COMBO，String类型，必传，1是 2否 ；3）PARENT_ITEM_NO，String类型，必传，父层级itemNo，32位UUID； 4）SPECS，String类型，必传，商品规格,比如：大份、小； 5） ATTRS，String类型，非必传，做法列表信息json串： [{ "type": 1, "groupId": 123456L, "name": "做法分组名，比如辣度", "values": [{ "value": "实际做法名，比如微辣" "id":12313124214213L, "actual": 500, "changeType": 2, "originalTotalPrice": 500, "price": 500, "totalPrice": 500 }] }, { "type": 1, "groupId": 123456L, "name": "做法分组名，比如烹饪方式", "values": [{ "value": "实际做法名，比如炝炒", "id": 12313124214213L, "actual": 500, "changeType": 2, "originalTotalPrice": 500, "price": 500, "totalPrice": 500, "count": 2}] }] count为该做法在该单菜品中的数量，price为做法单价*count，totalPrice为price*单菜品数量； 6）REMARK，String类型，非必传，菜品维度备注；7）ADD_PRICE，String类型，非必传，菜品加价,单位分没有；8）IS_COMBO_CONTAIN_METHOD_PRICE，String类型，非必传，"套餐是否包含做法价格.0:不包含，不传默认为01：包含 包含代表做法没有价格传"。
         */
        @JsonProperty("skuExt")
        private String skuExt;

        /**
         * 销售属性列表（eg：杯型、温度、咖啡豆等）。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleAttrDTO {

            /**
             * 创建销售属性列表（eg：杯型、温度、咖啡豆等）。的空实例。
             */
            public SaleAttrDTO() {
            }


            /**
             * 销售属性Code。必填。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 销售属性名称。必填。
             */
            @JsonProperty("name")
            private String name;

            /**
             * 销售属性值。必填。
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
             * 创建Sku下的配料信息。的空实例。
             */
            public PremiumDTO() {
            }


            /**
             * 配料Id。必填。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 配料名称。必填。
             */
            @JsonProperty("name")
            private String name;

            /**
             * 订单价格。必填。
             */
            @JsonProperty("orderPrice")
            private Integer orderPrice;

            /**
             * 数量。必填。
             */
            @JsonProperty("count")
            private Integer count;
        }

        /**
         * 菜品活动列表，一份sku上只能用一种优惠。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SkuActivityDTO {

            /**
             * 创建菜品活动列表，一份sku上只能用一种优惠。的空实例。
             */
            public SkuActivityDTO() {
            }


            /**
             * 关联活动 ID，如果是团购券和DealInfoDTO#dealId做关联。必填。
             */
            @JsonProperty("activityId")
            private String activityId;

            /**
             * 活动子 ID 活动类型为41、42：activitysubId对应DealInfoDTO中的dealCode。
             */
            @JsonProperty("activitySubId")
            private String activitySubId;

            /**
             * 活动名称。必填。
             */
            @JsonProperty("activityName")
            private String activityName;

            /**
             * 活动类型 11-单品特价 21-Combo2.0折扣 22-Combo2.0特价 23-Combo2.0立减 30-整单满减券 31-圈商品池满减券 32-折扣券 33-一口价券 41-团购券抵扣单品 42-团购券抵扣套餐 51-星星抵扣。
             * 必填。
             */
            @JsonProperty("activityType")
            private Integer activityType;

            /**
             * 活动作用的对用的 ID。必填。
             */
            @JsonProperty("referId")
            private String referId;

            /**
             * 使用会员积分。必填。
             */
            @JsonProperty("memberPoint")
            private Integer memberPoint;

            /**
             * SKU(1, "SKU"), PREMIUM(2, "配料");。必填。
             */
            @JsonProperty("referType")
            private Integer referType;

            /**
             * MT优惠金额，不会被赋值，勿用。必填。
             */
            @JsonProperty("mtDiscountPrice")
            private Integer mtDiscountPrice;

            /**
             * 商家优惠金额 = 商户MOP优惠金额 + 商户Deal优惠金额。必填。
             */
            @JsonProperty("vendorDiscountPrice")
            private Integer vendorDiscountPrice;

            /**
             * 商户MOP优惠金额。必填。
             */
            @JsonProperty("vendorMopDiscountPrice")
            private Integer vendorMopDiscountPrice;

            /**
             * 商户Deal优惠金额。必填。
             */
            @JsonProperty("vendorDealDiscountPrice")
            private Integer vendorDealDiscountPrice;

            /**
             * 活动扩展信息：具体数据结构见下说明。
             */
            @JsonProperty("activityExt")
            private ActivityExtDetails activityExt;

            /**
             * 活动扩展信息：具体数据结构见下说明。
             */
            @Getter
            @Setter
            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                    isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ActivityExtDetails {

                /**
                 * 创建活动扩展信息：具体数据结构见下说明。的空实例。
                 */
                public ActivityExtDetails() {
                }


                /**
                 * JSON串表示，支付抵扣详情：1)goodsNo String类型，必传，抵扣菜品的itemNo; 2)weight Double类型，非必传，
                 * 抵扣重量，仅菜品券使用，针对称重菜,实际抵扣重量；3)actualDeductionAmount Long类型，必填，实际抵扣金额。必填。
                 */
                @JsonProperty("PAY_DEDUCTION_GOODS_LIST")
                private String pAYDEDUCTIONGOODSLIST;

                /**
                 * pays支付流水信息编号。
                 */
                @JsonProperty("PAY_NO")
                private String pAYNO;

                /**
                 * 总优惠金额；单位分。
                 */
                @JsonProperty("ALL_DEDUCTION_AMOUNT")
                private String aLLDEDUCTIONAMOUNT;
            }
        }
    }

    /**
     * 订单关联套餐明细，拆到单份（sku、combo至少有一个） 团购券可以抵扣Combo 也可以 抵扣Sku，
     * 抵扣Combo时的优惠分摊不体现在OrderSkuDTO#skuActivityDTOList，体现在OrderComboDTO上。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderComboDTO {

        /**
         * 创建订单关联套餐明细，拆到单份（sku、combo至少有一个） 团购券可以抵扣Combo 也可以 抵扣Sku，的空实例。
         */
        public OrderComboDTO() {
        }


        /**
         * combo的标识code。必填。
         */
        @JsonProperty("comboCode")
        private String comboCode;

        /**
         * combo名称。必填。
         */
        @JsonProperty("comboName")
        private String comboName;

        /**
         * 唯一标识符（拆份的唯一标识）。必填。
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
         * combo原价。必填。
         */
        @JsonProperty("totalPrice")
        private Integer totalPrice;

        /**
         * 是否combo活动。必填。
         */
        @JsonProperty("promotion")
        private Boolean promotion;

        /**
         * 选购数量。必填。
         */
        @JsonProperty("count")
        private Integer count;

        /**
         * 商户优惠金额，刨除团购券商家应收价格的商户优惠金额。必填。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;

        /**
         * 商户团购优惠金额。必填。
         */
        @JsonProperty("vendorDealDiscountPrice")
        private Integer vendorDealDiscountPrice;

        /**
         * 商户在线点优惠金额。必填。
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
         * combo sku列表： 如果activityType = 42 sku上不批价活动OrderSkuDTO#skuActivityDTOList 信息无。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderSkuDTO {

            /**
             * 创建combo sku列表： 如果activityType = 42 sku上不批价活动OrderSkuDTO#skuActivityDTOList 信息无。的空实例。
             */
            public OrderSkuDTO() {
            }


            /**
             * 品牌商品编号。必填。
             */
            @JsonProperty("spuId")
            private String spuId;

            /**
             * 品牌skuID编号。必填。
             */
            @JsonProperty("skuId")
            private String skuId;

            /**
             * 唯一标识。必填。
             */
            @JsonProperty("unique")
            private String unique;

            /**
             * spu名称。必填。
             */
            @JsonProperty("spuName")
            private String spuName;

            /**
             * sku名称。必填。
             */
            @JsonProperty("skuName")
            private String skuName;

            /**
             * 商品后台类目。必填。
             */
            @JsonProperty("categoryCode")
            private String categoryCode;

            /**
             * combo所属分组 ID。
             */
            @JsonProperty("comboGroupId")
            private String comboGroupId;

            /**
             * 默认Sku价格。必填。
             */
            @JsonProperty("skuPrice")
            private Integer skuPrice;

            /**
             * 默认Sku + 配料的价格。必填。
             */
            @JsonProperty("totalPrice")
            private Integer totalPrice;

            /**
             * 商户优惠金额。必填。
             */
            @JsonProperty("vendorDiscountPrice")
            private Integer vendorDiscountPrice;

            /**
             * 商户团购优惠金额。必填。
             */
            @JsonProperty("vendorDealDiscountPrice")
            private Integer vendorDealDiscountPrice;

            /**
             * 商户在线点优惠金额。必填。
             */
            @JsonProperty("vendorMOPDiscountPrice")
            private Integer vendorMOPDiscountPrice;

            /**
             * 选购数量。必填。
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
             * 1） ITEM_TYPE，String类型，必传，1-单菜品、2-加料菜、4-套餐头、5-餐盒； 2）COMBO，String类型，必传，1是 2否 ；3）PARENT_ITEM_NO，String类型，必传，父层级itemNo，32位UUID； 4）SPECS，String类型，必传，商品规格,比如：大份、小； 5） ATTRS，String类型，非必传，做法列表信息json串： [{ "type": 1, "groupId": 123456L, "name": "做法分组名，比如辣度", "values": [{ "value": "实际做法名，比如微辣" "id":12313124214213L, "actual": 500, "changeType": 2, "originalTotalPrice": 500, "price": 500, "totalPrice": 500 }] }, { "type": 1, "groupId": 123456L, "name": "做法分组名，比如烹饪方式", "values": [{ "value": "实际做法名，比如炝炒", "id": 12313124214213L, "actual": 500, "changeType": 2, "originalTotalPrice": 500, "price": 500, "totalPrice": 500, "count": 2}] }] count为该做法在该单菜品中的数量，price为做法单价*count，totalPrice为price*单菜品数量； 6）REMARK，String类型，非必传，菜品维度备注；7）ADD_PRICE，String类型，非必传，菜品加价,单位分没有；8）IS_COMBO_CONTAIN_METHOD_PRICE，String类型，非必传，"套餐是否包含做法价格.0:不包含，不传默认为01：包含 包含代表做法没有价格传"。
             */
            @JsonProperty("skuExt")
            private String skuExt;

            /**
             * bizType=30必传，菜品状态，2-已下单、3-已退菜。
             */
            @JsonProperty("skuStatus")
            private Integer skuStatus;

            /**
             * 销售属性列表（eg：杯型、温度、咖啡豆等）。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SaleAttrDTO {

                /**
                 * 创建销售属性列表（eg：杯型、温度、咖啡豆等）。的空实例。
                 */
                public SaleAttrDTO() {
                }


                /**
                 * 销售属性Code。必填。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 销售属性名称。必填。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 销售属性值。必填。
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
                 * 创建Sku下的配料信息。的空实例。
                 */
                public PremiumDTO() {
                }


                /**
                 * 配料Id。必填。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 配料名称。必填。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 订单价格。必填。
                 */
                @JsonProperty("orderPrice")
                private Integer orderPrice;

                /**
                 * 数量。必填。
                 */
                @JsonProperty("count")
                private Integer count;
            }

            /**
             * 菜品活动列表，一份sku上只能用一种优惠。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SkuActivityDTO {

                /**
                 * 创建菜品活动列表，一份sku上只能用一种优惠。的空实例。
                 */
                public SkuActivityDTO() {
                }


                /**
                 * 关联活动 ID，如果是团购券和DealInfoDTO#dealId做关联。必填。
                 */
                @JsonProperty("activityId")
                private String activityId;

                /**
                 * 活动子 ID 活动类型为41、42：activitysubId对应DealInfoDTO中的dealCode。
                 */
                @JsonProperty("activitySubId")
                private Integer activitySubId;

                /**
                 * 活动名称。必填。
                 */
                @JsonProperty("activityName")
                private String activityName;

                /**
                 * 活动类型 11-单品特价 21-Combo2.0折扣 22-Combo2.0特价 23-Combo2.0立减 30-整单满减券 31-圈商品池满减券 32-折扣券 33-一口价券 41-团购券抵扣单品 42-团购券抵扣套餐 51-星星抵扣。
                 * 必填。
                 */
                @JsonProperty("activityType")
                private Integer activityType;

                /**
                 * 活动作用的对用的 ID。必填。
                 */
                @JsonProperty("referId")
                private String referId;

                /**
                 * SKU(1, "SKU"), PREMIUM(2, "配料");。必填。
                 */
                @JsonProperty("referType")
                private Integer referType;

                /**
                 * MT优惠金额，不会被赋值，勿用。必填。
                 */
                @JsonProperty("mtDiscountPrice")
                private Integer mtDiscountPrice;

                /**
                 * 商家优惠金额 = 商户MOP优惠金额 + 商户Deal优惠金额。必填。
                 */
                @JsonProperty("vendorDiscountPrice")
                private Integer vendorDiscountPrice;

                /**
                 * 商户MOP优惠金额。必填。
                 */
                @JsonProperty("vendorMopDiscountPrice")
                private Integer vendorMopDiscountPrice;

                /**
                 * 商户Deal优惠金额。必填。
                 */
                @JsonProperty("vendorDealDiscountPrice")
                private Integer vendorDealDiscountPrice;

                /**
                 * 使用会员积分。必填。
                 */
                @JsonProperty("memberPoint")
                private Integer memberPoint;

                /**
                 * 活动扩展信息：具体数据结构见下说明。
                 */
                @JsonProperty("activityExt")
                private ActivityExtDetails activityExt;

                /**
                 * 活动扩展信息：具体数据结构见下说明。
                 */
                @Getter
                @Setter
                @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class ActivityExtDetails {

                    /**
                     * 创建活动扩展信息：具体数据结构见下说明。的空实例。
                     */
                    public ActivityExtDetails() {
                    }


                    /**
                     * JSON串表示，支付抵扣详情：1)goodsNo String类型，必传，抵扣菜品的itemNo; 2)weight Double类型，非必传，
                     * 抵扣重量，仅菜品券使用，针对称重菜,实际抵扣重量；3)actualDeductionAmount Long类型，必填，实际抵扣金额。必填。
                     */
                    @JsonProperty("PAY_DEDUCTION_GOODS_LIST")
                    private String pAYDEDUCTIONGOODSLIST;

                    /**
                     * pays支付流水信息编号。
                     */
                    @JsonProperty("PAY_NO")
                    private String pAYNO;

                    /**
                     * 总优惠金额；单位分。
                     */
                    @JsonProperty("ALL_DEDUCTION_AMOUNT")
                    private String aLLDEDUCTIONAMOUNT;
                }
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
         * 创建团购券信息列表，拆到单份（团购券兑换时必有）。的空实例。
         */
        public DealInfoDTO() {
        }


        /**
         * 团购券批次 ID。必填。
         */
        @JsonProperty("dealId")
        private Integer dealId;

        /**
         * 团购券用户券码。必填。
         */
        @JsonProperty("dealCode")
        private Integer dealCode;

        /**
         * 团购券商家应收价格(券售价-商家优惠）。必填。
         */
        @JsonProperty("dealPayPrice")
        private Integer dealPayPrice;

        /**
         * Deal售价。必填。
         */
        @JsonProperty("totalPrice")
        private Integer totalPrice;

        /**
         * Deal商家优惠。必填。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;

        /**
         * bizType=30必传，平台补贴金额，单位分。
         */
        @JsonProperty("platformCost")
        private Long platformCost;

        /**
         * bizType=30必传,deal类型，1-代金券，2-团购券。
         */
        @JsonProperty("dealType")
        private Integer dealType;

        /**
         * 团单扩展字段，示例。 "ALL_DEDUCTION_AMOUNT": "7900", "PAY_DEDUCTION_GOODS_LIST": "[{\"goodsNo\":\"b889ca55f9f239f5b038c5c9be3407cb\",\"weight\":null,\"actualDeductionAmount\":7900}]", "PAY_NO": "3dcf1ed670d93fe7baa9eca15476df84"。
         */
        @JsonProperty("dealExt")
        private DealExtDetails dealExt;

        /**
         * 团单扩展字段，示例。 "ALL_DEDUCTION_AMOUNT": "7900", "PAY_DEDUCTION_GOODS_LIST": "[{\"goodsNo\":\"b889ca55f9f239f5b038c5c9be3407cb\",\"weight\":null,\"actualDeductionAmount\":7900}]", "PAY_NO": "3dcf1ed670d93fe7baa9eca15476df84"。
         */
        @Getter
        @Setter
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DealExtDetails {

            /**
             * 创建团单扩展字段，示例。 "ALL_DEDUCTION_AMOUNT": "7900", "PAY_DEDUCTION_GOODS_LIST": "[{\"goodsNo\":\"b889ca55f9f239f5b038c5c9be3407cb\",\"weight\":null,\"actualDeductionAmount\":7900}]", "PAY_NO": "3dcf1ed670d93fe7baa9eca15476df84"。的空实例。
             */
            public DealExtDetails() {
            }


            /**
             * JSON串表示，支付抵扣详情：1)goodsNo String类型，必传，抵扣菜品的itemNo; 2)weight Double类型，非必传，
             * 抵扣重量，仅菜品券使用，针对称重菜,实际抵扣重量；3)actualDeductionAmount Long类型，必填，实际抵扣金额。必填。
             */
            @JsonProperty("PAY_DEDUCTION_GOODS_LIST")
            private String pAYDEDUCTIONGOODSLIST;

            /**
             * pays支付流水信息编号。
             */
            @JsonProperty("PAY_NO")
            private String pAYNO;

            /**
             * 总优惠金额；单位分。
             */
            @JsonProperty("ALL_DEDUCTION_AMOUNT")
            private String aLLDEDUCTIONAMOUNT;
        }
    }

    /**
     * 订单行活动 （整单优惠）：整单优惠是基于订单的，不会批价到sku#activityList，并且在美团内部除了积分抵扣配料之外，和其他营销都互斥的，
     * 也就是说使用了积分抵扣配料营销之外的活动商品都不参与整单优惠分摊 整单优惠最多只有一个，使用整单优惠的前提是订单中没有其他的优惠。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderActivityDTO {

        /**
         * 创建订单行活动 （整单优惠）：整单优惠是基于订单的，不会批价到sku#activityList，并且在美团内部除了积分抵扣配料之外，和其他营销都互斥的，的空实例。
         */
        public OrderActivityDTO() {
        }


        /**
         * 活动 ID。必填。
         */
        @JsonProperty("activityId")
        private String activityId;

        /**
         * 活动类型 30-整单满减券。必填。
         */
        @JsonProperty("activityType")
        private Integer activityType;

        /**
         * 活动名称。必填。
         */
        @JsonProperty("activityName")
        private String activityName;

        /**
         * 美团优惠金额，不会被赋值，勿用。必填。
         */
        @JsonProperty("mtDiscountPrice")
        private Integer mtDiscountPrice;

        /**
         * 商户优惠金额。必填。
         */
        @JsonProperty("vendorDiscountPrice")
        private Integer vendorDiscountPrice;

        /**
         * 该活动订单总优惠金额。必填。
         */
        @JsonProperty("discountPrice")
        private Integer discountPrice;

        /**
         * 活动作用的单品的商品行。必填。
         */
        @JsonProperty("uniqueList")
        private List<String> uniqueList;
    }

    /**
     * 智能点餐信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SmartOrderDTO {

        /**
         * 创建智能点餐信息。的空实例。
         */
        public SmartOrderDTO() {
        }


        /**
         * 人数。
         */
        @JsonProperty("customerCount")
        private Integer customerCount;

        /**
         * 店内订单：100-已创建,300-已结账、600-已取消、500-已退单。
         */
        @JsonProperty("orderStatus")
        private Integer orderStatus;

        /**
         * 1-桌台号（桌台码）、2-流水号（尾号自动增加）、3-号牌（商家店内实体号牌直接输入）。
         */
        @JsonProperty("pickupType")
        private Integer pickupType;

        /**
         * 当pickupType取餐类型为2流水号模式，且generatePickupNo为1可不传，其余情况必传。pickupType=1：桌台名称；
         *  pickupType=2：流水号； pickupType=3：号牌；
         */
        @JsonProperty("pickupNo")
        private String pickupNo;

        /**
         * 支付明细列表。
         */
        @JsonProperty("payDTOList")
        private List<PayDTO> payDTOList;

        /**
         * 桌台名称。
         */
        @JsonProperty("tableName")
        private String tableName;

        /**
         * payDTOList。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PayDTO {

            /**
             * 创建payDTOList。的空实例。
             */
            public PayDTO() {
            }


            /**
             * -1,"未支付"1, "已支付" 2, "已撤销/退款成功"3, "支付中"4, "退款中"5, "支付失败"6, "退款失败"。
             */
            @JsonProperty("status")
            private Integer status;

            /**
             * 1-支付、3-退款。
             */
            @JsonProperty("type")
            private Integer type;

            /**
             * "3":"美团团购"。
             */
            @JsonProperty("payType")
            private Integer payType;

            /**
             * 实际Name,如"美团团购"。
             */
            @JsonProperty("payTypeName")
            private String payTypeName;

            /**
             * 1.券码场景，为券抵扣金额 2.尾款，为实付。
             */
            @JsonProperty("payed")
            private Integer payed;

            /**
             * 每一笔流水都生成唯一标识，原路退时会关联原流水，32位UUID。
             */
            @JsonProperty("payNo")
            private String payNo;

            /**
             * 支付时间毫秒时间戳。
             */
            @JsonProperty("operatedTime")
            private Long operatedTime;

            /**
             * 示例。
             *
             * <pre>
             * {
             *   "couponPlatform": "MT",
             *   "couponCode": "0",
             *   "dealTitle": "尾款",
             *   "dealValue": 6600,
             *   "couponBuyPrice": 6600,
             *   "couponDealId": "0",
             *   "couponCount": 1,
             *   "encryptedCode": null,
             *   "bizCost": 0,
             *   "platBizCost": 0,
             *   "dealPrice": 6600,
             *   "payDetailType": null,
             *   "due": 6600,
             *   "payDeductionGoodsList": []
             * }
             * </pre>
             */
            @JsonProperty("payExt")
            private PayExtDetails payExt;

            /**
             * 示例{"couponPlatform":"MT","couponCode":"0","dealTitle":"尾款","dealValue":6600,"couponBuyPrice":6600,"couponDealId":"0","couponCount":1,"encryptedCode":null,"bizCost":0,"platBizCost":0,"dealPrice":6600,"payDetailType":null,。
             */
            @Getter
            @Setter
            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                    isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PayExtDetails {

                /**
                 * 创建示例{"couponPlatform":"MT","couponCode":"0","dealTitle":"尾款","dealValue":6600,"couponBuyPrice":6600,"couponDealId":"0","couponCount":1,"encryptedCode":null,"bizCost":0,"platBizCost":0,"dealPrice":6600,"payDetailType":null,。的空实例。
                 */
                public PayExtDetails() {
                }


                /**
                 * JSON串表示，支付抵扣详情：1)goodsNo String类型，必传，抵扣菜品的itemNo; 2)weight Double类型，非必传，
                 * 抵扣重量，仅菜品券使用，针对称重菜,实际抵扣重量；3)actualDeductionAmount Long类型，必填，实际抵扣金额。必填。
                 */
                @JsonProperty("PAY_DEDUCTION_GOODS_LIST")
                private String pAYDEDUCTIONGOODSLIST;

                /**
                 * pays支付流水信息编号。
                 */
                @JsonProperty("PAY_NO")
                private String pAYNO;

                /**
                 * 总优惠金额；单位分。
                 */
                @JsonProperty("ALL_DEDUCTION_AMOUNT")
                private String aLLDEDUCTIONAMOUNT;
            }
        }
    }
}
