package io.github.easy4j.meituan.callback.business79.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「券码变更推送消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=79}，消息类型为 {@code msgType=7910001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_dishconnect_a7720bdf-02c2-4533-87f3-280cb3b0b006">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoucherCodeChangedMessage {

    /**
     * 消息推送时间戳，单位毫秒。
     */
    @JsonProperty("messagePushTime")
    private Long messagePushTime;

    /**
     * 幂等键。
     */
    @JsonProperty("idempotentKey")
    private String idempotentKey;

    /**
     * 消息类型 1-发券 2-核销 3-撤销核销 4-退券 5-赠予 7-换码。
     */
    @JsonProperty("messageType")
    private Integer messageType;

    /**
     * 券码列表。
     */
    @JsonProperty("couponPushMessageList")
    private CouponPushMessageListDetails couponPushMessageList;

    /**
     * 预留扩展字段。
     */
    @JsonProperty("extendInfo")
    private ExtendInfoDetails extendInfo;

    /**
     * 券码列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CouponPushMessageListDetails {

        /**
         * 券码，支持bin码。
         */
        @JsonProperty("couponCode")
        private String couponCode;

        /**
         * 所属项目 ID，即美团点评的商品 ID，此字段即将废弃，请使用dealIdLong。
         */
        @JsonProperty("dealId")
        private Integer dealId;

        /**
         * 所属项目 ID，即美团点评的商品 ID。
         */
        @JsonProperty("dealIdLong")
        private Long dealIdLong;

        /**
         * 券码状态。0-未使用，128-已使用，192-已作废。
         */
        @JsonProperty("couponStatus")
        private Integer couponStatus;

        /**
         * 变更动作时间戳，单位毫秒。
         */
        @JsonProperty("operateTime")
        private Long operateTime;

        /**
         * 购买券的美团侧订单号。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 扩展参数。
         */
        @JsonProperty("extendMap")
        private ExtendMapDetails extendMap;

        /**
         * 扩展参数。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ExtendMapDetails {

            /**
             * 可能包含非数字字符。 couponCode归属用户手机号，加密传输。
             *  普通券以下场景必传： - messageType=1 发券 - messageType=5 赠与 梯次卡以下场景必传： - messageType=1 发券消息 - messageType=4 退券。
             */
            @JsonProperty("mobile")
            private String mobile;

            /**
             * 商家门店Id，仅在messageType=2 核销消息且在直连有映射时会传。
             */
            @JsonProperty("vendorShopId")
            private String vendorShopId;

            /**
             * 撤销后新券码code，支持bin码，以下场景必传： - messageType=3 撤销核销 - messageType=7 换码。
             */
            @JsonProperty("newCode")
            private String newCode;

            /**
             * 券商家实收金额，梯次卡场景messageType=1 发券必传。
             */
            @JsonProperty("merchantAmount")
            private String merchantAmount;

            /**
             * 券码在次卡中的次序 梯次卡以下场景必传： - messageType=2 核销 - messageType=3 撤销核销 - messageType=4 退券 - messageType=7 换码。
             */
            @JsonProperty("couponCodeSequence")
            private String couponCodeSequence;

            /**
             * 政府券标识，仅在messageType=1发券且美团订单存在使用政府券情况下，有该标识。
             */
            @JsonProperty("govCashTag")
            private String govCashTag;

            /**
             * 在线点订单号 仅在messageType=2 核销且在线点订单使用券码时有值。
             */
            @JsonProperty("mryOrderId")
            private String mryOrderId;
        }
    }

    /**
     * 预留扩展字段。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtendInfoDetails {

        /**
         * 梯次卡标识，梯次卡必传。
         */
        @JsonProperty("ladderCardTag")
        private String ladderCardTag;

        /**
         * 可能包含非数字字符。 受赠人手机号，加密传输。 仅在messageType=5赠券消息必传。
         */
        @JsonProperty("doneeMobile")
        private String doneeMobile;
    }
}
