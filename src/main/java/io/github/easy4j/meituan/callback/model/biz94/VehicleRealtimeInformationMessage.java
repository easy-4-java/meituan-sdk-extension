package io.github.easy4j.meituan.callback.model.biz94;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「实时信息推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=94}，消息类型为 {@code msgType=9410004}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_keebot_9dd81753-503d-411f-b27f-e91786cc83fd">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleRealtimeInformationMessage {

    /**
     * 车架号。必填。
     */
    @JsonProperty("vin")
    private String vin;

    /**
     * 车辆位置，WGS84 经度。必填。
     */
    @JsonProperty("wgs84lon")
    private Double wgs84lon;

    /**
     * 车辆位置，WGS84 纬度。必填。
     */
    @JsonProperty("wgs84lat")
    private Double wgs84lat;

    /**
     * 车辆位置，GCJ02 经度。必填。
     */
    @JsonProperty("gcj02lon")
    private Double gcj02lon;

    /**
     * 车辆位置，GCJ02 纬度。必填。
     */
    @JsonProperty("gcj02lat")
    private Double gcj02lat;

    /**
     * 车速，单位 km/h。必填。
     */
    @JsonProperty("speed")
    private Double speed;

    /**
     * 档位：P/D/N/R。必填。
     */
    @JsonProperty("gear")
    private String gear;

    /**
     * 剩余电量百分比。必填。
     */
    @JsonProperty("soc")
    private Double soc;

    /**
     * 充电状态。必填。
     */
    @JsonProperty("chargeState")
    private String chargeState;

    /**
     * 剩余续航里程（km）。必填。
     */
    @JsonProperty("remainingEndurance")
    private Double remainingEndurance;

    /**
     * 航向角（弧度制）。必填。
     */
    @JsonProperty("heading")
    private Double heading;

    /**
     * 底盘上电状态。必填。
     */
    @JsonProperty("powerMode")
    private Boolean powerMode;

    /**
     * 车门状态。必填。
     */
    @JsonProperty("doorState")
    private List<DoorState> doorState;

    /**
     * 车轮状态。必填。
     */
    @JsonProperty("wheelState")
    private List<WheelState> wheelState;

    /**
     * 车辆模式。
     */
    @JsonProperty("chassisState")
    private String chassisState;

    /**
     * 灯光状态。必填。
     */
    @JsonProperty("lightState")
    private List<LightState> lightState;

    /**
     * 时间戳。必填。
     */
    @JsonProperty("timestamp")
    private Long timestamp;

    /**
     * doorState。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DoorState {

        /**
         * 车门类型。必填。
         */
        @JsonProperty("doorType")
        private Integer doorType;

        /**
         * 车门类型描述。必填。
         */
        @JsonProperty("doorTypeDesc")
        private String doorTypeDesc;

        /**
         * 车门状态。必填。
         */
        @JsonProperty("doorStatus")
        private Integer doorStatus;

        /**
         * 车门状态描述。必填。
         */
        @JsonProperty("doorStatusDesc")
        private String doorStatusDesc;
    }

    /**
     * wheelState。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WheelState {

        /**
         * 轮胎位置: FL/FR/RL/RR。必填。
         */
        @JsonProperty("wheelPosition")
        private String wheelPosition;

        /**
         * 胎压值。必填。
         */
        @JsonProperty("pressure")
        private Double pressure;

        /**
         * 胎温。必填。
         */
        @JsonProperty("temperature")
        private Double temperature;
    }

    /**
     * lightState。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LightState {

        /**
         * 灯光类型：TURN_LEFT, TURN_RIGHT, HAZARD, HIGH_BEAM, LOW_BEAM, REAR_LOW_BEAM, FRONT_FOG_LAMP, REAR_FOG_LAMP, BRAKE_LIGHT, BACKUP_LAMP。
         * 必填。
         */
        @JsonProperty("lightType")
        private String lightType;

        /**
         * 是否打开。必填。
         */
        @JsonProperty("isOn")
        private Boolean isOn;
    }
}
