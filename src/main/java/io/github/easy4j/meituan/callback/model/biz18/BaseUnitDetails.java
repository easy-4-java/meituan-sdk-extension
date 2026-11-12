package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * BaseUnitDetails，用于【供应链】采购订单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseUnitDetails {

    /**
     * 创建BaseUnitDetails\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u91c7\u8d2d\u8ba2\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public BaseUnitDetails() {
    }


    /**
     * 单位 ID。
     */
    @JsonProperty("id")
    private String id;

    /**
     * 单位名称。
     */
    @JsonProperty("name")
    private String name;
}
