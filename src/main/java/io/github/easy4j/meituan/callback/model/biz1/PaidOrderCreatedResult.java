package io.github.easy4j.meituan.callback.model.biz1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「新订单推送（已支付）」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_tuangoung_a598c633-ce85-4889-a688-41d372c40c10">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaidOrderCreatedResult {

    /**
     * 创建美团「新订单推送（已支付）」回调的业务响应。的空实例。
     */
    public PaidOrderCreatedResult() {
    }


    /**
     * 商家订单 ID。
     */
    @JsonProperty("vendorOrderId")
    private String vendorOrderId;

    /**
     * 主订单号。
     */
    @JsonProperty("orderNo")
    private String orderNo;

    /**
     * 子订单 ID，仅存在子订单号情况下使用。
     */
    @JsonProperty("subOrderId")
    private String subOrderId;

    /**
     * 退款单号，仅退款场景下使用。
     */
    @JsonProperty("refundNo")
    private String refundNo;

    /**
     * 订单扩展信息，预留扩展。
     */
    @JsonProperty("vendorOrderExt")
    private Map<String, String> vendorOrderExt;
}
