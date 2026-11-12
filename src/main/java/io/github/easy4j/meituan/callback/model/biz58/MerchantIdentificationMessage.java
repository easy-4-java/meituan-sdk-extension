package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商户识别」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810077}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_a3e73815-9fe7-450f-a493-e9e11d68ef5e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantIdentificationMessage {

    /**
     * 创建美团「商户识别」回调的业务内容。的空实例。
     */
    public MerchantIdentificationMessage() {
    }


    /**
     * 美团店铺 ID（混淆）。必填。
     */
    @JsonProperty("mtStoreCode")
    private String mtStoreCode;
}
