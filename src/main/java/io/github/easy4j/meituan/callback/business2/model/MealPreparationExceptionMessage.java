package io.github.easy4j.meituan.callback.business2.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收出餐异常消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=2102}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_7d1fbbc6-cd1b-419a-864c-08df18195c0f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealPreparationExceptionMessage {

    /**
     * 订单展示号（配置短订单号的为订单号）。
     */
    @JsonProperty("order_id")
    private Long orderId;

    /**
     * 消息类型: 1 出餐异常; 2 申诉状态变更。
     */
    @JsonProperty("biz_type")
    private Integer bizType;

    /**
     * 不同的biz_type格式不一样。
     */
    @JsonProperty("biz_data")
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    private BizData bizData;

    /**
     * 不同的biz_type格式不一样。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BizData {

        /**
         * 提示文案。
         */
        @JsonProperty("msg")
        private String msg;

        /**
         * 时间。秒级时间戳。
         */
        @JsonProperty("report_time")
        private Long reportTime;

        /**
         * 申诉提交材料要求说明。
         */
        @JsonProperty("appeal_data")
        private String appealData;

        /**
         * 0-不可申诉（商家超时未出餐不可申诉）；1-可以申诉。
         */
        @JsonProperty("appeal_enable")
        private Integer appealEnable;

        /**
         * 1-骑手上报；2-商家超时未出餐。
         */
        @JsonProperty("type")
        private Integer type;

        /**
         * 1-审核中；2-审核通过；3-审核未通过；
         */
        @JsonProperty("result")
        private String result;

        /**
         * 审核时间 (秒级时间戳)。
         */
        @JsonProperty("review_time")
        private String reviewTime;
    }
}
