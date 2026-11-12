package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「押金解冻结果回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210040}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_518ff9a5-7a8d-4ec5-b3b6-e5d76defbb47">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositUnfreezeResultMessage {

    /**
     * 美团订单号。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;
    /**
     * 供应商订单号。必填。
     */
    @JsonProperty("thirdOrderId")
    private Long thirdOrderId;
    /**
     * 商家解冻流水。
     */
    @JsonProperty("thirdUnfreezeId")
    private String thirdUnfreezeId;
    /**
     * 美团解冻流水。必填。
     */
    @JsonProperty("mtUnfreezeId")
    private String mtUnfreezeId;
    /**
     * 解冻结果发起方 PARTNER-商家主动发起， MT-美团兜底解冻。必填。
     */
    @JsonProperty("source")
    private String source;
    /**
     * 解冻类型。必填。
     */
    @JsonProperty("type")
    private String type;
    /**
     * 解冻金额。必填。
     */
    @JsonProperty("amount")
    private Integer amount;
    /**
     * 解冻时间。必填。
     */
    @JsonProperty("time")
    private String time;

    /**
     * 创建美团「押金解冻结果回调」回调的业务内容。的空实例。
     */
    public DepositUnfreezeResultMessage() {
    }
}
