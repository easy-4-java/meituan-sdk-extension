package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「POS部分退-接单页商家主动退菜退款(部分退)」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810089}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_53f91a3e-8946-4a56-8d36-9c38e3986345">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosPartialRefundMessage {

    /**
     * 第三方订单的唯一标识，与正向交易单的orderNo对应。必填。
     */
    @JsonProperty("orderNo")
    private String orderNo;
    /**
     * 退款金额。必填。
     */
    @JsonProperty("amount")
    private Long amount;
    /**
     * 退款原因。必填。
     */
    @JsonProperty("refundReason")
    private String refundReason;
    /**
     * 退菜列表。必填。
     */
    @JsonProperty("refundDishes")
    private List<RefundDish> refundDishes;

    /**
     * 创建美团「POS部分退-接单页商家主动退菜退款(部分退)」回调的业务内容。的空实例。
     */
    public PosPartialRefundMessage() {
    }

    /**
     * 退菜列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundDish {

        /**
         * 菜品编码，与正向交易单的skuId对应。必填。
         */
        @JsonProperty("skuId")
        private Long skuId;
        /**
         * 退菜数量。必填。
         */
        @JsonProperty("count")
        private Integer count;

        /**
         * 创建退菜列表。的空实例。
         */
        public RefundDish() {
        }
    }
}
