package io.github.easy4j.meituan.callback;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.model.biz3.FlashOrderAcknowledgement;
import lombok.Getter;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.Objects;

/**
 * 美团消息回调标准响应。
 *
 * @param <T> 协议规定的 data 类型，支持 JSON 字符串及直接嵌套的业务对象
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class MeituanCallbackResponse<T> {

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
     * 按协议编码的业务响应；无业务数据时为 {@code null}。
     */
    @JsonProperty("data")
    private final T data;

    /**
     * 处理本次回调的追踪标识，可随会员等级变更回执返回。
     */
    @JsonProperty("traceId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String traceId;

    /**
     * 创建包含状态码、业务结果和可选追踪标识的回执。
     *
     * @param code 协议规定的处理结果码
     * @param message 业务消息对象或处理结果说明
     * @param data 按接口协议编码的业务数据
     */
    private MeituanCallbackResponse(int code, String message, T data) {
        this(code, message, data, null);
    }

    /**
     * 创建包含状态码、业务结果和可选追踪标识的回执。
     *
     * @param code 协议规定的处理结果码
     * @param message 业务消息对象或处理结果说明
     * @param data 按接口协议编码的业务数据
     * @param traceId 本次回调的追踪标识
     */
    @JsonCreator
    private MeituanCallbackResponse(@JsonProperty("code") int code, @JsonProperty("message") String message,
                                    @JsonProperty("data") T data, @JsonProperty("traceId") String traceId) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.traceId = traceId;
    }

    /**
     * 构造无业务数据的成功响应。
     *
     * @param <T> 接口约定的业务数据类型
     * @return 状态码为 {@code 0}、消息为 {@code success}、业务数据为空的响应
     */
    public static <T> MeituanCallbackResponse<T> success() {
        return new MeituanCallbackResponse<>(0, "success", null);
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
    public static MeituanCallbackResponse<String> successJson(String dataJson) {
        return new MeituanCallbackResponse<>(0, "success", dataJson);
    }

    /**
     * 将业务对象序列化一次，生成标准同步回调所需的 JSON 字符串字段 {@code data}。
     *
     * @param data 业务对象或列表，为空时等同于 {@link #success()}；
     *             已序列化的 JSON 文本请使用 {@link #successJson(String)}
     * @return 携带业务数据的成功响应
     */
    public static MeituanCallbackResponse<String> successData(Object data) {
        try {
            return Objects.isNull(data) ? success() : successJson(new JsonMapper().writeValueAsString(data));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot serialize Meituan callback response", e);
        }
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
    public MeituanCallbackResponse<T> withTraceId(String traceId) {
        return new MeituanCallbackResponse<>(code, message, data, traceId);
    }

    /**
     * 构造失败响应。
     *
     * @param <T> 接口约定的业务数据类型
     * @param code 非 0 错误码
     * @param message 错误信息
     * @return 失败响应
     * @throws IllegalArgumentException 当状态码为 {@code 0} 时
     */
    public static <T> MeituanCallbackResponse<T> failure(int code, String message) {
        if (code == 0) {
            throw new IllegalArgumentException("failure code must not be 0");
        }
        return new MeituanCallbackResponse<>(code, message, null);
    }

    /**
     * 构造自定义响应。Jackson 按传入类型写入 data，例如会员券核销回执直接嵌套业务对象。
     *
     * @param <T> 响应数据类型
     * @param code 状态码
     * @param message 响应信息
     * @param data 接口要求的业务对象、列表或字符串
     * @return 自定义响应
     */
    public static <T> MeituanCallbackResponse<T> of(int code, String message, T data) {
        return new MeituanCallbackResponse<>(code, message, data);
    }
}
