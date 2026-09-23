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

    private static final String TENANT_ID = "tenant-catering-customer-solution";
    private static final List<Class<? extends MeituanRequest<?>>> REQUEST_TYPES = io.github.easy4j.meituan.TestCollections.listOf(
            DcSrcollQueryTradeProfitDetailRequest.class,
            DcSrcollQueryTradeProfitDetailForOppoiidRequest.class,
            WechatOrderSqtInfoBatchQueryRequest.class,
            DcPageQueryTokenPoiListRequest.class
    );

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

    private Method findFacadeMethod(Class<?> requestType) {
        return io.github.easy4j.meituan.TestCollections.listOf(MeituanStoreService.class.getDeclaredMethods()).stream()
                .filter(method -> method.getParameterCount() == 2)
                .filter(method -> method.getParameterTypes()[0].equals(requestType))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("缺少接口封装: " + requestType.getName()));
    }

    private static final class RecordingRequestExecutor implements MeituanRequestExecutor {

        private MeituanRequest<?> request;
        private String tenantId;
        private boolean authorized;
        private MeituanResponse<?> response;

        @Override
        public <T> MeituanResponse<T> execute(MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, true);
            return createResponse();
        }

        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> currentRequest) {
            record(currentRequest, null, false);
            return createResponse();
        }

        @Override
        public <T> MeituanResponse<T> executeWithoutAuth(
                MeituanRequest<T> currentRequest, String currentTenantId) {
            record(currentRequest, currentTenantId, false);
            return createResponse();
        }

        private <T> MeituanResponse<T> createResponse() {
            MeituanResponse<T> currentResponse = new MeituanResponse<>();
            this.response = currentResponse;
            return currentResponse;
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
            this.response = null;
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

        private MeituanResponse<?> getResponse() {
            return response;
        }
    }
}
