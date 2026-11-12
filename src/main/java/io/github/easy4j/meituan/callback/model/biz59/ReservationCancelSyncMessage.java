package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「取消同步三方」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_cda08228-2c64-4177-bedc-1d5b35d164c2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCancelSyncMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u53d6\u6d88\u540c\u6b65\u4e09\u65b9\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReservationCancelSyncMessage() {
    }


    /**
     * 预约单 ID。必填。
     */
    @JsonProperty("leadsId")
    private String leadsId;

    /**
     * 门店 ID。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 取消原因。
     */
    @JsonProperty("cancelReason")
    private String cancelReason;

    /**
     * 扩展字段。
     */
    @JsonProperty("extraMap")
    private String extraMap;

    /**
     * 是否极速退：true：是。
     */
    @JsonProperty("isFastRefund")
    private Boolean isFastRefund;
}
