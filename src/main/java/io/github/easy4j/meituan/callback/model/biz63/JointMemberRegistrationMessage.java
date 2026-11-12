package io.github.easy4j.meituan.callback.model.biz63;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「联合会员-注册会员」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=63}，消息类型为 {@code msgType=6310002}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_mtcdb_1e66e50a-4f85-4a2b-a039-4ed6c1152723">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JointMemberRegistrationMessage {

    /**
     * 手机号。必填。
     */
    @JsonProperty("mobile")
    private String mobile;
    /**
     * 会员名称。必填。
     */
    @JsonProperty("name")
    private String name;
    /**
     * 商场或者门店标识。
     */
    @JsonProperty("poiId")
    private String poiId;

    /**
     * 创建美团「联合会员-注册会员」回调的业务内容。的空实例。
     */
    public JointMemberRegistrationMessage() {
    }
}
