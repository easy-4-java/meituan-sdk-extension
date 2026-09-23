package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试券码数据。
 */
@Data
public class FreetryCouponData {

    /** 创建券码数据。 */
    public FreetryCouponData() {
    }

    /** 券号。 */
    private String couponCode;

    /** 券码状态。 */
    private String couponStatus;

    /** 验券时间戳。 */
    private Long verifyTime;

    /** 活动 ID。 */
    private Long activityId;

    /** 活动标题。 */
    private String activityTitle;

    /** 用户手机尾号。 */
    private String userPhoneTail;
}
