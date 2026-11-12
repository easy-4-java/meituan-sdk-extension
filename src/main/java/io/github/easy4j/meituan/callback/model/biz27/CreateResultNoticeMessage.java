package io.github.easy4j.meituan.callback.model.biz27;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「快驴订单创建结果异步通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=27}，消息类型为 {@code msgType=27001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_klopen_29b2c89c-6012-4333-990c-5d5f5eda69a7">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateResultNoticeMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5feb\u9a74\u8ba2\u5355\u521b\u5efa\u7ed3\u679c\u5f02\u6b65\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public CreateResultNoticeMessage() {
    }


    /**
     * 快驴订单编号。
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
     * 异常message。
     */
    @JsonProperty("errorMessage")
    private String errorMessage;
}
