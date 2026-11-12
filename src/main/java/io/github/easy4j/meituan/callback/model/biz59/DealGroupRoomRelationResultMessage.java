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
     * 创建\u7f8e\u56e2\u300c\u6279\u91cf\u63a8\u9001\u56e2\u8d2d\u5173\u8054\u5305\u578b\u5305\u95f4\u7ed3\u679c\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
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
