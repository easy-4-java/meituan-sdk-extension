package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 美团「接收门店信息变更消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=46}，消息类型为 {@code msgType=4610023}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_dcps_7eec9ee3-9b57-451a-aaf9-ccd574dbecdf">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoiInfoChangedMessage {

    /**
     * 具体变更详情。
     */
    @JsonProperty("detail")
    private String detail;

    /**
     * 门店 ID。
     */
    @JsonProperty("poiId")
    private Integer poiId;

    /**
     * 官网标量示例中的原始文本；按字段表推送对象时为空。
     */
    @JsonIgnore
    private String textValue;

    /**
     * 读取平台以单个 JSON 字符串推送的门店变更消息。
     *
     * @param textValue 标量消息解码后的文本
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING) public PoiInfoChangedMessage(String textValue) {
        this.textValue = textValue;
    }
}
