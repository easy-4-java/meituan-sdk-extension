package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询活动场次参与人接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910103}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_a7fabe92-48c6-4922-9575-f947a6d5e9dc">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubActivityParticipantsQueriedMessage {

    /**
     * 创建美团「查询活动场次参与人接口」回调的业务内容。的空实例。
     */
    public ClubActivityParticipantsQueriedMessage() {
    }


    /**
     * 三方活动Id。必填。
     */
    @JsonProperty("activityId")
    private String activityId;

    /**
     * 三方商品Id。必填。
     */
    @JsonProperty("productId")
    private String productId;

    /**
     * 三方SkuId。必填。
     */
    @JsonProperty("skuId")
    private String skuId;
}
