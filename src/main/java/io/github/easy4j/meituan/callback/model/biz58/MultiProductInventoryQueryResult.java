package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「多商品库存批量查询」回调的业务响应。
 *
 * <p>业务数据为数组，本类型表示其中一个元素。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_e1371f36-2c45-4e90-8b9e-43dda8bb16e8">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiProductInventoryQueryResult {

    /**
     * 创建美团「多商品库存批量查询」回调的业务响应。的空实例。
     */
    public MultiProductInventoryQueryResult() {
    }


    /**
     * 预订时间，有两种格式，分时段库存必须以天为单位。 1、2017-01-01 10:00；2、以天为单位：2017-01-01 宠物预订业务使用第二种格式（宠物预订业务必填本字段）。
     */
    @JsonProperty("bookTime")
    private String bookTime;

    /**
     * 服务时长，分钟数，如果不填，表示不在意预订时长。
     */
    @JsonProperty("duration")
    private Integer duration;

    /**
     * 剩余库存量 （宠物预订业务必填本字段）。
     */
    @JsonProperty("remainCount")
    private Integer remainCount;

    /**
     * 三方服务项目id （宠物预订业务必填本字段）。
     */
    @JsonProperty("appProductId")
    private String appProductId;

    /**
     * 美团侧服务项目id，适用于适用美团侧服务项目id通信的业务。
     */
    @JsonProperty("productId")
    private Long productId;

    /**
     * 时段信息 注：分时段库存类型为必填 注：类型为对象类型，详见扩展参数period （宠物预订业务必填本字段）。
     */
    @JsonProperty("period")
    private Period period;

    /**
     * 时段信息 注：分时段库存类型为必填 注：类型为对象类型，详见扩展参数period （宠物预订业务必填本字段）。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Period {

        /**
         * 创建时段信息 注：分时段库存类型为必填 注：类型为对象类型，详见扩展参数period （宠物预订业务必填本字段）。的空实例。
         */
        public Period() {
        }


        /**
         * 三方时段序号。必填。
         */
        @JsonProperty("appPeriodId")
        private String appPeriodId;

        /**
         * 时段描述 分时段库存场景下， 时段描述是当前时段的开始时间 例如要展示2020-01-01 10:00-12:00场次的库存 返回的booktime=2020-01-01 period_name应该为10:00 （宠物预订业务必填本字段）。
         */
        @JsonProperty("periodName")
        private String periodName;
    }
}
