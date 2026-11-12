package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「取消预订审核」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_dc9fb7af-c0a2-4702-a9f5-f55866ebfe97">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCancellationReviewResult {

    /**
     * 开放平台订单ID。
     */
    @JsonProperty("orderId")
    private String orderId;


    /**
     * 创建美团「取消预订审核」回调的业务响应。的空实例。
     */
    public ReservationCancellationReviewResult() {
    }
}
