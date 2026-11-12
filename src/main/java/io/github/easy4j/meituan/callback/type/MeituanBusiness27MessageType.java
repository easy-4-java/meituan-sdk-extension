package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz27.BillDetailNoticeMessage;
import io.github.easy4j.meituan.callback.model.biz27.CreateResultNoticeMessage;
import io.github.easy4j.meituan.callback.model.biz27.OrderCancelNoticeMessage;
import io.github.easy4j.meituan.callback.model.biz27.OrderShipmentNoticeMessage;
import io.github.easy4j.meituan.callback.model.biz27.StockInNoticeMessage;
import io.github.easy4j.meituan.callback.model.biz27.StockOutNoticeMessage;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 快驴（{@code businessId=27}）公开消息类型目录。
 *
 * <p>只收录当前官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness27MessageType implements MeituanMessageType {

    /**
     * 快驴订单创建结果异步通知。
     */
    CREATE_RESULT_NOTICE(
            "快驴订单创建结果异步通知",
            "27001",
            "msg_klopen_29b2c89c-6012-4333-990c-5d5f5eda69a7", CreateResultNoticeMessage.class),

    /**
     * 快驴入库通知。
     */
    STOCK_IN_NOTICE(
            "快驴入库通知",
            "27002",
            "msg_klopen_4e16b653-ed45-4efa-8948-0badc1dfa9f2", StockInNoticeMessage.class),

    /**
     * 快驴出库通知。
     */
    STOCK_OUT_NOTICE(
            "快驴出库通知",
            "27003",
            "msg_klopen_1056ac08-a99a-4053-a2bc-db530bb5c3af", StockOutNoticeMessage.class),

    /**
     * 快驴订单取消通知。
     */
    ORDER_CANCEL_NOTICE(
            "快驴订单取消通知",
            "27004",
            "msg_klopen_642ff552-99c0-4a65-bb26-ef6c66a45314", OrderCancelNoticeMessage.class),

    /**
     * 快驴推送账单明细。
     */
    BILL_DETAIL_NOTICE(
            "快驴推送账单明细",
            "2710003",
            "msg_klopen_cd5fa387-81aa-4cb7-836a-58fff83b41a5", BillDetailNoticeMessage.class),

    /**
     * 快驴订单发货通知。
     */
    ORDER_SHIPMENT_NOTICE(
            "快驴订单发货通知",
            "2710005",
            "msg_klopen_80bb04b0-5b52-4d47-9d55-430c0e561e79", OrderShipmentNoticeMessage.class);

    /**
     * 当前消息目录所属的官方业务编号。
     */
    private static final String BUSINESS_ID = "27";
    /**
     * 官网消息文档地址的基础路径。
     */
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    /**
     * 按消息编号建立的只读枚举索引。
     */
    private static final Map<String, MeituanBusiness27MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness27MessageType::getMsgType, Function.identity()))
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
     * @param displayName 官网消息名称
     * @param msgType 平台消息类型编号
     * @param documentKey 官网文档标识或完整文档地址
     * @param messageClass 业务消息的反序列化目标类型
     */
    MeituanBusiness27MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
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
     * 在确认回调属于 {@code businessId=27} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知快驴消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness27MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
