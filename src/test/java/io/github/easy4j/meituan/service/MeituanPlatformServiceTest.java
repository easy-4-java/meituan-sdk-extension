package io.github.easy4j.meituan.service;

import com.meituan.sdk.CommonRequest;
import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.auth.MeituanTokenResponse;
import com.meituan.sdk.model.mendianzhilian.test.pageSearch.PageSearchRequest;
import io.github.easy4j.meituan.client.MeituanClientFactory;
import io.github.easy4j.meituan.config.MeituanTenantConfig;
import io.github.easy4j.meituan.exception.MeituanJavaException;
import io.github.easy4j.meituan.tenant.InMemoryMeituanTenantConfigStorage;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class MeituanPlatformServiceTest {

    private final MeituanClientFactory factory = mock(MeituanClientFactory.class);
    private final MeituanTenantConfig tenant = new MeituanTenantConfig();
    private final MeituanPlatformService service = new MeituanPlatformService(factory,
            new InMemoryMeituanTenantConfigStorage(Map.of("shop", tenant)));

    @Test
    void routesTokenExchangeAndRefreshToSelectedDeveloper() throws Exception {
        var client = mock(MeituanClient.class);
        var token = mock(MeituanTokenResponse.class);
        when(factory.create(tenant)).thenReturn(client);
        when(client.getOAuthToken(59, "code")).thenReturn(token);
        when(client.refreshToken(59, "refresh")).thenReturn(token);
        assertThat(service.getOAuthToken(59, "code", "shop")).isSameAs(token);
        assertThat(service.refreshToken(59, "refresh", "shop")).isSameAs(token);
        assertThatThrownBy(() -> service.refreshToken(59, "refresh", "unknown"))
                .isInstanceOf(MeituanJavaException.class);
    }

    @Test
    void isolatesSdkTimeoutsAndForwardsTheRequestedAuthorizationMode() throws Exception {
        var first = mock(MeituanClient.class);
        var second = mock(MeituanClient.class);
        var third = mock(MeituanClient.class);
        var fourth = mock(MeituanClient.class);
        when(factory.create(tenant)).thenReturn(first, second, third, fourth);
        tenant.setAppAuthToken("tenant-token");
        var request = new PageSearchRequest();
        service.executeWithoutAuth(request, "shop", 100, 200);
        service.execute(request, "shop", 300, 400);
        service.execute(request, "shop", "actual-poi");
        var common = new CommonRequest();
        common.setRealOpBizCode("actual-poi");
        common.setReadTimeout(1000);
        service.commonInvokeApi(common, MeituanResponse.class, "shop");
        verify(first).invokeApi(request, 100, 200);
        verify(second).invokeApi(request, "tenant-token", 300, 400);
        verify(third).invokeApi(request, "tenant-token", "actual-poi");
        verify(fourth).commonInvokeApi(common, MeituanResponse.class);
    }
}
