package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「预订结果同步」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_f84503ae-994c-47ca-899b-2823bf201048">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationResultMessage {

    /**
     * 三方项目 ID（KTV为包房类型id），若第三方可通过服务名称识别，可不传。在products可根据partner_productid查询到相关信息。必填。
     */
    @JsonProperty("appProductId")
    private String appProductId;

    /**
     * 技术合作中心上的订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 项目名称，KTV必传。
     */
    @JsonProperty("productName")
    private String productName;

    /**
     * 格式如2016-05-24 12:00，数据精确到分钟，只支持整点和半点。必填。
     */
    @JsonProperty("beginTime")
    private String beginTime;

    /**
     * 预订的分钟数，一般半小时起订，如果不填，表示不在意预订时长。
     */
    @JsonProperty("duration")
    private String duration;

    /**
     * 格式如2016-05-24 12:00，数据精确到分钟。预订的结束时间。必填。
     */
    @JsonProperty("endTime")
    private String endTime;

    /**
     * 预订商品信息(不包含服务项目)。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("products")
    private Product products;

    /**
     * 预订用户的用户名。
     */
    @JsonProperty("userName")
    private String userName;

    /**
     * 用户性别，1-男，2-女。
     */
    @JsonProperty("userGender")
    private String userGender;

    /**
     * 预订用户的手机号码。必填。
     */
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 订单总价。
     */
    @JsonProperty("amount")
    private String amount;

    /**
     * 所在订单商家营销详情。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("orderShoppromoDetails")
    private OrderShoppromoDetails orderShoppromoDetails;

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
     * 预订渠道，1=三方平台渠道，2=美大平台渠道。必填。
     */
    @JsonProperty("bookChannel")
    private String bookChannel;

    /**
     * 预订结果，2-预订成功，3-预订失败。必填。
     */
    @JsonProperty("bookStatus")
    private String bookStatus;

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
     * 1-未婚，2-已婚。
     */
    @JsonProperty("married")
    private String married;

    /**
     * 美团服务项目 ID，适用于美团侧服务项目 ID 通信的业务。
     */
    @JsonProperty("productId")
    private String productId;

    /**
     * 业务类型（为了增加老代码增加）。
     */
    @JsonProperty("bizType")
    private String bizType;

    /**
     * 交易类型，枚举值，1-预订，2-团单，商家根据此属性字段识别交易类型，预订业务该字段非必传，团购后预约业务必传。
     */
    @JsonProperty("type")
    private String type;

    /**
     * 预订用户手机号，如果顾客开启隐私保护则是掩码手机号，未开启则是完整手机号。如需获取完整手机号，可通过用户虚拟号查询接口获取。
     */
    @JsonProperty("phone")
    private String phone;

    /**
     * 顾客是否选择号码隐私保护，1-开启隐私保护，0-未选择隐私保护。
     */
    @JsonProperty("useVirtualNumber")
    private String useVirtualNumber;

    /**
     * 手艺人Id。
     */
    @JsonProperty("techId")
    private String techId;

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
     * 预订商品信息(不包含服务项目)。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {

        /**
         * 第三方商品 ID。
         */
        @JsonProperty("app_product_id")
        private String appProductId;

        /**
         * 第三方sku_id（次卡时 为对应次卡关联团购所设置的skuid）。
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
         * 商品个数，默认为1。必填。
         */
        @JsonProperty("quantity")
        private Integer quantity;

        /**
         * 总金额。官网标注为 Decimal，示例为 {}，保留数值或对象。
         */
        @JsonProperty("amount")
        private JsonNode amount;

        /**
         * 商品说明信息，用于管道疏通类服务商模式和保洁类团单的加价信息。
         */
        @JsonProperty("desc")
        private String desc;

        /**
         * 商品类型， 0：普通团购 205：次卡。必填。
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
    }

    /**
     * 所在订单商家营销详情。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderShoppromoDetails {

        /**
         * 优惠金额。官网标注为 BigDecimal，示例为 {}，保留数值或对象。必填。
         */
        @JsonProperty("promo_amount")
        private JsonNode promoAmount;

        /**
         * 优惠类型，8-商家抵用券，16-美团商家红包，17-商家立减，18-美团商家立减，22-打折卡，2-基础券（包括联合营销券中的商家承担部分）。必填。
         */
        @JsonProperty("promo_type")
        private Integer promoType;

        /**
         * 说明信息。必填。
         */
        @JsonProperty("desc")
        private String desc;
    }
}
