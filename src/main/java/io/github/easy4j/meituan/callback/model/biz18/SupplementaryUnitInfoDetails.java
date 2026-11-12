package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * SupplementaryUnitInfoDetails，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplementaryUnitInfoDetails {

    /**
     * 创建SupplementaryUnitInfoDetails，用于【供应链】组合加工单消息等回调的业务字段。的空实例。
     */
    public SupplementaryUnitInfoDetails() {
    }


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
