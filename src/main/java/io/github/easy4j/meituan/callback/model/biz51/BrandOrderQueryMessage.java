package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「品牌提供订单查询（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110009}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_9e4af01d-409c-4a85-addb-2da4f86831bf">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandOrderQueryMessage {

    /**
     * 美团平台订单 ID。必填。
     */
    @JsonProperty("orderId")
    private Long orderId;
    /**
     * 业务类型 10-MOP。必填。
     */
    @JsonProperty("bizType")
    private Integer bizType;

    /**
     * 创建美团「品牌提供订单查询（必接）」回调的业务内容。的空实例。
     */
    public BrandOrderQueryMessage() {
    }
}
