package io.github.easy4j.meituan.callback;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import cn.hutool.http.ContentType;
import jakarta.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.net.URLDecoder;
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

    /**
     * 处理业务 JSON 的线程安全映射器。
     */
    private static final ObjectMapper MAPPER = JsonMapper.builder()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .build();

    /**
     * 创建当前类的实例。
     */
    private CallbackUtil() {
    }

    /**
     * 根据业务 ID 和消息类型选择已登记的回调模型。
     * 未登记的组合保留解码后的业务原文和全部验签参数。
     *
     * @param request Servlet 回调请求，须在消费请求体前调用
     * @return 包含已登记业务对象或原文的回调
     * @throws IllegalArgumentException 请求读取失败或已登记消息的内容无效
     */
    public static MeituanCallbackMessage<?> parse(HttpServletRequest request) {
        return dispatch(readParameters(request));
    }

    /**
     * 合并查询串和正文，按业务 ID 和消息类型（含旧协议的 {@code invokeType}）解析。
     * 未匹配时保留原文，缺少 {@code message} 和 {@code param} 时业务内容为空。
     *
     * @param query 可带问号的 URL 编码查询串，可为空
     * @param body 表单、JSON 信封或已解码的参数，可为空；同名参数以正文为准
     * @return 包含已登记业务对象或原文及验签参数的回调
     * @throws IllegalArgumentException 正文无效或已登记消息转换失败
     */
    public static MeituanCallbackMessage<?> parse(String query, Object body) {
        return dispatch(readParameters(query, body));
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
        Objects.requireNonNull(msgClass, "msgClass must not be null");
        return bind(readParameters(request), msgClass);
    }

    /**
     * 读取回调参数并合并查询串与正文，同名字段采用正文值。
     *
     * @param request 官方 SDK 请求对象
     * @return 读取回调参数并合并查询串与正文，同名字段采用正文值的结果
     */
    private static Map<String, String> readParameters(HttpServletRequest request) {
        Objects.requireNonNull(request, "request must not be null");
        try {
            if (Objects.isNull(request.getCharacterEncoding())) {
                request.setCharacterEncoding(StandardCharsets.UTF_8.name());
            }
            if (ContentType.isFormUrlEncode(request.getContentType())) {
                return readParameters(null, JakartaServletUtil.getParams(request));
            }
            return readParameters(request.getQueryString(), JakartaServletUtil.getBody(request));
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
        return bind(readParameters(query, body), msgClass);
    }

    /**
     * 读取回调参数并合并查询串与正文，同名字段采用正文值。
     *
     * @param query URL 编码的查询参数，可带前导问号
     * @param body 回调正文或已解码的参数映射
     * @return 读取回调参数并合并查询串与正文，同名字段采用正文值的结果
     */
    private static Map<String, String> readParameters(String query, Object body) {
        Map<String, String> parameters = new LinkedHashMap<>();
        appendForm(parameters, StrUtil.removePrefix(query, "?"));

        try {
            appendBody(parameters, body);
            return parameters;
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot read Meituan callback parameters", e);
        }
    }

    /**
     * 解码表单并合并参数，同名字段保留最后一个值。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @param form URL 编码的表单参数
     */
    private static void appendForm(Map<String, String> parameters, String form) {
        // 验签使用表单原始键名；JDK 解码器会拒绝不完整或非法的百分号编码。
        for (String pair : StrUtil.split(form, '&')) {
            String key = URLDecoder.decode(StrUtil.subBefore(pair, '=', false), StandardCharsets.UTF_8);
            if (StrUtil.isNotBlank(key)) {
                String value = URLDecoder.decode(StrUtil.subAfter(pair, '=', false), StandardCharsets.UTF_8);
                parameters.put(key, value);
            }
        }
    }

    /**
     * 按业务编号和消息编号选择模型，未知消息保留原始文本。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @return 按业务编号和消息编号选择模型，未知消息保留原始文本的结果
     */
    private static MeituanCallbackMessage<?> dispatch(Map<String, String> parameters) {
        var model = MeituanCallbackModels.find(MeituanCallbackMessage.businessId(parameters),
                MeituanCallbackMessage.msgType(parameters));
        if (model.isPresent() && !String.class.equals(model.get())) {
            return bind(parameters, model.get());
        }
        String rawMessage = MeituanCallbackMessage.rawMessage(parameters);
        return new MeituanCallbackMessage<>(parameters, rawMessage, rawMessage);
    }

    /**
     * 将业务内容绑定为指定模型，并保留用于验签的原始参数。
     *
     * @param <T> 业务消息类型
     * @param parameters 已解码的回调参数及验签字段
     * @param msgClass 业务内容的目标类型
     * @return 将业务内容绑定为指定模型，并保留用于验签的原始参数的结果
     */
    private static <T> MeituanCallbackMessage<T> bind(Map<String, String> parameters, Class<T> msgClass) {
        try {
            String rawMessage = MeituanCallbackMessage.rawMessage(parameters);
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
            for (int depth = 0; Objects.nonNull(payload) && depth < 3 && StrUtil.trimStart(json).startsWith("\""); depth++) {
                String decoded = MAPPER.readValue(json, String.class);
                if (!StrUtil.startWithAny(StrUtil.trimStart(decoded), "{", "[", "\"")) {
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
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot parse Meituan callback as " + msgClass.getName(), e);
        }
    }

    /**
     * 合并回调正文，将对象型业务内容编码为 JSON 参数。
     *
     * @param parameters 已解码的回调参数及验签字段
     * @param body 回调正文或已解码的参数映射
     * @throws com.fasterxml.jackson.core.JsonProcessingException 当请求读取、数据转换或接口检查失败时
     */
    private static void appendBody(Map<String, String> parameters, Object body) throws com.fasterxml.jackson.core.JsonProcessingException {
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
                appendForm(parameters, text);
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
