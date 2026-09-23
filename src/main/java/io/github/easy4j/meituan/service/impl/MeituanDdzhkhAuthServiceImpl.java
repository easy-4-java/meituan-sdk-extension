package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzhkh.auth.pageQueryTokenPoiList.PageQueryTokenPoiListRequest;
import com.meituan.sdk.model.ddzhkh.auth.pageQueryTokenPoiList.PageQueryTokenPoiListResponse;
import com.meituan.sdk.model.ddzhkh.auth.queryPoiMapping.QueryPoiMappingRequest;
import com.meituan.sdk.model.ddzhkh.auth.queryPoiMapping.QueryPoiMappingResponse;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryInfoByGeneralconnect.OrderQueryInfoByGeneralconnectRequest;
import com.meituan.sdk.model.ddzhkh.member.memberInfoAsyncCallback.MemberInfoAsyncCallbackRequest;
import com.meituan.sdk.model.ddzhkh.xcxpw.searchPayInfoBill.SearchPayInfoBillRequest;
import com.meituan.sdk.model.ddzhkh.xcxpw.searchRefundBill.SearchRefundBillRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanDdzhkhAuthService;

/**
 * 美团客户端授权默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanDdzhkhAuthServiceImpl extends AbstractMeituanService implements MeituanDdzhkhAuthService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanDdzhkhAuthServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    @Override
    public MeituanResponse<PageQueryTokenPoiListResponse> pageQueryTokenPoiList(
            PageQueryTokenPoiListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    @Override
    public MeituanResponse<QueryPoiMappingResponse> queryPoiMapping(
            QueryPoiMappingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    @Override
    public MeituanResponse<?> orderQueryInfoByGeneralconnect(
            OrderQueryInfoByGeneralconnectRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    @Override
    public MeituanResponse<?> memberInfoAsyncCallback(
            MemberInfoAsyncCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    @Override
    public MeituanResponse<?> searchPayInfoBill(SearchPayInfoBillRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    @Override
    public MeituanResponse<?> searchRefundBill(SearchRefundBillRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
