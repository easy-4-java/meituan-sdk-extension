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
     * 创建\u7f8e\u56e2\u300c\u6839\u636e\u4e8c\u7ef4\u7801URL\u67e5\u8be2\u8bbe\u5907ID\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public DeviceIdByQrCodeQueryMessage() {
    }


    /**
     * 二维码的URL。
     */
    @JsonProperty("url")
    private String url;
}
