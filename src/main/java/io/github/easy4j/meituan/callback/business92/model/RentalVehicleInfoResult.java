package io.github.easy4j.meituan.callback.business92.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务数据（VehicleInfo）。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalVehicleInfoResult {

    /**
     * 三方车型id。必填。
     */
    @JsonProperty("thirdCarModelId")
    private String thirdCarModelId;

    /**
     * 车龄，详情见 CarAge 枚举。
     */
    @JsonProperty("carAge")
    private String carAge;

    /**
     * 牌照类型，详情见车牌枚举 LicenseType .。必填。
     */
    @JsonProperty("licenseType")
    private String licenseType;

    /**
     * 车辆配置，详情见车辆配置枚举 CarDevice。必填。
     */
    @JsonProperty("devices")
    private List<String> devices;

    /**
     * 特色标签，详情见枚举 VehicleTag。
     */
    @JsonProperty("specialTags")
    private List<String> specialTags;
}
