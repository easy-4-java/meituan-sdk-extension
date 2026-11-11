package io.github.easy4j.meituan.callback.business2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收用户修改订单信息消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210077}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_1d0bc162-bc48-47d0-aed1-3081c5e87846">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInformationChangedMessage {

    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 用户发起ETA修改申请时间。
     */
    @JsonProperty("uetaCtime")
    private Integer uetaCtime;

    /**
     * 申请修改的ETA时间。
     */
    @JsonProperty("uetaTime")
    private Integer uetaTime;

    /**
     * 截止时间（秒级时间戳），目前限制30分钟。
     */
    @JsonProperty("uetaExpire")
    private Integer uetaExpire;

    /**
     * eta修改结果状态。1.申请，2.通过，3.商家拒绝，4.超时未处理，5.订单完成或取消自动拒绝， 6.订单处于退款中自动拒绝，
     *  7.商家点击平台原因拒绝（骑手已接单、骑手已到店、骑手已取餐、骑手已送达），8.商家点击平台原因拒绝（跑腿自动锁单状态），
     * 9.商家点击平台原因拒绝（专人直送）。
     */
    @JsonProperty("uetaStatus")
    private Integer uetaStatus;

    /**
     * 修改前订单流水号。
     */
    @JsonProperty("historyDaySeq")
    private Integer historyDaySeq;

    /**
     * 修改后订单流水号。
     */
    @JsonProperty("daySeq")
    private Integer daySeq;

    /**
     * 修改信息内容，1-修改预计送达时间、2-修改顾客信息（地址、姓名、电话）；修改地址时，可能会带着修改预计送达时一起修改，则接口返回1,2。
     */
    @JsonProperty("opType")
    private String opType;
}
