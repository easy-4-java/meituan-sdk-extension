package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * RentalInfo，用于下单预校验等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalInfo {

    /**
     * 创建RentalInfo\uff0c\u7528\u4e8e\u4e0b\u5355\u9884\u6821\u9a8c\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public RentalInfo() {
    }


    /**
     * 商家门店code。必填。
     */
    @JsonProperty("thirdStoreCode")
    private String thirdStoreCode;

    /**
     * 地址信息。必填。
     */
    @JsonProperty("address")
    private Address address;

    /**
     * 取还时间。必填。
     */
    @JsonProperty("time")
    private String time;

    /**
     * 取还方式，详情见取还方式枚举PickupDropoffType。必填。
     */
    @JsonProperty("type")
    private String type;
}
