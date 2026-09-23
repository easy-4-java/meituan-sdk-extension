package io.github.easy4j.meituan.callback;

import lombok.Getter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 美团消息回调公共参数及原始业务消息。
 * <p>该对象不依赖 Servlet 或 JSON 框架，业务方可在任意 Web 技术栈中接收回调后，
 * 将 form 参数交给 {@link MeituanCallbackParser} 解析，再按 {@code msgType} 路由。</p>
 */
@Getter
public final class MeituanCallbackMessage {

    private final String msgType;
    private final String timestamp;
    private final String sign;
    private final String developerId;
    private final String businessId;
    private final String msgId;
    private final String opBizCode;
    private final String ePoiId;
    private final String message;
    private final Map<String, String> parameters;

    MeituanCallbackMessage(Map<String, String> parameters) {
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
        this.message = MeituanCallbackParser.findValue(copiedParameters, "message", "param");
    }

}
