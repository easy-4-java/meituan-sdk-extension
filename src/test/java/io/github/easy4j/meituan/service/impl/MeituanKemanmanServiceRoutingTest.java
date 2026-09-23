package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanKemanmanService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店餐饮品牌会员卡 API 租户授权路由测试。
 */
class MeituanKemanmanServiceRoutingTest {

    private static final String TENANT_ID = "tenant-15";

    @Test
    void shouldRouteEveryBusiness15ApiThroughAuthorizedTenantExecution() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanKemanmanService service = new MeituanKemanmanServiceImpl(requestExecutor);
        List<Method> methods = Arrays.stream(MeituanKemanmanService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 2)
                .filter(method -> isBusiness15Request(method.getParameterTypes()[0]))
                .collect(java.util.stream.Collectors.toList());

        assertThat(methods).hasSize(4);
        for (Method method : methods) {
            MeituanRequest<?> request = (MeituanRequest<?>) method.getParameterTypes()[0]
                    .getDeclaredConstructor()
                    .newInstance();
            requestExecutor.reset();

            method.invoke(service, request, TENANT_ID);

            assertThat(requestExecutor.request).isSameAs(request);
            assertThat(requestExecutor.tenantId).isEqualTo(TENANT_ID);
            assertThat(requestExecutor.authorized).isTrue();
        }
    }

    private boolean isBusiness15Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 15;
    }

    private static final class RecordingRequestExecutor implements MeituanRequestExecutor {

        private MeituanRequest<?> request;
        private String tenantId;
        private boolean authorized;

        @Override
        public <T> MeituanResponse<T> execute(MeituanRequest<T> currentRequest, String currentTenantId) {
            request = currentRequest;
            tenantId = currentTenantId;
            authorized = true;
            return new MeituanResponse<>();
        }

        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest) {
            request = currentRequest;
            tenantId = null;
            authorized = false;
            return new MeituanResponse<>();
        }

        private void reset() {
            request = null;
            tenantId = null;
            authorized = false;
        }
    }
}
