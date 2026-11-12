package io.github.easy4j.meituan.callback.model.biz27;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「快驴推送账单明细」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=27}，消息类型为 {@code msgType=2710003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_klopen_cd5fa387-81aa-4cb7-836a-58fff83b41a5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillDetailNoticeMessage {

    /**
     * 订单编号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;
    /**
     * 出具账单时间。必填。
     */
    @JsonProperty("billTime")
    private Long billTime;
    /**
     * 订单总额(原金额)。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
     */
    @JsonProperty("orderAmount")
    private JsonNode orderAmount;
    /**
     * 订单总额(应付款)。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
     */
    @JsonProperty("receivableAmount")
    private JsonNode receivableAmount;
    /**
     * 商品总额(应付款)。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
     */
    @JsonProperty("goodsAmount")
    private JsonNode goodsAmount;
    /**
     * 运费(应付款)。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
     */
    @JsonProperty("freightAmount")
    private JsonNode freightAmount;
    /**
     * 订单商品信息。必填。
     */
    @JsonProperty("orderProducts")
    private List<OrderProduct> orderProducts;

    /**
     * 创建美团「快驴推送账单明细」回调的业务内容。的空实例。
     */
    public BillDetailNoticeMessage() {
    }

    /**
     * 订单商品信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderProduct {

        /**
         * sku 编号。必填。
         */
        @JsonProperty("skuCode")
        private String skuCode;
        /**
         * sku 名称。必填。
         */
        @JsonProperty("skuName")
        private String skuName;
        /**
         * 销售单价。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
         */
        @JsonProperty("price")
        private JsonNode price;
        /**
         * 包装单位。必填。
         */
        @JsonProperty("unit")
        private String unit;
        /**
         * 下单数量。必填。
         */
        @JsonProperty("orderQuantity")
        private Integer orderQuantity;
        /**
         * 账单数量。必填。
         */
        @JsonProperty("billQuantity")
        private Integer billQuantity;

        /**
         * 创建订单商品信息。的空实例。
         */
        public OrderProduct() {
        }
    }
}
