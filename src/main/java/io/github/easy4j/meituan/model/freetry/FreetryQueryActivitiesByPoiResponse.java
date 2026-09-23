package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试门店活动映射业务响应。
 */
@Data
public class FreetryQueryActivitiesByPoiResponse {

    /** 创建门店活动映射响应。 */
    public FreetryQueryActivitiesByPoiResponse() {
    }

    /** 业务状态码。 */
    private Integer code;

    /** 业务执行状态。 */
    private Boolean status;

    /** 业务提示信息。 */
    private String msg;

    /** 门店活动映射业务数据。 */
    private FreetryQueryActivitiesByPoiData data;
}
