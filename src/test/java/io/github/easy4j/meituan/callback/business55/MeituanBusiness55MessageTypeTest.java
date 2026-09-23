package io.github.easy4j.meituan.callback.business55;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 大众点评免费试（businessId=55）消息类型目录测试。
 */
class MeituanBusiness55MessageTypeTest {

    @Test
    void shouldExposeAndResolveActivityChangeNotice() {
        assertThat(MeituanBusiness55MessageType.values()).containsExactly(
                MeituanBusiness55MessageType.ACTIVITY_CHANGE_NOTICE
        );
        assertThat(MeituanBusiness55MessageType.ACTIVITY_CHANGE_NOTICE.getDisplayName())
                .isEqualTo("活动变更通知");
        assertThat(MeituanBusiness55MessageType.ACTIVITY_CHANGE_NOTICE.getMsgType()).isEqualTo("5510001");
        assertThat(MeituanBusiness55MessageType.ACTIVITY_CHANGE_NOTICE.getDocumentUrl())
                .endsWith("msg_freetryopen_da0cca39-5099-452f-9d9b-c9bb632c0a81");

        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "55",
                "msgType", "5510001",
                "message", "{\"activityId\":1000}"
        ));

        assertThat(MeituanBusiness55MessageType.resolve(message))
                .contains(MeituanBusiness55MessageType.ACTIVITY_CHANGE_NOTICE);
        assertThat(message.getMessage()).isEqualTo("{\"activityId\":1000}");
    }

    @Test
    void shouldRejectOtherBusinessesAndUnknownMessages() {
        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "5510001", "message", "{}"
        ));
        MeituanCallbackMessage unknownMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "55", "msgType", "5599999", "message", "{}"
        ));

        assertThat(MeituanBusiness55MessageType.resolve(otherBusiness)).isEmpty();
        assertThat(MeituanBusiness55MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMsgType()).isEqualTo("5599999");
    }
}
