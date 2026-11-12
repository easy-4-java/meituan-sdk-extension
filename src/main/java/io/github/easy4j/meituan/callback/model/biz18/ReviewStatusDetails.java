package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ReviewStatusDetails，用于【供应链】查询外销发货单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewStatusDetails {

    /**
     * 创建ReviewStatusDetails，用于【供应链】查询外销发货单消息等回调的业务字段。的空实例。
     */
    public ReviewStatusDetails() {
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
