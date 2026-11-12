package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「启动设备并核销团单」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_6ea4ba3a-a2c7-4e18-a897-c5c2ee96c47c">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartDeviceAndConsumeDealResult {

    /**
     * 操作结果（0为正常，非0为异常）。必填。
     */
    @JsonProperty("result")
    private Integer result;


    /**
     * 创建美团「启动设备并核销团单」回调的业务响应。的空实例。
     */
    public StartDeviceAndConsumeDealResult() {
    }
}
