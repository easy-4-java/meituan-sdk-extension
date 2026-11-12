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

/**
 * 验证Meituan Platform Service的行为与接口契约。
 */
class MeituanPlatformServiceTest {

    /**
     * 创建MeituanPlatformServiceTest的空实例。
     */
    MeituanPlatformServiceTest() {
    }


    /**
     * 创建测试客户端的工厂。
     */
    private final MeituanClientFactory factory = mock(MeituanClientFactory.class);
    /**
     * 测试使用的租户配置。
     */
    private final MeituanTenantConfig tenant = new MeituanTenantConfig();
    /**
     * 被验证的业务服务。
     */
    private final MeituanPlatformService service = new MeituanPlatformService(factory,
            new InMemoryMeituanTenantConfigStorage(io.github.easy4j.meituan.TestCollections.mapOf("shop", tenant)));

    /**
     * 验证授权码换取与刷新 token 使用所选开发者客户端。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void routesTokenExchangeAndRefreshToSelectedDeveloper() throws Exception {
        MeituanClient client = mock(MeituanClient.class);
        MeituanTokenResponse token = mock(MeituanTokenResponse.class);
        when(factory.create(tenant)).thenReturn(client);
        when(client.getOAuthToken(59, "code")).thenReturn(token);
        when(client.refreshToken(59, "refresh")).thenReturn(token);
        assertThat(service.getOAuthToken(59, "code", "shop")).isSameAs(token);
        assertThat(service.refreshToken(59, "refresh", "shop")).isSameAs(token);
        assertThatThrownBy(() -> service.refreshToken(59, "refresh", "unknown"))
                .isInstanceOf(MeituanJavaException.class);
    }

    /**
     * 验证调用间超时隔离，并转发对应授权模式与参数。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void isolatesSdkTimeoutsAndForwardsTheRequestedAuthorizationMode() throws Exception {
        MeituanClient first = mock(MeituanClient.class);
        MeituanClient second = mock(MeituanClient.class);
        MeituanClient third = mock(MeituanClient.class);
        MeituanClient fourth = mock(MeituanClient.class);
        when(factory.create(tenant)).thenReturn(first, second, third, fourth);
        tenant.setAppAuthToken("tenant-token");
        PageSearchRequest request = new PageSearchRequest();
        service.executeWithoutAuth(request, "shop", 100, 200);
        service.execute(request, "shop", 300, 400);
        service.execute(request, "shop", "actual-poi");
        CommonRequest common = new CommonRequest();
        common.setRealOpBizCode("actual-poi");
        common.setReadTimeout(1000);
        service.commonInvokeApi(common, MeituanResponse.class, "shop");
        verify(first).invokeApi(request, 100, 200);
        verify(second).invokeApi(request, "tenant-token", 300, 400);
        verify(third).invokeApi(request, "tenant-token", "actual-poi");
        verify(fourth).commonInvokeApi(common, MeituanResponse.class);
    }
}
