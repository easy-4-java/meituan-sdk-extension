package io.github.easy4j.meituan.model.freetry;

import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * 免费试门店活动映射查询请求。
 */
@Data
@ApiMeta(
        path = "/freetry/open/coupon/queryActivitiesByPoi",
        businessId = 55,
        apiVersion = "",
        apiName = "query_activities_by_poi",
        needAuth = true
)
public class FreetryQueryActivitiesByPoiRequest implements MeituanRequest<FreetryQueryActivitiesByPoiResponse> {

    /** 创建门店活动映射查询请求。 */
    public FreetryQueryActivitiesByPoiRequest() {
    }

    /**
     * 将官方 JSON 响应反序列化为当前接口的业务类型。
     *
     * @param response 官方接口返回的完整 JSON 文本
     * @return 包含状态码、结果说明和业务数据的官方响应
     */
    @Override
    public MeituanResponse<FreetryQueryActivitiesByPoiResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<FreetryQueryActivitiesByPoiResponse>>() { }.getType();
        return JsonUtil.fromJson(response, type);
    }

    /**
     * 将当前请求按官方字段名称序列化为 JSON。
     *
     * @return 发送给官方 SDK 的业务参数 JSON
     */
    @Override
    public String serializeToJson() {
        return JsonUtil.toJson(this);
    }
}
