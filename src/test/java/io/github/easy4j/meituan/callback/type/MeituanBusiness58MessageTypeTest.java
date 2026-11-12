package io.github.easy4j.meituan.callback.type;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.CallbackUtil;
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

    /**
     * 创建服务零售（businessId=58）消息类型目录测试。的空实例。
     */
    MeituanBusiness58MessageTypeTest() {
    }


    /**
     * 验证该业务的公开消息编号、名称、文档及编号唯一性。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldExposeAllDocumentedBusiness58MessagesWithoutDuplicateMsgTypes() throws Exception {
        assertThat(MeituanBusiness58MessageType.values()).hasSize(44);

        Set<String> msgTypes = Arrays.stream(MeituanBusiness58MessageType.values())
                .map(MeituanBusiness58MessageType::getMsgType)
                .collect(Collectors.toSet());

        assertThat(msgTypes).hasSize(44).contains("5810149", "5810147", "5810173");
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

    /**
     * 验证当前业务的已登记消息可解析，其他业务及未知编号保持隔离。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldResolveOnlyBusiness58MessagesAndKeepUnknownTypeAvailable() throws Exception {
        MeituanCallbackMessage<String> operateDevice = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "5810149", "message", "{}"), String.class);
        assertThat(MeituanBusiness58MessageType.resolve(operateDevice))
                .contains(MeituanBusiness58MessageType.OPERATE_DEVICE);

        MeituanCallbackMessage<String> otherBusiness = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "59", "msgType", "5810149", "message", "{}"), String.class);
        assertThat(MeituanBusiness58MessageType.resolve(otherBusiness)).isEmpty();

        MeituanCallbackMessage<String> unknownMessage = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "58", "msgType", "5899999", "message", "{}"), String.class);
        assertThat(MeituanBusiness58MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMsgType()).isEqualTo("5899999");
    }
}
