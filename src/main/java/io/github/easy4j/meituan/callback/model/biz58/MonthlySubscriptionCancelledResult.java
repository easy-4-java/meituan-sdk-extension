package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「取消连续包月通知」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_dcc3a1b9-a6ab-4f0d-8d63-9c0d25938a0d">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthlySubscriptionCancelledResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u53d6\u6d88\u8fde\u7eed\u5305\u6708\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public MonthlySubscriptionCancelledResult() {
    }


    /**
     * 取消结果：1-取消成功，2-取消失败。
     */
    @JsonProperty("cancelResult")
    private Integer cancelResult;

    /**
     * 错误原因。
     */
    @JsonProperty("bizErrorReason")
    private String bizErrorReason;
}
