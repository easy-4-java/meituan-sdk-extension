package io.github.easy4j.meituan.callback.model.biz86;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「美团企业开票申请」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=86}，消息类型为 {@code msgType=8610002}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_solution2_c248a615-a5ef-4086-a842-220da8a15f2f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CorporateInvoiceApplicationMessage {

    /**
     * 美团门店 ID。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 开票的订单列表，外卖订单中的orderViewId，最大20个。必填。
     */
    @JsonProperty("orderList")
    private InvoiceApplyOrderOuterDTO orderList;

    /**
     * 开票总金额（美团侧计算出来的开票金额）。
     */
    @JsonProperty("totalAmount")
    private String totalAmount;

    /**
     * 是否大类开票，1大类开票，0或null为明细开票。
     */
    @JsonProperty("invoiceCategory")
    private Integer invoiceCategory;

    /**
     * serialNo申请序列号不能为空。必填。
     */
    @JsonProperty("serialNo")
    private String serialNo;

    /**
     * originSerialNo原蓝票申请流水号不能为空。必填。
     */
    @JsonProperty("originSerialNo")
    private String originSerialNo;

    /**
     * 申请来源，没有传空。
     */
    @JsonProperty("applySource")
    private String applySource;

    /**
     * 开票类型，普通发票：82；专用发票：81。
     */
    @JsonProperty("invoiceKind")
    private Integer invoiceKind;

    /**
     * 外部申请号。三方回传蓝票结果时，将此字段回传到发票平台，红冲时发票平台设置。
     */
    @JsonProperty("outerInvoiceId")
    private String outerInvoiceId;

    /**
     * 发票抬头，具体字段见下面描述。必填。
     */
    @JsonProperty("invoiceTitle")
    private InvoiceTitleDetails invoiceTitle;

    /**
     * 开票的订单列表，外卖订单中的orderViewId，最大20个。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InvoiceApplyOrderOuterDTO {

        /**
         * 订单 ID。必填。
         */
        @JsonProperty("orderId")
        private String orderId;

        /**
         * 订单下单时间，如2026-03-26 12:00:00，团购订单为空。必填。
         */
        @JsonProperty("orderTime")
        private String orderTime;

        /**
         * 订单类型：010110团购（套餐+代金券）、010140银联企业支付、010180一键（用券）买单、010190微信企业支付、010020秒提。必填。
         */
        @JsonProperty("orderType")
        private String orderType;

        /**
         * 团购码信息。
         */
        @JsonProperty("codeList")
        private List<CodeListObject> codeList;

        /**
         * 扩展JSON字符串。
         */
        @JsonProperty("bizExtData")
        private String bizExtData;

        /**
         * 团购码信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CodeListObject {

            /**
             * 团购码,仅团购必填。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 码核销时间，如2026-03-26 12:00:00。
             */
            @JsonProperty("codeUseTime")
            private String codeUseTime;
        }
    }

    /**
     * 发票抬头，具体字段见下面描述。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InvoiceTitleDetails {

        /**
         * 抬头类型，企业抬头：1，个人抬头：2。必填。
         */
        @JsonProperty("type")
        private Integer type;

        /**
         * 购方名称（抬头）。必填。
         */
        @JsonProperty("buyerName")
        private String buyerName;

        /**
         * 购方纳税人识别号。
         */
        @JsonProperty("buyerTaxNo")
        private String buyerTaxNo;

        /**
         * 购方地址。
         */
        @JsonProperty("buyerAddress")
        private String buyerAddress;

        /**
         * 购方电话。
         */
        @JsonProperty("buyerPhone")
        private String buyerPhone;

        /**
         * 购方开户行。
         */
        @JsonProperty("buyerBank")
        private String buyerBank;

        /**
         * 购方银行账号。
         */
        @JsonProperty("buyerBankAccount")
        private String buyerBankAccount;
    }
}
