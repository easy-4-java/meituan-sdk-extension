package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
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
 * 业务 {@code businessId=3} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness3MessageType {

    /**
     * 接收订单推送接口。
     */
    PAYMENT_ORDER("接收订单推送接口", "310001", "https://developer.meituan.com/docs/msg/msg_shanhuing_164350be-4000-43c9-ac87-892c907749c3");

    private static final String BUSINESS_ID = "3";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness3MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness3MessageType::getMsgType, Function.identity()))
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

    MeituanBusiness3MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
    }

    /**
     * 在确认回调属于 {@code businessId=3} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness3MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness3MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
