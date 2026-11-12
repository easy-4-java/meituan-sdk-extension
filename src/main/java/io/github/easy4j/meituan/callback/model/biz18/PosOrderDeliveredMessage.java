package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「POS接单-接单页商家点击已送达」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810045}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_f93fd133-2373-4b0f-a7ae-a904031349e5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosOrderDeliveredMessage {

    /**
     * 机构 ID。必填。
     */
    @JsonProperty("orgId")
    private Long orgId;
    /**
     * 美团订单 ID。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;
    /**
     * 订单编号。必填。
     */
    @JsonProperty("orderNo")
    private String orderNo;
    /**
     * 美团操作人 ID。必填。
     */
    @JsonProperty("mtOperatorId")
    private Long mtOperatorId;
    /**
     * 美团设备 ID。必填。
     */
    @JsonProperty("mtDeviceId")
    private Long mtDeviceId;

    /**
     * 创建美团「POS接单-接单页商家点击已送达」回调的业务内容。的空实例。
     */
    public PosOrderDeliveredMessage() {
    }
}
