package io.github.easy4j.meituan.callback.business2;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.utils.StringUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 餐饮客户解决方案涉及的外卖品牌（businessId=2）公开消息类型目录。
 * <p>只收录当前官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness2MessageType {

    /** 品牌接收用户与商家的两方会话消息。 */
    TWO_PARTY_IM_MESSAGE(
            "接收IM两方会话消息",
            "210069",
            "msg_waimaing_0667a278-09c5-4d5d-98b3-6a92b5d3cfd8"
    );

    private static final String BUSINESS_ID = "2";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness2MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness2MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness2MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=2 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知品牌 IM 消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness2MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据平台消息类型查找品牌 IM 消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness2MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
