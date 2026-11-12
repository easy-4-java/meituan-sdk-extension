package io.github.easy4j.meituan.callback.model.biz63;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「联合会员-查询会员」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=63}，消息类型为 {@code msgType=6310000}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_mtcdb_8917e0cb-f07e-4212-93e9-19cfad77c319">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JointMemberQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8054\u5408\u4f1a\u5458-\u67e5\u8be2\u4f1a\u5458\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public JointMemberQueryMessage() {
    }


    /**
     * 手机号。必填。
     */
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 商场或者门店标识。
     */
    @JsonProperty("poiId")
    private String poiId;
}
