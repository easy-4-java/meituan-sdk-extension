package io.github.easy4j.meituan.callback.model.biz61;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「RECEIPT_CONSUME」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=61}，消息类型为 {@code msgType=6110009}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_outdistribution_124ce302-bc79-4135-a0ee-3574335c1e3b">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptConsumeMessage {

    /**
     * 创建\u7f8e\u56e2\u300cRECEIPT_CONSUME\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReceiptConsumeMessage() {
    }


    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 唯一 ID。
     */
    @JsonProperty("uniqueId")
    private String uniqueId;

    /**
     * 核销的券码信息。
     */
    @JsonProperty("receipts")
    private List<ReceiptDto> receipts;

    /**
     * 核销的券码信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReceiptDto {

        /**
         * 创建\u6838\u9500\u7684\u5238\u7801\u4fe1\u606f\u3002的空实例。
         */
        public ReceiptDto() {
        }


        /**
         * 券Id。
         */
        @JsonProperty("id")
        private Long id;

        /**
         * 本次核销数量。
         */
        @JsonProperty("usedQuantity")
        private Integer usedQuantity;

        /**
         * 核销时间。
         */
        @JsonProperty("consumeTime")
        private Long consumeTime;

        /**
         * 美团商品Id。
         */
        @JsonProperty("productId")
        private Long productId;

        /**
         * 美团套餐Id。
         */
        @JsonProperty("skuId")
        private Long skuId;
    }
}
