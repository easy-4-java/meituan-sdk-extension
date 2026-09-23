package io.github.easy4j.meituan.model.jmcard;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;

/**
 * 领取美团会员权益请求。
 * <p>当前官方 MtOpJavaSDK 1.0.20260831 未生成该模型，因此依据公开接口文档补充兼容请求。
 * 公共文档未公开模型版本，故 {@link ApiMeta#apiVersion()} 保持为空。</p>
 */
@Getter
@Setter
@ApiMeta(
        path = "/jmcard/members/claim",
        businessId = 15,
        apiVersion = "",
        apiName = "member_claim",
        needAuth = true
)
public class MeituanMemberClaimRequest implements MeituanRequest<MeituanMemberClaimResponse> {

    /** 创建空的权益领取请求。 */
    public MeituanMemberClaimRequest() {
    }

    /** 用户权益领取信息。 */
    @Valid
    @NotNull(message = "userRightInfo不能为空")
    @SerializedName("userRightInfo")
    private MeituanMemberClaimUserRight userRightInfo;

    @Override
    public MeituanResponse<MeituanMemberClaimResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<MeituanMemberClaimResponse>>() { }.getType();
        return JsonUtil.fromJson(response, type);
    }

    @Override
    public String serializeToJson() {
        return JsonUtil.toJson(this);
    }
}
