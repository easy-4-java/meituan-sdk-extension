package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * CategoryOpenDTO，用于【供应链】入库单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryOpenDTO {

    /**
     * 分类编码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 分类名称。
     */
    @JsonProperty("name")
    private String name;

    /**
     * 分类 ID。
     */
    @JsonProperty("id")
    private String id;
}
