package io.github.easy4j.meituan.callback.business49.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「用户取号」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=49}，消息类型为 {@code msgType=4910001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_dcpd_5dcead14-465f-40ba-9120-e3566cea7968">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueueTicketIssuedMessage {

    /**
     * 美团排队订单 ID。必填。
     */
    @JsonProperty("orderViewId")
    private String orderViewId;

    /**
     * 桌型 ID。必填。
     */
    @JsonProperty("tableTypeId")
    private Integer tableTypeId;

    /**
     * 人数。必填。
     */
    @JsonProperty("peopleCount")
    private Integer peopleCount;

    /**
     * 备注。
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * 手机号(加密)。已加密，请通过合作中心获取解密密钥。
     */
    @JsonProperty("mobile")
    private String mobile;
}
