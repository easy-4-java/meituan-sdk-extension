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
     * 创建CoCouponInfo，用于订单续租下单等回调的业务字段。的空实例。
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
