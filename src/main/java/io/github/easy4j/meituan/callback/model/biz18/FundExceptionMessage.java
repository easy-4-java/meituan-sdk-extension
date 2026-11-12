package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「资金业务异常通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810251}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_60d0606f-1762-4008-a59e-5e07eb8424d6">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundExceptionMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8d44\u91d1\u4e1a\u52a1\u5f02\u5e38\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public FundExceptionMessage() {
    }


    /**
     * 异常时间。必填。
     */
    @JsonProperty("exceptionTime")
    private String exceptionTime;

    /**
     * 异常系统。必填。
     */
    @JsonProperty("exceptionSystem")
    private String exceptionSystem;

    /**
     * 异常类型。必填。
     */
    @JsonProperty("exceptionType")
    private String exceptionType;

    /**
     * 异常原因。必填。
     */
    @JsonProperty("exceptionReason")
    private String exceptionReason;
}
