package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanCateringService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店餐饮排队 businessId=49 接口的租户执行路径回归测试。
 */
class MeituanCateringServiceQueueRoutingTest {

    private static final String TENANT_ID = "tenant-49";

    private static final Set<String> BUSINESS_49_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/dcpd/approval/batchAuthorize",
            "/dcpd/queue/query/shop/state",
            "/dcpd/queue/shop/config/tableType/sync",
            "/dcpd/queue/shop/config/tableType/clear",
            "/dcpd/queue/shop/heartbeat/sync",
            "/dcpd/queue/shop/user/bind",
            "/dcpd/queue/shop/config/onlineQueue/update",
            "/dcpd/queue/shop/config/displayWaitTime/update",
            "/dcpd/queue/shop/config/tips/update",
            "/dcpd/queue/order/reset",
            "/dcpd/queue/order/index/sync",
            "/dcpd/queue/order/create/sync",
            "/dcpd/queue/order/status/update",
            "/dcpd/queue/order/create/callback",
            "/dcpd/queue/order/create/batchsync",
            "/dcpd/queue/order/clear",
            "/dcpd/queue/order/query",
            "/dcpd/queue/order/cancel/callback"
    );

    @Test
    void shouldRouteEveryBusiness49ApiAccordingToAuthorizationMetadata() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanCateringService service = new MeituanCateringServiceImpl(requestExecutor);
        List<Method> queueMethods = Arrays.stream(MeituanCateringService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 2)
                .filter(method -> isBusiness49Request(method.getParameterTypes()[0]))
                .collect(java.util.stream.Collectors.toList());

        assertThat(queueMethods).hasSize(18);
        for (Method method : queueMethods) {
            MeituanRequest<?> request = (MeituanRequest<?>) method.getParameterTypes()[0]
                    .getDeclaredConstructor()
                    .newInstance();
            ApiMeta apiMeta = request.getClass().getAnnotation(ApiMeta.class);
            requestExecutor.reset();

            method.invoke(service, request, TENANT_ID);

            assertThat(requestExecutor.getRequest()).as("request for %s", apiMeta.path()).isSameAs(request);
            assertThat(requestExecutor.getTenantId()).as("tenant for %s", apiMeta.path()).isEqualTo(TENANT_ID);
            assertThat(requestExecutor.isAuthorized())
                    .as("authorization for %s", apiMeta.path())
                    .isEqualTo(apiMeta.needAuth());
        }
    }

    private boolean isBusiness49Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && BUSINESS_49_API_PATHS.contains(apiMeta.path());
    }

    private static final class RecordingRequestExecutor implements MeituanRequestExecutor {

        private MeituanRequest<?> request;
        private String tenantId;
        private boolean authorized;

        @Override
        public <T> MeituanResponse<T> execute(MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, true);
            return new MeituanResponse<>();
        }

        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest) {
            record(currentRequest, null, false);
            return new MeituanResponse<>();
        }

        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(
                MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, false);
            return new MeituanResponse<>();
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
    }
}
