package io.github.easy4j.meituan.model.jmcard;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 品牌会员等级及有效期。
 */
@Data
public class MeituanMemberLevel {

    /** 创建空的品牌会员等级对象。 */
    public MeituanMemberLevel() {
    }

    /** 品牌会员等级。 */
    @NotBlank(message = "brandLevel不能为空")
    @SerializedName("brandLevel")
    private String brandLevel;

    /** 等级开始时间，秒级时间戳。 */
    @SerializedName("levelBeginTime")
    private Long levelBeginTime;

    /** 等级结束时间，秒级时间戳。 */
    @SerializedName("levelEndTime")
    private Long levelEndTime;
}
