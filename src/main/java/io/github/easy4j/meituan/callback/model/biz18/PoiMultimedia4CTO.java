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
     * 创建PoiMultimedia4CTO\uff0c\u7528\u4e8e\u5e97\u5185\u83dc\u54c1\u6d88\u606f\uff08\u603b\u90e8\uff09\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public PoiMultimedia4CTO() {
    }


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
}
