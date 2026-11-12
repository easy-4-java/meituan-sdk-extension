package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「商家券批量查询三方订单信息」回调的业务响应。
 *
 * <p>业务数据为数组，本类型表示其中一个元素。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_ea80d356-994b-4460-831e-f6f2176425ff">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponOrderBatchQueriedResult {

    /**
     * 订单号。美团订单号必填。
     */
    @JsonProperty("orderId")
    private Long orderId;
    /**
     * 券码类型。券码类型(1-一码一用，2-一码多用)必填。
     */
    @JsonProperty("receiptType")
    private Integer receiptType;
    /**
     * 券码信息列表。必填。
     */
    @JsonProperty("receiptInfoResults")
    private List<ReceiptInfoResult> receiptInfoResults;
    /**
     * 待使用券个数。待使用券个数， 券类型为一码多用时必填。
     */
    @JsonProperty("toUseCount")
    private Integer toUseCount;
    /**
     * 已使用券个数。已使用券个数， 券类型为一码多用时必填。
     */
    @JsonProperty("usedCount")
    private Integer usedCount;
    /**
     * 已退款券个数。已退款券个数， 券类型为一码多用时必填。
     */
    @JsonProperty("refundCount")
    private Integer refundCount;

    /**
     * 创建美团「商家券批量查询三方订单信息」回调的业务响应。的空实例。
     */
    public MerchantCouponOrderBatchQueriedResult() {
    }

    /**
     * 券码信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReceiptInfoResult {

        /**
         * 券号。券码必填。
         */
        @JsonProperty("receiptCode")
        private String receiptCode;
        /**
         * 商家二维码链接。
         */
        @JsonProperty("receiptCodePic")
        private String receiptCodePic;
        /**
         * 券状态。券状态必填，1-未使用 2-已使用 4-已退款 5-退款中。
         */
        @JsonProperty("receiptStatus")
        private Integer receiptStatus;
        /**
         * 美团门店。如果状态为2，则需要传递美团核销门店。
         */
        @JsonProperty("opBizCode")
        private String opBizCode;

        /**
         * 创建券码信息列表。必填。的空实例。
         */
        public ReceiptInfoResult() {
        }
    }
}
