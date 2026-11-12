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
