package io.github.easy4j.meituan.callback.model.biz61;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「PAY_PROCESS」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=61}，消息类型为 {@code msgType=6110005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_outdistribution_812cf73c-7727-4540-8ee6-f9e2f5f68023">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayProcessMessage {

    /**
     * 唯一Key。
     */
    @JsonProperty("uniqueId")
    private String uniqueId;

    /**
     * 渠道编码。
     */
    @JsonProperty("channelId")
    private Integer channelId;

    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 支付时间(ms)。
     */
    @JsonProperty("payTime")
    private Long payTime;

    /**
     * 20：支付处理失败 30：支付处理成功。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 拓展信息。
     */
    @JsonProperty("orderExtend")
    private OrderExtendDTO orderExtend;

    /**
     * 支付金额(分)。
     */
    @JsonProperty("payAmount")
    private Long payAmount;

    /**
     * 卷详情。
     */
    @JsonProperty("receiptDetail")
    private ReceiptDetailDto receiptDetail;

    /**
     * 卷详情。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReceiptDetailDto {

        /**
         * 券码类型 1：1码1验 2：1码多验 3：无需券码。
         */
        @JsonProperty("receiptType")
        private Integer receiptType;

        /**
         * 券码信息。
         */
        @JsonProperty("receipts")
        private ReceiptDto receipts;

        /**
         * 券码信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ReceiptDto {

            /**
             * 券 ID。
             */
            @JsonProperty("id")
            private Long id;

            /**
             * 总数。
             */
            @JsonProperty("totalQuantity")
            private Integer totalQuantity;

            /**
             * 实付金额(分)。
             */
            @JsonProperty("payAmount")
            private Long payAmount;

            /**
             * 应付金额(分)。
             */
            @JsonProperty("totalAmount")
            private Long totalAmount;
        }
    }
}
