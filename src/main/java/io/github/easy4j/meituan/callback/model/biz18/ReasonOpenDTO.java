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
     * 创建ReasonOpenDTO\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u91c7\u8d2d\u9000\u8d27\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public ReasonOpenDTO() {
    }


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
