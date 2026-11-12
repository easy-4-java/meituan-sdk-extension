package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询指定门店资源库存」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_d2731034-87f5-4602-8c51-84222eb85227">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreResourceInventoryQueryResult {

    /**
     * 三方门店id。必填。
     */
    @JsonProperty("thirdPartPoiId")
    private Long thirdPartPoiId;

    /**
     * 美团门店id（混淆）。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 当前门店球桌总数。必填。
     */
    @JsonProperty("totalBallTableNum")
    private Integer totalBallTableNum;

    /**
     * 当前门店可用球桌数。必填。
     */
    @JsonProperty("availableBallTableNum")
    private Integer availableBallTableNum;

    /**
     * 桌信息列表。必填。
     */
    @JsonProperty("ballTableInfoBOS")
    private List<BallTableInfoBO> ballTableInfoBOS;

    /**
     * 桌信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BallTableInfoBO {

        /**
         * 球桌id。必填。
         */
        @JsonProperty("id")
        private Long id;

        /**
         * 球桌名称。必填。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 球桌状态：1-空闲、2-占用、3-清理、4-维修。必填。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 秒级时间戳。必填。
         */
        @JsonProperty("endTime")
        private Long endTime;
    }
}
