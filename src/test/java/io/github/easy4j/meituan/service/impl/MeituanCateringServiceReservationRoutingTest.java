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

    /**
     * 创建\u5230\u5e97\u9910\u996e\u9884\u8ba2\u63a5\u53e3\u6309\u5b98\u65b9\u6388\u6743\u5143\u6570\u636e\u9009\u62e9\u6267\u884c\u8def\u5f84\u7684\u56de\u5f52\u6d4b\u8bd5\u3002的空实例。
     */
    MeituanCateringServiceReservationRoutingTest() {
    }


    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-7";

    /**
     * 验证当前业务的接口按官方授权要求传递请求和租户信息。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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

    /**
     * 判断reservationRequest。
     *
     * @param requestType 官方请求类型
     * @return 判断reservationRequest的结果
     */
    private boolean isReservationRequest(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta)
                && apiMeta.businessId() == 7
                && requestType.getPackage().getName().startsWith("com.meituan.sdk.model.resv2.");
    }

    /**
     * 记录请求、租户、授权方式和响应的测试执行器。
     */
    private static final class RecordingRequestExecutor implements MeituanRequestExecutor {

        /**
         * 创建RecordingRequestExecutor的空实例。
         */
        private RecordingRequestExecutor() {
        }


        /**
         * 官方 SDK 请求对象。
         */
        private MeituanRequest<?> request;
        /**
         * 选择开发者凭据与授权信息的租户标识。
         */
        private String tenantId;
        /**
         * 记录本次调用是否使用授权入口。
         */
        private boolean authorized;

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> execute(MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, true);
            return new MeituanResponse<>();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest) {
            record(currentRequest, null, false);
            return new MeituanResponse<>();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(
                MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, false);
            return new MeituanResponse<>();
        }

        /**
         * 保存当前请求、租户及授权入口，供路由断言读取。
         *
         * @param currentRequest 本次调用接收到的官方请求
         * @param currentTenantId 本次调用接收到的租户标识
         * @param currentAuthorized 本次调用是否携带租户授权
         */
        private void record(MeituanRequest<?> currentRequest, String currentTenantId, boolean currentAuthorized) {
            this.request = currentRequest;
            this.tenantId = currentTenantId;
            this.authorized = currentAuthorized;
        }

        /**
         * 清空上一次调用记录，避免多次路由断言相互影响。
         */
        private void reset() {
            this.request = null;
            this.tenantId = null;
            this.authorized = false;
        }

        /**
         * 读取官方 SDK 请求对象。
         *
         * @return 读取官方 SDK 请求对象的结果
         */
        private MeituanRequest<?> getRequest() {
            return request;
        }

        /**
         * 读取选择开发者凭据与授权信息的租户标识。
         *
         * @return 读取选择开发者凭据与授权信息的租户标识的结果
         */
        private String getTenantId() {
            return tenantId;
        }

        /**
         * 判断记录本次调用是否使用授权入口。
         *
         * @return 判断记录本次调用是否使用授权入口的结果
         */
        private boolean isAuthorized() {
            return authorized;
        }
    }
}
