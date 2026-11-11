package io.github.easy4j.meituan.callback.business58.model;

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
