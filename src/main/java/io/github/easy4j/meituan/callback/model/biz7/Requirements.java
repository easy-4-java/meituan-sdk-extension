package io.github.easy4j.meituan.callback.model.biz7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Requirements，用于推送新订单等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Requirements {

    /**
     * 桌型，0-大厅 1-包间 3-自定义。
     */
    @JsonProperty("tableType")
    private Integer tableType;
    /**
     * 桌型名称。
     */
    @JsonProperty("tableTypeName")
    private String tableTypeName;
    /**
     * 备注。
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * 创建Requirements，用于推送新订单等回调的业务字段。的空实例。
     */
    public Requirements() {
    }
}
