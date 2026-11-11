package io.github.easy4j.meituan.callback;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import cn.hutool.http.ContentType;
import jakarta.servlet.http.HttpServletRequest;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 将美团回调表单或 JSON 信封转换为带业务对象的统一回调模型。
 *
 * <p>保留原始参数用于验签，未知业务字段按 Jackson 配置忽略。</p>
 */
public final class CallbackUtil {

    private static final ObjectMapper MAPPER = JsonMapper.builder()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .build();

    private CallbackUtil() {
    }

    /**
     * 解析 Servlet 回调请求。
     *
     * <p>表单参数由容器解码；其他请求从查询串与正文读取。</p>
     *
     * @param <T> 业务消息类型
     * @param request Jakarta Servlet 请求，表单和正文应在被消费前调用
     * @param msgClass 业务内容的目标类型；{@link String} 表示保留文本
     * @return 包含业务对象和原始验签参数的回调对象
     * @throws NullPointerException 当 {@code request} 或 {@code msgClass} 为 {@code null} 时
     * @throws IllegalArgumentException 请求读取失败、缺少业务消息或业务消息格式错误
     */
    public static <T> MeituanCallbackMessage<T> parse(HttpServletRequest request, Class<T> msgClass) {
        Objects.requireNonNull(request, "request must not be null");
        Objects.requireNonNull(msgClass, "msgClass must not be null");
        try {
            if (Objects.isNull(request.getCharacterEncoding())) {
                request.setCharacterEncoding(StandardCharsets.UTF_8.name());
            }
            if (ContentType.isFormUrlEncode(request.getContentType())) {
                return parse(null, JakartaServletUtil.getParams(request), msgClass);
            }
            return parse(request.getQueryString(), JakartaServletUtil.getBody(request), msgClass);
        } catch (IOException | IORuntimeException e) {
            Throwable cause = e instanceof IORuntimeException ? e.getCause() : e;
            throw new IllegalArgumentException("Cannot read Meituan callback request", cause);
        }
    }

    /**
     * 合并查询参数与回调正文，并将业务内容转换为指定类型。
     *
     * <p>query 为可带问号的 URL-encoded 查询串，body 可为表单字符串、JSON 信封字符串、
     * 已解码 Map、信封对象或已解析的回调对象。正文同名参数优先于查询参数。
     * {@code String.class} 保留原始业务文本，其他类型使用 Jackson 反序列化。
     * 对象型 {@code message} 会重新序列化，验签时应使用平台发送的表单参数。</p>
     *
     * <p>标准回调读取 {@code message}，旧版会员卡读取 {@code param}。其他历史协议
     * 可通过 {@link CallbackPayload} 指定业务参数名或使用整个表单。</p>
     *
     * @param <T> 业务消息类型
     * @param query URL-encoded 查询串，可为空
     * @param body 回调信封正文，可为空
     * @param msgClass 业务内容的目标类型；{@link String} 表示保留文本
     * @return 包含业务对象和原始验签参数的回调对象
     * @throws NullPointerException 当 {@code msgClass} 为 {@code null} 时
     * @throws IllegalArgumentException 缺少业务消息、正文格式错误或业务对象转换失败
     */
    public static <T> MeituanCallbackMessage<T> parse(String query, Object body, Class<T> msgClass) {
        Objects.requireNonNull(msgClass, "msgClass must not be null");
        Map<String, String> parameters = new LinkedHashMap<>();
        if (StrUtil.isNotBlank(query)) {
            String form = query.startsWith("?") ? query.substring(1) : query;
            if (StrUtil.isNotBlank(form)) {
                parameters.putAll(MeituanCallbackParser.parseForm(form).getParameters());
            }
        }

        try {
            appendBody(parameters, body);
            String rawMessage = parameters.get("message");
            if (StrUtil.isBlank(rawMessage)) {
                rawMessage = parameters.get("param");
            }
            CallbackPayload payload = msgClass.getAnnotation(CallbackPayload.class);
            if (StrUtil.isBlank(rawMessage) && Objects.nonNull(payload)) {
                if (payload.value().isEmpty() && !parameters.isEmpty()) {
                    return new MeituanCallbackMessage<>(parameters, MAPPER.convertValue(parameters, msgClass));
                }
                rawMessage = parameters.get(payload.value());
            }
            if (StrUtil.isBlank(rawMessage)) {
                throw new IllegalArgumentException("Callback message must not be blank");
            }
            String json = rawMessage;
            // 部分消息的整个 message 又被编码成 JSON 字符串，验签仍使用原始参数。
            for (int depth = 0; Objects.nonNull(payload) && depth < 3 && json.stripLeading().startsWith("\""); depth++) {
                String decoded = MAPPER.readValue(json, String.class);
                if (!StrUtil.startWithAny(decoded.stripLeading(), "{", "[", "\"")) {
                    break;
                }
                json = decoded;
            }
            T message = msgClass.equals(String.class)
                    ? msgClass.cast(rawMessage) : MAPPER.readValue(json, msgClass);
            if (Objects.isNull(message)) {
                throw new IllegalArgumentException("Callback message must not be null");
            }
            return new MeituanCallbackMessage<>(parameters, message, rawMessage);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Cannot parse Meituan callback as " + msgClass.getName(), e);
        }
    }

    private static void appendBody(Map<String, String> parameters, Object body) {
        if (Objects.isNull(body)) {
            return;
        }
        if (body instanceof MeituanCallbackMessage<?> callback) {
            parameters.putAll(callback.getParameters());
            return;
        }
        if (body instanceof String text) {
            if (StrUtil.isBlank(text)) {
                return;
            }
            if (!text.trim().startsWith("{")) {
                parameters.putAll(MeituanCallbackParser.parseForm(text).getParameters());
                return;
            }
            appendBody(parameters, MAPPER.readValue(text, Map.class));
            return;
        }
        Map<?, ?> values = body instanceof Map<?, ?> map ? map : MAPPER.convertValue(body, Map.class);
        for (Map.Entry<?, ?> entry : values.entrySet()) {
            String key = Objects.toString(entry.getKey(), "");
            Object value = entry.getValue();
            // Servlet 多值参数按最后一个值合并，与 query/body 的正文优先规则一致。
            if (value instanceof String[] array) {
                value = array.length == 0 ? null : array[array.length - 1];
            }
            String encoded;
            if (Objects.isNull(value)) {
                encoded = null;
            } else if (value instanceof String text) {
                encoded = text;
            } else {
                encoded = MAPPER.writeValueAsString(value);
            }
            parameters.put(key, encoded);
        }
    }
}
