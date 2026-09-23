package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试门店验券历史业务响应。
 */
@Data
public class FreetryQueryPoiCouponResponse {

    /** 创建门店验券历史响应。 */
    public FreetryQueryPoiCouponResponse() {
    }

    /** 业务状态码。 */
    private Integer code;

    /** 业务执行状态。 */
    private Boolean status;

    /** 业务提示信息。 */
    private String msg;

    /** 验券历史业务数据。 */
    private FreetryQueryPoiCouponData data;
}
