package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz15.*;
import lombok.Getter;

import java.net.URI;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 到店餐饮品牌会员卡（{@code businessId=15}）公开消息类型目录。
 *
 * <p>只收录当前官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness15MessageType implements MeituanMessageType {

    /**
     * 会员卡领卡、删卡事件。
     */
    MEMBERSHIP_CARD_EVENT(
            "会员卡消息",
            "15201",
            "msg_jmcard_8ca2d5a1-96af-44b9-8e10-f1fb5212ffe3", MembershipCardEventMessage.class),

    /**
     * 会员卡积分变更。
     */
    MEMBERSHIP_CARD_POINTS(
            "会员卡积分",
            "15202",
            "msg_jmcard_d1db186e-08c5-4ad8-b28e-532c68a84314", MembershipCardPointsMessage.class),

    /**
     * 会员联名卡查询品牌纯新客，使用旧版 invokeType/param 信封。
     */
    CO_BRANDED_NEW_USER_QUERY(
            "会员联名卡查询新客",
            "15101",
            "msg_jmcard_64a5fe93-48f2-49ca-86fe-f2a6a19cd172", CoBrandedNewUserQueryMessage.class),

    /**
     * 查询品牌会员信息。
     */
    BRAND_MEMBER_QUERY(
            "查询品牌会员信息",
            "1510001",
            "msg_jmcard_50cf570c-91a8-4ddc-a572-8d644f92febd", BrandMemberQueryMessage.class),

    /**
     * 品牌会员注册和权益发放。
     */
    BRAND_MEMBER_REGISTRATION_AND_RIGHTS(
            "品牌会员注册和权益发放",
            "1510003",
            "msg_jmcard_6a027b3f-818b-484c-b5ef-6b1fe634d0a2", BrandMemberRegistrationAndRightsMessage.class),
    /**
     * 美团黑金、黑钻会员等级变化通知。
     */
    BRAND_MEMBER_LEVEL_CHANGED(
            "美团会员（黑金/黑钻）等级变化通知",
            "1510005",
            "https://developer.meituan.com/docs/biz/biz_jmcard_a37bb777-fedf-4732-b897-96d11a235d59", BrandMemberLevelChangedMessage.class);

    /**
     * 当前消息目录所属的官方业务编号。
     */
    private static final String BUSINESS_ID = "15";
    /**
     * 官网消息文档地址的基础路径。
     */
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    /**
     * 按消息编号建立的只读枚举索引。
     */
    private static final Map<String, MeituanBusiness15MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness15MessageType::getMsgType, Function.identity()))
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
    MeituanBusiness15MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
        this.messageClass = Objects.requireNonNull(messageClass, "messageClass must not be null");
    }

    /**
     * 在确认回调属于 {@code businessId=15} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知品牌会员卡消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness15MessageType> resolve(MeituanCallbackMessage<?> callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据平台消息类型查找品牌会员卡消息定义。
     *
     * @param msgType 平台 msgType 或旧版 invokeType
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness15MessageType> fromMsgType(String msgType) {
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
