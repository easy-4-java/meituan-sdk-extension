package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「下单」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_77c13fc2-0902-4876-af97-a85d96a37692">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlacedResult {

    /**
     * 创建美团「下单」回调的业务响应。的空实例。
     */
    public OrderPlacedResult() {
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
     * 商家订单号。必填。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;
}
