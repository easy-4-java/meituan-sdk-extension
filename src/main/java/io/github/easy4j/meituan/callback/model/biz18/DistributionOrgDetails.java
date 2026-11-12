package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * DistributionOrgDetails，用于【供应链】返货单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DistributionOrgDetails {

    /**
     * 创建DistributionOrgDetails\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u8fd4\u8d27\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public DistributionOrgDetails() {
    }


    /**
     * 机构 ID。
     */
    @JsonProperty("orgId")
    private Long orgId;

    /**
     * 机构根节点ID,即总部机构 ID。
     */
    @JsonProperty("rootOrgId")
    private Long rootOrgId;

    /**
     * 机构编码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 机构名称。
     */
    @JsonProperty("name")
    private String name;
}
