package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.model.freetry.*;
import io.github.easy4j.meituan.service.MeituanFreetryService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * 大众点评免费试 API 租户授权调用路径测试。
 */
class MeituanFreetryServiceTest {

    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-55";


    /**
     * 创建大众点评免费试 API 租户授权调用路径测试。的空实例。
     */
    MeituanFreetryServiceTest() {
    }

    /**
     * 验证当前业务的接口按官方授权要求传递请求和租户信息。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldExecuteAllBusiness55ApisWithTenantAuthorization() throws Exception {
        MeituanRequestExecutor requestExecutor = mock(MeituanRequestExecutor.class);
        MeituanFreetryService service = new MeituanFreetryServiceImpl(requestExecutor);
        FreetryLoadActivityRestrictionRequest restrictionRequest = new FreetryLoadActivityRestrictionRequest();
        FreetryLoadCouponRequest loadRequest = new FreetryLoadCouponRequest();
        FreetryQueryPoiCouponRequest queryRequest = new FreetryQueryPoiCouponRequest();
        FreetryVerifyCouponRequest verifyRequest = new FreetryVerifyCouponRequest();
        FreetryQueryActivitiesByPoiRequest activitiesRequest = new FreetryQueryActivitiesByPoiRequest();
        FreetryPrepareVerifyRequest prepareRequest = new FreetryPrepareVerifyRequest();

        service.loadActivityRestriction(restrictionRequest, TENANT_ID);
        service.loadCoupon(loadRequest, TENANT_ID);
        service.queryPoiCoupon(queryRequest, TENANT_ID);
        service.verifyCoupon(verifyRequest, TENANT_ID);
        service.queryActivitiesByPoi(activitiesRequest, TENANT_ID);
        service.prepareVerify(prepareRequest, TENANT_ID);

        verify(requestExecutor).execute(same(restrictionRequest), same(TENANT_ID));
        verify(requestExecutor).execute(same(loadRequest), same(TENANT_ID));
        verify(requestExecutor).execute(same(queryRequest), same(TENANT_ID));
        verify(requestExecutor).execute(same(verifyRequest), same(TENANT_ID));
        verify(requestExecutor).execute(same(activitiesRequest), same(TENANT_ID));
        verify(requestExecutor).execute(same(prepareRequest), same(TENANT_ID));
    }

    /**
     * 验证现有自定义免费试门面实现保持源码兼容。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldKeepExistingCustomFacadeImplementationsSourceCompatible() throws Exception {
        MeituanRequestExecutor requestExecutor = mock(MeituanRequestExecutor.class);
        MeituanFreetryService customService = new MeituanFreetryService() {
            /**
             * {@inheritDoc}
             */
            @Override
            public <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId) {
                return requestExecutor.execute(request, tenantId);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request) {
                return requestExecutor.executeWithoutAuth(request);
            }
        };
        FreetryPrepareVerifyRequest request = new FreetryPrepareVerifyRequest();

        customService.prepareVerify(request, TENANT_ID);

        verify(requestExecutor).execute(same(request), same(TENANT_ID));
    }
}
