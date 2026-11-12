package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * OpenOppositeOrgDTO，用于【供应链】入库单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenOppositeOrgDTO {

    /**
     * 创建OpenOppositeOrgDTO\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u5165\u5e93\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public OpenOppositeOrgDTO() {
    }


    /**
     * 对方机构类型,1.供应商,2.组织机构,3.外销客户。
     */
    @JsonProperty("type")
    private PairDTO type;

    /**
     * 编码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 名称。
     */
    @JsonProperty("name")
    private String name;
}
