package io.github.easy4j.meituan.callback.model.biz1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店授权信息同步」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1}，消息类型为 {@code msgType=110019}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_tuangoung_33cda1bb-6a24-473e-b1b0-a3c869024e39">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreAuthorizationSyncMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u95e8\u5e97\u6388\u6743\u4fe1\u606f\u540c\u6b65\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StoreAuthorizationSyncMessage() {
    }


    /**
     * 门店code。必填。
     */
    @JsonProperty("vendorShopId")
    private String vendorShopId;

    /**
     * 操作类型：1-门店授权。必填。
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * yyyy-mm-dd hh:mm:ss。
     */
    @JsonProperty("time")
    private String time;
}
