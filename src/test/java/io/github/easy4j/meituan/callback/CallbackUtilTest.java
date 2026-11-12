package io.github.easy4j.meituan.callback;

import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/**
 * 泛型回调解析入口的行为与验签回归测试。
 */
class CallbackUtilTest {

    /**
     * 测试回调的公共查询参数。
     */
    private static final String QUERY = "businessId=59&msgType=5910019&opBizCode=shop-1";
    /**
     * 测试回调的业务 JSON 文本。
     */
    private static final String MESSAGE = " {\"opUserId\":\"user+1\",\"name\":\"张三 & 李四\",\"futureField\":true} ";
    /**
     * 创建泛型回调解析入口的行为与验签回归测试。的空实例。
     */
    CallbackUtilTest() {
    }

    /**
     * 按 UTF-8 将测试业务文本编码为表单参数。
     *
     * @param value 待进行 UTF-8 表单编码的文本
     * @return 按 UTF-8 将测试业务文本编码为表单参数的结果
     * @throws java.io.UnsupportedEncodingException 当请求读取、数据转换或接口检查失败时
     */
    private static String encode(String value) throws java.io.UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
    }

    /**
     * 验证表单可解析为指定消息模型，并保留原始验签参数。
     *
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
     *
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
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void acceptsDecodedMapAndAlreadyTypedEnvelope() throws Exception {
        Member member = new Member("user-3", "张三");
        MeituanCallbackMessage<Member> fromMap = CallbackUtil.parse(QUERY,
                io.github.easy4j.meituan.TestCollections.mapOf("message", member), Member.class);
        MeituanCallbackMessage<Member> fromEnvelope = CallbackUtil.parse(null, fromMap, Member.class);

        assertThat(fromMap.getMessage()).isEqualTo(member);
        assertThat(fromEnvelope.getMessage()).isEqualTo(member);
        assertThat(fromEnvelope.getParameters()).isEqualTo(fromMap.getParameters());
    }

    /**
     * 验证仅查询串输入及旧协议 param 信封。
     *
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
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void preservesNestedJsonStringsAndAllowsRawStringMessages() throws Exception {
        MeituanCallbackMessage<Reservation> callback = CallbackUtil.parse("msgType=710003",
                io.github.easy4j.meituan.TestCollections.mapOf("message", "{\"ePoiId\":\"shop\",\"data\":\"{\\\"status\\\":10}\"}"), Reservation.class);
        MeituanCallbackMessage<String> raw = CallbackUtil.parse(QUERY, io.github.easy4j.meituan.TestCollections.mapOf("message", MESSAGE), String.class);

        assertThat(callback.getMessage().data()).isEqualTo("{\"status\":10}");
        assertThat(raw.getMessage()).isEqualTo(MESSAGE);
    }

    /**
     * 验证表单请求直接读取容器参数且不再次读取正文。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void readsServletFormParametersWithoutReadingConsumedBody() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/x-www-form-urlencoded;charset=UTF-8");
        when(request.getParameterMap()).thenReturn(io.github.easy4j.meituan.TestCollections.mapOf("businessId", new String[]{"59"},
                "message", new String[]{MESSAGE}));

        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(request, Member.class);

        assertThat(callback.getMessage().name()).isEqualTo("张三 & 李四");
        verify(request, org.mockito.Mockito.never()).getReader();
    }

    /**
     * 验证 Servlet 的 JSON 正文和查询参数可以合并。
     *
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
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void servletParametersKeepBodyPrecedenceWithoutJoiningMultipleValues() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/x-www-form-urlencoded");
        when(request.getParameterMap()).thenReturn(io.github.easy4j.meituan.TestCollections.mapOf("businessId", new String[]{"58", "59"},
                "message", new String[]{"{}", MESSAGE}));

        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(request, Member.class);

        assertThat(callback.getBusinessId()).isEqualTo("59");
        assertThat(callback.getMessage().opUserId()).isEqualTo("user+1");
        assertThat(callback.getParameters()).containsEntry("message", MESSAGE);
    }

    /**
     * 验证表单只解码一次，并保留同名参数的最后值用于验签。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void decodesFormValuesOnceAndRetainsTheLastValueForSigning() throws Exception {
        MeituanCallbackMessage<String> callback = CallbackUtil.parse("?id=query", "id=one&id=two&message=+x%2By%26z%253D=+&flag&amp;id=literal", String.class);
        assertThat(callback.getMessage()).isEqualTo(" x+y&z%3D= ");
        assertThat(callback.getParameters()).containsEntry("id", "two")
                .containsEntry("flag", "").containsEntry("amp;id", "literal");
        assertThatThrownBy(() -> CallbackUtil.parse(null, "message=%GG", String.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 验证格式错误、空内容和缺失的业务消息被拒绝。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void rejectsMalformedOrMissingPayloads() throws Exception {
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, io.github.easy4j.meituan.TestCollections.mapOf("message", "{"), Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, null, Member.class))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CallbackUtil.parse(QUERY, io.github.easy4j.meituan.TestCollections.mapOf("message", "null"), Member.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 验证对象信封可解析，数组型外层信封被拒绝。
     *
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
     *
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
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void preservesRawLegacyParamWhenMessageIsBlank() throws Exception {
        MeituanCallbackMessage<Member> callback = CallbackUtil.parse(QUERY,
                io.github.easy4j.meituan.TestCollections.mapOf("message", " ", "param", MESSAGE), Member.class);
        assertThat(callback.getRawMessage()).isEqualTo(MESSAGE);
        assertThat(callback.getMessage().opUserId()).isEqualTo("user+1");
    }

    /**
     * 使用 Java 对象传入回调信封。
     */
    @lombok.EqualsAndHashCode
    static final class Envelope {
        /**
         * 平台消息类型编号。
         */
        @com.fasterxml.jackson.annotation.JsonProperty("msgType")
        private final String msgType;
        /**
         * 业务消息对象或处理结果说明。
         */
        @com.fasterxml.jackson.annotation.JsonProperty("message")
        private final Member message;

        /**
         * 创建当前类的实例。
         *
         * @param msgType 平台消息类型编号
         * @param message 业务消息对象或处理结果说明
         */
        @com.fasterxml.jackson.annotation.JsonCreator
        public Envelope(@com.fasterxml.jackson.annotation.JsonProperty("msgType") String msgType, @com.fasterxml.jackson.annotation.JsonProperty("message") Member message) {
            this.msgType = msgType;
            this.message = message;
        }

        /**
         * 按标准字段及旧协议字段的优先级读取消息编号。
         *
         * @return 按标准字段及旧协议字段的优先级读取消息编号的结果
         */
        public String msgType() {
            return msgType;
        }

        /**
         * 读取业务消息对象或处理结果说明。
         *
         * @return 读取业务消息对象或处理结果说明的结果
         */
        public Member message() {
            return message;
        }
    }

    /**
     * 创建会员消息的最小业务模型。
     */
    @lombok.EqualsAndHashCode
    static final class Member {
        /**
         * 平台用户的开放标识。
         */
        @com.fasterxml.jackson.annotation.JsonProperty("opUserId")
        private final String opUserId;
        /**
         * 官网接口名称。
         */
        @com.fasterxml.jackson.annotation.JsonProperty("name")
        private final String name;

        /**
         * 创建当前类的实例。
         *
         * @param opUserId 平台用户的开放标识
         * @param name     官网接口名称
         */
        @com.fasterxml.jackson.annotation.JsonCreator
        public Member(@com.fasterxml.jackson.annotation.JsonProperty("opUserId") String opUserId, @com.fasterxml.jackson.annotation.JsonProperty("name") String name) {
            this.opUserId = opUserId;
            this.name = name;
        }

        /**
         * 读取平台用户的开放标识。
         *
         * @return 读取平台用户的开放标识的结果
         */
        public String opUserId() {
            return opUserId;
        }

        /**
         * 读取官网接口名称。
         *
         * @return 读取官网接口名称的结果
         */
        public String name() {
            return name;
        }
    }

    /**
     * 预订消息保留协议中二次编码的 data 字符串。
     */
    @lombok.EqualsAndHashCode
    static final class Reservation {
        /**
         * 开发者系统中的门店编号。
         */
        @com.fasterxml.jackson.annotation.JsonProperty("ePoiId")
        private final String ePoiId;
        /**
         * 按接口协议编码的业务数据。
         */
        @com.fasterxml.jackson.annotation.JsonProperty("data")
        private final String data;

        /**
         * 创建当前类的实例。
         *
         * @param ePoiId 开发者系统中的门店编号
         * @param data   按接口协议编码的业务数据
         */
        @com.fasterxml.jackson.annotation.JsonCreator
        public Reservation(@com.fasterxml.jackson.annotation.JsonProperty("ePoiId") String ePoiId, @com.fasterxml.jackson.annotation.JsonProperty("data") String data) {
            this.ePoiId = ePoiId;
            this.data = data;
        }

        /**
         * 读取开发者系统中的门店编号。
         *
         * @return 读取开发者系统中的门店编号的结果
         */
        public String ePoiId() {
            return ePoiId;
        }

        /**
         * 读取按接口协议编码的业务数据。
         *
         * @return 读取按接口协议编码的业务数据的结果
         */
        public String data() {
            return data;
        }
    }
}
