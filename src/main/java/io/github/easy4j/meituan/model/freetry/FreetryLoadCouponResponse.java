package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试已验券码查询业务响应。
 */
@Data
public class FreetryLoadCouponResponse {

    /** 创建已验券码查询响应。 */
    public FreetryLoadCouponResponse() {
    }

    /** 业务状态码。 */
    private Integer code;

    /** 业务执行状态。 */
    private Boolean status;

    /** 业务提示信息。 */
    private String msg;

    /** 券码及活动业务数据。 */
    private FreetryLoadCouponData data;
}
