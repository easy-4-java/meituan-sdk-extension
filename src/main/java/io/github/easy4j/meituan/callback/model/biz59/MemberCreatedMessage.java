package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「创建会员」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910019}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_24aba593-6dfa-4391-9f10-84c3b2c7ea07">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberCreatedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u521b\u5efa\u4f1a\u5458\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MemberCreatedMessage() {
    }


    /**
     * 平台用户 ID。必填。
     */
    @JsonProperty("opUserId")
    private String opUserId;

    /**
     * 用户手机号。必填。
     */
    @JsonProperty("phone")
    private String phone;

    /**
     * 美团门店混淆 ID。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 所属平台。{@code MT} 表示美团，{@code DP} 表示大众点评。必填。
     */
    @JsonProperty("source")
    private String source;

    /**
     * 会员姓名。
     */
    @JsonProperty("name")
    private String name;

    /**
     * 性别。{@code "1"} 表示女，{@code "2"} 表示男。
     */
    @JsonProperty("gender")
    private String gender;

    /**
     * 生日,格式yyyy-MM-dd。
     */
    @JsonProperty("birthday")
    private String birthday;

    /**
     * 开卡时间，{@code yyyy-MM-dd HH:mm:ss}。
     */
    @JsonProperty("registerTime")
    private String registerTime;

    /**
     * 会员卡过期时间，{@code yyyy-MM-dd HH:mm:ss}。
     */
    @JsonProperty("expireDate")
    private String expireDate;

    /**
     * 加密的身份证号。
     */
    @JsonProperty("opIdentityNum")
    private String opIdentityNum;

    /**
     * 请求序列号，异步注册回调时必传。
     */
    @JsonProperty("requestSeq")
    private String requestSeq;
}
