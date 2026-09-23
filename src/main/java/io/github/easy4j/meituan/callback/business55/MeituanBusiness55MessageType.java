package io.github.easy4j.meituan.callback.business55;

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
 * 大众点评免费试（businessId=55）公开消息类型目录。
 * <p>该目录描述平台消息协议，不代表开发者账号已经获得对应业务授权。</p>
 */
@Getter
public enum MeituanBusiness55MessageType {

    /** 免费试活动发生变更。 */
    ACTIVITY_CHANGE_NOTICE(
            "活动变更通知",
            "5510001",
            "msg_freetryopen_da0cca39-5099-452f-9d9b-c9bb632c0a81"
    );

    private static final String BUSINESS_ID = "55";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness55MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness55MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness55MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=55 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知免费试消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness55MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 msgType 查找免费试消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness55MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
