package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单退款信息推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810173}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_a8ef235b-a621-4de4-b8d4-b0820980ea4f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRefundInfoPushedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8ba2\u5355\u9000\u6b3e\u4fe1\u606f\u63a8\u9001\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderRefundInfoPushedMessage() {
    }


    /**
     * 美团订单号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 1.退款申请 2.退款审核通过 3.退款审核拒绝 4.退款成功 5.退款失败。必填。
     */
    @JsonProperty("messageType")
    private String messageType;

    /**
     * 消息Id，消息的唯一Id，可用作推送消息处理的幂等键。长度为36的字符串示例：1ec33ae7-5248-4262-aa3f-25ad4c5b2639。必填。
     */
    @JsonProperty("messageId")
    private String messageId;

    /**
     * 订单创建时间（毫秒级时间戳。必填。
     */
    @JsonProperty("orderCreateTime")
    private String orderCreateTime;

    /**
     * 退款类型标识：1:首款 2:尾款。必填。
     */
    @JsonProperty("refundType")
    private Integer refundType;

    /**
     * 交易类型（团购普通单：nib.general.groupbuy）。
     */
    @JsonProperty("bizCode")
    private String bizCode;

    /**
     * 退款信息。必填。
     */
    @JsonProperty("refundBaseInfo")
    private RefundBaseInfo refundBaseInfo;

    /**
     * 商品信息(size 为1)。必填。
     */
    @JsonProperty("products")
    private List<Product> products;

    /**
     * 团购普通单相关支付信息。
     */
    @JsonProperty("orderPrice")
    private OrderPriceDTO orderPrice;

    /**
     * 退款信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundBaseInfo {

        /**
         * 创建\u9000\u6b3e\u4fe1\u606f\u3002的空实例。
         */
        public RefundBaseInfo() {
        }


        /**
         * 退款申请 ID。
         */
        @JsonProperty("refundId")
        private String refundId;

        /**
         * 退款人类型（0.系统，1.用户，2.商家，3.客服）。
         */
        @JsonProperty("refundOperatorType")
        private Integer refundOperatorType;

        /**
         * 退款金额。
         */
        @JsonProperty("refundAmount")
        private String refundAmount;

        /**
         * 实退金额。
         */
        @JsonProperty("refundCashAmount")
        private String refundCashAmount;

        /**
         * 退款数量。
         */
        @JsonProperty("refundQuantity")
        private Integer refundQuantity;

        /**
         * 退款原因。
         */
        @JsonProperty("refundReason")
        private String refundReason;

        /**
         * 退款创建时间。
         */
        @JsonProperty("createTime")
        private Long createTime;

        /**
         * 券码 ID 列表。
         */
        @JsonProperty("receiptIdList")
        private List<Long> receiptIdList;

        /**
         * 券码，美团券：10位数字，三方码：字符串 WT120230518673335770。
         */
        @JsonProperty("receiptCodeList")
        private List<String> receiptCodeList;

        /**
         * 0-全部退 1-部分退。
         */
        @JsonProperty("refundFeeType")
        private String refundFeeType;
    }
}
