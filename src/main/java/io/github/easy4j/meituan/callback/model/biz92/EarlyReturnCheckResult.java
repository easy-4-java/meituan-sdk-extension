package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「提前还车检查」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_449cbd33-ca5b-4625-9483-9c63f123b37e">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EarlyReturnCheckResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u63d0\u524d\u8fd8\u8f66\u68c0\u67e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public EarlyReturnCheckResult() {
    }


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
     * 提前还车费用明细，表示从租车到现在还车的报价费用。必填。
     */
    @JsonProperty("fee")
    private RentalFeeResult fee;

    /**
     * 除基础保障外，额外保障需要付费金额。必填。
     */
    @JsonProperty("selectedInsurance")
    private InsuranceFee selectedInsurance;

    /**
     * 有活动必传。
     */
    @JsonProperty("promotions")
    private List<RentalPromotionResult> promotions;

    /**
     * 预计退款用户金额，如果需要补款传负值 单位分。必填。
     */
    @JsonProperty("estimateReturnTotalAmount")
    private Integer estimateReturnTotalAmount;

    /**
     * 除基础保障外，额外保障需要付费金额。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InsuranceFee {

        /**
         * 创建\u9664\u57fa\u7840\u4fdd\u969c\u5916\uff0c\u989d\u5916\u4fdd\u969c\u9700\u8981\u4ed8\u8d39\u91d1\u989d\u3002\u5fc5\u586b\u3002的空实例。
         */
        public InsuranceFee() {
        }


        /**
         * 保障服务Code枚举：InsuranceCode。必填。
         */
        @JsonProperty("code")
        private String code;

        /**
         * 保障名称。必填。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 保障总需付的费用。必填。
         */
        @JsonProperty("totalAmount")
        private Integer totalAmount;

        /**
         * 保障每日额外加的费用（展示用）。必填。
         */
        @JsonProperty("dayAmount")
        private Integer dayAmount;
    }
}
