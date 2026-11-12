package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「到家行业库存查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_391676bf-4d52-4a88-9c9c-a8ccf6a05da5">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeServiceInventoryQueryResult {

    /**
     * 库存详情 注：类型为对象列表类型，详见扩展参数detail。必填。
     */
    @JsonProperty("detail")
    private List<Detail> detail;

    /**
     * 库存详情 注：类型为对象列表类型，详见扩展参数detail。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detail {

        /**
         * 预订时间。必填。
         */
        @JsonProperty("bookdate")
        private String bookdate;

        /**
         * 时间段（1、统一使用24小时制 2、时间段为当天的营业时间，无论是否有库存都需要返回 3、无库存的时间段也需要返回，使用remian_count表示是否有库存） 注：类型为对象列表类型，详见扩展参数period。必填。
         */
        @JsonProperty("period")
        private List<Period> period;
    }

    /**
     * 时间段（1、统一使用24小时制 2、时间段为当天的营业时间，无论是否有库存都需要返回 3、无库存的时间段也需要返回，使用remian_count表示是否有库存） 注：类型为对象列表类型，详见扩展参数period。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Period {

        /**
         * 开始时间段，必须是整点，24小时制，比如“8:00”。必填。
         */
        @JsonProperty("begin")
        private String begin;

        /**
         * 结束时间段，必须是整点，24小时制，比如“9:00”。
         */
        @JsonProperty("end")
        private String end;

        /**
         * 库存剩余量,0-表示无库存 大于0表示有库存，无限库存返回999。必填。
         */
        @JsonProperty("remainCount")
        private Integer remainCount;
    }
}
