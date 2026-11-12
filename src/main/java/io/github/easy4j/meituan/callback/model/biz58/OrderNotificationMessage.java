package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「订单信息推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810055}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_6fae169d-1eb4-4881-aa04-da68a4a33106">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderNotificationMessage {

    /**
     * 美团订单号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 消息类型(1-下单成功通知（发券通知） 2-核销（消费） 3-撤销核销（撤销消费） 4-退款完成（未消费退/已消费退） 5-订单创建成功 6-订单支付成功 7-订单取消（用户未支付） 8-订单失败（用户支付成功后因为优惠使用失败或发券失败导致的订单失败） 9-退款审核拒绝通知)。
     * 必填。
     */
    @JsonProperty("messageType")
    private String messageType;

    /**
     * 商品信息(size 为1)。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("products")
    private List<Product> products;

    /**
     * 消息Id，消息的唯一Id，可用作推送消息处理的幂等键。长度为36的字符串示例：1ec33ae7-5248-4262-aa3f-25ad4c5b2639。必填。
     */
    @JsonProperty("messageId")
    private String messageId;

    /**
     * 订单创建时间（毫秒级时间戳）。必填。
     */
    @JsonProperty("orderCreateTime")
    private String orderCreateTime;

    /**
     * 扩展字段。
     */
    @JsonProperty("extend")
    private String extend;

    /**
     * 交易类型（团购普通单：nib.general.groupbuy，预付：nib.general.prepay）。
     */
    @JsonProperty("bizCode")
    private String bizCode;

    /**
     * 预付相关信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("prepayInfo")
    private PrepayInfo prepayInfo;

    /**
     * 平台用户 ID。
     */
    @JsonProperty("opUserId")
    private String opUserId;

    /**
     * 用户来源。
     */
    @JsonProperty("userSource")
    private String userSource;

    /**
     * 统一订单 ID。
     */
    @JsonProperty("unifiedOrderId")
    private String unifiedOrderId;

    /**
     * 团购普通单相关支付信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("orderPrice")
    private OrderPriceDTO orderPrice;

    /**
     * 是否连续包月。
     */
    @JsonProperty("monthlySubscription")
    private Boolean monthlySubscription;

    /**
     * 连续包月当前核销次数。
     */
    @JsonProperty("currentConsumeSequenceNo")
    private Integer currentConsumeSequenceNo;

    /**
     * 团购次卡总共次数。
     */
    @JsonProperty("totalReceiptCount")
    private Integer totalReceiptCount;

    /**
     * 退款信息。
     */
    @JsonProperty("refundInfo")
    private RefundInfoDetails refundInfo;

    /**
     * 事件时间戳。
     */
    @JsonProperty("eventTime")
    private Long eventTime;

    /**
     * 订单类型，0-普通团购订单，1-到店提货订单(需要备货回调接单)。
     */
    @JsonProperty("orderType")
    private Integer orderType;

    /**
     * 包厢名称，目前仅用于KTV包厢码(需订阅)。
     */
    @JsonProperty("roomName")
    private String roomName;

    /**
     * 技术信息。
     */
    @JsonProperty("techInfo")
    private TechInfoBO techInfo;

    /**
     * 是否连续包月订单，非次卡场景。
     */
    @JsonProperty("isMonthlySubscriptionOrder")
    private Boolean isMonthlySubscriptionOrder;

    /**
     * 连续包月首单单号，非次卡场景。
     */
    @JsonProperty("mainOrderId")
    private String mainOrderId;

    /**
     * 连续包月期数，非次卡场景。
     */
    @JsonProperty("sequence")
    private Integer sequence;

    /**
     * 预付相关信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PrepayInfo {

        /**
         * 订单总价（保留两位小数）。必填。
         */
        @JsonProperty("totalPrice")
        private String totalPrice;

        /**
         * 预付金。必填。
         */
        @JsonProperty("prePayPrice")
        private String prePayPrice;

        /**
         * 预付金用户实付。
         */
        @JsonProperty("prePayAmount")
        private String prePayAmount;

        /**
         * 尾款实付。
         */
        @JsonProperty("remainAmount")
        private String remainAmount;

        /**
         * 是否已支付尾款（当尾款为0时，默认为true）。
         */
        @JsonProperty("remainAmountPayed")
        private String remainAmountPayed;

        /**
         * 尾款支付时间（毫秒级时间戳）。
         */
        @JsonProperty("remainAmountPayTime")
        private String remainAmountPayTime;
    }

    /**
     * refundInfo。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundInfoDetails {

        /**
         * 退款单 ID。
         */
        @JsonProperty("refundId")
        private String refundId;

        /**
         * 1-未消费退，2-已消费退。
         */
        @JsonProperty("refundType")
        private Integer refundType;
    }

    /**
     * techInfo。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TechInfoBO {

        /**
         * 美团职人 ID。
         */
        @JsonProperty("techId")
        private Long techId;

        /**
         * 职人姓名。
         */
        @JsonProperty("techName")
        private String techName;

        /**
         * 职人手机号（脱敏值）。
         */
        @JsonProperty("techMobile")
        private String techMobile;
    }
}
