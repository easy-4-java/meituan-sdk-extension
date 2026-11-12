package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店列表查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210001}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_b7e2df61-29e4-4e11-8fe6-85527aadecaf">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreListQueryMessage {

    /**
     * 城市行政区划代码（6位）。传入时只返回该城市下的门店；不传时返回供应商所有门店。建议按城市逐个拉取，避免单次返回数据量过大。
     */
    @JsonProperty("cityCode")
    private String cityCode;

    /**
     * 商家门店code列表，不传查全量。
     */
    @JsonProperty("thirdStoreCodes")
    private List<String> thirdStoreCodes;

    /**
     * 增量拉取开始时间戳，格式 {@code yyyy-MM-dd HH:mm:ss}。根据时间区间，获取区间内新增或更新的门店。
     */
    @JsonProperty("updateTimeBegin")
    private String updateTimeBegin;

    /**
     * 增量拉取结束时间戳，格式 {@code yyyy-MM-dd HH:mm:ss}。根据时间区间，获取区间内新增或更新的门店。全量同步时不传。
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
