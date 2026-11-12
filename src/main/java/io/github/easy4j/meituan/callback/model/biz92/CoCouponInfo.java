package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * CoCouponInfo，用于订单续租下单等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoCouponInfo {

    /**
     * 创建CoCouponInfo\uff0c\u7528\u4e8e\u8ba2\u5355\u7eed\u79df\u4e0b\u5355\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public CoCouponInfo() {
    }


    /**
     * 共补活动code。必填。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 共补描述。
     */
    @JsonProperty("description")
    private String description;

    /**
     * 总共优惠补贴金额。必填。
     */
    @JsonProperty("totalAmount")
    private Integer totalAmount;

    /**
     * 美团承担金额。必填。
     */
    @JsonProperty("mtAmount")
    private Integer mtAmount;

    /**
     * 商家承担金额。必填。
     */
    @JsonProperty("thirdAmount")
    private Integer thirdAmount;
}
