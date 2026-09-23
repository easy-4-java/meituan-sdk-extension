package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanKuailvService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 快驴 businessId=27 接口的租户授权执行路径回归测试。
 */
class MeituanKuailvServiceRoutingTest {

    private static final String TENANT_ID = "tenant-27";
    private static final Set<String> BUSINESS_27_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/kl/open/order/create",
            "/kl/open/order/create/sync",
            "/kl/open/order/detail",
            "/kl/open/order/cancel",
            "/kl/open/goods/page/spu",
            "/kl/open/goods/page/sku",
            "/kl/open/goods/sku/sales"
    );

    @Test
    void shouldRouteEveryBusiness27ApiThroughAuthorizedExecutor() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanKuailvService service = new MeituanKuailvServiceImpl(requestExecutor);
        List<Method> methods = Arrays.stream(MeituanKuailvService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 2)
                .filter(method -> isBusiness27Request(method.getParameterTypes()[0]))
                .collect(java.util.stream.Collectors.toList());

        assertThat(methods).hasSize(7);
        assertThat(methods)
                .extracting(method -> method.getParameterTypes()[0].getAnnotation(ApiMeta.class).path())
                .containsExactlyInAnyOrderElementsOf(BUSINESS_27_API_PATHS);
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

    private boolean isBusiness27Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 27;
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
