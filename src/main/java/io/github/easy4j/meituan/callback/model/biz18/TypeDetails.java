package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * TypeDetails，用于【供应链】入库单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeDetails {

    /**
     * id。
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 描述。
     */
    @JsonProperty("name")
    private String name;

    /**
     * 创建TypeDetails，用于【供应链】入库单消息等回调的业务字段。的空实例。
     */
    public TypeDetails() {
    }
}
