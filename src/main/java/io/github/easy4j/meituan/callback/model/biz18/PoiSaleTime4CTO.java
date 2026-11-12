package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * PoiSaleTime4CTO，用于店内菜品消息（总部）等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoiSaleTime4CTO {

    /**
     * 开始日期。
     */
    @JsonProperty("saleBeginDate")
    private Long saleBeginDate;

    /**
     * 结束日期。
     */
    @JsonProperty("saleEndDate")
    private Long saleEndDate;

    /**
     * 开始时间。
     */
    @JsonProperty("saleBeginTime")
    private String saleBeginTime;

    /**
     * 结束时间。
     */
    @JsonProperty("saleEndTime")
    private String saleEndTime;

    /**
     * 星期。
     */
    @JsonProperty("saleWeek")
    private String saleWeek;
}
