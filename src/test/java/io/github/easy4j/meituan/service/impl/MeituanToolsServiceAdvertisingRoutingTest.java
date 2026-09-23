package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanToolsService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店广告接口按官方 needAuth 元数据选择执行路径的回归测试。
 */
class MeituanToolsServiceAdvertisingRoutingTest {

    private static final String TENANT_ID = "tenant-22";

    @Test
    void shouldRouteEveryBusiness22ApiAccordingToOfficialAuthorizationMetadata() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanToolsService service = new MeituanToolsServiceImpl(requestExecutor);
        List<Method> advertisingMethods = Arrays.stream(MeituanToolsService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 2)
                .filter(method -> isBusiness22Request(method.getParameterTypes()[0]))
                .collect(java.util.stream.Collectors.toList());

        assertThat(advertisingMethods).hasSize(42);
        for (Method method : advertisingMethods) {
            MeituanRequest<?> request = (MeituanRequest<?>) method.getParameterTypes()[0]
                    .getDeclaredConstructor()
                    .newInstance();
            ApiMeta apiMeta = request.getClass().getAnnotation(ApiMeta.class);
            requestExecutor.reset();

            method.invoke(service, request, TENANT_ID);

            assertThat(requestExecutor.getRequest())
                    .as("request for %s", apiMeta.path())
                    .isSameAs(request);
            assertThat(requestExecutor.getTenantId())
                    .as("tenant for %s", apiMeta.path())
                    .isEqualTo(TENANT_ID);
            assertThat(requestExecutor.isAuthorized())
                    .as("needAuth routing for %s", apiMeta.path())
                    .isEqualTo(apiMeta.needAuth());
        }
    }

    private boolean isBusiness22Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 22;
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
