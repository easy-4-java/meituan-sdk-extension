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

    /**
     * 创建SupplierOpenDTO，用于【供应链】采购退货单消息等回调的业务字段。的空实例。
     */
    public SupplierOpenDTO() {
    }
}
