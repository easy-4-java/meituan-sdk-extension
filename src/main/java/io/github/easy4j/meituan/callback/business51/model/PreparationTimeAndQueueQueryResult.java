package io.github.easy4j.meituan.callback.business51.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店预计备餐时间和排队信息（必接）」回调的业务响应。
 *
 * <p>业务数据为数组，本类型表示其中一个元素。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_8516072d-d9ba-40dd-bc43-ab46c1276b5d">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreparationTimeAndQueueQueryResult {

    /**
     * 厂商门店id。必填。
     */
    @JsonProperty("app_poi_code")
    private String appPoiCode;

    /**
     * 预计等候最短时间(单位分钟）。必填。
     */
    @JsonProperty("predicatedMinMinutes")
    private Integer predicatedMinMinutes;

    /**
     * 预计等候最长时间(单位分钟）。必填。
     */
    @JsonProperty("predicatedMaxMinutes")
    private Integer predicatedMaxMinutes;

    /**
     * 预计等候杯数。
     */
    @JsonProperty("predicatedCount")
    private Integer predicatedCount;
}
