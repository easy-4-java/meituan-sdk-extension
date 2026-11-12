package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「POS接单-接单页商家点击开始制作」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810015}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_437ad66b-818d-400c-8ed3-3939326b15fd">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosPreparationStartedMessage {

    /**
     * 门店机构 ID。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 美团订单 ID。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 制作状态，固定为2-制作中。
     */
    @JsonProperty("makeStatus")
    private Integer makeStatus;

    /**
     * 订单状态，固定300-已结账。
     */
    @JsonProperty("orderStatus")
    private Integer orderStatus;

    /**
     * 取餐状态，固定0-待取餐。
     */
    @JsonProperty("pickupStatus")
    private Integer pickupStatus;
}
