package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「批量推送团购关联包型包间结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910147}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_aab66160-8538-4012-b55c-d8fe95651fa5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealGroupRoomRelationResultMessage {

    /**
     * 创建美团「批量推送团购关联包型包间结果通知」回调的业务内容。的空实例。
     */
    public DealGroupRoomRelationResultMessage() {
    }


    /**
     * 推送是否成功。必填。
     */
    @JsonProperty("success")
    private Boolean success;

    /**
     * 失败信息。
     */
    @JsonProperty("errMsg")
    private String errMsg;

    /**
     * 团购 ID。必填。
     */
    @JsonProperty("dealGroupId")
    private Long dealGroupId;

    /**
     * 门店 ID 列表。必填。
     */
    @JsonProperty("opPoiIds")
    private List<String> opPoiIds;
}
