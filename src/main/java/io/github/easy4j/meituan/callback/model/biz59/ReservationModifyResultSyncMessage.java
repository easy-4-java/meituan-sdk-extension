package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「改约结果同步三方」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_28cd1684-804f-4ce5-b2f3-b8dfc6f3373e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationModifyResultSyncMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u6539\u7ea6\u7ed3\u679c\u540c\u6b65\u4e09\u65b9\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReservationModifyResultSyncMessage() {
    }


    /**
     * 预约单 ID。必填。
     */
    @JsonProperty("leadsId")
    private String leadsId;

    /**
     * 美团门店 ID，该字段是混淆字段，实际值类型为混淆后的字符串类型。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 接单结果：1.同意改约 2.拒绝改约。
     */
    @JsonProperty("result")
    private String result;

    /**
     * 扩展字段。
     */
    @JsonProperty("extraMap")
    private String extraMap;
}
