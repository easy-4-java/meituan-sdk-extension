package io.github.easy4j.meituan.callback.model.biz18;

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
     * 创建CustomerOpenDTO\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u67e5\u8be2\u5916\u9500\u8ba2\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public CustomerOpenDTO() {
    }


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
