package io.github.easy4j.meituan.callback.model.biz19;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店状态回调」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=19}，消息类型为 {@code msgType=19103}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_peisong_c64b17b7-865c-4674-b063-d00c2a2e178a">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreStatusMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u95e8\u5e97\u72b6\u6001\u56de\u8c03\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StoreStatusMessage() {
    }


    /**
     * 门店名称。必填。
     */
    @JsonProperty("shop_name")
    private String shopName;

    /**
     * 取货门店 ID。必填。
     */
    @JsonProperty("shop_id")
    private String shopId;

    /**
     * 门店状态。必填。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 驳回原因。
     */
    @JsonProperty("reject_message")
    private String rejectMessage;
}
