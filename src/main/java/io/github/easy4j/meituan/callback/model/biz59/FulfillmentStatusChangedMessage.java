package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「履约状态变更通知商家」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910009}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_e6a2b815-4b19-484b-a795-39d33ceecc26">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FulfillmentStatusChangedMessage {

    /**
     * 创建美团「履约状态变更通知商家」回调的业务内容。的空实例。
     */
    public FulfillmentStatusChangedMessage() {
    }


    /**
     * 预约单号。必填。
     */
    @JsonProperty("leadsId")
    private String leadsId;

    /**
     * 美团门店 ID，该字段是混淆字段，实际值类型为混淆后的字符串类型。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 履约状态 100：已到店。
     */
    @JsonProperty("fullfillStatus")
    private String fullfillStatus;

    /**
     * 履约状态类型 1：到店状态。
     */
    @JsonProperty("fullfillStatusType")
    private String fullfillStatusType;

    /**
     * 履约信息。
     */
    @JsonProperty("fullfillInfo")
    private String fullfillInfo;

    /**
     * 扩展字段。
     */
    @JsonProperty("extraMap")
    private String extraMap;
}
