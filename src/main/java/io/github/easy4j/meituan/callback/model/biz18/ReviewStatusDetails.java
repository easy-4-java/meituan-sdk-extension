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
     * 创建ReviewStatusDetails\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u67e5\u8be2\u5916\u9500\u53d1\u8d27\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
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
