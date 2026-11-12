package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz7.ReservationOrderChangedMessage;
import io.github.easy4j.meituan.callback.model.biz7.ReservationOrderCreatedMessage;
import io.github.easy4j.meituan.callback.model.biz7.TableRulesAndInventoryChangedMessage;
import lombok.Getter;

import java.net.URI;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务 {@code businessId=7} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness7MessageType implements MeituanMessageType {

    /**
     * 推送新订单。
     */
    RESERVATION_ORDER_CREATED("推送新订单", "710003", "https://developer.meituan.com/docs/msg/msg_resv2_2db30e48-c7a1-4c08-b234-65ebf8e6638f", ReservationOrderCreatedMessage.class),
    /**
     * 订单变更。
     */
    RESERVATION_ORDER_CHANGED("订单变更", "710005", "https://developer.meituan.com/docs/msg/msg_resv2_f89e564f-498c-4843-9d6f-ccb70d26f133", ReservationOrderChangedMessage.class),
    /**
     * 推送桌型桌位&amp;规则&amp;库存变更通知。
     */
    TABLE_RULES_AND_INVENTORY_CHANGED("推送桌型桌位&amp;规则&amp;库存变更通知", "710014", "https://developer.meituan.com/docs/msg/msg_resv2_9eb4d57f-7159-40bd-ba43-cef4d82c09ce", TableRulesAndInventoryChangedMessage.class);

    /**
     * 当前消息目录所属的官方业务编号。
     */
    private static final String BUSINESS_ID = "7";
    /**
     * 官网消息文档地址的基础路径。
     */
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    /**
     * 按消息编号建立的只读枚举索引。
     */
    private static final Map<String, MeituanBusiness7MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness7MessageType::getMsgType, Function.identity()))
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
    MeituanBusiness7MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
        this.messageClass = Objects.requireNonNull(messageClass, "messageClass must not be null");
    }

    /**
     * 在确认回调属于 {@code businessId=7} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness7MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness7MessageType> fromMsgType(String msgType) {
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
