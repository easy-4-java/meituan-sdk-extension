package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetail.DcSrcollQueryTradeProfitDetailRequest;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetailForOppoiid.DcSrcollQueryTradeProfitDetailForOppoiidRequest;
import com.meituan.sdk.model.solution2.dcpoidinfo.dcPageQueryTokenPoiList.DcPageQueryTokenPoiListRequest;
import com.meituan.sdk.model.solution2.mtcompany.wechatOrderSqtInfoBatchQuery.WechatOrderSqtInfoBatchQueryRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanStoreService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 餐饮客户解决方案 businessId=86 接口的租户授权执行路径回归测试。
 */
class MeituanStoreServiceCateringCustomerSolutionRoutingTest {

    /**
     * 创建餐饮客户解决方案 businessId=86 接口的租户授权执行路径回归测试。的空实例。
     */
    MeituanStoreServiceCateringCustomerSolutionRoutingTest() {
    }


    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-catering-customer-solution";
    /**
     * 需要检查的官方请求类型集合。
     */
    private static final List<Class<? extends MeituanRequest<?>>> REQUEST_TYPES = io.github.easy4j.meituan.TestCollections.listOf(
            DcSrcollQueryTradeProfitDetailRequest.class,
            DcSrcollQueryTradeProfitDetailForOppoiidRequest.class,
            WechatOrderSqtInfoBatchQueryRequest.class,
            DcPageQueryTokenPoiListRequest.class
    );

    /**
     * 验证当前业务的接口按官方授权要求传递请求和租户信息。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldRouteEveryMappedBusiness86ApiThroughAuthorizedExecutor() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanStoreService service = new MeituanStoreServiceImpl(requestExecutor);

        for (Class<? extends MeituanRequest<?>> requestType : REQUEST_TYPES) {
            Method method = findFacadeMethod(requestType);
            MeituanRequest<?> request = requestType.getDeclaredConstructor().newInstance();
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            requestExecutor.reset();

            Object response = method.invoke(service, request, TENANT_ID);

            assertThat(apiMeta.businessId()).as("businessId for %s", apiMeta.path()).isEqualTo(86);
            assertThat(apiMeta.needAuth()).as("needAuth for %s", apiMeta.path()).isTrue();
            assertThat(requestExecutor.getRequest()).as("request for %s", apiMeta.path()).isSameAs(request);
            assertThat(requestExecutor.getTenantId()).as("tenant for %s", apiMeta.path()).isEqualTo(TENANT_ID);
            assertThat(requestExecutor.isAuthorized()).as("authorization for %s", apiMeta.path()).isTrue();
            assertThat(response).as("response for %s", apiMeta.path()).isSameAs(requestExecutor.getResponse());
        }
    }

    /**
     * 查找接收指定官方请求类型的业务门面方法。
     *
     * @param requestType 官方请求类型
     * @return 查找接收指定官方请求类型的业务门面方法的结果
     */
    private Method findFacadeMethod(Class<?> requestType) {
        return io.github.easy4j.meituan.TestCollections.listOf(MeituanStoreService.class.getDeclaredMethods()).stream()
                .filter(method -> method.getParameterCount() == 2)
                .filter(method -> method.getParameterTypes()[0].equals(requestType))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("缺少接口封装: " + requestType.getName()));
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
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest, String currentTenantId) {
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
