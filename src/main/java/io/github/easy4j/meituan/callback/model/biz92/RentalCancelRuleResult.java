package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务数据（CancelRule）。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalCancelRuleResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u62a5\u4ef7\u8be6\u60c5\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u6570\u636e\uff08CancelRule\uff09\u3002的空实例。
     */
    public RentalCancelRuleResult() {
    }


    /**
     * 取消规则结构化数据，推荐填结构化数据 ，实在无法结构化必填降级文案。
     */
    @JsonProperty("cancelItems")
    private List<RentalCancelRuleItemResult> cancelItems;

    /**
     * 补充说明文案。
     */
    @JsonProperty("footer")
    private String footer;

    /**
     * 降级文案。
     */
    @JsonProperty("degradeText")
    private List<String> degradeText;
}
