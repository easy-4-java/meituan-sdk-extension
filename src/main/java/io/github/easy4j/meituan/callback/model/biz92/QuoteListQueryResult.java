package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价列表查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_8fb4f32e-11c1-4e5c-a476-c50fec37d768">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteListQueryResult {

    /**
     * 创建美团「报价列表查询」回调的业务响应。的空实例。
     */
    public QuoteListQueryResult() {
    }


    /**
     * 业务状态码。必填。
     */
    @JsonProperty("bizCode")
    private Integer bizCode;

    /**
     * 错误描述。必填。
     */
    @JsonProperty("bizMessage")
    private String bizMessage;

    /**
     * 报价信息列表。必填。
     */
    @JsonProperty("quotations")
    private List<Quotation> quotations;

    /**
     * 报价信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Quotation {

        /**
         * 创建报价信息列表。必填。的空实例。
         */
        public Quotation() {
        }


        /**
         * 报价Id。必填。
         */
        @JsonProperty("quoteId")
        private String quoteId;

        /**
         * 取车门店code。必填。
         */
        @JsonProperty("pickUpThirdStoreCode")
        private String pickUpThirdStoreCode;

        /**
         * 取车方式，详情见取还方式枚举： PickupDropoffType。必填。
         */
        @JsonProperty("pickUpType")
        private String pickUpType;

        /**
         * 还车门店code。必填。
         */
        @JsonProperty("dropOffThirdStoreCode")
        private String dropOffThirdStoreCode;

        /**
         * 还车方式，详情见取还方式枚举： PickupDropoffType。必填。
         */
        @JsonProperty("dropOffType")
        private String dropOffType;

        /**
         * 门店配置信息。必填。
         */
        @JsonProperty("storeInfo")
        private RentalStoreInfoResult storeInfo;

        /**
         * 车辆信息。必填。
         */
        @JsonProperty("vehicleInfo")
        private RentalVehicleInfoResult vehicleInfo;

        /**
         * 价格信息。必填。
         */
        @JsonProperty("priceInfo")
        private RentalPriceInfoResult priceInfo;

        /**
         * 优惠信息，商家如果有优惠信息则必须传。
         */
        @JsonProperty("promotions")
        private List<RentalPromotionResult> promotions;
    }
}
