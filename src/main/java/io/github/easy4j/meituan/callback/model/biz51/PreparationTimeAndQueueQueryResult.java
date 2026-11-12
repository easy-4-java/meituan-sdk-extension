package io.github.easy4j.meituan.callback.model.biz51;

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
     * 创建\u7f8e\u56e2\u300c\u95e8\u5e97\u9884\u8ba1\u5907\u9910\u65f6\u95f4\u548c\u6392\u961f\u4fe1\u606f\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public PreparationTimeAndQueueQueryResult() {
    }


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
