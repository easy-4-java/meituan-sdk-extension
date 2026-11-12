package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * PoiComboGroup4CTO，用于店内菜品消息（总部）等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoiComboGroup4CTO {

    /**
     * 类型。
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * sku id列表。
     */
    @JsonProperty("skus")
    private List<Long> skus;
}
