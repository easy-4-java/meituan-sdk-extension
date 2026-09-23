package io.github.easy4j.meituan.model.freetry;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Type;

/**
 * 免费试已验券码查询请求。
 */
@Data
@ApiMeta(
        path = "/freetry/open/coupon/load",
        businessId = 55,
        apiVersion = "",
        apiName = "load_coupon",
        needAuth = true
)
public class FreetryLoadCouponRequest implements MeituanRequest<FreetryLoadCouponResponse> {

    /** 创建已验券码查询请求。 */
    public FreetryLoadCouponRequest() {
    }

    /** 13 位券码。 */
    @NotNull(message = "couponCode不能为空")
    @Size(min = 13, max = 13, message = "couponCode长度必须为13")
    @SerializedName("couponCode")
    private String couponCode;

    @Override
    public MeituanResponse<FreetryLoadCouponResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<FreetryLoadCouponResponse>>() { }.getType();
        return JsonUtil.fromJson(response, type);
    }

    @Override
    public String serializeToJson() {
        return JsonUtil.toJson(this);
    }
}
