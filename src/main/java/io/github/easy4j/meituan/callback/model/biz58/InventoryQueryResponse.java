package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 服务零售单个查询库存、批量获取库存的回执。
 *
 * @param code 字符串返回码，单个查询成功为 {@code OP_SUCCESS}，批量获取成功为 {@code 0}
 * @param msg 返回信息说明，可为空
 * @param data 库存明细列表的 JSON 字符串
 * @see InventoryQueryResult
 * @see BatchInventoryQueryResult
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.EqualsAndHashCode
public final class InventoryQueryResponse {
    @com.fasterxml.jackson.annotation.JsonProperty("code")
    private final String code;
    @com.fasterxml.jackson.annotation.JsonProperty("msg")
    private final String msg;
    @com.fasterxml.jackson.annotation.JsonProperty("data")
    private final String data;

    @com.fasterxml.jackson.annotation.JsonCreator
    public InventoryQueryResponse(@com.fasterxml.jackson.annotation.JsonProperty("code") String code, @com.fasterxml.jackson.annotation.JsonProperty("msg") String msg, @com.fasterxml.jackson.annotation.JsonProperty("data") String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public String data() {
        return data;
    }
}
