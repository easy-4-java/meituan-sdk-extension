package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ReasonOpenDTO，用于【供应链】采购退货单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReasonOpenDTO {

    /**
     * 原因唯一code。
     */
    @JsonProperty("reasonCode")
    private String reasonCode;

    /**
     * 原因名称。
     */
    @JsonProperty("reasonName")
    private String reasonName;
}
