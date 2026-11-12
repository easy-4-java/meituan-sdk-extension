package io.github.easy4j.meituan.callback.model.biz58;

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
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u6307\u5b9a\u95e8\u5e97\u8d44\u6e90\u5e93\u5b58\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public StoreResourceInventoryQueryResult() {
    }


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
         * 创建\u684c\u4fe1\u606f\u5217\u8868\u3002\u5fc5\u586b\u3002的空实例。
         */
        public BallTableInfoBO() {
        }


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
