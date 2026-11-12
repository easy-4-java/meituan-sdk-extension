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
public record InventoryQueryResponse(
        @JsonProperty("code") String code,
        @JsonProperty("msg") String msg,
        @JsonProperty("data") String data) {
}
