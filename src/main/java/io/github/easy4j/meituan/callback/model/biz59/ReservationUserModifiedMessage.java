package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「用户改约」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910017}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_0d364a1f-64a2-442c-8d9c-20368541ef62">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationUserModifiedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u7528\u6237\u6539\u7ea6\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReservationUserModifiedMessage() {
    }


    /**
     * 预约单号。必填。
     */
    @JsonProperty("leadsId")
    private String leadsId;

    /**
     * 门店 ID。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 联系电话。必填。
     */
    @JsonProperty("phone")
    private String phone;

    /**
     * 联系方式。
     */
    @JsonProperty("otherContact")
    private String otherContact;

    /**
     * 联系方式类型。
     */
    @JsonProperty("otherContactType")
    private String otherContactType;

    /**
     * 来源 ID。必填。
     */
    @JsonProperty("bizSourceId")
    private String bizSourceId;

    /**
     * 预约时间（毫秒数） 注：用户改约接口可以只修改备注，只修改备注时该字段不传。
     */
    @JsonProperty("bookingTime")
    private String bookingTime;

    /**
     * 预约结束时间（毫秒数）。
     */
    @JsonProperty("bookingEndTime")
    private String bookingEndTime;

    /**
     * 预约个数。必填。
     */
    @JsonProperty("count")
    private String count;

    /**
     * 订单关联 ID 列表。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("leadsReferList")
    private JsonNode leadsReferList;

    /**
     * 订单属性map。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("leadsAttributeList")
    private JsonNode leadsAttributeList;

    /**
     * 用户备注。
     */
    @JsonProperty("userRemark")
    private String userRemark;

    /**
     * 用户姓名。
     */
    @JsonProperty("userName")
    private String userName;

    /**
     * 扩展字段。
     */
    @JsonProperty("extraMap")
    private String extraMap;

    /**
     * 是否极速退。
     */
    @JsonProperty("isFastRefund")
    private Boolean isFastRefund;
}
