package io.github.easy4j.meituan.callback.model.biz71;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「审核结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=71}，消息类型为 {@code msgType=7110001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_mendianzhilian_2f16b69e-de3b-4f19-a24b-7c38f9bdc40f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreAuditResultMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5ba1\u6838\u7ed3\u679c\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StoreAuditResultMessage() {
    }


    /**
     * 请求 ID。必填。
     */
    @JsonProperty("reqId")
    private Long reqId;

    /**
     * 响应代码。必填。
     */
    @JsonProperty("code")
    private Integer code;

    /**
     * 响应代码说明。必填。
     */
    @JsonProperty("msg")
    private String msg;

    /**
     * 响应数据:创建门店成功时是美团门店 ID；更新门店时是每个字段的审核结果。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("data")
    private JsonNode data;
}
