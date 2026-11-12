package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「根据二维码URL查询设备ID」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_f75bf731-c6fb-42fe-aa1b-597ebedddbc9">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceIdByQrCodeQueryResult {

    /**
     * 三方设备ID，设备在商家侧的唯一标识。必填。
     */
    @JsonProperty("thirdPartyDeviceItemId")
    private String thirdPartyDeviceItemId;

    /**
     * 三方子设备ID，仅在存在主子两级设备时传递。
     */
    @JsonProperty("thirdPartyDeviceSubItemId")
    private String thirdPartyDeviceSubItemId;
}
