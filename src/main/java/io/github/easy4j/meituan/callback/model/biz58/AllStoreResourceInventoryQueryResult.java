package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询全量门店资源库存数据」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_bbe33bf7-e79c-4a6d-8741-869b0b7b2b29">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllStoreResourceInventoryQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u5168\u91cf\u95e8\u5e97\u8d44\u6e90\u5e93\u5b58\u6570\u636e\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public AllStoreResourceInventoryQueryResult() {
    }


    /**
     * 是否还有待查数据：true-有、false-无。必填。
     */
    @JsonProperty("hasNext")
    private Boolean hasNext;

    /**
     * 门店信息列表。必填。
     */
    @JsonProperty("poiInfoBOS")
    private List<PoiInfoBO> poiInfoBOS;

    /**
     * 门店信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiInfoBO {

        /**
         * 创建\u95e8\u5e97\u4fe1\u606f\u5217\u8868\u3002\u5fc5\u586b\u3002的空实例。
         */
        public PoiInfoBO() {
        }


        /**
         * 三方门店id。必填。
         */
        @JsonProperty("thirdPartPoiId")
        private Long thirdPartPoiId;

        /**
         * 美团门店id（混淆）。必填。
         */
        @JsonProperty("opPoiId")
        private String opPoiId;

        /**
         * 当前门店球桌总数。必填。
         */
        @JsonProperty("totalBallTableNum")
        private Integer totalBallTableNum;

        /**
         * 当前门店可用球桌数。必填。
         */
        @JsonProperty("availableBallTableNum")
        private Integer availableBallTableNum;

        /**
         * 球桌信息列表。必填。
         */
        @JsonProperty("ballTableInfoBOS")
        private List<BallTableInfoBO> ballTableInfoBOS;
    }

    /**
     * 球桌信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BallTableInfoBO {

        /**
         * 创建\u7403\u684c\u4fe1\u606f\u5217\u8868\u3002\u5fc5\u586b\u3002的空实例。
         */
        public BallTableInfoBO() {
        }


        /**
         * 球桌id。必填。
         */
        @JsonProperty("id")
        private Long id;

        /**
         * 球桌名称。必填。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 球桌状态：1-空闲、2-占用、3-清理、4-维修。必填。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 秒时间戳。必填。
         */
        @JsonProperty("endTime")
        private Long endTime;

        /**
         * 球桌关联团购。必填。
         */
        @JsonProperty("dealGroupBOS")
        private List<DealGroupBO> dealGroupBOS;
    }

    /**
     * 球桌关联团购。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DealGroupBO {

        /**
         * 创建\u7403\u684c\u5173\u8054\u56e2\u8d2d\u3002\u5fc5\u586b\u3002的空实例。
         */
        public DealGroupBO() {
        }


        /**
         * 团购id（美团侧id）。必填。
         */
        @JsonProperty("dealGroupId")
        private Long dealGroupId;

        /**
         * 团购使用时间。必填。
         */
        @JsonProperty("usableTimeList")
        private List<UsableTime> usableTimeList;

        /**
         * 不可用时间类型：0-全部日期可用、1-部分日期可用。必填。
         */
        @JsonProperty("exceptDateType")
        private Integer exceptDateType;

        /**
         * 自定义不可用日期。
         */
        @JsonProperty("exceptDateList")
        private List<ExceptDate> exceptDateList;

        /**
         * 周不可用时间，1~7对应周一到周日。
         */
        @JsonProperty("exceptWeekdayList")
        private List<Integer> exceptWeekdayList;

        /**
         * 节假日不可用时间：101-元旦、102-春节、103-劳动节，104-端午节、105-国庆节、106-清明节、107-中秋节、201-情人节、202-圣诞节。
         */
        @JsonProperty("exceptHolidayList")
        private List<Integer> exceptHolidayList;
    }

    /**
     * 团购使用时间。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UsableTime {

        /**
         * 创建\u56e2\u8d2d\u4f7f\u7528\u65f6\u95f4\u3002\u5fc5\u586b\u3002的空实例。
         */
        public UsableTime() {
        }


        /**
         * 开始时间，格式：hh:mm。必填。
         */
        @JsonProperty("startTime")
        private String startTime;

        /**
         * 结束时间，格式：hh:mm。必填。
         */
        @JsonProperty("endTime")
        private String endTime;
    }

    /**
     * 自定义不可用日期。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExceptDate {

        /**
         * 创建\u81ea\u5b9a\u4e49\u4e0d\u53ef\u7528\u65e5\u671f\u3002的空实例。
         */
        public ExceptDate() {
        }


        /**
         * 自定义不可用开始日期，格式：yyyy-MM-dd。必填。
         */
        @JsonProperty("from")
        private String from;

        /**
         * 自定义不可用结束日期，格式：yyyy-MM-dd。必填。
         */
        @JsonProperty("to")
        private String to;
    }
}
