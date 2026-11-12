package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员订单可用券列表」回调的业务响应。
 *
 * <p>收银端响应示例将本对象置于 {@code data}，外层 {@code message} 为 {@code ok}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_b5efd6b4-800b-4f05-b5f3-e554d585ae51">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberOrderAvailableCouponsResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u4f1a\u5458\u8ba2\u5355\u53ef\u7528\u5238\u5217\u8868\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public MemberOrderAvailableCouponsResult() {
    }


    /**
     * 当前订单可使用的第三方会员优惠券列表。
     */
    @JsonProperty("availableCoupons")
    private List<AvailableCoupon> availableCoupons;

    /**
     * 当前订单可使用的第三方会员优惠券列表。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AvailableCoupon {

        /**
         * 创建\u5f53\u524d\u8ba2\u5355\u53ef\u4f7f\u7528\u7684\u7b2c\u4e09\u65b9\u4f1a\u5458\u4f18\u60e0\u5238\u5217\u8868\u3002的空实例。
         */
        public AvailableCoupon() {
        }


        /**
         * 优惠规则，5折、5元，仅 代金券、折扣券存在，其余不存在。
         */
        @JsonProperty("context")
        private String context;

        /**
         * 订单计算中，优惠券可优惠的金额/分。必填。
         */
        @JsonProperty("discountAmount")
        private Long discountAmount;

        /**
         * 券码，核销券时需要使用。
         */
        @JsonProperty("code")
        private String code;

        /**
         * 券标题。必填。
         */
        @JsonProperty("title")
        private String title;

        /**
         * 门槛文案，订单满100元可用。必填。
         */
        @JsonProperty("condition")
        private String condition;

        /**
         * 券有效期开始时间，2021/08/02。
         */
        @JsonProperty("beginAt")
        private String beginAt;

        /**
         * 券有效期结束时间，2022/08/01。
         */
        @JsonProperty("endAt")
        private String endAt;
    }
}
