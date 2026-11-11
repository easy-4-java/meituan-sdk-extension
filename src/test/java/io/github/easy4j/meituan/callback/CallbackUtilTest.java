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

    private static final String QUERY = "businessId=59&msgType=5910019&opBizCode=shop-1";
    private static final String MESSAGE = " {\"opUserId\":\"user+1\",\"name\":\"张三 & 李四\",\"futureField\":true} ";

    @Test
    void parsesFormIntoTypedMessageAndPreservesSignedValues() {
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

    @Test
    void parsesJsonEnvelopeAndLetsBodyOverrideQueryParameters() {
        MeituanCallbackMessage<Member> callback = CallbackUtil.parse("businessId=58",
                "{\"businessId\":59,\"msgType\":5910019,\"message\":{\"opUserId\":\"user-2\",\"name\":\"张三\"}}",
                Member.class);

        assertThat(callback.getBusinessId()).isEqualTo("59");
        assertThat(callback.getMessage().opUserId()).isEqualTo("user-2");
    }

    @Test
    void acceptsDecodedMapAndAlreadyTypedEnvelope() {
        Member member = new Member("user-3", "张三");
        MeituanCallbackMessage<Member> fromMap = CallbackUtil.parse(QUERY,
                Map.of("message", member), Member.class);
        MeituanCallbackMessage<Member> fromEnvelope = CallbackUtil.parse(null, fromMap, Member.class);

        assertThat(fromMap.getMessage()).isEqualTo(member);
        assertThat(fromEnvelope.getMessage()).isEqualTo(member);
        assertThat(fromEnvelope.getParameters()).isEqualTo(fromMap.getParameters());
    }

    @Test
    void acceptsQueryOnlyAndLegacyParamEnvelope() {
        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(
                "?businessId=15&invokeType=15101&param=" + encode("{\"name\":\"会员\"}"), null, Member.class);

        assertThat(callback.getMsgType()).isEqualTo("15101");
        assertThat(callback.getMessage().name()).isEqualTo("会员");
    }

    @Test
    void preservesNestedJsonStringsAndAllowsRawStringMessages() {
        MeituanCallbackMessage<Reservation> callback = CallbackUtil.parse("msgType=710003",
                Map.of("message", "{\"ePoiId\":\"shop\",\"data\":\"{\\\"status\\\":10}\"}"), Reservation.class);
        MeituanCallbackMessage<String> raw = CallbackUtil.parse(QUERY, Map.of("message", MESSAGE), String.class);

        assertThat(callback.getMessage().data()).isEqualTo("{\"status\":10}");
        assertThat(raw.getMessage()).isEqualTo(MESSAGE);
    }

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

    @Test
    void readsServletJsonBodyAndQuery() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/json");
        when(request.getQueryString()).thenReturn(QUERY);
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(
                "{\n  \"message\": {\"opUserId\":\"user-4\",\"name\":\"张三\"}\n}")));

        assertThat(CallbackUtil.parse(request, Member.class).getMessage().opUserId()).isEqualTo("user-4");
    }

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

    @Test
    void rejectsMalformedOrMissingPayloads() {
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, Map.of("message", "{"), Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, null, Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, Map.of("message", "null"), Member.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parsesPojoEnvelopeAndRejectsNonObjectJsonEnvelope() {
        Envelope body = new Envelope("5910019", new Member("user-5", "张三"));
        assertThat(CallbackUtil.parse(QUERY, body, Member.class).getMessage().opUserId()).isEqualTo("user-5");
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, "[]", Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse("message=%GG", null, Member.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void wrapsServletReadFailures() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getReader()).thenThrow(new java.io.IOException("read failed"));
        assertThatThrownBy(() -> CallbackUtil.parse(request, Member.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasCauseInstanceOf(java.io.IOException.class);
    }

    @Test
    void preservesRawLegacyParamWhenMessageIsBlank() {
        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(QUERY,
                Map.of("message", " ", "param", MESSAGE), Member.class);
        assertThat(callback.getRawMessage()).isEqualTo(MESSAGE);
        assertThat(callback.getMessage().opUserId()).isEqualTo("user+1");
    }

    /** 使用 Java 对象传入回调信封。 */
    record Envelope(String msgType, Member message) {
    }

    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    /** 创建会员消息的最小业务模型。 */
    record Member(String opUserId, String name) {
    }

    /** 预订消息保留协议中二次编码的 data 字符串。 */
    record Reservation(String ePoiId, String data) {
    }
}
