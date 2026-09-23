package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试活动使用限制。
 */
@Data
public class FreetryActivityRestrictionData {

    /** 创建活动限制数据。 */
    public FreetryActivityRestrictionData() {
    }

    /** 不可用日期说明。 */
    private String unusableDays;

    /** 每日可用时段说明。 */
    private String usableDailyPeriod;

    /** 预约规则。 */
    private String appointmentRule;

    /** 是否可与其他优惠同享。 */
    private String otherDiscountUsable;

    /** 活动规则。 */
    private String activityRule;

    /** 接待时段。 */
    private String receptionPeriod;
}
