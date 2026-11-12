package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「团购商品变更通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910137}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_c88e2de3-2c2d-487c-8068-5ee74e12e03d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupBuyProductChangedMessage {

    /**
     * 美团团购商品 ID。必填。
     */
    @JsonProperty("dealGroupId")
    private Long dealGroupId;
    /**
     * 发布类型，0-维持原态（不变）,1-商品上架，2-商品下架。必填。
     */
    @JsonProperty("publishType")
    private Integer publishType;
    /**
     * 是否需要推送库存：0-不需要，1-需要。必填。
     */
    @JsonProperty("needPushStock")
    private Integer needPushStock;

    /**
     * 创建美团「团购商品变更通知」回调的业务内容。的空实例。
     */
    public GroupBuyProductChangedMessage() {
    }
}
