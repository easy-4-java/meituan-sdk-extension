package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开台信息同步」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810101}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_25f138ce-eeb0-42c2-8f7e-df65447aeaa1">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableOpeningSyncMessage {

    /**
     * 用户手机号。必填。
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 球桌 ID。必填。
     */
    @JsonProperty("ballTableId")
    private Long ballTableId;
    /**
     * 券码。必填。
     */
    @JsonProperty("couponCode")
    private String couponCode;

    /**
     * 创建美团「开台信息同步」回调的业务内容。的空实例。
     */
    public TableOpeningSyncMessage() {
    }
}
