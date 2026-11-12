package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「多商品库存批量查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810033}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_e1371f36-2c45-4e90-8b9e-43dda8bb16e8">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiProductInventoryQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u591a\u5546\u54c1\u5e93\u5b58\u6279\u91cf\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MultiProductInventoryQueryMessage() {
    }


    /**
     * 预订时间，形如2019-01-01。必填。
     */
    @JsonProperty("bookDate")
    private String bookDate;

    /**
     * 几天的库存组成，days=2，包含booktime的2天的库存。必填。
     */
    @JsonProperty("days")
    private String days;

    /**
     * 服务时长（分钟）如：30，60，90等. 如果不填，表示不在意预订时长。
     */
    @JsonProperty("durations")
    private String durations;

    /**
     * 每天营业开始时间，精确到分钟，如10:00 （宠物预订业务使用本字段）。
     */
    @JsonProperty("startTime")
    private String startTime;

    /**
     * 每天营业结束时间，精确到分钟，如23:30 （宠物预订业务使用本字段）。
     */
    @JsonProperty("endTime")
    private String endTime;

    /**
     * 时间切片宽度，单位分钟，如20（宠物预订业务使用本字段）。
     */
    @JsonProperty("interval")
    private String interval;

    /**
     * 项目信息数组（包含对项目具体信息的查询条件）。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("inventoryProductInfos")
    private InventoryProductInfos inventoryProductInfos;

    /**
     * 项目信息数组（包含对项目具体信息的查询条件）。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InventoryProductInfos {

        /**
         * 创建\u9879\u76ee\u4fe1\u606f\u6570\u7ec4\uff08\u5305\u542b\u5bf9\u9879\u76ee\u5177\u4f53\u4fe1\u606f\u7684\u67e5\u8be2\u6761\u4ef6\uff09\u3002的空实例。
         */
        public InventoryProductInfos() {
        }


        /**
         * 三方服务项目 ID，不填则查询门店下所有服务项目（宠物预订业务使用本字段）。
         */
        @JsonProperty("app_product_id")
        private String appProductId;

        /**
         * 美团侧服务项目 ID，适用于适用美团侧服务项目 ID 通信的业务。
         */
        @JsonProperty("product_id")
        private Long productId;
    }
}
