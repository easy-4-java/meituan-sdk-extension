package io.github.easy4j.meituan.callback;

import io.github.easy4j.meituan.callback.model.biz1000.MigrationCompletedMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderCancelledMessage;
import io.github.easy4j.meituan.callback.model.biz3.PaymentOrderMessage;
import io.github.easy4j.meituan.callback.model.biz46.PoiInfoChangedMessage;
import io.github.easy4j.meituan.callback.model.biz7.ReservationOrderCreatedMessage;
import io.github.easy4j.meituan.callback.model.biz59.MemberCreatedMessage;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 验证Meituan Payload的行为与接口契约。
 */
class MeituanPayloadTest {

    /**
     * 创建MeituanPayloadTest的空实例。
     */
    MeituanPayloadTest() {
    }


    /**
     * 验证独立映射器启用下划线策略后仍采用官网字段名称。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void standaloneMapperUsesDocumentedNamesEvenWithASnakeCaseNamingStrategy() throws Exception {
        JsonMapper mapper = JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
        String json = "{\"ePoiId\":\"shop\",\"newField\":1,\"data\":\"{\\\"orderSerializedId\\\":\\\"001\\\",\\\"newDetail\\\":true}\"}\n";
        ReservationOrderCreatedMessage reservation = mapper.readValue(json, ReservationOrderCreatedMessage.class);
        assertThat(reservation.getData().getOrderSerializedId()).isEqualTo("001");
        JsonNode output = mapper.readTree(mapper.writeValueAsString(reservation));
        assertThat(output.path("ePoiId").asText()).isEqualTo("shop");
        assertThat(output.path("data").path("orderSerializedId").asText()).isEqualTo("001");
        assertThat(output.has("e_poi_id")).isFalse();
    }

    /**
     * 验证会员标识反序列化后保留前导零。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void mapsMemberIdentifiersWithoutLosingLeadingZeros() throws Exception {
        MemberCreatedMessage member = CallbackUtil.parse("businessId=59&msgType=5910019",
                io.github.easy4j.meituan.TestCollections.mapOf("message", io.github.easy4j.meituan.TestCollections.mapOf("opUserId", "user", "phone", "01333333333",
                        "gender", "1", "requestSeq", "00001")), MemberCreatedMessage.class).getMessage();

        assertThat(member.getOpUserId()).isEqualTo("user");
        assertThat(member.getPhone()).isEqualTo("01333333333");
        assertThat(member.getGender()).isEqualTo("1");
        assertThat(member.getRequestSeq()).isEqualTo("00001");
    }

    /**
     * 验证预订及编码需求字段被类型化，原始验签文本保持完整。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void mapsReservationAndItsEncodedRequirementsWithoutChangingTheSignedMessage() throws Exception {
        String data = "{\"orderSerializedId\":\"001\",\"status\":10,\"requirements\":\"{\\\"tableType\\\":1,\\\"remark\\\":\\\"靠窗\\\"}\"}\n".trim();
        MeituanCallbackMessage<ReservationOrderCreatedMessage> callback = CallbackUtil.parse("businessId=7&msgType=710003",
                io.github.easy4j.meituan.TestCollections.mapOf("message", io.github.easy4j.meituan.TestCollections.mapOf("ePoiId", "shop", "data", data)), ReservationOrderCreatedMessage.class);

        assertThat(callback.getMessage().getData().getOrderSerializedId()).isEqualTo("001");
        assertThat(callback.getMessage().getData().getRequirements().getRemark()).isEqualTo("靠窗");
        assertThat(callback.getRawMessage()).isEqualTo(callback.getParameters().get("message"));
    }

    /**
     * 验证消息模型按业务编号和消息编号共同选择。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void resolvesMessageClassWithinItsBusiness() throws Exception {
        assertThat(MeituanCallbackModels.find("59", "5910019")).hasValue(MemberCreatedMessage.class);
        assertThat(MeituanCallbackModels.find("7", "5910019")).isEmpty();
        assertThat(MeituanCallbackModels.find("1", "110017"))
                .isEqualTo(MeituanCallbackModels.find("1", "110027")).isPresent();
    }

    /**
     * 验证数组型消息可以直接映射为集合模型。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void readsArrayPayloadWithoutAnArtificialWrapperProperty() throws Exception {
        MeituanCallbackMessage<MigrationCompletedMessage> callback = CallbackUtil.parse("businessId=1000&msgType=100010007",
                io.github.easy4j.meituan.TestCollections.mapOf("message", io.github.easy4j.meituan.TestCollections.listOf(io.github.easy4j.meituan.TestCollections.mapOf("opBizCode", "000123", "status", 3))),
                MigrationCompletedMessage.class);
        assertThat(callback.getMessage()).singleElement().satisfies(entry -> {
            assertThat(entry.getOpBizCode()).isEqualTo("000123");
            assertThat(entry.getStatus()).isEqualTo(3);
        });
    }

    /**
     * 验证历史表单协议可以读取且保留其验签参数。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void readsDocumentedLegacyFormsAndPreservesTheirSigningParameters() throws Exception {
        String order = "{\"orderId\":9007199254740993,\"reason\":\"取消\"}";
        MeituanCallbackMessage<OrderCancelledMessage> cancel = CallbackUtil.parse(null,
                io.github.easy4j.meituan.TestCollections.mapOf("ePoiId", "shop", "orderCancel", order), OrderCancelledMessage.class);
        assertThat(cancel.getMessage().getOrderCancel().getOrderId()).isEqualTo(9007199254740993L);
        assertThat(cancel.getParameters()).containsEntry("orderCancel", order);

        String payment = "{\"business\":\"Hui\",\"amountInfo\":{\"actualPay\":10.10}}";
        MeituanCallbackMessage<PaymentOrderMessage> flash = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf("params", payment), PaymentOrderMessage.class);
        assertThat(flash.getRawMessage()).isEqualTo(payment);
        assertThat(flash.getMessage().getAmountInfo().getActualPay().toString()).isIn("10.10", "10.1");
    }

    /**
     * 验证门店变更消息兼容官网对象和字符串两种形态。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void keepsBothPublishedShapesOfTheStoreChangeMessage() throws Exception {
        MeituanCallbackMessage<PoiInfoChangedMessage> text = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf("message", "\"example\""), PoiInfoChangedMessage.class);
        assertThat(text.getMessage().getTextValue()).isEqualTo("example");
        MeituanCallbackMessage<PoiInfoChangedMessage> object = CallbackUtil.parse(null, io.github.easy4j.meituan.TestCollections.mapOf("message", io.github.easy4j.meituan.TestCollections.mapOf("poiId", 123, "detail", "变更")),
                PoiInfoChangedMessage.class);
        assertThat(object.getMessage().getPoiId()).isEqualTo(123);
        assertThat(object.getMessage().getDetail()).isEqualTo("变更");
    }
}
