package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

import java.math.BigDecimal;

/**
 * 美团「新订单推送（已支付）（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110025}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_3dca76a3-2434-4548-be17-d3258d17e967">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaidOrderPushMessage {

    /**
     * 订单 ID（数据库中请用bigint(20)存储此字段）；使用外卖orderIdView字段，外卖侧后续不使用该字段。必填。
     */
    @JsonProperty("orderId")
    private Long orderId;
    /**
     * 使用外卖orderIdView字段，调用美团到店核销业务接口使用的订单 ID。必填。
     */
    @JsonProperty("orderIdView")
    private Long orderIdView;
    /**
     * 到店订单 ID，到店在线核销业务必传。
     */
    @JsonProperty("dcOrderIdView")
    private Long dcOrderIdView;
    /**
     * 美团生成的openId，和品牌方会员 ID 一一对应。
     */
    @JsonProperty("dcOpenId")
    private String dcOpenId;
    /**
     * 商家门店 ID。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;
    /**
     * 到店门店的名称。必填。
     */
    @JsonProperty("poiName")
    private String poiName;
    /**
     * 默认""。必填。
     */
    @JsonProperty("poiAddress")
    private String poiAddress;
    /**
     * 默认""。必填。
     */
    @JsonProperty("poiPhone")
    private String poiPhone;
    /**
     * 默认为""。必填。
     */
    @JsonProperty("recipientAddress")
    private String recipientAddress;
    /**
     * 默认为""。必填。
     */
    @JsonProperty("recipientAddressDesensitization")
    private String recipientAddressDesensitization;
    /**
     * 用户虚拟号：异常时可能会为空。必填。
     */
    @JsonProperty("recipientPhone")
    private String recipientPhone;
    /**
     * 用户虚拟号：异常时可能会为空。必填。
     */
    @JsonProperty("backupRecipientPhone")
    private String backupRecipientPhone;
    /**
     * 默认为""。必填。
     */
    @JsonProperty("recipientName")
    private String recipientName;
    /**
     * 门店配送费；秒提业务，0：无配送费。必填。
     */
    @JsonProperty("shippingFee")
    private Float shippingFee;
    /**
     * 用户的实付价格：订单中商品使用团购券抵扣，没有加购和加付费小料则团购券抵扣为0元。必填。
     */
    @JsonProperty("total")
    private BigDecimal total;
    /**
     * 订单商品原价：外卖侧商品价格的叠加。必填。
     */
    @JsonProperty("originalPrice")
    private BigDecimal originalPrice;
    /**
     * 默认填""。必填。
     */
    @JsonProperty("caution")
    private String caution;
    /**
     * 默认填""。必填。
     */
    @JsonProperty("shipperPhone")
    private String shipperPhone;
    /**
     * 订单状态；秒提业务，2:新订单-用户支付完成，待商家接单。必填。
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 默认填-1，商家不使用。必填。
     */
    @JsonProperty("cityId")
    private Long cityId;
    /**
     * 默认填：0，否，商家用不到。必填。
     */
    @JsonProperty("hasInvoiced")
    private Integer hasInvoiced;
    /**
     * 默认填 ""，商家用不到。必填。
     */
    @JsonProperty("invoiceTitle")
    private String invoiceTitle;
    /**
     * 默认填 ""，商家用不到。必填。
     */
    @JsonProperty("taxpayerId")
    private String taxpayerId;
    /**
     * 用户下单时间。必填。
     */
    @JsonProperty("ctime")
    private Long ctime;
    /**
     * 订单更新时间。必填。
     */
    @JsonProperty("utime")
    private Long utime;
    /**
     * 用户预计送达时间，“立即送达”时为0,非0 代表非即时单(包含到店自取，时间为用户到店取餐时间)，预订单代表用户下单时填写的预计送达时间，单位是秒，
     * 10位时间戳；秒提交业务，0：即时单。必填。
     */
    @JsonProperty("deliveryTime")
    private Long deliveryTime;
    /**
     * 推单时间。必填。
     */
    @JsonProperty("estimateArrivalTime")
    private Long estimateArrivalTime;
    /**
     * 是否是第三方配送平台配送,0表否，1表是；秒提业务，0：否。必填。
     */
    @JsonProperty("isThirdShipping")
    private Integer isThirdShipping;
    /**
     * 支付类型，1表货到付款，2表在线支付(非支付渠道)；秒提业务，2：在线付款。必填。
     */
    @JsonProperty("payType")
    private Integer payType;
    /**
     * 新增类型2：到店线上核销，区别外卖到店取餐。必填。
     */
    @JsonProperty("pickType")
    private Integer pickType;
    /**
     * 0.0：无需送餐。必填。
     */
    @JsonProperty("latitude")
    private Double latitude;
    /**
     * 0.0：无需送餐。必填。
     */
    @JsonProperty("longitude")
    private Double longitude;
    /**
     * 用户c端展示的取餐码，美团生成，目前是10001-10999。必填。
     */
    @JsonProperty("daySeq")
    private Integer daySeq;
    /**
     * 用户是否收藏此门店（true, false）；秒提业务，false：无此功能。必填。
     */
    @JsonProperty("isFavorites")
    private Boolean isFavorites;
    /**
     * 用户是否第一次在此门店点餐（true, false）；秒提业务，false：无此功能。必填。
     */
    @JsonProperty("isPoiFirstOrder")
    private Boolean isPoiFirstOrder;
    /**
     * 用餐人数（0：用户没有选择用餐人数；1-10：用户选择的用餐人数；-10：10人以上用餐；88：用户需要餐具；99：用户不需要餐具）；秒提业务，0：用户没有选择用餐人数。必填。
     */
    @JsonProperty("dinnersNumber")
    private Integer dinnersNumber;
    /**
     * 填""。必填。
     */
    @JsonProperty("logisticsCode")
    private String logisticsCode;
    /**
     * 商家对账信息的json数据。必填。
     */
    @JsonProperty("poiReceiveDetail")
    private PoiReceiveDetailDetails poiReceiveDetail;
    /**
     * 订单商品详情，其值为由list。必填。
     */
    @JsonProperty("detail")
    private DetailDetails detail;
    /**
     * 未使用。必填。
     */
    @JsonProperty("extras")
    private String extras;
    /**
     * 门店平均配送时长，单位为秒；秒提业务，-1。必填。
     */
    @JsonProperty("avgSendTime")
    private Integer avgSendTime;
    /**
     * 到店线上核销业务场景下 美团：MT 点评：DP。必填。
     */
    @JsonProperty("channel")
    private String channel;
    /**
     * 0：非自动开票订单。必填。
     */
    @JsonProperty("invMakeType")
    private Integer invMakeType;
    /**
     * 0：无数据降级。
     */
    @JsonProperty("incmpCode")
    private Integer incmpCode;
    /**
     * 未使用。
     */
    @JsonProperty("incmpModules")
    private JsonNode incmpModules;
    /**
     * 未使用。必填。
     */
    @JsonProperty("extendsAmount")
    private String extendsAmount;
    /**
     * 新增业务类型 0：到店线上核销。必填。
     */
    @JsonProperty("orderTagList")
    private String orderTagList;
    /**
     * 未使用。
     */
    @JsonProperty("phf_order_extra_data")
    private Integer phfOrderExtraData;
    /**
     * 未使用。
     */
    @JsonProperty("userPayCouponAmount")
    private String userPayCouponAmount;
    /**
     * 未使用。
     */
    @JsonProperty("poiMealAssessmentTime")
    private Long poiMealAssessmentTime;
    /**
     * 未使用。
     */
    @JsonProperty("packageBagMode")
    private Integer packageBagMode;
    /**
     * 未使用。
     */
    @JsonProperty("packageBagFee")
    private Double packageBagFee;
    /**
     * 未使用。
     */
    @JsonProperty("packageBagCartDetail")
    private JsonNode packageBagCartDetail;

    /**
     * 创建美团「新订单推送（已支付）（必接）」回调的业务内容。的空实例。
     */
    public PaidOrderPushMessage() {
    }

    /**
     * 商家对账信息的json数据。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiReceiveDetailDetails {

        /**
         * 未使用。必填。
         */
        @JsonProperty("actOrderChargeByMt")
        private JsonNode actOrderChargeByMt;
        /**
         * 商家承担明细。必填。
         */
        @JsonProperty("actOrderChargeByPoi")
        private ActOrderChargeByPoiDetails actOrderChargeByPoi;
        /**
         * 平台服务费：团购核销订单无加购时为 0，付费小料场景有值。必填。
         */
        @JsonProperty("foodShareFeeChargeByPoi")
        private Long foodShareFeeChargeByPoi;
        /**
         * 0：无配送费。必填。
         */
        @JsonProperty("logisticsFee")
        private Long logisticsFee;
        /**
         * 用户实付：团购核销订单无加购时为 0，付费小料场景有正值。必填。
         */
        @JsonProperty("onlinePayment")
        private Long onlinePayment;
        /**
         * 商家应收款：团购核销订单无加购时为 0，付费小料场景有值。必填。
         */
        @JsonProperty("wmPoiReceiveCent")
        private Long wmPoiReceiveCent;
        /**
         * -。必填。
         */
        @JsonProperty("reconciliationExtras")
        private ReconciliationExtrasDetails reconciliationExtras;

        /**
         * 创建商家对账信息的json数据。的空实例。
         */
        public PoiReceiveDetailDetails() {
        }

        /**
         * 商家承担明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ActOrderChargeByPoiDetails {

            /**
             * 填""。必填。
             */
            @JsonProperty("comment")
            private String comment;
            /**
             * 默认填""。必填。
             */
            @JsonProperty("feeTypeDesc")
            private String feeTypeDesc;
            /**
             * 优惠类型，团购券：10，商家不使用。必填。
             */
            @JsonProperty("feeTypeId")
            private Integer feeTypeId;
            /**
             * 商家营销承担成本，按优惠类型聚合,单位为分。必填。
             */
            @JsonProperty("moneyCent")
            private Long moneyCent;

            /**
             * 创建商家承担明细。的空实例。
             */
            public ActOrderChargeByPoiDetails() {
            }
        }

        /**
         * -。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ReconciliationExtrasDetails {

            /**
             * 费率模式；秒提业务，新增收费模式，0：到店线上核销收费模式。必填。
             */
            @JsonProperty("chargeMode")
            private Integer chargeMode;
            /**
             * 填0.0。必填。
             */
            @JsonProperty("performanceServiceFee")
            private Double performanceServiceFee;
            /**
             * 填0.0。
             */
            @JsonProperty("technicalServiceFee")
            private Double technicalServiceFee;
            /**
             * 填0.0。
             */
            @JsonProperty("distanceFee")
            private Double distanceFee;
            /**
             * 填0.0。
             */
            @JsonProperty("feeDis")
            private Double feeDis;
            /**
             * 填0.0。
             */
            @JsonProperty("priceFee")
            private Double priceFee;
            /**
             * 填0.0。
             */
            @JsonProperty("slaFee")
            private Double slaFee;
            /**
             * 填0.0。
             */
            @JsonProperty("baseShippingAmount")
            private Double baseShippingAmount;
            /**
             * 填0.0。
             */
            @JsonProperty("categoryChargeFee")
            private Double categoryChargeFee;
            /**
             * 填0.0。
             */
            @JsonProperty("weightChargeFee")
            private Double weightChargeFee;
            /**
             * 填0.0。
             */
            @JsonProperty("holidayChargeFee")
            private Double holidayChargeFee;

            /**
             * 创建-。的空实例。
             */
            public ReconciliationExtrasDetails() {
            }
        }
    }

    /**
     * 订单商品详情，其值为由list。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DetailDetails {

        /**
         * 子商品信息列表。必填。
         */
        @JsonProperty("sub_detail_list")
        private SubDetailListDetails subDetailList;
        /**
         * 订单记录的商品行 ID，对于相同sku商品可用于标识区分，订单下唯一。必填。
         */
        @JsonProperty("detail_id")
        private Long detailId;
        /**
         * 团单 ID，到店在线核销业务必传。
         */
        @JsonProperty("dealId")
        private Long dealId;
        /**
         * 团购券抵扣的商品类型，1：单个sku，2：套餐，sub_detail_list多个元素，到店在线核销业务必传。
         */
        @JsonProperty("productType")
        private Integer productType;
        /**
         * 使用的团购券码，到店在线核销业务必传。
         */
        @JsonProperty("dealCodeList")
        private JsonNode dealCodeList;
        /**
         * 未使用。必填。
         */
        @JsonProperty("detail_extra")
        private JsonNode detailExtra;
        /**
         * 团购兑换套餐时是商家在[团购券菜品关系同步]接口同步过来的vendorComboId或者在开店宝配置的品牌方套餐code。必填。
         */
        @JsonProperty("app_food_code")
        private String appFoodCode;
        /**
         * 团购抵扣套餐时是团单的名称。必填。
         */
        @JsonProperty("food_name")
        private String foodName;
        /**
         * 团购抵扣套餐是商家在开店宝配置的【品牌方套餐skuCode】。必填。
         */
        @JsonProperty("sku_id")
        private String skuId;
        /**
         * 商品的数量，数量是 1。必填。
         */
        @JsonProperty("quantity")
        private Float quantity;
        /**
         * 外卖商品原价。必填。
         */
        @JsonProperty("price")
        private Float price;
        /**
         * 餐盒数量；秒提业务，0：无餐盒。必填。
         */
        @JsonProperty("box_num")
        private Float boxNum;
        /**
         * 餐盒价格；秒提业务，0。必填。
         */
        @JsonProperty("box_price")
        private BigDecimal boxPrice;
        /**
         * 为""，商家不使用。必填。
         */
        @JsonProperty("unit")
        private String unit;
        /**
         * 默认填1，商家不使用。必填。
         */
        @JsonProperty("food_discount")
        private Float foodDiscount;
        /**
         * 团购抵扣套餐时为""。必填。
         */
        @JsonProperty("food_property")
        private String foodProperty;
        /**
         * 默认填""，商家不使用。必填。
         */
        @JsonProperty("spec")
        private String spec;
        /**
         * 商品所在的口袋，0为1号口袋，1为2号口袋，以此类推；秒提业务，0：无口袋。必填。
         */
        @JsonProperty("cart_id")
        private Integer cartId;

        /**
         * 创建订单商品详情，其值为由list。的空实例。
         */
        public DetailDetails() {
        }

        /**
         * 子商品信息列表。
         */
        @Getter
        @Setter
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SubDetailListDetails {

            /**
             * 为-1，不使用。必填。
             */
            @JsonProperty("weight")
            private Long weight;
            /**
             * 属性值个数；秒提业务，1,1,1,1。必填。
             */
            @JsonProperty("attr_counts")
            private String attrCounts;
            /**
             * 属性名称。必填。
             */
            @JsonProperty("attr_names")
            private String attrNames;
            /**
             * 为""，商家不使用。必填。
             */
            @JsonProperty("unit")
            private String unit;
            /**
             * 为""，商家不使用。必填。
             */
            @JsonProperty("spec")
            private String spec;
            /**
             * 与外卖侧交互的三方sku编码。必填。
             */
            @JsonProperty("sku_id")
            private String skuId;
            /**
             * 套餐子商品数量。必填。
             */
            @JsonProperty("quantity")
            private Integer quantity;
            /**
             * 子商品价格，外卖侧商品价格。必填。
             */
            @JsonProperty("price")
            private BigDecimal price;
            /**
             * 完全由团购券抵扣场景时为0，付费小料订单为小料额外的加价。必填。
             */
            @JsonProperty("actual_price")
            private Float actualPrice;
            /**
             * 与外卖侧交互的三方的商品 ID。必填。
             */
            @JsonProperty("app_food_code")
            private String appFoodCode;
            /**
             * 0：无餐盒。必填。
             */
            @JsonProperty("box_num")
            private Float boxNum;
            /**
             * 0：无餐盒。必填。
             */
            @JsonProperty("box_price")
            private Float boxPrice;
            /**
             * 订单记录的商品行 ID。必填。
             */
            @JsonProperty("detail_id")
            private Long detailId;
            /**
             * 菜品名称。必填。
             */
            @JsonProperty("food_name")
            private String foodName;
            /**
             * 菜品属性：如冰,果香。必填。
             */
            @JsonProperty("food_property")
            private String foodProperty;
            /**
             * 为空，商家不使用。必填。
             */
            @JsonProperty("mt_sku_id")
            private Long mtSkuId;
            /**
             * 为空，商家不使用。必填。
             */
            @JsonProperty("mt_spu_id")
            private Long mtSpuId;
            /**
             * 为-1，商家不使用。必填。
             */
            @JsonProperty("mt_tag_id")
            private Long mtTagId;
            /**
             * 子商品价格，外卖侧商品价格。必填。
             */
            @JsonProperty("original_price")
            private BigDecimal originalPrice;

            /**
             * 创建子商品信息列表。的空实例。
             */
            public SubDetailListDetails() {
            }
        }
    }
}
