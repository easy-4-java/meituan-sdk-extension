package io.github.easy4j.meituan.callback.business2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收订单结算明细回调接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210015}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_9d34417c-defb-4c51-9aa3-445405f1b066">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSettlementDetailsMessage {

    /**
     * 服务商入驻技术合作中心得到的唯一身份表示。必填。
     */
    @JsonProperty("developerId")
    private Integer developerId;

    /**
     * ERP方门店 ID。必填。
     */
    @JsonProperty("epoiId")
    private String epoiId;

    /**
     * 数字签名。必填。
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 订单结算信息详情数据。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("tradeDetail")
    private TradeDetail tradeDetail;

    /**
     * 拼好饭订单信息。
     */
    @JsonProperty("phfOrderChargeData")
    private PhfOrderChargeData phfOrderChargeData;

    /**
     * 低收入订单，1-预计收入过低。必填。
     */
    @JsonProperty("lowincomeOrder")
    private Integer lowincomeOrder;

    /**
     * 是否1对1急送订单，0-不是急送，1-急送。
     */
    @JsonProperty("oneOneUrgentDelivery")
    private Integer oneOneUrgentDelivery;

    /**
     * 1对1急送订单是否降级，0-未降级，1-降级。
     */
    @JsonProperty("oneOneUrgentDeliveryTag")
    private Integer oneOneUrgentDeliveryTag;

    /**
     * 配送类型，1-美配，2-自配，0-未知类型。必填。
     */
    @JsonProperty("settlementLogisticsType")
    private Integer settlementLogisticsType;

    /**
     * 订单结算信息详情数据。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TradeDetail {

        /**
         * 活动成本明细(仅商家部分)。
         */
        @JsonProperty("activityDetails")
        private String activityDetails;

        /**
         * 抽佣金额,保留2位小数。
         */
        @JsonProperty("commisionAmount")
        private String commisionAmount;

        /**
         * 商品金额=菜品原价＋餐盒费＋赠品原价（铺货模式赠品原值为0）,保留2为小数。
         */
        @JsonProperty("foodAmount")
        private String foodAmount;

        /**
         * 美团应付给商家 (仅货到付款)。
         */
        @JsonProperty("offlineOrderSkPayAmount")
        private String offlineOrderSkPayAmount;

        /**
         * 订单展示 ID。
         */
        @JsonProperty("orderId")
        private String orderId;

        /**
         * 支付类型（1:货到付款；2:在线支付）。
         */
        @JsonProperty("payType")
        private Integer payType;

        /**
         * 结算金额(商家收入)。
         */
        @JsonProperty("settleAmount")
        private String settleAmount;

        /**
         * 配送费,保留2位小数。
         */
        @JsonProperty("shippingAmount")
        private String shippingAmount;

        /**
         * 配送类型,详见7.6补充相关字段说明。
         */
        @JsonProperty("shippingType")
        private String shippingType;

        /**
         * 总活动款,保留2位小数。
         */
        @JsonProperty("totalActivityAmount")
        private String totalActivityAmount;

        /**
         * 客户线下支付给商家 (仅货到付款)。
         */
        @JsonProperty("userPayAmount")
        private String userPayAmount;

        /**
         * 订单状态,1 用户已提交订单,2 可推送到APP方平台也可推送到商家,3 商家已收到,4 商家已确认,8 已完成,9 已取消。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 津贴联盟信息。
         */
        @JsonProperty("allowance")
        private String allowance;

        /**
         * 活动与对应活动的费用组合,[{amountCent(津贴联盟平台扣减费用/CPS费用转入广告红包账户):112,type(18003代表津贴联盟;18004代表交易额转推广费活动):18003},{}...]。
         */
        @JsonProperty("extendsAmount")
        private String extendsAmount;

        /**
         * 打包袋价格，单位分。
         */
        @JsonProperty("packageBagMoney")
        private BigDecimal packageBagMoney;

        /**
         * 订单业务打标枚举，即业务身份，16-拼好饭场景订单，1001-神抢手场景订单，47-接力送场景订单。
         */
        @JsonProperty("orderTagList")
        private String orderTagList;

        /**
         * 用户支付的1对1急送加速费。
         */
        @JsonProperty("userPay1v1DeliveryFee")
        private String userPay1v1DeliveryFee;
    }

    /**
     * 拼好饭订单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PhfOrderChargeData {

        /**
         * 顾客单买单送费。
         */
        @JsonProperty("singleIncreaseAmount")
        private Double singleIncreaseAmount;

        /**
         * 商品金额合计=餐品原价+打包费+配送费-商家活动补贴-店铺环保捐赠。
         */
        @JsonProperty("totalProductAmount")
        private BigDecimal totalProductAmount;

        /**
         * 顾客实际支付。
         */
        @JsonProperty("userPayTotalAmount")
        private Double userPayTotalAmount;

        /**
         * 顾客支付给商家。
         */
        @JsonProperty("phfPayTotalAmountForPoi")
        private Double phfPayTotalAmountForPoi;

        /**
         * 平台活动补贴(含合作商、第三方)。
         */
        @JsonProperty("platformPayForPoiAmount")
        private Double platformPayForPoiAmount;

        /**
         * 商家费用合计=技术服务费+配送服务费（均摊）-配送服务费补贴（均摊）- 技术服务费补贴。
         */
        @JsonProperty("totalMerchantFees")
        private Double totalMerchantFees;

        /**
         * 技术服务费。
         */
        @JsonProperty("commisionAmount")
        private Double commisionAmount;

        /**
         * 技术服务费补贴。
         */
        @JsonProperty("techAllowanceAmount")
        private Double techAllowanceAmount;

        /**
         * 配送服务费收费(均摊后)。
         */
        @JsonProperty("agreementAmount")
        private Double agreementAmount;

        /**
         * 配送服务费补贴(均摊后)。
         */
        @JsonProperty("agreementAllowanceAmount")
        private Double agreementAllowanceAmount;

        /**
         * 结算金额(商家收入)。
         */
        @JsonProperty("settleAmount")
        private BigDecimal settleAmount;
    }
}
