package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「续租取消」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_ecc0df85-921a-4667-a7ae-465d8f96c2ac">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionCancelledResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u7eed\u79df\u53d6\u6d88\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public RentalExtensionCancelledResult() {
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
     * 取消实际扣款金额 单位分。
     */
    @JsonProperty("deductAmount")
    private Integer deductAmount;

    /**
     * 扣款描述。
     */
    @JsonProperty("reason")
    private Integer reason;
}
