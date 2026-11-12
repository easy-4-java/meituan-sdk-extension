package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz1000.MigrationCompletedMessage;
import io.github.easy4j.meituan.callback.model.biz1000.PushVolumeAdjustmentResultMessage;
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
 * 业务 {@code businessId=1000} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness1000MessageType implements MeituanMessageType {

    /**
     * 迁移任务处理完成通知。
     */
    MIGRATION_COMPLETED("迁移任务处理完成通知", "100010007", "https://developer.meituan.com/docs/msg/msg_common_d7f87232-fe1f-491c-9dc1-c1c089263f53", MigrationCompletedMessage.class),
    /**
     * 开发者迁移消息调量结果通知消息。
     */
    PUSH_VOLUME_ADJUSTMENT_RESULT("开发者迁移消息调量结果通知消息", "100010009", "https://developer.meituan.com/docs/msg/msg_common_baf66063-f311-471d-8392-01df3fce7d80", PushVolumeAdjustmentResultMessage.class);

    private static final String BUSINESS_ID = "1000";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness1000MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness1000MessageType::getMsgType, Function.identity()))
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

    MeituanBusiness1000MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
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
     * 在确认回调属于 {@code businessId=1000} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness1000MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness1000MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
