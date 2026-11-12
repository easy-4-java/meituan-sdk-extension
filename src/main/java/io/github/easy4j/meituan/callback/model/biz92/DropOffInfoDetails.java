package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * DropOffInfoDetails，用于下单预校验等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DropOffInfoDetails {

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

    /**
     * 创建DropOffInfoDetails，用于下单预校验等回调的业务字段。的空实例。
     */
    public DropOffInfoDetails() {
    }
}
