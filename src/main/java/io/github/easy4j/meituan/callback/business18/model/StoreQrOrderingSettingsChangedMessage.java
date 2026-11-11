package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店扫码点餐配置变动通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810279}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_d78845e8-5809-40c1-a9b1-64ec3e7c0d32">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreQrOrderingSettingsChangedMessage {

    /**
     * 发生配置变更的门店组织机构 ID。
     */
    @JsonProperty("orgId")
    private Long orgId;
}
