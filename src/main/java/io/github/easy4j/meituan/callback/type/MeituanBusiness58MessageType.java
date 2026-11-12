package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz58.AllStoreResourceInventoryQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.AuthorizedStoreCountQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.BatchInventoryQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.CustomerLeadMessage;
import io.github.easy4j.meituan.callback.model.biz58.DeviceIdByQrCodeQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.GroupDealProjectMappingQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.HomeServiceInventoryQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.InventoryQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.LegacySessionMigrationCompletedMessage;
import io.github.easy4j.meituan.callback.model.biz58.MerchantIdentificationMessage;
import io.github.easy4j.meituan.callback.model.biz58.MigratedSessionTokenMessage;
import io.github.easy4j.meituan.callback.model.biz58.MonthlyChargeQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.MonthlySubscriptionCancelledMessage;
import io.github.easy4j.meituan.callback.model.biz58.MultiProductInventoryQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.MultiStoreDeviceStatusQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.OperateDeviceMessage;
import io.github.easy4j.meituan.callback.model.biz58.OrderNotificationMessage;
import io.github.easy4j.meituan.callback.model.biz58.OrderRefundInfoPushedMessage;
import io.github.easy4j.meituan.callback.model.biz58.RedemptionStatusQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.RefundWithdrawnMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationCancellationReviewMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationCancelledMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationChangeResultMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationChangeSubmittedMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationRedemptionMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationRefundFailedMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationResultMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservationStartedMessage;
import io.github.easy4j.meituan.callback.model.biz58.ReservedDeviceStartedMessage;
import io.github.easy4j.meituan.callback.model.biz58.RoomAuditResultMessage;
import io.github.easy4j.meituan.callback.model.biz58.RoomInformationQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.RoomPushResultMessage;
import io.github.easy4j.meituan.callback.model.biz58.SecondaryRefundMessage;
import io.github.easy4j.meituan.callback.model.biz58.SelfServiceDeviceOrderMessage;
import io.github.easy4j.meituan.callback.model.biz58.StaffTimeSlotInventoryQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.StartDeviceAndConsumeDealMessage;
import io.github.easy4j.meituan.callback.model.biz58.StoreDeviceStatusQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.StoreDevicesQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.StoreResourceInventoryQueryMessage;
import io.github.easy4j.meituan.callback.model.biz58.SurchargeOrderRedeemedMessage;
import io.github.easy4j.meituan.callback.model.biz58.SurchargePaymentResultMessage;
import io.github.easy4j.meituan.callback.model.biz58.TableOpeningSyncMessage;
import io.github.easy4j.meituan.callback.model.biz58.TechnicianAuditResultMessage;
import io.github.easy4j.meituan.callback.model.biz58.VideoResourceQueryMessage;
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
 * 服务零售（{@code businessId=58}）具有公开协议的消息类型目录。
 *
 * <p>该目录只登记能够从官方消息文档确认 {@code msgType} 的协议，不代表任一开发者
 * 账号当前已开通的能力集合。平台后续可能新增类型，调用方使用 {@code switch} 时应保留
 * {@code default} 分支。</p>
 */
@Getter
public enum MeituanBusiness58MessageType implements MeituanMessageType {

