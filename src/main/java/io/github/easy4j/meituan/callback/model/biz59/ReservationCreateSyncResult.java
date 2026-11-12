package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「创单同步三方」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_70680584-cd1b-471f-aac6-d4d9bfbba5a9">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCreateSyncResult {

    /**
     * 处理结果。true/false。必填。
     */
    @JsonProperty("result")
    private String result;
}
