package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「品牌提供订单查询（必接）」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_9e4af01d-409c-4a85-addb-2da4f86831bf">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandOrderQueryResult {

    /**
     * 创建美团「品牌提供订单查询（必接）」回调的业务响应。的空实例。
     */
    public BrandOrderQueryResult() {
    }


    /**
     * 官网响应示例中的处理结果类型。
     */
    @JsonProperty("resultType")
    private Integer resultType;

    /**
     * 美团平台订单ID。必填。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 品牌方订单ID。必填。
     */
    @JsonProperty("vendorOrderId")
    private String vendorOrderId;

    /**
     * 订单类型 1—实时单 2—预约单。必填。
     */
    @JsonProperty("orderType")
    private Integer orderType;

    /**
     * 取餐口令，如品牌自己生成取餐码，则必传。
     */
    @JsonProperty("takeCode")
    private String takeCode;

    /**
     * 预计取餐时间，普通单必传。
     */
    @JsonProperty("takeTime")
    private Long takeTime;

    /**
     * 预计制作时间。
     */
    @JsonProperty("makeTime")
    private Long makeTime;

    /**
     * 订单状态 10—已付款 20—预约中 30—制作中 40—待取餐 50—已取餐（已完成） 60—已退款。必填。
     */
    @JsonProperty("orderStatus")
    private Integer orderStatus;

    /**
     * 取餐杯数。
     */
    @JsonProperty("predicatedCount")
    private Integer predicatedCount;

    /**
     * 最大可取餐时间，单位分钟。
     */
    @JsonProperty("maxMinutes")
    private Integer maxMinutes;
}
