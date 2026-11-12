package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「订单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18207}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_886675cb-a79f-48e5-b280-c35aebcd191d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderNotificationMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8ba2\u5355\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderNotificationMessage() {
    }


    /**
     * 大订单标识。
     */
    @JsonProperty("bigOrderTag")
    private Boolean bigOrderTag;

    /**
     * 订单详情。如果是大订单，除orderbase外，orderDetailRmsVO中其他属性都为空。获取订单全部信息，请通过-订单详情接口获取。
     */
    @JsonProperty("orderDetailRmsVO")
    private OrderDetailRmsVO orderDetailRmsVO;

    /**
     * 订单详情。如果是大订单，除orderbase外，orderDetailRmsVO中其他属性都为空。获取订单全部信息，请通过-订单详情接口获取。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderDetailRmsVO {

        /**
         * 创建\u8ba2\u5355\u8be6\u60c5\u3002\u5982\u679c\u662f\u5927\u8ba2\u5355\uff0c\u9664orderbase\u5916\uff0corderDetailRmsVO\u4e2d\u5176\u4ed6\u5c5e\u6027\u90fd\u4e3a\u7a7a\u3002\u83b7\u53d6\u8ba2\u5355\u5168\u90e8\u4fe1\u606f\uff0c\u8bf7\u901a\u8fc7-\u8ba2\u5355\u8be6\u60c5\u63a5\u53e3\u83b7\u53d6\u3002的空实例。
         */
        public OrderDetailRmsVO() {
        }


        /**
         * 订单基本信息。
         */
        @JsonProperty("orderBase")
        private OrderBaseVO orderBase;

        /**
         * 订单商品信息。
         */
        @JsonProperty("itemList")
        private List<OrderItemVO> itemList;

        /**
         * 订单支付信息。
         */
        @JsonProperty("payList")
        private List<OrderPayVO> payList;

        /**
         * 订单优惠信息。
         */
        @JsonProperty("discountList")
        private List<OrderDiscountVO> discountList;

        /**
         * 子单信息，联台场景使用。
         */
        @JsonProperty("subOrderList")
        private List<SubOrderVO> subOrderList;

        /**
         * 订单外卖信息。
         */
        @JsonProperty("wm")
        private OrderWmVO wm;

        /**
         * 订单挂账信息。
         */
        @JsonProperty("onAccount")
        private OrderOnAccountVO onAccount;

        /**
         * 服务费信息列表。
         */
        @JsonProperty("serviceFees")
        private List<OrderServiceFeeVO> serviceFees;

        /**
         * 订单基本信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderBaseVO {

            /**
             * 创建\u8ba2\u5355\u57fa\u672c\u4fe1\u606f\u3002的空实例。
             */
            public OrderBaseVO() {
            }


            /**
             * 订单Id。
             */
            @JsonProperty("id")
            private Long id;

            /**
             * localServer订单Id。
             */
            @JsonProperty("localId")
            private String localId;

            /**
             * 订单编号。
             */
            @JsonProperty("orderNo")
            private String orderNo;

            /**
             * 订单类型:100 堂食, 200 外带。
             */
            @JsonProperty("type")
            private Integer type;

            /**
             * 订单状态:100 已创建, 200 已下单, 300 已结账, 400 反结账, 500 已退单, 600 已取消,1000 待接单,1100 待制作,1125 待出餐,1150 待配送,1200 配送中,1300 已送达,1400 已完成,1500 已取消。
             */
            @JsonProperty("status")
            private Integer status;

            /**
             * 实际付款金额，单位分。
             */
            @JsonProperty("payed")
            private Long payed;

            /**
             * 下单时间，单位毫秒。
             */
            @JsonProperty("orderTime")
            private Long orderTime;

            /**
             * 备注。
             */
            @JsonProperty("comment")
            private String comment;

            /**
             * 订单变更版本号。
             */
            @JsonProperty("orderVersion")
            private Integer orderVersion;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private Integer creator;

            /**
             * 最后修改人。
             */
            @JsonProperty("modifier")
            private Integer modifier;

            /**
             * 创建时间，单位毫秒。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 最后修改时间，单位毫秒。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 就餐人数。
             */
            @JsonProperty("customerCount")
            private Integer customerCount;

            /**
             * 餐厅类型。
             */
            @JsonProperty("businessType")
            private Integer businessType;

            /**
             * 应收金额，单位分。
             */
            @JsonProperty("receivable")
            private Long receivable;

            /**
             * 抹零金额，单位分。
             */
            @JsonProperty("oddment")
            private Long oddment;

            /**
             * 自动抹零金额，单位分。
             */
            @JsonProperty("autoOddment")
            private Long autoOddment;

            /**
             * 收银员。
             */
            @JsonProperty("cashier")
            private Integer cashier;

            /**
             * 订单来源：1 pos, 2 服务员APP, 3 扫码点餐,,21 美团外卖,22 饿了么外卖, 23 预点餐, 25 点菜宝,26 平板点餐,27 自营外卖, 28 自提, 29 第三方小程序。
             */
            @JsonProperty("source")
            private Integer source;

            /**
             * 结账时间。
             */
            @JsonProperty("checkoutTime")
            private Long checkoutTime;

            /**
             * 退单时间。
             */
            @JsonProperty("refundTime")
            private Long refundTime;

            /**
             * 撤单时间。
             */
            @JsonProperty("cancelTime")
            private Long cancelTime;

            /**
             * 同步时间。
             */
            @JsonProperty("syncTime")
            private Long syncTime;

            /**
             * 服务费。
             */
            @JsonProperty("serviceFee")
            private Long serviceFee;

            /**
             * pickupNo对应的类型。
             */
            @JsonProperty("pickupType")
            private Integer pickupType;

            /**
             * 取餐号或者桌台号。
             */
            @JsonProperty("pickupNo")
            private String pickupNo;

            /**
             * 免找原因。
             */
            @JsonProperty("keepReason")
            private String keepReason;

            /**
             * 门店名。
             */
            @JsonProperty("poiName")
            private String poiName;

            /**
             * 真实桌台 ID。
             */
            @JsonProperty("tableId")
            private Long tableId;

            /**
             * 桌台备注。
             */
            @JsonProperty("tableComment")
            private String tableComment;

            /**
             * 菜品总价。
             */
            @JsonProperty("goodsTotalPrice")
            private Long goodsTotalPrice;

            /**
             * 订单来源名称。
             */
            @JsonProperty("sourceName")
            private String sourceName;

            /**
             * 订单状态名称。
             */
            @JsonProperty("statusName")
            private String statusName;

            /**
             * 订单类型名称。
             */
            @JsonProperty("typeName")
            private String typeName;

            /**
             * 餐厅类型名称。
             */
            @JsonProperty("businessTypeName")
            private String businessTypeName;

            /**
             * C端用户下单时间。
             */
            @JsonProperty("userOrderTime")
            private Long userOrderTime;

            /**
             * 订单金额，单位分。
             */
            @JsonProperty("amount")
            private Long amount;

            /**
             * 是否已开发票： 0-未开发票，1-纸质发票 2-电子发票。
             */
            @JsonProperty("hasInvoice")
            private Integer hasInvoice;

            /**
             * 桌台区域名称。
             */
            @JsonProperty("areaName")
            private String areaName;

            /**
             * 订单收入金额，单位分。
             */
            @JsonProperty("income")
            private Long income;

            /**
             * 订单优惠金额，单位分。
             */
            @JsonProperty("discount")
            private Long discount;

            /**
             * 免找金额，单位分。
             */
            @JsonProperty("keepAmount")
            private Long keepAmount;

            /**
             * 预订单状态：100-已预约、200-预约完成、300-取消预约。
             */
            @JsonProperty("bookStatus")
            private Integer bookStatus;

            /**
             * 预订单预订时间。
             */
            @JsonProperty("bookTime")
            private Long bookTime;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 税额。
             */
            @JsonProperty("taxAmt")
            private Long taxAmt;

            /**
             * 不含税金额。
             */
            @JsonProperty("taxExcludedAmt")
            private Long taxExcludedAmt;

            /**
             * 组织机构 ID。
             */
            @JsonProperty("orgId")
            private Integer orgId;

            /**
             * 第三方门店 ID。
             */
            @JsonProperty("orgCode")
            private Integer orgCode;
        }

        /**
         * 订单商品信息。
         */
        @Getter
        @Setter
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderItemVO {

            /**
             * 创建\u8ba2\u5355\u5546\u54c1\u4fe1\u606f\u3002的空实例。
             */
            public OrderItemVO() {
            }


            /**
             * 订单Id。
             */
            @JsonProperty("orderId")
            private Long orderId;

            /**
             * 菜品skuId。
             */
            @JsonProperty("skuId")
            private Long skuId;

            /**
             * 菜品SKU编号。
             */
            @JsonProperty("skuNo")
            private String skuNo;

            /**
             * 规格，如大、中、小。
             */
            @JsonProperty("specs")
            private String specs;

            /**
             * 菜品名称。
             */
            @JsonProperty("name")
            private String name;

            /**
             * 份数。
             */
            @JsonProperty("count")
            private Double count;

            /**
             * 单价，单位分。
             */
            @JsonProperty("price")
            private Long price;

            /**
             * 总价，单位分。
             */
            @JsonProperty("totalPrice")
            private Long totalPrice;

            /**
             * 备注。
             */
            @JsonProperty("comment")
            private String comment;

            /**
             * 菜品序号。
             */
            @JsonProperty("serialNo")
            private Integer serialNo;

            /**
             * 折后单价，单位分。
             */
            @JsonProperty("actualPrice")
            private Long actualPrice;

            /**
             * 创建时间，单位毫秒。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 最后修改时间，单位毫秒。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * spuId。
             */
            @JsonProperty("spuId")
            private Long spuId;

            /**
             * spu名称。
             */
            @JsonProperty("spuName")
            private String spuName;

            /**
             * 是否套餐 true=是 false=否。
             */
            @JsonProperty("isCombo")
            private Integer isCombo;

            /**
             * 类型：1 正常, 2 称重菜。
             */
            @JsonProperty("type")
            private Integer type;

            /**
             * 是否立即上菜 true=是 false=否。
             */
            @JsonProperty("serving")
            private Integer serving;

            /**
             * 套餐分组 ID。
             */
            @JsonProperty("groupId")
            private Integer groupId;

            /**
             * 状态：1 暂存, 2 下单。
             */
            @JsonProperty("status")
            private Integer status;

            /**
             * 菜品属性。
             */
            @JsonProperty("attrs")
            private String attrs;

            /**
             * 套餐份数。
             */
            @JsonProperty("spuCount")
            private Integer spuCount;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private Integer creator;

            /**
             * 最后修改人。
             */
            @JsonProperty("modifier")
            private Integer modifier;

            /**
             * 增菜退菜原因。
             */
            @JsonProperty("reason")
            private String reason;

            /**
             * 用以标识套餐、主配菜的层级关系的serial_no。
             */
            @JsonProperty("parentNo")
            private Integer parentNo;

            /**
             * 搭配 parent_no 1 套餐、2 普通菜、3 配菜，搭配parent_no使用。
             */
            @JsonProperty("parentType")
            private Integer parentType;

            /**
             * 用于表示是否是临时菜。
             */
            @JsonProperty("temp")
            private Integer temp;

            /**
             * 摊分金额,单位分。
             */
            @JsonProperty("apportionPrice")
            private Long apportionPrice;

            /**
             * 菜品父级标识 -- 32位uuid 用于表示套餐、主配菜的主菜。
             */
            @JsonProperty("parentItemNo")
            private String parentItemNo;

            /**
             * 菜品 ID -- 32位uuid。
             */
            @JsonProperty("itemNo")
            private String itemNo;

            /**
             * 单位。
             */
            @JsonProperty("unit")
            private String unit;

            /**
             * 履约状态：0-无,1-已划菜。
             */
            @JsonProperty("performanceStatus")
            private Integer performanceStatus;

            /**
             * 批次号。
             */
            @JsonProperty("batchNo")
            private String batchNo;

            /**
             * 称重菜重量。
             */
            @JsonProperty("weight")
            private Double weight;

            /**
             * 商品属性JSON：[{type:0,name:"甜度",version:1,values:[{value:"半糖",price:5,actual:3}]}]。
             */
            @JsonProperty("newAttrs")
            private List<OrderGoodsAttrVO> newAttrs;

            /**
             * 是否赠菜。
             */
            @JsonProperty("present")
            private Boolean present;

            /**
             * 是否打折。
             */
            @JsonProperty("discount")
            private Boolean discount;

            /**
             * 是否参加促销活动。
             */
            @JsonProperty("promotion")
            private Boolean promotion;

            /**
             * 是否退菜。
             */
            @JsonProperty("retreat")
            private Boolean retreat;

            /**
             * 赠菜原因。
             */
            @JsonProperty("presentReason")
            private String presentReason;

            /**
             * 打折原因。
             */
            @JsonProperty("discountReason")
            private String discountReason;

            /**
             * 参加的活动名称。
             */
            @JsonProperty("promotionName")
            private String promotionName;

            /**
             * 套餐加价金额。
             */
            @JsonProperty("comboAddPrice")
            private Long comboAddPrice;

            /**
             * 是否打包：1-是，2或者其他值-否。
             */
            @JsonProperty("pack")
            private Integer pack;

            /**
             * 菜品优惠。
             */
            @JsonProperty("discountAmount")
            private Long discountAmount;

            /**
             * 菜品收入。
             */
            @JsonProperty("income")
            private Long income;

            /**
             * 优惠方式列表。
             */
            @JsonProperty("discountItems")
            private List<DiscountItemVO> discountItems;

            /**
             * 菜品价格合计。
             */
            @JsonProperty("newTotalPrice")
            private Long newTotalPrice;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 税额。
             */
            @JsonProperty("taxAmt")
            private Long taxAmt;

            /**
             * 不含税金额。
             */
            @JsonProperty("taxExcludedAmt")
            private Long taxExcludedAmt;

            /**
             * 第三方菜品 ID。
             */
            @JsonProperty("thirdSkuId")
            private Long thirdSkuId;

            /**
             * 商品属性JSON：[{type:0,name:"甜度",version:1,values:[{value:"半糖",price:5,actual:3}]}]。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderGoodsAttrVO {

                /**
                 * 创建\u5546\u54c1\u5c5e\u6027JSON\uff1a[{type:0,name:"\u751c\u5ea6",version:1,values:[{value:"\u534a\u7cd6",price:5,actual:3}]}]\u3002的空实例。
                 */
                public OrderGoodsAttrVO() {
                }


                /**
                 * 属性类型：0-属性、1-做法、2-标签。
                 */
                @JsonProperty("type")
                private Integer type;

                /**
                 * 属性名：如果为标签，忽略values，直接取name。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 属性取值列表。
                 */
                @JsonProperty("values")
                private List<OrderGoodsAttrValueVO> values;

                /**
                 * 属性取值列表。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class OrderGoodsAttrValueVO {

                    /**
                     * 创建\u5c5e\u6027\u53d6\u503c\u5217\u8868\u3002的空实例。
                     */
                    public OrderGoodsAttrValueVO() {
                    }


                    /**
                     * 属性值。
                     */
                    @JsonProperty("value")
                    private String value;

                    /**
                     * 属性金额（做法的时候对应做法的变价金额）。
                     */
                    @JsonProperty("price")
                    private Long price;

                    /**
                     * 实际价格。
                     */
                    @JsonProperty("actual")
                    private Long actual;

                    /**
                     * 变价类型：0-不加价、2-固定加价、3-比例加价（二期）。
                     */
                    @JsonProperty("changeType")
                    private Integer changeType;

                    /**
                     * 做法 ID，其他type可为0。
                     */
                    @JsonProperty("id")
                    private Long id;

                    /**
                     * 做法总价。
                     */
                    @JsonProperty("originalTotalPrice")
                    private Long originalTotalPrice;

                    /**
                     * 做法实际总价。
                     */
                    @JsonProperty("totalPrice")
                    private Long totalPrice;

                    /**
                     * 菜品收入。
                     */
                    @JsonProperty("income")
                    private Long income;

                    /**
                     * 菜品优惠。
                     */
                    @JsonProperty("discountAmount")
                    private Long discountAmount;

                    /**
                     * 优惠方式列表。
                     */
                    @JsonProperty("discountItems")
                    private List<DiscountItemVO> discountItems;

                    /**
                     * 菜品价格合计。
                     */
                    @JsonProperty("newTotalPrice")
                    private Long newTotalPrice;

                    /**
                     * 税率。
                     */
                    @JsonProperty("taxRate")
                    private String taxRate;

                    /**
                     * 税额。
                     */
                    @JsonProperty("taxAmt")
                    private Long taxAmt;

                    /**
                     * 不含税金额。
                     */
                    @JsonProperty("taxExcludedAmt")
                    private Long taxExcludedAmt;

                    /**
                     * 优惠方式列表。
                     */
                    @Getter
                    @Setter
                    @JsonIgnoreProperties(ignoreUnknown = true)
                    public static class DiscountItemVO {

                        /**
                         * 创建\u4f18\u60e0\u65b9\u5f0f\u5217\u8868\u3002的空实例。
                         */
                        public DiscountItemVO() {
                        }


                        /**
                         * 优惠项名称。
                         */
                        @JsonProperty("discountName")
                        private String discountName;

                        /**
                         * 优惠金额。
                         */
                        @JsonProperty("discountAmount")
                        private Long discountAmount;
                    }
                }
            }

            /**
             * 优惠方式列表。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DiscountItemVO {

                /**
                 * 创建\u4f18\u60e0\u65b9\u5f0f\u5217\u8868\u3002的空实例。
                 */
                public DiscountItemVO() {
                }


                /**
                 * 优惠项名称。
                 */
                @JsonProperty("discountName")
                private String discountName;

                /**
                 * 优惠金额。
                 */
                @JsonProperty("discountAmount")
                private Long discountAmount;
            }
        }

        /**
         * 订单支付信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderPayVO {

            /**
             * 创建\u8ba2\u5355\u652f\u4ed8\u4fe1\u606f\u3002的空实例。
             */
            public OrderPayVO() {
            }


            /**
             * 订单 ID。
             */
            @JsonProperty("orderId")
            private Long orderId;

            /**
             * 支付方式Id,大于1000的属于自定支付方式。
             */
            @JsonProperty("payType")
            private Integer payType;

            /**
             * 该支付方式支付金额，单位分。
             */
            @JsonProperty("payed")
            private Long payed;

            /**
             * 交易流水号。
             */
            @JsonProperty("tradeNo")
            private String tradeNo;

            /**
             * 状态：-1 未支付,1 已支付,2 已撤销,3 支付中,4 退款中,5 支付失败,6 退款失败。
             */
            @JsonProperty("status")
            private Integer status;

            /**
             * 挂账人。
             */
            @JsonProperty("debtIndividual")
            private Integer debtIndividual;

            /**
             * 支付类型 1-支付、2-找零、3-退款、4-找零撤销。
             */
            @JsonProperty("type")
            private Integer type;

            /**
             * 创建时间。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 最后修改时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 结算账户。
             */
            @JsonProperty("merchantType")
            private Integer merchantType;

            /**
             * 退款原因。
             */
            @JsonProperty("refundReason")
            private String refundReason;

            /**
             * 退款方式。
             */
            @JsonProperty("refundWay")
            private Integer refundWay;

            /**
             * 退款操作人。
             */
            @JsonProperty("refundOperator")
            private Integer refundOperator;

            /**
             * 退款时间。
             */
            @JsonProperty("refundTime")
            private Long refundTime;

            /**
             * 是否人工。
             */
            @JsonProperty("manual")
            private Integer manual;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private Integer creator;

            /**
             * 修改人。
             */
            @JsonProperty("modifier")
            private Integer modifier;

            /**
             * 支付记录唯一标识。
             */
            @JsonProperty("payNo")
            private String payNo;

            /**
             * 关联支付流水标识。
             */
            @JsonProperty("relatedPayNo")
            private String relatedPayNo;

            /**
             * 支付详情类型: 1 团购代金券, 2 团购菜品券, 3 抵用代金券 ,4抵用菜品券。
             */
            @JsonProperty("payDetailType")
            private Integer payDetailType;

            /**
             * 退款流水号。
             */
            @JsonProperty("refundTradeNo")
            private String refundTradeNo;

            /**
             * 商户号。
             */
            @JsonProperty("merchantNo")
            private String merchantNo;

            /**
             * 支付优惠。
             */
            @JsonProperty("discountAmount")
            private Long discountAmount;

            /**
             * 支付收入。
             */
            @JsonProperty("income")
            private Long income;
        }

        /**
         * 订单优惠信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderDiscountVO {

            /**
             * 创建\u8ba2\u5355\u4f18\u60e0\u4fe1\u606f\u3002的空实例。
             */
            public OrderDiscountVO() {
            }


            /**
             * 订单 ID。
             */
            @JsonProperty("orderId")
            private Long orderId;

            /**
             * 优惠对象：0-无,1-商品,2-订单。
             */
            @JsonProperty("target")
            private Integer target;

            /**
             * 优惠分类。
             */
            @JsonProperty("mode")
            private Integer mode;

            /**
             * 优惠类型。
             */
            @JsonProperty("type")
            private Integer type;

            /**
             * 优惠 ID（如果有），campaignId。
             */
            @JsonProperty("campaignId")
            private Long campaignId;

            /**
             * 优惠数额。
             */
            @JsonProperty("discountAmount")
            private Long discountAmount;

            /**
             * 优惠描述。
             */
            @JsonProperty("discountInfo")
            private String discountInfo;

            /**
             * 优惠详情。
             */
            @JsonProperty("detail")
            private String detail;

            /**
             * 原因。
             */
            @JsonProperty("reason")
            private String reason;

            /**
             * 状态：1：暂存，2：下单，3：核销中，4：失效。
             */
            @JsonProperty("status")
            private Integer status;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private Integer creator;

            /**
             * 创建时间。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 修改人。
             */
            @JsonProperty("modifier")
            private Integer modifier;

            /**
             * 修改时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 优惠流水uuid。
             */
            @JsonProperty("discountNo")
            private String discountNo;
        }

        /**
         * 子单信息，联台场景使用。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SubOrderVO {

            /**
             * 创建\u5b50\u5355\u4fe1\u606f\uff0c\u8054\u53f0\u573a\u666f\u4f7f\u7528\u3002的空实例。
             */
            public SubOrderVO() {
            }


            /**
             * 子单基本信息。
             */
            @JsonProperty("orderBase")
            private OrderBaseVO orderBase;

            /**
             * 子单商品信息。
             */
            @JsonProperty("itemList")
            private List<OrderItemVO> itemList;

            /**
             * 子单支付信息。
             */
            @JsonProperty("payList")
            private List<OrderPayVO> payList;

            /**
             * 子单折扣信息。
             */
            @JsonProperty("discountList")
            private List<OrderDiscountVO> discountList;

            /**
             * 订单挂账信息。
             */
            @JsonProperty("onAccount")
            private OrderOnAccountVO onAccount;

            /**
             * 子单服务费信息。
             */
            @JsonProperty("serviceFees")
            private List<OrderServiceFeeVO> serviceFees;

            /**
             * 子单基本信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderBaseVO {

                /**
                 * 创建\u5b50\u5355\u57fa\u672c\u4fe1\u606f\u3002的空实例。
                 */
                public OrderBaseVO() {
                }


                /**
                 * 订单Id。
                 */
                @JsonProperty("id")
                private Long id;

                /**
                 * localServer订单Id。
                 */
                @JsonProperty("localId")
                private String localId;

                /**
                 * 订单编号。
                 */
                @JsonProperty("orderNo")
                private String orderNo;

                /**
                 * 订单类型:100 堂食, 200 外带。
                 */
                @JsonProperty("type")
                private Integer type;

                /**
                 * 订单状态:100 已创建, 200 已下单, 300 已结账, 400 反结账, 500 已退单, 600 已取消,1000 待接单,1100 待制作,1125 待出餐,1150 待配送,1200 配送中,1300 已送达,1400 已完成,1500 已取消。
                 */
                @JsonProperty("status")
                private Integer status;

                /**
                 * 实际付款金额，单位分。
                 */
                @JsonProperty("payed")
                private Long payed;

                /**
                 * 下单时间，单位毫秒。
                 */
                @JsonProperty("orderTime")
                private Long orderTime;

                /**
                 * 备注。
                 */
                @JsonProperty("comment")
                private String comment;

                /**
                 * 订单变更版本号。
                 */
                @JsonProperty("orderVersion")
                private Integer orderVersion;

                /**
                 * 创建人。
                 */
                @JsonProperty("creator")
                private Integer creator;

                /**
                 * 最后修改人。
                 */
                @JsonProperty("modifier")
                private Integer modifier;

                /**
                 * 创建时间，单位毫秒。
                 */
                @JsonProperty("createdTime")
                private Long createdTime;

                /**
                 * 最后修改时间，单位毫秒。
                 */
                @JsonProperty("modifyTime")
                private Long modifyTime;

                /**
                 * 就餐人数。
                 */
                @JsonProperty("customerCount")
                private Integer customerCount;

                /**
                 * 餐厅类型。
                 */
                @JsonProperty("businessType")
                private Integer businessType;

                /**
                 * 应收金额，单位分。
                 */
                @JsonProperty("receivable")
                private Long receivable;

                /**
                 * 抹零金额，单位分。
                 */
                @JsonProperty("oddment")
                private Long oddment;

                /**
                 * 自动抹零金额，单位分。
                 */
                @JsonProperty("autoOddment")
                private Long autoOddment;

                /**
                 * 收银员。
                 */
                @JsonProperty("cashier")
                private Integer cashier;

                /**
                 * 订单来源：1 pos, 2 服务员APP, 3 扫码点餐,,21 美团外卖,22 饿了么外卖, 23 预点餐, 25 点菜宝,26 平板点餐,27 自营外卖, 28 自提, 29 第三方小程序。
                 */
                @JsonProperty("source")
                private Integer source;

                /**
                 * 结账时间。
                 */
                @JsonProperty("checkoutTime")
                private Long checkoutTime;

                /**
                 * 退单时间。
                 */
                @JsonProperty("refundTime")
                private Long refundTime;

                /**
                 * 撤单时间。
                 */
                @JsonProperty("cancelTime")
                private Long cancelTime;

                /**
                 * 同步时间。
                 */
                @JsonProperty("syncTime")
                private Long syncTime;

                /**
                 * 服务费。
                 */
                @JsonProperty("serviceFee")
                private Long serviceFee;

                /**
                 * pickupNo对应的类型。
                 */
                @JsonProperty("pickupType")
                private Integer pickupType;

                /**
                 * 取餐号或者桌台号。
                 */
                @JsonProperty("pickupNo")
                private String pickupNo;

                /**
                 * 免找原因。
                 */
                @JsonProperty("keepReason")
                private String keepReason;

                /**
                 * 门店名。
                 */
                @JsonProperty("poiName")
                private String poiName;

                /**
                 * 真实桌台 ID。
                 */
                @JsonProperty("tableId")
                private Long tableId;

                /**
                 * 桌台备注。
                 */
                @JsonProperty("tableComment")
                private String tableComment;

                /**
                 * 菜品总价。
                 */
                @JsonProperty("goodsTotalPrice")
                private Long goodsTotalPrice;

                /**
                 * 订单来源名称。
                 */
                @JsonProperty("sourceName")
                private String sourceName;

                /**
                 * 订单状态名称。
                 */
                @JsonProperty("statusName")
                private String statusName;

                /**
                 * 订单类型名称。
                 */
                @JsonProperty("typeName")
                private String typeName;

                /**
                 * 餐厅类型名称。
                 */
                @JsonProperty("businessTypeName")
                private String businessTypeName;

                /**
                 * C端用户下单时间。
                 */
                @JsonProperty("userOrderTime")
                private Long userOrderTime;

                /**
                 * 订单金额，单位分。
                 */
                @JsonProperty("amount")
                private Long amount;

                /**
                 * 是否已开发票： 0-未开发票，1-纸质发票 2-电子发票。
                 */
                @JsonProperty("hasInvoice")
                private Integer hasInvoice;

                /**
                 * 桌台区域名称。
                 */
                @JsonProperty("areaName")
                private String areaName;

                /**
                 * 订单收入金额，单位分。
                 */
                @JsonProperty("income")
                private Long income;

                /**
                 * 订单优惠金额，单位分。
                 */
                @JsonProperty("discount")
                private Long discount;

                /**
                 * 免找金额，单位分。
                 */
                @JsonProperty("keepAmount")
                private Long keepAmount;

                /**
                 * 预订单状态：100-已预约、200-预约完成、300-取消预约。
                 */
                @JsonProperty("bookStatus")
                private Integer bookStatus;

                /**
                 * 预订单预订时间。
                 */
                @JsonProperty("bookTime")
                private Long bookTime;

                /**
                 * 税率。
                 */
                @JsonProperty("taxRate")
                private String taxRate;

                /**
                 * 税额。
                 */
                @JsonProperty("taxAmt")
                private Long taxAmt;

                /**
                 * 不含税金额。
                 */
                @JsonProperty("taxExcludedAmt")
                private Long taxExcludedAmt;

                /**
                 * 组织机构 ID。
                 */
                @JsonProperty("orgId")
                private Integer orgId;

                /**
                 * 第三方门店 ID。
                 */
                @JsonProperty("orgCode")
                private Integer orgCode;
            }

            /**
             * 子单商品信息。
             */
            @Getter
            @Setter
            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                    isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderItemVO {

                /**
                 * 创建\u5b50\u5355\u5546\u54c1\u4fe1\u606f\u3002的空实例。
                 */
                public OrderItemVO() {
                }


                /**
                 * 订单Id。
                 */
                @JsonProperty("orderId")
                private Long orderId;

                /**
                 * 菜品skuId。
                 */
                @JsonProperty("skuId")
                private Long skuId;

                /**
                 * 菜品SKU编号。
                 */
                @JsonProperty("skuNo")
                private String skuNo;

                /**
                 * 规格，如大、中、小。
                 */
                @JsonProperty("specs")
                private String specs;

                /**
                 * 菜品名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 份数。
                 */
                @JsonProperty("count")
                private Double count;

                /**
                 * 单价，单位分。
                 */
                @JsonProperty("price")
                private Long price;

                /**
                 * 总价，单位分。
                 */
                @JsonProperty("totalPrice")
                private Long totalPrice;

                /**
                 * 备注。
                 */
                @JsonProperty("comment")
                private String comment;

                /**
                 * 菜品序号。
                 */
                @JsonProperty("serialNo")
                private Integer serialNo;

                /**
                 * 折后单价，单位分。
                 */
                @JsonProperty("actualPrice")
                private Long actualPrice;

                /**
                 * 创建时间，单位毫秒。
                 */
                @JsonProperty("createdTime")
                private Long createdTime;

                /**
                 * 最后修改时间，单位毫秒。
                 */
                @JsonProperty("modifyTime")
                private Long modifyTime;

                /**
                 * spuId。
                 */
                @JsonProperty("spuId")
                private Long spuId;

                /**
                 * spu名称。
                 */
                @JsonProperty("spuName")
                private String spuName;

                /**
                 * 是否套餐 true=是 false=否。
                 */
                @JsonProperty("isCombo")
                private Integer isCombo;

                /**
                 * 类型：1 正常, 2 称重菜。
                 */
                @JsonProperty("type")
                private Integer type;

                /**
                 * 是否立即上菜 true=是 false=否。
                 */
                @JsonProperty("serving")
                private Integer serving;

                /**
                 * 套餐分组 ID。
                 */
                @JsonProperty("groupId")
                private Integer groupId;

                /**
                 * 状态：1 暂存, 2 下单。
                 */
                @JsonProperty("status")
                private Integer status;

                /**
                 * 菜品属性。
                 */
                @JsonProperty("attrs")
                private String attrs;

                /**
                 * 套餐份数。
                 */
                @JsonProperty("spuCount")
                private Integer spuCount;

                /**
                 * 创建人。
                 */
                @JsonProperty("creator")
                private Integer creator;

                /**
                 * 最后修改人。
                 */
                @JsonProperty("modifier")
                private Integer modifier;

                /**
                 * 增菜退菜原因。
                 */
                @JsonProperty("reason")
                private String reason;

                /**
                 * 用以标识套餐、主配菜的层级关系的serial_no。
                 */
                @JsonProperty("parentNo")
                private Integer parentNo;

                /**
                 * 搭配 parent_no 1 套餐、2 普通菜、3 配菜，搭配parent_no使用。
                 */
                @JsonProperty("parentType")
                private Integer parentType;

                /**
                 * 用于表示是否是临时菜。
                 */
                @JsonProperty("temp")
                private Integer temp;

                /**
                 * 摊分金额,单位分。
                 */
                @JsonProperty("apportionPrice")
                private Long apportionPrice;

                /**
                 * 菜品父级标识 -- 32位uuid 用于表示套餐、主配菜的主菜。
                 */
                @JsonProperty("parentItemNo")
                private String parentItemNo;

                /**
                 * 菜品 ID -- 32位uuid。
                 */
                @JsonProperty("itemNo")
                private String itemNo;

                /**
                 * 单位。
                 */
                @JsonProperty("unit")
                private String unit;

                /**
                 * 履约状态：0-无,1-已划菜。
                 */
                @JsonProperty("performanceStatus")
                private Integer performanceStatus;

                /**
                 * 批次号。
                 */
                @JsonProperty("batchNo")
                private String batchNo;

                /**
                 * 称重菜重量。
                 */
                @JsonProperty("weight")
                private Double weight;

                /**
                 * 商品属性JSON：[{type:0,name:"甜度",version:1,values:[{value:"半糖",price:5,actual:3}]}]。
                 */
                @JsonProperty("newAttrs")
                private List<OrderGoodsAttrVO> newAttrs;

                /**
                 * 是否赠菜。
                 */
                @JsonProperty("present")
                private Boolean present;

                /**
                 * 是否打折。
                 */
                @JsonProperty("discount")
                private Boolean discount;

                /**
                 * 是否参加促销活动。
                 */
                @JsonProperty("promotion")
                private Boolean promotion;

                /**
                 * 是否退菜。
                 */
                @JsonProperty("retreat")
                private Boolean retreat;

                /**
                 * 赠菜原因。
                 */
                @JsonProperty("presentReason")
                private String presentReason;

                /**
                 * 打折原因。
                 */
                @JsonProperty("discountReason")
                private String discountReason;

                /**
                 * 参加的活动名称。
                 */
                @JsonProperty("promotionName")
                private String promotionName;

                /**
                 * 套餐加价金额。
                 */
                @JsonProperty("comboAddPrice")
                private Long comboAddPrice;

                /**
                 * 是否打包：1-是，2或者其他值-否。
                 */
                @JsonProperty("pack")
                private Integer pack;

                /**
                 * 菜品优惠。
                 */
                @JsonProperty("discountAmount")
                private Long discountAmount;

                /**
                 * 菜品收入。
                 */
                @JsonProperty("income")
                private Long income;

                /**
                 * 优惠方式列表。
                 */
                @JsonProperty("discountItems")
                private List<DiscountItemVO> discountItems;

                /**
                 * 菜品价格合计。
                 */
                @JsonProperty("newTotalPrice")
                private Long newTotalPrice;

                /**
                 * 税率。
                 */
                @JsonProperty("taxRate")
                private String taxRate;

                /**
                 * 税额。
                 */
                @JsonProperty("taxAmt")
                private Long taxAmt;

                /**
                 * 不含税金额。
                 */
                @JsonProperty("taxExcludedAmt")
                private Long taxExcludedAmt;

                /**
                 * 第三方菜品 ID。
                 */
                @JsonProperty("thirdSkuId")
                private Long thirdSkuId;

                /**
                 * 商品属性JSON：[{type:0,name:"甜度",version:1,values:[{value:"半糖",price:5,actual:3}]}]。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class OrderGoodsAttrVO {

                    /**
                     * 创建\u5546\u54c1\u5c5e\u6027JSON\uff1a[{type:0,name:"\u751c\u5ea6",version:1,values:[{value:"\u534a\u7cd6",price:5,actual:3}]}]\u3002的空实例。
                     */
                    public OrderGoodsAttrVO() {
                    }


                    /**
                     * 属性类型：0-属性、1-做法、2-标签。
                     */
                    @JsonProperty("type")
                    private Integer type;

                    /**
                     * 属性名：如果为标签，忽略values，直接取name。
                     */
                    @JsonProperty("name")
                    private String name;

                    /**
                     * 属性取值列表。
                     */
                    @JsonProperty("values")
                    private List<OrderGoodsAttrValueVO> values;

                    /**
                     * 属性取值列表。
                     */
                    @Getter
                    @Setter
                    @JsonIgnoreProperties(ignoreUnknown = true)
                    public static class OrderGoodsAttrValueVO {

                        /**
                         * 创建\u5c5e\u6027\u53d6\u503c\u5217\u8868\u3002的空实例。
                         */
                        public OrderGoodsAttrValueVO() {
                        }


                        /**
                         * 属性值。
                         */
                        @JsonProperty("value")
                        private String value;

                        /**
                         * 属性金额（做法的时候对应做法的变价金额）。
                         */
                        @JsonProperty("price")
                        private Long price;

                        /**
                         * 实际价格。
                         */
                        @JsonProperty("actual")
                        private Long actual;

                        /**
                         * 变价类型：0-不加价、2-固定加价、3-比例加价（二期）。
                         */
                        @JsonProperty("changeType")
                        private Integer changeType;

                        /**
                         * 做法 ID，其他type可为0。
                         */
                        @JsonProperty("id")
                        private Long id;

                        /**
                         * 做法总价。
                         */
                        @JsonProperty("originalTotalPrice")
                        private Long originalTotalPrice;

                        /**
                         * 做法实际总价。
                         */
                        @JsonProperty("totalPrice")
                        private Long totalPrice;

                        /**
                         * 菜品收入。
                         */
                        @JsonProperty("income")
                        private Long income;

                        /**
                         * 菜品优惠。
                         */
                        @JsonProperty("discountAmount")
                        private Long discountAmount;

                        /**
                         * 优惠方式列表。
                         */
                        @JsonProperty("discountItems")
                        private List<DiscountItemVO> discountItems;

                        /**
                         * 菜品价格合计。
                         */
                        @JsonProperty("newTotalPrice")
                        private Long newTotalPrice;

                        /**
                         * 税率。
                         */
                        @JsonProperty("taxRate")
                        private String taxRate;

                        /**
                         * 税额。
                         */
                        @JsonProperty("taxAmt")
                        private Long taxAmt;

                        /**
                         * 不含税金额。
                         */
                        @JsonProperty("taxExcludedAmt")
                        private Long taxExcludedAmt;

                        /**
                         * 优惠方式列表。
                         */
                        @Getter
                        @Setter
                        @JsonIgnoreProperties(ignoreUnknown = true)
                        public static class DiscountItemVO {

                            /**
                             * 创建\u4f18\u60e0\u65b9\u5f0f\u5217\u8868\u3002的空实例。
                             */
                            public DiscountItemVO() {
                            }


                            /**
                             * 优惠项名称。
                             */
                            @JsonProperty("discountName")
                            private String discountName;

                            /**
                             * 优惠金额。
                             */
                            @JsonProperty("discountAmount")
                            private Long discountAmount;
                        }
                    }
                }

                /**
                 * 优惠方式列表。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class DiscountItemVO {

                    /**
                     * 创建\u4f18\u60e0\u65b9\u5f0f\u5217\u8868\u3002的空实例。
                     */
                    public DiscountItemVO() {
                    }


                    /**
                     * 优惠项名称。
                     */
                    @JsonProperty("discountName")
                    private String discountName;

                    /**
                     * 优惠金额。
                     */
                    @JsonProperty("discountAmount")
                    private Long discountAmount;
                }
            }

            /**
             * 子单支付信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderPayVO {

                /**
                 * 创建\u5b50\u5355\u652f\u4ed8\u4fe1\u606f\u3002的空实例。
                 */
                public OrderPayVO() {
                }


                /**
                 * 订单 ID。
                 */
                @JsonProperty("orderId")
                private Long orderId;

                /**
                 * 支付方式Id,大于1000的属于自定支付方式。
                 */
                @JsonProperty("payType")
                private Integer payType;

                /**
                 * 该支付方式支付金额，单位分。
                 */
                @JsonProperty("payed")
                private Long payed;

                /**
                 * 交易流水号。
                 */
                @JsonProperty("tradeNo")
                private String tradeNo;

                /**
                 * 状态：-1 未支付,1 已支付,2 已撤销,3 支付中,4 退款中,5 支付失败,6 退款失败。
                 */
                @JsonProperty("status")
                private Integer status;

                /**
                 * 挂账人。
                 */
                @JsonProperty("debtIndividual")
                private Integer debtIndividual;

                /**
                 * 支付类型 1-支付、2-找零、3-退款、4-找零撤销。
                 */
                @JsonProperty("type")
                private Integer type;

                /**
                 * 创建时间。
                 */
                @JsonProperty("createdTime")
                private Long createdTime;

                /**
                 * 最后修改时间。
                 */
                @JsonProperty("modifyTime")
                private Long modifyTime;

                /**
                 * 结算账户。
                 */
                @JsonProperty("merchantType")
                private Integer merchantType;

                /**
                 * 退款原因。
                 */
                @JsonProperty("refundReason")
                private String refundReason;

                /**
                 * 退款方式。
                 */
                @JsonProperty("refundWay")
                private Integer refundWay;

                /**
                 * 退款操作人。
                 */
                @JsonProperty("refundOperator")
                private Integer refundOperator;

                /**
                 * 退款时间。
                 */
                @JsonProperty("refundTime")
                private Long refundTime;

                /**
                 * 是否人工。
                 */
                @JsonProperty("manual")
                private Integer manual;

                /**
                 * 创建人。
                 */
                @JsonProperty("creator")
                private Integer creator;

                /**
                 * 修改人。
                 */
                @JsonProperty("modifier")
                private Integer modifier;

                /**
                 * 支付记录唯一标识。
                 */
                @JsonProperty("payNo")
                private String payNo;

                /**
                 * 关联支付流水标识。
                 */
                @JsonProperty("relatedPayNo")
                private String relatedPayNo;

                /**
                 * 支付详情类型: 1 团购代金券, 2 团购菜品券, 3 抵用代金券 ,4抵用菜品券。
                 */
                @JsonProperty("payDetailType")
                private Integer payDetailType;

                /**
                 * 退款流水号。
                 */
                @JsonProperty("refundTradeNo")
                private String refundTradeNo;

                /**
                 * 商户号。
                 */
                @JsonProperty("merchantNo")
                private String merchantNo;

                /**
                 * 支付优惠。
                 */
                @JsonProperty("discountAmount")
                private Long discountAmount;

                /**
                 * 支付收入。
                 */
                @JsonProperty("income")
                private Long income;
            }

            /**
             * 子单折扣信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderDiscountVO {

                /**
                 * 创建\u5b50\u5355\u6298\u6263\u4fe1\u606f\u3002的空实例。
                 */
                public OrderDiscountVO() {
                }


                /**
                 * 订单 ID。
                 */
                @JsonProperty("orderId")
                private Long orderId;

                /**
                 * 优惠对象：0-无,1-商品,2-订单。
                 */
                @JsonProperty("target")
                private Integer target;

                /**
                 * 优惠分类。
                 */
                @JsonProperty("mode")
                private Integer mode;

                /**
                 * 优惠类型。
                 */
                @JsonProperty("type")
                private Integer type;

                /**
                 * 优惠 ID（如果有），campaignId。
                 */
                @JsonProperty("campaignId")
                private Long campaignId;

                /**
                 * 优惠数额。
                 */
                @JsonProperty("discountAmount")
                private Long discountAmount;

                /**
                 * 优惠描述。
                 */
                @JsonProperty("discountInfo")
                private String discountInfo;

                /**
                 * 优惠详情。
                 */
                @JsonProperty("detail")
                private String detail;

                /**
                 * 原因。
                 */
                @JsonProperty("reason")
                private String reason;

                /**
                 * 状态：1：暂存，2：下单，3：核销中，4：失效。
                 */
                @JsonProperty("status")
                private Integer status;

                /**
                 * 创建人。
                 */
                @JsonProperty("creator")
                private Integer creator;

                /**
                 * 创建时间。
                 */
                @JsonProperty("createdTime")
                private Long createdTime;

                /**
                 * 修改人。
                 */
                @JsonProperty("modifier")
                private Integer modifier;

                /**
                 * 修改时间。
                 */
                @JsonProperty("modifyTime")
                private Long modifyTime;

                /**
                 * 优惠流水uuid。
                 */
                @JsonProperty("discountNo")
                private String discountNo;
            }

            /**
             * 订单挂账信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderOnAccountVO {

                /**
                 * 创建\u8ba2\u5355\u6302\u8d26\u4fe1\u606f\u3002的空实例。
                 */
                public OrderOnAccountVO() {
                }


                /**
                 * 挂账类型。
                 */
                @JsonProperty("type")
                private Integer type;

                /**
                 * 挂账公司。
                 */
                @JsonProperty("company")
                private String company;

                /**
                 * 挂账时间。
                 */
                @JsonProperty("onAccountTime")
                private Long onAccountTime;
            }

            /**
             * 子单服务费信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderServiceFeeVO {

                /**
                 * 创建\u5b50\u5355\u670d\u52a1\u8d39\u4fe1\u606f\u3002的空实例。
                 */
                public OrderServiceFeeVO() {
                }


                /**
                 * 服务费名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * rule中type=1表示人数，其他表示数量。
                 */
                @JsonProperty("count")
                private Double count;

                /**
                 * 服务费总价。
                 */
                @JsonProperty("totalPrice")
                private Long totalPrice;

                /**
                 * 状态：1-有效、2-无效。
                 */
                @JsonProperty("valid")
                private Integer valid;

                /**
                 * 服务费规则 ID。
                 */
                @JsonProperty("serviceFeeId")
                private Long serviceFeeId;

                /**
                 * 服务费规则，JSON存储。
                 */
                @JsonProperty("rule")
                private String rule;

                /**
                 * 扩展字段。
                 */
                @JsonProperty("extra")
                private String extra;

                /**
                 * 创建人。
                 */
                @JsonProperty("creator")
                private Integer creator;

                /**
                 * 创建时间。
                 */
                @JsonProperty("createdTime")
                private Long createdTime;

                /**
                 * 最后修改人。
                 */
                @JsonProperty("modifier")
                private Integer modifier;

                /**
                 * 最后修改时间。
                 */
                @JsonProperty("modifyTime")
                private Long modifyTime;

                /**
                 * 同步时间。
                 */
                @JsonProperty("syncTime")
                private Long syncTime;

                /**
                 * 服务费优惠。
                 */
                @JsonProperty("discountAmount")
                private Long discountAmount;

                /**
                 * 服务费收入。
                 */
                @JsonProperty("income")
                private Long income;

                /**
                 * 优惠方式列表。
                 */
                @JsonProperty("discountItems")
                private List<String> discountItems;

                /**
                 * 服务费规则。
                 */
                @JsonProperty("serviceFeeRuleVO")
                private OrderServiceFeeRuleVO serviceFeeRuleVO;

                /**
                 * 服务费唯一标识。
                 */
                @JsonProperty("no")
                private String no;

                /**
                 * 税率。
                 */
                @JsonProperty("taxRate")
                private String taxRate;

                /**
                 * 税额。
                 */
                @JsonProperty("taxAmt")
                private Long taxAmt;

                /**
                 * 不含税金额。
                 */
                @JsonProperty("taxExcludedAmt")
                private Long taxExcludedAmt;

                /**
                 * 服务费规则。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class OrderServiceFeeRuleVO {

                    /**
                     * 创建\u670d\u52a1\u8d39\u89c4\u5219\u3002的空实例。
                     */
                    public OrderServiceFeeRuleVO() {
                    }


                    /**
                     * 服务费类型：1-按顾客人数 2-按桌收取 3-按菜品优惠后价格设置比例 4-按菜品价格合计设置比例。
                     */
                    @JsonProperty("type")
                    private Integer type;

                    /**
                     * 服务费固定价格，例如单人服务费金额，或单桌金额，单位：分。
                     */
                    @JsonProperty("price")
                    private Long price;

                    /**
                     * 服务费比例，当type = 3或4 时，这里保存了比例。例如收取消费金额的5.5%，这里存5.5。
                     */
                    @JsonProperty("percentage")
                    private BigDecimal percentage;
                }
            }
        }

        /**
         * 订单外卖信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderWmVO {

            /**
             * 创建\u8ba2\u5355\u5916\u5356\u4fe1\u606f\u3002的空实例。
             */
            public OrderWmVO() {
            }


            /**
             * 餐盒费总价。
             */
            @JsonProperty("boxFee")
            private Long boxFee;

            /**
             * 本单预计收入（原）。
             */
            @JsonProperty("settlement")
            private Long settlement;

            /**
             * 商家活动支出。
             */
            @JsonProperty("campaignFee")
            private Long campaignFee;

            /**
             * 本单预计收入（最终结算金额）。
             */
            @JsonProperty("finalSettlement")
            private Long finalSettlement;

            /**
             * 配送费（商家收入）。
             */
            @JsonProperty("shippingFeePoi")
            private Long shippingFeePoi;

            /**
             * 商品金额。
             */
            @JsonProperty("foodAmount")
            private Long foodAmount;

            /**
             * 应收金额。
             */
            @JsonProperty("receivablePoi")
            private Long receivablePoi;

            /**
             * 商家活动支出。
             */
            @JsonProperty("campaignPoiTotal")
            private Long campaignPoiTotal;

            /**
             * 公益捐款。
             */
            @JsonProperty("publicWelfareDonate")
            private Long publicWelfareDonate;

            /**
             * 部分退款金额。
             */
            @JsonProperty("partRefundPrice")
            private Long partRefundPrice;

            /**
             * 其他支出。
             */
            @JsonProperty("accountReverse")
            private Long accountReverse;

            /**
             * 餐盒费相关。
             */
            @JsonProperty("box")
            private FeeVO box;

            /**
             * 配送费相关。
             */
            @JsonProperty("shipping")
            private ShippingDetails shipping;

            /**
             * 餐盒费相关。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class FeeVO {

                /**
                 * 创建\u9910\u76d2\u8d39\u76f8\u5173\u3002的空实例。
                 */
                public FeeVO() {
                }


                /**
                 * 费用。
                 */
                @JsonProperty("fee")
                private Long fee;

                /**
                 * 优惠后收入。
                 */
                @JsonProperty("income")
                private Long income;

                /**
                 * 优惠。
                 */
                @JsonProperty("discount")
                private Long discount;

                /**
                 * 税率。
                 */
                @JsonProperty("taxRate")
                private String taxRate;

                /**
                 * 税额。
                 */
                @JsonProperty("taxAmt")
                private Long taxAmt;

                /**
                 * 不含税金额。
                 */
                @JsonProperty("taxExcludedAmt")
                private Long taxExcludedAmt;
            }

            /**
             * 配送费相关。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ShippingDetails {

                /**
                 * 创建\u914d\u9001\u8d39\u76f8\u5173\u3002的空实例。
                 */
                public ShippingDetails() {
                }


                /**
                 * 费用。
                 */
                @JsonProperty("fee")
                private Long fee;

                /**
                 * 优惠后收入。
                 */
                @JsonProperty("income")
                private Long income;

                /**
                 * 优惠。
                 */
                @JsonProperty("discount")
                private Long discount;

                /**
                 * 税率。
                 */
                @JsonProperty("taxRate")
                private String taxRate;

                /**
                 * 税额。
                 */
                @JsonProperty("taxAmt")
                private Long taxAmt;

                /**
                 * 不含税金额。
                 */
                @JsonProperty("taxExcludedAmt")
                private Long taxExcludedAmt;
            }
        }

        /**
         * 订单挂账信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderOnAccountVO {

            /**
             * 创建\u8ba2\u5355\u6302\u8d26\u4fe1\u606f\u3002的空实例。
             */
            public OrderOnAccountVO() {
            }


            /**
             * 挂账类型。
             */
            @JsonProperty("type")
            private Integer type;

            /**
             * 挂账公司。
             */
            @JsonProperty("company")
            private String company;

            /**
             * 挂账时间。
             */
            @JsonProperty("onAccountTime")
            private Long onAccountTime;
        }

        /**
         * 服务费信息列表。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OrderServiceFeeVO {

            /**
             * 创建\u670d\u52a1\u8d39\u4fe1\u606f\u5217\u8868\u3002的空实例。
             */
            public OrderServiceFeeVO() {
            }


            /**
             * 服务费名称。
             */
            @JsonProperty("name")
            private String name;

            /**
             * rule中type=1表示人数，其他表示数量。
             */
            @JsonProperty("count")
            private Double count;

            /**
             * 服务费总价。
             */
            @JsonProperty("totalPrice")
            private Long totalPrice;

            /**
             * 状态：1-有效、2-无效。
             */
            @JsonProperty("valid")
            private Integer valid;

            /**
             * 服务费规则 ID。
             */
            @JsonProperty("serviceFeeId")
            private Long serviceFeeId;

            /**
             * 服务费规则，JSON存储。
             */
            @JsonProperty("rule")
            private String rule;

            /**
             * 扩展字段。
             */
            @JsonProperty("extra")
            private String extra;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private Integer creator;

            /**
             * 创建时间。
             */
            @JsonProperty("createdTime")
            private Long createdTime;

            /**
             * 最后修改人。
             */
            @JsonProperty("modifier")
            private Integer modifier;

            /**
             * 最后修改时间。
             */
            @JsonProperty("modifyTime")
            private Long modifyTime;

            /**
             * 同步时间。
             */
            @JsonProperty("syncTime")
            private Long syncTime;

            /**
             * 服务费优惠。
             */
            @JsonProperty("discountAmount")
            private Long discountAmount;

            /**
             * 服务费收入。
             */
            @JsonProperty("income")
            private Long income;

            /**
             * 优惠方式列表。
             */
            @JsonProperty("discountItems")
            private List<String> discountItems;

            /**
             * 服务费规则。
             */
            @JsonProperty("serviceFeeRuleVO")
            private OrderServiceFeeRuleVO serviceFeeRuleVO;

            /**
             * 服务费唯一标识。
             */
            @JsonProperty("no")
            private String no;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 税额。
             */
            @JsonProperty("taxAmt")
            private Long taxAmt;

            /**
             * 不含税金额。
             */
            @JsonProperty("taxExcludedAmt")
            private Long taxExcludedAmt;

            /**
             * 服务费规则。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrderServiceFeeRuleVO {

                /**
                 * 创建\u670d\u52a1\u8d39\u89c4\u5219\u3002的空实例。
                 */
                public OrderServiceFeeRuleVO() {
                }


                /**
                 * 服务费类型：1-按顾客人数 2-按桌收取 3-按菜品优惠后价格设置比例 4-按菜品价格合计设置比例。
                 */
                @JsonProperty("type")
                private Integer type;

                /**
                 * 服务费固定价格，例如单人服务费金额，或单桌金额，单位：分。
                 */
                @JsonProperty("price")
                private Long price;

                /**
                 * 服务费比例，当type = 3或4 时，这里保存了比例。例如收取消费金额的5.5%，这里存5.5。
                 */
                @JsonProperty("percentage")
                private BigDecimal percentage;
            }
        }
    }
}
