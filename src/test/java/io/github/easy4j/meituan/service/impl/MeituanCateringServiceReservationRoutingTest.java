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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店餐饮预订接口按官方授权元数据选择执行路径的回归测试。
 */
class MeituanCateringServiceReservationRoutingTest {

    private static final String TENANT_ID = "tenant-7";

    @Test
    void shouldRouteEveryReservationApiThroughTenantAuthorization() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanCateringService service = new MeituanCateringServiceImpl(requestExecutor);
        List<Method> reservationMethods = Arrays.stream(MeituanCateringService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 2)
                .filter(method -> isReservationRequest(method.getParameterTypes()[0]))
                .collect(java.util.stream.Collectors.toList());

        assertThat(reservationMethods).hasSize(21);
        for (Method method : reservationMethods) {
            MeituanRequest<?> request = (MeituanRequest<?>) method.getParameterTypes()[0]
                    .getDeclaredConstructor()
                    .newInstance();
            ApiMeta apiMeta = request.getClass().getAnnotation(ApiMeta.class);
            requestExecutor.reset();

            method.invoke(service, request, TENANT_ID);

            assertThat(apiMeta.businessId()).as("businessId for %s", apiMeta.path()).isEqualTo(7);
            assertThat(apiMeta.needAuth()).as("needAuth for %s", apiMeta.path()).isTrue();
            assertThat(requestExecutor.getRequest())
                    .as("request for %s", apiMeta.path())
                    .isSameAs(request);
            assertThat(requestExecutor.getTenantId())
                    .as("tenant for %s", apiMeta.path())
                    .isEqualTo(TENANT_ID);
            assertThat(requestExecutor.isAuthorized())
                    .as("authorization routing for %s", apiMeta.path())
                    .isTrue();
        }
    }

    private boolean isReservationRequest(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta)
                && apiMeta.businessId() == 7
                && requestType.getPackage().getName().startsWith("com.meituan.sdk.model.resv2.");
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
