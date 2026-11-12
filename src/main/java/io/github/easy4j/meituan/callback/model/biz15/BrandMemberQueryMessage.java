package io.github.easy4j.meituan.callback.model.biz15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询品牌会员信息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=15}，消息类型为 {@code msgType=1510001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_jmcard_50cf570c-91a8-4ddc-a572-8d644f92febd">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandMemberQueryMessage {

    /**
     * 用户手机号。必填。
     */
    @JsonProperty("phoneNo")
    private String phoneNo;
}
