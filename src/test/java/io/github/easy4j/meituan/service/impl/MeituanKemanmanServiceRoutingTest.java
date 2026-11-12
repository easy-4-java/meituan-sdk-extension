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

    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-15";


    /**
     * 创建到店餐饮品牌会员卡 API 租户授权路由测试。的空实例。
     */
    MeituanKemanmanServiceRoutingTest() {
    }

    /**
     * 验证当前业务的接口按官方授权要求传递请求和租户信息。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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

    /**
     * 判断请求的官方元数据是否属于当前被检查的业务。
     *
     * @param requestType 官方请求类型
     * @return 判断请求的官方元数据是否属于当前被检查的业务的结果
     */
    private boolean isBusiness15Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 15;
    }

    /**
     * 记录请求、租户、授权方式和响应的测试执行器。
     */
    private static final class RecordingRequestExecutor implements MeituanRequestExecutor {

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
         * 创建RecordingRequestExecutor的空实例。
         */
        private RecordingRequestExecutor() {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> execute(MeituanRequest<T> currentRequest, String currentTenantId) {
            request = currentRequest;
            tenantId = currentTenantId;
            authorized = true;
            return new MeituanResponse<>();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest) {
            request = currentRequest;
            tenantId = null;
            authorized = false;
            return new MeituanResponse<>();
        }

        /**
         * 清空上一次调用记录，避免多次路由断言相互影响。
         */
        private void reset() {
            request = null;
            tenantId = null;
            authorized = false;
        }
    }
}
