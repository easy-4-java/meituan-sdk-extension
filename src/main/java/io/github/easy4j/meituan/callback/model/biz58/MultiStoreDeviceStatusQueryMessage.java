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
     * 三方设备 ID 列表。必填。
     */
    @JsonProperty("thirdPartyDeviceItemIds")
    private List<String> thirdPartyDeviceItemIds;
}
