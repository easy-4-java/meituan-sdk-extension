package io.github.easy4j.meituan.callback.business92.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Driver，用于驾驶员修改等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver {

    /**
     * 姓名。必填。
     */
    @JsonProperty("name")
    private String name;

    /**
     * 证件类型，详情可见证件类型枚举。必填。
     */
    @JsonProperty("idType")
    private String idType;

    /**
     * 证件号码。必填。
     */
    @JsonProperty("idNumber")
    private String idNumber;

    /**
     * 手机号码。必填。
     */
    @JsonProperty("phone")
    private String phone;
}
