package io.github.easy4j.meituan.callback;

import io.github.easy4j.meituan.callback.business15.model.CoBrandedNewUserQueryMessage;
import io.github.easy4j.meituan.callback.business18.model.MemberCouponRedemptionMessage;
import io.github.easy4j.meituan.callback.business18.model.MemberOperationResult;
import io.github.easy4j.meituan.callback.business18.model.MemberOrderAvailableCouponsMessage;
import io.github.easy4j.meituan.callback.business3.model.PaymentOrderMessage;
import io.github.easy4j.meituan.callback.business58.model.InventoryQueryResponse;
import io.github.easy4j.meituan.callback.business87.model.InvoiceStatusQueryResult;
import io.github.easy4j.meituan.callback.business18.model.ReverseOrderMessage;
import io.github.easy4j.meituan.callback.business59.model.MemberCreatedMessage;
import io.github.easy4j.meituan.callback.business59.model.MemberCreatedResult;
import io.github.easy4j.meituan.callback.business59.model.MerchantCouponIssueResult;
import io.github.easy4j.meituan.callback.business7.model.ReservationOrderDecision;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CallbackDispatchTest {
    private final JsonMapper mapper = JsonMapper.shared();

    @Test
    void dispatchesByBothIdentifiersAndPreservesSignedText() throws Exception {
        String raw = " {\"name\":\"张三 + A\"} ";
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/json");
        when(request.getQueryString()).thenReturn("business_id=59&msg_type=5910019");
        when(request.getReader()).thenReturn(new BufferedReader(new StringReader(
                mapper.writeValueAsString(Map.of("message", raw)))));
        var known = CallbackUtil.parse(request);
        assertThat(known.getMessage()).isInstanceOfSatisfying(MemberCreatedMessage.class,
                member -> assertThat(member.getName()).isEqualTo("张三 + A"));
        assertThat(known.getParameters()).containsEntry("message", raw);
        verify(request).getReader();
        var unknown = CallbackUtil.parse("businessId=18&msgType=5910019", Map.of("message", raw));
        assertThat(unknown.getMessage()).isEqualTo(raw);
        assertThat(unknown.getRawMessage()).isEqualTo(raw);
        assertThat(CallbackUtil.parse("businessId=15&invokeType=15101", Map.of("param", "{}")).getMessage())
                .isInstanceOf(CoBrandedNewUserQueryMessage.class);
        assertThatThrownBy(() -> CallbackUtil.parse("businessId=59&msgType=5910019", Map.of("message", "{")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void dispatchesLegacyFormWithoutConsumingTheBodyOrLosingSignedParameters() throws Exception {
        var request = mock(HttpServletRequest.class);
        when(request.getContentType()).thenReturn("application/x-www-form-urlencoded;charset=UTF-8");
        when(request.getParameterMap()).thenReturn(Map.of("businessId", new String[]{"3"},
                "msgType", new String[]{"310001"}, "params", new String[]{" {} "}));
        var callback = CallbackUtil.parse(request);
        assertThat(callback.getMessage()).isInstanceOf(PaymentOrderMessage.class);
        assertThat(callback.getRawMessage()).isEqualTo(" {} ");
        verify(request, never()).getReader();

        var unknown = CallbackUtil.parse("businessId=18", Map.of("orderNo", "0007"));
        assertThat(unknown.getMessage()).isNull();
        assertThat(unknown.getParameters()).containsEntry("orderNo", "0007");
    }

    @Test
    void bindsDifferentCouponOrderContractsAndNestedRefundItems() {
        var available = CallbackUtil.parse(null, Map.of("message",
                Map.of("orderInfo", Map.of("orderNo", "o", "skus", new Object[]{Map.of("skuId", 42, "count", "0.5")}))),
                MemberOrderAvailableCouponsMessage.class).getMessage();
        assertThat(available.getOrderInfo().getSkus().get(0).getCount()).isEqualTo("0.5");
        var redemption = CallbackUtil.parse(null, Map.of("message",
                Map.of("bizId", "b", "orderInfo", Map.of("localId", "o", "skus", new Object[]{Map.of("skuId", "0012", "count", 2)}))),
                MemberCouponRedemptionMessage.class).getMessage();
        assertThat(redemption.getOrderInfo().getSkus().get(0).getSkuId()).isEqualTo("0012");
        var refund = CallbackUtil.parse(null, Map.of("message", Map.of(
                "refundItemList", new Object[]{Map.of("weight", 0.75)},
                "refundOrderServiceFeeVOS", new Object[]{Map.of("serviceFeeId", 4294967296L)})),
                ReverseOrderMessage.class).getMessage();
        assertThat(refund.getRefundItemList().get(0).getWeight()).isEqualTo(0.75);
        assertThat(refund.getRefundOrderServiceFeeVOS().get(0).getServiceFeeId()).isEqualTo(4294967296L);
    }

    @Test
    void preservesNestedInvoiceItemsAndFilesAndSerializesListsAsJsonArrays() {
        String json = """
                {"applyId":"01","invoices":[{"invoiceDate":"2026-11-12","invoiceItems":[{"itemName":"餐费","taxAmount":"3.00"}],
                "fileInfos":[{"fileType":"PDF","fileUrl":"https://example.org/invoice.pdf"}]}]}
                """;
        var result = mapper.readValue(json, InvoiceStatusQueryResult.class);
        assertThat(result.getInvoices().get(0).getInvoiceItems().get(0).getTaxAmount()).isEqualTo("3.00");
        var encoded = MeituanCallbackResponse.successData(List.of(result)).getData();
        assertThat(mapper.readTree(encoded).get(0)).isEqualTo(mapper.readTree(json));
    }

    @Test
    void preservesDistinctObjectAndStringResponseContracts() {
        var result = new MemberOperationResult();
        result.setResult(true);
        var pos = new MeituanObjectCallbackResponse<>(0, "ok", result);
        assertThat(mapper.readTree(mapper.writeValueAsString(pos))).isEqualTo(mapper.readTree("""
                {"code":0,"message":"ok","data":{"result":true}}
                """));
        var inventory = new InventoryQueryResponse("OP_SUCCESS", "success", "[]");
        assertThat(mapper.readTree(mapper.writeValueAsString(inventory))).isEqualTo(mapper.readTree("""
                {"code":"OP_SUCCESS","msg":"success","data":"[]"}
                """));
    }

    @Test
    void serializesBusinessDataOnceAndKeepsLegacyAcknowledgementShape() {
        var member = new MemberCreatedResult();
        member.setNewMember(true);
        member.setMemberLevel("01");
        var reservation = new ReservationOrderDecision();
        reservation.setResult(2);
        reservation.setRejectReason(5);
        var coupon = mapper.readValue("""
                {"receiptInfoList":[{"receiptCode":"001","receiptCodePic":"https://example.org/qr"}],"businessCode":200}
                """, MerchantCouponIssueResult.class);
        for (Object data : new Object[]{member, reservation, coupon}) {
            var envelope = mapper.readTree(mapper.writeValueAsString(MeituanCallbackResponse.successData(data)));
            assertThat(envelope.get("data").isString()).isTrue();
            assertThat(mapper.readTree(envelope.get("data").asString())).isEqualTo(mapper.valueToTree(data));
        }
        assertThat(coupon.getReceiptInfoList().get(0).getReceiptCode()).isEqualTo("001");
        assertThat(MeituanCallbackResponse.successData(null).getData()).isNull();
        assertThat(mapper.writeValueAsString(MeituanCallbackResponse.flashOrderSuccess())).isEqualTo("{\"data\":\"ok\"}");
    }
}
