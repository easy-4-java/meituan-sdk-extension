package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Address，用于报价列表查询等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    /**
     * 创建Address，用于报价列表查询等回调的业务字段。的空实例。
     */
    public Address() {
    }


    /**
     * 纬度（GCJ-02 坐标系）。必填。
     */
    @JsonProperty("latitude")
    private String latitude;

    /**
     * 经度（GCJ-02 坐标系）。必填。
     */
    @JsonProperty("longitude")
    private String longitude;

    /**
     * 地址。必填。
     */
    @JsonProperty("locationName")
    private String locationName;

    /**
     * 城市编码。必填。
     */
    @JsonProperty("cityCode")
    private String cityCode;
}
