package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「核销状态查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_c22a6603-c6b6-4b47-83bb-9752288fd4dc">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedemptionStatusQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u6838\u9500\u72b6\u6001\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public RedemptionStatusQueryResult() {
    }


    /**
     * 是否核销。1.未核销 2.已核销 3.未知状态 注1：如果返回3（未知状态），美团侧会一直轮询直到返回终态（1或2），体检预订业务除外。 注2：体检预订业务发起退款后，轮询72小时仍返回consume_status=3，平台会发起自动退款。必填。
     */
    @JsonProperty("consumeStatus")
    private Integer consumeStatus;

    /**
     * 订单Id。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
}
