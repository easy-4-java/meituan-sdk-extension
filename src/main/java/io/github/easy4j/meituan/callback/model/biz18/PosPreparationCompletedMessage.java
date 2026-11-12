package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「POS接单-接单页商家点击制作完成」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810017}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_c6f755a8-cb26-46be-956a-c9a247642a2c">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosPreparationCompletedMessage {

    /**
     * 创建\u7f8e\u56e2\u300cPOS\u63a5\u5355-\u63a5\u5355\u9875\u5546\u5bb6\u70b9\u51fb\u5236\u4f5c\u5b8c\u6210\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PosPreparationCompletedMessage() {
    }


    /**
     * 门店机构 ID。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 美团订单Id。
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
     * 取餐状态，固定0-待取餐。
     */
    @JsonProperty("pickupStatus")
    private Integer pickupStatus;
}
