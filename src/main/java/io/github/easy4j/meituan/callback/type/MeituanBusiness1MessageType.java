package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz1.*;
import lombok.Getter;

import java.net.URI;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务 {@code businessId=1} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness1MessageType implements MeituanMessageType {

    /**
     * 代金券买单订单消息【必接】。
     */
    VOUCHER_PAYMENT_ORDER("代金券买单订单消息【必接】", "110009", "https://developer.meituan.com/docs/msg/msg_tuangoung_339f232c-3fcc-42bb-af9e-979375b5e8dc", VoucherPaymentOrderMessage.class),
    /**
     * 开通代金券买单消息。
     */
    VOUCHER_PAYMENT_ENABLED("开通代金券买单消息", "110011", "https://developer.meituan.com/docs/msg/msg_tuangoung_10c69b71-a072-4d6f-ab0e-9d1f3a2027da", VoucherPaymentEnabledMessage.class),
    /**
     * 门店授权信息同步。
     */
    STORE_AUTHORIZATION_SYNC("门店授权信息同步", "110019", "https://developer.meituan.com/docs/msg/msg_tuangoung_33cda1bb-6a24-473e-b1b0-a3c869024e39", StoreAuthorizationSyncMessage.class),
    /**
     * 门店代金券买单设置变更。
     */
    STORE_VOUCHER_PAYMENT_SETTINGS_CHANGED("门店代金券买单设置变更", "110021", "https://developer.meituan.com/docs/msg/msg_tuangoung_0c32a6c8-7f01-44d8-8b1b-65b769db8ddb", StoreVoucherPaymentSettingsChangedMessage.class),
    /**
     * 审核驳回通知。
     */
    PRODUCT_AUDIT_REJECTED("审核驳回通知", "110027", "https://developer.meituan.com/docs/msg/msg_tuangoung_41822434-e339-4850-9e0e-1204af98e295", ProductAuditRejectedMessage.class),
    /**
     * 审核驳回通知。
     */
    PRODUCT_AUDIT_REJECTED_110017("审核驳回通知", "110017", "https://developer.meituan.com/docs/msg/msg_tuangoung_41822434-e339-4850-9e0e-1204af98e295", ProductAuditRejectedMessage.class),
    /**
     * 新订单推送（已支付）。
     */
    PAID_ORDER_CREATED("新订单推送（已支付）", "110029", "https://developer.meituan.com/docs/msg/msg_tuangoung_a598c633-ce85-4889-a688-41d372c40c10", PaidOrderCreatedMessage.class);

    /**
     * 当前消息目录所属的官方业务编号。
     */
    private static final String BUSINESS_ID = "1";
    /**
     * 官网消息文档地址的基础路径。
     */
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    /**
     * 按消息编号建立的只读枚举索引。
     */
    private static final Map<String, MeituanBusiness1MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness1MessageType::getMsgType, Function.identity()))
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
     * @param displayName  官网消息名称
     * @param msgType      平台消息类型编号
     * @param documentKey  官网文档标识或完整文档地址
     * @param messageClass 业务消息的反序列化目标类型
     */
    MeituanBusiness1MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
        this.messageClass = Objects.requireNonNull(messageClass, "messageClass must not be null");
    }

    /**
     * 在确认回调属于 {@code businessId=1} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness1MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness1MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
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
}
