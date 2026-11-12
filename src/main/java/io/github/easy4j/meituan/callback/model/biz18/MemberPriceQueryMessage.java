package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询商品会员价」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810093}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_42758627-f078-43fe-9420-73cc37c31cab">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPriceQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u5546\u54c1\u4f1a\u5458\u4ef7\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MemberPriceQueryMessage() {
    }


    /**
     * 会员 ID。必填。
     */
    @JsonProperty("memberId")
    private String memberId;

    /**
     * 卡 ID。必填。
     */
    @JsonProperty("cardId")
    private String cardId;

    /**
     * 卡号。
     */
    @JsonProperty("cardNo")
    private String cardNo;

    /**
     * 商品规格列表。必填。
     */
    @JsonProperty("skus")
    private StandardLoyaltySkus skus;

    /**
     * skus。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StandardLoyaltySkus {

        /**
         * 创建skus\u3002的空实例。
         */
        public StandardLoyaltySkus() {
        }


        /**
         * 菜品skuId。必填。
         */
        @JsonProperty("skuId")
        private Integer skuId;

        /**
         * 菜品使用优惠后单价(分)。必填。
         */
        @JsonProperty("priceAfterDiscount")
        private Long priceAfterDiscount;

        /**
         * 菜品原价（不受优惠影响）(分)。必填。
         */
        @JsonProperty("price")
        private Long price;
    }
}
