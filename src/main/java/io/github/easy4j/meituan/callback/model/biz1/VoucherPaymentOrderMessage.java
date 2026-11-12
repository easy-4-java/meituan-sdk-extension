package io.github.easy4j.meituan.callback.model.biz1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 美团「代金券买单订单消息【必接】」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1}，消息类型为 {@code msgType=110009}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_tuangoung_339f232c-3fcc-42bb-af9e-979375b5e8dc">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoucherPaymentOrderMessage {

    /**
     * 系统订单号。
     */
    @JsonProperty("orderId")
    private Long orderId;
    /**
     * C端用户订单号。
     */
    @JsonProperty("serialNumber")
    private String serialNumber;
    /**
     * 订单消息类型 createOrder：创单成功 payOrderSuccess：订单支付成功 payOrderError：订单支付失败 refundingOrder：退款中 refundOrderSuccess：退款成功 refundOrderError：退款失败 unknownOrder：未知状态。
     */
    @JsonProperty("msgType")
    private String msgType;
    /**
     * 订单消息体。
     */
    @JsonProperty("msgContent")
    private String msgContent;
    /**
     * 用户 ID，根据userType区分点评或者美团订单（0 点评， 1 美团）。
     */
    @JsonProperty("userId")
    private Long userId;
    /**
     * 用户类型 0点评；1美团。
     */
    @JsonProperty("userType")
    private Integer userType;
    /**
     * 用户手机号。
     */
    @JsonProperty("mobileNo")
    private String mobileNo;
    /**
     * 下单时间。
     */
    @JsonProperty("orderAddTime")
    private Long orderAddTime;
    /**
     * 订单最后更新时间。
     */
    @JsonProperty("orderUpdateTime")
    private Long orderUpdateTime;
    /**
     * 订单支付时间。
     */
    @JsonProperty("payTime")
    private Long payTime;
    /**
     * 下单美团城市 ID。
     */
    @JsonProperty("mtCityId")
    private Integer mtCityId;
    /**
     * 订单状态 0（创单成功） 10（支付成功） 34、54、4（支付失败） 30、31（退款中） 50（退款成功） 40（退款失败）。
     */
    @JsonProperty("orderStatus")
    private Integer orderStatus;
    /**
     * 订单金额。
     */
    @JsonProperty("orderAmount")
    private BigDecimal orderAmount;
    /**
     * 不享优惠金额。
     */
    @JsonProperty("noDiscountAmount")
    private BigDecimal noDiscountAmount;
    /**
     * 用户实付金额。
     */
    @JsonProperty("userPayAmount")
    private BigDecimal userPayAmount;
    /**
     * 代金券抵扣金额。
     */
    @JsonProperty("groupVoucherDiscountAmount")
    private BigDecimal groupVoucherDiscountAmount;
    /**
     * 优惠详细信息。
     */
    @JsonProperty("couponInfoList")
    private CouponInfo couponInfoList;
    /**
     * 商品 ID。
     */
    @JsonProperty("productId")
    private Long productId;
    /**
     * 退款详细信息。
     */
    @JsonProperty("refundInfo")
    private RefundInfo refundInfo;
    /**
     * 扩展字段。
     */
    @JsonProperty("extraInfo")
    private JsonNode extraInfo;

    /**
     * 创建美团「代金券买单订单消息【必接】」回调的业务内容。的空实例。
     */
    public VoucherPaymentOrderMessage() {
    }

    /**
     * 优惠详细信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CouponInfo {

        /**
         * 优惠类型，
         * 优惠名称 couponType 点评优惠——立减运营活动 10 点评优惠——抵用券 20 点评优惠——优惠代码 21 平台优惠——美团红包 22 平台优惠——美团抵用券 23 点评优惠——红包/现金券 30 点评优惠——积分 40 团购代金券 52 商户优惠——折扣 101 商户优惠——赠品 102 商户优惠——满减 103 商户优惠——满赠券 104 商户优惠-预定立减优惠 105 平台立减-KA铺码 106 商户优惠——尊享券送券 110 商户优惠——尊享券用券 111 商户优惠——抵用券 112 商户优惠——会员卡 113 商户优惠——原价买单 114 商户优惠——美团商家红包 115 商家优惠——美团商家自促抵用券 116 自助餐 117 美团会员卡 118 商家优惠——点评商家自促抵用券 119 商户优惠——预订订金 120 平台优惠——满赠 200。
         */
        @JsonProperty("couponType")
        private Integer couponType;
        /**
         * 优惠 ID。
         */
        @JsonProperty("couponIdStr")
        private String couponIdStr;
        /**
         * 优惠金额。
         */
        @JsonProperty("couponAmount")
        private BigDecimal couponAmount;
        /**
         * 用户实付金额。
         */
        @JsonProperty("realPayAmount")
        private BigDecimal realPayAmount;
        /**
         * 代金券优惠对应的商品 ID。
         */
        @JsonProperty("dealId")
        private Long dealId;
        /**
         * 扩展信息。
         */
        @JsonProperty("extraMessage")
        private String extraMessage;

        /**
         * 创建优惠详细信息。的空实例。
         */
        public CouponInfo() {
        }
    }

    /**
     * 退款详细信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundInfo {

        /**
         * 退款来源。
         */
        @JsonProperty("refundSource")
        private String refundSource;
        /**
         * 操作者。
         */
        @JsonProperty("operator")
        private String operator;
        /**
         * 操作者IP。
         */
        @JsonProperty("operatorIp")
        private String operatorIp;
        /**
         * 退款原因。
         */
        @JsonProperty("refundReason")
        private String refundReason;
        /**
         * 退款时间。
         */
        @JsonProperty("refundTime")
        private Long refundTime;

        /**
         * 创建退款详细信息。的空实例。
         */
        public RefundInfo() {
        }
    }
}
