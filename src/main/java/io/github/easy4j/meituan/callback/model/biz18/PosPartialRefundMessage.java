package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
     * 创建\u7f8e\u56e2\u300cPOS\u90e8\u5206\u9000-\u63a5\u5355\u9875\u5546\u5bb6\u4e3b\u52a8\u9000\u83dc\u9000\u6b3e(\u90e8\u5206\u9000)\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PosPartialRefundMessage() {
    }


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
     * 退菜列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundDish {

        /**
         * 创建\u9000\u83dc\u5217\u8868\u3002的空实例。
         */
        public RefundDish() {
        }


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
    }
}
