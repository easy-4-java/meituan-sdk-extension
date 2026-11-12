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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收订单数据接口【必须】」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_0b380f3e-dd60-473e-9c0f-1addcbfc1a0e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderReceivedMessage {

    /**
     * 创建美团「接收订单数据接口【必须】」回调的业务内容。的空实例。
     */
    public OrderReceivedMessage() {
    }


    /**
     * 订单 ID，订单长度最少20位。必填。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 订单展示Id，用户下单时看到的订单号。必填。
     */
    @JsonProperty("orderIdView")
    private Long orderIdView;

    /**
     * 三方的门店Id，最大长度100。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 门店名称。
     */
    @JsonProperty("poiName")
    private String poiName;

    /**
     * 参考【7.3.1 根据订单Id查询订单】中的extras字段，由于赠送的菜品在外卖业务中是通过自定义文字的方式来处理的，所以可能无法直接按字段样式返回赠送菜品信息。
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
     * 脱敏收货人地址。字段默认内容“为保护顾客隐私，地址已隐藏”，参数后不再拼接「@#经纬度反查地址」。
     */
    @JsonProperty("recipientAddress")
    private String recipientAddress;

    /**
     * 脱敏收货人地址。字段默认内容“为保护顾客隐私，地址已隐藏”。
     */
    @JsonProperty("recipientAddressDesensitization")
    private String recipientAddressDesensitization;

    /**
     * 收货人电话。字段默认内容“***********”。
     */
    @JsonProperty("recipientPhone")
    private String recipientPhone;

    /**
     * 备份隐私号。该信息默认不推送，如有需求可联系技术合作中心工作人员开通。
     */
    @JsonProperty("backupRecipientPhone")
    private String backupRecipientPhone;

    /**
     * 收货人姓名。脱敏收货人名称。
     */
    @JsonProperty("recipientName")
    private String recipientName;

    /**
     * 配送费。原始未优惠的金额。
     */
    @JsonProperty("shippingFee")
    private BigDecimal shippingFee;

    /**
     * 订单总价。用户实际支付金额。
     */
    @JsonProperty("total")
    private BigDecimal total;

    /**
     * 订单原价。
     */
    @JsonProperty("originalPrice")
    private Double originalPrice;

    /**
     * 备注，去掉隐私号，去掉脱敏的真实号，去掉预订人手机号。
     */
    @JsonProperty("caution")
    private String caution;

    /**
     * 配送员电话。
     */
    @JsonProperty("shipperPhone")
    private String shipperPhone;

    /**
     * 订单状态。字段含义：1-用户已提交订单；2-用户支付完成，待商家接单；4-商家已确认；6-已配送；8-已完成；9-已取消。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 城市Id，目前暂时用不到此信息。
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
     * 订单创建时间，unix_timestamp。
     */
    @JsonProperty("ctime")
    private Long ctime;

    /**
     * 订单更新时间。
     */
    @JsonProperty("utime")
    private Long utime;

    /**
     * 用户预计送达时间。即用户选择或填写的预计送达时间。“立即送达”时为0。单位:秒, 如取餐类型为到店自取，则该时间为用户自选的到店自取时间。
     */
    @JsonProperty("deliveryTime")
    private Long deliveryTime;

    /**
     * 预计送达时间。即时单：字段值为配送系统提供的预计送达时间。 到店自取单：字段值为用户到店取餐时间。 预订单：字段值为用户下单时填写的预计送达时间。
     *  该信息默认不推送，如有需求可联系技术合作中心工作人员开通。
     */
    @JsonProperty("estimateArrivalTime")
    private Long estimateArrivalTime;

    /**
     * 是否第三方配送，0-否，1-是。
     */
    @JsonProperty("isThirdShipping")
    private Integer isThirdShipping;

    /**
     * 支付类型。1：货到付款；2：在线支付。
     */
    @JsonProperty("payType")
    private Integer payType;

    /**
     * 实际送餐地址纬度。字段默认内容“0.0”。
     */
    @JsonProperty("latitude")
    private Double latitude;

    /**
     * 实际送餐地址经度。字段默认内容“0.0”。
     */
    @JsonProperty("longitude")
    private Double longitude;

    /**
     * 门店当天的订单流水号，每天流水号从1开始。
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
     * 用餐人数。用餐人数（0：用户没有选择用餐人数；1-10：用户选择的用餐人数；-10：10人以上用餐；88：用户需要餐具；99：用户不需要餐具），
     * 该信息默认不推送，如有需求可在开发者中心订阅。
     */
    @JsonProperty("dinnersNumber")
    private Integer dinnersNumber;

    /**
     * 配送方式码。请查看《补充相关字段说明》。
     */
    @JsonProperty("logisticsCode")
    private Integer logisticsCode;

    /**
     * 外卖门店 ID。
     */
    @JsonProperty("poiId")
    private Long poiId;

    /**
     * 取餐类型。0：普通取餐；1：到店取餐 该信息默认不推送，如有需求可联系技术合作中心工作人员开通。
     */
    @JsonProperty("pickType")
    private Integer pickType;

    /**
     * 开票方式，1：美团发票合作商家，且在线自动开具电子发票，0：非美团发票合作商家。
     */
    @JsonProperty("InvMakeType")
    private Integer invMakeType;

    /**
     * 订单业务打标枚举，即业务身份。16-拼好饭场景订单，19-团餐场景订单。json字符串格式的数组，例："[16]"。
     */
    @JsonProperty("orderTagList")
    private String orderTagList;

    /**
     * 降级标识。订单数据状态标记。当订单中部分字段的数据因内部交互异常或网络等原因延迟生成（超时），导致开发者当前获取的订单数据不完整，
     * 此时技术合作中心对订单数据缺失情况进行标记。如不完整，建议尝试重新查询。注意，
     * 技术合作中心仅对部分模块的数据完整性进行监察标记（参考incmp_modules字段）。参考值： -1：有数据降级 0：无数据降级。
     */
    @JsonProperty("incmpCode")
    private Integer incmpCode;

    /**
     * 降级模块。有降级的数据模块的集合，
     * 参考值： 0：订单商品详情 1：订单优惠信息 2：商品优惠详情 3：订单用户会员信息 4：订单维度的商家对账信息 5：订单维度的商家对账信息(元) 6：订单收货人地址 7：订单配送方式 8：技术合作中心用户 ID 9：部分退款商品信息 10：退货退款物流信息 11：部分订单基本信息(包括订单优惠信息、订单商品详情、门店信息等) 12：sku信息 13：spu信息 14：商品信息(可能是sku或spu等商品相关信息获取时降级)。
     */
    @JsonProperty("incmpModules")
    private List<Integer> incmpModules;

    /**
     * 标识订单是否为团餐定制菜单，1：团餐定制菜单；0或空：外卖菜单。
     */
    @JsonProperty("orderEntranceType")
    private Integer orderEntranceType;

    /**
     * 拼好饭一起送的订单信息。PhfOrderExtraData{ PhfOrderExtraInfo curOrderInfo（当前订单信息） List groupOrders // 团单订单信息（主子单都在） } 其中PhfOrderExtraInfo{ long wmOrderViewId // 订单展示 ID long orderType // 订单类型 主单/子单 String dayNo // 订单每日序号 }。
     */
    @JsonProperty("phfOrderExtraData")
    private String phfOrderExtraData;

    /**
     * 收餐地址行政区域。
     */
    @JsonProperty("addressOfReceivingAdministrative")
    private String addressOfReceivingAdministrative;

    /**
     * 打包费模式。0按照商品餐盒费收取，1按照订单总价收取，2按照订单口袋收取。
     */
    @JsonProperty("packageBagMode")
    private Integer packageBagMode;

    /**
     * 打包费金额。
     */
    @JsonProperty("packageBagFee")
    private BigDecimal packageBagFee;

    /**
     * 口袋打包费明细。口袋 ID：cart_id（int） 原打包费：original_package_bag_fee（double）。
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
     * 商家应收款。
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
     * 小票推广信息。
     */
    @JsonProperty("easterEggText")
    private String easterEggText;

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
     * 闪电送订单标识，1-是闪电送，0-不是闪电送。
     */
    @JsonProperty("speedyOrderTag")
    private Integer speedyOrderTag;

    /**
     * 顾客预先支付。
     */
    @JsonProperty("consumerPrepays")
    private String consumerPrepays;

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
         * 创建商家对账详情。的空实例。
         */
        public PoiReceiveDetail() {
        }


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
         * 用户支付的1对1急送加速费，单位分。
         */
        @JsonProperty("userPay1v1DeliveryFee")
        private Long userPay1v1DeliveryFee;

        /**
         * 商家应收款，单位分。
         */
        @JsonProperty("wmPoiReceiveCent")
        private Long wmPoiReceiveCent;

        /**
         * 在线支付金额，单位分。
         */
        @JsonProperty("onlinePayment")
        private Long onlinePayment;
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
         * 创建参考【7.3.1 根据订单Id查询订单】中的detail。的空实例。
         */
        public Detail() {
        }


        /**
         * 餐盒数量。
         */
        @JsonProperty("box_num")
        private Float boxNum;

        /**
         * 餐盒价格。
         */
        @JsonProperty("box_price")
        private Float boxPrice;

        /**
         * 商品规格 ID。
         */
        @JsonProperty("sku_id")
        private String skuId;
    }
}
