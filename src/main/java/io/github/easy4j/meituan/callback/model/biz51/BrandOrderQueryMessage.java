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
     * 创建\u7f8e\u56e2\u300c\u54c1\u724c\u63d0\u4f9b\u8ba2\u5355\u67e5\u8be2\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public BrandOrderQueryMessage() {
    }


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
}
