package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz61.OrderCloseMessage;
import io.github.easy4j.meituan.callback.model.biz61.OrderSubmitMessage;
import io.github.easy4j.meituan.callback.model.biz61.PayProcessMessage;
import io.github.easy4j.meituan.callback.model.biz61.ReceiptCancelConsumeMessage;
import io.github.easy4j.meituan.callback.model.biz61.ReceiptConsumeMessage;
import io.github.easy4j.meituan.callback.model.biz61.RefundProcessMessage;
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
 * 业务 {@code businessId=61} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness61MessageType implements MeituanMessageType {

    /**
     * ORDER_SUBMIT。
     */
    ORDER_SUBMIT("ORDER_SUBMIT", "6110001", "https://developer.meituan.com/docs/msg/msg_outdistribution_94f141f9-ad3a-41c1-8dfa-5d749212add3", OrderSubmitMessage.class),
    /**
     * ORDER_CLOSE。
     */
    ORDER_CLOSE("ORDER_CLOSE", "6110003", "https://developer.meituan.com/docs/msg/msg_outdistribution_e43fa49a-cdce-4a21-89f8-7e0218601ff6", OrderCloseMessage.class),
    /**
     * PAY_PROCESS。
     */
    PAY_PROCESS("PAY_PROCESS", "6110005", "https://developer.meituan.com/docs/msg/msg_outdistribution_812cf73c-7727-4540-8ee6-f9e2f5f68023", PayProcessMessage.class),
    /**
     * REFUND_PROCESS。
     */
    REFUND_PROCESS("REFUND_PROCESS", "6110007", "https://developer.meituan.com/docs/msg/msg_outdistribution_dfadd7a1-0eeb-4290-a7f7-782d7c56e262", RefundProcessMessage.class),
    /**
     * RECEIPT_CONSUME。
     */
    RECEIPT_CONSUME("RECEIPT_CONSUME", "6110009", "https://developer.meituan.com/docs/msg/msg_outdistribution_124ce302-bc79-4135-a0ee-3574335c1e3b", ReceiptConsumeMessage.class),
    /**
     * RECEIPT_CANCEL_CONSUME。
     */
    RECEIPT_CANCEL_CONSUME("RECEIPT_CANCEL_CONSUME", "6110011", "https://developer.meituan.com/docs/msg/msg_outdistribution_1a13b8f7-7690-415b-8b80-41a6b3230c40", ReceiptCancelConsumeMessage.class);

    /**
     * 当前消息目录所属的官方业务编号。
     */
    private static final String BUSINESS_ID = "61";
    /**
     * 官网消息文档地址的基础路径。
     */
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    /**
     * 按消息编号建立的只读枚举索引。
     */
    private static final Map<String, MeituanBusiness61MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness61MessageType::getMsgType, Function.identity()))
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
    MeituanBusiness61MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
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
     * 在确认回调属于 {@code businessId=61} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness61MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness61MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
