package io.github.easy4j.meituan.callback.business3.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收订单推送接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=3}，消息类型为 {@code msgType=310001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_shanhuing_164350be-4000-43c9-ac87-892c907749c3">官网消息文档</a>
 */
@CallbackPayload("params")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOrderMessage {

    /**
     * 用户支付信息。
     */
    @JsonProperty("amountInfo")
    private AmountInfo amountInfo;

    /**
     * 业务描述。
     */
    @JsonProperty("business")
    private String business;

    /**
     * 是否可退款。
     */
    @JsonProperty("canRefund")
    private Boolean canRefund;

    /**
     * 点评订单编号。
     */
    @JsonProperty("dpOrderCode")
    private String dpOrderCode;

    /**
     * 订单状态。
     */
    @JsonProperty("orderStatus")
    private Long orderStatus;

    /**
     * 流水号。
     */
    @JsonProperty("serialNumber")
    private String serialNumber;

    /**
     * 开发者门店 ID。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 商家订单 ID。
     */
    @JsonProperty("vendorOrderId")
    private String vendorOrderId;

    /**
     * 用户支付信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AmountInfo {

        /**
         * 用户实际支付金额。
         */
        @JsonProperty("actualPay")
        private BigDecimal actualPay;

        /**
         * 平台优惠减免金额。
         */
        @JsonProperty("dpTotalPay")
        private BigDecimal dpTotalPay;

        /**
         * 原价。
         */
        @JsonProperty("originPrice")
        private Double originPrice;

        /**
         * 总金额。
         */
        @JsonProperty("total")
        private BigDecimal total;
    }
}
