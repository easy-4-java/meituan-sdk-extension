package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanDeliveryService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 团购配送 businessId=46 接口的租户授权执行路径回归测试。
 */
class MeituanDeliveryServiceGroupDeliveryRoutingTest {

    private static final String TENANT_ID = "tenant-46";
    private static final Set<String> BUSINESS_46_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/dcps/fulfill/poi/getPoiInfo",
            "/dcps/fulfill/poi/deliveryRule/create",
            "/dcps/fulfill/poi/deliveryRule/base/update",
            "/dcps/fulfill/poi/deliveryRule/feeDiscount/update",
            "/dcps/fulfill/poi/deliveryRule/reservation/update",
            "/dcps/fulfill/poi/deliveryRule/range/update",
            "/dcps/fulfill/poi/deliveryRule/change/query",
            "/dcps/fulfill/poi/deliveryRule/query",
            "/dcps/fulfill/reject/refund",
            "/dcps/fulfill/meal/call/rider",
            "/dcps/fulfill/agree/refund",
            "/dcps/fulfill/cancel/order",
            "/dcps/fulfill/reject/receive/order",
            "/dcps/fulfill/delivery/finish",
            "/dcps/fulfill/self/delivery",
            "/dcps/fulfill/order/detail",
            "/dcps/fulfill/order/logs",
            "/dcps/fulfill/receive/order",
            "/dcps/fulfill/poi/deal/query",
            "/dcps/fulfill/poi/deliveryRule/type/update",
            "/dcps/fulfill/poi/biz/deliveryRule/fee/update",
            "/dcps/fulfill/poi/biz/deliveryRule/range/update",
            "/dcps/fulfill/fill/tracking/number",
            "/dcps/fulfill/delivery/change/status",
            "/dcps/print/printer/status/update",
            "/dcps/settlement/querySettleResultForTGDeliver"
    );

    @Test
    void shouldRouteEveryBusiness46ApiThroughAuthorizedExecutor() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanDeliveryService service = new MeituanDeliveryServiceImpl(requestExecutor);
        List<Method> methods = Arrays.stream(MeituanDeliveryService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() > 0)
                .filter(method -> isBusiness46Request(method.getParameterTypes()[0]))
                .collect(java.util.stream.Collectors.toList());

        assertThat(methods).hasSize(26);
        assertThat(methods).allSatisfy(method -> {
            assertThat(method.getParameterTypes()).as("signature for %s", method.getName()).hasSize(2);
            assertThat(method.getParameterTypes()[1]).as("tenant parameter for %s", method.getName())
                    .isEqualTo(String.class);
        });
        assertThat(methods)
                .extracting(method -> method.getParameterTypes()[0].getAnnotation(ApiMeta.class).path())
                .containsExactlyInAnyOrderElementsOf(BUSINESS_46_API_PATHS);
        for (Method method : methods) {
            MeituanRequest<?> request = (MeituanRequest<?>) method.getParameterTypes()[0]
                    .getDeclaredConstructor()
                    .newInstance();
            requestExecutor.reset();

            Object response = method.invoke(service, request, TENANT_ID);

            assertThat(requestExecutor.getRequest()).as("request for %s", method.getName()).isSameAs(request);
            assertThat(requestExecutor.getTenantId()).as("tenant for %s", method.getName()).isEqualTo(TENANT_ID);
            assertThat(requestExecutor.isAuthorized()).as("authorization for %s", method.getName()).isTrue();
            assertThat(response).as("response for %s", method.getName()).isSameAs(requestExecutor.getResponse());
        }
    }

    private boolean isBusiness46Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 46;
    }

    private static final class RecordingRequestExecutor implements MeituanRequestExecutor {

        private MeituanRequest<?> request;
        private String tenantId;
        private boolean authorized;
        private MeituanResponse<?> response;

        @Override
        public <T> MeituanResponse<T> execute(MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, true);
            return createResponse();
        }

        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest) {
            record(currentRequest, null, false);
            return createResponse();
        }

        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(
                MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, false);
            return createResponse();
        }

        private <T> MeituanResponse<T> createResponse() {
            MeituanResponse<T> currentResponse = new MeituanResponse<>();
            this.response = currentResponse;
            return currentResponse;
        }

        private void record(MeituanRequest<?> currentRequest, String currentTenantId, boolean currentAuthorized) {
            this.request = currentRequest;
            this.tenantId = currentTenantId;
            this.authorized = currentAuthorized;
        }

        private void reset() {
            this.request = null;
            this.tenantId = null;
            this.authorized = false;
            this.response = null;
        }

        private MeituanRequest<?> getRequest() {
            return request;
        }

        private String getTenantId() {
            return tenantId;
        }

        private boolean isAuthorized() {
            return authorized;
        }

        private MeituanResponse<?> getResponse() {
            return response;
        }
    }
}
