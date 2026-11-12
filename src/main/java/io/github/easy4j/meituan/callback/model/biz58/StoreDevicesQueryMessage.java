package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询指定门店下全量设备信息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810155}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_18fa357c-fd6f-4a3c-aff7-f891be2c3c92">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDevicesQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u6307\u5b9a\u95e8\u5e97\u4e0b\u5168\u91cf\u8bbe\u5907\u4fe1\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StoreDevicesQueryMessage() {
    }


    /**
     * 美团门店 ID（混淆）。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 每页条数。必填。
     */
    @JsonProperty("pageSize")
    private Integer pageSize;

    /**
     * 查询页数。必填。
     */
    @JsonProperty("pageNo")
    private Integer pageNo;
}
