package io.github.easy4j.meituan.callback.business71;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 门店建店直连（businessId=71）消息类型目录测试。
 */
class MeituanBusiness71MessageTypeTest {

    @Test
    void shouldExposePoiAuditResultMessageContract() {
        assertThat(MeituanBusiness71MessageType.values()).hasSize(1);
        assertThat(MeituanBusiness71MessageType.POI_OPENAPI_MSG_PUSH.getDisplayName())
                .isEqualTo("审核结果通知");
        assertThat(MeituanBusiness71MessageType.POI_OPENAPI_MSG_PUSH.getCapabilityName())
                .isEqualTo("poi_openapi_msg_push");
        assertThat(MeituanBusiness71MessageType.POI_OPENAPI_MSG_PUSH.getMsgType()).isEqualTo("7110001");
        assertThat(MeituanBusiness71MessageType.POI_OPENAPI_MSG_PUSH.getDocumentUrl())
                .isEqualTo("https://developer.meituan.com/docs/msg/"
                        + "msg_mendianzhilian_2f16b69e-de3b-4f19-a24b-7c38f9bdc40f");
    }

    @Test
    void shouldResolveOnlyBusiness71MessagesAndPreserveUnknownType() {
        MeituanCallbackMessage auditResult = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "71", "msgType", "7110001", "message", "{}"));
        assertThat(MeituanBusiness71MessageType.resolve(auditResult))
                .contains(MeituanBusiness71MessageType.POI_OPENAPI_MSG_PUSH);

        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "7110001", "message", "{}"));
        assertThat(MeituanBusiness71MessageType.resolve(otherBusiness)).isEmpty();

        MeituanCallbackMessage unknownMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "71", "msgType", "7199999", "message", "{}"));
        assertThat(MeituanBusiness71MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMsgType()).isEqualTo("7199999");
    }
}
