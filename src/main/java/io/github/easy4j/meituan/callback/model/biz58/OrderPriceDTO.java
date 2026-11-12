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
     * 创建OrderPriceDTO\uff0c\u7528\u4e8e\u8ba2\u5355\u4fe1\u606f\u63a8\u9001\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public OrderPriceDTO() {
    }


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
