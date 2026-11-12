package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「菜品沽清消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810079}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_2e05df35-5662-4b0a-83a2-df717f7337d5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DishSoldOutMessage {

    /**
     * 门店 ID。必填。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 菜品SKU。必填。
     */
    @JsonProperty("skuId")
    private Long skuId;

    /**
     * 可售卖数量。必填。
     */
    @JsonProperty("quantity")
    private String quantity;
}
