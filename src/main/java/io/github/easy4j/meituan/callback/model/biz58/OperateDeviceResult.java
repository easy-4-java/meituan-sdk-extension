package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「操作设备」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_12820d14-4867-46b5-b527-210c123fc5e9">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperateDeviceResult {

    /**
     * 三方侧设备ID。必填。
     */
    @JsonProperty("thirdPartyDeviceItemId")
    private String thirdPartyDeviceItemId;

    /**
     * 0 正常 1异常。必填。
     */
    @JsonProperty("operateResult")
    private Integer operateResult;
}
