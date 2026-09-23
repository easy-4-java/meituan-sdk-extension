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

    @Override
    public MeituanResponse<FreetryQueryActivitiesByPoiResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<FreetryQueryActivitiesByPoiResponse>>() { }.getType();
        return JsonUtil.fromJson(response, type);
    }

    @Override
    public String serializeToJson() {
        return JsonUtil.toJson(this);
    }
}
