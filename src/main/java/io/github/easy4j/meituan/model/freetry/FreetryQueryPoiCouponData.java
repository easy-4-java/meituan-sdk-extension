package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

import java.util.List;

/**
 * 免费试门店验券历史查询结果。
 */
@Data
public class FreetryQueryPoiCouponData {

    /** 创建门店验券历史查询结果。 */
    public FreetryQueryPoiCouponData() {
    }

    /** 券码总数。 */
    private Integer totalCnt;

    /** 券码列表。 */
    private List<FreetryCouponData> couponList;
}
