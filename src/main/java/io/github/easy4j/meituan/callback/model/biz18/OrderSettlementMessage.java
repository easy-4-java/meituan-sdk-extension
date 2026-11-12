package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单结算消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18208}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_105942f4-4cdf-4c15-89c5-417f3b77c512">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSettlementMessage {

    /**
     * 已经同步的结账时间,时间戳（单位：毫秒） 代表POS将订单结账时间在该时间点之前的订单数据已经全部上传到云端。必填。
     */
    @JsonProperty("syncedCheckoutTime")
    private Long syncedCheckoutTime;
}
