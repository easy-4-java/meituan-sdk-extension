package io.github.easy4j.meituan.callback.business58;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 服务零售（businessId=58）消息类型目录测试。
 */
class MeituanBusiness58MessageTypeTest {

    @Test
    void shouldExposeAllDocumentedBusiness58MessagesWithoutDuplicateMsgTypes() {
        assertThat(MeituanBusiness58MessageType.values()).hasSize(3);

        Set<String> msgTypes = Arrays.stream(MeituanBusiness58MessageType.values())
                .map(MeituanBusiness58MessageType::getMsgType)
                .collect(Collectors.toSet());

        assertThat(msgTypes).containsExactlyInAnyOrder("5810149", "5810147", "5810173");
        assertThat(MeituanBusiness58MessageType.OPERATE_DEVICE.getDisplayName()).isEqualTo("操作设备");
        assertThat(MeituanBusiness58MessageType.OPERATE_DEVICE.getMsgType()).isEqualTo("5810149");
        assertThat(MeituanBusiness58MessageType.OPERATE_DEVICE.getDocumentUrl())
                .endsWith("msg_ddzh_12820d14-4867-46b5-b527-210c123fc5e9");
        assertThat(MeituanBusiness58MessageType.START_DEVICE_AND_CONSUME_DEAL.getDisplayName())
                .isEqualTo("启动设备并核销团单");
        assertThat(MeituanBusiness58MessageType.START_DEVICE_AND_CONSUME_DEAL.getMsgType()).isEqualTo("5810147");
        assertThat(MeituanBusiness58MessageType.START_DEVICE_AND_CONSUME_DEAL.getDocumentUrl())
                .endsWith("msg_ddzh_6ea4ba3a-a2c7-4e18-a897-c5c2ee96c47c");
        assertThat(MeituanBusiness58MessageType.ORDER_REFUND_INFO_PUSHED.getDisplayName())
                .isEqualTo("订单退款信息推送");
        assertThat(MeituanBusiness58MessageType.ORDER_REFUND_INFO_PUSHED.getMsgType()).isEqualTo("5810173");
        assertThat(MeituanBusiness58MessageType.ORDER_REFUND_INFO_PUSHED.getDocumentUrl())
                .endsWith("msg_ddzh_a8ef235b-a621-4de4-b8d4-b0820980ea4f");
    }

    @Test
    void shouldResolveOnlyBusiness58MessagesAndKeepUnknownTypeAvailable() {
        MeituanCallbackMessage operateDevice = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "5810149", "message", "{}"));
        assertThat(MeituanBusiness58MessageType.resolve(operateDevice))
                .contains(MeituanBusiness58MessageType.OPERATE_DEVICE);

        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "59", "msgType", "5810149", "message", "{}"));
        assertThat(MeituanBusiness58MessageType.resolve(otherBusiness)).isEmpty();

        MeituanCallbackMessage unknownMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "5899999", "message", "{}"));
        assertThat(MeituanBusiness58MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMsgType()).isEqualTo("5899999");
    }
}
