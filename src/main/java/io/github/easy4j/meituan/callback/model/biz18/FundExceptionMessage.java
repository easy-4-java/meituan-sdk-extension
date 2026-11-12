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

    /**
     * 创建美团「资金业务异常通知」回调的业务内容。的空实例。
     */
    public FundExceptionMessage() {
    }
}
