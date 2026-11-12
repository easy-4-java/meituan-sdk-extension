package io.github.easy4j.meituan.callback.type;

import io.github.easy4j.meituan.callback.CallbackUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店餐饮品牌会员卡（businessId=15）消息类型目录测试。
 */
class MeituanBusiness15MessageTypeTest {

    /**
     * 创建到店餐饮品牌会员卡（businessId=15）消息类型目录测试。的空实例。
     */
    MeituanBusiness15MessageTypeTest() {
    }


    /**
     * 验证该业务的公开消息编号、名称、文档及编号唯一性。
     */
    @Test
    void shouldExposeAllFiveDocumentedMessageTypes() {
        assertThat(MeituanBusiness15MessageType.values()).containsExactly(
                MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT,
                MeituanBusiness15MessageType.MEMBERSHIP_CARD_POINTS,
                MeituanBusiness15MessageType.CO_BRANDED_NEW_USER_QUERY,
                MeituanBusiness15MessageType.BRAND_MEMBER_QUERY,
                MeituanBusiness15MessageType.BRAND_MEMBER_REGISTRATION_AND_RIGHTS,
                MeituanBusiness15MessageType.BRAND_MEMBER_LEVEL_CHANGED
        );
        assertThat(MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT.getMsgType()).isEqualTo("15201");
        assertThat(MeituanBusiness15MessageType.MEMBERSHIP_CARD_POINTS.getMsgType()).isEqualTo("15202");
        assertThat(MeituanBusiness15MessageType.CO_BRANDED_NEW_USER_QUERY.getMsgType()).isEqualTo("15101");
        assertThat(MeituanBusiness15MessageType.BRAND_MEMBER_QUERY.getMsgType()).isEqualTo("1510001");
        assertThat(MeituanBusiness15MessageType.BRAND_MEMBER_REGISTRATION_AND_RIGHTS.getMsgType())
                .isEqualTo("1510003");
    }

    /**
     * 验证标准回调信封可解析为会员卡事件。
     */
    @Test
    void shouldResolveModernMessageEnvelope() {
        MeituanCallbackMessage<String> message = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "msgType", "15201",
                "message", "{\"eventType\":\"USER_GET_CARD_EVENT\"}"
        ), String.class);

        assertThat(MeituanBusiness15MessageType.resolve(message))
                .contains(MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT);
        assertThat(message.getMessage()).contains("USER_GET_CARD_EVENT");
    }

    /**
     * 验证旧版 invokeType 和 param 字段可以归一化读取。
     */
    @Test
    void shouldNormalizeLegacyInvokeTypeAndParamEnvelope() {
        MeituanCallbackMessage<String> message = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "invokeType", "15101",
                "param", "{\"phoneNo\":\"19288387287\",\"platformType\":\"MEI_TUAN\"}"
        ), String.class);

        assertThat(message.getMsgType()).isEqualTo("15101");
        assertThat(message.getMessage()).contains("19288387287");
        assertThat(MeituanBusiness15MessageType.resolve(message))
                .contains(MeituanBusiness15MessageType.CO_BRANDED_NEW_USER_QUERY);
    }

    /**
     * 验证标准字段与旧协议字段并存时优先使用标准字段。
     */
    @Test
    void shouldPreferModernEnvelopeWhenModernAndLegacyFieldsCollide() {
        MeituanCallbackMessage<String> message = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "msgType", "15201",
                "invokeType", "15101",
                "message", "{\"source\":\"modern\"}",
                "param", "{\"source\":\"legacy\"}"
        ), String.class);

        assertThat(message.getMsgType()).isEqualTo("15201");
        assertThat(message.getMessage()).isEqualTo("{\"source\":\"modern\"}");
        assertThat(MeituanBusiness15MessageType.resolve(message))
                .contains(MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT);
    }

    /**
     * 验证未知消息编号仍可通过通用回调读取原文。
     */
    @Test
    void shouldKeepUnknownMessageAvailableToGenericCallbackConsumers() {
        MeituanCallbackMessage<String> message = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "msgType", "1599999",
                "message", "{\"mtLevel\":\"L6\"}"
        ), String.class);

        assertThat(MeituanBusiness15MessageType.resolve(message)).isEmpty();
        assertThat(message.getBusinessId()).isEqualTo("15");
        assertThat(message.getMsgType()).isEqualTo("1599999");
        assertThat(message.getMessage()).contains("L6");
    }
}
