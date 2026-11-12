package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开始预订」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_c08eb5f3-ba98-4c97-8579-7d95757df2b4">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationStartedResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u5f00\u59cb\u9884\u8ba2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationStartedResult() {
    }


    /**
     * 订单ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 第三方的订单号。
     */
    @JsonProperty("appOrderId")
    private String appOrderId;

    /**
     * 预订手机号。
     */
    @JsonProperty("mobile")
    private String mobile;
}
