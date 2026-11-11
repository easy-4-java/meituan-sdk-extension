package io.github.easy4j.meituan.callback.business15.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「品牌会员注册和权益发放」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=15}，消息类型为 {@code msgType=1510003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_jmcard_6a027b3f-818b-484c-b5ef-6b1fe634d0a2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandMemberRegistrationAndRightsMessage {

    /**
     * 本次事件 ID（通过此字段，接口支持请求幂等）。必填。
     */
    @JsonProperty("eventId")
    private Long eventId;

    /**
     * 事件类型： 1-注册并领取权益 2-解绑会员。必填。
     */
    @JsonProperty("eventType")
    private Integer eventType;

    /**
     * 美团用户唯一标识，同一个用户在美团APP和点评APP不一样。必填。
     */
    @JsonProperty("userOpenId")
    private String userOpenId;

    /**
     * 平台。必填。
     */
    @JsonProperty("platformType")
    private String platformType;

    /**
     * 用户领取的权益 ID。必填。
     */
    @JsonProperty("rightId")
    private Long rightId;

    /**
     * 美团会员等级，L1~L6，L1最低，L6最高。必填。
     */
    @JsonProperty("mtLevel")
    private String mtLevel;

    /**
     * 权益明细。
     */
    @JsonProperty("rightDetail")
    private RightDetail rightDetail;

    /**
     * 注册参数。必填。
     */
    @JsonProperty("registParam")
    private RegistParam registParam;

    /**
     * rightDetail。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RightDetail {

        /**
         * 权益开始时间，秒级时间戳（如无，则表示无时间限制）。
         */
        @JsonProperty("rightBeginTime")
        private Long rightBeginTime;

        /**
         * 权益结束时间，秒级时间戳（如无，则表示无时间限制）。
         */
        @JsonProperty("rightEndTime")
        private Long rightEndTime;
    }

    /**
     * registParam。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RegistParam {

        /**
         * 美团内部生成的会员卡号，非品牌方自己内部的会员卡号。
         */
        @JsonProperty("cardNo")
        private String cardNo;

        /**
         * 用户注册时的手机号码，明文数据；若手机号为13111111111，则代表是探测请求， 开发者响应成功且固定返回mock数据即可。
         */
        @JsonProperty("phoneNo")
        private String phoneNo;
    }
}
