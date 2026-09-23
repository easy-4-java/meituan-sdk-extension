package io.github.easy4j.meituan.callback.business46;

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
 * 团购配送（businessId=46）公开消息类型目录。
 * <p>只收录官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness46MessageType {

    /** 套餐配送接单消息。 */
    PACKAGE_DELIVERY_ACCEPTED(
            "套餐配送接单消息",
            "4610000",
            "msg_dcps_48121253-009e-4075-89d4-5b79fb9ba172"
    ),

    /** 接收门店信息变更消息。 */
    POI_INFO_CHANGED(
            "接收门店信息变更消息",
            "4610023",
            "msg_dcps_7eec9ee3-9b57-451a-aaf9-ccd574dbecdf"
    ),

    /** 接收订单完成消息。 */
    ORDER_COMPLETED(
            "接收订单完成消息",
            "4610018",
            "msg_dcps_69917343-b53f-4de8-bdbf-2eee2477bdd5"
    ),

    /** 接收订单自配完成消息。 */
    SELF_DELIVERY_COMPLETED(
            "接收订单自配完成消息",
            "4610016",
            "msg_dcps_4548a521-15cb-4dfb-8721-971a0e831085"
    ),

    /** 接收订单可转自配消息。 */
    SELF_DELIVERY_AVAILABLE(
            "接收订单可转自配消息",
            "4610014",
            "msg_dcps_efa3af0a-85bd-4cc9-94c4-4e5a7d712ddb"
    ),

    /** 接收配送状态变更消息。 */
    DELIVERY_STATUS_CHANGED(
            "接收配送状态变更消息",
            "4610012",
            "msg_dcps_14be7b74-05e1-4b4e-a626-d6cacbee850c"
    ),

    /** 接收订单已出餐消息。 */
    MEAL_READY(
            "接收订单已出餐消息",
            "4610010",
            "msg_dcps_0771bd42-2080-4e7d-886c-c0969ded3078"
    ),

    /** 接收用户退款状态变更消息。 */
    REFUND_STATUS_CHANGED(
            "接收用户退款状态变更消息",
            "4610008",
            "msg_dcps_d812c905-37ba-4972-8204-9f7e867a1f78"
    ),

    /** 接收订单超时取消消息。 */
    ORDER_TIMEOUT_CANCELED(
            "接收订单超时取消消息",
            "4610006",
            "msg_dcps_b19bc448-d624-41db-9b33-58501f48ba16"
    ),

    /** 接收订单拒绝接单消息。 */
    ORDER_REJECTED(
            "接收订单拒绝接单消息",
            "4610004",
            "msg_dcps_baa84876-82fa-4e30-8b8e-e8ffa051a452"
    ),

    /** 接收订单已支付消息。 */
    ORDER_PAID(
            "接收订单已支付消息",
            "4610002",
            "msg_dcps_75fe9410-4d49-40f6-960e-22e55329fd59"
    ),

    /** 接收商家转自配成功消息。 */
    SELF_DELIVERY_TRANSFER_SUCCEEDED(
            "接收商家转自配成功消息",
            "4610026",
            "msg_dcps_73535482-f538-43e6-9b11-b18a4535e484"
    ),

    /** 接收预订单提醒备餐消息。 */
    PREORDER_MEAL_REMINDER(
            "接收预订单提醒备餐消息",
            "4610024",
            "msg_dcps_eb9ee436-1e53-420f-891e-cb030e8c9dba"
    ),

    /** 指定打印机打印订单。 */
    PRINT_ORDER(
            "指定打印机打印订单",
            "4610029",
            "msg_dcps_d36c3f46-442f-4189-ba83-36591af2f548"
    );

    private static final String BUSINESS_ID = "46";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness46MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness46MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness46MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=46 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知团购配送消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness46MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 msgType 查找团购配送消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness46MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
