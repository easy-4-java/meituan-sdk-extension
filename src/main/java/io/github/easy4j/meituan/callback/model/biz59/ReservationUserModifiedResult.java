package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「用户改约」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_0d364a1f-64a2-442c-8d9c-20368541ef62">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationUserModifiedResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u7528\u6237\u6539\u7ea6\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationUserModifiedResult() {
    }


    /**
     * 处理结果。true/false。必填。
     */
    @JsonProperty("result")
    private String result;
}
