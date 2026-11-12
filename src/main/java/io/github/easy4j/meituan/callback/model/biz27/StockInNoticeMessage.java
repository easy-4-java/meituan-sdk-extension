package io.github.easy4j.meituan.callback.model.biz27;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 美团「快驴入库通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=27}，消息类型为 {@code msgType=27002}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_klopen_4e16b653-ed45-4efa-8948-0badc1dfa9f2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockInNoticeMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5feb\u9a74\u5165\u5e93\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StockInNoticeMessage() {
    }


    /**
     * 快驴入库单号。必填。
     */
    @JsonProperty("inboundBillNo")
    private String inboundBillNo;

    /**
     * 服务商订单标识。必填。
     */
    @JsonProperty("orderIdentify")
    private String orderIdentify;

    /**
     * 服务商商家品牌标识。必填。
     */
    @JsonProperty("brandIdentify")
    private String brandIdentify;

    /**
     * 服务商门店标识。必填。
     */
    @JsonProperty("shopIdentify")
    private String shopIdentify;

    /**
     * 来源。
     */
    @JsonProperty("source")
    private Integer source;

    /**
     * 创建时间。必填。
     */
    @JsonProperty("createTime")
    private JsonNode createTime;

    /**
     * 备注。
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * 订单商品明细。必填。
     */
    @JsonProperty("orderItemList")
    private List<OrderItemDto> orderItemList;

    /**
     * 订单商品明细。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderItemDto {

        /**
         * 创建\u8ba2\u5355\u5546\u54c1\u660e\u7ec6\u3002的空实例。
         */
        public OrderItemDto() {
        }


        /**
         * 服务商商品标识。必填。
         */
        @JsonProperty("goodsIdentify")
        private String goodsIdentify;

        /**
         * 服务商订单明细标识。必填。
         */
        @JsonProperty("orderItemIdentify")
        private String orderItemIdentify;

        /**
         * 商品数量。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
         */
        @JsonProperty("actualQuantity")
        private JsonNode actualQuantity;

        /**
         * 单价。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
         */
        @JsonProperty("goodsPrice")
        private JsonNode goodsPrice;

        /**
         * 多退少补重量。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
         */
        @JsonProperty("differenceWeight")
        private JsonNode differenceWeight;

        /**
         * 多退少补金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
         */
        @JsonProperty("differenceAmount")
        private JsonNode differenceAmount;

        /**
         * 商品应付金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
         */
        @JsonProperty("payAmount")
        private JsonNode payAmount;

        /**
         * 商品实付金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
         */
        @JsonProperty("actualPayAmount")
        private JsonNode actualPayAmount;
    }
}
