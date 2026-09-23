package io.github.easy4j.meituan.callback;

import io.github.easy4j.meituan.callback.business59.MeituanBusiness59MessageType;
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

        MeituanCallbackMessage callback = MeituanCallbackParser.parseForm(body);

        assertThat(callback.getMsgType()).isEqualTo("5910003");
        assertThat(callback.getBusinessId()).isEqualTo("59");
        assertThat(callback.getMessage()).isEqualTo(message);
        assertThat(MeituanBusiness59MessageType.resolve(callback))
                .contains(MeituanBusiness59MessageType.PRODUCT_STATUS_CHANGED);
        assertThat(callback.getParameters()).containsEntry("opBizCode", "1711591987");
    }

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

    @Test
    void shouldExposeAllDocumentedBusiness59MessagesWithoutDuplicateMsgTypes() {
        assertThat(MeituanBusiness59MessageType.values()).hasSize(33);

        Set<String> knownMsgTypes = java.util.Arrays.stream(MeituanBusiness59MessageType.values())
                .map(MeituanBusiness59MessageType::getMsgType)
                .filter(java.util.Objects::nonNull)
                .collect(Collectors.toSet());

        assertThat(knownMsgTypes).hasSize(33);
        assertThat(MeituanBusiness59MessageType.fromMsgType("5910149"))
                .contains(MeituanBusiness59MessageType.MEMBER_UNREGISTERED);

        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "5910003", "message", "{}"));
        assertThat(MeituanBusiness59MessageType.resolve(otherBusiness)).isEmpty();

        MeituanCallbackMessage unknownMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "59", "msgType", "5999999", "message", "{}"));
        assertThat(MeituanBusiness59MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMsgType()).isEqualTo("5999999");
    }

    @Test
    void shouldBuildStandardCallbackResponses() throws Exception {
        assertThat(MeituanCallbackResponse.success())
                .extracting(MeituanCallbackResponse::getCode, MeituanCallbackResponse::getMessage)
                .containsExactly(0, "success");
        assertThat(MeituanCallbackResponse.failure(-99, "unsupported"))
                .extracting(MeituanCallbackResponse::getCode, MeituanCallbackResponse::getMessage)
                .containsExactly(-99, "unsupported");

        MeituanCallbackResponse response = MeituanCallbackResponse.successJson("{\"stock\":12}");
        ObjectMapper objectMapper = JsonMapper.builder().build();
        JsonNode responseJson = objectMapper.readTree(objectMapper.writeValueAsString(response));
        assertThat(responseJson.get("data").isTextual()).isTrue();
        assertThat(responseJson.get("data").asText()).isEqualTo("{\"stock\":12}");
    }
}
