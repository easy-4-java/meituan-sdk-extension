package io.github.easy4j.meituan.callback.model.biz55;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「活动变更通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=55}，消息类型为 {@code msgType=5510001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_freetryopen_da0cca39-5099-452f-9d9b-c9bb632c0a81">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityChangeNoticeMessage {

    /**
     * 变更的活动 ID。必填。
     */
    @JsonProperty("activityId")
    private Long activityId;
}
