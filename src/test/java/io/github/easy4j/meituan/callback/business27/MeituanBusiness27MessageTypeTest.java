package io.github.easy4j.meituan.callback.business27;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * 快驴（businessId=27）消息类型目录测试。
 */
class MeituanBusiness27MessageTypeTest {

    @Test
    void shouldExposeAllSixDocumentedMessageTypes() {
        assertThat(MeituanBusiness27MessageType.values())
                .extracting(
                        MeituanBusiness27MessageType::getDisplayName,
                        MeituanBusiness27MessageType::getMsgType,
                        MeituanBusiness27MessageType::getDocumentUrl
                )
                .containsExactly(
                        tuple(
                                "快驴订单创建结果异步通知",
                                "27001",
                                "https://developer.meituan.com/docs/msg/msg_klopen_29b2c89c-6012-4333-990c-5d5f5eda69a7"
                        ),
                        tuple(
                                "快驴入库通知",
                                "27002",
                                "https://developer.meituan.com/docs/msg/msg_klopen_4e16b653-ed45-4efa-8948-0badc1dfa9f2"
                        ),
                        tuple(
                                "快驴出库通知",
                                "27003",
                                "https://developer.meituan.com/docs/msg/msg_klopen_1056ac08-a99a-4053-a2bc-db530bb5c3af"
                        ),
                        tuple(
                                "快驴订单取消通知",
                                "27004",
                                "https://developer.meituan.com/docs/msg/msg_klopen_642ff552-99c0-4a65-bb26-ef6c66a45314"
                        ),
                        tuple(
                                "快驴推送账单明细",
                                "2710003",
                                "https://developer.meituan.com/docs/msg/msg_klopen_cd5fa387-81aa-4cb7-836a-58fff83b41a5"
                        ),
                        tuple(
                                "快驴订单发货通知",
                                "2710005",
                                "https://developer.meituan.com/docs/msg/msg_klopen_80bb04b0-5b52-4d47-9d55-430c0e561e79"
                        )
                );
    }

    @Test
    void shouldResolveDocumentedMessageForBusiness27() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "27",
                "msgType", "27004",
                "message", "{\"orderNo\":\"K1000\"}"
        ));

        assertThat(MeituanBusiness27MessageType.resolve(message))
                .contains(MeituanBusiness27MessageType.ORDER_CANCEL_NOTICE);
        assertThat(message.getMessage()).isEqualTo("{\"orderNo\":\"K1000\"}");
    }

    @Test
    void shouldRejectOtherBusinessesAndKeepUndocumentedMessagesAvailable() {
        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "51", "msgType", "27004", "message", "{}"
        ));
        MeituanCallbackMessage undocumentedMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "27", "msgType", "2799999", "message", "{\"raw\":true}"
        ));

        assertThat(MeituanBusiness27MessageType.resolve(otherBusiness)).isEmpty();
        assertThat(MeituanBusiness27MessageType.resolve(undocumentedMessage)).isEmpty();
        assertThat(undocumentedMessage.getMessage()).isEqualTo("{\"raw\":true}");
    }
}
