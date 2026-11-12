package io.github.easy4j.meituan.callback;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.model.biz3.FlashOrderAcknowledgement;
import lombok.Getter;
import tools.jackson.databind.json.JsonMapper;

import java.util.Objects;

/**
 * 美团消息回调标准响应。
 */
@Getter
public final class MeituanCallbackResponse {

    /**
     * 响应状态码。成功为 {@code 0}。
     */
    @JsonProperty("code")
    private final int code;

    /**
     * 返回给平台的处理结果说明。
     */
    @JsonProperty("message")
    private final String message;

    /**
     * 业务响应的 JSON 字符串；无业务数据时为 {@code null}。
     */
    @JsonProperty("data")
    private final String data;

    /**
     * 处理本次回调的追踪标识，可随会员等级变更回执返回。
     */
    @JsonProperty("traceId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String traceId;

    private MeituanCallbackResponse(int code, String message, String data) {
        this(code, message, data, null);
    }

    @JsonCreator
    private MeituanCallbackResponse(@JsonProperty("code") int code, @JsonProperty("message") String message,
                                    @JsonProperty("data") String data, @JsonProperty("traceId") String traceId) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.traceId = traceId;
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
     * 将业务对象序列化一次，生成标准同步回调所需的 JSON 字符串字段 {@code data}。
     *
     * @param data 业务对象或列表，为空时等同于 {@link #success()}；
     *             已序列化的 JSON 文本请使用 {@link #successJson(String)}
     * @return 携带业务数据的成功响应
     */
    public static MeituanCallbackResponse successData(Object data) {
        return Objects.isNull(data) ? success() : successJson(JsonMapper.shared().writeValueAsString(data));
    }

    /**
     * 构造闪惠接收订单推送（业务 3、消息 310001）的专用成功回执。
     *
     * @return 仅含 {@code data="ok"} 的回执
     */
    public static FlashOrderAcknowledgement flashOrderSuccess() {
        return new FlashOrderAcknowledgement("ok");
    }

    /**
     * 为当前回执附上追踪标识。
     *
     * @param traceId 接收方用于定位此次请求的标识，为 {@code null} 时省略该字段
     * @return 携带该标识的响应副本
     */
    public MeituanCallbackResponse withTraceId(String traceId) {
        return new MeituanCallbackResponse(code, message, data, traceId);
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
