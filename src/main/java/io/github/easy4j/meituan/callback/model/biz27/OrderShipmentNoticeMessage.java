package io.github.easy4j.meituan.callback.model.biz27;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「快驴订单发货通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=27}，消息类型为 {@code msgType=2710005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_klopen_80bb04b0-5b52-4d47-9d55-430c0e561e79">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderShipmentNoticeMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5feb\u9a74\u8ba2\u5355\u53d1\u8d27\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderShipmentNoticeMessage() {
    }


    /**
     * 订单编号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 订单状态。必填。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 订单创建 时间。必填。
     */
    @JsonProperty("createDate")
    private String createDate;

    /**
     * 收货人姓 名。必填。
     */
    @JsonProperty("receiverName")
    private String receiverName;

    /**
     * 收货人联 系电话。必填。
     */
    @JsonProperty("receiverPhone")
    private String receiverPhone;

    /**
     * 配送地址。必填。
     */
    @JsonProperty("addressDetail")
    private String addressDetail;

    /**
     * 期待到货 日期。必填。
     */
    @JsonProperty("expectTime")
    private String expectTime;

    /**
     * 订单备注。
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * 取消原因。
     */
    @JsonProperty("cancelReason")
    private String cancelReason;

    /**
     * 取消备注。
     */
    @JsonProperty("cancelRemark")
    private String cancelRemark;

    /**
     * 取消人。
     */
    @JsonProperty("cancelUser")
    private String cancelUser;

    /**
     * 优惠金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
     */
    @JsonProperty("discountAmount")
    private JsonNode discountAmount;

    /**
     * 应收金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
     */
    @JsonProperty("receivableAmount")
    private JsonNode receivableAmount;

    /**
     * 订单总额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
     */
    @JsonProperty("totalAmount")
    private JsonNode totalAmount;

    /**
     * 订单支付 方式。
     */
    @JsonProperty("payType")
    private Integer payType;

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
         * 订单编号。必填。
         */
        @JsonProperty("orderId")
        private String orderId;

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
         * 规格描述。必填。
         */
        @JsonProperty("specificationsDes")
        private String specificationsDes;

        /**
         * 销售单价。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
         */
        @JsonProperty("goodsPrice")
        private JsonNode goodsPrice;

        /**
         * 下单数量。必填。
         */
        @JsonProperty("quantity")
        private Integer quantity;

        /**
         * 实发数量。
         */
        @JsonProperty("deliveryQuantity")
        private Integer deliveryQuantity;

        /**
         * 包装单位。必填。
         */
        @JsonProperty("unit")
        private String unit;
    }
}
