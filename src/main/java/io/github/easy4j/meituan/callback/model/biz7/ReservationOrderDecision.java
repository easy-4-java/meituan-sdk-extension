package io.github.easy4j.meituan.callback.model.biz7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「推送新订单」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_resv2_2db30e48-c7a1-4c08-b234-65ebf8e6638f">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationOrderDecision {

    /**
     * 创建美团「推送新订单」回调的业务响应。的空实例。
     */
    public ReservationOrderDecision() {
    }


    /**
     * 新订单。1 - 接单；2 - 拒单；3 - 稍后处理。必填。
     */
    @JsonProperty("result")
    private Integer result;

    /**
     * 拒单原因。可选，1 - 没有匹配的桌型；2 - 该桌型已订满；3 - 不在可预订时间内；4 - 备注无法满足；5 - 其他原因。
     */
    @JsonProperty("rejectReason")
    private Integer rejectReason;

    /**
     * 其他拒单原因说明。
     */
    @JsonProperty("otherReason")
    private String otherReason;

    /**
     * 桌位id列表。result=1接单时需返回桌位id，多桌位接单时逗号(英文)分隔。
     */
    @JsonProperty("tableId")
    private String tableId;

    /**
     * 接单时返回的桌位名称，与 tableId 中的桌位对应。
     */
    @JsonProperty("tableName")
    private String tableName;

    /**
     * 锁台开始时间。Unix时间戳(秒)，result=1时需返回。
     */
    @JsonProperty("startTime")
    private Integer startTime;

    /**
     * 锁台结束时间。Unix时间戳(秒)，result=1时需返回。
     */
    @JsonProperty("endTime")
    private Integer endTime;
}
