package io.github.easy4j.meituan.callback.model.biz19;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「配送风险等级变更」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=19}，消息类型为 {@code msgType=19105}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_peisong_877bba14-539e-4051-a2ab-ddfa7c0d4db2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryRiskLevelChangedMessage {

    /**
     * 取货门店 ID。必填。
     */
    @JsonProperty("shop_id")
    private String shopId;
    /**
     * 配送风险等级。必填。
     */
    @JsonProperty("delivery_risk_level")
    private Integer deliveryRiskLevel;

    /**
     * 创建美团「配送风险等级变更」回调的业务内容。的空实例。
     */
    public DeliveryRiskLevelChangedMessage() {
    }
}
