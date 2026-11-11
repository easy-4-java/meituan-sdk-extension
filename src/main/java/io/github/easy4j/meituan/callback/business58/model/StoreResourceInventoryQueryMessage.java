package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询指定门店资源库存」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810093}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_d2731034-87f5-4602-8c51-84222eb85227">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreResourceInventoryQueryMessage {

    /**
     * 美团门店 ID（混淆）。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;
}
