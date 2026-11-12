package io.github.easy4j.meituan.callback.model.biz61;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「ORDER_SUBMIT」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=61}，消息类型为 {@code msgType=6110001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_outdistribution_94f141f9-ad3a-41c1-8dfa-5d749212add3">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSubmitMessage {

    /**
     * 创建美团「ORDER_SUBMIT」回调的业务内容。的空实例。
     */
    public OrderSubmitMessage() {
    }


    /**
     * 唯一key。
     */
    @JsonProperty("uniqueId")
    private String uniqueId;

    /**
     * 渠道编码。
     */
    @JsonProperty("channelId")
    private Integer channelId;

    /**
     * 订单号。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 生单时间戳(ms)。
     */
    @JsonProperty("createTime")
    private Long createTime;

    /**
     * 用户编码。
     */
    @JsonProperty("userId")
    private Long userId;

    /**
     * 待支付截止时间。
     */
    @JsonProperty("expireTime")
    private Long expireTime;

    /**
     * 应付金额。
     */
    @JsonProperty("totalAmount")
    private Long totalAmount;

    /**
     * 优惠金额。
     */
    @JsonProperty("discountAmount")
    private Long discountAmount;

    /**
     * 拓展信息。
     */
    @JsonProperty("orderExtend")
    private OrderExtendDTO orderExtend;

    /**
     * 订单详情。
     */
    @JsonProperty("orderItemList")
    private List<OrderItemDto> orderItemList;

    /**
     * 订单详情页面地址。
     */
    @JsonProperty("detailPageUrl")
    private String detailPageUrl;

    /**
     * 订单详情。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderItemDto {

        /**
         * 创建订单详情。的空实例。
         */
        public OrderItemDto() {
        }


        /**
         * 购买项Id。
         */
        @JsonProperty("id")
        private Long id;

        /**
         * 数量。
         */
        @JsonProperty("totalQuantity")
        private Integer totalQuantity;

        /**
         * 商品Id。
         */
        @JsonProperty("productId")
        private Long productId;

        /**
         * 套餐Id。
         */
        @JsonProperty("skuId")
        private Long skuId;

        /**
         * 门店名称。
         */
        @JsonProperty("shopName")
        private String shopName;

        /**
         * 商品名称。
         */
        @JsonProperty("productName")
        private String productName;

        /**
         * 商品头图。
         */
        @JsonProperty("productHeaderUrl")
        private String productHeaderUrl;

        /**
         * 城市 ID。
         */
        @JsonProperty("cityId")
        private Integer cityId;

        /**
         * 门店 ID。
         */
        @JsonProperty("shopId")
        private Long shopId;
    }
}
