package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试已验券码查询结果。
 */
@Data
public class FreetryLoadCouponData {

    /** 创建已验券码查询结果。 */
    public FreetryLoadCouponData() {
    }

    /** 券码信息。 */
    private FreetryCouponData coupon;

    /** 活动信息。 */
    private FreetryActivityData activity;
}
