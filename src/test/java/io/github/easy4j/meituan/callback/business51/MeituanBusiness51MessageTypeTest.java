package io.github.easy4j.meituan.callback.business51;

import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackParser;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * 到店餐饮在线点（businessId=51）消息类型目录测试。
 */
class MeituanBusiness51MessageTypeTest {

    @Test
    void shouldExposeAllTwelveDocumentedMessageTypes() {
        assertThat(MeituanBusiness51MessageType.values()).containsExactly(
                MeituanBusiness51MessageType.ONLINE_BUSINESS_CHANGE,
                MeituanBusiness51MessageType.ONLINE_SERVICE_STATUS_CHANGE,
                MeituanBusiness51MessageType.PREPARATION_TIME_QUERY,
                MeituanBusiness51MessageType.PRODUCT_AUDIT_NOTICE,
                MeituanBusiness51MessageType.BRAND_ORDER_QUERY,
                MeituanBusiness51MessageType.PLATFORM_ORDER_STATUS_CHANGE,
                MeituanBusiness51MessageType.ORDER_PUSH,
                MeituanBusiness51MessageType.PREPARATION_TIME_AND_QUEUE_QUERY,
                MeituanBusiness51MessageType.ORDER_FULFILLMENT_QUERY,
                MeituanBusiness51MessageType.REFUND_APPLICATION_PUSH,
                MeituanBusiness51MessageType.PAID_ORDER_PUSH,
                MeituanBusiness51MessageType.BRAND_ORDER_CANCEL
        );
        assertThat(MeituanBusiness51MessageType.values())
                .extracting(
                        MeituanBusiness51MessageType::getDisplayName,
                        MeituanBusiness51MessageType::getMsgType,
                        MeituanBusiness51MessageType::getDocumentUrl
                )
                .containsExactly(
                        tuple(
                                "美团通知品牌方“线上点”业务变更",
                                "5110001",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_babc2497-e3b5-49be-8259-3412d71fe210"
                        ),
                        tuple(
                                "美团通知品牌方门店“线上点”营业状态变更",
                                "5110003",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_ac21784a-7718-4ab3-9a41-2ea7eafa6fca"
                        ),
                        tuple(
                                "门店预计备餐时间查询",
                                "5110005",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_dbf2bef2-55ee-4d2e-9985-7cf039ca2ff6"
                        ),
                        tuple(
                                "商品审核失败通知（必接）",
                                "5110007",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_217803ab-efd3-47e2-bb94-bad7e887b645"
                        ),
                        tuple(
                                "品牌提供订单查询",
                                "5110009",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_9e4af01d-409c-4a85-addb-2da4f86831bf"
                        ),
                        tuple(
                                "美团平台订单状态变更通知",
                                "5110011",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_1578f703-51d9-408d-8115-81600e6bda31"
                        ),
                        tuple(
                                "推单接口",
                                "5110013",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_a4d1b81e-3c9c-48d6-928c-52c9d43e3754"
                        ),
                        tuple(
                                "门店预计备餐时间和排队信息（必接）",
                                "5110019",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_8516072d-d9ba-40dd-bc43-ab46c1276b5d"
                        ),
                        tuple(
                                "查询订单履约信息",
                                "5110021",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_c5d73602-79ab-4880-ba25-ef974c42f9d0"
                        ),
                        tuple(
                                "退款申请推送",
                                "5110023",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_8ac18476-e862-4fb9-a767-1050f22689c7"
                        ),
                        tuple(
                                "新订单推送（已支付）",
                                "5110025",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_3dca76a3-2434-4548-be17-d3258d17e967"
                        ),
                        tuple(
                                "品牌提供取消订单",
                                "5110029",
                                "https://developer.meituan.com/docs/msg/msg_foodmop_c2d61f12-5312-4717-8fef-1d4cbba36709"
                        )
                );
    }

    @Test
    void shouldResolveDocumentedMessageForBusiness51() {
        MeituanCallbackMessage message = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "51",
                "msgType", "5110013",
                "message", "{\"orderId\":1000}"
        ));

        assertThat(MeituanBusiness51MessageType.resolve(message))
                .contains(MeituanBusiness51MessageType.ORDER_PUSH);
        assertThat(message.getMessage()).isEqualTo("{\"orderId\":1000}");
    }

    @Test
    void shouldRejectOtherBusinessesAndKeepUndocumentedMessagesAvailable() {
        MeituanCallbackMessage otherBusiness = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "15", "msgType", "5110013", "message", "{}"
        ));
        MeituanCallbackMessage undocumentedMessage = MeituanCallbackParser.parse(io.github.easy4j.meituan.TestCollections.mapOf(
                "businessId", "51", "msgType", "5199999", "message", "{\"raw\":true}"
        ));

        assertThat(MeituanBusiness51MessageType.resolve(otherBusiness)).isEmpty();
        assertThat(MeituanBusiness51MessageType.resolve(undocumentedMessage)).isEmpty();
        assertThat(undocumentedMessage.getMessage()).isEqualTo("{\"raw\":true}");
    }
}
