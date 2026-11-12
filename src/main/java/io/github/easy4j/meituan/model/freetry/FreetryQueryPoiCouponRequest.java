package io.github.easy4j.meituan.model.freetry;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * 免费试门店验券历史查询请求。
 */
@Data
@ApiMeta(
        path = "/freetry/open/coupon/queryPoiCoupon",
        businessId = 55,
        apiVersion = "",
        apiName = "query_poi_coupon",
        needAuth = true
)
public class FreetryQueryPoiCouponRequest implements MeituanRequest<FreetryQueryPoiCouponResponse> {

    /**
     * 查询日期，格式为 yyyy-MM-dd；不传时由平台采用默认范围。
     */
    @SerializedName("date")
    private String date;
    /**
     * 活动 ID；不传时查询门店全部活动。
     */
    @SerializedName("activityId")
    private Long activityId;
    /**
     * 页码，从 1 开始。
     */
    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page必须大于等于1")
    @SerializedName("page")
    private Integer page;
    /**
     * 每页数量。
     */
    @NotNull(message = "pageSize不能为空")
    @Min(value = 1, message = "pageSize必须大于等于1")
    @SerializedName("pageSize")
    private Integer pageSize;

    /**
     * 创建门店验券历史查询请求。
     */
    public FreetryQueryPoiCouponRequest() {
    }

    /**
     * 将官方 JSON 响应反序列化为当前接口的业务类型。
     *
     * @param response 官方接口返回的完整 JSON 文本
     * @return 包含状态码、结果说明和业务数据的官方响应
     */
    @Override
    public MeituanResponse<FreetryQueryPoiCouponResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<FreetryQueryPoiCouponResponse>>() {
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
