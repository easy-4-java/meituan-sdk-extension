package io.github.easy4j.meituan.callback.model.biz16;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「推送是否可发配送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=16}，消息类型为 {@code msgType=1610019}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_wmoperng_5eb67b95-94be-4f04-aa5f-8fd64c2e9457">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DispatchEligibilityMessage {

    /**
     * 创建美团「推送是否可发配送」回调的业务内容。的空实例。
     */
    public DispatchEligibilityMessage() {
    }


    /**
     * 订单 ID。必填。
     */
    @JsonProperty("order_id")
    private Long orderId;

    /**
     * 门店编码。必填。
     */
    @JsonProperty("app_poi_code")
    private String appPoiCode;

    /**
     * 美团跑腿订单聚合平台可发配送状态，当前返回值只有0，收到此推送时商家可对当前订单发起配送。 0：可发配送。必填。
     */
    @JsonProperty("delivery_available")
    private Integer deliveryAvailable;
}
