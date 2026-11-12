package io.github.easy4j.meituan.callback;

import io.github.easy4j.meituan.callback.type.MeituanBusiness59MessageType;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 服务零售（客户，businessId=59）消息回调基础能力测试。
 */
class MeituanCallbackSupportTest {

    /**
     * 创建服务零售（客户，businessId=59）消息回调基础能力测试。的空实例。
     */
    MeituanCallbackSupportTest() {
    }


    /**
     * 验证官网表单示例的公共字段和业务消息类型可以解析。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldParseOfficialFormEncodedCallbackAndResolveMessageType() throws Exception {
        String message = "{\"productId\":1000,\"flowStatus\":30}";
        String body = "msgType=5910003"
                + "&opBizCode=1711591987"
                + "&developerId=123456"
                + "&businessId=59"
                + "&sign=abcdef"
                + "&msgId=3702923312382104528"
                + "&timestamp=1711592316026"
                + "&message=" + URLEncoder.encode(message, StandardCharsets.UTF_8.name());

        MeituanCallbackMessage<String> callback = CallbackUtil.parse(null, body, String.class);

        assertThat(callback.getMsgType()).isEqualTo("5910003");
        assertThat(callback.getBusinessId()).isEqualTo("59");
        assertThat(callback.getMessage()).isEqualTo(message);
        assertThat(MeituanBusiness59MessageType.resolve(callback))
                .contains(MeituanBusiness59MessageType.PRODUCT_STATUS_CHANGED);
        assertThat(callback.getParameters()).containsEntry("opBizCode", "1711591987");
    }

    /**
     * 验证正确签名通过，参数被篡改后验签失败。
     */
    @Test
    void shouldVerifySignatureAndRejectTamperedParameters() {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("msgType", "5910003");
        parameters.put("developerId", "123456");
        parameters.put("businessId", "59");
        parameters.put("msgId", "callback-1");
        parameters.put("timestamp", "1711592316");
        parameters.put("message", "{\"productId\":1000}");

        String signature = MeituanCallbackSigner.sign("test-sign-key", parameters);
        assertThat(signature).isEqualTo("19e3e56e35030ae84f85122cdf5d73f5283bbef7");
        parameters.put("sign", signature);

        assertThat(MeituanCallbackSigner.verify("test-sign-key", parameters, signature)).isTrue();

        parameters.put("message", "{\"productId\":1001}");
        assertThat(MeituanCallbackSigner.verify("test-sign-key", parameters, signature)).isFalse();

        parameters.put("message", "{\"productId\":1000}");
        parameters.put("ePoiId", "");
        assertThat(MeituanCallbackSigner.sign("test-sign-key", parameters)).isEqualTo(signature);
    }

    /**
     * 验证该业务的公开消息编号、名称、文档及编号唯一性。
     */
    @Test
    void shouldExposeAllDocumentedBusiness59MessagesWithoutDuplicateMsgTypes() {
        assertThat(MeituanBusiness59MessageType.values()).hasSize(34);

        Set<String> knownMsgTypes = java.util.Arrays.stream(MeituanBusiness59MessageType.values())
                .map(MeituanBusiness59MessageType::getMsgType)
                .filter(java.util.Objects::nonNull)
                .collect(Collectors.toSet());

        assertThat(knownMsgTypes).hasSize(34);
        assertThat(MeituanBusiness59MessageType.fromMsgType("5910149"))
                .contains(MeituanBusiness59MessageType.MEMBER_UNREGISTERED);

        MeituanCallbackMessage<String> otherBusiness = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "5910003", "message", "{}"), String.class);
        assertThat(MeituanBusiness59MessageType.resolve(otherBusiness)).isEmpty();

        MeituanCallbackMessage<String> unknownMessage = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "59", "msgType", "5999999", "message", "{}"), String.class);
        assertThat(MeituanBusiness59MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMsgType()).isEqualTo("5999999");
    }

    /**
     * 验证标准成功与失败回执的状态、说明及数据格式。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldBuildStandardCallbackResponses() throws Exception {
        assertThat(MeituanCallbackResponse.success())
                .extracting(MeituanCallbackResponse::getCode, MeituanCallbackResponse::getMessage)
                .containsExactly(0, "success");
        assertThat(MeituanCallbackResponse.failure(-99, "unsupported"))
                .extracting(MeituanCallbackResponse::getCode, MeituanCallbackResponse::getMessage)
                .containsExactly(-99, "unsupported");

        MeituanCallbackResponse<String> response = MeituanCallbackResponse.successJson("{\"stock\":12}");
        ObjectMapper objectMapper = JsonMapper.builder().build();
        JsonNode responseJson = objectMapper.readTree(objectMapper.writeValueAsString(response));
        assertThat(responseJson.get("data").isTextual()).isTrue();
        assertThat(responseJson.get("data").asText()).isEqualTo("{\"stock\":12}");
    }
}
