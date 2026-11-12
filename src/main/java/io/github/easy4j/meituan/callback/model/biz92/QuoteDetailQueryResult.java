package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「报价详情查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDetailQueryResult {

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
     * 还车门店code。必填。
     */
    @JsonProperty("dropOffThirdStoreCode")
    private String dropOffThirdStoreCode;
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
     * 政策列表。必填。
     */
    @JsonProperty("policies")
    private Policy policies;
    /**
     * 保障信息。必填。
     */
    @JsonProperty("insuranceInfo")
    private List<Insurance> insuranceInfo;
    /**
     * 费用信息。必填。
     */
    @JsonProperty("fee")
    private RentalFeeResult fee;
    /**
     * 需要的押金总金额。必填。
     */
    @JsonProperty("depositTotalAmount")
    private Integer depositTotalAmount;
    /**
     * 商家支持的证件类型枚举 IdCardType。必填。
     */
    @JsonProperty("supportIdTypes")
    private List<String> supportIdTypes;
    /**
     * 是否可续租。必填。
     */
    @JsonProperty("renewal")
    private Boolean renewal;
    /**
     * 取车材料。必填。
     */
    @JsonProperty("pickUpMaterial")
    private PickUpMaterial pickUpMaterial;
    /**
     * 优惠信息，商家如果有优惠信息则必须传。
     */
    @JsonProperty("promotions")
    private List<RentalPromotionResult> promotions;

    /**
     * 创建美团「报价详情查询」回调的业务响应。的空实例。
     */
    public QuoteDetailQueryResult() {
    }

    /**
     * 政策列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Policy {

        /**
         * 退款规则。必填。
         */
        @JsonProperty("cancelRule")
        private RentalCancelRuleResult cancelRule;
        /**
         * 其他政策。必填。
         */
        @JsonProperty("policyContents")
        private List<PolicyContent> policyContents;

        /**
         * 创建政策列表。必填。的空实例。
         */
        public Policy() {
        }
    }

    /**
     * 保障信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Insurance {

        /**
         * 保障服务Code枚举：InsuranceCode。必填。
         */
        @JsonProperty("code")
        private String code;
        /**
         * 保障名称。必填。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 保障总需增加的费用。必填。
         */
        @JsonProperty("totalAmount")
        private Integer totalAmount;
        /**
         * 保障每日额外加的费用（展示用）。必填。
         */
        @JsonProperty("dayAmount")
        private Integer dayAmount;
        /**
         * 报价费用里是否已经该保险费用，美团用来决定要不要计入总价。必填。
         */
        @JsonProperty("feeIncluded")
        private Boolean feeIncluded;
        /**
         * 保险部分。必填。
         */
        @JsonProperty("insuranceComponent")
        private InsuranceComponent insuranceComponent;
        /**
         * 本保障不予理赔情况描述。必填。
         */
        @JsonProperty("unAssuranceDetail")
        private List<ContentBlock> unAssuranceDetail;

        /**
         * 创建保障信息。必填。的空实例。
         */
        public Insurance() {
        }
    }

    /**
     * 取车材料。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PickUpMaterial {

        /**
         * 驾照要求信息，不传代表没有特殊要求。
         */
        @JsonProperty("driverLicense")
        private DriverLicense driverLicense;
        /**
         * 身份证要求信息，不传代表没有特殊要求。
         */
        @JsonProperty("idCardInfo")
        private IDCard idCardInfo;
        /**
         * 其他取车材料文字化描述。
         */
        @JsonProperty("footer")
        private List<String> footer;

        /**
         * 创建取车材料。必填。的空实例。
         */
        public PickUpMaterial() {
        }
    }

    /**
     * 其他政策。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PolicyContent {

        /**
         * 规则编码，详情见规则编码枚举PolicyModuleCode。必填。
         */
        @JsonProperty("moduleCode")
        private String moduleCode;
        /**
         * 具体内容。必填。
         */
        @JsonProperty("contents")
        private List<ContentBlock> contents;

        /**
         * 创建其他政策。必填。的空实例。
         */
        public PolicyContent() {
        }
    }

    /**
     * 保险部分。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InsuranceComponent {

        /**
         * 车损费用。必填。
         */
        @JsonProperty("vehicleDamage")
        private VehicleDamageInsurance vehicleDamage;
        /**
         * 三者。必填。
         */
        @JsonProperty("thirdParty")
        private ThirdPartyInsurance thirdParty;
        /**
         * 折旧费。必填。
         */
        @JsonProperty("depreciation")
        private DepreciationInsurance depreciation;
        /**
         * 停运费。必填。
         */
        @JsonProperty("lossOfUse")
        private LossOfUseInsurance lossOfUse;

        /**
         * 创建保险部分。必填。的空实例。
         */
        public InsuranceComponent() {
        }
    }

    /**
     * 本保障不予理赔情况描述。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContentBlock {

        /**
         * 二级子标题。
         */
        @JsonProperty("subTitle")
        private String subTitle;
        /**
         * 具体内容。必填。
         */
        @JsonProperty("contentText")
        private List<String> contentText;

        /**
         * 创建本保障不予理赔情况描述。必填。的空实例。
         */
        public ContentBlock() {
        }
    }

    /**
     * 驾照要求信息，不传代表没有特殊要求。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DriverLicense {

        /**
         * 驾龄，单位（月），要求驾龄&gt;=n月，不填代表对驾龄没要求。
         */
        @JsonProperty("drivingExperienceMonths")
        private Integer drivingExperienceMonths;
        /**
         * 驾照有效期，单位（月），驾照有效期&gt;=N个月，不填表示对驾照有效期没要求。
         */
        @JsonProperty("licenseValidityMonths")
        private Integer licenseValidityMonths;
        /**
         * 是否支持12123电子驾照，不填表示不支持。
         */
        @JsonProperty("allowDigitalLicense")
        private Boolean allowDigitalLicense;

        /**
         * 创建驾照要求信息，不传代表没有特殊要求。的空实例。
         */
        public DriverLicense() {
        }
    }

    /**
     * 身份证要求信息，不传代表没有特殊要求。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IDCard {

        /**
         * 是否支持电子身份证，不填表示不支持。
         */
        @JsonProperty("allowDigitCard")
        private Boolean allowDigitCard;
        /**
         * 身份证有效期&gt;=N个月，不填对身份证有效期没限制，有效期之内就行。
         */
        @JsonProperty("validityMonths")
        private Integer validityMonths;

        /**
         * 创建身份证要求信息，不传代表没有特殊要求。的空实例。
         */
        public IDCard() {
        }
    }

    /**
     * 车损费用。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VehicleDamageInsurance {

        /**
         * 是否全额赔付。必填。
         */
        @JsonProperty("fullCoverage")
        private Boolean fullCoverage;
        /**
         * 起赔额度，当全额赔付时可不填，否则必填。
         */
        @JsonProperty("minClaimThreshold")
        private Integer minClaimThreshold;
        /**
         * 最多赔付额度，当全额赔付时不填，否则必填。
         */
        @JsonProperty("maxClaimAmount")
        private Integer maxClaimAmount;
        /**
         * 是否包含玻璃，true代表无需单独承担，false代表需单独承担。必填。
         */
        @JsonProperty("includeGlass")
        private Boolean includeGlass;
        /**
         * 是否包含车轮，true代表无需单独承担，false代表需单独承担。必填。
         */
        @JsonProperty("includeTyre")
        private Boolean includeTyre;
        /**
         * 车损保障部分详情内容。必填。
         */
        @JsonProperty("insuranceDetail")
        private List<ContentBlock> insuranceDetail;

        /**
         * 创建车损费用。必填。的空实例。
         */
        public VehicleDamageInsurance() {
        }
    }

    /**
     * 三者。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ThirdPartyInsurance {

        /**
         * 是否全额赔付。必填。
         */
        @JsonProperty("fullCoverage")
        private Boolean fullCoverage;
        /**
         * 起赔额度，当全额赔付时可不填，否则必填。
         */
        @JsonProperty("minClaimThreshold")
        private Integer minClaimThreshold;
        /**
         * 最多赔付额度，当全额赔付时不填，否则必填。
         */
        @JsonProperty("maxClaimAmount")
        private Integer maxClaimAmount;
        /**
         * 三方保障部分详情内容。必填。
         */
        @JsonProperty("insuranceDetail")
        private List<ContentBlock> insuranceDetail;

        /**
         * 创建三者。必填。的空实例。
         */
        public ThirdPartyInsurance() {
        }
    }

    /**
     * 折旧费。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DepreciationInsurance {

        /**
         * 是否免收。必填。
         */
        @JsonProperty("free")
        private Boolean free;
        /**
         * 免收额度，当免收时不填，否则必填。
         */
        @JsonProperty("maxClaimAmount")
        private Integer maxClaimAmount;
        /**
         * 折旧费比例（车损的百分比），&lt;100，10就是10%。
         */
        @JsonProperty("percent")
        private Integer percent;
        /**
         * 折旧保障部分详情内容。必填。
         */
        @JsonProperty("insuranceDetail")
        private List<ContentBlock> insuranceDetail;

        /**
         * 创建折旧费。必填。的空实例。
         */
        public DepreciationInsurance() {
        }
    }

    /**
     * 停运费。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LossOfUseInsurance {

        /**
         * 是否免停运费。必填。
         */
        @JsonProperty("free")
        private Boolean free;
        /**
         * 免收额度，当免停运费时必传。
         */
        @JsonProperty("maxClaimAmount")
        private Integer maxClaimAmount;
        /**
         * 停运保障部分详情内容。必填。
         */
        @JsonProperty("insuranceDetail")
        private List<ContentBlock> insuranceDetail;

        /**
         * 创建停运费。必填。的空实例。
         */
        public LossOfUseInsurance() {
        }
    }
}
