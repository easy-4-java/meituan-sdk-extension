package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「改约提交」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810015}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_ebd8fc97-8ff0-4d77-b438-b86aaa5bf818">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationChangeSubmittedMessage {

    /**
     * 平台订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 平台商品 ID。必填。
     */
    @JsonProperty("productId")
    private String productId;

    /**
     * 产品名称。必填。
     */
    @JsonProperty("productName")
    private String productName;

    /**
     * 预约结束时间，格式如 2016-05-24 12:00。必填。
     */
    @JsonProperty("reserveEndtime")
    private String reserveEndtime;

    /**
     * 预约起始时间，格式如 2016-05-24 12:00。必填。
     */
    @JsonProperty("reserveBegintime")
    private String reserveBegintime;

    /**
     * 用户地址。
     */
    @JsonProperty("userAddress")
    private String userAddress;

    /**
     * 用户姓名。
     */
    @JsonProperty("userName")
    private String userName;

    /**
     * 备注。
     */
    @JsonProperty("remarks")
    private String remarks;

    /**
     * 是否需要送件。
     */
    @JsonProperty("needDelivery")
    private String needDelivery;

    /**
     * 送件电话（出于对用户隐私的保护，该字段后续会被废弃，对接时请使用deliveryPhone字段）。
     */
    @JsonProperty("deliveryMobile")
    private String deliveryMobile;

    /**
     * 送件地址。
     */
    @JsonProperty("deliveryAdress")
    private String deliveryAdress;

    /**
     * 送件联系人姓名。
     */
    @JsonProperty("deliveryUser")
    private String deliveryUser;

    /**
     * 预约电话（出于对用户隐私的保护，该字段后续会被废弃，对接时请使用reservePhone字段）。必填。
     */
    @JsonProperty("reserveMobile")
    private String reserveMobile;

    /**
     * 平台，1-大众点评，2-美团。必填。
     */
    @JsonProperty("platform")
    private String platform;

    /**
     * 业务类型，2-家政、洗涤、维修。必填。
     */
    @JsonProperty("bizType")
    private String bizType;

    /**
     * userAddress的纬度。必填。
     */
    @JsonProperty("addressLatitude")
    private String addressLatitude;

    /**
     * userAddress的经度。必填。
     */
    @JsonProperty("addressLongitude")
    private String addressLongitude;

    /**
     * deliveryAddress的纬度。
     */
    @JsonProperty("deliveryLatitude")
    private String deliveryLatitude;

    /**
     * deliveryAddress的经度。
     */
    @JsonProperty("deliveryLongitude")
    private String deliveryLongitude;

    /**
     * 送件电话，如果顾客开启隐私保护则是掩码手机号，未开启则是完整手机号。如需获取完整手机号，可通过用户隐私号查询接口获取。
     */
    @JsonProperty("deliveryPhone")
    private String deliveryPhone;

    /**
     * 送件电话顾客是否选择号码隐私保护。1:开启隐私保护 0：未选择隐私保护。
     */
    @JsonProperty("useDeliveryVirtualNumber")
    private String useDeliveryVirtualNumber;

    /**
     * 预约电话，如果顾客开启隐私保护则是掩码手机号，未开启则是完整手机号。如需获取完整手机号，可通过用户隐私号查询接口获取。必填。
     */
    @JsonProperty("reservePhone")
    private String reservePhone;

    /**
     * 预约电话顾客是否选择号码隐私保护。1:开启隐私保护 0：未选择隐私保护。必填。
     */
    @JsonProperty("useReceiverVirtualNumber")
    private String useReceiverVirtualNumber;

    /**
     * 用户修改指定服务人员 ID，不指定是0（仅接入指定保洁服务人员相关门店的改约请求会传递该字段）。
     */
    @JsonProperty("advServiceTechId")
    private String advServiceTechId;
}
