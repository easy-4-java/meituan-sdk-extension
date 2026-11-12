package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收订单完成消息接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210007}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_ba98bf52-d204-4ba4-96c0-5062da15547a">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCompletedMessage {

    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 订单展示Id。必填。
     */
    @JsonProperty("orderIdView")
    private Long orderIdView;

    /**
     * 三方的门店Id。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 门店名称。必填。
     */
    @JsonProperty("poiName")
    private String poiName;

    /**
     * 订单额外信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("extras")
    private JsonNode extras;

    /**
     * 门店地址。
     */
    @JsonProperty("poiAddress")
    private String poiAddress;

    /**
     * 商家电话。
     */
    @JsonProperty("poiPhone")
    private String poiPhone;

    /**
     * 脱敏收货人地址。
     */
    @JsonProperty("recipientAddress")
    private String recipientAddress;

    /**
     * 脱敏收货人地址。
     */
    @JsonProperty("recipientAddressDesensitization")
    private String recipientAddressDesensitization;

    /**
     * 收货人电话。
     */
    @JsonProperty("recipientPhone")
    private String recipientPhone;

    /**
     * 备份隐私号。
     */
    @JsonProperty("backupRecipientPhone")
    private String backupRecipientPhone;

    /**
     * 收货人姓名。
     */
    @JsonProperty("recipientName")
    private String recipientName;

    /**
     * 配送费。
     */
    @JsonProperty("shippingFee")
    private Double shippingFee;

    /**
     * 订单总价。
     */
    @JsonProperty("total")
    private Double total;

    /**
     * 订单原价。
     */
    @JsonProperty("originalPrice")
    private Double originalPrice;

    /**
     * 备注。
     */
    @JsonProperty("caution")
    private String caution;

    /**
     * 配送员电话。
     */
    @JsonProperty("shipperPhone")
    private String shipperPhone;

    /**
     * 订单状态。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 城市Id。
     */
    @JsonProperty("cityId")
    private Long cityId;

    /**
     * 是否需要发票。0-不需要， 1-需要。
     */
    @JsonProperty("hasInvoiced")
    private Integer hasInvoiced;

    /**
     * 发票抬头。
     */
    @JsonProperty("invoiceTitle")
    private String invoiceTitle;

    /**
     * 发票税号。
     */
    @JsonProperty("taxpayerId")
    private String taxpayerId;

    /**
     * 订单创建时间。
     */
    @JsonProperty("ctime")
    private Long ctime;

    /**
     * 订单更新时间。
     */
    @JsonProperty("utime")
    private Long utime;

    /**
     * 用户预计送达时间。即用户选择或填写的预计送达时间。“立即送达”时为0。
     */
    @JsonProperty("deliveryTime")
    private Long deliveryTime;

    /**
     * 预计送达时间。
     */
    @JsonProperty("estimateArrivalTime")
    private Long estimateArrivalTime;

    /**
     * 是否第三方配送，0-否，1-是。
     */
    @JsonProperty("isThirdShipping")
    private Integer isThirdShipping;

    /**
     * 支付类型。
     */
    @JsonProperty("payType")
    private Integer payType;

    /**
     * 实际送餐地址纬度。
     */
    @JsonProperty("latitude")
    private Double latitude;

    /**
     * 实际送餐地址经度。
     */
    @JsonProperty("longitude")
    private Double longitude;

    /**
     * 门店当天的订单流水号。
     */
    @JsonProperty("daySeq")
    private String daySeq;

    /**
     * 用户是否收藏此门店。
     */
    @JsonProperty("isFavorites")
    private Boolean isFavorites;

    /**
     * 用户是否第一次在此门店点餐。
     */
    @JsonProperty("isPoiFirstOrder")
    private Boolean isPoiFirstOrder;

    /**
     * 商家对账详情。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("poiReceiveDetail")
    private PoiReceiveDetail poiReceiveDetail;

    /**
     * 参考【7.3.1 根据订单Id查询订单】中的detail。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("detail")
    private List<Detail> detail;

    /**
     * 餐厅平均送餐时间，单位为秒。
     */
    @JsonProperty("avgSendTime")
    private Float avgSendTime;

    /**
     * 用餐人数。
     */
    @JsonProperty("dinnersNumber")
    private Integer dinnersNumber;

    /**
     * 配送方式码。
     */
    @JsonProperty("logisticsCode")
    private Integer logisticsCode;

    /**
     * 外卖门店 ID。
     */
    @JsonProperty("poiId")
    private Long poiId;

    /**
     * 取餐类型。
     */
    @JsonProperty("pickType")
    private Integer pickType;

    /**
     * 开票方式，1：美团发票合作商家，且在线自动开具电子发票，0：非美团发票合作商家。
     */
    @JsonProperty("InvMakeType")
    private Integer invMakeType;

    /**
     * 订单业务打标枚举，即业务身份。16-拼好饭场景订单，19-团餐场景订单。
     */
    @JsonProperty("orderTagList")
    private String orderTagList;

    /**
     * 降级标识。
     */
    @JsonProperty("incmpCode")
    private Integer incmpCode;

    /**
     * 降级模块。
     */
    @JsonProperty("incmpModules")
    private String incmpModules;

    /**
     * 标识订单是否为团餐定制菜单。
     */
    @JsonProperty("orderEntranceType")
    private Integer orderEntranceType;

    /**
     * 拼好饭一起送的订单信息。
     */
    @JsonProperty("phfOrderExtraData")
    private String phfOrderExtraData;

    /**
     * 收餐地址行政区域。
     */
    @JsonProperty("addressOfReceivingAdministrative")
    private String addressOfReceivingAdministrative;

    /**
     * 打包费模式。
     */
    @JsonProperty("packageBagMode")
    private Integer packageBagMode;

    /**
     * 打包费金额。
     */
    @JsonProperty("packageBagFee")
    private BigDecimal packageBagFee;

    /**
     * 口袋打包费明细。
     */
    @JsonProperty("packageBagCartDetail")
    private String packageBagCartDetail;

    /**
     * 出餐考核时间。
     */
    @JsonProperty("poiMealAssessmentTime")
    private Long poiMealAssessmentTime;

    /**
     * 是否是商企通订单 1是商企通订单 2非商企通 0降级。
     */
    @JsonProperty("sqtOrder")
    private Integer sqtOrder;

    /**
     * 是否需要开发票 1需要开发票 2无需开发票 0降级。
     */
    @JsonProperty("sqtNeedInvoice")
    private Integer sqtNeedInvoice;

    /**
     * 赠品信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("giftInfo")
    private JsonNode giftInfo;

    /**
     * 商家应收金额。
     */
    @JsonProperty("wmPoiReceiveCent")
    private Long wmPoiReceiveCent;

    /**
     * 美团跑腿订单聚合平台可发配送状态，当前返回值只有0，收到此推送时商家可对当前订单发起配送。 0：可发配送。必填。
     */
    @JsonProperty("deliveryAvailable")
    private Integer deliveryAvailable;

    /**
     * 拼好饭春节服务费，单位为：元。
     */
    @JsonProperty("phfSsf")
    private Float phfSsf;

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
     * 订单预计送达时间区间的左端点，只有该字段不为空且大于0时才有效。
     */
    @JsonProperty("estimateArrivalTimeLeft")
    private Integer estimateArrivalTimeLeft;

    /**
     * 订单预计送达时间区间的右端点，只有该字段不为空且大于0时才有效。
     */
    @JsonProperty("estimateArrivalTimeRight")
    private Integer estimateArrivalTimeRight;

    /**
     * 订单的实际配送类型，在未发配时为0。1-美配，2-自配，0-未知类型。必填。
     */
    @JsonProperty("actualLogisticsType")
    private Integer actualLogisticsType;

    /**
     * 订单的预估配送类型，可能与实际配送类型不同。1-美配，2-自配，0-未知类型。必填。
     */
    @JsonProperty("preLogisticsType")
    private Integer preLogisticsType;

    /**
     * 门店纬度。
     */
    @JsonProperty("poiLatitude")
    private Double poiLatitude;

    /**
     * 门店经度。
     */
    @JsonProperty("poiLongitude")
    private Double poiLongitude;

    /**
     * 商家对账详情。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiReceiveDetail {

        /**
         * 美团承担明细。
         */
        @JsonProperty("actOrderChargeByMt")
        private List<ActOrderChargeByMt> actOrderChargeByMt;

        /**
         * 商家承担明细。
         */
        @JsonProperty("actOrderChargeByPoi")
        private List<ActOrderChargeByPoi> actOrderChargeByPoi;

        /**
         * 菜品分成 (分)。
         */
        @JsonProperty("foodShareFeeChargeByPoi")
        private Integer foodShareFeeChargeByPoi;

        /**
         * 用户实际支付配送费 (分)。
         */
        @JsonProperty("logisticsFee")
        private Integer logisticsFee;

        /**
         * 拓展字段，单位为元。具体属性需要根据费率模式判断。
         */
        @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
        @JsonProperty("reconciliationExtras")
        private JsonNode reconciliationExtras;

        /**
         * 地址变更费，单位：分。
         */
        @JsonProperty("modifyAddressFee")
        private Double modifyAddressFee;
    }

    /**
     * 参考【7.3.1 根据订单Id查询订单】中的detail。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detail {

        /**
         * 餐盒数量。
         */
        @JsonProperty("box_num")
        private Float boxNum;

        /**
         * 餐盒单价。
         */
        @JsonProperty("box_price")
        private BigDecimal boxPrice;

        /**
         * ERP方菜品sku。
         */
        @JsonProperty("sku_id")
        private String skuId;
    }
}
