package io.github.easy4j.meituan.callback.model.biz7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「推送桌型桌位&amp;规则&amp;库存变更通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=7}，消息类型为 {@code msgType=710014}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_resv2_9eb4d57f-7159-40bd-ba43-cef4d82c09ce">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableRulesAndInventoryChangedMessage {

    /**
     * 创建美团「推送桌型桌位&amp;规则&amp;库存变更通知」回调的业务内容。的空实例。
     */
    public TableRulesAndInventoryChangedMessage() {
    }


    /**
     * true-需要拉数据。必填。
     */
    @JsonProperty("needPull")
    private Boolean needPull;

    /**
     * 1-桌型桌位 2-库存 3-规则。必填。
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * type为2时必填。
     */
    @JsonProperty("day")
    private Integer day;
}
