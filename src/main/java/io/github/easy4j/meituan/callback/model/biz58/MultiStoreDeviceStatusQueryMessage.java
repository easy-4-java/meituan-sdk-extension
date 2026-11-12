package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「多门店三方设备号批量查询设备状态」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810161}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_747ad6b5-8cca-4853-b84f-144fedd02750">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiStoreDeviceStatusQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u591a\u95e8\u5e97\u4e09\u65b9\u8bbe\u5907\u53f7\u6279\u91cf\u67e5\u8be2\u8bbe\u5907\u72b6\u6001\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MultiStoreDeviceStatusQueryMessage() {
    }


    /**
     * 三方设备 ID 列表。必填。
     */
    @JsonProperty("thirdPartyDeviceItemIds")
    private List<String> thirdPartyDeviceItemIds;
}
