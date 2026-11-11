package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * BaseUnitInfoDetails，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseUnitInfoDetails {

    /**
     * 单位 ID。
     */
    @JsonProperty("id")
    private String id;

    /**
     * 单位编码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 单位名称。
     */
    @JsonProperty("name")
    private String name;
}
