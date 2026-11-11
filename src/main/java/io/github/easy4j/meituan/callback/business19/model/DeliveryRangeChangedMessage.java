package io.github.easy4j.meituan.callback.business19.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「配送范围变更」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=19}，消息类型为 {@code msgType=19104}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_peisong_8fc0e891-2f4c-4380-8b3e-c27f4f3e690c">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryRangeChangedMessage {

    /**
     * 配送服务代码。必填。
     */
    @JsonProperty("delivery_service_code")
    private Integer deliveryServiceCode;

    /**
     * 取货门店 ID。必填。
     */
    @JsonProperty("shop_id")
    private String shopId;

    /**
     * 门店配送范围。必填。
     */
    @JsonProperty("scope")
    private String scope;
}
