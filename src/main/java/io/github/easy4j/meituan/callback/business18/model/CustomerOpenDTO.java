package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * CustomerOpenDTO，用于【供应链】查询外销订单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerOpenDTO {

    /**
     * 客户 ID。
     */
    @JsonProperty("id")
    private String id;

    /**
     * 客户编码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 客户名称。
     */
    @JsonProperty("name")
    private String name;
}
