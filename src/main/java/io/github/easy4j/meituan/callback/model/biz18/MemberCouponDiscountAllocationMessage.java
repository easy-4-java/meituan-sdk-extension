package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员券优惠分摊」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810059}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_1e8b7101-896d-422a-bf75-0348367b674b">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberCouponDiscountAllocationMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u4f1a\u5458\u5238\u4f18\u60e0\u5206\u644a\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MemberCouponDiscountAllocationMessage() {
    }


    /**
     * 会员 ID。
     */
    @JsonProperty("memberId")
    private String memberId;

    /**
     * 卡 ID。
     */
    @JsonProperty("cardId")
    private String cardId;

    /**
     * 卡号。
     */
    @JsonProperty("cardNo")
    private String cardNo;

    /**
     * 待核销的券码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 订单信息，不传递则不计算可用券、已使用券。
     */
    @JsonProperty("orderInfo")
    private OrderInfoDetails orderInfo;

    /**
     * 订单信息，不传递则不计算可用券、已使用券。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderInfoDetails {

        /**
         * 创建\u8ba2\u5355\u4fe1\u606f\uff0c\u4e0d\u4f20\u9012\u5219\u4e0d\u8ba1\u7b97\u53ef\u7528\u5238\u3001\u5df2\u4f7f\u7528\u5238\u3002的空实例。
         */
        public OrderInfoDetails() {
        }


        /**
         * localserver订单 ID。
         */
        @JsonProperty("localId")
        private String localId;

        /**
         * 订单总金额。
         */
        @JsonProperty("amount")
        private Long amount;

        /**
         * 应收。
         */
        @JsonProperty("receivable")
        private Long receivable;

        /**
         * 实收。
         */
        @JsonProperty("payed")
        private Long payed;

        /**
         * 商品列表。
         */
        @JsonProperty("skus")
        private List<SkusItem> skus;

        /**
         * 商品列表。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SkusItem {

            /**
             * 创建\u5546\u54c1\u5217\u8868\u3002的空实例。
             */
            public SkusItem() {
            }


            /**
             * 商品编号。
             */
            @JsonProperty("no")
            private String no;

            /**
             * 商品 ID。
             */
            @JsonProperty("skuId")
            private String skuId;

            /**
             * 商品数量。
             */
            @JsonProperty("count")
            private Integer count;

            /**
             * 商品单价。
             */
            @JsonProperty("price")
            private Long price;

            /**
             * 商品优惠总金额，默认0。
             */
            @JsonProperty("discountAmount")
            private Long discountAmount;
        }
    }
}
