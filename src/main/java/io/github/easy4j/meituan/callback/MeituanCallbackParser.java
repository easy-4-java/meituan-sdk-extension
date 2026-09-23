package io.github.easy4j.meituan.callback;

import io.github.easy4j.meituan.utils.StringUtils;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 美团消息回调公共参数解析器。
 * <p>当前美团消息文档使用
 * {@code application/x-www-form-urlencoded} 推送，并把业务 JSON 放在 {@code message} 字段中；
 * 部分历史协议使用 {@code invokeType}/{@code param} 信封，解析后归一化为相同模型。
 * 本解析器只负责传输层解码，不擅自解释各业务消息的 JSON 字段。</p>
 */
public final class MeituanCallbackParser {

    private MeituanCallbackParser() {
    }

    /**
     * 解析 URL-encoded 回调请求体。
     *
     * @param formBody 原始 form 请求体
     * @return 回调公共参数对象
     */
    public static MeituanCallbackMessage parseForm(String formBody) {
        if (!StringUtils.hasText(formBody)) {
            throw new IllegalArgumentException("formBody must not be blank");
        }
        Map<String, String> parameters = new LinkedHashMap<>();
        for (String pair : formBody.split("&")) {
            if (!StringUtils.hasText(pair)) {
                continue;
            }
            int separator = pair.indexOf('=');
            String rawKey = separator < 0 ? pair : pair.substring(0, separator);
            String rawValue = separator < 0 ? "" : pair.substring(separator + 1);
            String key = decode(rawKey);
            if (StringUtils.hasText(key)) {
                parameters.put(key, decode(rawValue));
            }
        }
        return parse(parameters);
    }

    /**
     * 从 Web 框架已经解析好的参数映射构造回调对象。
     *
     * @param parameters 回调参数
     * @return 回调公共参数对象
     */
    public static MeituanCallbackMessage parse(Map<String, String> parameters) {
        Objects.requireNonNull(parameters, "parameters must not be null");
        return new MeituanCallbackMessage(parameters);
    }

    static String findValue(Map<String, String> parameters, String... keys) {
        for (String key : keys) {
            String value = parameters.get(key);
            if (StringUtils.hasText(value)) {
                return value.trim();
            }
        }
        return null;
    }

    private static String decode(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 must be supported", e);
        }
    }
}
