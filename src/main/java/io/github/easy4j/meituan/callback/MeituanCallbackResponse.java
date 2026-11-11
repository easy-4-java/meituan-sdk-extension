package io.github.easy4j.meituan.callback;

import lombok.Getter;

/**
 * 美团消息回调标准响应。
 */
@Getter
public final class MeituanCallbackResponse {

    /**
     * 响应状态码。成功为 {@code 0}。
     */
    private final int code;

    /**
     * 返回给平台的处理结果说明。
     */
    private final String message;

    /**
     * 业务响应的 JSON 字符串；无业务数据时为 {@code null}。
     */
    private final String data;

    private MeituanCallbackResponse(int code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造无业务数据的成功响应。
     *
     * @return 状态码为 {@code 0}、消息为 {@code success}、业务数据为空的响应
     */
    public static MeituanCallbackResponse success() {
        return new MeituanCallbackResponse(0, "success", null);
    }

    /**
     * 构造携带 JSON 字符串业务数据的成功响应。
     *
     * <p>部分同步查询消息要求响应 {@code data} 是 JSON string，而不是嵌套 JSON object；
     * 调用方应先将业务对象序列化为 JSON，再调用本方法。</p>
     *
     * @param dataJson 业务数据 JSON 字符串
     * @return 成功响应
     */
    public static MeituanCallbackResponse successJson(String dataJson) {
        return new MeituanCallbackResponse(0, "success", dataJson);
    }

    /**
     * 构造失败响应。
     *
     * @param code 非 0 错误码
     * @param message 错误信息
     * @return 失败响应
     * @throws IllegalArgumentException 当状态码为 {@code 0} 时
     */
    public static MeituanCallbackResponse failure(int code, String message) {
        if (code == 0) {
            throw new IllegalArgumentException("failure code must not be 0");
        }
        return new MeituanCallbackResponse(code, message, null);
    }

    /**
     * 构造自定义响应。
     *
     * @param code 状态码
     * @param message 响应信息
     * @param dataJson 业务数据 JSON 字符串
     * @return 自定义响应
     */
    public static MeituanCallbackResponse of(int code, String message, String dataJson) {
        return new MeituanCallbackResponse(code, message, dataJson);
    }
}
