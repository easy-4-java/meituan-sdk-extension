package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 服务零售单个查询库存、批量获取库存的回执。
 *
 * @see InventoryQueryResult
 * @see BatchInventoryQueryResult
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.EqualsAndHashCode
public final class InventoryQueryResponse {
    /**
     * 协议规定的处理结果码。
     */
    @com.fasterxml.jackson.annotation.JsonProperty("code")
    private final String code;
    /**
     * 协议规定的结果说明。
     */
    @com.fasterxml.jackson.annotation.JsonProperty("msg")
    private final String msg;
    /**
     * 按接口协议编码的业务数据。
     */
    @com.fasterxml.jackson.annotation.JsonProperty("data")
    private final String data;

    /**
     * 创建当前类的实例。
     *
     * @param code 字符串返回码，单个查询成功为 {@code OP_SUCCESS}，批量获取成功为 {@code 0}
     * @param msg 返回信息说明，可为空
     * @param data 库存明细列表的 JSON 字符串
     */
    @com.fasterxml.jackson.annotation.JsonCreator
    public InventoryQueryResponse(@com.fasterxml.jackson.annotation.JsonProperty("code") String code, @com.fasterxml.jackson.annotation.JsonProperty("msg") String msg, @com.fasterxml.jackson.annotation.JsonProperty("data") String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 读取协议规定的处理结果码。
     *
     * @return 读取协议规定的处理结果码的结果
     */
    public String code() {
        return code;
    }

    /**
     * 读取协议规定的结果说明。
     *
     * @return 读取协议规定的结果说明的结果
     */
    public String msg() {
        return msg;
    }

    /**
     * 读取按接口协议编码的业务数据。
     *
     * @return 读取按接口协议编码的业务数据的结果
     */
    public String data() {
        return data;
    }
}
