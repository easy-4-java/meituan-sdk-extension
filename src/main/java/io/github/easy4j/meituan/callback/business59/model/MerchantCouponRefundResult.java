package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券退券」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_593a32a9-0dbc-4ca4-abd9-750153ff3ec1">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponRefundResult {

    /**
     * 退款ID。必填。
     */
    @JsonProperty("refundId")
    private String refundId;

    /**
     * 业务错误码。200：退券成功 400：参数错误 1111 ： 券已核销【注：美团侧会进行补核销，核销门店为商品的适用门店内随机一个】 1112：团购券已退款 1113：团购套餐已过期 1114：退券数量不对 1115：处理中【注：异步退券，返回这个】 1116：其他原因导致退券失败 1131：部分核销成功。
     */
    @JsonProperty("businessCode")
    private Integer businessCode;

    /**
     * 业务响应信息。
     */
    @JsonProperty("businessMsg")
    private String businessMsg;
}
