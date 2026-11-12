package io.github.easy4j.meituan.callback.model.biz61;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「REFUND_PROCESS」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=61}，消息类型为 {@code msgType=6110007}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_outdistribution_dfadd7a1-0eeb-4290-a7f7-782d7c56e262">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundProcessMessage {

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
     * 退款单号。
     */
    @JsonProperty("refundOrderId")
    private Long refundOrderId;
    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private Long orderId;
    /**
     * 退款结果 80 - 退款成功。
     */
    @JsonProperty("refundStatus")
    private Integer refundStatus;
    /**
     * 退款时间戳(毫秒)。
     */
    @JsonProperty("refundApplyTime")
    private Long refundApplyTime;
    /**
     * 退款审核通过时间戳（毫秒）。
     */
    @JsonProperty("refundApproveTime")
    private Long refundApproveTime;
    /**
     * 退款金额(单位 分)。
     */
    @JsonProperty("refundAmount")
    private Long refundAmount;
    /**
     * 退款类型，1：未消费退款 2: 已消费退款 3: 过期已转收入退款。
     */
    @JsonProperty("refundType")
    private Integer refundType;
    /**
     * 退款券信息。
     */
    @JsonProperty("refundDetails")
    private List<RefundDetailDto> refundDetails;

    /**
     * 创建美团「REFUND_PROCESS」回调的业务内容。的空实例。
     */
    public RefundProcessMessage() {
    }

    /**
     * 退款券信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundDetailDto {

        /**
         * 券 ID。
         */
        @JsonProperty("receiptId")
        private Long receiptId;
        /**
         * 本次退款券码数。
         */
        @JsonProperty("refundQuantity")
        private Integer refundQuantity;
        /**
         * 商品Id。
         */
        @JsonProperty("productId")
        private Long productId;
        /**
         * 套餐Id。
         */
        @JsonProperty("skuId")
        private Long skuId;
        /**
         * 退款金额(分)。
         */
        @JsonProperty("refundAmount")
        private Long refundAmount;
        /**
         * 应退金额(分)。
         */
        @JsonProperty("totalAmount")
        private Long totalAmount;

        /**
         * 创建退款券信息。的空实例。
         */
        public RefundDetailDto() {
        }
    }
}
