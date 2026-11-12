package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「商家券发券」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910031}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_59ffc833-1474-4f06-964f-42c5fd1b5647">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponIssueMessage {

    /**
     * 创建美团「商家券发券」回调的业务内容。的空实例。
     */
    public MerchantCouponIssueMessage() {
    }


    /**
     * 三方团单 ID。必填。
     */
    @JsonProperty("appDealId")
    private String appDealId;

    /**
     * 订单号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 发券数量。必填。
     */
    @JsonProperty("issueCount")
    private Integer issueCount;

    /**
     * 订单金额。必填。
     */
    @JsonProperty("paidAmount")
    private String paidAmount;

    /**
     * 用户实付。必填。
     */
    @JsonProperty("userPaidAmount")
    private String userPaidAmount;

    /**
     * 商家优惠。
     */
    @JsonProperty("merchantDiscountAmount")
    private String merchantDiscountAmount;

    /**
     * 平台优惠。
     */
    @JsonProperty("platformDiscountAmount")
    private String platformDiscountAmount;

    /**
     * 冗余字段。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("extraMap")
    private ExtraMapDetails extraMap;

    /**
     * 商户编码。必填。
     */
    @JsonProperty("merchantCode")
    private String merchantCode;

    /**
     * 美团下单门店 ID。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 商品类型（0:团购、1:次卡）。
     */
    @JsonProperty("productType")
    private Integer productType;

    /**
     * int 次卡价格类型（0:阶梯次卡、1:非阶梯次卡）。
     */
    @JsonProperty("punchCardPriceType")
    private Integer punchCardPriceType;

    /**
     * 券码金额明细列表。
     */
    @JsonProperty("receiptAmountList")
    private List<ReceiptAmountInfoDTO> receiptAmountList;

    /**
     * 购买份数。
     */
    @JsonProperty("buyNum")
    private Integer buyNum;

    /**
     * 冗余字段。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtraMapDetails {

        /**
         * 创建冗余字段。的空实例。
         */
        public ExtraMapDetails() {
        }


        /**
         * 加项信息。
         */
        @JsonProperty("additionItemInfos")
        private List<AdditionItemInfosItem> additionItemInfos;

        /**
         * 加项信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdditionItemInfosItem {

            /**
             * 创建加项信息。的空实例。
             */
            public AdditionItemInfosItem() {
            }


            /**
             * 服务名。
             */
            @JsonProperty("serviceTitle")
            private String serviceTitle;

            /**
             * 调价规则当前金额(当前金额，单位：元)。
             */
            @JsonProperty("adjustedAmount")
            private String adjustedAmount;

            /**
             * 加项商品 ID。
             */
            @JsonProperty("productId")
            private String productId;

            /**
             * 三方加项商品 ID。
             */
            @JsonProperty("addItemThirdPartyId")
            private String addItemThirdPartyId;
        }
    }

    /**
     * 券码金额明细列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReceiptAmountInfoDTO {

        /**
         * 创建券码金额明细列表。的空实例。
         */
        public ReceiptAmountInfoDTO() {
        }


        /**
         * 券码金额。
         */
        @JsonProperty("amount")
        private Long amount;

        /**
         * 券码顺序。
         */
        @JsonProperty("sequenceNo")
        private Integer sequenceNo;
    }
}
