package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * OrderPriceDTO，用于订单信息推送等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPriceDTO {

    /**
     * 订单金额。必填。
     */
    @JsonProperty("orderTotalPrice")
    private String orderTotalPrice;

    /**
     * 订单商家优惠金额。必填。
     */
    @JsonProperty("orderMerchantDiscountPrice")
    private String orderMerchantDiscountPrice;

    /**
     * 订单用户实付金额。必填。
     */
    @JsonProperty("orderActualPayPrice")
    private String orderActualPayPrice;
}
