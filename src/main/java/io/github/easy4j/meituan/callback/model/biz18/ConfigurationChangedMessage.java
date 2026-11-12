package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「配置消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18205}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_f95460c6-88ff-4286-8c96-6cdc3a3bf4f8">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigurationChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u914d\u7f6e\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ConfigurationChangedMessage() {
    }


    /**
     * 结算时间。
     */
    @JsonProperty("clearingTime")
    private Integer clearingTime;

    /**
     * 餐段信息。
     */
    @JsonProperty("mealInfos")
    private List<MealInfoTO> mealInfos;

    /**
     * 班次信息。
     */
    @JsonProperty("shiftInfos")
    private List<ShiftInfoTO> shiftInfos;

    /**
     * 营业时间。
     */
    @JsonProperty("openingHours")
    private OpeningHoursTO openingHours;

    /**
     * 餐段信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MealInfoTO {

        /**
         * 创建\u9910\u6bb5\u4fe1\u606f\u3002的空实例。
         */
        public MealInfoTO() {
        }


        /**
         * 餐段编号。必填。
         */
        @JsonProperty("mealNO")
        private Integer mealNO;

        /**
         * 餐段名称。必填。
         */
        @JsonProperty("mealName")
        private String mealName;

        /**
         * 餐段开始时间。必填。
         */
        @JsonProperty("startTime")
        private String startTime;

        /**
         * 餐段结束时间。必填。
         */
        @JsonProperty("endTime")
        private String endTime;
    }

    /**
     * 班次信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShiftInfoTO {

        /**
         * 创建\u73ed\u6b21\u4fe1\u606f\u3002的空实例。
         */
        public ShiftInfoTO() {
        }


        /**
         * 班次编号。必填。
         */
        @JsonProperty("shiftNO")
        private Integer shiftNO;

        /**
         * 班次名称。必填。
         */
        @JsonProperty("shiftName")
        private String shiftName;

        /**
         * 班次开始时间。必填。
         */
        @JsonProperty("startTime")
        private String startTime;

        /**
         * 班次结束时间。必填。
         */
        @JsonProperty("endTime")
        private String endTime;
    }

    /**
     * 营业时间。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OpeningHoursTO {

        /**
         * 创建\u8425\u4e1a\u65f6\u95f4\u3002的空实例。
         */
        public OpeningHoursTO() {
        }


        /**
         * 营业开始时间。必填。
         */
        @JsonProperty("startTime")
        private String startTime;

        /**
         * 营业结束时间。必填。
         */
        @JsonProperty("endTime")
        private String endTime;
    }
}
