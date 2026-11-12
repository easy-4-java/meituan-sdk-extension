package io.github.easy4j.meituan.callback.type;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.CallbackUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 餐饮客户解决方案涉及的外卖品牌（businessId=2）消息类型目录测试。
 */
class MeituanBusiness2MessageTypeTest {

    /**
     * 创建\u9910\u996e\u5ba2\u6237\u89e3\u51b3\u65b9\u6848\u6d89\u53ca\u7684\u5916\u5356\u54c1\u724c\uff08businessId=2\uff09\u6d88\u606f\u7c7b\u578b\u76ee\u5f55\u6d4b\u8bd5\u3002的空实例。
     */
    MeituanBusiness2MessageTypeTest() {
    }


    /**
     * 验证业务 2 包含已公开的品牌 IM 消息定义。
     */
    @Test
    void shouldExposeDocumentedBrandImMessage() {
        assertThat(MeituanBusiness2MessageType.values())
                .hasSize(24).contains(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE);
        assertThat(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE.getDisplayName())
                .isEqualTo("接收IM两方会话消息");
        assertThat(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE.getMsgType()).isEqualTo("210069");
        assertThat(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE.getDocumentUrl()).isEqualTo(
                "https://developer.meituan.com/docs/msg/"
                        + "msg_waimaing_0667a278-09c5-4d5d-98b3-6a92b5d3cfd8"
        );
    }

    /**
     * 验证当前业务的已登记消息可解析，其他业务及未知编号保持隔离。
     */
    @Test
    void shouldResolveDocumentedBrandImMessageForBusiness2() {
        MeituanCallbackMessage<String> message = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "2",
                "msgType", "210069",
                "message", "{\"content\":\"hello\"}"
        ), String.class);

        assertThat(MeituanBusiness2MessageType.resolve(message))
                .contains(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE);
        assertThat(message.getMessage()).contains("hello");
    }

    /**
     * 验证跨业务消息被拒绝，并按通用回调契约处理未知编号。
     */
    @Test
    void shouldRejectOtherBusinessesAndKeepUnknownMessagesAvailable() {
        MeituanCallbackMessage<String> otherBusiness = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "86", "msgType", "210069", "message", "{}"
        ), String.class);
        MeituanCallbackMessage<String> unknownMessage = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "2", "msgType", "299999", "message", "{\"raw\":true}"
        ), String.class);

        assertThat(MeituanBusiness2MessageType.resolve(otherBusiness)).isEmpty();
        assertThat(MeituanBusiness2MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMessage()).isEqualTo("{\"raw\":true}");
    }
}
