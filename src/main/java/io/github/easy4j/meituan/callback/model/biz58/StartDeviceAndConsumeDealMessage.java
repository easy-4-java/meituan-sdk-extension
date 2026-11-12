package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「启动设备并核销团单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810147}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_6ea4ba3a-a2c7-4e18-a897-c5c2ee96c47c">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartDeviceAndConsumeDealMessage {

    /**
     * 请求唯一标识。必填。
     */
    @JsonProperty("requestId")
    private String requestId;

    /**
     * 三方设备 ID。必填。
     */
    @JsonProperty("thirdPartyDeviceItemId")
    private String thirdPartyDeviceItemId;

    /**
     * 美团券 ID。必填。
     */
    @JsonProperty("couponId")
    private String couponId;

    /**
     * 用户手机号。
     */
    @JsonProperty("phone")
    private String phone;
}
