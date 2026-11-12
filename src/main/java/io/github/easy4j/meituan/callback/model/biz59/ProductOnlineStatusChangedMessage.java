package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商品上下架状态通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910049}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_79cb15bc-bccd-4564-aa15-a5163fef9fa3">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOnlineStatusChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u54c1\u4e0a\u4e0b\u67b6\u72b6\u6001\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ProductOnlineStatusChangedMessage() {
    }


    /**
     * 商品 ID。必填。
     */
    @JsonProperty("productId")
    private Long productId;

    /**
     * 0-无效状态 1-上架状态 2-下架状态。必填。
     */
    @JsonProperty("status")
    private Integer status;
}
