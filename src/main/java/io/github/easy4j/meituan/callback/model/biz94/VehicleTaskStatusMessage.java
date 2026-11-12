package io.github.easy4j.meituan.callback.model.biz94;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「车辆任务状态推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=94}，消息类型为 {@code msgType=9410000}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_keebot_4ab66dcf-35a9-4712-acc9-b0adb8f4307a">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleTaskStatusMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8f66\u8f86\u4efb\u52a1\u72b6\u6001\u63a8\u9001\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public VehicleTaskStatusMessage() {
    }


    /**
     * 车架号。必填。
     */
    @JsonProperty("vin")
    private String vin;

    /**
     * 行程任务 ID。必填。
     */
    @JsonProperty("taskId")
    private String taskId;

    /**
     * 状态值. 含义如下: 0: 已创建 100: 驶入中 200: 已到达 300: 已离开 400: 已取消 500: 已终止。必填。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 行程任务项目标点位 ID。必填。
     */
    @JsonProperty("parkingStationId")
    private String parkingStationId;

    /**
     * 毫秒时间戳。必填。
     */
    @JsonProperty("timestamp")
    private Long timestamp;
}
