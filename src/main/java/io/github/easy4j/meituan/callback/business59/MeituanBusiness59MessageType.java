package io.github.easy4j.meituan.callback.business59;

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
 * 服务零售（客户，businessId=59）具有公开协议的消息类型目录。
 * <p>该目录只登记能够从官方消息文档确认 {@code msgType} 的协议，不代表任一开发者
 * 账号当前已开通的能力集合。平台后续可能新增类型，调用方使用 {@code switch} 时应保留
 * {@code default} 分支。</p>
 */
@Getter
public enum MeituanBusiness59MessageType {

    /** 商品状态变更。 */
    PRODUCT_STATUS_CHANGED("商品状态变更", "5910003", "msg_ddzhkh_96f04b32-2780-4a0d-af3e-529dd7fa2490"),
    /** 商家券已消费退通知。 */
    MERCHANT_COUPON_CONSUMED_REFUND_NOTICE("商家券-已消费退通知接口", "5910025", "msg_ddzhkh_6b7209e5-f24f-4547-81a0-bb1f4fb21f7f"),
    /** 商家券强退通知。 */
    MERCHANT_COUPON_FORCED_REFUND_NOTICE("商家券-强退通知接口", "5910027", "msg_ddzhkh_12d0dc9e-ee01-42ac-ab05-1c0bf266c3df"),
    /** 商家券退券通知。 */
    MERCHANT_COUPON_REFUND("商家券退券", "5910029", "msg_ddzhkh_593a32a9-0dbc-4ca4-abd9-750153ff3ec1"),
    /** 商家券发券通知。 */
    MERCHANT_COUPON_ISSUE("商家券发券", "5910031", "msg_ddzhkh_59ffc833-1474-4f06-964f-42c5fd1b5647"),
    /** 商家券动态核销码通知。 */
    MERCHANT_COUPON_DYNAMIC_CODE("商家券获取动态核销码", "5910035", "msg_ddzhkh_f14d537b-97e0-4bd0-b595-9f66a86e7d30"),
    /** 创建会员通知。 */
    MEMBER_CREATED("创建会员", "5910019", "msg_ddzhkh_24aba593-6dfa-4391-9f10-84c3b2c7ea07"),
    /** 查询会员级别通知。 */
    MEMBER_LEVEL_QUERIED("查询会员级别", "5910021", "msg_ddzhkh_87291f75-1b2e-42e0-a8bd-9e3c1b51d229"),
    /** 预约取消同步三方。 */
    RESERVATION_CANCEL_SYNC("取消同步三方接口", "5910011", "msg_ddzhkh_cda08228-2c64-4177-bedc-1d5b35d164c2"),
    /** 预约取消结果同步。 */
    RESERVATION_CANCEL_RESULT_SYNC("取消结果同步三方", "5910013", "msg_ddzhkh_6ba0dd9e-04e0-45e6-a3aa-4937d7598c16"),
    /** 预约创单同步三方。 */
    RESERVATION_CREATE_SYNC("创单同步三方接口", "5910015", "msg_ddzhkh_70680584-cd1b-471f-aac6-d4d9bfbba5a9"),
    /** 用户改约通知。 */
    RESERVATION_USER_MODIFIED("用户改约", "5910017", "msg_ddzhkh_0d364a1f-64a2-442c-8d9c-20368541ef62"),
    /** 改约结果同步三方。 */
    RESERVATION_MODIFY_RESULT_SYNC("改约结果同步三方", "5910005", "msg_ddzhkh_28cd1684-804f-4ce5-b2f3-b8dfc6f3373e"),
    /** 查询库存。 */
    INVENTORY_QUERIED("查询库存接口", "5910007", "msg_ddzhkh_b0a7f77b-2480-431d-9bf2-0d1321e6d993"),
    /** 查询三方可用手艺人。 */
    AVAILABLE_TECHNICIAN_QUERIED("查询三方可用手艺人", "5910033", "msg_ddzhkh_0b4bf40c-5993-4897-a086-ff6cba0ed5cd"),
    /** 履约状态变更通知。 */
    FULFILLMENT_STATUS_CHANGED("履约状态变更通知商家", "5910009", "msg_ddzhkh_e6a2b815-4b19-484b-a795-39d33ceecc26"),
    /** 商品上下架状态通知。 */
    PRODUCT_ONLINE_STATUS_CHANGED("商品上下架状态通知", "5910049", "msg_ddzhkh_79cb15bc-bccd-4564-aa15-a5163fef9fa3"),
    /** 查询通话记录。 */
    CALL_RECORDS_QUERIED("查询通话记录（对账或补偿使用）", "5910071", "msg_ddzhkh_ee50457f-2740-4256-8dcd-73e95e42c8dc"),
    /** 支付结果通知。 */
    PAYMENT_RESULT_NOTIFIED("支付结果通知", "5910081", "msg_ddzhkh_94529cae-263a-41ed-bbdc-4e5793ffcf50"),
    /** 退款结果通知。 */
    REFUND_RESULT_NOTIFIED("退款结果通知", "5910083", "msg_ddzhkh_eda2b789-7728-4c6e-8318-45dc72afe83d"),
    /** 批量查询库存。 */
    INVENTORY_BATCH_QUERIED("批量查询库存", "5910079", "msg_ddzhkh_a2c86c6b-dfe3-40da-b7c8-7383a6c8edc2"),
    /** 商家券批量查询三方订单。 */
    MERCHANT_COUPON_ORDER_BATCH_QUERIED("商家券批量查询三方订单信息", "5910105", "msg_ddzhkh_ea80d356-994b-4460-831e-f6f2176425ff"),
    /** 俱乐部活动审核结果通知。 */
    CLUB_ACTIVITY_AUDIT_RESULT("俱乐部活动审核结果通知", "5910101", "msg_ddzhkh_cc1c6e1a-a79a-4886-b9b1-c11357283d58"),
    /** 查询活动场次参与人。 */
    CLUB_ACTIVITY_PARTICIPANTS_QUERIED("查询活动场次参与人接口", "5910103", "msg_ddzhkh_a7fabe92-48c6-4922-9575-f947a6d5e9dc"),
    /** 商场会员无感积分授权通知。 */
    MALL_MEMBER_POINTS_AUTHORIZED("商场会员无感积分授权通知", "5910099", "msg_ddzhkh_6c3b3f8e-f092-4815-8c75-ae427ab1b34c"),
    /** 商场积分交易事件推送。 */
    MALL_POINTS_TRANSACTION_PUSHED("商场积分交易事件推送", "5910093", "msg_ddzhkh_e2e9abe0-68f2-48e7-bcce-e6dcacc978c5"),
    /** 团单发布通知。 */
    DEAL_GROUP_PUBLISHED("团单发布通知", "5910109", "msg_ddzhkh_bfc39315-dfd7-4046-b487-6d37b7e40aa9"),
    /** 预约单操作结果同步。 */
    RESERVATION_OPERATION_RESULT_SYNC("预约单操作结果同步", "5910135", "msg_ddzhkh_195769d5-876b-49dc-aecc-a12d8aeef8f4"),
    /** 商家券降级消息推送。 */
    MERCHANT_COUPON_DEGRADED("商家券降级消息推送", "5910139", "msg_ddzhkh_48e46879-9c02-40f0-9e6e-de751d55714d"),
    /** 批量推送团购关联包型包间结果。 */
    DEAL_GROUP_ROOM_RELATION_RESULT("批量推送团购关联包型包间结果通知", "5910147", "msg_ddzhkh_aab66160-8538-4012-b55c-d8fe95651fa5"),
    /** 团购商品变更通知。 */
    GROUP_BUY_PRODUCT_CHANGED("团购商品变更通知", "5910137", "msg_ddzhkh_c88e2de3-2c2d-487c-8068-5ee74e12e03d"),
    /** 演出项目状态更新通知。 */
    SHOW_EVENT_STATUS_UPDATED("演出项目状态更新通知", "5910141", "msg_ddzhkh_a2c040da-23e8-4d2a-9432-0068d355e541"),
    /** 会员注销通知。 */
    MEMBER_UNREGISTERED("会员注销", "5910149", "msg_ddzhkh_f34f7833-4633-4725-98ac-a3ee75ecd32e");

    private static final String BUSINESS_ID = "59";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";

    private static final Map<String, MeituanBusiness59MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness59MessageType::getMsgType, Function.identity()))
    );

    private final String displayName;
    private final String msgType;
    private final String documentUrl;

    MeituanBusiness59MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = DOCUMENT_BASE_URL + documentKey;
    }

    /**
     * 在确认回调属于 businessId=59 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return businessId=59 的已知消息；其他业务或未知类型返回 empty
     */
    public static Optional<MeituanBusiness59MessageType> resolve(MeituanCallbackMessage callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 businessId=59 回调中的 msgType 查找消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness59MessageType> fromMsgType(String msgType) {
        if (!StringUtils.hasText(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
