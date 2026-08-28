package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.mlive.anchor.checkDelegation.CheckDelegationRequest;
import com.meituan.sdk.model.mlive.comment.queryLiveRoomComment.QueryLiveRoomCommentRequest;
import com.meituan.sdk.model.mlive.comment.queryLiveRoomCommentV2.QueryLiveRoomCommentV2Request;
import com.meituan.sdk.model.mlive.comment.sendLiveRoomComment.SendLiveRoomCommentRequest;
import com.meituan.sdk.model.mlive.comment.sendLiveRoomCommentV2.SendLiveRoomCommentV2Request;
import com.meituan.sdk.model.mlive.goods.liveGoodsOnTop.LiveGoodsOnTopRequest;
import com.meituan.sdk.model.mlive.goods.liveGoodsOnTopV2.LiveGoodsOnTopV2Request;
import com.meituan.sdk.model.mlive.goods.queryLiveGoodsInfo.QueryLiveGoodsInfoRequest;
import com.meituan.sdk.model.mlive.goods.queryLiveGoodsInfoV2.QueryLiveGoodsInfoV2Request;
import com.meituan.sdk.model.mlive.immsg.search.SearchRequest;
import com.meituan.sdk.model.mlive.streams.getPushUrlWithMaterial.GetPushUrlWithMaterialRequest;
import com.meituan.sdk.model.mlive.streams.getPushUrls.GetPushUrlsRequest;
import com.meituan.sdk.model.mlive.streams.getPushUrlsV2.GetPushUrlsV2Request;
import com.meituan.sdk.model.mlive.streams.reportLiveMaterial.ReportLiveMaterialRequest;
import com.meituan.sdk.model.mlive.streams.reportLiveMaterialV2.ReportLiveMaterialV2Request;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanLiveService;

/**
 * 美团平台直播默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanLiveServiceImpl extends AbstractMeituanService implements MeituanLiveService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanLiveServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> checkDelegation(CheckDelegationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryLiveRoomComment(QueryLiveRoomCommentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryLiveRoomCommentV2(QueryLiveRoomCommentV2Request request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sendLiveRoomComment(SendLiveRoomCommentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sendLiveRoomCommentV2(SendLiveRoomCommentV2Request request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> liveGoodsOnTop(LiveGoodsOnTopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> liveGoodsOnTopV2(LiveGoodsOnTopV2Request request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryLiveGoodsInfo(QueryLiveGoodsInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryLiveGoodsInfoV2(QueryLiveGoodsInfoV2Request request, String tenantId) {
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
    public MeituanResponse<?> getPushUrlWithMaterial(GetPushUrlWithMaterialRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getPushUrls(GetPushUrlsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getPushUrlsV2(GetPushUrlsV2Request request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> reportLiveMaterial(ReportLiveMaterialRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> reportLiveMaterialV2(ReportLiveMaterialV2Request request, String tenantId) {
        return execute(request, tenantId);
    }
}
