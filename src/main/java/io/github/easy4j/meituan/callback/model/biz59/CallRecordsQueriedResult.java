package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询通话记录（对账或补偿使用）」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_ee50457f-2740-4256-8dcd-73e95e42c8dc">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallRecordsQueriedResult {

    /**
     * 当前页数。必填。
     */
    @JsonProperty("page")
    private Integer page;

    /**
     * 每页数量。必填。
     */
    @JsonProperty("limit")
    private Integer limit;

    /**
     * 总页数。必填。
     */
    @JsonProperty("pageCount")
    private Integer pageCount;

    /**
     * 总记录数。必填。
     */
    @JsonProperty("totalNumber")
    private String totalNumber;

    /**
     * 通话记录。官网将 records 的字段类型定义为 object&lt;Record&gt;。必填。
     */
    @JsonProperty("records")
    private CallRecord records;

    /**
     * 通话记录。官网将 records 的字段类型定义为 object&lt;Record&gt;。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CallRecord {

        /**
         * 通话的唯一标识，与查询时保持一致。必填。
         */
        @JsonProperty("ext_tel_record_id")
        private String extTelRecordId;

        /**
         * 400号码。必填。
         */
        @JsonProperty("tel")
        private String tel;

        /**
         * 分机号码。
         */
        @JsonProperty("subtel")
        private String subtel;

        /**
         * 主叫区号。必填。
         */
        @JsonProperty("area_code")
        private String areaCode;

        /**
         * 主叫号码。必填。
         */
        @JsonProperty("from_num")
        private String fromNum;

        /**
         * 被叫号码。
         */
        @JsonProperty("dest_num")
        private String destNum;

        /**
         * 开始时间，时间戳，精确到秒。必填。
         */
        @JsonProperty("start_time")
        private Long startTime;

        /**
         * 接听时间，时间戳，精确到秒 接通必传。
         */
        @JsonProperty("answer_time")
        private Long answerTime;

        /**
         * 结束时间，时间戳，精确到秒。必填。
         */
        @JsonProperty("end_time")
        private Long endTime;

        /**
         * 结束原因，支持传的值为0到3，对应含义如下： 0-未知; 1-主通道挂机; 2-非主通道挂机; 3-非正常挂断。必填。
         */
        @JsonProperty("end_reason")
        private Integer endReason;

        /**
         * 通话时长(秒)。
         */
        @JsonProperty("duration")
        private Integer duration;

        /**
         * 通话下载链接。
         */
        @JsonProperty("record_url")
        private String recordUrl;

        /**
         * 错误码。("success": "成功" "noanswer": "未接通" "curlerror": "交互错误，如接口异常、断网、分机号输入错误（输入分机号的动作之后断的）" "nophone":"未查询到坐席" "nosubtel": "未输入分机号" "other_cause": "其他原因" "blocked": "通话被拦截”)。必填。
         */
        @JsonProperty("error_code")
        private String errorCode;

        /**
         * 通话状态未接的补充码，支持传的值为1到8(1-占线 2-无人接听 3-空号 4-关机 5-呼叫受限、用户线故障、暂时无法接通、秘书台 6-停机 7-嘟嘟、静音、未知 8-拒接)。必填。
         */
        @JsonProperty("status_supply")
        private Integer statusSupply;
    }
}
