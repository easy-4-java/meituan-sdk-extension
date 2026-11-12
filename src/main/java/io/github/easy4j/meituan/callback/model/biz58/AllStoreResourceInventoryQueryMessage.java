package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询全量门店资源库存数据」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810095}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_bbe33bf7-e79c-4a6d-8741-869b0b7b2b29">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllStoreResourceInventoryQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u5168\u91cf\u95e8\u5e97\u8d44\u6e90\u5e93\u5b58\u6570\u636e\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public AllStoreResourceInventoryQueryMessage() {
    }


    /**
     * 查询页数。必填。
     */
    @JsonProperty("pageNumber")
    private Integer pageNumber;

    /**
     * 每页条数。必填。
     */
    @JsonProperty("pageSize")
    private Integer pageSize;
}
