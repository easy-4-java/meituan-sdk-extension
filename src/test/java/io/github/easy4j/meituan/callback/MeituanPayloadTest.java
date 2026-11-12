package io.github.easy4j.meituan.callback;

import io.github.easy4j.meituan.callback.model.biz1000.MigrationCompletedMessage;
import io.github.easy4j.meituan.callback.model.biz2.OrderCancelledMessage;
import io.github.easy4j.meituan.callback.model.biz3.PaymentOrderMessage;
import io.github.easy4j.meituan.callback.model.biz46.PoiInfoChangedMessage;
import io.github.easy4j.meituan.callback.model.biz7.ReservationOrderCreatedMessage;
import io.github.easy4j.meituan.callback.model.biz59.MemberCreatedMessage;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MeituanPayloadTest {

    @Test
    void standaloneMapperUsesDocumentedNamesEvenWithASnakeCaseNamingStrategy() {
        JsonMapper mapper = JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
        String json = """
                {"ePoiId":"shop","newField":1,"data":"{\\"orderSerializedId\\":\\"001\\",\\"newDetail\\":true}"}
                """;
        var reservation = mapper.readValue(json, ReservationOrderCreatedMessage.class);
        assertThat(reservation.getData().getOrderSerializedId()).isEqualTo("001");
        var output = mapper.readTree(mapper.writeValueAsString(reservation));
        assertThat(output.path("ePoiId").asString()).isEqualTo("shop");
        assertThat(output.path("data").path("orderSerializedId").asString()).isEqualTo("001");
        assertThat(output.has("e_poi_id")).isFalse();
    }

    @Test
    void mapsMemberIdentifiersWithoutLosingLeadingZeros() {
        MemberCreatedMessage member = CallbackUtil.parse("businessId=59&msgType=5910019",
                Map.of("message", Map.of("opUserId", "user", "phone", "01333333333",
                        "gender", "1", "requestSeq", "00001")), MemberCreatedMessage.class).getMessage();

        assertThat(member.getOpUserId()).isEqualTo("user");
        assertThat(member.getPhone()).isEqualTo("01333333333");
        assertThat(member.getGender()).isEqualTo("1");
        assertThat(member.getRequestSeq()).isEqualTo("00001");
    }

    @Test
    void mapsReservationAndItsEncodedRequirementsWithoutChangingTheSignedMessage() {
        String data = """
                {"orderSerializedId":"001","status":10,"requirements":"{\\"tableType\\":1,\\"remark\\":\\"靠窗\\"}"}
                """.trim();
        var callback = CallbackUtil.parse("businessId=7&msgType=710003",
                Map.of("message", Map.of("ePoiId", "shop", "data", data)), ReservationOrderCreatedMessage.class);

        assertThat(callback.getMessage().getData().getOrderSerializedId()).isEqualTo("001");
        assertThat(callback.getMessage().getData().getRequirements().getRemark()).isEqualTo("靠窗");
        assertThat(callback.getRawMessage()).isEqualTo(callback.getParameters().get("message"));
    }

    @Test
    void resolvesMessageClassWithinItsBusiness() {
        assertThat(MeituanCallbackModels.find("59", "5910019")).hasValue(MemberCreatedMessage.class);
        assertThat(MeituanCallbackModels.find("7", "5910019")).isEmpty();
        assertThat(MeituanCallbackModels.find("1", "110017"))
                .isEqualTo(MeituanCallbackModels.find("1", "110027")).isPresent();
    }

    @Test
    void readsArrayPayloadWithoutAnArtificialWrapperProperty() {
        var callback = CallbackUtil.parse("businessId=1000&msgType=100010007",
                Map.of("message", List.of(Map.of("opBizCode", "000123", "status", 3))),
                MigrationCompletedMessage.class);
        assertThat(callback.getMessage()).singleElement().satisfies(entry -> {
            assertThat(entry.getOpBizCode()).isEqualTo("000123");
            assertThat(entry.getStatus()).isEqualTo(3);
        });
    }

    @Test
    void readsDocumentedLegacyFormsAndPreservesTheirSigningParameters() {
        String order = "{\"orderId\":9007199254740993,\"reason\":\"取消\"}";
        var cancel = CallbackUtil.parse(null,
                Map.of("ePoiId", "shop", "orderCancel", order), OrderCancelledMessage.class);
        assertThat(cancel.getMessage().getOrderCancel().getOrderId()).isEqualTo(9007199254740993L);
        assertThat(cancel.getParameters()).containsEntry("orderCancel", order);

        String payment = "{\"business\":\"Hui\",\"amountInfo\":{\"actualPay\":10.10}}";
        var flash = CallbackUtil.parse(null, Map.of("params", payment), PaymentOrderMessage.class);
        assertThat(flash.getRawMessage()).isEqualTo(payment);
        assertThat(flash.getMessage().getAmountInfo().getActualPay().toString()).isIn("10.10", "10.1");
    }

    @Test
    void keepsBothPublishedShapesOfTheStoreChangeMessage() {
        var text = CallbackUtil.parse(null, Map.of("message", "\"example\""), PoiInfoChangedMessage.class);
        assertThat(text.getMessage().getTextValue()).isEqualTo("example");
        var object = CallbackUtil.parse(null, Map.of("message", Map.of("poiId", 123, "detail", "变更")),
                PoiInfoChangedMessage.class);
        assertThat(object.getMessage().getPoiId()).isEqualTo(123);
        assertThat(object.getMessage().getDetail()).isEqualTo("变更");
    }
}
