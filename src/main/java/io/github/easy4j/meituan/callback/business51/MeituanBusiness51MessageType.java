package io.github.easy4j.meituan.callback.business51;

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
 * 到店餐饮在线点（businessId=51）公开消息类型目录。
 * <p>只收录当前官方文档能够确认类型号的消息；通用回调对象仍会保留未知消息的原始内容。</p>
 */
@Getter
public enum MeituanBusiness51MessageType {

    /** 美团通知品牌方“线上点”业务变更。 */
    ONLINE_BUSINESS_CHANGE(
            "美团通知品牌方“线上点”业务变更",
            "5110001",
            "msg_foodmop_babc2497-e3b5-49be-8259-3412d71fe210"
    ),

    /** 美团通知品牌方门店“线上点”营业状态变更。 */
    ONLINE_SERVICE_STATUS_CHANGE(
            "美团通知品牌方门店“线上点”营业状态变更",
            "5110003",
            "msg_foodmop_ac21784a-7718-4ab3-9a41-2ea7eafa6fca"
    ),

    /** 门店预计备餐时间查询。 */
    PREPARATION_TIME_QUERY(
            "门店预计备餐时间查询",
            "5110005",
            "msg_foodmop_dbf2bef2-55ee-4d2e-9985-7cf039ca2ff6"
    ),

    /** 商品审核失败通知，当前官方文档标记为必接。 */
    PRODUCT_AUDIT_NOTICE(
            "商品审核失败通知（必接）",
            "5110007",
            "msg_foodmop_217803ab-efd3-47e2-bb94-bad7e887b645"
    ),

    /** 品牌提供订单查询。 */
    BRAND_ORDER_QUERY(
            "品牌提供订单查询",
            "5110009",
            "msg_foodmop_9e4af01d-409c-4a85-addb-2da4f86831bf"
    ),

    /** 美团平台订单状态变更通知。 */
    PLATFORM_ORDER_STATUS_CHANGE(
            "美团平台订单状态变更通知",
            "5110011",
            "msg_foodmop_1578f703-51d9-408d-8115-81600e6bda31"
    ),

    /** 美团向品牌推送订单。 */
    ORDER_PUSH(
            "推单接口",
            "5110013",
            "msg_foodmop_a4d1b81e-3c9c-48d6-928c-52c9d43e3754"
    ),

    /** 门店预计备餐时间和排队信息查询。 */
    PREPARATION_TIME_AND_QUEUE_QUERY(
            "门店预计备餐时间和排队信息（必接）",
            "5110019",
            "msg_foodmop_8516072d-d9ba-40dd-bc43-ab46c1276b5d"
    ),

    /** 查询订单履约信息。 */
    ORDER_FULFILLMENT_QUERY(
            "查询订单履约信息",
            "5110021",
            "msg_foodmop_c5d73602-79ab-4880-ba25-ef974c42f9d0"
    ),

    /** 退款申请推送。 */
    REFUND_APPLICATION_PUSH(
            "退款申请推送",
            "5110023",
            "msg_foodmop_8ac18476-e862-4fb9-a767-1050f22689c7"
    ),

    /** 新订单推送（已支付）。 */
    PAID_ORDER_PUSH(
            "新订单推送（已支付）",
            "5110025",
            "msg_foodmop_3dca76a3-2434-4548-be17-d3258d17e967"
    ),

    /** 品牌提供取消订单。 */
    BRAND_ORDER_CANCEL(
            "品牌提供取消订单",
            "5110029",
            "msg_foodmop_c2d61f12-5312-4717-8fef-1d4cbba36709"
    );

    private static final String BUSINESS_ID = "51";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness51MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness51MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness51MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=51 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已知在线点消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness51MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 msgType 查找在线点消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness51MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
