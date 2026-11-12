package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
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
 * 业务 {@code businessId=92} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness92MessageType {

    /**
     * 门店列表查询。
     */
    STORE_LIST_QUERY("门店列表查询", "9210001", "https://developer.meituan.com/docs/msg/msg_rental_b7e2df61-29e4-4e11-8fe6-85527aadecaf"),
    /**
     * 售卖车型库查询。
     */
    VEHICLE_MODEL_QUERY("售卖车型库查询", "9210003", "https://developer.meituan.com/docs/msg/msg_rental_caf10bff-4041-45d3-8540-0b7914bb07c3"),
    /**
     * 报价列表查询。
     */
    QUOTE_LIST_QUERY("报价列表查询", "9210005", "https://developer.meituan.com/docs/msg/msg_rental_8fb4f32e-11c1-4e5c-a476-c50fec37d768"),
    /**
     * 报价详情查询。
     */
    QUOTE_DETAIL_QUERY("报价详情查询", "9210007", "https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891"),
    /**
     * 下单预校验。
     */
    ORDER_PRECHECK("下单预校验", "9210009", "https://developer.meituan.com/docs/msg/msg_rental_a40c4fd2-2cee-432b-9877-6594015218ea"),
    /**
     * 下单。
     */
    ORDER_PLACED("下单", "9210011", "https://developer.meituan.com/docs/msg/msg_rental_77c13fc2-0902-4876-af97-a85d96a37692"),
    /**
     * 订单预取消。
     */
    ORDER_CANCELLATION_PRECHECK("订单预取消", "9210013", "https://developer.meituan.com/docs/msg/msg_rental_1ea72825-e410-48e1-b6c4-d1085dc366ef"),
    /**
     * 订单取消。
     */
    ORDER_CANCELLED("订单取消", "9210015", "https://developer.meituan.com/docs/msg/msg_rental_7279603f-72ae-4904-8fb4-81ba0362f4e5"),
    /**
     * 订单续租报价查询。
     */
    RENTAL_EXTENSION_QUOTE_QUERY("订单续租报价查询", "9210017", "https://developer.meituan.com/docs/msg/msg_rental_8de7d873-af5f-4323-91b4-59c6ed617263"),
    /**
     * 订单续租预校验。
     */
    RENTAL_EXTENSION_PRECHECK("订单续租预校验", "9210019", "https://developer.meituan.com/docs/msg/msg_rental_9ee76877-45b1-4432-b44b-ed299e44175d"),
    /**
     * 续租取消检查。
     */
    RENTAL_EXTENSION_CANCELLATION_CHECK("续租取消检查", "9210021", "https://developer.meituan.com/docs/msg/msg_rental_5dbbbbd2-153e-4a1a-9760-b8d86eb23c5c"),
    /**
     * 续租取消。
     */
    RENTAL_EXTENSION_CANCELLED("续租取消", "9210023", "https://developer.meituan.com/docs/msg/msg_rental_ecc0df85-921a-4667-a7ae-465d8f96c2ac"),
    /**
     * 提前还车检查。
     */
    EARLY_RETURN_CHECK("提前还车检查", "9210025", "https://developer.meituan.com/docs/msg/msg_rental_449cbd33-ca5b-4625-9483-9c63f123b37e"),
    /**
     * 押金冻结通知。
     */
    DEPOSIT_FROZEN("押金冻结通知", "9210027", "https://developer.meituan.com/docs/msg/msg_rental_69082f18-a384-4785-a789-acf1a2c470b3"),
    /**
     * 驾驶员修改。
     */
    DRIVER_CHANGED("驾驶员修改", "9210029", "https://developer.meituan.com/docs/msg/msg_rental_50774f47-470d-4336-ae7a-0d23478d32e4"),
    /**
     * 订单详情查询。
     */
    ORDER_DETAIL_QUERY("订单详情查询", "9210031", "https://developer.meituan.com/docs/msg/msg_rental_1d80724b-a152-4d9f-9aa2-cec1e5b7e8a9"),
    /**
     * 退款结果回调。
     */
    REFUND_RESULT("退款结果回调", "9210033", "https://developer.meituan.com/docs/msg/msg_rental_f5840e37-6390-4ec1-8634-a96a583d4fcf"),
    /**
     * 押金扣款结果回调。
     */
    DEPOSIT_DEDUCTION_RESULT("押金扣款结果回调", "9210035", "https://developer.meituan.com/docs/msg/msg_rental_3b5ec62b-dfc5-4028-ac8a-9a3259996029"),
    /**
     * 押金扣款退款结果回调。
     */
    DEPOSIT_DEDUCTION_REFUND_RESULT("押金扣款退款结果回调", "9210037", "https://developer.meituan.com/docs/msg/msg_rental_9a014959-e27d-42ae-b665-081ef730173d"),
    /**
     * 订单续租下单。
     */
    RENTAL_EXTENSION_ORDER("订单续租下单", "9210039", "https://developer.meituan.com/docs/msg/msg_rental_56c92d5f-85c5-40e2-a1d1-942a6bc279eb"),
    /**
     * 押金解冻结果回调。
     */
    DEPOSIT_UNFREEZE_RESULT("押金解冻结果回调", "9210040", "https://developer.meituan.com/docs/msg/msg_rental_518ff9a5-7a8d-4ec5-b3b6-e5d76defbb47");

    private static final String BUSINESS_ID = "92";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness92MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness92MessageType::getMsgType, Function.identity()))
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

    MeituanBusiness92MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
    }

    /**
     * 在确认回调属于 {@code businessId=92} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness92MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness92MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
