package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单预取消」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_1ea72825-e410-48e1-b6c4-d1085dc366ef">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCancellationPrecheckResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u8ba2\u5355\u9884\u53d6\u6d88\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public OrderCancellationPrecheckResult() {
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
