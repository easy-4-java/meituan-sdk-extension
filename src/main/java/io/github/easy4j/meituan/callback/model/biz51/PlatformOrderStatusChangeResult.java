package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「美团平台订单状态变更通知（必接）」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_1578f703-51d9-408d-8115-81600e6bda31">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformOrderStatusChangeResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u7f8e\u56e2\u5e73\u53f0\u8ba2\u5355\u72b6\u6001\u53d8\u66f4\u901a\u77e5\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public PlatformOrderStatusChangeResult() {
    }


    /**
     * 取消订单的业务处理码。
     */
    @JsonProperty("code")
    private Integer code;

    /**
     * 取消订单的处理结果说明。
     */
    @JsonProperty("reasonMessage")
    private String reasonMessage;
}
