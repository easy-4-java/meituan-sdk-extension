package io.github.easy4j.meituan.callback.business92.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单续租报价查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_8de7d873-af5f-4323-91b4-59c6ed617263">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalExtensionQuoteQueryResult {

    /**
     * 业务状态码。必填。
     */
    @JsonProperty("bizCode")
    private Integer bizCode;

    /**
     * 错误描述。必填。
     */
    @JsonProperty("bizMessage")
    private String bizMessage;

    /**
     * 报价Id。必填。
     */
    @JsonProperty("quoteId")
    private String quoteId;

    /**
     * 需要补交总价钱 单位分。必填。
     */
    @JsonProperty("totalAmount")
    private Integer totalAmount;

    /**
     * 报价时效时间。必填。
     */
    @JsonProperty("quoteExpiresAt")
    private String quoteExpiresAt;

    /**
     * 续租后还车时间。必填。
     */
    @JsonProperty("renewalReturnTime")
    private String renewalReturnTime;

    /**
     * 续租取消规则信息。必填。
     */
    @JsonProperty("cancelRule")
    private RentalCancelRuleResult cancelRule;

    /**
     * 续租费用明细。必填。
     */
    @JsonProperty("fee")
    private RentalFeeResult fee;

    /**
     * 商家优惠信息。
     */
    @JsonProperty("promotions")
    private List<RentalPromotionResult> promotions;
}
