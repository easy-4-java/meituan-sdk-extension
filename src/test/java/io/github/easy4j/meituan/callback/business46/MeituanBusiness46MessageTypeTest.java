package io.github.easy4j.meituan.callback.business46;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * 团购配送（businessId=46）消息类型目录测试。
 */
class MeituanBusiness46MessageTypeTest {

    @Test
    void shouldExposeAllFourteenDocumentedMessageTypes() {
        assertThat(MeituanBusiness46MessageType.values())
                .extracting(
                        MeituanBusiness46MessageType::getDisplayName,
                        MeituanBusiness46MessageType::getMsgType,
                        MeituanBusiness46MessageType::getDocumentUrl
                )
                .containsExactly(
                        tuple("套餐配送接单消息", "4610000", document("msg_dcps_48121253-009e-4075-89d4-5b79fb9ba172")),
                        tuple("接收门店信息变更消息", "4610023", document("msg_dcps_7eec9ee3-9b57-451a-aaf9-ccd574dbecdf")),
                        tuple("接收订单完成消息", "4610018", document("msg_dcps_69917343-b53f-4de8-bdbf-2eee2477bdd5")),
                        tuple("接收订单自配完成消息", "4610016", document("msg_dcps_4548a521-15cb-4dfb-8721-971a0e831085")),
                        tuple("接收订单可转自配消息", "4610014", document("msg_dcps_efa3af0a-85bd-4cc9-94c4-4e5a7d712ddb")),
                        tuple("接收配送状态变更消息", "4610012", document("msg_dcps_14be7b74-05e1-4b4e-a626-d6cacbee850c")),
                        tuple("接收订单已出餐消息", "4610010", document("msg_dcps_0771bd42-2080-4e7d-886c-c0969ded3078")),
                        tuple("接收用户退款状态变更消息", "4610008", document("msg_dcps_d812c905-37ba-4972-8204-9f7e867a1f78")),
                        tuple("接收订单超时取消消息", "4610006", document("msg_dcps_b19bc448-d624-41db-9b33-58501f48ba16")),
                        tuple("接收订单拒绝接单消息", "4610004", document("msg_dcps_baa84876-82fa-4e30-8b8e-e8ffa051a452")),
                        tuple("接收订单已支付消息", "4610002", document("msg_dcps_75fe9410-4d49-40f6-960e-22e55329fd59")),
                        tuple("接收商家转自配成功消息", "4610026", document("msg_dcps_73535482-f538-43e6-9b11-b18a4535e484")),
                        tuple("接收预订单提醒备餐消息", "4610024", document("msg_dcps_eb9ee436-1e53-420f-891e-cb030e8c9dba")),
                        tuple("指定打印机打印订单", "4610029", document("msg_dcps_d36c3f46-442f-4189-ba83-36591af2f548"))
                );
    }

    @Test
    void shouldResolveDocumentedMessageForBusiness46() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "46",
                "msgType", "4610012",
                "message", "{\"orderId\":1000}"
        ));

        assertThat(MeituanBusiness46MessageType.resolve(message))
                .contains(MeituanBusiness46MessageType.DELIVERY_STATUS_CHANGED);
        assertThat(message.getMessage()).isEqualTo("{\"orderId\":1000}");
    }

    @Test
    void shouldRejectOtherBusinessesAndKeepUnknownMessagesAvailable() {
        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "27", "msgType", "4610012", "message", "{}"
        ));
        MeituanCallbackMessage unknownMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "46", "msgType", "4699999", "message", "{\"raw\":true}"
        ));

        assertThat(MeituanBusiness46MessageType.resolve(otherBusiness)).isEmpty();
        assertThat(MeituanBusiness46MessageType.resolve(unknownMessage)).isEmpty();
        assertThat(unknownMessage.getMessage()).isEqualTo("{\"raw\":true}");
    }

    private String document(String documentKey) {
        return "https://developer.meituan.com/docs/msg/" + documentKey;
    }
}
