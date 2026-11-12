package io.github.easy4j.meituan.callback.model.biz3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 闪惠接收订单推送的回执。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_shanhuing_164350be-4000-43c9-ac87-892c907749c3">闪惠接收订单推送</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.EqualsAndHashCode
public final class FlashOrderAcknowledgement {
    /**
     * 按接口协议编码的业务数据。
     */
    @com.fasterxml.jackson.annotation.JsonProperty("data")
    private final String data;

    /**
     * 创建当前类的实例。
     *
     * @param data 成功接收订单时固定为 {@code ok}
     */
    @com.fasterxml.jackson.annotation.JsonCreator
    public FlashOrderAcknowledgement(@com.fasterxml.jackson.annotation.JsonProperty("data") String data) {
        this.data = data;
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
