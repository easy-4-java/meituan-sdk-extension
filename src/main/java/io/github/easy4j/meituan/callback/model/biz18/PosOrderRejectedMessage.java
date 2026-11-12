package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「POS接单-接单页商家手动拒绝接单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810013}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_c4ad6b92-7711-4f2c-ba97-f1ff4fe16c6f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosOrderRejectedMessage {

    /**
     * 创建\u7f8e\u56e2\u300cPOS\u63a5\u5355-\u63a5\u5355\u9875\u5546\u5bb6\u624b\u52a8\u62d2\u7edd\u63a5\u5355\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PosOrderRejectedMessage() {
    }


    /**
     * 门店机构 ID。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 美团订单 ID。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 三方订单 ID。
     */
    @JsonProperty("orderNo")
    private String orderNo;

    /**
     * 拒单原因。
     */
    @JsonProperty("reason")
    private String reason;
}
