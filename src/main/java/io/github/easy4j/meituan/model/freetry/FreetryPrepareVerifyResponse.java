package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试验券准备响应。
 */
@Data
public class FreetryPrepareVerifyResponse {

    /** 创建验券准备响应。 */
    public FreetryPrepareVerifyResponse() {
    }

    /** 活动 ID。 */
    private Long activityId;

    /** 活动标题。 */
    private String activityTitle;

    /** 活动名额。 */
    private Integer activityQuota;

    /** 活动项目名称。 */
    private String activityProjectName;

    /** 券状态码。 */
    private Integer couponStatusCode;

    /** 券状态说明。 */
    private String couponStatus;
}
