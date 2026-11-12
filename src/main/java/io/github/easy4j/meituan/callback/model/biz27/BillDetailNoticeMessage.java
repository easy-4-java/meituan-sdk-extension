package io.github.easy4j.meituan.callback.model.biz27;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

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
     * 创建\u7f8e\u56e2\u300c\u5feb\u9a74\u63a8\u9001\u8d26\u5355\u660e\u7ec6\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public BillDetailNoticeMessage() {
    }


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
     * 订单商品信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderProduct {

        /**
         * 创建\u8ba2\u5355\u5546\u54c1\u4fe1\u606f\u3002的空实例。
         */
        public OrderProduct() {
        }


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
    }
}
