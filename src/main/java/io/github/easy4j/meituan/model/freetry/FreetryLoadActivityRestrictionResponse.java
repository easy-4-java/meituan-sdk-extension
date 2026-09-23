package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试查询活动限制业务响应。
 */
@Data
public class FreetryLoadActivityRestrictionResponse {

    /** 创建查询活动限制响应。 */
    public FreetryLoadActivityRestrictionResponse() {
    }

    /** 业务状态码。 */
    private Integer code;

    /** 业务执行状态。 */
    private Boolean status;

    /** 业务提示信息。 */
    private String msg;

    /** 活动限制数据。 */
    private FreetryActivityRestrictionData data;
}
