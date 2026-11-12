package io.github.easy4j.meituan.callback.model.biz1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店代金券买单设置变更」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1}，消息类型为 {@code msgType=110021}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_tuangoung_0c32a6c8-7f01-44d8-8b1b-65b769db8ddb">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreVoucherPaymentSettingsChangedMessage {

    /**
     * 门店 ID。必填。
     */
    @JsonProperty("poiId")
    private Long poiId;

    /**
     * 变更内容。必填。
     */
    @JsonProperty("changes")
    private List<String> changes;

    /**
     * 变更时间。必填。
     */
    @JsonProperty("operateTime")
    private Long operateTime;
}
