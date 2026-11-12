package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务数据（PriceInfo）。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalPriceInfoResult {

    /**
     * 优惠前总价格 (单位分)。必填。
     */
    @JsonProperty("originalTotalAmount")
    private Integer originalTotalAmount;

    /**
     * 优惠后总价格（包含基础保险和商家交互的总价格) (单位分)。必填。
     */
    @JsonProperty("totalAmount")
    private Integer totalAmount;

    /**
     * 日均价(基本租车费的日均价) (单位分)。必填。
     */
    @JsonProperty("unitAmount")
    private Integer unitAmount;
}
