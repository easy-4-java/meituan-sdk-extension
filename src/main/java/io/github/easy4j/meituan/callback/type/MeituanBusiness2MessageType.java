package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz2.AnonymousReviewChatMessage;
import io.github.easy4j.meituan.callback.model.biz2.AutoReplySettingsChangedMessage;
import io.github.easy4j.meituan.callback.model.biz2.GroupMealProductChangedMessage;
import io.github.easy4j.meituan.callback.model.biz2.ImDeliveryBlockedMessage;
import io.github.easy4j.meituan.callback.model.biz2.MealPreparationExceptionMessage;
import io.github.easy4j.meituan.callback.model.biz2.MealPreparationStatusMessage;
import io.github.easy4j.meituan.callback.model.biz2.MerchantAppealResultMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderCancelledMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderCompletedMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderConfirmedMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderDeliveryStatusMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderInformationChangedMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderReceivedMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderRefundMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderReminderMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderSettlementDetailsMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderTransferredToMerchantDeliveryMessage;
import io.github.easy4j.meituan.callback.model.biz2.PartialOrderRefundMessage;
import io.github.easy4j.meituan.callback.model.biz2.PrivacyNumberFallbackMessage;
import io.github.easy4j.meituan.callback.model.biz2.RefundReviewReminderMessage;
import io.github.easy4j.meituan.callback.model.biz2.SmsDeliveryResultMessage;
import io.github.easy4j.meituan.callback.model.biz2.StoreOrProductChangedMessage;
import io.github.easy4j.meituan.callback.model.biz2.StoreStatusChangedMessage;
import io.github.easy4j.meituan.callback.model.biz2.TwoPartyImMessage;
import lombok.Getter;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 外卖餐饮（{@code businessId=2}）公开消息类型目录。
 *
 * <p>只收录当前官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness2MessageType implements MeituanMessageType {

    /**
     * 品牌接收用户与商家的两方会话消息。
     */
    TWO_PARTY_IM_MESSAGE(
            "接收IM两方会话消息",
            "210069",
            "msg_waimaing_0667a278-09c5-4d5d-98b3-6a92b5d3cfd8", TwoPartyImMessage.class),
    /**
     * 接收菜品/门店/门店装修/配送范围的变更消息【必须】。
     */
    STORE_OR_PRODUCT_CHANGED("接收菜品/门店/门店装修/配送范围的变更消息【必须】", "2101", "https://developer.meituan.com/docs/msg/msg_waimaing_bb6e77b7-d647-47ca-a3c2-9ba57090bfeb", StoreOrProductChangedMessage.class),
    /**
     * 接收出餐异常消息。
     */
    MEAL_PREPARATION_EXCEPTION("接收出餐异常消息", "2102", "https://developer.meituan.com/docs/msg/msg_waimaing_7d1fbbc6-cd1b-419a-864c-08df18195c0f", MealPreparationExceptionMessage.class),
    /**
     * 接收订单数据接口【必须】。
     */
    ORDER_RECEIVED("接收订单数据接口【必须】", "210001", "https://developer.meituan.com/docs/msg/msg_waimaing_0b380f3e-dd60-473e-9c0f-1addcbfc1a0e", OrderReceivedMessage.class),
    /**
     * 接收订单取消消息接口【必须】。
     */
    ORDER_CANCELLED("接收订单取消消息接口【必须】", "210003", "https://developer.meituan.com/docs/msg/msg_waimaing_6f40dc94-b808-4954-b478-bf0e4ac77693", OrderCancelledMessage.class),
    /**
     * 接收订单退款类消息接口【必须】。
     */
    ORDER_REFUND("接收订单退款类消息接口【必须】", "210005", "https://developer.meituan.com/docs/msg/msg_waimaing_ec09b7af-7cc3-430b-95ce-d7be671e477b", OrderRefundMessage.class),
    /**
     * 接收订单完成消息接口。
     */
    ORDER_COMPLETED("接收订单完成消息接口", "210007", "https://developer.meituan.com/docs/msg/msg_waimaing_ba98bf52-d204-4ba4-96c0-5062da15547a", OrderCompletedMessage.class),
    /**
     * 接收订单已确认消息接口【指商家已确认】。
     */
    ORDER_CONFIRMED("接收订单已确认消息接口【指商家已确认】", "210009", "https://developer.meituan.com/docs/msg/msg_waimaing_77527eaf-ed0d-4300-8d41-ddfd76adaa30", OrderConfirmedMessage.class),
    /**
     * 接收订单配送状态接口。
     */
    ORDER_DELIVERY_STATUS("接收订单配送状态接口", "210011", "https://developer.meituan.com/docs/msg/msg_waimaing_4b789ca7-7215-4253-8c20-2863ab6b20d2", OrderDeliveryStatusMessage.class),
    /**
     * 接收门店状态变更接口。
     */
    STORE_STATUS_CHANGED("接收门店状态变更接口", "210013", "https://developer.meituan.com/docs/msg/msg_waimaing_a827b96c-6ea1-4919-b91a-6629f7751662", StoreStatusChangedMessage.class),
    /**
     * 接收订单结算明细回调接口。
     */
    ORDER_SETTLEMENT_DETAILS("接收订单结算明细回调接口", "210015", "https://developer.meituan.com/docs/msg/msg_waimaing_9d34417c-defb-4c51-9aa3-445405f1b066", OrderSettlementDetailsMessage.class),
    /**
     * 接收部分退款回调接口。
     */
    PARTIAL_ORDER_REFUND("接收部分退款回调接口", "210017", "https://developer.meituan.com/docs/msg/msg_waimaing_3586d47e-e40d-4e02-b6b9-3ff92b5546b7", PartialOrderRefundMessage.class),
    /**
     * 隐私号-降级回调接口【必须】。
     */
    PRIVACY_NUMBER_FALLBACK("隐私号-降级回调接口【必须】", "210019", "https://developer.meituan.com/docs/msg/msg_waimaing_b5c80c79-d168-49c0-80b8-54b5303bedcf", PrivacyNumberFallbackMessage.class),
    /**
     * 接收催单消息。
     */
    ORDER_REMINDER("接收催单消息", "210021", "https://developer.meituan.com/docs/msg/msg_waimaing_6bc9fde7-81a7-4b15-a152-fc92e439f310", OrderReminderMessage.class),
    /**
     * 拼好饭-推送商品变更消息。
     */
    GROUP_MEAL_PRODUCT_CHANGED("拼好饭-推送商品变更消息", "210027", "https://developer.meituan.com/docs/msg/msg_waimaing_5857a661-af40-442b-83ec-f0eca808c170", GroupMealProductChangedMessage.class),
    /**
     * 接收美团配送转自配送消息。
     */
    ORDER_TRANSFERRED_TO_MERCHANT_DELIVERY("接收美团配送转自配送消息", "210031", "https://developer.meituan.com/docs/msg/msg_waimaing_92f54148-a06c-452e-a9ec-52138f2518a5", OrderTransferredToMerchantDeliveryMessage.class),
    /**
     * 接收IM发送消息被风控拦截的信息。
     */
    IM_DELIVERY_BLOCKED("接收IM发送消息被风控拦截的信息", "210033", "https://developer.meituan.com/docs/msg/msg_waimaing_54686005-9c88-4cdc-bae2-7afc4973ffd4", ImDeliveryBlockedMessage.class),
    /**
     * 接收门店智能回复机器人开关变更消息。
     */
    AUTO_REPLY_SETTINGS_CHANGED("接收门店智能回复机器人开关变更消息", "210051", "https://developer.meituan.com/docs/msg/msg_waimaing_44784bc6-feb1-4d9f-ba9d-bfc0a67b2281", AutoReplySettingsChangedMessage.class),
    /**
     * 接收商家申诉结果消息。
     */
    MERCHANT_APPEAL_RESULT("接收商家申诉结果消息", "210065", "https://developer.meituan.com/docs/msg/msg_waimaing_0dbe7497-249f-4403-b3e9-446d4acff3a1", MerchantAppealResultMessage.class),
    /**
     * 接收IM匿名评价群聊消息。
     */
    ANONYMOUS_REVIEW_CHAT("接收IM匿名评价群聊消息", "210071", "https://developer.meituan.com/docs/msg/msg_waimaing_05fc09bc-aef3-485d-90e7-a138336a4a7e", AnonymousReviewChatMessage.class),
    /**
     * 接收用户修改订单信息消息。
     */
    ORDER_INFORMATION_CHANGED("接收用户修改订单信息消息", "210077", "https://developer.meituan.com/docs/msg/msg_waimaing_1d0bc162-bc48-47d0-aed1-3081c5e87846", OrderInformationChangedMessage.class),
    /**
     * 推送订单出餐状态。
     */
    MEAL_PREPARATION_STATUS("推送订单出餐状态", "210081", "https://developer.meituan.com/docs/msg/msg_waimaing_fc2e35f0-ce97-437a-be5f-3487518fb2a2", MealPreparationStatusMessage.class),
    /**
     * 接收用户催商家审核退款消息。
     */
    REFUND_REVIEW_REMINDER("接收用户催商家审核退款消息", "210083", "https://developer.meituan.com/docs/msg/msg_waimaing_ca998471-e428-4ae4-9556-d181aedb0239", RefundReviewReminderMessage.class),
    /**
     * 短信发送结果回调。
     */
    SMS_DELIVERY_RESULT("短信发送结果回调", "210095", "https://developer.meituan.com/docs/msg/msg_waimaing_4b06f3e7-b940-4aee-8577-bad12f2e373f", SmsDeliveryResultMessage.class);

    private static final String BUSINESS_ID = "2";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness2MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness2MessageType::getMsgType, Function.identity()))
    );

    /**
     * 美团文档中的消息名称。
     */
    private final String displayName;

    /**
     * 平台用来标识此消息的类型编号。
     */
    private final String msgType;

    /**
     * 美团官网上此消息的文档地址。
     */
    private final String documentUrl;

    /**
     * 业务内容的 Jackson 目标类型；String 表示保留业务原文。
     */
    private final Class<?> messageClass;

    MeituanBusiness2MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
        this.messageClass = Objects.requireNonNull(messageClass, "messageClass must not be null");
    }

    /**
     * 返回此枚举所属的美团业务编号。
     *
     * @return 官方 businessId
     */
    @Override
    public String getBusinessId() {
        return BUSINESS_ID;
    }

    /**
     * 在确认回调属于 {@code businessId=2} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness2MessageType> resolve(MeituanCallbackMessage<?> callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据平台消息类型查找已登记消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness2MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
