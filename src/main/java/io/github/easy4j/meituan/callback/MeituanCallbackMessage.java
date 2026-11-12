package io.github.easy4j.meituan.callback;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 美团消息回调公共参数及泛型业务消息。
 *
 * <p>{@link CallbackUtil} 将业务内容转换为指定类型，同时保留解码后的回调参数供验签使用。</p>
 *
 * @param <T> 业务消息类型；仅解析表单时为 {@link String}
 */
@Getter
public final class MeituanCallbackMessage<T> {

    /**
     * 消息类型。旧版会员卡协议取自 {@code invokeType}。
     */
    private final String msgType;

    /**
     * 平台推送的时间戳原值。
     */
    private final String timestamp;

    /**
     * 平台随回调发送的签名。
     */
    private final String sign;

    /**
     * 接收回调的开发者 ID。
     */
    private final String developerId;

    /**
     * 消息所属的美团业务 ID。
     */
    private final String businessId;

    /**
     * 本次推送的消息 ID，可用于识别重复推送。
     */
    private final String msgId;

    /**
     * 授权实体标识，通常对应门店或客户。
     */
    private final String opBizCode;

    /**
     * 开发者系统中的门店 ID。
     */
    private final String ePoiId;

    /**
     * 按指定类型解析的业务内容。
     */
    private final T message;

    /**
     * 解码后的业务参数文本。整张表单直接承载业务字段时，此值可为 {@code null}。
     */
    private final String rawMessage;

    /**
     * 验签使用的只读参数快照，包含输入中的扩展字段。
     */
    private final Map<String, String> parameters;

    /**
     * 保存回调参数快照、业务对象和原始文本。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @param message 业务消息对象或处理结果说明
     */
    MeituanCallbackMessage(Map<String, String> parameters, T message) {
        this(parameters, message, rawMessage(parameters));
    }

    /**
     * 保存回调参数快照、业务对象和原始文本。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @param message 业务消息对象或处理结果说明
     * @param rawMessage 用于验签和排查问题的原始业务文本
     */
    MeituanCallbackMessage(Map<String, String> parameters, T message, String rawMessage) {
        Map<String, String> copiedParameters = new LinkedHashMap<>(parameters);
        this.parameters = Collections.unmodifiableMap(copiedParameters);
        this.msgType = msgType(copiedParameters);
        this.timestamp = findValue(copiedParameters, "timestamp");
        this.sign = findValue(copiedParameters, "sign", "signature");
        this.developerId = findValue(copiedParameters, "developerId", "developer_id");
        this.businessId = businessId(copiedParameters);
        this.msgId = findValue(copiedParameters, "msgId", "msg_id", "msgid");
        this.opBizCode = findValue(copiedParameters, "opBizCode", "op_biz_code", "opbizcode");
        this.ePoiId = findValue(copiedParameters, "ePoiId", "e_poi_id");
        this.message = message;
        this.rawMessage = rawMessage;
    }

    /**
     * 按标准字段及旧协议字段的优先级读取消息编号。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @return 按标准字段及旧协议字段的优先级读取消息编号的结果
     */
    static String msgType(Map<String, String> parameters) {
        return findValue(parameters, "msgType", "msg_type", "msgtype", "invokeType", "invoke_type");
    }

    /**
     * 读取标准字段或下划线字段中的业务编号。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @return 读取标准字段或下划线字段中的业务编号的结果
     */
    static String businessId(Map<String, String> parameters) {
        return findValue(parameters, "businessId", "business_id");
    }

    /**
     * 按键名优先级查找首个非空白参数并裁剪其首尾空白。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @param keys 按查找优先级排列的参数名
     * @return 按键名优先级查找首个非空白参数并裁剪其首尾空白的结果
     */
    private static String findValue(Map<String, String> parameters, String... keys) {
        for (String key : keys) {
            String value = parameters.get(key);
            if (StrUtil.isNotBlank(value)) {
                return value.trim();
            }
        }
        return null;
    }

    /**
     * 读取业务参数原文，标准字段为空白时使用旧协议字段。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @return 读取业务参数原文，标准字段为空白时使用旧协议字段的结果
     */
    static String rawMessage(Map<String, String> parameters) {
        return StrUtil.isNotBlank(parameters.get("message")) ? parameters.get("message") : parameters.get("param");
    }
}
