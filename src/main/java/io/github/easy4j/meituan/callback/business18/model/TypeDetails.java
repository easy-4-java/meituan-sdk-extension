package io.github.easy4j.meituan.callback.business18.model;

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
}
