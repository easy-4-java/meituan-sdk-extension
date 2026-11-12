package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「逆向单消息」回调的业务内容。
 *
 * <p>官网未给出消息类型，可向 {@code CallbackUtil.parse} 显式传入本类型。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_2ae666d5-4440-47d5-8cd2-bb3e5ce2b33e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReverseOrderMessage {

    /**
     * 退款单基本信息。
     */
    @JsonProperty("refundOrderBase")
    private RefundOrderBase refundOrderBase;

    /**
     * 退款商品信息。
     */
    @JsonProperty("refundItemList")
    private List<RefundItem> refundItemList;

    /**
     * 退款支付信息。
     */
    @JsonProperty("refundPayList")
    private List<RefundPayment> refundPayList;

    /**
     * 退款单折扣信息。
     */
    @JsonProperty("refundDiscountList")
    private List<RefundDiscount> refundDiscountList;

    /**
     * 退款费用信息。
     */
    @JsonProperty("refundOrderServiceFeeVOS")
    private List<RefundServiceFee> refundOrderServiceFeeVOS;

    /**
     * 退款单基本信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundOrderBase {

        /**
         * 原订单id。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 最后修改人，详情页面操作人取自该值。
         */
        @JsonProperty("modifier")
        private Long modifier;

        /**
         * 退单来源，同原订单source相同含义, 1-POS、2-服务生APP、3-用户自助点餐等。
         */
        @JsonProperty("source")
        private Long source;

        /**
         * 操作设备id。
         */
        @JsonProperty("deviceId")
        private Long deviceId;

        /**
         * 菜品总价。
         */
        @JsonProperty("goodsTotalPrice")
        private Long goodsTotalPrice;

        /**
         * 退单修改时间。
         */
        @JsonProperty("modifyTime")
        private Long modifyTime;

        /**
         * 退款单号。
         */
        @JsonProperty("refundNo")
        private String refundNo;

        /**
         * 退单发起时间。
         */
        @JsonProperty("createdTime")
        private Long createdTime;

        /**
         * 自动抹零。
         */
        @JsonProperty("autoOddment")
        private Long autoOddment;

        /**
         * 税额。
         */
        @JsonProperty("taxAmt")
        private Long taxAmt;

        /**
         * 收入退款。
         */
        @JsonProperty("refundIncome")
        private Long refundIncome;

        /**
         * 服务费退款。
         */
        @JsonProperty("serviceFee")
        private Long serviceFee;

        /**
         * 取餐号。
         */
        @JsonProperty("pickupNo")
        private String pickupNo;

        /**
         * 抹零。
         */
        @JsonProperty("oddment")
        private Long oddment;

        /**
         * 原订单号。
         */
        @JsonProperty("orderNo")
        private String orderNo;

        /**
         * 退款单localId, 用于各端唯一标识。
         */
        @JsonProperty("refundLocalId")
        private String refundLocalId;

        /**
         * 应退金额, 等于退款金额 - 折扣优惠。
         */
        @JsonProperty("totalAmount")
        private Long totalAmount;

        /**
         * 税率。
         */
        @JsonProperty("taxRate")
        private String taxRate;

        /**
         * 配送费退款。
         */
        @JsonProperty("shippingFee")
        private Long shippingFee;

        /**
         * 菜品优惠合计，itemList.discountAmount之和(只计算菜品第一层级。
         */
        @JsonProperty("goodsDiscountTotalPrice")
        private Long goodsDiscountTotalPrice;

        /**
         * 退款单类型，1-红冲订单, 2-普通退款单。
         */
        @JsonProperty("refundOrderType")
        private Long refundOrderType;

        /**
         * 支付优惠合计。
         */
        @JsonProperty("payExpense")
        private Long payExpense;

        /**
         * 是否跨营业日退款, 0-否, 1-是。
         */
        @JsonProperty("isOverBusinessTime")
        private Long isOverBusinessTime;

        /**
         * 0-未申请退款，10-退款申请中，11-拒绝退单，20-退款中，21-部分退失败，22-退款失败，30-已退单。
         */
        @JsonProperty("refundStatusName")
        private String refundStatusName;

        /**
         * 实退金额，等于退款流水中退款收入合计值，正常情况等于应退金额 - 支付优惠。
         */
        @JsonProperty("refundedAmount")
        private Long refundedAmount;

        /**
         * posVersion。
         */
        @JsonProperty("posVersion")
        private Long posVersion;

        /**
         * 退单发起人名称。
         */
        @JsonProperty("creatorName")
        private String creatorName;

        /**
         * 0-未申请退款，10-退款申请中，11-拒绝退单，20-退款中，21-部分退失败，22-退款失败，30-已退单。
         */
        @JsonProperty("refundStatus")
        private Long refundStatus;

        /**
         * 原订单营业日期。
         */
        @JsonProperty("originalBusinessTime")
        private String originalBusinessTime;

        /**
         * 会员卡号。
         */
        @JsonProperty("vipCardId")
        private Long vipCardId;

        /**
         * 退款单营业日期。
         */
        @JsonProperty("businessTime")
        private String businessTime;

        /**
         * 会员手机尾号。
         */
        @JsonProperty("vipMobile")
        private String vipMobile;

        /**
         * 退款类型，1-整单退、2-部分退。
         */
        @JsonProperty("refundType")
        private Long refundType;

        /**
         * 菜品支付合计，菜品支付合计, itemList.income 之和(只计算第一层级）。
         */
        @JsonProperty("goodsRefundedTotalPrice")
        private Long goodsRefundedTotalPrice;

        /**
         * 会员名。
         */
        @JsonProperty("vipName")
        private String vipName;

        /**
         * 门店id。
         */
        @JsonProperty("poiId")
        private Long poiId;

        /**
         * 免找。
         */
        @JsonProperty("keepAmount")
        private Long keepAmount;

        /**
         * 折扣优惠合计。
         */
        @JsonProperty("onSaleDiscountTotalPrice")
        private Long onSaleDiscountTotalPrice;

        /**
         * 退单发起人。
         */
        @JsonProperty("creator")
        private Long creator;

        /**
         * ls版本号。
         */
        @JsonProperty("lsVersion")
        private Long lsVersion;

        /**
         * 部分退次数。
         */
        @JsonProperty("refundStep")
        private Long refundStep;

        /**
         * 退单原因。
         */
        @JsonProperty("refundReason")
        private String refundReason;

        /**
         * 退单版本号。
         */
        @JsonProperty("refundVersion")
        private Long refundVersion;

        /**
         * 优惠退款，等于优惠、支付流水中的折扣优惠和支付优惠合计值。
         */
        @JsonProperty("refundExpense")
        private Long refundExpense;

        /**
         * 退款金额，由菜品金额、配送费及服务费等组成，对应原订单详情中的订单金额。
         */
        @JsonProperty("originAmount")
        private Long originAmount;

        /**
         * 逆向订单标记最后一次部分退，用于外卖交班。
         */
        @JsonProperty("lastRefundType")
        private Long lastRefundType;

        /**
         * 主食统计就餐人数。
         */
        @JsonProperty("stapleFoodCustomerCounts")
        private Long stapleFoodCustomerCounts;

        /**
         * 租户id。
         */
        @JsonProperty("tenantId")
        private Long tenantId;

        /**
         * 退单修改人名字。
         */
        @JsonProperty("modifierName")
        private String modifierName;

        /**
         * 业务类型, 1-快餐、2-正餐、3-美团外卖、4-饿了么外卖、st。
         */
        @JsonProperty("businessType")
        private Long businessType;

        /**
         * 退款单id。
         */
        @JsonProperty("refundId")
        private Long refundId;

        /**
         * 不含税金额。
         */
        @JsonProperty("taxExcludedAmt")
        private Long taxExcludedAmt;
    }

    /**
     * 优惠项。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DiscountItem {

        /**
         * 优惠项名称。
         */
        @JsonProperty("discountName")
        private String discountName;

        /**
         * 优惠金额。
         */
        @JsonProperty("discountAmount")
        private Long discountAmount;
    }

    /**
     * 属性值列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AttributeValue {

        /**
         * 菜品收入。
         */
        @JsonProperty("income")
        private Long income;

        /**
         * 实际价格。
         */
        @JsonProperty("actual")
        private Long actual;

        /**
         * 优惠项。
         */
        @JsonProperty("discountItems")
        private List<DiscountItem> discountItems;

        /**
         * newTotalPrice。
         */
        @JsonProperty("newTotalPrice")
        private Long newTotalPrice;

        /**
         * 做法实际总价。
         */
        @JsonProperty("totalPrice")
        private Long totalPrice;

        /**
         * 变价类型：0-不加价、2-固定加价、3-比例加价（二期）。
         */
        @JsonProperty("changeType")
        private Long changeType;

        /**
         * 菜品优惠。
         */
        @JsonProperty("discountAmount")
        private Long discountAmount;

        /**
         * 税率。
         */
        @JsonProperty("taxRate")
        private String taxRate;

        /**
         * 做法原价总价。
         */
        @JsonProperty("originalTotalPrice")
        private Long originalTotalPrice;

        /**
         * 属性原价（做法的时候对应做法的变价金额）。
         */
        @JsonProperty("price")
        private Long price;

        /**
         * 做法ID，其他type可为0。
         */
        @JsonProperty("id")
        private Long id;

        /**
         * 属性值。
         */
        @JsonProperty("value")
        private String value;

        /**
         * 税额。
         */
        @JsonProperty("taxAmt")
        private Long taxAmt;

        /**
         * 不含税金额。
         */
        @JsonProperty("taxExcludedAmt")
        private Long taxExcludedAmt;
    }

    /**
     * 退款商品属性列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ItemAttribute {

        /**
         * 属性值列表。
         */
        @JsonProperty("values")
        private List<AttributeValue> values;

        /**
         * 属性名。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 属性类型。
         */
        @JsonProperty("type")
        private Long type;
    }

    /**
     * 退款商品信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundItem {

        /**
         * 菜品原总价合计，包含关联的餐盒价格。
         */
        @JsonProperty("newTotalPrice")
        private Long newTotalPrice;

        /**
         * SPU名称。
         */
        @JsonProperty("spuName")
        private String spuName;

        /**
         * 商品类型，1-普通菜、2-加料、4-套餐、5-餐盒、6-宴会套餐。
         */
        @JsonProperty("itemType")
        private Long itemType;

        /**
         * 原订单id。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 总价，优惠后的总价。
         */
        @JsonProperty("totalPrice")
        private Long totalPrice;

        /**
         * 退单修改人。
         */
        @JsonProperty("modifier")
        private Long modifier;

        /**
         * 菜品唯一标识。
         */
        @JsonProperty("itemNo")
        private String itemNo;

        /**
         * 是否套餐,1=是 2=否。
         */
        @JsonProperty("isCombo")
        private Long isCombo;

        /**
         * 菜品规格。
         */
        @JsonProperty("specs")
        private String specs;

        /**
         * 退单修改时间。
         */
        @JsonProperty("modifyTime")
        private Long modifyTime;

        /**
         * 退款商品属性列表。
         */
        @JsonProperty("newAttrs")
        private List<ItemAttribute> newAttrs;

        /**
         * 菜品原总价, 端上传过来之前已经算好，但不包括关联的餐盒价格。
         */
        @JsonProperty("originalTotalPrice")
        private Long originalTotalPrice;

        /**
         * 菜品单价。
         */
        @JsonProperty("price")
        private Long price;

        /**
         * 套餐是否包含做法价格（包含代表不加价）。
         */
        @JsonProperty("isComboContainMethodPrice")
        private Long isComboContainMethodPrice;

        /**
         * 退单创建时间。
         */
        @JsonProperty("createdTime")
        private Long createdTime;

        /**
         * 门店id。
         */
        @JsonProperty("poiId")
        private Long poiId;

        /**
         * 非套餐的情况下，和count一样，套餐头也一样，但是套餐子菜，count和weight是单份套餐的数量，spuCount记录的套餐份数。
         */
        @JsonProperty("spuCount")
        private Long spuCount;

        /**
         * 税额。
         */
        @JsonProperty("taxAmt")
        private Long taxAmt;

        /**
         * 菜品skuId。
         */
        @JsonProperty("skuId")
        private Long skuId;

        /**
         * 菜品收入退款，账单服务获取。
         */
        @JsonProperty("refundIncome")
        private Long refundIncome;

        /**
         * 套餐是否包含加料价格（包含代表不加价）。
         */
        @JsonProperty("isComboContainSidePrice")
        private Long isComboContainSidePrice;

        /**
         * 优惠项列表。
         */
        @JsonProperty("discountItems")
        private List<DiscountItem> discountItems;

        /**
         * 是否为临时菜。
         */
        @JsonProperty("temp")
        private Long temp;

        /**
         * 退单发起人。
         */
        @JsonProperty("creator")
        private Long creator;

        /**
         * 菜品数量。
         */
        @JsonProperty("count")
        private Double count;

        /**
         * 重量，称重菜时取。
         */
        @JsonProperty("weight")
        private Double weight;

        /**
         * 是否打包。
         */
        @JsonProperty("pack")
        private Long pack;

        /**
         * 套餐子菜加价。
         */
        @JsonProperty("comboAddPrice")
        private Long comboAddPrice;

        /**
         * 菜品属性，包含属性、做法及做法加价等信息。
         */
        @JsonProperty("attrs")
        private String attrs;

        /**
         * 税率。
         */
        @JsonProperty("taxRate")
        private String taxRate;

        /**
         * 父菜唯一标识。
         */
        @JsonProperty("parentItemNo")
        private String parentItemNo;

        /**
         * 菜品单位。
         */
        @JsonProperty("unit")
        private String unit;

        /**
         * 菜品分类id。
         */
        @JsonProperty("cateId")
        private Long cateId;

        /**
         * 菜品优惠退款, 账单服务获取。
         */
        @JsonProperty("refundDiscount")
        private Long refundDiscount;

        /**
         * 租户id。
         */
        @JsonProperty("tenantId")
        private Long tenantId;

        /**
         * 菜品spuId。
         */
        @JsonProperty("spuId")
        private Long spuId;

        /**
         * 菜品备注信息。
         */
        @JsonProperty("comment")
        private String comment;

        /**
         * 退款单id。
         */
        @JsonProperty("refundId")
        private Long refundId;

        /**
         * 不含税金额。
         */
        @JsonProperty("taxExcludedAmt")
        private Long taxExcludedAmt;
    }

    /**
     * 退款支付信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundPayment {

        /**
         * 该笔退款的收入退款金额。
         */
        @JsonProperty("income")
        private Long income;

        /**
         * 退单发起人。
         */
        @JsonProperty("creator")
        private Long creator;

        /**
         * 退单操作人编号。
         */
        @JsonProperty("modifierNo")
        private String modifierNo;

        /**
         * 原订单id。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 退单修改人。
         */
        @JsonProperty("modifier")
        private Long modifier;

        /**
         * 退款失败的原因。
         */
        @JsonProperty("failedMsg")
        private String failedMsg;

        /**
         * 原单交易流水payNo。
         */
        @JsonProperty("payTradeNo")
        private String payTradeNo;

        /**
         * 该笔退款的优惠退款金额。
         */
        @JsonProperty("expense")
        private Long expense;

        /**
         * 退款结账方式名称。
         */
        @JsonProperty("payTypeName")
        private String payTypeName;

        /**
         * 退款单交易流水。
         */
        @JsonProperty("payNo")
        private String payNo;

        /**
         * 退款结账方式类型。
         */
        @JsonProperty("payType")
        private Long payType;

        /**
         * 退单修改时间。
         */
        @JsonProperty("modifyTime")
        private Long modifyTime;

        /**
         * 租户id。
         */
        @JsonProperty("tenantId")
        private Long tenantId;

        /**
         * 退单创建时间。
         */
        @JsonProperty("createdTime")
        private Long createdTime;

        /**
         * 门店id。
         */
        @JsonProperty("poiId")
        private Long poiId;

        /**
         * 退款流水号。
         */
        @JsonProperty("refundTradeNo")
        private String refundTradeNo;

        /**
         * 退单修改人名字。
         */
        @JsonProperty("modifierName")
        private String modifierName;

        /**
         * 退款单id。
         */
        @JsonProperty("refundId")
        private Long refundId;

        /**
         * 该笔退款的状态，0-退款初始化、1-退款中、2-已退款、3-退款失败。
         */
        @JsonProperty("status")
        private Long status;

        /**
         * 该笔退款的实退金额。
         */
        @JsonProperty("payed")
        private Long payed;
    }

    /**
     * 	退款单折扣信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundDiscount {

        /**
         * 原单优惠流水号。
         */
        @JsonProperty("discountNo")
        private String discountNo;

        /**
         * 退单发起人。
         */
        @JsonProperty("creator")
        private Long creator;

        /**
         * 创建人编号。
         */
        @JsonProperty("creatorNo")
        private String creatorNo;

        /**
         * 原订单id。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 退单修改人。
         */
        @JsonProperty("modifier")
        private Long modifier;

        /**
         * 创建人名。
         */
        @JsonProperty("creatorName")
        private String creatorName;

        /**
         * 退优惠金额。
         */
        @JsonProperty("discountAmount")
        private Long discountAmount;

        /**
         * 退失败原因。
         */
        @JsonProperty("failedMsg")
        private String failedMsg;

        /**
         * 资产名称。
         */
        @JsonProperty("discountName")
        private String discountName;

        /**
         * 退单修改时间。
         */
        @JsonProperty("modifyTime")
        private Long modifyTime;

        /**
         * 额外字段信息。
         */
        @JsonProperty("extra")
        private String extra;

        /**
         * 租户id。
         */
        @JsonProperty("tenantId")
        private Long tenantId;

        /**
         * 退单创建时间。
         */
        @JsonProperty("createdTime")
        private Long createdTime;

        /**
         * 优惠类型，算价侧定义。
         */
        @JsonProperty("discountType")
        private Long discountType;

        /**
         * 优惠mode，算价侧定义。
         */
        @JsonProperty("discountMode")
        private Long discountMode;

        /**
         * 门店id。
         */
        @JsonProperty("poiId")
        private Long poiId;

        /**
         * 退优惠详情。
         */
        @JsonProperty("detail")
        private String detail;

        /**
         * 资产id。
         */
        @JsonProperty("discountId")
        private String discountId;

        /**
         * 退款单id。
         */
        @JsonProperty("refundId")
        private Long refundId;

        /**
         * 退款状态，0-退款初始化，1-退款中，2-已退款，3-退款失败。
         */
        @JsonProperty("status")
        private Long status;
    }

    /**
     * 	退款费用信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundServiceFee {

        /**
         * 服务费唯一标示。
         */
        @JsonProperty("no")
        private String no;

        /**
         * 服务费规则ID。
         */
        @JsonProperty("serviceFeeId")
        private Long serviceFeeId;

        /**
         * 退单发起人。
         */
        @JsonProperty("creator")
        private Long creator;

        /**
         * 退单修改时间。
         */
        @JsonProperty("modifyTime")
        private Long modifyTime;

        /**
         * 服务费原价总价。
         */
        @JsonProperty("totalPrice")
        private Long totalPrice;

        /**
         * 退单修改人。
         */
        @JsonProperty("modifier")
        private Long modifier;

        /**
         * 服务费名称。
         */
        @JsonProperty("name")
        private String name;

        /**
         * rule中type=1表示人数，其他表示数量。
         */
        @JsonProperty("count")
        private Double count;

        /**
         * 创建时间。
         */
        @JsonProperty("createdTime")
        private Long createdTime;

        /**
         * 退款单id。
         */
        @JsonProperty("refundId")
        private Long refundId;
    }
}
