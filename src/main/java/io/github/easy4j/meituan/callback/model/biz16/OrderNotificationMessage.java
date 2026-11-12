package io.github.easy4j.meituan.callback.model.biz16;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * 美团「接收订单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=16}，消息类型为 {@code msgType=16102}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_wmoperng_e166a543-49a3-4ce2-8663-35f41ea8b415">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderNotificationMessage {

    /**
     * 订单 ID。必填。
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 订单展示 ID。必填。
     */
    @JsonProperty("wm_order_id_view")
    private String wmOrderIdView;
    /**
     * 美团商家名称。必填。
     */
    @JsonProperty("wm_poi_name")
    private String wmPoiName;
    /**
     * 美团商家地址。必填。
     */
    @JsonProperty("wm_poi_address")
    private String wmPoiAddress;
    /**
     * 美团商家电话。必填。
     */
    @JsonProperty("wm_poi_phone")
    private String wmPoiPhone;
    /**
     * 收件人电话。 如果用户选择使用了隐私号，此处为隐私号。 如果用户没使用隐私号，此处为脱敏手机号。必填。
     */
    @JsonProperty("recipient_phone")
    private String recipientPhone;
    /**
     * 用户真实手机号后4位。必填。
     */
    @JsonProperty("recipient_phone_end")
    private String recipientPhoneEnd;
    /**
     * 收件人姓名。必填。
     */
    @JsonProperty("recipient_name")
    private String recipientName;
    /**
     * 忌口或备注。必填。
     */
    @JsonProperty("caution")
    private String caution;
    /**
     * 订单状态 4:商家已接单；8:订单已完成；9:订单已取消。必填。
     */
    @JsonProperty("status")
    private String status;
    /**
     * 创建时间。必填。
     */
    @JsonProperty("ctime")
    private String ctime;
    /**
     * 更新时间。必填。
     */
    @JsonProperty("utime")
    private String utime;
    /**
     * 用户预计送达时间。即用户选择或填写的预计送达时间。 “立即送达”时为0， 非0代表非即时单(包含到店自取，时间为用户到店取餐时间)，
     * 预订单代表用户下单时填写的预计送达时间，单位是秒，10位时间戳。必填。
     */
    @JsonProperty("delivery_time")
    private String deliveryTime;
    /**
     * 即时单：字段值为配送系统提供的预计送达时间。 到店自取单：字段值为用户到店取餐时间。 预订单：字段值为用户下单时填写的预计送达时间。必填。
     */
    @JsonProperty("estimate_arrival_time")
    private String estimateArrivalTime;
    /**
     * 是否是第三方配送平台配送 0表否，1表是。必填。
     */
    @JsonProperty("is_third_shipping")
    private String isThirdShipping;
    /**
     * 取餐类型（0：普通取餐；1：到店取餐）。必填。
     */
    @JsonProperty("pick_type")
    private String pickType;
    /**
     * 门店当天的推单流水号。必填。
     */
    @JsonProperty("day_seq")
    private String daySeq;
    /**
     * 用餐人数 0：用户没有选择用餐人数； 1-10：用户选择的用餐人数； -10：10人以上用餐； 88：用户需要餐具； 99：用户不需要餐具。必填。
     */
    @JsonProperty("dinners_number")
    private String dinnersNumber;
    /**
     * 订单配送方式。必填。
     */
    @JsonProperty("logistics_code")
    private String logisticsCode;
    /**
     * 用户下单时间。必填。
     */
    @JsonProperty("order_send_time")
    private String orderSendTimeSnakeCase;
    /**
     * 商户确认时间。必填。
     */
    @JsonProperty("order_confirm_time")
    private String orderConfirmTimeSnakeCase;
    /**
     * 标示该订单是否修改。 0为没有修改，1为修改。必填。
     */
    @JsonProperty("op_type")
    private String opType;
    /**
     * 订单详情。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("wmAppOrderFoods")
    private List<WmAppOrderFoods> wmAppOrderFoods;
    /**
     * 收餐地址行政区域。必填。
     */
    @JsonProperty("address_of_receiving_administrative")
    private String addressOfReceivingAdministrative;
    /**
     * 是否是商企通订单 1是商企通订单 2非商企通 0降级。
     */
    @JsonProperty("sqtOrder")
    private String sqtOrder;
    /**
     * 是否需要开发票 1需要开发票 2无需开发票 0降级。
     */
    @JsonProperty("sqtNeedInvoice")
    private String sqtNeedInvoice;
    /**
     * 门店配送费。必填。
     */
    @JsonProperty("shippingFee")
    private String shippingFee;
    /**
     * 订单金额。必填。
     */
    @JsonProperty("total")
    private String total;
    /**
     * 商品原价。必填。
     */
    @JsonProperty("originalPrice")
    private String originalPrice;
    /**
     * 支付类型，1表货到付款，2表在线支付。必填。
     */
    @JsonProperty("payType")
    private String payType;
    /**
     * 活动信息（jsonArray格式）。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("activity")
    private Activity activity;
    /**
     * 实际送餐地址纬度。字段默认内容“0.0”。必填。
     */
    @JsonProperty("latitude")
    private String latitude;
    /**
     * 实际送餐地址经度。字段默认内容“0.0”。必填。
     */
    @JsonProperty("longitude")
    private String longitude;
    /**
     * 商家对账信息，此字段为JSON字符串。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("poiReceiveDetail")
    private PoiReceiveDetail poiReceiveDetail;
    /**
     * 透传给第三方的偏移后的user_id。必填。
     */
    @JsonProperty("userIdView")
    private String userIdView;
    /**
     * 用户下单时间（用户已支付时间）。必填。
     */
    @JsonProperty("orderSendTime")
    private String orderSendTime;
    /**
     * 商户确认时间。必填。
     */
    @JsonProperty("orderConfirmTime")
    private String orderConfirmTime;
    /**
     * 商户收到时间。必填。
     */
    @JsonProperty("orderReceiveTime")
    private String orderReceiveTime;
    /**
     * 订单取消时间。必填。
     */
    @JsonProperty("orderCancelTime")
    private String orderCancelTime;
    /**
     * 订单完成时间。必填。
     */
    @JsonProperty("orderCompletedTime")
    private String orderCompletedTime;
    /**
     * 配送单下单时间。必填。
     */
    @JsonProperty("logisticsSendTime")
    private String logisticsSendTime;
    /**
     * 配送单确认时间。必填。
     */
    @JsonProperty("logisticsConfirmTime")
    private String logisticsConfirmTime;
    /**
     * 配送单取消时间。必填。
     */
    @JsonProperty("logisticsCancelTime")
    private String logisticsCancelTime;
    /**
     * 骑手取单时间。必填。
     */
    @JsonProperty("logisticsFetchTime")
    private String logisticsFetchTime;
    /**
     * 配送完成时间。必填。
     */
    @JsonProperty("logisticsCompletedTime")
    private String logisticsCompletedTime;
    /**
     * 打包费模式：0按照商品餐盒费收取，1按照订单总价收取，2按照订单口袋收取。
     */
    @JsonProperty("package_bag_mode")
    private String packageBagMode;
    /**
     * 打包费金额。
     */
    @JsonProperty("package_bag_fee")
    private String packageBagFee;
    /**
     * 口袋打包费明细：口袋 ID：cart_id（int） 原打包费：original_package_bag_fee（double）。
     */
    @JsonProperty("package_bag_cart_detail")
    private String packageBagCartDetail;
    /**
     * 拼好饭春节服务费，单位为：元。
     */
    @JsonProperty("phfSsf")
    private Float phfSsf;
    /**
     * 低收入订单，1-预计收入过低。必填。
     */
    @JsonProperty("lowincomeOrder")
    private Integer lowincomeOrder;
    /**
     * 是否1对1急送订单，0-不是急送，1-急送。
     */
    @JsonProperty("oneOneUrgentDelivery")
    private Integer oneOneUrgentDelivery;
    /**
     * 1对1急送订单是否降级，0-未降级，1-降级。
     */
    @JsonProperty("oneOneUrgentDeliveryTag")
    private Integer oneOneUrgentDeliveryTag;
    /**
     * 订单预计送达时间区间的左端点，只有该字段不为空且大于0时才有效。
     */
    @JsonProperty("estimateArrivalTimeLeft")
    private Integer estimateArrivalTimeLeft;
    /**
     * 订单预计送达时间区间的右端点，只有该字段不为空且大于0时才有效。
     */
    @JsonProperty("estimateArrivalTimeRight")
    private Integer estimateArrivalTimeRight;
    /**
     * 订单的实际配送类型，在未发配时为0。1-美配，2-自配，0-未知类型。必填。
     */
    @JsonProperty("actualLogisticsType")
    private Integer actualLogisticsType;
    /**
     * 订单的预估配送类型，可能与实际配送类型不同。1-美配，2-自配，0-未知类型。必填。
     */
    @JsonProperty("preLogisticsType")
    private Integer preLogisticsType;
    /**
     * 闪电送订单标识，1-是闪电送，0-不是闪电送。
     */
    @JsonProperty("speedyOrderTag")
    private Integer speedyOrderTag;
    /**
     * 门店纬度。
     */
    @JsonProperty("poiLatitude")
    private Double poiLatitude;
    /**
     * 门店经度。
     */
    @JsonProperty("poiLongitude")
    private Double poiLongitude;

    /**
     * 创建美团「接收订单消息」回调的业务内容。的空实例。
     */
    public OrderNotificationMessage() {
    }

    /**
     * 订单详情。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WmAppOrderFoods {

        /**
         * 菜品名称。必填。
         */
        @JsonProperty("food_name")
        private String foodName;
        /**
         * 商品数量。必填。
         */
        @JsonProperty("quantity")
        private String quantity;
        /**
         * 餐盒数量 在计算餐盒数量和餐盒费用时，请先按照商品规格维度将餐盒数量向上取整后，再乘以相应的餐盒费单价，计算得出餐盒费用。必填。
         */
        @JsonProperty("box_num")
        private String boxNum;
        /**
         * 菜品属性 多个属性用半角逗号隔开。必填。
         */
        @JsonProperty("food_property")
        private String foodProperty;
        /**
         * 商品所在的口袋 0为1号口袋，1为2号口袋，以此类推。必填。
         */
        @JsonProperty("cart_id")
        private String cartId;
        /**
         * 菜品code。必填。
         */
        @JsonProperty("appFoodCode")
        private String appFoodCode;
        /**
         * sku编码。必填。
         */
        @JsonProperty("skuId")
        private String skuId;
        /**
         * 商品单价。必填。
         */
        @JsonProperty("price")
        private BigDecimal price;
        /**
         * 餐盒价格。必填。
         */
        @JsonProperty("boxPrice")
        private BigDecimal boxPrice;
        /**
         * 单位。必填。
         */
        @JsonProperty("unit")
        private String unit;
        /**
         * 菜品规格名称。必填。
         */
        @JsonProperty("spec")
        private String spec;
        /**
         * 偏移后的skuid。必填。
         */
        @JsonProperty("mtSkuId")
        private Long mtSkuId;
        /**
         * 偏移后的spuid。必填。
         */
        @JsonProperty("mtSpuId")
        private Long mtSpuId;
        /**
         * 偏移后的tagid。必填。
         */
        @JsonProperty("mtTagId")
        private Long mtTagId;
        /**
         * 美团品类名称。必填。
         */
        @JsonProperty("tagName")
        private Long tagName;
        /**
         * 美团真实SKUID。必填。
         */
        @JsonProperty("originSkuId")
        private Long originSkuId;

        /**
         * 创建订单详情。的空实例。
         */
        public WmAppOrderFoods() {
        }
    }

    /**
     * 活动信息（jsonArray格式）。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Activity {

        /**
         * 活动 ID。必填。
         */
        @JsonProperty("actDetailId")
        private Long actDetailId;
        /**
         * 该活动用户实际享受优惠金额。必填。
         */
        @JsonProperty("reduceFee")
        private BigDecimal reduceFee;
        /**
         * 优惠金额中美团承担的部分。必填。
         */
        @JsonProperty("mtCharge")
        private BigDecimal mtCharge;
        /**
         * 优惠金额中商家承担的部分。必填。
         */
        @JsonProperty("poiCharge")
        private BigDecimal poiCharge;
        /**
         * 说明。必填。
         */
        @JsonProperty("remark")
        private String remark;
        /**
         * 活动类型。必填。
         */
        @JsonProperty("type")
        private Integer type;

        /**
         * 创建活动信息（jsonArray格式）。的空实例。
         */
        public Activity() {
        }
    }

    /**
     * 商家对账信息，此字段为JSON字符串。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiReceiveDetail {

        /**
         * 美团承担明细。
         */
        @JsonProperty("actOrderChargeByMt")
        private List<ActOrderChargeByMt> actOrderChargeByMt;
        /**
         * 商家承担明细。
         */
        @JsonProperty("actOrderChargeByPoi")
        private List<ActOrderChargeByPoi> actOrderChargeByPoi;
        /**
         * 商品分成，即平台服务费，单位为分。
         */
        @JsonProperty("foodShareFeeChargeByPoi")
        private Long foodShareFeeChargeByPoi;
        /**
         * 配送费，单位为分。
         */
        @JsonProperty("logisticsFee")
        private Long logisticsFee;
        /**
         * 在线支付款，单位为分。
         */
        @JsonProperty("onlinePayment")
        private Long onlinePayment;
        /**
         * 商家应收款，单位为分。
         */
        @JsonProperty("wmPoiReceiveCent")
        private Long wmPoiReceiveCent;
        /**
         * 拓展字段，单位为元，示例值中的属性为企客费率示例。具体属性需要根据费率模式判断。
         */
        @JsonProperty("reconciliationExtras")
        private ReconciliationExtras reconciliationExtras;

        /**
         * 创建商家对账信息，此字段为JSON字符串。的空实例。
         */
        public PoiReceiveDetail() {
        }

        /**
         * 美团承担明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ActOrderChargeByMt {

            /**
             * 备注。
             */
            @JsonProperty("comment")
            private String comment;
            /**
             * 明细费用类型描述。
             */
            @JsonProperty("feeTypeDesc")
            private String feeTypeDesc;
            /**
             * 明细费用类型 ID。
             */
            @JsonProperty("feeTypeId")
            private Integer feeTypeId;
            /**
             * 明细金额，单位为分。
             */
            @JsonProperty("moneyCent")
            private Long moneyCent;

            /**
             * 创建美团承担明细。的空实例。
             */
            public ActOrderChargeByMt() {
            }
        }

        /**
         * 商家承担明细。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ActOrderChargeByPoi {

            /**
             * 备注。
             */
            @JsonProperty("comment")
            private String comment;
            /**
             * 明细费用类型描述。
             */
            @JsonProperty("feeTypeDesc")
            private String feeTypeDesc;
            /**
             * 明细费用类型 ID。
             */
            @JsonProperty("feeTypeId")
            private Integer feeTypeId;
            /**
             * 明细金额，单位为分。
             */
            @JsonProperty("moneyCent")
            private Long moneyCent;

            /**
             * 创建商家承担明细。的空实例。
             */
            public ActOrderChargeByPoi() {
            }
        }

        /**
         * 拓展字段，单位为元，示例值中的属性为企客费率示例。具体属性需要根据费率模式判断。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ReconciliationExtras {

            /**
             * 费率模式 1:旧收费模式 2:新收费模式 3 外卖1.0模式 4 外卖2.0模式 5 外卖企客模式 6 闪购企客模式。
             */
            @JsonProperty("chargeMode")
            private Integer chargeMode;
            /**
             * 履约服务费，单位为元。
             */
            @JsonProperty("performanceServiceFee")
            private Double performanceServiceFee;
            /**
             * 技术服务费，单位为元，仅当费率模式为(4,5,6)时存在。
             */
            @JsonProperty("technicalServiceFee")
            private Double technicalServiceFee;
            /**
             * 距离收费，单位为元，仅当费率模式为(4,5,6)时存在。
             */
            @JsonProperty("distanceFee")
            private Double distanceFee;
            /**
             * 价格收费，单位为元，仅当费率模式为(4)时存在。
             */
            @JsonProperty("priceFee")
            private BigDecimal priceFee;
            /**
             * 时段增值收费，单位为元，仅当费率模式为(4,5,6)时存在。
             */
            @JsonProperty("slaFee")
            private Double slaFee;
            /**
             * 基础配送费，单位为元，仅当费率模式为(5,6)时存在。
             */
            @JsonProperty("baseShippingAmount")
            private Double baseShippingAmount;
            /**
             * 品类加价，单位为元，仅当费率模式为(5,6)时存在。
             */
            @JsonProperty("categoryChargeFee")
            private Double categoryChargeFee;
            /**
             * 重量收费，单位为元，仅当费率模式为(5,6)时存在。
             */
            @JsonProperty("weightChargeFee")
            private Double weightChargeFee;
            /**
             * 特殊日期收费，单位为元，仅当费率模式为(5,6)时存在。
             */
            @JsonProperty("holidayChargeFee")
            private Double holidayChargeFee;

            /**
             * 创建拓展字段，单位为元，示例值中的属性为企客费率示例。具体属性需要根据费率模式判断。的空实例。
             */
            public ReconciliationExtras() {
            }
        }
    }
}
