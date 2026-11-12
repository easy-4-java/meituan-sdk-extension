package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz52.ActivationCodeRedeemedMessage;
import io.github.easy4j.meituan.callback.model.biz52.MerchantOnboardingResultMessage;
import io.github.easy4j.meituan.callback.model.biz52.PaymentProductActivationResultMessage;
import io.github.easy4j.meituan.callback.model.biz52.PaymentResultMessage;
import io.github.easy4j.meituan.callback.model.biz52.RefundNotificationMessage;
import io.github.easy4j.meituan.callback.model.biz52.StagePaymentResultMessage;
import io.github.easy4j.meituan.callback.model.biz52.StageRefundNotificationMessage;
import io.github.easy4j.meituan.callback.model.biz52.SubMerchantVerificationResultMessage;
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
 * 业务 {@code businessId=52} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness52MessageType implements MeituanMessageType {

    /**
     * 收单开放平台支付结果通知。
     */
    PAYMENT_RESULT("收单开放平台支付结果通知", "5210005", "https://developer.meituan.com/docs/msg/msg_sdpt_14307110-59e4-4570-8f81-e589ae7d2b1a", PaymentResultMessage.class),
    /**
     * 激活码核销的通知。
     */
    ACTIVATION_CODE_REDEEMED("激活码核销的通知", "5210006", "https://developer.meituan.com/docs/msg/msg_sdpt_616c5363-83ee-4415-b05f-43216ae9fed9", ActivationCodeRedeemedMessage.class),
    /**
     * 收单开放平台商户入驻结果通知。
     */
    MERCHANT_ONBOARDING_RESULT("收单开放平台商户入驻结果通知", "5210008", "https://developer.meituan.com/docs/msg/msg_sdpt_ea08efbd-785e-4938-b07f-10c60a6cf001", MerchantOnboardingResultMessage.class),
    /**
     * 收单开放平台支付产品开通结果通知。
     */
    PAYMENT_PRODUCT_ACTIVATION_RESULT("收单开放平台支付产品开通结果通知", "5210010", "https://developer.meituan.com/docs/msg/msg_sdpt_e7192e69-a8de-4320-8557-f9dcf790cf10", PaymentProductActivationResultMessage.class),
    /**
     * 收单开放平台微信/支付宝子商户认证结果通知。
     */
    SUB_MERCHANT_VERIFICATION_RESULT("收单开放平台微信/支付宝子商户认证结果通知", "5210011", "https://developer.meituan.com/docs/msg/msg_sdpt_7128c07e-d4dd-4f39-ada6-c014d622dc3f", SubMerchantVerificationResultMessage.class),
    /**
     * 收单开放平台退款通知。
     */
    REFUND_NOTIFICATION("收单开放平台退款通知", "5210013", "https://developer.meituan.com/docs/msg/msg_sdpt_cec8a9b2-43a4-4b4c-b841-fcfc2884c409", RefundNotificationMessage.class),
    /**
     * 收单开放平台支付结果通知（stage）。
     */
    STAGE_PAYMENT_RESULT("收单开放平台支付结果通知（stage）", "5210015", "https://developer.meituan.com/docs/msg/msg_sdpt_2683a986-2715-4b18-a276-781b7ead252b", StagePaymentResultMessage.class),
    /**
     * 收单开放平台退款通知（stage）。
     */
    STAGE_REFUND_NOTIFICATION("收单开放平台退款通知（stage）", "5210017", "https://developer.meituan.com/docs/msg/msg_sdpt_c22aa8bf-115c-4dd7-a385-45e090e46e75", StageRefundNotificationMessage.class);

    /**
     * 当前消息目录所属的官方业务编号。
     */
    private static final String BUSINESS_ID = "52";
    /**
     * 官网消息文档地址的基础路径。
     */
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    /**
     * 按消息编号建立的只读枚举索引。
     */
    private static final Map<String, MeituanBusiness52MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness52MessageType::getMsgType, Function.identity()))
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

    /**
     * 登记消息的名称、编号、官网文档和模型类型。
     *
     * @param displayName 官网消息名称
     * @param msgType 平台消息类型编号
     * @param documentKey 官网文档标识或完整文档地址
     * @param messageClass 业务消息的反序列化目标类型
     */
    MeituanBusiness52MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
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
     * 在确认回调属于 {@code businessId=52} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness52MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness52MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
