package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * BelongOrgDetails，用于【供应链】入库单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BelongOrgDetails {

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
