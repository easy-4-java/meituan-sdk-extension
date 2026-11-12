package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz63.JointMemberPointsDeductionMessage;
import io.github.easy4j.meituan.callback.model.biz63.JointMemberQueryMessage;
import io.github.easy4j.meituan.callback.model.biz63.JointMemberRegistrationMessage;
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
 * 业务 {@code businessId=63} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness63MessageType implements MeituanMessageType {

    /**
     * 联合会员-查询会员。
     */
    JOINT_MEMBER_QUERY("联合会员-查询会员", "6310000", "https://developer.meituan.com/docs/msg/msg_mtcdb_8917e0cb-f07e-4212-93e9-19cfad77c319", JointMemberQueryMessage.class),
    /**
     * 联合会员-注册会员。
     */
    JOINT_MEMBER_REGISTRATION("联合会员-注册会员", "6310002", "https://developer.meituan.com/docs/msg/msg_mtcdb_1e66e50a-4f85-4a2b-a039-4ed6c1152723", JointMemberRegistrationMessage.class),
    /**
     * 联合会员-会员积分扣减。
     */
    JOINT_MEMBER_POINTS_DEDUCTION("联合会员-会员积分扣减", "6310004", "https://developer.meituan.com/docs/msg/msg_mtcdb_9b6c10c2-1f14-4466-afc7-f1211d4fcd53", JointMemberPointsDeductionMessage.class);

    private static final String BUSINESS_ID = "63";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness63MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness63MessageType::getMsgType, Function.identity()))
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

    MeituanBusiness63MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
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
     * 在确认回调属于 {@code businessId=63} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness63MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness63MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
