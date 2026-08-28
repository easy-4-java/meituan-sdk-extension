package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.mendianzhilian.test.bind.BindRequest;
import com.meituan.sdk.model.mendianzhilian.test.createPoi.CreatePoiRequest;
import com.meituan.sdk.model.mendianzhilian.test.search.SearchRequest;
import com.meituan.sdk.model.mendianzhilian.test.updatePoi.UpdatePoiRequest;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetail.DcSrcollQueryTradeProfitDetailRequest;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetailForOppoiid.DcSrcollQueryTradeProfitDetailForOppoiidRequest;
import com.meituan.sdk.model.solution2.dcpoidinfo.dcPageQueryTokenPoiList.DcPageQueryTokenPoiListRequest;
import com.meituan.sdk.model.solution2.dcpoidinfo.obfuscateMtshop.ObfuscateMtshopRequest;
import com.meituan.sdk.model.solution2.mtcompany.wechatOrderSqtInfoBatchQuery.WechatOrderSqtInfoBatchQueryRequest;

/**
 * 门店基础信息直连业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanStoreService extends MeituanService {

    /**
     * 绑定/解绑美团门店。
     * <p>官方接口：{@code /mendianzhilian/test/map/poi/bind}，API：{@code bind}，版本：{@code 10026}，businessId：{@code 71}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bind(BindRequest request, String tenantId);

    /**
     * 创建新门店。
     * <p>官方接口：{@code /mendianzhilian/test/map/poi/create}，API：{@code create_poi}，版本：{@code 10020}，businessId：{@code 71}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createPoi(CreatePoiRequest request, String tenantId);

    /**
     * 查询门店信息。
     * <p>官方接口：{@code /mendianzhilian/test/map/poi/search}，API：{@code search}，版本：{@code 10024}，businessId：{@code 71}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> search(SearchRequest request, String tenantId);

    /**
     * 门店信息更新。
     * <p>官方接口：{@code /mendianzhilian/test/map/poi/update}，API：{@code update_poi}，版本：{@code 10017}，businessId：{@code 71}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updatePoi(UpdatePoiRequest request, String tenantId);

    /**
     * 游标查询交易结算流水。
     * <p>官方接口：{@code /solution2/csaccount/scrollQueryTradeProfitDetail}，API：{@code dc_srcoll_query_trade_profit_detail}，版本：{@code 10001}，businessId：{@code 86}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dcSrcollQueryTradeProfitDetail(DcSrcollQueryTradeProfitDetailRequest request, String tenantId);

    /**
     * 游标查询交易结算流水(服务商使用)。
     * <p>官方接口：{@code /solution2/csaccount/scrollQueryTradeProfitDetailOpPoiId}，API：{@code dc_srcoll_query_trade_profit_detail_for_oppoiid}，版本：{@code 10005}，businessId：{@code 86}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dcSrcollQueryTradeProfitDetailForOppoiid(DcSrcollQueryTradeProfitDetailForOppoiidRequest request, String tenantId);

    /**
     * 适用门店查询。
     * <p>官方接口：{@code /solution2/dcpoidinfo/pageQueryPoiList}，API：{@code dc_page_query_token_poi_list}，版本：{@code 10002}，businessId：{@code 86}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dcPageQueryTokenPoiList(DcPageQueryTokenPoiListRequest request, String tenantId);

    /**
     * 美团门店混淆。
     * <p>官方接口：{@code /solution2/dcpoidinfo/obfuscate/poiid}，API：{@code obfuscate_mtshop}，版本：{@code 10003}，businessId：{@code 86}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> obfuscateMtshop(ObfuscateMtshopRequest request, String tenantId);

    /**
     * 批量查询微信支付订单商企通信息。
     * <p>官方接口：{@code /solution2/mtcompany/wechat/sqtInfo/batch/query}，API：{@code wechat_order_sqt_info_batch_query}，版本：{@code 10001}，businessId：{@code 86}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wechatOrderSqtInfoBatchQuery(WechatOrderSqtInfoBatchQueryRequest request, String tenantId);
}
