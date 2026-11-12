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
     * 创建StockInWarehousesInfosItem，用于【供应链】组合加工单消息等回调的业务字段。的空实例。
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
