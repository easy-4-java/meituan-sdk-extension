package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「批量获取库存」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810025}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_3e3c9cce-babf-4faf-9e87-6949e471b8dc">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchInventoryQueryMessage {

    /**
     * 三方商户 ID。
     */
    @JsonProperty("appShopId")
    private String appShopId;
    /**
     * 预订时间，形如2017-01-01。必填。
     */
    @JsonProperty("bookDate")
    private String bookDate;
    /**
     * 几天的库存组成，days=2，包含booktime的2天的库存。必填。
     */
    @JsonProperty("days")
    private Integer days;
    /**
     * 服务时长（分钟）如：30，60，90等. 如果不填，表示不在意预订时长。
     */
    @JsonProperty("durations")
    private String durations;
    /**
     * 项目信息（包含对项目具体信息的查询条件），详细字段见下表。
     */
    @JsonProperty("inventoryProductInfo")
    private InventoryProductInfo inventoryProductInfo;
    /**
     * 批量项目信息。
     */
    @JsonProperty("inventoryInfos")
    private List<InventoryInfo> inventoryInfos;

    /**
     * 创建美团「批量获取库存」回调的业务内容。的空实例。
     */
    public BatchInventoryQueryMessage() {
    }

    /**
     * 项目信息（包含对项目具体信息的查询条件），详细字段见下表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InventoryProductInfo {

        /**
         * 三方服务项目 ID，不填则表示查询门店库存，即门店内的项目共享库存，共享库存三方可以自己定义，可以是门店内商品的总库存，也可以是门店内技师总数。
         */
        @JsonProperty("appProductId")
        private String appProductId;
        /**
         * 美团侧服务项目 ID，适用于适用美团侧服务项目 ID 通信的业务。
         */
        @JsonProperty("productId")
        private String productId;

        /**
         * 创建项目信息（包含对项目具体信息的查询条件），详细字段见下表。的空实例。
         */
        public InventoryProductInfo() {
        }
    }

    /**
     * 批量项目信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InventoryInfo {

        /**
         * 三方服务项目 ID。
         */
        @JsonProperty("appProductId")
        private String appProductId;


        /**
         * 创建批量项目信息。的空实例。
         */
        public InventoryInfo() {
        }
    }
}
