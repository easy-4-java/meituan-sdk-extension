package io.github.easy4j.meituan.callback.business15;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店餐饮品牌会员卡（businessId=15）消息类型目录测试。
 */
class MeituanBusiness15MessageTypeTest {

    @Test
    void shouldExposeAllFiveDocumentedMessageTypes() {
        assertThat(MeituanBusiness15MessageType.values()).containsExactly(
                MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT,
                MeituanBusiness15MessageType.MEMBERSHIP_CARD_POINTS,
                MeituanBusiness15MessageType.CO_BRANDED_NEW_USER_QUERY,
                MeituanBusiness15MessageType.BRAND_MEMBER_QUERY,
                MeituanBusiness15MessageType.BRAND_MEMBER_REGISTRATION_AND_RIGHTS
        );
        assertThat(MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT.getMsgType()).isEqualTo("15201");
        assertThat(MeituanBusiness15MessageType.MEMBERSHIP_CARD_POINTS.getMsgType()).isEqualTo("15202");
        assertThat(MeituanBusiness15MessageType.CO_BRANDED_NEW_USER_QUERY.getMsgType()).isEqualTo("15101");
        assertThat(MeituanBusiness15MessageType.BRAND_MEMBER_QUERY.getMsgType()).isEqualTo("1510001");
        assertThat(MeituanBusiness15MessageType.BRAND_MEMBER_REGISTRATION_AND_RIGHTS.getMsgType())
                .isEqualTo("1510003");
    }

    @Test
    void shouldResolveModernMessageEnvelope() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "msgType", "15201",
                "message", "{\"eventType\":\"USER_GET_CARD_EVENT\"}"
        ));

        assertThat(MeituanBusiness15MessageType.resolve(message))
                .contains(MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT);
        assertThat(message.getMessage()).contains("USER_GET_CARD_EVENT");
    }

    @Test
    void shouldNormalizeLegacyInvokeTypeAndParamEnvelope() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "invokeType", "15101",
                "param", "{\"phoneNo\":\"19288387287\",\"platformType\":\"MEI_TUAN\"}"
        ));

        assertThat(message.getMsgType()).isEqualTo("15101");
        assertThat(message.getMessage()).contains("19288387287");
        assertThat(MeituanBusiness15MessageType.resolve(message))
                .contains(MeituanBusiness15MessageType.CO_BRANDED_NEW_USER_QUERY);
    }

    @Test
    void shouldPreferModernEnvelopeWhenModernAndLegacyFieldsCollide() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "msgType", "15201",
                "invokeType", "15101",
                "message", "{\"source\":\"modern\"}",
                "param", "{\"source\":\"legacy\"}"
        ));

        assertThat(message.getMsgType()).isEqualTo("15201");
        assertThat(message.getMessage()).isEqualTo("{\"source\":\"modern\"}");
        assertThat(MeituanBusiness15MessageType.resolve(message))
                .contains(MeituanBusiness15MessageType.MEMBERSHIP_CARD_EVENT);
    }

    @Test
    void shouldKeepUndocumentedLevelChangeAvailableToGenericCallbackConsumers() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15",
                "msgType", "1599999",
                "message", "{\"mtLevel\":\"L6\"}"
        ));

        assertThat(MeituanBusiness15MessageType.resolve(message)).isEmpty();
        assertThat(message.getBusinessId()).isEqualTo("15");
        assertThat(message.getMsgType()).isEqualTo("1599999");
        assertThat(message.getMessage()).contains("L6");
    }
}
