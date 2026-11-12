package io.github.easy4j.meituan.callback.type;

import io.github.easy4j.meituan.callback.CallbackUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 门店建店直连（businessId=71）消息类型目录测试。
 */
class MeituanBusiness71MessageTypeTest {

    /**
     * 创建门店建店直连（businessId=71）消息类型目录测试。的空实例。
     */
    MeituanBusiness71MessageTypeTest() {
    }


    /**
     * 验证门店审核通知的编号、能力名称和文档地址。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldExposePoiAuditResultMessageContract() throws Exception {
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

    /**
     * 验证当前业务的已登记消息可解析，其他业务及未知编号保持隔离。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldResolveOnlyBusiness71MessagesAndPreserveUnknownType() throws Exception {
        MeituanCallbackMessage<String> auditResult = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "71", "msgType", "7110001", "message", "{}"), String.class);
        assertThat(MeituanBusiness71MessageType.resolve(auditResult))
                .contains(MeituanBusiness71MessageType.POI_OPENAPI_MSG_PUSH);

        MeituanCallbackMessage<String> otherBusiness = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "7110001", "message", "{}"), String.class);
        assertThat(MeituanBusiness71MessageType.resolve(otherBusiness)).isEmpty();

        MeituanCallbackMessage<String> unknownMessage = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "71", "msgType", "7199999", "message", "{}"), String.class);
        assertThat(MeituanBusiness71MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMsgType()).isEqualTo("7199999");
    }
}
