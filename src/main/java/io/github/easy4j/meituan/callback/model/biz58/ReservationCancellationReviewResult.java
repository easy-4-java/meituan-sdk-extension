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
     * 创建\u7f8e\u56e2\u300c\u53d6\u6d88\u9884\u8ba2\u5ba1\u6838\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationCancellationReviewResult() {
    }


    /**
     * 开放平台订单ID。
     */
    @JsonProperty("orderId")
    private String orderId;
}
