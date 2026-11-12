package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * BizTypeOpenDTO，用于【供应链】入库单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BizTypeOpenDTO {

    /**
     * 创建BizTypeOpenDTO\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u5165\u5e93\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public BizTypeOpenDTO() {
    }


    /**
     * 业务类型编码。
     */
    @JsonProperty("bizTypeCode")
    private String bizTypeCode;

    /**
     * 业务类型名字。
     */
    @JsonProperty("bizTypeName")
    private String bizTypeName;

    /**
     * 系统内置名称。
     */
    @JsonProperty("systemName")
    private String systemName;

    /**
     * 业务类型状态。
     */
    @JsonProperty("status")
    private PairDTO status;

    /**
     * 单据类型。
     */
    @JsonProperty("ioType")
    private IoTypeDetails ioType;

    /**
     * 原因编码。
     */
    @JsonProperty("reasonCode")
    private String reasonCode;
}
