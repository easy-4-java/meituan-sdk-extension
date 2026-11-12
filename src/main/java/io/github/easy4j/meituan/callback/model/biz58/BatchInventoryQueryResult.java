package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「批量获取库存」回调的业务响应。
 *
 * <p>业务数据为数组，本类型表示其中一个元素。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_3e3c9cce-babf-4faf-9e87-6949e471b8dc">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchInventoryQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u6279\u91cf\u83b7\u53d6\u5e93\u5b58\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public BatchInventoryQueryResult() {
    }


    /**
     * 预订时间，有两种格式，分时段库存必须以天为单位。 1、2017-01-01 10:00；2、支持以天为单位：形如2017-01-01 注意：足疗预订业务不受上述限制，返回时间格式均为2017-01-01 10:00。必填。
     */
    @JsonProperty("beginTime")
    private String beginTime;

    /**
     * 服务时长，分钟数，如：30，60，90等。如果不填，表示不在意预订时长。
     */
    @JsonProperty("duration")
    private Integer duration;

    /**
     * 剩余库存量。必填。
     */
    @JsonProperty("remainCount")
    private Integer remainCount;

    /**
     * 第三方项目id，三方测试时可通过技术支持联系我们在测试门店中添加测试商品。
     */
    @JsonProperty("appProductId")
    private String appProductId;

    /**
     * 美团侧服务项目id，适用于适用美团侧服务项目id通信的业务。
     */
    @JsonProperty("productId")
    private Long productId;

    /**
     * 是否是跨凌晨库存。1-是，0-不是。主要用于足疗预订。
     */
    @JsonProperty("smallHoursFlag")
    private Integer smallHoursFlag;

    /**
     * 时段信息，详细字段见下表 注：分时段库存类型为必填。
     */
    @JsonProperty("period")
    private Period period;

    /**
     * 时段信息，详细字段见下表 注：分时段库存类型为必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Period {

        /**
         * 创建\u65f6\u6bb5\u4fe1\u606f\uff0c\u8be6\u7ec6\u5b57\u6bb5\u89c1\u4e0b\u8868 \u6ce8\uff1a\u5206\u65f6\u6bb5\u5e93\u5b58\u7c7b\u578b\u4e3a\u5fc5\u586b\u3002的空实例。
         */
        public Period() {
        }


        /**
         * 三方时段id。必填。
         */
        @JsonProperty("appPeriodId")
        private String appPeriodId;

        /**
         * 时段名称 分时段库存场景下， 时段描述是当前时段的开始时间 例如要展示2020-01-01 10:00-12:00场次的库存 返回的booktime=2020-01-01 period_name应该为10:00。必填。
         */
        @JsonProperty("periodName")
        private String periodName;
    }
}
