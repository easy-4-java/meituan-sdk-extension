package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「POS接单-接单页商家主动取消订单(退单)」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810023}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_a1633b76-3d13-4942-82dd-3adce4172dc1">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosOrderCancelledMessage {

    /**
     * 创建\u7f8e\u56e2\u300cPOS\u63a5\u5355-\u63a5\u5355\u9875\u5546\u5bb6\u4e3b\u52a8\u53d6\u6d88\u8ba2\u5355(\u9000\u5355)\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PosOrderCancelledMessage() {
    }


    /**
     * 门店的组织 ID。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 美团订单 ID。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 美团退单 ID。
     */
    @JsonProperty("mtRefundId")
    private Long mtRefundId;

    /**
     * 操作人 ID。
     */
    @JsonProperty("mtOperatorId")
    private Integer mtOperatorId;
}
