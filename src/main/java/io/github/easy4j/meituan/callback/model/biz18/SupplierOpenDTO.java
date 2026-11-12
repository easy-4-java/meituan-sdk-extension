package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * SupplierOpenDTO，用于【供应链】采购退货单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierOpenDTO {

    /**
     * 创建SupplierOpenDTO\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u91c7\u8d2d\u9000\u8d27\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public SupplierOpenDTO() {
    }


    /**
     * 供应商 ID。
     */
    @JsonProperty("id")
    private String id;

    /**
     * 供应商编码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 供应商名称。
     */
    @JsonProperty("name")
    private String name;
}
