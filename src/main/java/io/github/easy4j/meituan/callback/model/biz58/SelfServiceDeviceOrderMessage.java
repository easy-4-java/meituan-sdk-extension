package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「自助设备订单信息推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810145}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_165fdd05-1c25-4f13-9f62-285324deda4c">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelfServiceDeviceOrderMessage {

    /**
     * 美团订单号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 消息类型(1-下单成功通知（发券通知） 2-核销（消费） 3-撤销核销（撤销消费） 4-退款完成（未消费退/已消费退） 5-订单创建成功 6-订单支付成功 7-订单取消（用户未支付） 8-订单失败（用户支付成功后因为优惠使用失败或发券失败导致的订单失败）)。
     * 必填。
     */
    @JsonProperty("messageType")
    private Integer messageType;

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
     * 团购普通单相关支付信息。
     */
    @JsonProperty("orderPrice")
    private OrderPriceDTO orderPrice;

    /**
     * 统一订单号。必填。
     */
    @JsonProperty("unifiedOrderId")
    private String unifiedOrderId;

    /**
     * 商品信息(size 为1)。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {

        /**
         * 美团商品 ID。
         */
        @JsonProperty("productId")
        private Long productId;

        /**
         * 商品名称。
         */
        @JsonProperty("title")
        private String title;

        /**
         * skuId。
         */
        @JsonProperty("skuId")
        private Long skuId;

        /**
         * 购买数量。
         */
        @JsonProperty("quantity")
        private Long quantity;
    }

    /**
     * 团购普通单相关支付信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderPriceDTO {

        /**
         * 订单金额。
         */
        @JsonProperty("orderTotalPrice")
        private String orderTotalPrice;

        /**
         * 订单商家优惠金额。
         */
        @JsonProperty("orderMerchantDiscountPrice")
        private String orderMerchantDiscountPrice;

        /**
         * 订单用户实付金额。
         */
        @JsonProperty("orderActualPayPrice")
        private String orderActualPayPrice;
    }
}
