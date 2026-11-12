package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员订单可用券列表」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810057}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_b5efd6b4-800b-4f05-b5f3-e554d585ae51">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberOrderAvailableCouponsMessage {

    /**
     * 创建美团「会员订单可用券列表」回调的业务内容。的空实例。
     */
    public MemberOrderAvailableCouponsMessage() {
    }


    /**
     * 身份id。必填。
     */
    @JsonProperty("memberId")
    private String memberId;

    /**
     * 卡id。必填。
     */
    @JsonProperty("cardId")
    private String cardId;

    /**
     * 卡号。必填。
     */
    @JsonProperty("cardNo")
    private String cardNo;

    /**
     * 订单信息。
     */
    @JsonProperty("orderInfo")
    private OrderInfo orderInfo;

    /**
     * 订单商品列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sku {

        /**
         * 创建订单商品列表。的空实例。
         */
        public Sku() {
        }


        /**
         * 商品skuId。必填。
         */
        @JsonProperty("skuId")
        private Long skuId;

        /**
         * 商品数量。必填。
         */
        @JsonProperty("count")
        private String count;

        /**
         * 商品自定义标识。必填。
         */
        @JsonProperty("no")
        private String no;

        /**
         * 商品销售单价(分)。必填。
         */
        @JsonProperty("price")
        private Long price;

        /**
         * 商品优惠总金额(分)。必填。
         */
        @JsonProperty("discountAmount")
        private Long discountAmount;
    }

    /**
     * 订单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderInfo {

        /**
         * 创建订单信息。的空实例。
         */
        public OrderInfo() {
        }


        /**
         * 订单编号。
         */
        @JsonProperty("orderNo")
        private String orderNo;

        /**
         * 订单总金额 (分)。
         */
        @JsonProperty("amount")
        private Long amount;

        /**
         * 订单应收(分)。
         */
        @JsonProperty("receivable")
        private Long receivable;

        /**
         * 订单实收(分)。
         */
        @JsonProperty("payed")
        private Long payed;

        /**
         * 订单商品列表。
         */
        @JsonProperty("skus")
        private List<Sku> skus;
    }
}
