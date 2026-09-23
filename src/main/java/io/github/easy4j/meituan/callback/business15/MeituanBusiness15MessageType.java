package io.github.easy4j.meituan.callback.business15;

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
 * 到店餐饮品牌会员卡（businessId=15）公开消息类型目录。
 * <p>只收录当前官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness15MessageType {

    /** 会员卡领卡、删卡事件。 */
    MEMBERSHIP_CARD_EVENT(
            "会员卡消息",
            "15201",
            "msg_jmcard_8ca2d5a1-96af-44b9-8e10-f1fb5212ffe3"
    ),

    /** 会员卡积分变更。 */
    MEMBERSHIP_CARD_POINTS(
            "会员卡积分",
            "15202",
            "msg_jmcard_d1db186e-08c5-4ad8-b28e-532c68a84314"
    ),

    /** 会员联名卡查询品牌纯新客，使用旧版 invokeType/param 信封。 */
    CO_BRANDED_NEW_USER_QUERY(
            "会员联名卡查询新客",
            "15101",
            "msg_jmcard_64a5fe93-48f2-49ca-86fe-f2a6a19cd172"
    ),

    /** 查询品牌会员信息。 */
    BRAND_MEMBER_QUERY(
            "查询品牌会员信息",
            "1510001",
            "msg_jmcard_50cf570c-91a8-4ddc-a572-8d644f92febd"
    ),

    /** 品牌会员注册和权益发放。 */
    BRAND_MEMBER_REGISTRATION_AND_RIGHTS(
            "品牌会员注册和权益发放",
            "1510003",
            "msg_jmcard_6a027b3f-818b-484c-b5ef-6b1fe634d0a2"
    );

    private static final String BUSINESS_ID = "15";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness15MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness15MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness15MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=15 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知品牌会员卡消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness15MessageType> resolve(MeituanCallbackMessage callback) {
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
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
