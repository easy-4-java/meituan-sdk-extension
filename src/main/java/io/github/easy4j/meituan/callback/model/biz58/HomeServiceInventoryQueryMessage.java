package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「到家行业库存查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810009}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_391676bf-4d52-4a88-9c9c-a8ccf6a05da5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeServiceInventoryQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5230\u5bb6\u884c\u4e1a\u5e93\u5b58\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public HomeServiceInventoryQueryMessage() {
    }


    /**
     * 预订日期 格式：2019-08-14。必填。
     */
    @JsonProperty("bookdate")
    private String bookdate;

    /**
     * 几天的库存组成，比如bookdate=2019-08-14，
     * days=2则返回2019-08-14和2019-08-15这两天的库存（注：1、统一使用24小时制 2、时间段返回营业时间内的，
     * 无需做截断 3、无库存的时间段也需要返回）。必填。
     */
    @JsonProperty("days")
    private String days;

    /**
     * 上门服务地址 注：类型为对象类型，详见扩展参数service_address。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("serviceAddress")
    private ServiceAddress serviceAddress;

    /**
     * 三方项目信息 注：类型为对象类型。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("products")
    private Product products;

    /**
     * 上门服务地址 注：类型为对象类型，详见扩展参数service_address。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ServiceAddress {

        /**
         * 创建\u4e0a\u95e8\u670d\u52a1\u5730\u5740 \u6ce8\uff1a\u7c7b\u578b\u4e3a\u5bf9\u8c61\u7c7b\u578b\uff0c\u8be6\u89c1\u6269\u5c55\u53c2\u6570service_address\u3002的空实例。
         */
        public ServiceAddress() {
        }


        /**
         * 上门地址。必填。
         */
        @JsonProperty("address")
        private String address;

        /**
         * 地址备注。
         */
        @JsonProperty("remark")
        private String remark;

        /**
         * 经纬度。必填。
         */
        @JsonProperty("longitude")
        private Double longitude;

        /**
         * 经纬度。必填。
         */
        @JsonProperty("latitude")
        private Double latitude;
    }

    /**
     * 三方项目信息 注：类型为对象类型。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {

        /**
         * 创建\u4e09\u65b9\u9879\u76ee\u4fe1\u606f \u6ce8\uff1a\u7c7b\u578b\u4e3a\u5bf9\u8c61\u7c7b\u578b\u3002的空实例。
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

        /**
         * 用户指定的优先服务人员 ID，在美团侧通过接口生成的服务人员 ID，无特殊指定为0。
         */
        @JsonProperty("adv_service_tech_id")
        private String advServiceTechId;
    }
}
