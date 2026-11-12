package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * OpenOppositeOrgDTO，用于【供应链】入库单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenOppositeOrgDTO {

    /**
     * 对方机构类型,1.供应商,2.组织机构,3.外销客户。
     */
    @JsonProperty("type")
    private PairDTO type;
    /**
     * 编码。
     */
    @JsonProperty("code")
    private String code;
    /**
     * 名称。
     */
    @JsonProperty("name")
    private String name;

    /**
     * 创建OpenOppositeOrgDTO，用于【供应链】入库单消息等回调的业务字段。的空实例。
     */
    public OpenOppositeOrgDTO() {
    }
}
