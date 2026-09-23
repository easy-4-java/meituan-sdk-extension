package io.github.easy4j.meituan.model.jmcard;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 领取美团会员权益业务响应。
 */
@Data
public class MeituanMemberClaimResponse {

    /** 创建空的权益领取业务响应。 */
    public MeituanMemberClaimResponse() {
    }

    /** 业务结果码，官方文档约定 200 表示成功。 */
    @SerializedName("resultCode")
    private Integer resultCode;

    /** 业务异常描述。 */
    @SerializedName("errMsg")
    private String errMsg;

    /** 美团会员实际等级。 */
    @SerializedName("mtLevel")
    private MeituanMemberClaimResultLevel mtLevel;
}
