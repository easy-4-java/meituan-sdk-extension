package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「改约提交」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_ebd8fc97-8ff0-4d77-b438-b86aaa5bf818">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationChangeSubmittedResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u6539\u7ea6\u63d0\u4ea4\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ReservationChangeSubmittedResult() {
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
