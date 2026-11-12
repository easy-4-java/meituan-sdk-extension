package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「查询通话记录（对账或补偿使用）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910071}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_ee50457f-2740-4256-8dcd-73e95e42c8dc">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallRecordsQueriedMessage {

    /**
     * 创建美团「查询通话记录（对账或补偿使用）」回调的业务内容。的空实例。
     */
    public CallRecordsQueriedMessage() {
    }


    /**
     * 开始时间，格式yyyyMMddhhmmss。必填。
     */
    @JsonProperty("startTime")
    private String startTime;

    /**
     * 结束时间。必填。
     */
    @JsonProperty("endTime")
    private String endTime;

    /**
     * 每批数量，最多100。必填。
     */
    @JsonProperty("limit")
    private String limit;

    /**
     * 页数，从1开始。必填。
     */
    @JsonProperty("page")
    private String page;

    /**
     * 400主机号。
     */
    @JsonProperty("tel")
    private String tel;

    /**
     * 400分机号。
     */
    @JsonProperty("subtel")
    private String subtel;

    /**
     * 扩展参数map 类型。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("extParam")
    private JsonNode extParam;
}
