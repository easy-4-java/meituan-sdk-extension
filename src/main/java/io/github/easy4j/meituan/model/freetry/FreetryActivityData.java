package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试活动数据。
 */
@Data
public class FreetryActivityData {

    /** 创建活动数据。 */
    public FreetryActivityData() {
    }

    /** 活动 ID。 */
    private Long activityId;

    /** 活动标题。 */
    private String activityTitle;

    /** 活动项目名称。 */
    private String projectName;

    /** 门店名额。 */
    private Integer branchQuota;

    /** 报名开始时间戳。 */
    private Long applyBeginTime;

    /** 报名结束时间戳。 */
    private Long applyEndTime;

    /** 接待开始时间戳。 */
    private Long receptionBeginTime;

    /** 接待结束时间戳。 */
    private Long receptionEndTime;

    /** 体验内容。 */
    private String activityContent;

    /** 活动价值。 */
    private String activityValue;
}
