package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「续租取消检查」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_5dbbbbd2-153e-4a1a-9760-b8d86eb23c5c">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionCancellationCheckResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u7eed\u79df\u53d6\u6d88\u68c0\u67e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public RentalExtensionCancellationCheckResult() {
    }


    /**
     * 业务状态码。必填。
     */
    @JsonProperty("bizCode")
    private Integer bizCode;

    /**
     * 错误描述。必填。
     */
    @JsonProperty("bizMessage")
    private String bizMessage;

    /**
     * 预计扣款金额。必填。
     */
    @JsonProperty("deductAmount")
    private Integer deductAmount;

    /**
     * 扣款描述。必填。
     */
    @JsonProperty("reason")
    private String reason;
}
