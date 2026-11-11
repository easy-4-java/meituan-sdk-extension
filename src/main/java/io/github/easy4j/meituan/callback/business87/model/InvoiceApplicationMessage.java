package io.github.easy4j.meituan.callback.business87.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开票申请接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=87}，消息类型为 {@code msgType=8710001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_enterprise_6d838670-fab5-4342-a861-8cc433a82095">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceApplicationMessage {

    /**
     * 开票申请 ID。必填。
     */
    @JsonProperty("applyId")
    private String applyId;

    /**
     * 申请类型。必填。
     */
    @JsonProperty("applyType")
    private String applyType;

    /**
     * 企业订单号。
     */
    @JsonProperty("sqtOrderId")
    private String sqtOrderId;

    /**
     * 商家门店唯一键。必填。
     */
    @JsonProperty("shopUniqueKey")
    private String shopUniqueKey;

    /**
     * 门店类型， 0到餐，1外卖。必填。
     */
    @JsonProperty("bizType")
    private Integer bizType;

    /**
     * 发票类别。必填。
     */
    @JsonProperty("invoiceType")
    private String invoiceType;

    /**
     * 开票金额（元，两位小数）。必填。
     */
    @JsonProperty("invoiceAmount")
    private String invoiceAmount;

    /**
     * 回调地址。必填。
     */
    @JsonProperty("callbackUrl")
    private String callbackUrl;

    /**
     * 购买方信息。
     */
    @JsonProperty("buyerInfo")
    private BuyerInfo buyerInfo;

    /**
     * 红字发票信息。
     */
    @JsonProperty("redInvoiceInfo")
    private RedInvoiceInfo redInvoiceInfo;

    /**
     * 拓展字段，json格式。
     */
    @JsonProperty("ext")
    private String ext;

    /**
     * buyerInfo。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BuyerInfo {

        /**
         * 发票抬头类型，个人：0 企业：1。必填。
         */
        @JsonProperty("type")
        private Integer type;

        /**
         * 购方名称。必填。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 购方税号/社会统一信用代码；企业情况下必填。
         */
        @JsonProperty("taxId")
        private String taxId;

        /**
         * 购方地址。
         */
        @JsonProperty("address")
        private String address;

        /**
         * 购方电话。
         */
        @JsonProperty("phone")
        private String phone;

        /**
         * 购方开户银行。
         */
        @JsonProperty("bankName")
        private String bankName;

        /**
         * 购方银行账号。
         */
        @JsonProperty("bankAccount")
        private String bankAccount;
    }

    /**
     * redInvoiceInfo。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RedInvoiceInfo {

        /**
         * 原蓝票 ID。必填。
         */
        @JsonProperty("originalInvoiceId")
        private String originalInvoiceId;

        /**
         * 原蓝票代码。
         */
        @JsonProperty("originalInvoiceCode")
        private String originalInvoiceCode;

        /**
         * 原蓝票号码。必填。
         */
        @JsonProperty("originalInvoiceNumber")
        private String originalInvoiceNumber;

        /**
         * 销方税号。必填。
         */
        @JsonProperty("originalSellerTaxId")
        private String originalSellerTaxId;

        /**
         * 冲红原因1-销货退回, 2-开票有误, 3-服务中止, 4-发生销售折让。必填。
         */
        @JsonProperty("redReasonCode")
        private Integer redReasonCode;
    }
}
