package io.github.easy4j.meituan.callback.model.biz77;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=77}，消息类型为 {@code msgType=7710001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_kmmsaas_b6276d27-4963-4629-8279-49dfaec9ff17">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderNotificationMessage {

    /**
     * 变更类型。
     */
    @JsonProperty("changeType")
    private Integer changeType;

    /**
     * 17820103131。
     */
    @JsonProperty("changeTime")
    private Long changeTime;

    /**
     * 门店 ID。
     */
    @JsonProperty("shopID")
    private Integer shopID;

    /**
     * 订单 ID。
     */
    @JsonProperty("orderID")
    private Long orderID;

    /**
     * 订单展示编号。
     */
    @JsonProperty("orderDisplayID")
    private Long orderDisplayID;

    /**
     * 订单类型。
     */
    @JsonProperty("orderType")
    private Integer orderType;

    /**
     * 订单来源。
     */
    @JsonProperty("orderSource")
    private Integer orderSource;

    /**
     * 订单状态。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 订单总价。
     */
    @JsonProperty("totalAmount")
    private Double totalAmount;

    /**
     * 订单实收。
     */
    @JsonProperty("payAmount")
    private Double payAmount;

    /**
     * 会员 ID。
     */
    @JsonProperty("memberId")
    private Long memberId;

    /**
     * 创建订单时间。
     */
    @JsonProperty("createOrderTime")
    private Long createOrderTime;
}