    /**
     * 操作设备。
     */
    OPERATE_DEVICE("操作设备", "5810149", "msg_ddzh_12820d14-4867-46b5-b527-210c123fc5e9", OperateDeviceMessage.class),
    /**
     * 启动设备并核销团单。
     */
    START_DEVICE_AND_CONSUME_DEAL("启动设备并核销团单", "5810147", "msg_ddzh_6ea4ba3a-a2c7-4e18-a897-c5c2ee96c47c", StartDeviceAndConsumeDealMessage.class),
    /**
     * 订单退款信息推送。
     */
    ORDER_REFUND_INFO_PUSHED("订单退款信息推送", "5810173", "msg_ddzh_a8ef235b-a621-4de4-b8d4-b0820980ea4f", OrderRefundInfoPushedMessage.class),
    /**
     * 取消预订。
     */
    RESERVATION_CANCELLED("取消预订", "5810001", "https://developer.meituan.com/docs/msg/msg_ddzh_0b1a03ad-7027-4045-92e2-bcde392cfd4f", ReservationCancelledMessage.class),
    /**
     * 预订结果同步。
     */
    RESERVATION_RESULT("预订结果同步", "5810003", "https://developer.meituan.com/docs/msg/msg_ddzh_f84503ae-994c-47ca-899b-2823bf201048", ReservationResultMessage.class),
    /**
     * 用户撤销退款通知。
     */
    REFUND_WITHDRAWN("用户撤销退款通知", "5810005", "https://developer.meituan.com/docs/msg/msg_ddzh_3a4f32f3-1ee6-4db5-b411-031469e6df4f", RefundWithdrawnMessage.class),
    /**
     * 改约结果通知三方。
     */
    RESERVATION_CHANGE_RESULT("改约结果通知三方", "5810007", "https://developer.meituan.com/docs/msg/msg_ddzh_a0fbb149-f754-444e-ae81-2792d460d6c6", ReservationChangeResultMessage.class),
    /**
     * 到家行业库存查询。
     */
    HOME_SERVICE_INVENTORY_QUERY("到家行业库存查询", "5810009", "https://developer.meituan.com/docs/msg/msg_ddzh_391676bf-4d52-4a88-9c9c-a8ccf6a05da5", HomeServiceInventoryQueryMessage.class),
    /**
     * 批量查询商家固定时间点服务人员库存。
     */
    STAFF_TIME_SLOT_INVENTORY_QUERY("批量查询商家固定时间点服务人员库存", "5810011", "https://developer.meituan.com/docs/msg/msg_ddzh_e1f3eacf-c538-4357-abeb-d95de1ad1db4", StaffTimeSlotInventoryQueryMessage.class),
    /**
     * 取消预订审核。
     */
    RESERVATION_CANCELLATION_REVIEW("取消预订审核", "5810013", "https://developer.meituan.com/docs/msg/msg_ddzh_dc9fb7af-c0a2-4702-a9f5-f55866ebfe97", ReservationCancellationReviewMessage.class),
    /**
     * 改约提交。
     */
    RESERVATION_CHANGE_SUBMITTED("改约提交", "5810015", "https://developer.meituan.com/docs/msg/msg_ddzh_ebd8fc97-8ff0-4d77-b438-b86aaa5bf818", ReservationChangeSubmittedMessage.class),
    /**
     * 开始预订。
     */
    RESERVATION_STARTED("开始预订", "5810017", "https://developer.meituan.com/docs/msg/msg_ddzh_c08eb5f3-ba98-4c97-8579-7d95757df2b4", ReservationStartedMessage.class),
    /**
     * 查询三方房间信息。
     */
    ROOM_INFORMATION_QUERY("查询三方房间信息", "5810019", "https://developer.meituan.com/docs/msg/msg_ddzh_154a5f56-e436-4aff-a124-5651bd1dc590", RoomInformationQueryMessage.class),
    /**
     * 单个查询库存。
     */
    INVENTORY_QUERY("单个查询库存", "5810021", "https://developer.meituan.com/docs/msg/msg_ddzh_952bd534-0b45-4cae-90b7-ba7790e7b978", InventoryQueryMessage.class),
    /**
     * 核销状态查询。
     */
    REDEMPTION_STATUS_QUERY("核销状态查询", "5810023", "https://developer.meituan.com/docs/msg/msg_ddzh_c22a6603-c6b6-4b47-83bb-9752288fd4dc", RedemptionStatusQueryMessage.class),
    /**
     * 批量获取库存。
     */
    BATCH_INVENTORY_QUERY("批量获取库存", "5810025", "https://developer.meituan.com/docs/msg/msg_ddzh_3e3c9cce-babf-4faf-9e87-6949e471b8dc", BatchInventoryQueryMessage.class),
    /**
     * 预订设备启动。
     */
    RESERVED_DEVICE_STARTED("预订设备启动", "5810027", "https://developer.meituan.com/docs/msg/msg_ddzh_ad563069-6449-4503-b9eb-81406b5f657a", ReservedDeviceStartedMessage.class),
    /**
     * 补价支付结果。
     */
    SURCHARGE_PAYMENT_RESULT("补价支付结果", "5810029", "https://developer.meituan.com/docs/msg/msg_ddzh_e1900c6f-df1d-435b-9c23-653562a5e1b2", SurchargePaymentResultMessage.class),
    /**
     * 预订核销同步。
     */
    RESERVATION_REDEMPTION("预订核销同步", "5810031", "https://developer.meituan.com/docs/msg/msg_ddzh_927cf9da-5294-4e0a-83c1-665d06f31b47", ReservationRedemptionMessage.class),
    /**
     * 多商品库存批量查询。
     */
    MULTI_PRODUCT_INVENTORY_QUERY("多商品库存批量查询", "5810033", "https://developer.meituan.com/docs/msg/msg_ddzh_e1371f36-2c45-4e90-8b9e-43dda8bb16e8", MultiProductInventoryQueryMessage.class),
    /**
     * 推送顾客线索消息。
     */
    CUSTOMER_LEAD("推送顾客线索消息", "5810053", "https://developer.meituan.com/docs/msg/msg_ddzh_8cd0c2b0-f10d-4226-9d47-6c6f9e336484", CustomerLeadMessage.class),
    /**
     * 订单信息推送。
     */
    ORDER_NOTIFICATION("订单信息推送", "5810055", "https://developer.meituan.com/docs/msg/msg_ddzh_6fae169d-1eb4-4881-aa04-da68a4a33106", OrderNotificationMessage.class),
    /**
     * 商户识别。
     */
    MERCHANT_IDENTIFICATION("商户识别", "5810077", "https://developer.meituan.com/docs/msg/msg_ddzh_a3e73815-9fe7-450f-a493-e9e11d68ef5e", MerchantIdentificationMessage.class),
    /**
     * 接收session迁移后的合作中心token。
     */
    MIGRATED_SESSION_TOKEN("接收session迁移后的合作中心token", "5810079", "https://developer.meituan.com/docs/msg/msg_ddzh_41c5e119-c6a5-4a74-83cf-7719a6f7ffed", MigratedSessionTokenMessage.class),
    /**
     * 接收原北极星session迁移完毕状态。
     */
    LEGACY_SESSION_MIGRATION_COMPLETED("接收原北极星session迁移完毕状态", "5810083", "https://developer.meituan.com/docs/msg/msg_ddzh_23e7ff83-c8db-41ab-beb0-206c72b61520", LegacySessionMigrationCompletedMessage.class),
    /**
     * 查询指定门店资源库存。
     */
    STORE_RESOURCE_INVENTORY_QUERY("查询指定门店资源库存", "5810093", "https://developer.meituan.com/docs/msg/msg_ddzh_d2731034-87f5-4602-8c51-84222eb85227", StoreResourceInventoryQueryMessage.class),
    /**
     * 查询全量门店资源库存数据。
     */
    ALL_STORE_RESOURCE_INVENTORY_QUERY("查询全量门店资源库存数据", "5810095", "https://developer.meituan.com/docs/msg/msg_ddzh_bbe33bf7-e79c-4a6d-8741-869b0b7b2b29", AllStoreResourceInventoryQueryMessage.class),
    /**
     * 查询视频资源。
     */
    VIDEO_RESOURCE_QUERY("查询视频资源", "5810097", "https://developer.meituan.com/docs/msg/msg_ddzh_8ea56270-db80-4f0f-9e8c-60293f6e554d", VideoResourceQueryMessage.class),
    /**
     * 加价尾单核销通知。
     */
    SURCHARGE_ORDER_REDEEMED("加价尾单核销通知", "5810099", "https://developer.meituan.com/docs/msg/msg_ddzh_66fc027d-ab11-4fa0-b2eb-066b0acd7263", SurchargeOrderRedeemedMessage.class),
    /**
     * 开台信息同步。
     */
    TABLE_OPENING_SYNC("开台信息同步", "5810101", "https://developer.meituan.com/docs/msg/msg_ddzh_25f138ce-eeb0-42c2-8f7e-df65447aeaa1", TableOpeningSyncMessage.class),
    /**
     * 手艺人审核结果通知。
     */
    TECHNICIAN_AUDIT_RESULT("手艺人审核结果通知", "5810105", "https://developer.meituan.com/docs/msg/msg_ddzh_885450f6-7010-4cc5-914a-571155ac982e", TechnicianAuditResultMessage.class),
    /**
     * 自助设备订单信息推送。
     */
    SELF_SERVICE_DEVICE_ORDER("自助设备订单信息推送", "5810145", "https://developer.meituan.com/docs/msg/msg_ddzh_165fdd05-1c25-4f13-9f62-285324deda4c", SelfServiceDeviceOrderMessage.class),
    /**
     * 根据二维码URL查询设备ID。
     */
    DEVICE_ID_BY_QR_CODE_QUERY("根据二维码URL查询设备ID", "5810151", "https://developer.meituan.com/docs/msg/msg_ddzh_f75bf731-c6fb-42fe-aa1b-597ebedddbc9", DeviceIdByQrCodeQueryMessage.class),
    /**
     * 查询单个门店下指定设备状态。
     */
    STORE_DEVICE_STATUS_QUERY("查询单个门店下指定设备状态", "5810153", "https://developer.meituan.com/docs/msg/msg_ddzh_8fd1159c-e946-4749-8b3d-787f8e3f7143", StoreDeviceStatusQueryMessage.class),
    /**
     * 查询指定门店下全量设备信息。
     */
    STORE_DEVICES_QUERY("查询指定门店下全量设备信息", "5810155", "https://developer.meituan.com/docs/msg/msg_ddzh_18fa357c-fd6f-4a3c-aff7-f891be2c3c92", StoreDevicesQueryMessage.class),
    /**
     * 查询三方开发者货架插件授权门店数量。
     */
    AUTHORIZED_STORE_COUNT_QUERY("查询三方开发者货架插件授权门店数量", "5810157", "https://developer.meituan.com/docs/msg/msg_ddzh_d17b551c-683e-4f94-a3ed-9e0c8dd09141", AuthorizedStoreCountQueryMessage.class),
    /**
     * 多门店三方设备号批量查询设备状态。
     */
    MULTI_STORE_DEVICE_STATUS_QUERY("多门店三方设备号批量查询设备状态", "5810161", "https://developer.meituan.com/docs/msg/msg_ddzh_747ad6b5-8cca-4853-b84f-144fedd02750", MultiStoreDeviceStatusQueryMessage.class),
    /**
     * 包型包间推送结果通知。
     */
    ROOM_PUSH_RESULT("包型包间推送结果通知", "5810162", "https://developer.meituan.com/docs/msg/msg_ddzh_2f06a02d-0ebf-40a4-9789-cddfd5b05403", RoomPushResultMessage.class),
    /**
     * 团购三方项目Id关联关系查询。
     */
    GROUP_DEAL_PROJECT_MAPPING_QUERY("团购三方项目Id关联关系查询", "5810163", "https://developer.meituan.com/docs/msg/msg_ddzh_387e2d53-3f92-44b6-8236-ec795952b954", GroupDealProjectMappingQueryMessage.class),
    /**
     * 次月扣款查询。
     */
    MONTHLY_CHARGE_QUERY("次月扣款查询", "5810239", "https://developer.meituan.com/docs/msg/msg_ddzh_0bb991f6-1aa1-47cb-9322-2b92ae232cf1", MonthlyChargeQueryMessage.class),
    /**
     * 取消连续包月通知。
     */
    MONTHLY_SUBSCRIPTION_CANCELLED("取消连续包月通知", "5810241", "https://developer.meituan.com/docs/msg/msg_ddzh_dcc3a1b9-a6ab-4f0d-8d63-9c0d25938a0d", MonthlySubscriptionCancelledMessage.class),
    /**
     * 二次退款通知。
     */
    SECONDARY_REFUND("二次退款通知", "5810245", "https://developer.meituan.com/docs/msg/msg_ddzh_5d5c559c-f667-4f69-8645-9338284c984b", SecondaryRefundMessage.class),
    /**
     * 包型包间审核结果通知。
     */
    ROOM_AUDIT_RESULT("包型包间审核结果通知", "5810247", "https://developer.meituan.com/docs/msg/msg_ddzh_94957cd6-851a-4ab9-a5cc-94d18b431209", RoomAuditResultMessage.class),
    /**
     * 预订退款失败通知。
     */
    RESERVATION_REFUND_FAILED("预订退款失败通知", "5810251", "https://developer.meituan.com/docs/msg/msg_ddzh_0274c0a7-c408-4f2d-bb03-0ed1bf40f09f", ReservationRefundFailedMessage.class);

    /**
     * 当前消息目录所属的官方业务编号。
     */
    private static final String BUSINESS_ID = "58";
    /**
     * 官网消息文档地址的基础路径。
     */
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";

    /**
     * 按消息编号建立的只读枚举索引。
     */
    private static final Map<String, MeituanBusiness58MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness58MessageType::getMsgType, Function.identity()))
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
    MeituanBusiness58MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
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
     * 在确认回调属于 {@code businessId=58} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return {@code businessId=58} 的已知消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness58MessageType> resolve(MeituanCallbackMessage<?> callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据 {@code businessId=58} 回调中的 msgType 查找消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness58MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
