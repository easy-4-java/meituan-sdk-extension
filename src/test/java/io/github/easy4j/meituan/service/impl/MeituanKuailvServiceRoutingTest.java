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

    /**
     * 创建\u5feb\u9a74 businessId=27 \u63a5\u53e3\u7684\u79df\u6237\u6388\u6743\u6267\u884c\u8def\u5f84\u56de\u5f52\u6d4b\u8bd5\u3002的空实例。
     */
    MeituanKuailvServiceRoutingTest() {
    }


    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-27";
    /**
     * 快驴业务的官方接口路径。
     */
    private static final Set<String> BUSINESS_27_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/kl/open/order/create",
            "/kl/open/order/create/sync",
            "/kl/open/order/detail",
            "/kl/open/order/cancel",
            "/kl/open/goods/page/spu",
            "/kl/open/goods/page/sku",
            "/kl/open/goods/sku/sales"
    );

    /**
     * 验证当前业务的接口按官方授权要求传递请求和租户信息。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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

    /**
     * 判断请求的官方元数据是否属于当前被检查的业务。
     *
     * @param requestType 官方请求类型
     * @return 判断请求的官方元数据是否属于当前被检查的业务的结果
     */
    private boolean isBusiness27Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 27;
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
         * 预设或实际接收到的接口响应。
         */
        private MeituanResponse<?> response;

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> execute(MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, true);
            return createResponse();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest) {
            record(currentRequest, null, false);
            return createResponse();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(
                MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, false);
            return createResponse();
        }

        /**
         * 创建可由记录型执行器返回的官方响应对象。
         *
         * @param <T> 业务消息类型
         * @return 创建可由记录型执行器返回的官方响应对象的结果
         */
        private <T> MeituanResponse<T> createResponse() {
            MeituanResponse<T> currentResponse = new MeituanResponse<>();
            this.response = currentResponse;
            return currentResponse;
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
            this.response = null;
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

        /**
         * 读取预设或实际接收到的接口响应。
         *
         * @return 读取预设或实际接收到的接口响应的结果
         */
        private MeituanResponse<?> getResponse() {
            return response;
        }
    }
}
