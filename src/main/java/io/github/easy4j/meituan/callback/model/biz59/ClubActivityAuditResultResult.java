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
     * 创建\u7f8e\u56e2\u300c\u4ff1\u4e50\u90e8\u6d3b\u52a8\u5ba1\u6838\u7ed3\u679c\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ClubActivityAuditResultResult() {
    }


    /**
     * 是否成功接收。必填。
     */
    @JsonProperty("success")
    private Boolean success;
}
