package io.github.easy4j.meituan.callback.model.biz27;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「快驴订单取消通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=27}，消息类型为 {@code msgType=27004}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_klopen_642ff552-99c0-4a65-bb26-ef6c66a45314">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCancelNoticeMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5feb\u9a74\u8ba2\u5355\u53d6\u6d88\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderCancelNoticeMessage() {
    }


    /**
     * 快驴订单编号。必填。
     */
    @JsonProperty("orderNo")
    private String orderNo;

    /**
     * 服务商订单标识。必填。
     */
    @JsonProperty("orderIdentify")
    private String orderIdentify;

    /**
     * 服务商商家品牌标识。必填。
     */
    @JsonProperty("brandIdentify")
    private String brandIdentify;

    /**
     * 取消原因。
     */
    @JsonProperty("cancelReason")
    private String cancelReason;
}
