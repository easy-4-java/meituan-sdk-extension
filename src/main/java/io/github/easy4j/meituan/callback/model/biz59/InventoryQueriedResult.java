package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 美团「查询库存」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_b0a7f77b-2480-431d-9bf2-0d1321e6d993">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryQueriedResult {

    /**
     * 库存主体。必填。
     */
    @JsonProperty("stockSubject")
    private StockSubject stockSubject;
    /**
     * 库存实例。必填。
     */
    @JsonProperty("stock")
    private Stock stock;

    /**
     * 创建美团「查询库存」回调的业务响应。的空实例。
     */
    public InventoryQueriedResult() {
    }

    /**
     * 库存主体。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StockSubject {

        /**
         * 库存主体类型。库存主体类型： 1.美团门店（key：大众点评门店ID） 2.团购（key：deal_group） 3.标品（key：spu）。必填。
         */
        @JsonProperty("stockSubjectType")
        private Integer stockSubjectType;
        /**
         * 库存主体Map。库存主体Map 注：类型为对象类型，详见扩展参数stock_subject_map 示例 开放平台门店id： eg:key： op_poi_id ,value：123456 团购id： eg:key：deal_group,value：123456 标品id： eg:key：spu,value：123456。必填。
         */
        @JsonProperty("stockSubjectMap")
        private Map<String, Object> stockSubjectMap;

        /**
         * 创建库存主体。必填。的空实例。
         */
        public StockSubject() {
        }
    }

    /**
     * 库存实例。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Stock {

        /**
         * 库存模式。库存模式： 1.标准库存 2.区间库存 3.日库存 4.日时段库存（体检业务： 3.日库存 丽人业务： 4.日时段库存）。必填。
         */
        @JsonProperty("stockMode")
        private Integer stockMode;
        /**
         * 标准库存。
         */
        @JsonProperty("standardStock")
        private StandardStock standardStock;
        /**
         * 区间库存。
         */
        @JsonProperty("periodStocks")
        private List<PeriodStocks> periodStocks;
        /**
         * 日期库存。
         */
        @JsonProperty("dailyStocks")
        private List<DailyStocks> dailyStocks;
        /**
         * 日时段库存。
         */
        @JsonProperty("dailyTimeStocks")
        private List<DailyTimeStocks> dailyTimeStocks;

        /**
         * 创建库存实例。必填。的空实例。
         */
        public Stock() {
        }
    }

    /**
     * 标准库存。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StandardStock {

        /**
         * 库存单元。必填。
         */
        @JsonProperty("stockUnit")
        private StockUnit stockUnit;


        /**
         * 创建标准库存。的空实例。
         */
        public StandardStock() {
        }
    }

    /**
     * 区间库存。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PeriodStocks {

        /**
         * 库存单元。必填。
         */
        @JsonProperty("stockUnit")
        private StockUnit stockUnit;
        /**
         * 日期时间范围。必填。
         */
        @JsonProperty("dateTimeRange")
        private DateTimeRange dateTimeRange;
        /**
         * 日期范围的开始时间。必填。
         */
        @JsonProperty("startDateTime")
        private Long startDateTime;
        /**
         * 日期范围的结束时间。必填。
         */
        @JsonProperty("endDateTime")
        private String endDateTime;

        /**
         * 创建区间库存。的空实例。
         */
        public PeriodStocks() {
        }
    }

    /**
     * 日期库存。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DailyStocks {

        /**
         * 库存单元。必填。
         */
        @JsonProperty("stockUnit")
        private StockUnit stockUnit;
        /**
         * 日期。日期，例如：2023-05-01。必填。
         */
        @JsonProperty("date")
        private String date;

        /**
         * 创建日期库存。的空实例。
         */
        public DailyStocks() {
        }
    }

    /**
     * 日时段库存。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DailyTimeStocks {

        /**
         * 库存单元。必填。
         */
        @JsonProperty("stockUnit")
        private StockUnit stockUnit;
        /**
         * 日期。日期（日维度），例如：2023-05-01。必填。
         */
        @JsonProperty("date")
        private String date;
        /**
         * 时间范围。必填。
         */
        @JsonProperty("timeRange")
        private TimeRange timeRange;

        /**
         * 创建日时段库存。的空实例。
         */
        public DailyTimeStocks() {
        }
    }

    /**
     * 库存单元。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StockUnit {

        /**
         * 计划总量。必填。
         */
        @JsonProperty("planTotal")
        private Integer planTotal;
        /**
         * 实际总量。必填。
         */
        @JsonProperty("total")
        private Integer total;
        /**
         * 剩余量。必填。
         */
        @JsonProperty("remain")
        private Integer remain;
        /**
         * 占用量。必填。
         */
        @JsonProperty("hold")
        private Integer hold;
        /**
         * 售卖量。必填。
         */
        @JsonProperty("sold")
        private Integer sold;
        /**
         * 是否为有限库存。必填。
         */
        @JsonProperty("limited")
        private Boolean limited;
        /**
         * 可用量。必填。
         */
        @JsonProperty("available")
        private Integer available;
        /**
         * 库存不可用原因。必填。
         */
        @JsonProperty("unavailableReason")
        private List<String> unavailableReason;

        /**
         * 创建库存单元。必填。的空实例。
         */
        public StockUnit() {
        }
    }

    /**
     * 日期时间范围。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DateTimeRange {

        /**
         * 开始日期时间。开始日期时间，例如2023-05-01 08:00:00。必填。
         */
        @JsonProperty("startDateTime")
        private String startDateTime;
        /**
         * 结束日期时间。结束日期时间，例如2023-05-01 09:00:00。必填。
         */
        @JsonProperty("endDateTime")
        private String endDateTime;

        /**
         * 创建日期时间范围。必填。的空实例。
         */
        public DateTimeRange() {
        }
    }

    /**
     * 时间范围。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TimeRange {

        /**
         * 开始时间。开始时间，例如08:00:00。必填。
         */
        @JsonProperty("startTime")
        private String startTime;
        /**
         * 结束时间。结束时间，例如09:00:00。必填。
         */
        @JsonProperty("endTime")
        private String endTime;
        /**
         * 是否跨天。是否跨天，true-跨天，false-不跨天。必填。
         */
        @JsonProperty("nextDay")
        private Boolean nextDay;

        /**
         * 创建时间范围。必填。的空实例。
         */
        public TimeRange() {
        }
    }
}
