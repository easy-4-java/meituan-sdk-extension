package io.github.easy4j.meituan.callback.business71;

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
 * 门店建店直连（businessId=71）具有公开协议的消息类型目录。
 * <p>该目录只登记能够从官方消息文档确认 {@code msgType} 的协议。平台后续可能新增类型，
 * 调用方使用 {@code switch} 时应保留 {@code default} 分支。</p>
 */
@Getter
public enum MeituanBusiness71MessageType {

    /** 门店创建、更新或账号认领处理完成后的审核结果通知。 */
    POI_OPENAPI_MSG_PUSH(
            "审核结果通知",
            "poi_openapi_msg_push",
            "7110001",
            "msg_mendianzhilian_2f16b69e-de3b-4f19-a24b-7c38f9bdc40f"
    );

    private static final String BUSINESS_ID = "71";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";

    private static final Map<String, MeituanBusiness71MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness71MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String capabilityName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness71MessageType(String displayName, String capabilityName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.capabilityName = capabilityName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=71 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return businessId=71 的已知消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness71MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 businessId=71 回调中的 msgType 查找消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness71MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
