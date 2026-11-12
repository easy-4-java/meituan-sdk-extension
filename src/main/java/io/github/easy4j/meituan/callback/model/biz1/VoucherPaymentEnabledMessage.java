package io.github.easy4j.meituan.callback.model.biz1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开通代金券买单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1}，消息类型为 {@code msgType=110011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_tuangoung_10c69b71-a072-4d6f-ab0e-9d1f3a2027da">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoucherPaymentEnabledMessage {

    /**
     * 是否开通代金券买单，true开通false不开通。必填。
     */
    @JsonProperty("isOpen")
    private Boolean isOpen;
}
