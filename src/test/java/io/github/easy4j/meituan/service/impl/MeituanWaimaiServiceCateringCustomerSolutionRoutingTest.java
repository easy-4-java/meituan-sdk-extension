package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.model.waimaiNg.im.getAutoSendConfigInfo.GetAutoSendConfigInfoRequest;
import com.meituan.sdk.model.waimaiNg.im.getPoiImStatus.GetPoiImStatusRequest;
import com.meituan.sdk.model.waimaiNg.im.msgRead.MsgReadRequest;
import com.meituan.sdk.model.waimaiNg.im.sendImMsgWaimai.SendImMsgWaimaiRequest;
import com.meituan.sdk.model.waimaiNg.im.setAutoSendConfigInfo.SetAutoSendConfigInfoRequest;
import com.meituan.sdk.model.waimaiNg.im.setPoiImStatus.SetPoiImStatusRequest;
import com.meituan.sdk.model.waimaiNg.im.waimaiImGetReadTime.WaimaiImGetReadTimeRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanWaimaiService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 餐饮客户解决方案 IM 接口的授权执行路径回归测试。
 */
class MeituanWaimaiServiceCateringCustomerSolutionRoutingTest {

    private static final String TENANT_ID = "tenant-catering-customer-solution";
    private static final List<Class<? extends MeituanRequest<?>>> REQUEST_TYPES = io.github.easy4j.meituan.TestCollections.listOf(
            SetAutoSendConfigInfoRequest.class,
            MsgReadRequest.class,
            SendImMsgWaimaiRequest.class,
            GetAutoSendConfigInfoRequest.class,
            WaimaiImGetReadTimeRequest.class,
            SetPoiImStatusRequest.class,
            GetPoiImStatusRequest.class
    );

    @Test
    void shouldRouteEveryMappedImApiAccordingToOfficialNeedAuthMetadata() throws Exception {
        RecordingRequestExecutor requestExecutor = new RecordingRequestExecutor();
        MeituanWaimaiService service = new MeituanWaimaiServiceImpl(requestExecutor);

        for (Class<? extends MeituanRequest<?>> requestType : REQUEST_TYPES) {
            Method method = findFacadeMethod(requestType);
            MeituanRequest<?> request = requestType.getDeclaredConstructor().newInstance();
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            requestExecutor.reset();

            Object response = method.invoke(service, request, TENANT_ID);

            assertThat(requestExecutor.getRequest()).as("request for %s", apiMeta.path()).isSameAs(request);
            assertThat(requestExecutor.getTenantId()).as("tenant for %s", apiMeta.path()).isEqualTo(TENANT_ID);
            assertThat(requestExecutor.isAuthorized()).as("authorization for %s", apiMeta.path())
                    .isEqualTo(apiMeta.needAuth());
            assertThat(response).as("response for %s", apiMeta.path()).isSameAs(requestExecutor.getResponse());
        }
    }

    private Method findFacadeMethod(Class<?> requestType) {
        return io.github.easy4j.meituan.TestCollections.listOf(MeituanWaimaiService.class.getDeclaredMethods()).stream()
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
