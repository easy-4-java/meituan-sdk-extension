package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「俱乐部活动审核结果通知」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_cc1c6e1a-a79a-4886-b9b1-c11357283d58">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubActivityAuditResultResult {

    /**
     * 创建美团「俱乐部活动审核结果通知」回调的业务响应。的空实例。
     */
    public ClubActivityAuditResultResult() {
    }


    /**
     * 是否成功接收。必填。
     */
    @JsonProperty("success")
    private Boolean success;
}
