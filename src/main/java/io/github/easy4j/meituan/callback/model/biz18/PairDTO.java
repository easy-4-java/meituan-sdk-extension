package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * PairDTO，用于【供应链】（预）付款单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PairDTO {

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
     * 创建PairDTO，用于【供应链】（预）付款单消息等回调的业务字段。的空实例。
     */
    public PairDTO() {
    }
}
