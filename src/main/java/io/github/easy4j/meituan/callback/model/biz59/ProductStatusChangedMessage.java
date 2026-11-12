package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商品状态变更」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_96f04b32-2780-4a0d-af3e-529dd7fa2490">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductStatusChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u54c1\u72b6\u6001\u53d8\u66f4\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ProductStatusChangedMessage() {
    }


    /**
     * 商品 ID。
     */
    @JsonProperty("productId")
    private Long productId;

    /**
     * ISV商品 ID。
     */
    @JsonProperty("appProductId")
    private String appProductId;

    /**
     * 商品流转状态 24：审核驳回, 30：已发布。
     */
    @JsonProperty("flowStatus")
    private Integer flowStatus;

    /**
     * 商品流程相关信息，如驳回理由等。
     */
    @JsonProperty("memo")
    private String memo;
}
