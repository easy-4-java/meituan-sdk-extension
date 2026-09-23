package io.github.easy4j.meituan.callback.business58;

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
 * 服务零售（businessId=58）具有公开协议的消息类型目录。
 * <p>该目录只登记能够从官方消息文档确认 {@code msgType} 的协议，不代表任一开发者
 * 账号当前已开通的能力集合。平台后续可能新增类型，调用方使用 {@code switch} 时应保留
 * {@code default} 分支。</p>
 */
@Getter
public enum MeituanBusiness58MessageType {

    /** 操作设备。 */
    OPERATE_DEVICE("操作设备", "5810149", "msg_ddzh_12820d14-4867-46b5-b527-210c123fc5e9"),
    /** 启动设备并核销团单。 */
    START_DEVICE_AND_CONSUME_DEAL("启动设备并核销团单", "5810147", "msg_ddzh_6ea4ba3a-a2c7-4e18-a897-c5c2ee96c47c"),
    /** 订单退款信息推送。 */
    ORDER_REFUND_INFO_PUSHED("订单退款信息推送", "5810173", "msg_ddzh_a8ef235b-a621-4de4-b8d4-b0820980ea4f");

    private static final String BUSINESS_ID = "58";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";

    private static final Map<String, MeituanBusiness58MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness58MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness58MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=58 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return businessId=58 的已知消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness58MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 businessId=58 回调中的 msgType 查找消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness58MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
