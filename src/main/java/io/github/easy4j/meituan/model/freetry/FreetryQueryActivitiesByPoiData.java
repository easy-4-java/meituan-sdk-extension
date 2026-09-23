package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

import java.util.List;

/**
 * 免费试门店活动映射查询结果。
 */
@Data
public class FreetryQueryActivitiesByPoiData {

    /** 创建门店活动映射查询结果。 */
    public FreetryQueryActivitiesByPoiData() {
    }

    /** 门店活动列表。 */
    private List<FreetryActivityData> activityList;
}
