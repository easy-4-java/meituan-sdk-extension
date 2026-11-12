package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询会员级别」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910021}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/biz/biz_2023243_60a4ed73-41f8-40ea-bdc0-1d9a3a8922e1">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberLevelQueriedMessage {

    /**
     * 创建美团「查询会员级别」回调的业务内容。的空实例。
     */
    public MemberLevelQueriedMessage() {
    }


    /**
     * 会员卡号。
     */
    @JsonProperty("memberCard")
    private String memberCard;

    /**
     * 平台用户 ID（混淆ID）。
     */
    @JsonProperty("opUserId")
    private String opUserId;

    /**
     * 所属平台。
     */
    @JsonProperty("source")
    private Integer source;
}
