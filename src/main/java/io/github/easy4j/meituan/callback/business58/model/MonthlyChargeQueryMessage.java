package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「次月扣款查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810239}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_0bb991f6-1aa1-47cb-9322-2b92ae232cf1">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthlyChargeQueryMessage {

    /**
     * 首单订单号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 下月扣费期数。
     */
    @JsonProperty("nextMonth")
    private Integer nextMonth;

    /**
     * 下次消费日期，yyyy-MM-dd格式。
     */
    @JsonProperty("nextConsumeDate")
    private String nextConsumeDate;

    /**
     * 下月最多扣费金额，单位：分。
     */
    @JsonProperty("nextMaxPrice")
    private Long nextMaxPrice;
}
