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
     * 创建Requirements\uff0c\u7528\u4e8e\u63a8\u9001\u65b0\u8ba2\u5355\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public Requirements() {
    }


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
}
