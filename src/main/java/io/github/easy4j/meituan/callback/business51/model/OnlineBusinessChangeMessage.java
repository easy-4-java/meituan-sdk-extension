package io.github.easy4j.meituan.callback.business51.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「美团通知品牌方“线上点”业务变更【回调】（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_babc2497-e3b5-49be-8259-3412d71fe210">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OnlineBusinessChangeMessage {

    /**
     * 厂商门店 ID。
     */
    @JsonProperty("vendorShopId")
    private String vendorShopId;

    /**
     * 线上点业务开通状态10:开 20:关。
     */
    @JsonProperty("vendorBizOpen")
    private Integer vendorBizOpen;

    /**
     * 操作人（内容审核、运营、大客菜品服务等）。
     */
    @JsonProperty("operator")
    private String operator;

    /**
     * 操作原因（没有菜品、审核违法、运营紧急下线等）。
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * 操作时间（单位毫秒）。
     */
    @JsonProperty("updateTime")
    private Long updateTime;
}
