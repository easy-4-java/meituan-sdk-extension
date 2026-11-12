package io.github.easy4j.meituan.callback.business87.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开票状态结果查询接口」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_enterprise_9d722132-f26b-40a4-ac3c-210aacf67afa">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceStatusQueryResult {

    /**
     * 开票申请ID。必填。
     */
    @JsonProperty("applyId")
    private String applyId;

    /**
     * 服务商开票受理流水号。
     */
    @JsonProperty("batchNo")
    private String batchNo;

    /**
     * 订单号。
     */
    @JsonProperty("sqtOrderId")
    private String sqtOrderId;

    /**
     * 处理状态： SUCCESS(成功)、FAILED(失败)、PROCESSING(处理中)。必填。
     */
    @JsonProperty("status")
    private String status;

    /**
     * 开票失败原因。
     */
    @JsonProperty("failReason")
    private String failReason;

    /**
     * 发票列表。必填。
     */
    @JsonProperty("invoices")
    private List<Invoice> invoices;

    /**
     * 发票列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Invoice {

        /**
         * 发票ID（发票服务商内部标识发票的唯一键）。必填。
         */
        @JsonProperty("invoiceId")
        private String invoiceId;

        /**
         * 发票代码（数电票无）。
         */
        @JsonProperty("invoiceCode")
        private String invoiceCode;

        /**
         * 发票号码。必填。
         */
        @JsonProperty("invoiceNumber")
        private String invoiceNumber;

        /**
         * 申请类型： issue (开票)、 offset (红冲)。必填。
         */
        @JsonProperty("applyType")
        private String applyType;

        /**
         * 发票类别： normal (普票)、 special (专票)。必填。
         */
        @JsonProperty("invoiceType")
        private String invoiceType;

        /**
         * 校验码（后6位）。
         */
        @JsonProperty("checkCode")
        private String checkCode;

        /**
         * 购方名称。必填。
         */
        @JsonProperty("buyerName")
        private String buyerName;

        /**
         * 购方税号/社会统一信用代码（企业必填）。
         */
        @JsonProperty("buyerTaxId")
        private String buyerTaxId;

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
         * 购方开户银行。
         */
        @JsonProperty("buyerBankName")
        private String buyerBankName;

        /**
         * 购方银行账号。
         */
        @JsonProperty("buyerBankAccount")
        private String buyerBankAccount;

        /**
         * 销方名称。必填。
         */
        @JsonProperty("sellerName")
        private String sellerName;

        /**
         * 销方税号/社会统一信用代码。必填。
         */
        @JsonProperty("sellerTaxId")
        private String sellerTaxId;

        /**
         * 销方地址。
         */
        @JsonProperty("sellerAddress")
        private String sellerAddress;

        /**
         * 销方电话。
         */
        @JsonProperty("sellerPhone")
        private String sellerPhone;

        /**
         * 销方开户银行。
         */
        @JsonProperty("sellerBankName")
        private String sellerBankName;

        /**
         * 销方银行账号。
         */
        @JsonProperty("sellerBankAccount")
        private String sellerBankAccount;

        /**
         * 开票金额（元，两位小数）。必填。
         */
        @JsonProperty("invoiceAmount")
        private String invoiceAmount;

        /**
         * 税额（元，两位小数）。必填。
         */
        @JsonProperty("taxAmount")
        private String taxAmount;

        /**
         * 合计金额（元，两位小数）。必填。
         */
        @JsonProperty("totalAmount")
        private String totalAmount;

        /**
         * 发票描述信息， InvoiceItem。必填。
         */
        @JsonProperty("invoiceItems")
        private List<InvoiceItem> invoiceItems;

        /**
         * 开票日期,yyyy-MM-dd。必填。
         */
        @JsonProperty("invoiceDate")
        private String invoiceDate;

        /**
         * 备注。
         */
        @JsonProperty("remark")
        private String remark;

        /**
         * 原蓝票ID（红冲时不为空）。
         */
        @JsonProperty("originalInvoiceId")
        private String originalInvoiceId;

        /**
         * 原蓝票代码（红冲时不为空）。
         */
        @JsonProperty("originalInvoiceCode")
        private String originalInvoiceCode;

        /**
         * 原蓝票号码（红冲时不为空）。
         */
        @JsonProperty("originalInvoiceNumber")
        private String originalInvoiceNumber;

        /**
         * 发票文件（至少提供PDF、XML和OFD文件）。
         */
        @JsonProperty("fileInfos")
        private List<FileInfo> fileInfos;
    }

    /**
     * 发票描述信息， InvoiceItem。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InvoiceItem {

        /**
         * 项目名称（如：餐饮服务*餐饮费）。必填。
         */
        @JsonProperty("itemName")
        private String itemName;

        /**
         * 规格型号。
         */
        @JsonProperty("specification")
        private String specification;

        /**
         * 单位。
         */
        @JsonProperty("unit")
        private String unit;

        /**
         * 数量。
         */
        @JsonProperty("quantity")
        private Integer quantity;

        /**
         * 单价（元，两位小数）。
         */
        @JsonProperty("unitPrice")
        private String unitPrice;

        /**
         * 金额（数量×单价）（元，两位小数）。必填。
         */
        @JsonProperty("amount")
        private String amount;

        /**
         * 税率/征收率（如：6%）。必填。
         */
        @JsonProperty("taxRate")
        private String taxRate;

        /**
         * 税额（元，两位小数）。必填。
         */
        @JsonProperty("taxAmount")
        private String taxAmount;
    }

    /**
     * 发票文件（至少提供PDF、XML和OFD文件）。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FileInfo {

        /**
         * 文件类型：PDF、XML、OFD、JPG、PNG等。必填。
         */
        @JsonProperty("fileType")
        private String fileType;

        /**
         * 下载地址。必填。
         */
        @JsonProperty("fileUrl")
        private String fileUrl;

        /**
         * 备注。
         */
        @JsonProperty("remark")
        private String remark;
    }
}
