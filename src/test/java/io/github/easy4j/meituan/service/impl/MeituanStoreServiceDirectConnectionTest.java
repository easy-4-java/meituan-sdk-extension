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

    private static final String TENANT_ID = "tenant-71";

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

    @Test
    void shouldFailClosedWhenCustomExecutorDoesNotSupportTenantAwareNoAuthCalls() {
        MeituanRequestExecutor legacyExecutor = new MeituanRequestExecutor() {
            @Override
            public <T> MeituanResponse<T> execute(MeituanRequest<T> request, String tenantId) {
                return null;
            }

            @Override
            public <T> MeituanResponse<T> executeWithoutAuth(MeituanRequest<T> request) {
                return null;
            }
        };

        assertThatThrownBy(() -> legacyExecutor.executeWithoutAuth(new UpdatePoiRequest(), TENANT_ID))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessageContaining("Tenant-aware executeWithoutAuth");
    }

    private MeituanTenantConfig tenantConfig(long developerId, String signKey, String appAuthToken) {
        MeituanTenantConfig tenantConfig = new MeituanTenantConfig();
        tenantConfig.setDeveloperId(developerId);
        tenantConfig.setSignKey(signKey);
        tenantConfig.setAppAuthToken(appAuthToken);
        return tenantConfig;
    }
}
