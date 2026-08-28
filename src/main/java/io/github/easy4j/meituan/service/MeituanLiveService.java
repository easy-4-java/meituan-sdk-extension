package io.github.easy4j.meituan.service;

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

/**
 * 美团平台直播业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanLiveService extends MeituanService {

    /**
     * 校验授权情况，集采场景。
     * <p>官方接口：{@code /mlive/anchor/checkDelegation}，API：{@code check_delegation}，版本：{@code 10001}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> checkDelegation(CheckDelegationRequest request, String tenantId);

    /**
     * 查询直播间用户评论。
     * <p>官方接口：{@code /mlive/comment/query}，API：{@code query_live_room_comment}，版本：{@code 10008}，businessId：{@code 50}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryLiveRoomComment(QueryLiveRoomCommentRequest request, String tenantId);

    /**
     * 评论查询接口，集采场景。
     * <p>官方接口：{@code /mlive/comment/query/v2}，API：{@code query_live_room_comment_v2}，版本：{@code 10012}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryLiveRoomCommentV2(QueryLiveRoomCommentV2Request request, String tenantId);

    /**
     * 发送直播间评论。
     * <p>官方接口：{@code /mlive/comment/send}，API：{@code send_live_room_comment}，版本：{@code 10009}，businessId：{@code 50}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sendLiveRoomComment(SendLiveRoomCommentRequest request, String tenantId);

    /**
     * 评论发送接口，集采场景。
     * <p>官方接口：{@code /mlive/comment/send/v2}，API：{@code send_live_room_comment_v2}，版本：{@code 10013}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sendLiveRoomCommentV2(SendLiveRoomCommentV2Request request, String tenantId);

    /**
     * 直播间商品置顶。
     * <p>官方接口：{@code /mlive/goods/onTop}，API：{@code live_goods_on_top}，版本：{@code 10004}，businessId：{@code 50}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> liveGoodsOnTop(LiveGoodsOnTopRequest request, String tenantId);

    /**
     * 直播间商品置顶，集采场景。
     * <p>官方接口：{@code /mlive/goods/onTop/v2}，API：{@code live_goods_on_top_v2}，版本：{@code 10008}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> liveGoodsOnTopV2(LiveGoodsOnTopV2Request request, String tenantId);

    /**
     * 查询直播间商品。
     * <p>官方接口：{@code /mlive/goods/query}，API：{@code query_live_goods_info}，版本：{@code 10005}，businessId：{@code 50}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryLiveGoodsInfo(QueryLiveGoodsInfoRequest request, String tenantId);

    /**
     * 查询直播间商品，集采场景。
     * <p>官方接口：{@code /mlive/goods/query/v2}，API：{@code query_live_goods_info_v2}，版本：{@code 10009}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryLiveGoodsInfoV2(QueryLiveGoodsInfoV2Request request, String tenantId);

    /**
     * 获取im消息。
     * <p>官方接口：{@code /mlive/immsg/search}，API：{@code search}，版本：{@code 10000}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> search(SearchRequest request, String tenantId);

    /**
     * 用直播物料获取推流地址。
     * <p>官方接口：{@code /mlive/streams/getPushUrlWithLiveMaterial}，API：{@code get_push_url_with_material}，版本：{@code 10010}，businessId：{@code 50}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getPushUrlWithMaterial(GetPushUrlWithMaterialRequest request, String tenantId);

    /**
     * 获取推流地址。
     * <p>官方接口：{@code /mlive/streams/getPushUrls}，API：{@code get_push_urls}，版本：{@code 10011}，businessId：{@code 50}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getPushUrls(GetPushUrlsRequest request, String tenantId);

    /**
     * 获取推流地址，集采场景。
     * <p>官方接口：{@code /mlive/streams/getPushUrls/v2}，API：{@code get_push_urls_v2}，版本：{@code 10015}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getPushUrlsV2(GetPushUrlsV2Request request, String tenantId);

    /**
     * 提交直播物料。
     * <p>官方接口：{@code /mlive/streams/reportMaterial}，API：{@code report_live_material}，版本：{@code 10012}，businessId：{@code 50}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> reportLiveMaterial(ReportLiveMaterialRequest request, String tenantId);

    /**
     * 提交直播物料，集采场景。
     * <p>官方接口：{@code /mlive/streams/reportMaterial/v2}，API：{@code report_live_material_v2}，版本：{@code 10016}，businessId：{@code 50}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> reportLiveMaterialV2(ReportLiveMaterialV2Request request, String tenantId);
}
