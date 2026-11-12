package io.github.easy4j.meituan.callback;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** 泛型回调解析入口的行为与验签回归测试。 */
class CallbackUtilTest {

    /**
     * 创建\u6cdb\u578b\u56de\u8c03\u89e3\u6790\u5165\u53e3\u7684\u884c\u4e3a\u4e0e\u9a8c\u7b7e\u56de\u5f52\u6d4b\u8bd5\u3002的空实例。
     */
    CallbackUtilTest() {
    }


    /**
     * 测试回调的公共查询参数。
     */
    private static final String QUERY = "businessId=59&msgType=5910019&opBizCode=shop-1";
    /**
     * 测试回调的业务 JSON 文本。
     */
    private static final String MESSAGE = " {\"opUserId\":\"user+1\",\"name\":\"张三 & 李四\",\"futureField\":true} ";

    /**
     * 验证表单可解析为指定消息模型，并保留原始验签参数。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void parsesFormIntoTypedMessageAndPreservesSignedValues() throws Exception {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("businessId", "59");
        parameters.put("msgType", "5910019");
        parameters.put("opBizCode", "shop-1");
        parameters.put("message", MESSAGE);
        String sign = MeituanCallbackSigner.sign("test-key", parameters);

        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(QUERY,
                "message=" + encode(MESSAGE) + "&sign=" + sign, Member.class);

        assertThat(callback.getMessage().opUserId()).isEqualTo("user+1");
        assertThat(callback.getMessage().name()).isEqualTo("张三 & 李四");
        assertThat(callback.getRawMessage()).isEqualTo(MESSAGE);
        assertThat(callback.getParameters()).containsEntry("message", MESSAGE);
        assertThat(MeituanCallbackSigner.verify("test-key", callback.getParameters(), callback.getSign())).isTrue();
    }

    /**
     * 验证 JSON 正文可解析且其参数优先于查询串。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void parsesJsonEnvelopeAndLetsBodyOverrideQueryParameters() throws Exception {
        MeituanCallbackMessage<Member> callback = CallbackUtil.parse("businessId=58",
                "{\"businessId\":59,\"msgType\":5910019,\"message\":{\"opUserId\":\"user-2\",\"name\":\"张三\"}}",
                Member.class);

        assertThat(callback.getBusinessId()).isEqualTo("59");
        assertThat(callback.getMessage().opUserId()).isEqualTo("user-2");
    }

    /**
     * 验证入口接受已解码映射和已类型化的回调信封。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void acceptsDecodedMapAndAlreadyTypedEnvelope() throws Exception {
        Member member = new Member("user-3", "张三");
        MeituanCallbackMessage<Member> fromMap = CallbackUtil.parse(QUERY,
                Map.of("message", member), Member.class);
        MeituanCallbackMessage<Member> fromEnvelope = CallbackUtil.parse(null, fromMap, Member.class);

        assertThat(fromMap.getMessage()).isEqualTo(member);
        assertThat(fromEnvelope.getMessage()).isEqualTo(member);
        assertThat(fromEnvelope.getParameters()).isEqualTo(fromMap.getParameters());
    }

    /**
     * 验证仅查询串输入及旧协议 param 信封。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void acceptsQueryOnlyAndLegacyParamEnvelope() throws Exception {
        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(
                "?businessId=15&invokeType=15101&param=" + encode("{\"name\":\"会员\"}"), null, Member.class);

        assertThat(callback.getMsgType()).isEqualTo("15101");
        assertThat(callback.getMessage().name()).isEqualTo("会员");
    }

    /**
     * 验证嵌套 JSON 字符串和原始字符串消息均可读取。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void preservesNestedJsonStringsAndAllowsRawStringMessages() throws Exception {
        MeituanCallbackMessage<Reservation> callback = CallbackUtil.parse("msgType=710003",
                Map.of("message", "{\"ePoiId\":\"shop\",\"data\":\"{\\\"status\\\":10}\"}"), Reservation.class);
        MeituanCallbackMessage<String> raw = CallbackUtil.parse(QUERY, Map.of("message", MESSAGE), String.class);

        assertThat(callback.getMessage().data()).isEqualTo("{\"status\":10}");
        assertThat(raw.getMessage()).isEqualTo(MESSAGE);
    }

    /**
     * 验证表单请求直接读取容器参数且不再次读取正文。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void readsServletFormParametersWithoutReadingConsumedBody() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/x-www-form-urlencoded;charset=UTF-8");
        when(request.getParameterMap()).thenReturn(Map.of("businessId", new String[]{"59"},
                "message", new String[]{MESSAGE}));

        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(request, Member.class);

        assertThat(callback.getMessage().name()).isEqualTo("张三 & 李四");
        verify(request, org.mockito.Mockito.never()).getReader();
    }

    /**
     * 验证 Servlet 的 JSON 正文和查询参数可以合并。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void readsServletJsonBodyAndQuery() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/json");
        when(request.getQueryString()).thenReturn(QUERY);
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(
                "{\n  \"message\": {\"opUserId\":\"user-4\",\"name\":\"张三\"}\n}")));

        assertThat(CallbackUtil.parse(request, Member.class).getMessage().opUserId()).isEqualTo("user-4");
    }

    /**
     * 验证多值表单采用最后值，避免拼接破坏业务文本。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void servletParametersKeepBodyPrecedenceWithoutJoiningMultipleValues() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/x-www-form-urlencoded");
        when(request.getParameterMap()).thenReturn(Map.of("businessId", new String[]{"58", "59"},
                "message", new String[]{"{}", MESSAGE}));

        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(request, Member.class);

        assertThat(callback.getBusinessId()).isEqualTo("59");
        assertThat(callback.getMessage().opUserId()).isEqualTo("user+1");
        assertThat(callback.getParameters()).containsEntry("message", MESSAGE);
    }

    /**
     * 验证表单只解码一次，并保留同名参数的最后值用于验签。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void decodesFormValuesOnceAndRetainsTheLastValueForSigning() throws Exception {
        var callback = CallbackUtil.parse("?id=query", "id=one&id=two&message=+x%2By%26z%253D=+&flag&amp;id=literal", String.class);
        assertThat(callback.getMessage()).isEqualTo(" x+y&z%3D= ");
        assertThat(callback.getParameters()).containsEntry("id", "two")
                .containsEntry("flag", "").containsEntry("amp;id", "literal");
        assertThatThrownBy(() -> CallbackUtil.parse(null, "message=%GG", String.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 验证格式错误、空内容和缺失的业务消息被拒绝。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void rejectsMalformedOrMissingPayloads() throws Exception {
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, Map.of("message", "{"), Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, null, Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, Map.of("message", "null"), Member.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 验证对象信封可解析，数组型外层信封被拒绝。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void parsesPojoEnvelopeAndRejectsNonObjectJsonEnvelope() throws Exception {
        Envelope body = new Envelope("5910019", new Member("user-5", "张三"));
        assertThat(CallbackUtil.parse(QUERY, body, Member.class).getMessage().opUserId()).isEqualTo("user-5");
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, "[]", Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse("message=%GG", null, Member.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 验证 Servlet 读取失败会保留原始原因并包装为参数异常。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void wrapsServletReadFailures() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getReader()).thenThrow(new java.io.IOException("read failed"));
        assertThatThrownBy(() -> CallbackUtil.parse(request, Member.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasCauseInstanceOf(java.io.IOException.class);
    }

    /**
     * 验证标准消息字段为空白时保留旧协议参数原文。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void preservesRawLegacyParamWhenMessageIsBlank() throws Exception {
        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(QUERY,
                Map.of("message", " ", "param", MESSAGE), Member.class);
        assertThat(callback.getRawMessage()).isEqualTo(MESSAGE);
        assertThat(callback.getMessage().opUserId()).isEqualTo("user+1");
    }

    /** 使用 Java 对象传入回调信封。
     *
     * @param msgType 测试消息编号
     * @param message 测试业务消息
     */
    record Envelope(String msgType, Member message) {
    }

    /**
     * 按 UTF-8 将测试业务文本编码为表单参数。
     *
     * @param value value
     * @return 按 UTF-8 将测试业务文本编码为表单参数的结果
     */
    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    /** 创建会员消息的最小业务模型。
     *
     * @param opUserId 测试用户开放标识
     * @param name 测试会员姓名
     */
    record Member(String opUserId, String name) {
    }

    /** 预订消息保留协议中二次编码的 data 字符串。
     *
     * @param ePoiId 测试门店标识
     * @param data 保持字符串形式的预订明细
     */
    record Reservation(String ePoiId, String data) {
    }
}
