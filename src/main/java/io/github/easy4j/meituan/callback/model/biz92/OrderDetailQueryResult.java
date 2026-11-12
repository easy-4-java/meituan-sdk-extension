package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「订单详情查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_1d80724b-a152-4d9f-9aa2-cec1e5b7e8a9">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailQueryResult {

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
     * 驾驶员信息。必填。
     */
    @JsonProperty("driver")
    private Driver driver;
    /**
     * 预订信息。必填。
     */
    @JsonProperty("bookingInfo")
    private BookingInfo bookingInfo;
    /**
     * 订单信息。必填。
     */
    @JsonProperty("orderInfo")
    private OrderInfo orderInfo;
    /**
     * 押金相关信息（产生了押金事件必传）。
     */
    @JsonProperty("depositInfo")
    private DepositInfo depositInfo;
    /**
     * 续租单信息（有续租信息必传）。
     */
    @JsonProperty("renewalOrders")
    private List<RenewalOrder> renewalOrders;

    /**
     * 创建美团「订单详情查询」回调的业务响应。的空实例。
     */
    public OrderDetailQueryResult() {
    }

    /**
     * 驾驶员信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Driver {

        /**
         * 姓名。必填。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 证件类型，详情可见证件类型枚举: IdCardType。必填。
         */
        @JsonProperty("idType")
        private String idType;
        /**
         * 证件号码。必填。
         */
        @JsonProperty("idNumber")
        private String idNumber;
        /**
         * 手机号码。必填。
         */
        @JsonProperty("phone")
        private String phone;

        /**
         * 创建驾驶员信息。必填。的空实例。
         */
        public Driver() {
        }
    }

    /**
     * 预订信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookingInfo {

        /**
         * 取车信息。必填。
         */
        @JsonProperty("pickUpInfo")
        private RentalInfo pickUpInfo;
        /**
         * 还车信息。必填。
         */
        @JsonProperty("dropOffInfo")
        private RentalInfo dropOffInfo;
        /**
         * 三方车型编码。必填。
         */
        @JsonProperty("thirdCarModelId")
        private String thirdCarModelId;

        /**
         * 创建预订信息。必填。的空实例。
         */
        public BookingInfo() {
        }
    }

    /**
     * 订单信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderInfo {

        /**
         * 美团订单id。必填。
         */
        @JsonProperty("mtOrderId")
        private Long mtOrderId;
        /**
         * 三方商家订单id。必填。
         */
        @JsonProperty("thirdOrderId")
        private String thirdOrderId;
        /**
         * 订单状态：详情见枚举OrderStatus。必填。
         */
        @JsonProperty("status")
        private String status;
        /**
         * 订单状态描述。
         */
        @JsonProperty("description")
        private String description;
        /**
         * 支付给商家的费用金额。必填。
         */
        @JsonProperty("amount")
        private Integer amount;
        /**
         * 创建时间。必填。
         */
        @JsonProperty("createTime")
        private String createTime;
        /**
         * 订单取消违约金（当订单是取消状态时，取消扣除的违约金，免费取消可为0）。
         */
        @JsonProperty("cancelPenalty")
        private Integer cancelPenalty;
        /**
         * 退款单列表 当有退款单的时候必传。
         */
        @JsonProperty("refundOrders")
        private List<RefundOrder> refundOrders;

        /**
         * 创建订单信息。必填。的空实例。
         */
        public OrderInfo() {
        }
    }

    /**
     * 押金相关信息（产生了押金事件必传）。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DepositInfo {

        /**
         * 车损押金 单位分。必填。
         */
        @JsonProperty("carDepositAmount")
        private Integer carDepositAmount;
        /**
         * 违章押金 单位分。必填。
         */
        @JsonProperty("violationDepositAmount")
        private Integer violationDepositAmount;
        /**
         * 已冻结总押金额 单位分。必填。
         */
        @JsonProperty("freezeAmount")
        private Integer freezeAmount;
        /**
         * 已解冻总押金额 单位分。必填。
         */
        @JsonProperty("unFreezeAmount")
        private Integer unFreezeAmount;
        /**
         * 押金已扣款总金额 单位分。必填。
         */
        @JsonProperty("deductAmount")
        private Integer deductAmount;
        /**
         * 押金渠道， 详情可见： DepositChannel。必填。
         */
        @JsonProperty("freezeChannel")
        private String freezeChannel;
        /**
         * 押金扣款单。
         */
        @JsonProperty("deductOrders")
        private List<DeductOrder> deductOrders;
        /**
         * 押金解冻单。
         */
        @JsonProperty("unfreezeOrders")
        private List<UnfreezeOrder> unfreezeOrders;

        /**
         * 创建押金相关信息（产生了押金事件必传）。的空实例。
         */
        public DepositInfo() {
        }
    }

    /**
     * 续租单信息（有续租信息必传）。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RenewalOrder {

        /**
         * 美团续租订单Id。必填。
         */
        @JsonProperty("mtRenewalOrderId")
        private Long mtRenewalOrderId;
        /**
         * 三方续租单订单号。必填。
         */
        @JsonProperty("thirdRenewalOrderId")
        private String thirdRenewalOrderId;
        /**
         * 续租单状态， 详情可见：RenewalOrderStatus。必填。
         */
        @JsonProperty("status")
        private String status;
        /**
         * 原始还车时间。必填。
         */
        @JsonProperty("dropOffTime")
        private String dropOffTime;
        /**
         * 新还车时间。必填。
         */
        @JsonProperty("newDropOffTime")
        private String newDropOffTime;
        /**
         * 续租金额，单位分。必填。
         */
        @JsonProperty("amount")
        private Integer amount;
        /**
         * 创建时间。必填。
         */
        @JsonProperty("createTime")
        private String createTime;

        /**
         * 创建续租单信息（有续租信息必传）。的空实例。
         */
        public RenewalOrder() {
        }
    }

    /**
     * 取车信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RentalInfo {

        /**
         * 商家门店code。必填。
         */
        @JsonProperty("thirdStoreCode")
        private String thirdStoreCode;
        /**
         * 地址信息。必填。
         */
        @JsonProperty("address")
        private Address address;
        /**
         * 取还时间。必填。
         */
        @JsonProperty("time")
        private String time;
        /**
         * 取还方式 详情见取还方式枚举： PickupDropoffType。必填。
         */
        @JsonProperty("type")
        private String type;

        /**
         * 创建取车信息。必填。的空实例。
         */
        public RentalInfo() {
        }
    }

    /**
     * 退款单列表 当有退款单的时候必传。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RefundOrder {

        /**
         * 美团退款流水。必填。
         */
        @JsonProperty("mtRefundId")
        private String mtRefundId;
        /**
         * 商家退款流水ID，由供应商生成，全局唯一。平台用此ID做幂等去重。必填。
         */
        @JsonProperty("thirdRefundId")
        private String thirdRefundId;
        /**
         * 退款类型，详情见退款类型枚举：RefundType。必填。
         */
        @JsonProperty("refundType")
        private String refundType;
        /**
         * 退款状态，详情见退款单状态枚举：RefundStatus。必填。
         */
        @JsonProperty("refundStatus")
        private String refundStatus;
        /**
         * 退款时间。必填。
         */
        @JsonProperty("refundTime")
        private String refundTime;
        /**
         * 本次退款总金额，单位：分。必填。
         */
        @JsonProperty("totalRefundAmount")
        private Integer totalRefundAmount;
        /**
         * 退款原因说明，面向用户展示。如"经核实，超里程费多收取50元，现予退还"。
         */
        @JsonProperty("refundReason")
        private String refundReason;

        /**
         * 创建退款单列表 当有退款单的时候必传。的空实例。
         */
        public RefundOrder() {
        }
    }

    /**
     * 押金扣款单。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeductOrder {

        /**
         * 商家扣款流水号。必填。
         */
        @JsonProperty("thirdDeductId")
        private String thirdDeductId;
        /**
         * 美团扣款流水。必填。
         */
        @JsonProperty("mtDeductId")
        private String mtDeductId;
        /**
         * 扣款类型，详情见扣款类型枚举：DeductType。必填。
         */
        @JsonProperty("deductType")
        private String deductType;
        /**
         * 扣款原因类型， 详情可见： DeductReasonType。必填。
         */
        @JsonProperty("deductReason")
        private String deductReason;
        /**
         * 扣款金额，单位：分。必填。
         */
        @JsonProperty("amount")
        private Integer amount;
        /**
         * 押金扣款已退金额。必填。
         */
        @JsonProperty("refundAmount")
        private Integer refundAmount;
        /**
         * 扣款单状态，详情见扣款单状态枚举：DeductStatus。必填。
         */
        @JsonProperty("status")
        private String status;
        /**
         * 扣款时间。必填。
         */
        @JsonProperty("deductTime")
        private String deductTime;

        /**
         * 创建押金扣款单。的空实例。
         */
        public DeductOrder() {
        }
    }

    /**
     * 押金解冻单。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UnfreezeOrder {

        /**
         * 扣款解冻流水号。必填。
         */
        @JsonProperty("mtUnfreezeId")
        private String mtUnfreezeId;
        /**
         * 商家解冻流水号。必填。
         */
        @JsonProperty("thirdUnfreezeId")
        private String thirdUnfreezeId;
        /**
         * 解冻类型类型，详情见解冻类型枚举：unfreezeType。必填。
         */
        @JsonProperty("unfreezeType")
        private String unfreezeType;
        /**
         * 解冻金额，单位：分。必填。
         */
        @JsonProperty("amount")
        private Integer amount;
        /**
         * 解冻单状态，详情见解冻单状态枚举：DepositUnfreezeStatus。必填。
         */
        @JsonProperty("status")
        private String status;
        /**
         * 解冻单来源：详情见解冻来源枚举：UnfreezeSource。必填。
         */
        @JsonProperty("source")
        private String source;
        /**
         * 解冻单创建时间。必填。
         */
        @JsonProperty("createdAt")
        private String createdAt;

        /**
         * 创建押金解冻单。的空实例。
         */
        public UnfreezeOrder() {
        }
    }

    /**
     * 地址信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Address {

        /**
         * 纬度（GCJ-02 坐标系）。必填。
         */
        @JsonProperty("latitude")
        private String latitude;
        /**
         * 经度（GCJ-02 坐标系）。必填。
         */
        @JsonProperty("longitude")
        private String longitude;
        /**
         * 地址。必填。
         */
        @JsonProperty("locationName")
        private String locationName;
        /**
         * 城市编码。必填。
         */
        @JsonProperty("cityCode")
        private String cityCode;

        /**
         * 创建地址信息。必填。的空实例。
         */
        public Address() {
        }
    }
}
