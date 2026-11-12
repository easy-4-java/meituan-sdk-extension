package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收催单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210021}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_6bc9fde7-81a7-4b15-a152-fc92e439f310">官网消息文档</a>
 */
@CallbackPayload("")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderReminderMessage {

    /**
     * 开发者 ID。
     */
    @JsonProperty("developerId")
    private Integer developerId;

    /**
     * 门店。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 数字签名。
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 催单详情。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("pushOrderRemind")
    private PushOrderRemind pushOrderRemind;

    /**
     * 催单详情。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PushOrderRemind {

        /**
         * 订单 ID。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 订单状态。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 订单配送方式code。
         */
        @JsonProperty("logisticsCode")
        private String logisticsCode;

        /**
         * 订单配送状态。
         */
        @JsonProperty("logisticsStatus")
        private Integer logisticsStatus;

        /**
         * 催单 ID。
         */
        @JsonProperty("remindId")
        private Long remindId;

        /**
         * 催单时间，如用户多次催单，则推送多个催单时间。
         */
        @JsonProperty("remindTime")
        private String remindTime;
    }
}
