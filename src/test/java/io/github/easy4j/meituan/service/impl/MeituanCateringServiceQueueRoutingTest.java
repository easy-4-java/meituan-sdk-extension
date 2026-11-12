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

    /**
     * 创建到店餐饮排队 businessId=49 接口的租户执行路径回归测试。的空实例。
     */
    MeituanCateringServiceQueueRoutingTest() {
    }


    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-49";

    /**
     * 排队业务的官方接口路径。
     */
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

    /**
     * 验证当前业务的接口按官方授权要求传递请求和租户信息。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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

    /**
     * 判断请求的官方元数据是否属于当前被检查的业务。
     *
     * @param requestType 官方请求类型
     * @return 判断请求的官方元数据是否属于当前被检查的业务的结果
     */
    private boolean isBusiness49Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && BUSINESS_49_API_PATHS.contains(apiMeta.path());
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
