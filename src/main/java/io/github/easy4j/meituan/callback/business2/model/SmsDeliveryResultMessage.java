package io.github.easy4j.meituan.callback.business2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「短信发送结果回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210095}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_4b06f3e7-b940-4aee-8577-bad12f2e373f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsDeliveryResultMessage {

    /**
     * 消息标识。必填。
     */
    @JsonProperty("msgId")
    private Long msgId;

    /**
     * 订单 ID，仅当发送时传了订单号有值。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 接收目标类型，1为订单场景收货人，2为订单场景预订人。必填。
     */
    @JsonProperty("targetType")
    private Integer targetType;

    /**
     * 短信场景编码。必填。
     */
    @JsonProperty("sceneCode")
    private Integer sceneCode;

    /**
     * 短信模板 ID。必填。
     */
    @JsonProperty("templateId")
    private Integer templateId;

    /**
     * 发送结果状态码，0-成功；100-终端问题，比如关机、空号等；200-内容问题，比如敏感词等；300-策略问题，比如频次免打扰等；400-系统问题；500-未知原因；。必填。
     */
    @JsonProperty("statusCode")
    private String statusCode;

    /**
     * 发送结果描述，当status_code非0时为失败原因。必填。
     */
    @JsonProperty("statusDesc")
    private String statusDesc;
}
