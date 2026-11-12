package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务数据（CancelRuleItem）。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalCancelRuleItemResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u62a5\u4ef7\u8be6\u60c5\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u6570\u636e\uff08CancelRuleItem\uff09\u3002的空实例。
     */
    public RentalCancelRuleItemResult() {
    }


    /**
     * 是否免费取消，用于高亮显示。必填。
     */
    @JsonProperty("isFree")
    private Boolean isFree;

    /**
     * 基准类型（下单时间/取车时间）详情见基准类型枚举 BaseLineType 免费取消可不填，否则需要填。
     */
    @JsonProperty("baseLineType")
    private String baseLineType;

    /**
     * 取消时间段描述 免费取消可不填，否则需要填。
     */
    @JsonProperty("timeDescription")
    private String timeDescription;

    /**
     * 扣费描述 免费取消可不填，否则需要填。
     */
    @JsonProperty("deductDescription")
    private String deductDescription;

    /**
     * 扣款金额 单位（分）。
     */
    @JsonProperty("amount")
    private Integer amount;

    /**
     * 单位万分之一，举例100%为10000，5%为500。
     */
    @JsonProperty("rate")
    private Integer rate;

    /**
     * 距离基准前分钟数，用来换算成绝对时刻。
     */
    @JsonProperty("aheadMinutes")
    private Integer aheadMinutes;

    /**
     * 按照取消时间短排序值，越小越靠前。必填。
     */
    @JsonProperty("sort")
    private Integer sort;
}
