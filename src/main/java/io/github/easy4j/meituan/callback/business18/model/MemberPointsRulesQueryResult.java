package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询会员积分规则」回调的业务响应。
 *
 * <p>收银端响应示例将本对象置于 {@code data}，外层 {@code message} 为 {@code ok}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_92875d44-c27e-4c62-97d6-43b50372eb35">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPointsRulesQueryResult {

    /**
     * 积分抵现规则，支持传入多等级会员规则。必填。
     */
    @JsonProperty("redeemRules")
    private List<RedeemRule> redeemRules;

    /**
     * 积分抵现规则，支持传入多等级会员规则。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RedeemRule {

        /**
         * 会员为统一等级不用传。
         */
        @JsonProperty("levelId")
        private String levelId;

        /**
         * 积分抵现开关，开启能使用积分抵现，关闭不能使用。必填。
         */
        @JsonProperty("openStatus")
        private Boolean openStatus;

        /**
         * 每满多少积分抵现。必填。
         */
        @JsonProperty("redeemCount")
        private Long redeemCount;

        /**
         * 每满积分抵现多少分钱。必填。
         */
        @JsonProperty("redeemAmount")
        private Long redeemAmount;

        /**
         * 是否开启时间限制，不开启则永久有效。必填。
         */
        @JsonProperty("timeLimit")
        private Boolean timeLimit;

        /**
         * 积分生效时间 ,"2022-07-01 11:11:11"。
         */
        @JsonProperty("effectiveStartTime")
        private String effectiveStartTime;

        /**
         * 积分失效时间, '2022-09-01 11:11:11'。
         */
        @JsonProperty("effectiveEndTime")
        private String effectiveEndTime;

        /**
         * 每天 适用时间段，全天适用不用传。
         */
        @JsonProperty("timeLimitList")
        private List<String> timeLimitList;

        /**
         * 每天不用传，每一周 传周几 例[1,2,3], 每月传多少号 [1,25,23]。
         */
        @JsonProperty("activityCycleList")
        private List<String> activityCycleList;

        /**
         * 每天不用传，活动类型 1：每天，2：每周，3：每月。
         */
        @JsonProperty("activityCycleType")
        private Integer activityCycleType;

        /**
         * 订单最大可抵现积分。
         */
        @JsonProperty("maxRedeemCount")
        private Long maxRedeemCount;

        /**
         * 订单最大可抵现金额，单位分。
         */
        @JsonProperty("maxRedeemAmount")
        private Long maxRedeemAmount;

        /**
         * 订单最大可积分抵现金额比例。
         */
        @JsonProperty("maxRedeemAmountRatio")
        private Integer maxRedeemAmountRatio;

        /**
         * 订单最低积分抵现数量。
         */
        @JsonProperty("minRedeemCount")
        private Long minRedeemCount;

        /**
         * 订单最低积分抵现金额，单位分。
         */
        @JsonProperty("minRedeemAmount")
        private Long minRedeemAmount;
    }
}
