package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.OrderQueryorderRequest;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.OrderQueryorderResponse;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.ResultSub;
import io.github.easy4j.meituan.client.DefaultMeituanRequestExecutor;
import io.github.easy4j.meituan.client.MeituanClientFactory;
import io.github.easy4j.meituan.config.MeituanTenantConfig;
import io.github.easy4j.meituan.service.MeituanRetailService;
import io.github.easy4j.meituan.tenant.InMemoryMeituanTenantConfigStorage;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * 验证Meituan Retail Service Order Queryorder的行为与接口契约。
 */
class MeituanRetailServiceOrderQueryorderTest {

    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID = "tenant-001";
    /**
     * 本地联调使用的应用授权 token。
     */
    private static final String APP_AUTH_TOKEN = "xxxx";
    /**
     * 本地联调使用的美团开发者编号。
     */
    private static final long DEVELOPER_ID = 100000L;
    /**
     * 本地联调使用的开发者签名密钥。
     */
    private static final String SIGN_KEY = "sign-key";
    /**
     * 创建MeituanRetailServiceOrderQueryorderTest的空实例。
     */
    MeituanRetailServiceOrderQueryorderTest() {
    }

    /**
     * 验证订单查询将租户 token 传给官方客户端。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void orderQueryorderShouldInvokeOfficialClientWithTenantAuthToken() throws Exception {
        MeituanClient meituanClient = mock(MeituanClient.class);
        MeituanResponse<OrderQueryorderResponse> expectedResponse = successResponse();
        OrderQueryorderRequest request = buildRequest();
        MeituanRetailService meituanRetailService = buildRetailService(meituanClient);

        when(meituanClient.invokeApi(request, APP_AUTH_TOKEN)).thenReturn(expectedResponse);

        MeituanResponse<?> response = meituanRetailService.orderQueryorder(request, TENANT_ID);

        assertThat(response).isSameAs(expectedResponse);
        ArgumentCaptor<OrderQueryorderRequest> requestCaptor = ArgumentCaptor.forClass(OrderQueryorderRequest.class);
        verify(meituanClient).invokeApi(requestCaptor.capture(), org.mockito.ArgumentMatchers.eq(APP_AUTH_TOKEN));
        OrderQueryorderRequest capturedRequest = requestCaptor.getValue();
        assertThat(capturedRequest.getOrderType()).isEqualTo(1);
        assertThat(capturedRequest.getAddTimeFrom()).isEqualTo(1765337402000L);
        assertThat(capturedRequest.getAddTimeTo()).isEqualTo(1765337404000L);
        assertThat(capturedRequest.getBuySuccessTimeFrom()).isEqualTo(1765338604000L);
        assertThat(capturedRequest.getBuySuccessTimeTo()).isEqualTo(1765338605000L);
        assertThat(capturedRequest.getPageNo()).isEqualTo(1);
        assertThat(capturedRequest.getPageSize()).isEqualTo(20);
    }

    /**
     * 验证订单查询使用所选租户的开发者凭据创建客户端。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void orderQueryorderShouldCreateOfficialClientFromTenantCredentials() throws Exception {
        MeituanClientFactory meituanClientFactory = mock(MeituanClientFactory.class);
        MeituanClient meituanClient = mock(MeituanClient.class);
        MeituanTenantConfig tenantConfig = buildTenantConfig();
        InMemoryMeituanTenantConfigStorage tenantConfigStorage = new InMemoryMeituanTenantConfigStorage(
                Collections.singletonMap(TENANT_ID, tenantConfig)
        );
        MeituanResponse<OrderQueryorderResponse> expectedResponse = successResponse();
        OrderQueryorderRequest request = buildRequest();
        MeituanRetailService meituanRetailService = new MeituanRetailServiceImpl(
                new DefaultMeituanRequestExecutor(meituanClientFactory, tenantConfigStorage)
        );

        when(meituanClientFactory.create(tenantConfig)).thenReturn(meituanClient);
        when(meituanClient.invokeApi(request, APP_AUTH_TOKEN)).thenReturn(expectedResponse);

        MeituanResponse<?> response = meituanRetailService.orderQueryorder(request, TENANT_ID);

        assertThat(response).isSameAs(expectedResponse);
        verify(meituanClientFactory).create(tenantConfig);
        verify(meituanClient).invokeApi(request, APP_AUTH_TOKEN);
    }

    /**
     * 验证订单查询成功示例能够完整反序列化。
     */
    @Test
    void orderQueryorderShouldDeserializeSuccessResponseExample() {
        String json = "{"
                + "\"code\":\"OP_SUCCESS\","
                + "\"msg\":\"成功\","
                + "\"traceId\":\"8531422235710213256\","
                + "\"data\":{\"result\":[{"
                + "\"orderId\":\"\\\"5008024992393321234\\\"\","
                + "\"orderType\":1,"
                + "\"buySuccessTime\":1765028817000,"
                + "\"expireTime\":1765030615000,"
                + "\"productName\":\"\\\"商品名称\\\"\","
                + "\"productItemId\":1336632339,"
                + "\"status\":0,"
                + "\"refundStatus\":-1,"
                + "\"mobile\":\"\\\"157****9926\\\"\","
                + "\"shopName\":\"\\\"门店名称\\\"\","
                + "\"opPoiId\":\"\\\"AG42IGTUDLL670H4855\\\"\","
                + "\"channel\":1,"
                + "\"totalAmount\":100.0,"
                + "\"shopAmount\":0.0,"
                + "\"spugId\":1113254333,"
                + "\"relatedBookByOrder\":false"
                + "}]}}";

        MeituanResponse<OrderQueryorderResponse> response = buildRequest().deserializeResponse(json);

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getTraceId()).isEqualTo("8531422235710213256");
        assertThat(response.getData().getResult()).hasSize(1);
        ResultSub result = response.getData().getResult().get(0);
        assertThat(result.getOrderId()).isEqualTo("\"5008024992393321234\"");
        assertThat(result.getOrderType()).isEqualTo(1);
        assertThat(result.getBuySuccessTime()).isEqualTo(1765028817000L);
        assertThat(result.getExpireTime()).isEqualTo(1765030615000L);
        assertThat(result.getProductName()).isEqualTo("\"商品名称\"");
        assertThat(result.getProductItemId()).isEqualTo(1336632339L);
        assertThat(result.getStatus()).isZero();
        assertThat(result.getRefundStatus()).isEqualTo(-1);
        assertThat(result.getMobile()).isEqualTo("\"157****9926\"");
        assertThat(result.getShopName()).isEqualTo("\"门店名称\"");
        assertThat(result.getOpPoiId()).isEqualTo("\"AG42IGTUDLL670H4855\"");
        assertThat(result.getChannel()).isEqualTo(1);
        assertThat(result.getTotalAmount()).isEqualTo(100.0D);
        assertThat(result.getShopAmount()).isEqualTo(0.0D);
        assertThat(result.getSpugId()).isEqualTo(1113254333L);
        assertThat(result.getRelatedBookByOrder()).isFalse();
    }

    /**
     * 验证订单查询失败示例能够读取错误码及说明。
     */
    @Test
    void orderQueryorderShouldDeserializeErrorResponseExample() {
        String json = "{"
                + "\"code\":\"OP_SYSTEM_PARAM_ERROR\","
                + "\"msg\":\"缺少系统参数\","
                + "\"traceId\":\"123\""
                + "}";

        MeituanResponse<OrderQueryorderResponse> response = buildRequest().deserializeResponse(json);

        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getCode()).isEqualTo("OP_SYSTEM_PARAM_ERROR");
        assertThat(response.getMsg()).isEqualTo("缺少系统参数");
        assertThat(response.getTraceId()).isEqualTo("123");
        assertThat(response.getData()).isNull();
    }

    /**
     * 按本地调试配置创建带租户授权的服务零售门面。
     *
     * @param meituanClient 测试使用的官方 SDK 客户端
     * @return 按本地调试配置创建带租户授权的服务零售门面的结果
     */
    private MeituanRetailService buildRetailService(MeituanClient meituanClient) {
        InMemoryMeituanTenantConfigStorage tenantConfigStorage = new InMemoryMeituanTenantConfigStorage(
                Collections.singletonMap(TENANT_ID, buildTenantConfig())
        );
        return new MeituanRetailServiceImpl(new DefaultMeituanRequestExecutor(meituanClient, tenantConfigStorage));
    }

    /**
     * 创建包含测试开发者凭据和授权 token 的租户配置。
     *
     * @return 创建包含测试开发者凭据和授权 token 的租户配置的结果
     */
    private MeituanTenantConfig buildTenantConfig() {
        MeituanTenantConfig tenantConfig = new MeituanTenantConfig();
        tenantConfig.setDeveloperId(DEVELOPER_ID);
        tenantConfig.setSignKey(SIGN_KEY);
        tenantConfig.setAppAuthToken(APP_AUTH_TOKEN);
        return tenantConfig;
    }

    /**
     * 构造指定偏移量的已验券码分页查询请求。
     *
     * @return 构造指定偏移量的已验券码分页查询请求的结果
     */
    private OrderQueryorderRequest buildRequest() {
        OrderQueryorderRequest request = new OrderQueryorderRequest();
        request.setOrderType(1);
        request.setAddTimeFrom(1765337402000L);
        request.setAddTimeTo(1765337404000L);
        request.setBuySuccessTimeFrom(1765338604000L);
        request.setBuySuccessTimeTo(1765338605000L);
        request.setPageNo(1);
        request.setPageSize(20);
        return request;
    }

    /**
     * 构造用于验证订单查询路由的成功响应。
     *
     * @return 构造用于验证订单查询路由的成功响应的结果
     */
    private MeituanResponse<OrderQueryorderResponse> successResponse() {
        ResultSub result = new ResultSub();
        result.setOrderId("5008024992393321234");
        result.setOrderType(1);

        OrderQueryorderResponse data = new OrderQueryorderResponse();
        data.setResult(Collections.singletonList(result));

        MeituanResponse<OrderQueryorderResponse> response = new MeituanResponse<>();
        response.setCode("OP_SUCCESS");
        response.setMsg("成功");
        response.setData(data);
        return response;
    }
}
