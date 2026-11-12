package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商场积分交易事件推送」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_e2e9abe0-68f2-48e7-bcce-e6dcacc978c5">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MallPointsTransactionPushedResult {

    /**
     * 积分事务是否成功。必填。
     */
    @JsonProperty("transactionSuccess")
    private Boolean transactionSuccess;

    /**
     * 积分事务失败原因。
     */
    @JsonProperty("transactionFailReason")
    private String transactionFailReason;

    /**
     * 积分事务时间（毫秒时间戳）。必填。
     */
    @JsonProperty("transactionTime")
    private Long transactionTime;

    /**
     * 积分事务类型（1-增加 2-扣减)。必填。
     */
    @JsonProperty("transactionType")
    private Integer transactionType;

    /**
     * 积分数（正数）。支持小数，按double解析。必填。
     */
    @JsonProperty("points")
    private String points;

    /**
     * 积分过期时间(毫秒时间戳)。
     */
    @JsonProperty("expiryDate")
    private Long expiryDate;
}
