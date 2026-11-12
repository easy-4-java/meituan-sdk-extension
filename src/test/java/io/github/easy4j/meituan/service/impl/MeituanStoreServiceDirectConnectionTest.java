package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.mendianzhilian.test.bind.BindRequest;
import com.meituan.sdk.model.mendianzhilian.test.createPoi.CreatePoiRequest;
import com.meituan.sdk.model.mendianzhilian.test.search.SearchRequest;
import com.meituan.sdk.model.mendianzhilian.test.updatePoi.UpdatePoiRequest;
import io.github.easy4j.meituan.client.DefaultMeituanRequestExecutor;
import io.github.easy4j.meituan.client.MeituanClientFactory;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.config.MeituanTenantConfig;
import io.github.easy4j.meituan.service.MeituanStoreService;
import io.github.easy4j.meituan.tenant.InMemoryMeituanTenantConfigStorage;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 门店建店直连 API 的免 appAuthToken 调用路径测试。
 */
class MeituanStoreServiceDirectConnectionTest {

    /**
     * 创建\u95e8\u5e97\u5efa\u5e97\u76f4\u8fde API \u7684\u514d appAuthToken \u8c03\u7528\u8def\u5f84\u6d4b\u8bd5\u3002的空实例。
     */
    MeituanStoreServiceDirectConnectionTest() {
    }


    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-71";

    /**
     * 验证门店直连接口使用所选租户凭据且不携带授权 token。
     */
    @Test
    void shouldExecuteAllBusiness71ApisWithoutAppAuthTokenForSelectedTenant() {
        MeituanRequestExecutor requestExecutor = mock(MeituanRequestExecutor.class);
        MeituanStoreService service = new MeituanStoreServiceImpl(requestExecutor);
        UpdatePoiRequest updateRequest = new UpdatePoiRequest();
        BindRequest bindRequest = new BindRequest();
        CreatePoiRequest createRequest = new CreatePoiRequest();
        SearchRequest searchRequest = new SearchRequest();

        service.updatePoi(updateRequest, TENANT_ID);
        service.bind(bindRequest, TENANT_ID);
        service.createPoi(createRequest, TENANT_ID);
        service.search(searchRequest, TENANT_ID);

        verify(requestExecutor).executeWithoutAuth(same(updateRequest), same(TENANT_ID));
        verify(requestExecutor).executeWithoutAuth(same(bindRequest), same(TENANT_ID));
        verify(requestExecutor).executeWithoutAuth(same(createRequest), same(TENANT_ID));
        verify(requestExecutor).executeWithoutAuth(same(searchRequest), same(TENANT_ID));
    }

    /**
     * 验证免授权调用按租户选择客户端。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldSelectTenantClientAndInvokeOfficialApiWithoutAppAuthToken() throws Exception {
        MeituanClientFactory clientFactory = mock(MeituanClientFactory.class);
        MeituanClient meituanClient = mock(MeituanClient.class);
        MeituanTenantConfig tenantConfig = new MeituanTenantConfig();
        tenantConfig.setDeveloperId(119358L);
        tenantConfig.setSignKey("sign-key");
        tenantConfig.setAppAuthToken("must-not-be-used");
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(
                Collections.singletonMap(TENANT_ID, tenantConfig)
        );
        MeituanStoreService service = new MeituanStoreServiceImpl(
                new DefaultMeituanRequestExecutor(clientFactory, storage)
        );
        UpdatePoiRequest request = new UpdatePoiRequest();
        MeituanResponse<Long> expectedResponse = new MeituanResponse<>();
        expectedResponse.setCode("OP_SUCCESS");

        when(clientFactory.create(tenantConfig)).thenReturn(meituanClient);
        when(meituanClient.invokeApi(request)).thenReturn(expectedResponse);

        MeituanResponse<?> response = service.updatePoi(request, TENANT_ID);

        assertThat(response).isSameAs(expectedResponse);
        verify(clientFactory).create(tenantConfig);
        verify(meituanClient).invokeApi(request);
        verify(meituanClient, never()).invokeApi(request, tenantConfig.getAppAuthToken());
    }

    /**
     * 验证不同租户的免授权请求使用各自客户端。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldRouteNoAuthCallsToDifferentTenantClients() throws Exception {
        String otherTenantId = "tenant-71-b";
        MeituanClientFactory clientFactory = mock(MeituanClientFactory.class);
        MeituanClient firstClient = mock(MeituanClient.class);
        MeituanClient secondClient = mock(MeituanClient.class);
        MeituanTenantConfig firstConfig = tenantConfig(119358L, "first-sign-key", "first-token");
        MeituanTenantConfig secondConfig = tenantConfig(219358L, "second-sign-key", "second-token");
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(
                io.github.easy4j.meituan.TestCollections.mapOf(TENANT_ID, firstConfig, otherTenantId, secondConfig)
        );
        MeituanStoreService service = new MeituanStoreServiceImpl(
                new DefaultMeituanRequestExecutor(clientFactory, storage)
        );
        UpdatePoiRequest firstRequest = new UpdatePoiRequest();
        SearchRequest secondRequest = new SearchRequest();

        when(clientFactory.create(firstConfig)).thenReturn(firstClient);
        when(clientFactory.create(secondConfig)).thenReturn(secondClient);

        service.updatePoi(firstRequest, TENANT_ID);
        service.search(secondRequest, otherTenantId);

        verify(firstClient).invokeApi(firstRequest);
        verify(secondClient).invokeApi(secondRequest);
        verify(firstClient, never()).invokeApi(firstRequest, firstConfig.getAppAuthToken());
        verify(secondClient, never()).invokeApi(secondRequest, secondConfig.getAppAuthToken());
    }

    /**
     * 验证自定义执行器缺少租户感知免授权入口时明确失败。
     */
    @Test
    void shouldFailClosedWhenCustomExecutorDoesNotSupportTenantAwareNoAuthCalls() {
        MeituanRequestExecutor legacyExecutor = new MeituanRequestExecutor() {
            /**
             * {@inheritDoc}
             */
            @Override
            public <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId) {
                return null;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request) {
                return null;
            }
        };

        assertThatThrownBy(() -> legacyExecutor.executeWithoutAuth(new UpdatePoiRequest(), TENANT_ID))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessageContaining("Tenant-aware executeWithoutAuth");
    }

    /**
     * 创建包含指定开发者凭据与授权 token 的租户配置。
     *
     * @param developerId 美团开发者编号
     * @param signKey 开发者签名密钥
     * @param appAuthToken 租户的应用授权 token
     * @return 创建包含指定开发者凭据与授权 token 的租户配置的结果
     */
    private MeituanTenantConfig tenantConfig(long developerId, String signKey, String appAuthToken) {
        MeituanTenantConfig tenantConfig = new MeituanTenantConfig();
        tenantConfig.setDeveloperId(developerId);
        tenantConfig.setSignKey(signKey);
        tenantConfig.setAppAuthToken(appAuthToken);
        return tenantConfig;
    }
}
