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
 * 业务 {@code businessId=16} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness16MessageType {

    /**
     * 接收订单配送状态消息。
     */
    ORDER_DELIVERY_STATUS("接收订单配送状态消息", "16101", "https://developer.meituan.com/docs/msg/msg_wmoperng_518e4127-0a7d-40ef-b4c3-5ea4c47969be"),
    /**
     * 接收订单消息。
     */
    ORDER_NOTIFICATION("接收订单消息", "16102", "https://developer.meituan.com/docs/msg/msg_wmoperng_e166a543-49a3-4ce2-8663-35f41ea8b415"),
    /**
     * 接收部分退款回调接口。
     */
    PARTIAL_REFUND("接收部分退款回调接口", "1610009", "https://developer.meituan.com/docs/msg/msg_wmoperng_3a03df24-a1c3-41e5-8b64-653542166018"),
    /**
     * 推送订单出餐状态。
     */
    MEAL_PREPARATION_STATUS("推送订单出餐状态", "1610013", "https://developer.meituan.com/docs/msg/msg_wmoperng_b21fef3b-dc3c-4848-8dd1-5a37403cf313"),
    /**
     * 接收用户催商家审核退款消息。
     */
    REFUND_REVIEW_REMINDER("接收用户催商家审核退款消息", "1610015", "https://developer.meituan.com/docs/msg/msg_wmoperng_fedafb83-675d-4d97-8156-0ba95aadf2a1"),
    /**
     * 推送是否可发配送。
     */
    DISPATCH_ELIGIBILITY("推送是否可发配送", "1610019", "https://developer.meituan.com/docs/msg/msg_wmoperng_5eb67b95-94be-4f04-aa5f-8fd64c2e9457"),
    /**
     * 短信发送结果回调。
     */
    SMS_DELIVERY_RESULT("短信发送结果回调", "1610031", "https://developer.meituan.com/docs/msg/msg_wmoperng_6df899a1-136f-452e-bb3f-7802f7111d65");

    private static final String BUSINESS_ID = "16";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness16MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness16MessageType::getMsgType, Function.identity()))
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

    MeituanBusiness16MessageType(String displayName, String msgType, String documentKey) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
    }

    /**
     * 在确认回调属于 {@code businessId=16} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness16MessageType> resolve(MeituanCallbackMessage<?> callback) {
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
    public static Optional<MeituanBusiness16MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
