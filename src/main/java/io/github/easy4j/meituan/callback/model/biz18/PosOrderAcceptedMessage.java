package io.github.easy4j.meituan.callback.model.biz18;

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
     * 创建\u7f8e\u56e2\u300cPOS\u63a5\u5355-\u81ea\u52a8\u63a5\u5355or\u63a5\u5355\u9875\u5546\u5bb6\u624b\u52a8\u540c\u610f\u63a5\u5355\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PosOrderAcceptedMessage() {
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
