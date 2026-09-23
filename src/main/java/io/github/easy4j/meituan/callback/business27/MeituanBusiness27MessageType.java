package io.github.easy4j.meituan.callback.business27;

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
 * 快驴（businessId=27）公开消息类型目录。
 * <p>只收录当前官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness27MessageType {

    /** 快驴订单创建结果异步通知。 */
    CREATE_RESULT_NOTICE(
            "快驴订单创建结果异步通知",
            "27001",
            "msg_klopen_29b2c89c-6012-4333-990c-5d5f5eda69a7"
    ),

    /** 快驴入库通知。 */
    STOCK_IN_NOTICE(
            "快驴入库通知",
            "27002",
            "msg_klopen_4e16b653-ed45-4efa-8948-0badc1dfa9f2"
    ),

    /** 快驴出库通知。 */
    STOCK_OUT_NOTICE(
            "快驴出库通知",
            "27003",
            "msg_klopen_1056ac08-a99a-4053-a2bc-db530bb5c3af"
    ),

    /** 快驴订单取消通知。 */
    ORDER_CANCEL_NOTICE(
            "快驴订单取消通知",
            "27004",
            "msg_klopen_642ff552-99c0-4a65-bb26-ef6c66a45314"
    ),

    /** 快驴推送账单明细。 */
    BILL_DETAIL_NOTICE(
            "快驴推送账单明细",
            "2710003",
            "msg_klopen_cd5fa387-81aa-4cb7-836a-58fff83b41a5"
    ),

    /** 快驴订单发货通知。 */
    ORDER_SHIPMENT_NOTICE(
            "快驴订单发货通知",
            "2710005",
            "msg_klopen_80bb04b0-5b52-4d47-9d55-430c0e561e79"
    );

    private static final String BUSINESS_ID = "27";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness27MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness27MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness27MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=27 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知快驴消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness27MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 msgType 查找快驴消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness27MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
