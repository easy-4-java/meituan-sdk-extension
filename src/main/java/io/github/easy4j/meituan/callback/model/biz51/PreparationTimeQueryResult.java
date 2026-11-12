package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店预计备餐时间查询（非必接）」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_dbf2bef2-55ee-4d2e-9985-7cf039ca2ff6">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreparationTimeQueryResult {

    /**
     * 门店的预计备餐时间列表。
     */
    @JsonProperty("shopPrepareTimeDTOList")
    private List<ShopPrepareTime> shopPrepareTimeDTOList;

    /**
     * 门店的预计备餐时间列表。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShopPrepareTime {

        /**
         * 厂商门店ID。必填。
         */
        @JsonProperty("vendorShopId")
        private String vendorShopId;

        /**
         * 最小可取餐时间，单位分钟，当total&gt;0时必传。
         */
        @JsonProperty("minMinutes")
        private Integer minMinutes;

        /**
         * 最大可取餐时间，单位分钟,maxMinutes&gt;=minMinutes，当total&gt;0时必传。
         */
        @JsonProperty("maxMinutes")
        private Integer maxMinutes;

        /**
         * 等待杯数。
         */
        @JsonProperty("predicatedCount")
        private Integer predicatedCount;

        /**
         * 示例中的门店排队总数。
         */
        @JsonProperty("total")
        private Integer total;
    }
}
