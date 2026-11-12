package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * PayStatusDetails，用于【供应链】在线交易流水等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayStatusDetails {

    /**
     * 创建PayStatusDetails，用于【供应链】在线交易流水等回调的业务字段。的空实例。
     */
    public PayStatusDetails() {
    }


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
