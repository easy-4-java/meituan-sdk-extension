package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「开始预订」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810017}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_c08eb5f3-ba98-4c97-8579-7d95757df2b4">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationStartedMessage {

    /**
     * 技术合作中心订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 三方项目 ID（KTV为包房类型id），若三方可通过服务名称识别，可不传。在products可根据app_product_id查询到相关信息。必填。
     */
    @JsonProperty("appProductId")
    private String appProductId;

    /**
     * 美团侧服务项目 ID，适用于适用美团侧服务项目 ID 通信的业务。
     */
    @JsonProperty("productId")
    private String productId;

    /**
     * 项目名称。
     */
    @JsonProperty("productName")
    private String productName;

    /**
     * 格式如2016-05-24 12:00 ，数据精确到分钟，只支持整点和半点。必填。
     */
    @JsonProperty("begintime")
    private String begintime;

    /**
     * 预订的分钟数，一般半小时起订，如果不填，表示不在意预订时长。
     */
    @JsonProperty("duration")
    private String duration;

    /**
     * 格式如 2016-05-24 12:00 ，数据精确到分钟。预订的结束时间。必填。
     */
    @JsonProperty("endtime")
    private String endtime;

    /**
     * 预订商品信息(不包含服务项目)，单个商品的数据结构查看下文的product说明。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("products")
    private List<Product> products;

    /**
     * 预订用户的用户名。
     */
    @JsonProperty("userName")
    private String userName;

    /**
     * 用户性别，1-男 2-女。
     */
    @JsonProperty("userGender")
    private String userGender;

    /**
     * 预订用户的手机号码(出于对用户隐私的保护，后续该字段会废弃，对接时请使用phone字段)。必填。
     */
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 三方时段 ID。
     */
    @JsonProperty("appPeriodId")
    private String appPeriodId;

    /**
     * 用户年龄。
     */
    @JsonProperty("userAge")
    private String userAge;

    /**
     * 身份证号。
     */
    @JsonProperty("identityNum")
    private String identityNum;

    /**
     * 收费模式，1-按项目收费，2-按人头收费。
     */
    @JsonProperty("chargeMode")
    private String chargeMode;

    /**
     * 1-未婚，2-已婚。
     */
    @JsonProperty("married")
    private String married;

    /**
     * 订单总价，不刨除任何优惠信息。
     */
    @JsonProperty("amount")
    private String amount;

    /**
     * 所在订单商家营销详情。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("orderShoppromoDetails")
    private List<OrderShoppromoDetailsItem> orderShoppromoDetails;

    /**
     * 预订份数，默认为1。必填。
     */
    @JsonProperty("quantity")
    private String quantity;

    /**
     * 用户备注信息。
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * 业务类型（为了兼容老代码增加的）。
     */
    @JsonProperty("bizType")
    private String bizType;

    /**
     * 订单关联服务项目，格式为json数组，见related_service_item。
     */
    @JsonProperty("relatedServiceItem")
    private List<RelatedServiceItemItem> relatedServiceItem;

    /**
     * 用户上门地址(取件地址)，格式为json，见address。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("userAddress")
    private UserAddressDetails userAddress;

    /**
     * 生活服务行业新增字段，其他行业不传交易类型，枚举值：1-预订，2-团单（团购后预约），3-服务商商家根据此属性字段识别交易类型，预订业务该字段非必传，团购后预约业务必传。
     */
    @JsonProperty("type")
    private String type;

    /**
     * 送件地址，格式为json，见address。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("deliveryAddress")
    private DeliveryAddressDetails deliveryAddress;

    /**
     * 预订用户手机号，如果用户开启隐私保护则是掩码手机号，未开启则是完整手机号。如需获取完整手机号，可通过用户虚拟号查询接口进行获取。
     */
    @JsonProperty("phone")
    private String phone;

    /**
     * 顾客是否选择隐私保护。1:开启隐私保护 0:未选择隐私保护。
     */
    @JsonProperty("useVirtualNumber")
    private String useVirtualNumber;

    /**
     * 是否锁券：家政洗涤行业需要锁定券直到用户点击服务完成，维修行业不锁券。
     */
    @JsonProperty("lockReceipt")
    private String lockReceipt;

    /**
     * 下单平台（mt/dp）。
     */
    @JsonProperty("platform")
    private String platform;

    /**
     * 接单类型：1是自动接单 2是手动接单。
     */
    @JsonProperty("acceptType")
    private String acceptType;

    /**
     * 手艺人Id。
     */
    @JsonProperty("techId")
    private String techId;

    /**
     * 服务费。
     */
    @JsonProperty("serviceFee")
    private String serviceFee;

    /**
     * 套餐明细（酒吧预订行业使用）。
     */
    @JsonProperty("resourceInfo")
    private String resourceInfo;

    /**
     * 订单备注。
     */
    @JsonProperty("orderRemark")
    private String orderRemark;

    /**
     * 三方订单 ID。
     */
    @JsonProperty("thirdPartyOrderId")
    private String thirdPartyOrderId;

    /**
     * 退款类型，1-阶梯退。
     */
    @JsonProperty("refundType")
    private String refundType;

    /**
     * 是否为续时子订单,0-否，1-是；
     */
    @JsonProperty("isSubOrder")
    private String isSubOrder;

    /**
     * 关联的主订单 ID。
     */
    @JsonProperty("relatedMasterOrderId")
    private String relatedMasterOrderId;

    /**
     * 预订商品信息(不包含服务项目)，单个商品的数据结构查看下文的product说明。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {

        /**
         * 三方商品 ID。
         */
        @JsonProperty("app_product_id")
        private String appProductId;

        /**
         * 三方sku_id（次卡时 为对应次卡关联团购所设置的skuid）。
         */
        @JsonProperty("app_sku_id")
        private String appSkuId;

        /**
         * 美团侧商品 ID。
         */
        @JsonProperty("product_id")
        private Long productId;

        /**
         * 美团侧商品sku_id。
         */
        @JsonProperty("sku_id")
        private String skuId;

        /**
         * 商品个数，默认为1。
         */
        @JsonProperty("quantity")
        private Integer quantity;

        /**
         * 总金额。
         */
        @JsonProperty("amount")
        private String amount;

        /**
         * 商品说明信息，用于管道疏通类服务商模式和保洁类团单的加价信息。
         */
        @JsonProperty("desc")
        private String desc;

        /**
         * 商品类型，0-普通团购，205-次卡。
         */
        @JsonProperty("product_type")
        private Integer productType;

        /**
         * 次卡关联的团购项目 ID。
         */
        @JsonProperty("related_product")
        private String relatedProduct;

        /**
         * 次卡总计服务次数。
         */
        @JsonProperty("card_total_number")
        private Integer cardTotalNumber;

        /**
         * 次卡本次消费的服务次数。
         */
        @JsonProperty("card_consumption_number")
        private Integer cardConsumptionNumber;

        /**
         * 次卡剩余的可消费次数。
         */
        @JsonProperty("card_remain_number")
        private Integer cardRemainNumber;

        /**
         * 用户指定的优先服务人员 ID，在美团侧通过接口生成的服务人员 ID，无特殊指定为0。
         */
        @JsonProperty("adv_service_techId")
        private String advServiceTechId;

        /**
         * 当前预约属于周期性预约时会传该 ID，同属于一个周期预约的预约该 ID 相同。
         */
        @JsonProperty("period_orderId")
        private String periodOrderId;

        /**
         * 平台统一订单 ID。
         */
        @JsonProperty("uni_order_id")
        private String uniOrderId;

        /**
         * 商品名称。
         */
        @JsonProperty("product_name")
        private String productName;
    }

    /**
     * 所在订单商家营销详情。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderShoppromoDetailsItem {

        /**
         * 优惠类型，8-商家抵用券，16-美团商家红包，17-商家立减，18-美团商家立减，22-打折卡，2-基础券（包括联合营销券中的商家承担部分）。必填。
         */
        @JsonProperty("promo_type")
        private Integer promoType;

        /**
         * 优惠金额。必填。
         */
        @JsonProperty("promo_amount")
        private String promoAmount;

        /**
         * 说明信息。
         */
        @JsonProperty("desc")
        private String desc;
    }

    /**
     * 订单关联服务项目，格式为json数组，见related_service_item。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RelatedServiceItemItem {

        /**
         * 商品单价。
         */
        @JsonProperty("price")
        private String price;

        /**
         * 商品个数，默认为1。
         */
        @JsonProperty("quantity")
        private Integer quantity;

        /**
         * 美团侧商品skuId。
         */
        @JsonProperty("sku_id")
        private String skuId;

        /**
         * 第三方sku_id。
         */
        @JsonProperty("app_sku_id")
        private String appSkuId;

        /**
         * 三方商品 ID。
         */
        @JsonProperty("app_product_id")
        private String appProductId;
    }

    /**
     * 用户上门地址(取件地址)，格式为json，见address。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserAddressDetails {

        /**
         * 上门联系用户名称 receiver_mobile 上门联系用户电话(出于对用户隐私的保护，后续该字段会废弃，
         * 对接时请使用receiver_phone字段) receiver_phone 上门联系用户电话，如果用户开启隐私保护则是掩码手机号，
         * 未开启则是完整手机号。 如需获取完整手机号，可通过用户虚拟号查询接口进行获取。
         */
        @JsonProperty("receiver_name")
        private String receiverName;

        /**
         * 地址。
         */
        @JsonProperty("receiver_address")
        private String receiverAddress;

        /**
         * 地址备注。
         */
        @JsonProperty("remark")
        private String remark;

        /**
         * 纬度(火星坐标系)。
         */
        @JsonProperty("latitude")
        private String latitude;

        /**
         * 顾客是否选择隐私保护。1:开启隐私保护 0:未选择隐私保护。
         */
        @JsonProperty("use_receiver_virtual_number")
        private String useReceiverVirtualNumber;

        /**
         * 经度(火星坐标系)。
         */
        @JsonProperty("longitude")
        private String longitude;

        /**
         * 上门联系用户电话(出于对用户隐私的保护，后续该字段会废弃，对接时请使用receiver_phone字段)。
         */
        @JsonProperty("receiver_mobile")
        private String receiverMobile;

        /**
         * 上门联系用户电话，如果用户开启隐私保护则是掩码手机号，未开启则是完整手机号。 如需获取完整手机号，可通过用户虚拟号查询接口进行获取。
         */
        @JsonProperty("receiver_phone")
        private String receiverPhone;
    }

    /**
     * 送件地址，格式为json，见address。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeliveryAddressDetails {

        /**
         * 上门联系用户名称 receiver_mobile 上门联系用户电话(出于对用户隐私的保护，后续该字段会废弃，
         * 对接时请使用receiver_phone字段) receiver_phone 上门联系用户电话，如果用户开启隐私保护则是掩码手机号，
         * 未开启则是完整手机号。 如需获取完整手机号，可通过用户虚拟号查询接口进行获取。
         */
        @JsonProperty("receiver_name")
        private String receiverName;

        /**
         * 地址。
         */
        @JsonProperty("receiver_address")
        private String receiverAddress;

        /**
         * 地址备注。
         */
        @JsonProperty("remark")
        private String remark;

        /**
         * 纬度(火星坐标系)。
         */
        @JsonProperty("latitude")
        private String latitude;

        /**
         * 顾客是否选择隐私保护。1:开启隐私保护 0:未选择隐私保护。
         */
        @JsonProperty("use_receiver_virtual_number")
        private String useReceiverVirtualNumber;

        /**
         * 经度(火星坐标系)。
         */
        @JsonProperty("longitude")
        private String longitude;

        /**
         * 上门联系用户电话(出于对用户隐私的保护，后续该字段会废弃，对接时请使用receiver_phone字段)。
         */
        @JsonProperty("receiver_mobile")
        private String receiverMobile;

        /**
         * 上门联系用户电话，如果用户开启隐私保护则是掩码手机号，未开启则是完整手机号。 如需获取完整手机号，可通过用户虚拟号查询接口进行获取。
         */
        @JsonProperty("receiver_phone")
        private String receiverPhone;
    }
}
