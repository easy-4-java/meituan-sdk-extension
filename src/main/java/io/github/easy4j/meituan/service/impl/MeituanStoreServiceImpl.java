package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.mendianzhilian.test.bind.BindRequest;
import com.meituan.sdk.model.mendianzhilian.test.createPoi.CreatePoiRequest;
import com.meituan.sdk.model.mendianzhilian.test.search.SearchRequest;
import com.meituan.sdk.model.mendianzhilian.test.updatePoi.UpdatePoiRequest;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetail.DcSrcollQueryTradeProfitDetailRequest;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetailForOppoiid.DcSrcollQueryTradeProfitDetailForOppoiidRequest;
import com.meituan.sdk.model.solution2.dcpoidinfo.dcPageQueryTokenPoiList.DcPageQueryTokenPoiListRequest;
import com.meituan.sdk.model.solution2.mtcompany.wechatOrderSqtInfoBatchQuery.WechatOrderSqtInfoBatchQueryRequest;
import com.meituan.sdk.model.solution2.csaccount.scrollQueryNonTradeProfitDetail.ScrollQueryNonTradeProfitDetailRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanStoreService;

/**
 * 门店基础信息直连默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanStoreServiceImpl extends AbstractMeituanService implements MeituanStoreService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanStoreServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bind(BindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createPoi(CreatePoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> search(SearchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updatePoi(UpdatePoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dcSrcollQueryTradeProfitDetail(DcSrcollQueryTradeProfitDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dcSrcollQueryTradeProfitDetailForOppoiid(DcSrcollQueryTradeProfitDetailForOppoiidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dcPageQueryTokenPoiList(DcPageQueryTokenPoiListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wechatOrderSqtInfoBatchQuery(WechatOrderSqtInfoBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }
    /**
     * 游标查询非交易结算流水。
     * <p>官方接口：{@code /solution2/csaccount/scrollQueryNonTradeProfitDetail}，API：{@code scroll_query_non_trade_profit_detail}，版本：{@code 10009}，businessId：{@code 86}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> scrollQueryNonTradeProfitDetail(ScrollQueryNonTradeProfitDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

}
