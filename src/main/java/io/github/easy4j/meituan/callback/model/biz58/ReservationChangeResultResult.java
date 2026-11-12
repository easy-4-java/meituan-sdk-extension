package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「改约结果通知三方」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_a0fbb149-f754-444e-ae81-2792d460d6c6">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationChangeResultResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u6539\u7ea6\u7ed3\u679c\u901a\u77e5\u4e09\u65b9\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationChangeResultResult() {
    }


    /**
     * 平台订单id。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 三方订单id。
     */
    @JsonProperty("appOrderId")
    private String appOrderId;
}
