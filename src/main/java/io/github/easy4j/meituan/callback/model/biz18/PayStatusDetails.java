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
     * 创建PayStatusDetails\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u5728\u7ebf\u4ea4\u6613\u6d41\u6c34\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
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
