package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「POS接单-接单页商家点击确认取餐」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810019}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_1675bd8f-12c6-4239-a242-77083e109fc3">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosOrderCollectedMessage {

    /**
     * 门店机构 ID。
     */
    @JsonProperty("orgId")
    private Integer orgId;
    /**
     * 美团门店 ID。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;
    /**
     * 制作状态，固定3-制作完成。
     */
    @JsonProperty("makeStatus")
    private Integer makeStatus;
    /**
     * 订单状态，固定300-已结账。
     */
    @JsonProperty("orderStatus")
    private Integer orderStatus;
    /**
     * 取餐状态，固定1-已取餐。
     */
    @JsonProperty("pickupStatus")
    private Integer pickupStatus;

    /**
     * 创建美团「POS接单-接单页商家点击确认取餐」回调的业务内容。的空实例。
     */
    public PosOrderCollectedMessage() {
    }
}
