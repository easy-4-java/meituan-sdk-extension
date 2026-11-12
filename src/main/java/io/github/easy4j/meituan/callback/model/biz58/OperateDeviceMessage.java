package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「操作设备」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810149}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_12820d14-4867-46b5-b527-210c123fc5e9">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperateDeviceMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u64cd\u4f5c\u8bbe\u5907\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OperateDeviceMessage() {
    }


    /**
     * 请求唯一标识。必填。
     */
    @JsonProperty("requestId")
    private String requestId;

    /**
     * 13位毫秒级时间戳，为美团侧发起请求的时间。必填。
     */
    @JsonProperty("timestamp")
    private Long timestamp;

    /**
     * 美团券 ID。必填。
     */
    @JsonProperty("couponId")
    private String couponId;

    /**
     * 三方侧设备唯一标识（用于系统内部处理）。必填。
     */
    @JsonProperty("thirdPartyDeviceItemId")
    private String thirdPartyDeviceItemId;

    /**
     * 期望进行的操作：1 继续/resume 2 暂停/pause。必填。
     */
    @JsonProperty("operationkey")
    private Integer operationkey;
}
