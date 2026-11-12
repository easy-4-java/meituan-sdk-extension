package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员券优惠分摊」回调的业务响应。
 *
 * <p>收银端响应示例将本对象置于 {@code data}，外层 {@code message} 为 {@code ok}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_1e8b7101-896d-422a-bf75-0348367b674b">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberCouponDiscountAllocationResult {

    /**
     * 优惠金额（分）。
     */
    @JsonProperty("discountAmount")
    private Long discountAmount;

    /**
     * 菜品优惠分摊。
     */
    @JsonProperty("goodsApportions")
    private List<GoodsApportion> goodsApportions;

    /**
     * 菜品优惠分摊。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GoodsApportion {

        /**
         * 商品编号。必填。
         */
        @JsonProperty("goodsNo")
        private String goodsNo;

        /**
         * 商品本身优惠金额/分。必填。
         */
        @JsonProperty("goodsDiscountAmount")
        private Long goodsDiscountAmount;

        /**
         * 商品id。必填。
         */
        @JsonProperty("skuId")
        private String skuId;
    }
}
