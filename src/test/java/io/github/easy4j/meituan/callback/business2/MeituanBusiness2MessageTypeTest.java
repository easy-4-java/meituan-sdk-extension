package io.github.easy4j.meituan.callback.business2;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 餐饮客户解决方案涉及的外卖品牌（businessId=2）消息类型目录测试。
 */
class MeituanBusiness2MessageTypeTest {

    @Test
    void shouldExposeDocumentedBrandImMessage() {
        assertThat(MeituanBusiness2MessageType.values())
                .containsExactly(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE);
        assertThat(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE.getDisplayName())
                .isEqualTo("接收IM两方会话消息");
        assertThat(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE.getMsgType()).isEqualTo("210069");
        assertThat(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE.getDocumentUrl()).isEqualTo(
                "https://developer.meituan.com/docs/msg/"
                        + "msg_waimaing_0667a278-09c5-4d5d-98b3-6a92b5d3cfd8"
        );
    }

    @Test
    void shouldResolveDocumentedBrandImMessageForBusiness2() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "2",
                "msgType", "210069",
                "message", "{\"content\":\"hello\"}"
        ));

        assertThat(MeituanBusiness2MessageType.resolve(message))
                .contains(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE);
        assertThat(message.getMessage()).contains("hello");
    }

    @Test
    void shouldRejectOtherBusinessesAndKeepUnknownMessagesAvailable() {
        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "86", "msgType", "210069", "message", "{}"
        ));
        MeituanCallbackMessage unknownMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "2", "msgType", "299999", "message", "{\"raw\":true}"
        ));

        assertThat(MeituanBusiness2MessageType.resolve(otherBusiness)).isEmpty();
        assertThat(MeituanBusiness2MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMessage()).isEqualTo("{\"raw\":true}");
    }
}
