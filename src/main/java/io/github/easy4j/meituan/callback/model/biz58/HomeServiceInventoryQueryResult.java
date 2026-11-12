package io.github.easy4j.meituan.callback.model.biz58;

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
     * 创建\u7f8e\u56e2\u300c\u5230\u5bb6\u884c\u4e1a\u5e93\u5b58\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public HomeServiceInventoryQueryResult() {
    }


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
         * 创建\u5e93\u5b58\u8be6\u60c5 \u6ce8\uff1a\u7c7b\u578b\u4e3a\u5bf9\u8c61\u5217\u8868\u7c7b\u578b\uff0c\u8be6\u89c1\u6269\u5c55\u53c2\u6570detail\u3002\u5fc5\u586b\u3002的空实例。
         */
        public Detail() {
        }


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
         * 创建\u65f6\u95f4\u6bb5\uff081\u3001\u7edf\u4e00\u4f7f\u752824\u5c0f\u65f6\u5236 2\u3001\u65f6\u95f4\u6bb5\u4e3a\u5f53\u5929\u7684\u8425\u4e1a\u65f6\u95f4\uff0c\u65e0\u8bba\u662f\u5426\u6709\u5e93\u5b58\u90fd\u9700\u8981\u8fd4\u56de 3\u3001\u65e0\u5e93\u5b58\u7684\u65f6\u95f4\u6bb5\u4e5f\u9700\u8981\u8fd4\u56de\uff0c\u4f7f\u7528remian_count\u8868\u793a\u662f\u5426\u6709\u5e93\u5b58\uff09 \u6ce8\uff1a\u7c7b\u578b\u4e3a\u5bf9\u8c61\u5217\u8868\u7c7b\u578b\uff0c\u8be6\u89c1\u6269\u5c55\u53c2\u6570period\u3002\u5fc5\u586b\u3002的空实例。
         */
        public Period() {
        }


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
