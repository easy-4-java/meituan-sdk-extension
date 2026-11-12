package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「查询单个门店下指定设备状态」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810153}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_8fd1159c-e946-4749-8b3d-787f8e3f7143">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDeviceStatusQueryMessage {

    /**
     * 客户方设备 ID 列表。必填。
     */
    @JsonProperty("thirdPartyDeviceItemIds")
    private List<String> thirdPartyDeviceItemIds;
    /**
     * 美团门店 ID（混淆）。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 创建美团「查询单个门店下指定设备状态」回调的业务内容。的空实例。
     */
    public StoreDeviceStatusQueryMessage() {
    }
}
