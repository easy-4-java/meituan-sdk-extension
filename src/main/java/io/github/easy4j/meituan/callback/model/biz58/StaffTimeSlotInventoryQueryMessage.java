package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「批量查询商家固定时间点服务人员库存」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_e1f3eacf-c538-4357-abeb-d95de1ad1db4">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffTimeSlotInventoryQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u6279\u91cf\u67e5\u8be2\u5546\u5bb6\u56fa\u5b9a\u65f6\u95f4\u70b9\u670d\u52a1\u4eba\u5458\u5e93\u5b58\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StaffTimeSlotInventoryQueryMessage() {
    }


    /**
     * 上门服务地址。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("serviceAddress")
    private ServiceAddressDetails serviceAddress;

    /**
     * 优先服务人员 ID，在美团侧通过接口生成的服务人员 ID 无指定人员时为0。必填。
     */
    @JsonProperty("serviceTechId")
    private String serviceTechId;

    /**
     * 预约时间列表 注：类型为对象类型，详见扩展参数book_time_list。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("bookTimeList")
    private List<BookTimeListItem> bookTimeList;

    /**
     * 扩展字段。
     */
    @JsonProperty("extFields")
    private String extFields;

    /**
     * 三方项目信息。必填。
     */
    @JsonProperty("products")
    private Product products;

    /**
     * 上门服务地址。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ServiceAddressDetails {

        /**
         * 创建\u4e0a\u95e8\u670d\u52a1\u5730\u5740\u3002的空实例。
         */
        public ServiceAddressDetails() {
        }


        /**
         * 上门地址。必填。
         */
        @JsonProperty("address")
        private String address;

        /**
         * 地址备注。必填。
         */
        @JsonProperty("remark")
        private String remark;

        /**
         * 经纬度。必填。
         */
        @JsonProperty("longitude")
        private String longitude;

        /**
         * 经纬度。必填。
         */
        @JsonProperty("latitude")
        private String latitude;
    }

    /**
     * 预约时间列表 注：类型为对象类型，详见扩展参数book_time_list。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookTimeListItem {

        /**
         * 创建\u9884\u7ea6\u65f6\u95f4\u5217\u8868 \u6ce8\uff1a\u7c7b\u578b\u4e3a\u5bf9\u8c61\u7c7b\u578b\uff0c\u8be6\u89c1\u6269\u5c55\u53c2\u6570book_time_list\u3002的空实例。
         */
        public BookTimeListItem() {
        }


        /**
         * 开始时间点，格式如 2016-05-24 12:00 ，数据精确到分钟，只支持整点和半点。必填。
         */
        @JsonProperty("begin")
        private String begin;

        /**
         * 结束时间点，格式如 2016-05-24 12:00 ，数据精确到分钟，只支持整点和半点。
         */
        @JsonProperty("end")
        private String end;
    }

    /**
     * 三方项目信息。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {

        /**
         * 创建\u4e09\u65b9\u9879\u76ee\u4fe1\u606f\u3002的空实例。
         */
        public Product() {
        }


        /**
         * 三方的项目 ID。必填。
         */
        @JsonProperty("app_product_id")
        private String appProductId;

        /**
         * 三方sku_id。必填。
         */
        @JsonProperty("app_sku_id")
        private String appSkuId;

        /**
         * sku数量。必填。
         */
        @JsonProperty("sku_quantity")
        private String skuQuantity;
    }
}
