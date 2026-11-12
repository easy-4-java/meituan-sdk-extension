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
     * 创建\u7f8e\u56e2\u300c\u95e8\u5e97\u9884\u8ba1\u5907\u9910\u65f6\u95f4\u67e5\u8be2\uff08\u975e\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public PreparationTimeQueryResult() {
    }


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
         * 创建\u95e8\u5e97\u7684\u9884\u8ba1\u5907\u9910\u65f6\u95f4\u5217\u8868\u3002的空实例。
         */
        public ShopPrepareTime() {
        }


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
