package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「预约单操作结果同步」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910135}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_195769d5-876b-49dc-aecc-a12d8aeef8f4">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationOperationResultSyncMessage {

    /**
     * 创建美团「预约单操作结果同步」回调的业务内容。的空实例。
     */
    public ReservationOperationResultSyncMessage() {
    }


    /**
     * 预约单 ID。必填。
     */
    @JsonProperty("leadsId")
    private Integer leadsId;

    /**
     * 消息类型1：预约下单（针对预约同步第三方消息，包含自动确认，标识该同步流程是否成功） 5：拒单（需要手动确认接单时，
     * 拒单时或超时系统自动拒单时的处理结果） 6：接单 （需要手动确认接单时，同意接单时的处理结果） 3：改约 （针对用户改约同步第三方，包含自动确认，
     * 标识该同步流程是否成功） 7：改约确认 （针对需改约手动确认时同意改约并同步美团，
     * 标识该同步流程是否成功） 8：改约拒绝（针对需改约手动确认时拒绝改约并同步美团，标识该同步流程是否成功） 2：取消预约 （针对用户取消预约同步第三方，
     * 包含自动确认，标识该同步流程是否成功） 9：取消预约确认 （针对需取消预约手动确认时同意取消并同步美团，
     * 标识该同步流程是否成功） 10：取消预约拒绝（针对需取消预约手动确认时拒绝取消并同步美团，
     * 标识该同步流程是否成功） 11：到店履约（用户到店履约处理结果）。必填。
     */
    @JsonProperty("messageType")
    private Integer messageType;

    /**
     * 处理结果： 0：成功 1：失败。必填。
     */
    @JsonProperty("result")
    private Integer result;

    /**
     * 混淆的预约门店 ID。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;
}
