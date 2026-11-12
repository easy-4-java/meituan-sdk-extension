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
     * 创建\u7f8e\u56e2\u300c\u53d6\u6d88\u7ed3\u679c\u540c\u6b65\u4e09\u65b9\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationCancelResultSyncResult() {
    }


    /**
     * 处理结果。true/false。必填。
     */
    @JsonProperty("result")
    private String result;
}
