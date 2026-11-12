package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「取消结果同步三方」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_6ba0dd9e-04e0-45e6-a3aa-4937d7598c16">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCancelResultSyncResult {

    /**
     * 创建美团「取消结果同步三方」回调的业务响应。的空实例。
     */
    public ReservationCancelResultSyncResult() {
    }


    /**
     * 处理结果。true/false。必填。
     */
    @JsonProperty("result")
    private String result;
}
