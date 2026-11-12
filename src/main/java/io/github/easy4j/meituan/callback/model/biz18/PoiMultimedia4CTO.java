package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * PoiMultimedia4CTO，用于店内菜品消息（总部）等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoiMultimedia4CTO {

    /**
     * 文件url。
     */
    @JsonProperty("url")
    private String url;
    /**
     * 删除标记。
     */
    @JsonProperty("deleted")
    private Integer deleted;

    /**
     * 创建PoiMultimedia4CTO，用于店内菜品消息（总部）等回调的业务字段。的空实例。
     */
    public PoiMultimedia4CTO() {
    }
}
