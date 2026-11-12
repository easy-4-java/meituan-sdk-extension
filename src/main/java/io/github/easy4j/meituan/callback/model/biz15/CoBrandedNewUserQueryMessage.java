package io.github.easy4j.meituan.callback.model.biz15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员联名卡查询新客」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=15}，消息类型为 {@code invokeType=15101}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_jmcard_64a5fe93-48f2-49ca-86fe-f2a6a19cd172">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoBrandedNewUserQueryMessage {

    /**
     * 创建美团「会员联名卡查询新客」回调的业务内容。的空实例。
     */
    public CoBrandedNewUserQueryMessage() {
    }


    /**
     * 用户注册手机号。必填。
     */
    @JsonProperty("phoneNo")
    private String phoneNo;

    /**
     * 注册平台。必填。
     */
    @JsonProperty("platformType")
    private String platformType;
}
