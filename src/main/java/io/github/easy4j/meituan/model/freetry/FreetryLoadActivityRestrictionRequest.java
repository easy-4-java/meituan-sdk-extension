package io.github.easy4j.meituan.model.freetry;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;

/**
 * 免费试查询活动限制请求。
 */
@Data
@ApiMeta(
        path = "/freetry/open/coupon/loadActivityRestriction",
        businessId = 55,
        apiVersion = "",
        apiName = "load_activity_restriction",
        needAuth = true
)
public class FreetryLoadActivityRestrictionRequest
        implements MeituanRequest<FreetryLoadActivityRestrictionResponse> {

    /** 创建查询活动限制请求。 */
    public FreetryLoadActivityRestrictionRequest() {
    }

    /** 活动 ID。 */
    @NotNull(message = "activityId不能为空")
    @SerializedName("activityId")
    private Long activityId;

    @Override
    public MeituanResponse<FreetryLoadActivityRestrictionResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<FreetryLoadActivityRestrictionResponse>>() { }.getType();
        return JsonUtil.fromJson(response, type);
    }

    @Override
    public String serializeToJson() {
        return JsonUtil.toJson(this);
    }
}
