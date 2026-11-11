package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「【供应链】组合加工单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810335}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_42ee4c75-d6ef-4186-9f98-7c6ad99d8695">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssemblyOrderMessage {

    /**
     * 总部机构。必填。
     */
    @JsonProperty("rootOrgId")
    private Long rootOrgId;

    /**
     * 推送事件Id。必填。
     */
    @JsonProperty("pushEventId")
    private String pushEventId;

    /**
     * 操作类型。必填。
     */
    @JsonProperty("opType")
    private Integer opType;

    /**
     * 消息时序Id。必填。
     */
    @JsonProperty("seqId")
    private Long seqId;

    /**
     * 大消息体标识。
     */
    @JsonProperty("largeMessageTag")
    private Boolean largeMessageTag;

    /**
     * 业务数据。必填。
     */
    @JsonProperty("bizData")
    private ProduceProcessDetailOpenDTO bizData;
}
