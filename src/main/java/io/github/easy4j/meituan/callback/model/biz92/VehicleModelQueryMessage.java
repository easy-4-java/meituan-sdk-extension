package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「售卖车型库查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_caf10bff-4041-45d3-8540-0b7914bb07c3">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleModelQueryMessage {

    /**
     * 增量拉取开始时间戳，格式 {@code yyyy-MM-dd HH:mm:ss}。根据时间区间，获取区间内新增或更新的车型。
     */
    @JsonProperty("updateTimeBegin")
    private String updateTimeBegin;

    /**
     * 增量拉取结束时间戳，格式 {@code yyyy-MM-dd HH:mm:ss}。根据时间区间，获取区间内新增或更新的车型。全量同步时不传。
     */
    @JsonProperty("updateTimeEnd")
    private String updateTimeEnd;

    /**
     * 分页游标。必填。
     */
    @JsonProperty("cursor")
    private Long cursor;

    /**
     * 每页数量，默认 100，最大 500。必填。
     */
    @JsonProperty("pageSize")
    private Long pageSize;
}
