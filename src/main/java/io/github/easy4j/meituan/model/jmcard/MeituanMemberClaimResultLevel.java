package io.github.easy4j.meituan.model.jmcard;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 领取权益后返回的美团会员实际等级。
 */
@Data
public class MeituanMemberClaimResultLevel {

    /** 创建空的美团会员结果等级对象。 */
    public MeituanMemberClaimResultLevel() {
    }

    /** 美团会员等级，范围为 L1 至 L6。 */
    @SerializedName("mtLevel")
    private String mtLevel;

    /** 等级开始时间，秒级时间戳。 */
    @SerializedName("levelBeginTime")
    private Long levelBeginTime;

    /** 等级结束时间，秒级时间戳。 */
    @SerializedName("levelEndTime")
    private Long levelEndTime;
}
