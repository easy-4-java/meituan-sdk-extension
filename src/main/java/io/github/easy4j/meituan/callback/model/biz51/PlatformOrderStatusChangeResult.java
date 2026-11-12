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
     * 取消订单的业务处理码。
     */
    @JsonProperty("code")
    private Integer code;
    /**
     * 取消订单的处理结果说明。
     */
    @JsonProperty("reasonMessage")
    private String reasonMessage;

    /**
     * 创建美团「美团平台订单状态变更通知（必接）」回调的业务响应。的空实例。
     */
    public PlatformOrderStatusChangeResult() {
    }
}
