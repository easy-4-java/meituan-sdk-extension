package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
     * 创建\u7f8e\u56e2\u300c\u6279\u91cf\u83b7\u53d6\u5e93\u5b58\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public BatchInventoryQueryMessage() {
    }


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
     * 项目信息（包含对项目具体信息的查询条件），详细字段见下表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InventoryProductInfo {

        /**
         * 创建\u9879\u76ee\u4fe1\u606f\uff08\u5305\u542b\u5bf9\u9879\u76ee\u5177\u4f53\u4fe1\u606f\u7684\u67e5\u8be2\u6761\u4ef6\uff09\uff0c\u8be6\u7ec6\u5b57\u6bb5\u89c1\u4e0b\u8868\u3002的空实例。
         */
        public InventoryProductInfo() {
        }


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
    }

    /**
     * 批量项目信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InventoryInfo {

        /**
         * 创建\u6279\u91cf\u9879\u76ee\u4fe1\u606f\u3002的空实例。
         */
        public InventoryInfo() {
        }


        /**
         * 三方服务项目 ID。
         */
        @JsonProperty("appProductId")
        private String appProductId;
    }
}
