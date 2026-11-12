package io.github.easy4j.meituan.callback.model.biz27;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「快驴出库通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=27}，消息类型为 {@code msgType=27003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_klopen_1056ac08-a99a-4053-a2bc-db530bb5c3af">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockOutNoticeMessage {

    /**
     * 快驴出库单号。必填。
     */
    @JsonProperty("outboundBillNo")
    private String outboundBillNo;

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
     * 运费金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
     */
    @JsonProperty("freightFee")
    private JsonNode freightFee;

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
         * 实际出库数量。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
         */
        @JsonProperty("returnQuantity")
        private JsonNode returnQuantity;

        /**
         * 单价。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
         */
        @JsonProperty("goodsPrice")
        private JsonNode goodsPrice;

        /**
         * 多退少补金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
         */
        @JsonProperty("differenceAmount")
        private JsonNode differenceAmount;

        /**
         * 商品实退金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。
         */
        @JsonProperty("returnAmount")
        private JsonNode returnAmount;
    }
}
