package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「创单同步三方接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910015}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_70680584-cd1b-471f-aac6-d4d9bfbba5a9">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationCreateSyncMessage {

    /**
     * 预约单 ID。必填。
     */
    @JsonProperty("leadsId")
    private String leadsId;
    /**
     * 门店 ID。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;
    /**
     * 预约电话。必填。
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 状态：0：初始化 1：已接单 3：待接单 注： 1）当状态为0的时候仅传递商品信息和电话号码，
     * 商户可以基于状态为0的订单进行商家创建预约单操作 2）当状态为1的时候为自动接单预约单，返回成功即创单成功 3）当状态为3的时候为手动接单预约单，
     * 返回成功仅代表成功接收预约请求，需要调用创单回调接口返回接单结果（接单/拒单）。必填。
     */
    @JsonProperty("status")
    private String status;
    /**
     * 联系方式 （体检业务无需关注）。
     */
    @JsonProperty("otherContact")
    private String otherContact;
    /**
     * 联系方式类型 （体检业务无需关注）。
     */
    @JsonProperty("otherContactType")
    private String otherContactType;
    /**
     * 来源 ID （接口业务参数，无需关注）。必填。
     */
    @JsonProperty("bizSourceId")
    private String bizSourceId;
    /**
     * 预约时间（毫秒数）。必填。
     */
    @JsonProperty("bookingTime")
    private String bookingTime;
    /**
     * 预约个数。必填。
     */
    @JsonProperty("count")
    private String count;
    /**
     * 预约结束时间（毫秒数）（体检业务无需关注）。必填。
     */
    @JsonProperty("bookingEndTime")
    private String bookingEndTime;
    /**
     * 商家备注。
     */
    @JsonProperty("merchantRemark")
    private String merchantRemark;
    /**
     * 订单关联 ID 列表（jsonarray 字符串）。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("leadsReferList")
    private LeadsReferListDetails leadsReferList;
    /**
     * 订单属性map。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("leadsAttributeList")
    private HashMap leadsAttributeList;
    /**
     * 用户备注。
     */
    @JsonProperty("userRemark")
    private String userRemark;
    /**
     * 用户姓名 （预留字段，无需关注）。
     */
    @JsonProperty("userName")
    private String userName;
    /**
     * 扩展属性。
     */
    @JsonProperty("extraMap")
    private String extraMap;

    /**
     * 创建美团「创单同步三方接口」回调的业务内容。的空实例。
     */
    public ReservationCreateSyncMessage() {
    }

    /**
     * 订单关联 ID 列表（jsonarray 字符串）。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LeadsReferListDetails {

        /**
         * 关联 ID 类型 36：美团统一交易订单 ID 12：美团团购 ID 44：美团券码 45：体检标品 46：orderID（团检订单ID） 47：卡号（三方发券需要） 48：卡密（三方发券需要，
         * 不加密） 50：spuId（标品ID） 51：三方商品 ID C 端个检商家发券返回：36美团统一交易订单 ID、51三方商品 ID、47卡号、48卡密 C 端个检平台发券返回：36美团统一交易订单 ID、12美团团购 ID、44美团券码 团检返回：45体检标品、46 orderID、50 spuId。
         */
        @JsonProperty("referType")
        private Integer referType;
        /**
         * 关联 ID。
         */
        @JsonProperty("referId")
        private String referId;

        /**
         * 创建订单关联 ID 列表（jsonarray 字符串）。的空实例。
         */
        public LeadsReferListDetails() {
        }
    }

    /**
     * 订单属性map。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class HashMap {

        /**
         * 【体检业务使用】是否开通号码保护 true：开通 false：未开通。
         */
        @JsonProperty("isPhoneProtect")
        private Boolean isPhoneProtect;
        /**
         * 【体检、丽人业务使用】商品名称。
         */
        @JsonProperty("userDetailDealName")
        private String userDetailDealName;
        /**
         * 【体检业务使用】门店预约的项目名称。
         */
        @JsonProperty("userDetailBookitemName")
        private String userDetailBookitemName;
        /**
         * 【体检业务使用】是否已婚 0：不限 1：已婚 2：未婚。
         */
        @JsonProperty("userMarried")
        private Integer userMarried;
        /**
         * 【体检业务使用】证件类型 1：身份证 2：护照 3：港澳通行证 4：台胞证。
         */
        @JsonProperty("userIdNumberType")
        private Integer userIdNumberType;
        /**
         * 【体检业务使用】证件号。
         */
        @JsonProperty("userIdNumber")
        private String userIdNumber;
        /**
         * 【体检业务使用】附加项附属信息 C 端个检可忽略，团检加项内容固定显示在此处 velue：[{"productId":商品ID,"extraName":"项目名","price":"价格","spuId":标品ID}] 关注spuId即可。必填。
         */
        @JsonProperty("spuProductExtraInfo")
        private String spuProductExtraInfo;
        /**
         * 【体检业务使用】预约人姓名。
         */
        @JsonProperty("resvUserName")
        private String resvUserName;
        /**
         * 【体检业务使用】用户性别 1：男 2：女。
         */
        @JsonProperty("userGender")
        private Integer userGender;
        /**
         * 【丽人业务使用】服务时长。
         */
        @JsonProperty("orderDuration")
        private Long orderDuration;

        /**
         * 创建订单属性map。的空实例。
         */
        public HashMap() {
        }
    }
}
