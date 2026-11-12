package io.github.easy4j.meituan.callback.model.biz61;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「RECEIPT_CANCEL_CONSUME」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=61}，消息类型为 {@code msgType=6110011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_outdistribution_1a13b8f7-7690-415b-8b80-41a6b3230c40">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptCancelConsumeMessage {

    /**
     * 唯一Key。
     */
    @JsonProperty("uniqueId")
    private String uniqueId;

    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 撤销的券码信息。
     */
    @JsonProperty("receipts")
    private List<ReceiptDto> receipts;

    /**
     * 撤销的券码信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReceiptDto {

        /**
         * 券Id。
         */
        @JsonProperty("id")
        private Long id;

        /**
         * 撤销时间。
         */
        @JsonProperty("cancelConsumeTime")
        private Long cancelConsumeTime;

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
