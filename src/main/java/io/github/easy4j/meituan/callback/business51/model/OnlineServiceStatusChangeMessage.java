package io.github.easy4j.meituan.callback.business51.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「美团通知品牌方门店“线上点”营业状态变更【回调】（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_ac21784a-7718-4ab3-9a41-2ea7eafa6fca">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OnlineServiceStatusChangeMessage {

    /**
     * 厂商门店 ID。必填。
     */
    @JsonProperty("vendorShopId")
    private String vendorShopId;

    /**
     * 操作人。必填。
     */
    @JsonProperty("operator")
    private String operator;

    /**
     * 操作原因。必填。
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * 线上点服务开关。必填。
     */
    @JsonProperty("vendorServiceOpen")
    private Integer vendorServiceOpen;

    /**
     * 操作时间。必填。
     */
    @JsonProperty("updateTime")
    private Long updateTime;
}
