package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收商家转自配成功消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=46}，消息类型为 {@code msgType=4610026}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_dcps_73535482-f538-43e6-9b11-b18a4535e484">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelfDeliveryTransferSucceededMessage {

    /**
     * 创建美团「接收商家转自配成功消息」回调的业务内容。的空实例。
     */
    public SelfDeliveryTransferSucceededMessage() {
    }


    /**
     * 门店名称。
     */
    @JsonProperty("poiName")
    private String poiName;

    /**
     * 预约单Id。
     */
    @JsonProperty("bookingOrderId")
    private Long bookingOrderId;

    /**
     * 订单展示Id，用户看到的团购订单Id。多券场景推送的是配送订单 ID。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 城市Id，目前暂时用不到此信息。
     */
    @JsonProperty("cityId")
    private Long cityId;

    /**
     * 创建时间，毫秒时间戳。
     */
    @JsonProperty("createTime")
    private Long createTime;

    /**
     * 更新时间，毫秒时间戳。
     */
    @JsonProperty("updateTime")
    private Long updateTime;

    /**
     * 门店当天的订单流水号，取餐号。
     */
    @JsonProperty("serialNumber")
    private String serialNumber;

    /**
     * 交付类型，1-配送；2-电商；3-自提（目前仅面包蛋糕门店和少量测试门店有自提功能）。
     */
    @JsonProperty("deliveryPattern")
    private Integer deliveryPattern;

    /**
     * 预计送达时间，毫秒时间戳。预约单场景下，该时间戳为用户选择的送达时间。
     */
    @JsonProperty("deliveryTime")
    private Long deliveryTime;

    /**
     * 收货人姓名，仅配送订单有，自提订单无收货人姓名。
     */
    @JsonProperty("consignee")
    private String consignee;

    /**
     * 用户手机尾号，真实手机尾号后四位。
     */
    @JsonProperty("consigneePhoneTailNumber")
    private String consigneePhoneTailNumber;

    /**
     * 是否隐私号。
     */
    @JsonProperty("isPrivacyNumber")
    private Boolean isPrivacyNumber;

    /**
     * 收货人电话。注：该电话可能为隐私号，可通过isPrivacyNumber字段判断。
     */
    @JsonProperty("consigneePhone")
    private String consigneePhone;

    /**
     * 订购人电话，适用于为他人订购商品的场景，如果商家联系不上收货人，可以联系订购人。目前仅蛋糕品类支持下单时填写订购人电话，非必填，可能为空。
     * 注：该电话可能为隐私号，可通过isPrivacyNumber字段判断。
     */
    @JsonProperty("buyerPhoneNumber")
    private String buyerPhoneNumber;

    /**
     * 配送地址纬度。
     */
    @JsonProperty("latitude")
    private Double latitude;

    /**
     * 配送地址经度。
     */
    @JsonProperty("longitude")
    private Double longitude;

    /**
     * 收货地址省。
     */
    @JsonProperty("provinceName")
    private String provinceName;

    /**
     * 收货地址市。
     */
    @JsonProperty("cityName")
    private String cityName;

    /**
     * 收货地址区。
     */
    @JsonProperty("districtName")
    private String districtName;

    /**
     * 收货人地址。
     */
    @JsonProperty("consigneeAddress")
    private String consigneeAddress;

    /**
     * 用餐人数，餐具数量，可以是12345，也可以是“依餐量提供”。
     */
    @JsonProperty("wareCount")
    private String wareCount;

    /**
     * 备注。
     */
    @JsonProperty("caution")
    private String caution;

    /**
     * 套餐相关信息，注：该模型未来会替换调下面的这些deal信息。
     */
    @JsonProperty("dealData")
    private List<DealData> dealData;

    /**
     * 团购名称，注：未来该字段废弃。
     */
    @JsonProperty("dealName")
    private String dealName;

    /**
     * 套餐 ID，注意不是两个大写的I，是deal 、id，i大写。注：未来该字段会废弃。
     */
    @JsonProperty("dealId")
    private String dealId;

    /**
     * 套餐图片，注：未来该字段会废弃。
     */
    @JsonProperty("dealImgUrl")
    private String dealImgUrl;

    /**
     * 团购券 ID，注：未来该字段会废弃。
     */
    @JsonProperty("couponCode")
    private String couponCode;

    /**
     * 菜品份数，注：未来该字段会废弃。
     */
    @JsonProperty("quantity")
    private String quantity;

    /**
     * 菜品详情，注：未来该字段会废弃。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("details")
    private List<GroupDeal> details;

    /**
     * 订单类型，4=实时单；5=预约单 历史数据默认type=4。
     */
    @JsonProperty("orderDeliveryType")
    private Integer orderDeliveryType;

    /**
     * 预订单信息，仅在orderDeliveryType=5时有值，其他情况为0 1-营业时间预订单 2-非营业时间预订单。
     */
    @JsonProperty("advanceType")
    private Integer advanceType;

    /**
     * 订单原价，套餐价格，单位元 注：后期该字段会废弃，新接入厂商可使用BillData.unitPrice字段。
     */
    @JsonProperty("originalPrice")
    private BigDecimal originalPrice;

    /**
     * 配送费，商家+用户，单位元 注：后期该字段会废弃，
     * 商家承担部分的配送费为BillData.merchantDeliveryFee + BillData.deliveryReductionFee。
     * 该和与当前的shippingFee不一致。
     */
    @JsonProperty("shippingFee")
    private Double shippingFee;

    /**
     * 支付金额，用户实际支付金额，单位元。
     */
    @JsonProperty("payFee")
    private BigDecimal payFee;

    /**
     * 订单操作相关信息。
     */
    @JsonAlias("OrderOperationData")
    @JsonProperty("orderOperationData")
    private OrderOperationData orderOperationData;

    /**
     * 配送相关信息。
     */
    @JsonAlias("DeliveryData")
    @JsonProperty("deliveryData")
    private DeliveryData deliveryData;

    /**
     * 退款相关信息。
     */
    @JsonAlias("RefundData")
    @JsonProperty("refundData")
    private RefundData refundData;

    /**
     * 订单相关资金信息。
     */
    @JsonAlias("BillData")
    @JsonProperty("billData")
    private BillData billData;

    /**
     * 菜品详情，注：未来该字段会废弃。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GroupDeal {

        /**
         * 创建菜品详情，注：未来该字段会废弃。的空实例。
         */
        public GroupDeal() {
        }


        /**
         * 当前菜品组，若商家上单配置了菜品组，则存在该字段。
         */
        @JsonProperty("groupName")
        private String groupName;

        /**
         * 第三方套餐id,仅套餐通过三方系统上单录入时有值。
         */
        @JsonProperty("thirdProductId")
        private String thirdProductId;

        /**
         * 菜品明细。
         */
        @JsonProperty("foodDetails")
        private List<FoodDetail> foodDetails;

        /**
         * 分组名称。
         */
        @JsonProperty("groupNam")
        private String groupNam;
    }
}
