package io.github.easy4j.meituan.callback.model.biz94;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「车辆异常推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=94}，消息类型为 {@code msgType=9410002}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_keebot_d02a2f66-30a7-4bf4-a69e-cf56c88612bd">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleExceptionMessage {

    /**
     * 车辆vin码。必填。
     */
    @JsonProperty("vin")
    private String vin;

    /**
     * 异常告警事件 ID，目前可能为空。
     */
    @JsonProperty("alertEventId")
    private String alertEventId;

    /**
     * 异常告警类型：ACCIDENT、FAULT、RESCUE、MAINTENANCE。必填。
     */
    @JsonProperty("alertType")
    private String alertType;

    /**
     * 异常告警事件状态，1异常发生；2异常恢复。必填。
     */
    @JsonProperty("alertStatus")
    private Integer alertStatus;

    /**
     * 异常告警详细描述。必填。
     */
    @JsonProperty("message")
    private String message;

    /**
     * 异常事件发生/恢复的毫秒时间戳。必填。
     */
    @JsonProperty("timestamp")
    private Long timestamp;

    /**
     * 其他附加信息，JSON字符串格式。
     */
    @JsonProperty("extendInfo")
    private String extendInfo;
}
