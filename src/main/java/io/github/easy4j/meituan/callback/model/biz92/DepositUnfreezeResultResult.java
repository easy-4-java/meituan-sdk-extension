package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「押金解冻结果回调」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_518ff9a5-7a8d-4ec5-b3b6-e5d76defbb47">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositUnfreezeResultResult {

    /**
     * 业务状态码。必填。
     */
    @JsonProperty("bizCode")
    private Integer bizCode;
    /**
     * 错误描述。必填。
     */
    @JsonProperty("bizMessage")
    private String bizMessage;
    /**
     * 美团解冻流水。必填。
     */
    @JsonProperty("mtUnfreezeId")
    private String mtUnfreezeId;
    /**
     * 商家解冻流水。必填。
     */
    @JsonProperty("thirdUnfreezeId")
    private String thirdUnfreezeId;

    /**
     * 创建美团「押金解冻结果回调」回调的业务响应。的空实例。
     */
    public DepositUnfreezeResultResult() {
    }
}
