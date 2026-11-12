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

    /**
     * 创建到店广告接口按官方 needAuth 元数据选择执行路径的回归测试。的空实例。
     */
    MeituanToolsServiceAdvertisingRoutingTest() {
    }


    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-22";

    /**
     * 验证当前业务的接口按官方授权要求传递请求和租户信息。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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

    /**
     * 判断请求的官方元数据是否属于当前被检查的业务。
     *
     * @param requestType 官方请求类型
     * @return 判断请求的官方元数据是否属于当前被检查的业务的结果
     */
    private boolean isBusiness22Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 22;
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
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest, String currentTenantId) {
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
