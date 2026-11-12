package io.github.easy4j.meituan.model.freetry;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * 免费试执行验券请求。
 */
@Data
@ApiMeta(
        path = "/freetry/open/coupon/verify",
        businessId = 55,
        apiVersion = "",
        apiName = "verify_coupon",
        needAuth = true
)
public class FreetryVerifyCouponRequest implements MeituanRequest<FreetryVerifyCouponResponse> {

    /**
     * 13 位券码。
     */
    @NotNull(message = "couponCode不能为空")
    @Size(min = 13, max = 13, message = "couponCode长度必须为13")
    @SerializedName("couponCode")
    private String couponCode;
    /**
     * 幂等键。
     * <p>官方请求示例会随执行验券请求传递该字段，用于区分同一次业务操作的重复提交。</p>
     */
    @SerializedName("idempotent")
    private String idempotent;

    /**
     * 创建执行验券请求。
     */
    public FreetryVerifyCouponRequest() {
    }

    /**
     * 将官方 JSON 响应反序列化为当前接口的业务类型。
     *
     * @param response 官方接口返回的完整 JSON 文本
     * @return 包含状态码、结果说明和业务数据的官方响应
     */
    @Override
    public MeituanResponse<FreetryVerifyCouponResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<FreetryVerifyCouponResponse>>() {
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
