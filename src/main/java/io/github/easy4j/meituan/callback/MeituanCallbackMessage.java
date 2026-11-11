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

    MeituanCallbackMessage(Map<String, String> parameters, T message) {
        this(parameters, message, StrUtil.isNotBlank(parameters.get("message"))
                ? parameters.get("message") : parameters.get("param"));
    }

    MeituanCallbackMessage(Map<String, String> parameters, T message, String rawMessage) {
        Map<String, String> copiedParameters = new LinkedHashMap<>(parameters);
        this.parameters = Collections.unmodifiableMap(copiedParameters);
        this.msgType = MeituanCallbackParser.findValue(
                copiedParameters, "msgType", "msg_type", "msgtype", "invokeType", "invoke_type");
        this.timestamp = MeituanCallbackParser.findValue(copiedParameters, "timestamp");
        this.sign = MeituanCallbackParser.findValue(copiedParameters, "sign", "signature");
        this.developerId = MeituanCallbackParser.findValue(copiedParameters, "developerId", "developer_id");
        this.businessId = MeituanCallbackParser.findValue(copiedParameters, "businessId", "business_id");
        this.msgId = MeituanCallbackParser.findValue(copiedParameters, "msgId", "msg_id", "msgid");
        this.opBizCode = MeituanCallbackParser.findValue(copiedParameters, "opBizCode", "op_biz_code", "opbizcode");
        this.ePoiId = MeituanCallbackParser.findValue(copiedParameters, "ePoiId", "e_poi_id");
        this.message = message;
        this.rawMessage = rawMessage;
    }

}
