package io.github.easy4j.meituan.model.freetry;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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

    /**
     * 活动 ID。
     */
    @NotNull(message = "activityId不能为空")
    @SerializedName("activityId")
    private Long activityId;

    /**
     * 创建查询活动限制请求。
     */
    public FreetryLoadActivityRestrictionRequest() {
    }

    /**
     * 将官方 JSON 响应反序列化为当前接口的业务类型。
     *
     * @param response 官方接口返回的完整 JSON 文本
     * @return 包含状态码、结果说明和业务数据的官方响应
     */
    @Override
    public MeituanResponse<FreetryLoadActivityRestrictionResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<FreetryLoadActivityRestrictionResponse>>() {
        }.getType();
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
