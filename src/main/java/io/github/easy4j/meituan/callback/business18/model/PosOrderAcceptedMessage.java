package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「POS接单-自动接单or接单页商家手动同意接单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_c338bee4-012c-4cba-98ec-167e7eb4bfbf">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosOrderAcceptedMessage {

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
     * 美团收银员 ID。
     */
    @JsonProperty("mtOperatorId")
    private Long mtOperatorId;

    /**
     * 美团设备 ID。
     */
    @JsonProperty("mtDeviceId")
    private Long mtDeviceId;
}
