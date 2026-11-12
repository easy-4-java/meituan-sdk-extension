package io.github.easy4j.meituan.callback.model.biz87;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开票状态结果查询接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=87}，消息类型为 {@code msgType=8710003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_enterprise_9d722132-f26b-40a4-ac3c-210aacf67afa">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceStatusQueryMessage {

    /**
     * 创建美团「开票状态结果查询接口」回调的业务内容。的空实例。
     */
    public InvoiceStatusQueryMessage() {
    }


    /**
     * 开票申请 id。必填。
     */
    @JsonProperty("applyId")
    private String applyId;

    /**
     * 商家门店唯一键。
     */
    @JsonProperty("shopUniqueKey")
    private String shopUniqueKey;

    /**
     * 门店类型 0到餐，1外卖。
     */
    @JsonProperty("bizType")
    private String bizType;
}
