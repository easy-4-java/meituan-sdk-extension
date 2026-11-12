package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「根据二维码URL查询设备ID」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810151}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_f75bf731-c6fb-42fe-aa1b-597ebedddbc9">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceIdByQrCodeQueryMessage {

    /**
     * 二维码的URL。
     */
    @JsonProperty("url")
    private String url;


    /**
     * 创建美团「根据二维码URL查询设备ID」回调的业务内容。的空实例。
     */
    public DeviceIdByQrCodeQueryMessage() {
    }
}
