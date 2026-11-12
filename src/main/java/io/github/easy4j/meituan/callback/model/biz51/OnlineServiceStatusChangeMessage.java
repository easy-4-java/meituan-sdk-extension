package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「美团通知品牌方门店“线上点”营业状态变更【回调】（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_ac21784a-7718-4ab3-9a41-2ea7eafa6fca">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OnlineServiceStatusChangeMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u7f8e\u56e2\u901a\u77e5\u54c1\u724c\u65b9\u95e8\u5e97\u201c\u7ebf\u4e0a\u70b9\u201d\u8425\u4e1a\u72b6\u6001\u53d8\u66f4\u3010\u56de\u8c03\u3011\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OnlineServiceStatusChangeMessage() {
    }


    /**
     * 厂商门店 ID。必填。
     */
    @JsonProperty("vendorShopId")
    private String vendorShopId;

    /**
     * 操作人。必填。
     */
    @JsonProperty("operator")
    private String operator;

    /**
     * 操作原因。必填。
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * 线上点服务开关。必填。
     */
    @JsonProperty("vendorServiceOpen")
    private Integer vendorServiceOpen;

    /**
     * 操作时间。必填。
     */
    @JsonProperty("updateTime")
    private Long updateTime;
}
