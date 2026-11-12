package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询订单履约信息（必接）」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_c5d73602-79ab-4880-ba25-ef974c42f9d0">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderFulfillmentQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u8ba2\u5355\u5c65\u7ea6\u4fe1\u606f\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public OrderFulfillmentQueryResult() {
    }


    /**
     * 订单状态，状态枚举： -1:订单不存在 、2:新订单-用户支付完成，待商家接单、4:商家已接单、8:订单已完成、9:订单已取消。必填。
     */
    @JsonProperty("orderStatus")
    private Integer orderStatus;

    /**
     * 预计等候时间(单位分钟）。必填。
     */
    @JsonProperty("predicatedMinutes")
    private Integer predicatedMinutes;

    /**
     * 预计等候杯数。
     */
    @JsonProperty("predicatedCount")
    private Integer predicatedCount;
}
