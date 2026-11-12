package io.github.easy4j.meituan.callback.type;

import io.github.easy4j.meituan.callback.CallbackUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 餐饮客户解决方案涉及的外卖品牌（businessId=2）消息类型目录测试。
 */
class MeituanBusiness2MessageTypeTest {

    /**
     * 创建餐饮客户解决方案涉及的外卖品牌（businessId=2）消息类型目录测试。的空实例。
     */
    MeituanBusiness2MessageTypeTest() {
    }


    /**
     * 验证业务 2 包含已公开的品牌 IM 消息定义。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldExposeDocumentedBrandImMessage() throws Exception {
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
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldResolveDocumentedBrandImMessageForBusiness2() throws Exception {
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
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldRejectOtherBusinessesAndKeepUnknownMessagesAvailable() throws Exception {
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
