package io.github.easy4j.meituan.model.jmcard;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.internal.utils.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

    /**
     * 将官方 JSON 响应反序列化为当前接口的业务类型。
     *
     * @param response 官方接口返回的完整 JSON 文本
     * @return 包含状态码、结果说明和业务数据的官方响应
     */
    @Override
    public MeituanResponse<MeituanMemberClaimResponse> deserializeResponse(String response) {
        Type type = new TypeToken<MeituanResponse<MeituanMemberClaimResponse>>() { }.getType();
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
