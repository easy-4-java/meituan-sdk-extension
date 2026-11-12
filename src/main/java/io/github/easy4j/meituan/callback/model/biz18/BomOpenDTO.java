package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * BomOpenDTO，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BomOpenDTO {

    /**
     * BOM编码。
     */
    @JsonProperty("bomCode")
    private String bomCode;

    /**
     * BOM名称。
     */
    @JsonProperty("bomName")
    private String bomName;

    /**
     * BOM来源。
     */
    @JsonProperty("createType")
    private Integer createType;

    /**
     * 是否默认BOM。
     */
    @JsonProperty("defaultBom")
    private Integer defaultBom;

    /**
     * 主副产品成本分摊规则。
     */
    @JsonProperty("costApportionType")
    private Integer costApportionType;

    /**
     * 创建时间。
     */
    @JsonProperty("createdTime")
    private Long createdTime;

    /**
     * 备注。
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * bomId。
     */
    @JsonProperty("id")
    private String id;
}
