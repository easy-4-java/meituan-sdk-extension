package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「预订设备启动」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810027}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_ad563069-6449-4503-b9eb-81406b5f657a">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDeviceStartedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u9884\u8ba2\u8bbe\u5907\u542f\u52a8\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReservedDeviceStartedMessage() {
    }


    /**
     * 订单号。必填。
     */
    @JsonProperty("unifiedOrderId")
    private String unifiedOrderId;
}
