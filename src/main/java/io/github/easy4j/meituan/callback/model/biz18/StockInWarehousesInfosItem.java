package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * StockInWarehousesInfosItem，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockInWarehousesInfosItem {

    /**
     * 创建StockInWarehousesInfosItem\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u7ec4\u5408\u52a0\u5de5\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public StockInWarehousesInfosItem() {
    }


    /**
     * 仓库 ID。
     */
    @JsonProperty("id")
    private String id;

    /**
     * 仓库编码。
     */
    @JsonProperty("code")
    private String code;

    /**
     * 仓库名称。
     */
    @JsonProperty("name")
    private String name;
}
