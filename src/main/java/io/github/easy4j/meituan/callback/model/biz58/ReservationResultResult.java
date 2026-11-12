package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「预订结果同步」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_f84503ae-994c-47ca-899b-2823bf201048">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationResultResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u9884\u8ba2\u7ed3\u679c\u540c\u6b65\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationResultResult() {
    }


    /**
     * orderId。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * appOrderId。
     */
    @JsonProperty("appOrderId")
    private String appOrderId;
}
