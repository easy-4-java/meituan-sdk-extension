package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz19.DeliveryOrderExceptionMessage;
import io.github.easy4j.meituan.callback.model.biz19.DeliveryOrderStatusMessage;
import io.github.easy4j.meituan.callback.model.biz19.DeliveryRangeChangedMessage;
import io.github.easy4j.meituan.callback.model.biz19.DeliveryRiskLevelChangedMessage;
import io.github.easy4j.meituan.callback.model.biz19.StoreStatusMessage;
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
 * 业务 {@code businessId=19} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness19MessageType implements MeituanMessageType {

    /**
     * 订单状态回调。
     */
    DELIVERY_ORDER_STATUS("订单状态回调", "19101", "https://developer.meituan.com/docs/msg/msg_peisong_e0159351-5e6f-4911-bf86-51f4def71635", DeliveryOrderStatusMessage.class),
    /**
     * 订单异常回调。
     */
    DELIVERY_ORDER_EXCEPTION("订单异常回调", "19102", "https://developer.meituan.com/docs/msg/msg_peisong_ec826ab4-9996-4c23-b64e-b9f460f49e83", DeliveryOrderExceptionMessage.class),
    /**
     * 门店状态回调。
     */
    STORE_STATUS("门店状态回调", "19103", "https://developer.meituan.com/docs/msg/msg_peisong_c64b17b7-865c-4674-b063-d00c2a2e178a", StoreStatusMessage.class),
    /**
     * 配送范围变更。
     */
    DELIVERY_RANGE_CHANGED("配送范围变更", "19104", "https://developer.meituan.com/docs/msg/msg_peisong_8fc0e891-2f4c-4380-8b3e-c27f4f3e690c", DeliveryRangeChangedMessage.class),
    /**
     * 配送风险等级变更。
     */
    DELIVERY_RISK_LEVEL_CHANGED("配送风险等级变更", "19105", "https://developer.meituan.com/docs/msg/msg_peisong_877bba14-539e-4051-a2ab-ddfa7c0d4db2", DeliveryRiskLevelChangedMessage.class);

    private static final String BUSINESS_ID = "19";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness19MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness19MessageType::getMsgType, Function.identity()))
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

    MeituanBusiness19MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
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
     * 在确认回调属于 {@code businessId=19} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness19MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness19MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
