package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzhkh.auth.pageQueryTokenPoiList.PageQueryTokenPoiListRequest;
import com.meituan.sdk.model.ddzhkh.auth.pageQueryTokenPoiList.PageQueryTokenPoiListResponse;
import com.meituan.sdk.model.ddzhkh.auth.queryPoiMapping.QueryPoiMappingRequest;
import com.meituan.sdk.model.ddzhkh.auth.queryPoiMapping.QueryPoiMappingResponse;

/**
 * 美团客户端授权（业务 59 ddzhkh）门面。
 *
 * <ul>
 *   <li>{@code /ddzhkh/auth/token/pageQueryPoiList}（businessId=59，需要授权）</li>
 *   <li>{@code /ddzhkh/auth/token/queryPoiMapping}（businessId=59，需要授权）</li>
 * </ul>
 */
public interface MeituanDdzhkhAuthService extends MeituanService {

    /**
     * 分页查询当前 token 授权范围内可授权的 POI 列表。
     *
     * @param request  官方 SDK 请求对象（limit、offset、openShopUuid 等字段）
     * @param tenantId 租户标识
     * @return 官方 SDK 响应对象，data 为 POI 列表
     */
    MeituanResponse<PageQueryTokenPoiListResponse> pageQueryTokenPoiList(
            PageQueryTokenPoiListRequest request, String tenantId);

    /**
     * 查询一批 POI 与开发商门店的绑定映射关系。
     *
     * @param request  官方 SDK 请求对象（poiIds 等字段）
     * @param tenantId 租户标识
     * @return 官方 SDK 响应对象，data 为映射信息
     */
    MeituanResponse<QueryPoiMappingResponse> queryPoiMapping(
            QueryPoiMappingRequest request, String tenantId);
}
