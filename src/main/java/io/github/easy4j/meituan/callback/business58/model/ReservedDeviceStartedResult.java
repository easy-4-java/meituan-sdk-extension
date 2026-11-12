package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「预订设备启动」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_ad563069-6449-4503-b9eb-81406b5f657a">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDeviceStartedResult {

    /**
     * 业务错误码。业务错误码；返回特定code时，C端优先展示 businessMsg。
     */
    @JsonProperty("businessCode")
    private Integer businessCode;

    /**
     * 业务响应信息。业务错误信息。
     */
    @JsonProperty("businessMsg")
    private String businessMsg;
}
