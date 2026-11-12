package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单续租下单」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_56c92d5f-85c5-40e2-a1d1-942a6bc279eb">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionOrderResult {

    /**
     * 创建美团「订单续租下单」回调的业务响应。的空实例。
     */
    public RentalExtensionOrderResult() {
    }


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
     * 三方续租单订单号。必填。
     */
    @JsonProperty("thirdRenewalOrderId")
    private String thirdRenewalOrderId;
}
