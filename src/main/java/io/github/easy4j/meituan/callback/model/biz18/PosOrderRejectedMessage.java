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
