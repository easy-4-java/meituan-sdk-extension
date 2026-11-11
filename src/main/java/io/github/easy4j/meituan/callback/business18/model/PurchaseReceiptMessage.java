package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「【供应链】采购收货单消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810249}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_5f479a1e-4235-47b8-8d49-7a1e421e2939">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseReceiptMessage {

    /**
     * 总部机构。必填。
     */
    @JsonProperty("rootOrgId")
    private Long rootOrgId;

    /**
     * 推送事件Id。必填。
     */
    @JsonProperty("pushEventId")
    private String pushEventId;

    /**
     * 操作类型。必填。
     */
    @JsonProperty("opType")
    private Integer opType;

    /**
     * 消息时序Id。必填。
     */
    @JsonProperty("seqId")
    private Long seqId;

    /**
     * 大消息体标识。
     */
    @JsonProperty("largeMessageTag")
    private Boolean largeMessageTag;

    /**
     * 采购收货单信息。必填。
     */
    @JsonProperty("bizData")
    private PurchaseAcceptOrderOpenDTO bizData;

    /**
     * 采购收货单信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PurchaseAcceptOrderOpenDTO {

        /**
         * 采购收货单主单。
         */
        @JsonProperty("acceptOrderItem")
        private PurchaseAcceptOrderItemOpenDTO acceptOrderItem;

        /**
         * 采购收货单明细。
         */
        @JsonProperty("details")
        private List<PurchaseAcceptOrderDetailOpenDTO> details;

        /**
         * 采购收货单主单。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PurchaseAcceptOrderItemOpenDTO {

            /**
             * 收货单号。
             */
            @JsonProperty("orderSn")
            private String orderSn;

            /**
             * 收货方机构。
             */
            @JsonProperty("receiveOrgInfo")
            private OrgOpenDTO receiveOrgInfo;

            /**
             * 采购机构。
             */
            @JsonProperty("purchaseOrgInfo")
            private PurchaseOrgInfoDetails purchaseOrgInfo;

            /**
             * 收货日期。
             */
            @JsonProperty("receiveDate")
            private Long receiveDate;

            /**
             * 采购日期。
             */
            @JsonProperty("purchaseDate")
            private Long purchaseDate;

            /**
             * 期望到货日期。
             */
            @JsonProperty("expectReceiveDate")
            private Long expectReceiveDate;

            /**
             * 预计到货日期。
             */
            @JsonProperty("estimateReceiveTime")
            private Long estimateReceiveTime;

            /**
             * 供应商。
             */
            @JsonProperty("supplierInfo")
            private SupplierOpenDTO supplierInfo;

            /**
             * 单据状态。
             */
            @JsonProperty("status")
            private JsonNode status;

            /**
             * 对账状态。
             */
            @JsonProperty("financeSettleStatus")
            private JsonNode financeSettleStatus;

            /**
             * 单据类型。
             */
            @JsonProperty("bizMode")
            private JsonNode bizMode;

            /**
             * 采购订单号。
             */
            @JsonProperty("purchaseOrderSn")
            private String purchaseOrderSn;

            /**
             * 下游单号。
             */
            @JsonProperty("stockInSns")
            private List<String> stockInSns;

            /**
             * 收货地址。
             */
            @JsonProperty("receiveAddress")
            private OrgAddressOpenDTO receiveAddress;

            /**
             * 物流信息。
             */
            @JsonProperty("logisticsInfo")
            private List<LogisticsInfoOpenDTO> logisticsInfo;

            /**
             * 车牌号。
             */
            @JsonProperty("licensePlateNumber")
            private String licensePlateNumber;

            /**
             * 司机名称。
             */
            @JsonProperty("driverName")
            private String driverName;

            /**
             * 司机电话。
             */
            @JsonProperty("driverPhone")
            private String driverPhone;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 质检次数。
             */
            @JsonProperty("qualityInspectionCount")
            private Integer qualityInspectionCount;

            /**
             * 附件。
             */
            @JsonProperty("attachments")
            private List<FileOpenDTO> attachments;

            /**
             * 创建人。
             */
            @JsonProperty("creator")
            private UserOpenDTO creator;

            /**
             * 创建日期。
             */
            @JsonProperty("createTime")
            private Long createTime;

            /**
             * 第三方单据。
             */
            @JsonProperty("thirdOrderSn")
            private String thirdOrderSn;

            /**
             * 收货地址分配维度（1.单据维度 2.明细维度）。
             */
            @JsonProperty("addressDimension")
            private Integer addressDimension;

            /**
             * 收货方机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgOpenDTO {

                /**
                 * 机构 ID。
                 */
                @JsonProperty("orgId")
                private Long orgId;

                /**
                 * 机构根节点ID,即总部机构 ID。
                 */
                @JsonProperty("rootOrgId")
                private Long rootOrgId;

                /**
                 * 机构编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 机构名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 采购机构。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PurchaseOrgInfoDetails {

                /**
                 * 机构 ID。
                 */
                @JsonProperty("orgId")
                private Long orgId;

                /**
                 * 机构根节点ID,即总部机构 ID。
                 */
                @JsonProperty("rootOrgId")
                private Long rootOrgId;

                /**
                 * 机构编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 机构名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 收货地址。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgAddressOpenDTO {

                /**
                 * 主联系人姓名。
                 */
                @JsonProperty("contactName")
                private String contactName;

                /**
                 * 主联系人电话。
                 */
                @JsonProperty("phone")
                private String phone;

                /**
                 * 地址信息。
                 */
                @JsonProperty("address")
                private String address;

                /**
                 * 备用联系人姓名。
                 */
                @JsonProperty("alternateContactName")
                private String alternateContactName;

                /**
                 * 备用联系人电话。
                 */
                @JsonProperty("alternateContactTelephone")
                private String alternateContactTelephone;
            }

            /**
             * 物流信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class LogisticsInfoOpenDTO {

                /**
                 * 物流公司。
                 */
                @JsonProperty("logisticsCompany")
                private String logisticsCompany;

                /**
                 * 物流编号。
                 */
                @JsonProperty("logisticsOrderSn")
                private String logisticsOrderSn;

                /**
                 * 收件人手机号（顺丰必填）。
                 */
                @JsonProperty("receiverPhone")
                private String receiverPhone;

                /**
                 * 包裹件数。
                 */
                @JsonProperty("packageAmount")
                private String packageAmount;
            }

            /**
             * 附件。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class FileOpenDTO {

                /**
                 * 序号。
                 */
                @JsonProperty("seqId")
                private String seqId;

                /**
                 * 文件名称。
                 */
                @JsonProperty("fileName")
                private String fileName;

                /**
                 * 文件Key。
                 */
                @JsonProperty("fileKey")
                private String fileKey;

                /**
                 * 文件访问链接。
                 */
                @JsonProperty("fileUrl")
                private String fileUrl;
            }

            /**
             * 创建人。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UserOpenDTO {

                /**
                 * id。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 真实名称。
                 */
                @JsonProperty("realName")
                private String realName;
            }
        }

        /**
         * 采购收货单明细。
         */
        @Getter
        @Setter
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
                isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PurchaseAcceptOrderDetailOpenDTO {

            /**
             * 明细行 ID。
             */
            @JsonProperty("rowIndex")
            private String rowIndex;

            /**
             * 行号。
             */
            @JsonProperty("seqId")
            private Integer seqId;

            /**
             * 物品信息。
             */
            @JsonProperty("goodsInfo")
            private GoodsOpenDTO goodsInfo;

            /**
             * 采购单位。
             */
            @JsonProperty("purchaseUnit")
            private UnitOpenDTO purchaseUnit;

            /**
             * 采购数量。
             */
            @JsonProperty("purchaseAmount")
            private String purchaseAmount;

            /**
             * 应收数量。
             */
            @JsonProperty("receivableAmount")
            private String receivableAmount;

            /**
             * 收货单位。
             */
            @JsonProperty("receiveUnit")
            private ReceiveUnitDetails receiveUnit;

            /**
             * 收货数量。
             */
            @JsonProperty("receiveAmount")
            private String receiveAmount;

            /**
             * 收货单价(含税)。
             */
            @JsonProperty("receivePrice")
            private String receivePrice;

            /**
             * 收货金额(含税)。
             */
            @JsonProperty("receiveMoney")
            private String receiveMoney;

            /**
             * 税率。
             */
            @JsonProperty("taxRate")
            private String taxRate;

            /**
             * 收货金额(不含税)。
             */
            @JsonProperty("receiveNoTaxMoney")
            private String receiveNoTaxMoney;

            /**
             * 税额。
             */
            @JsonProperty("tax")
            private String tax;

            /**
             * 基准单位。
             */
            @JsonProperty("baseUnit")
            private BaseUnitDetails baseUnit;

            /**
             * 基准换算关系。
             */
            @JsonProperty("stockUnitConversion")
            private String stockUnitConversion;

            /**
             * 基准单位数量。
             */
            @JsonProperty("receiveBaseUnitAmount")
            private String receiveBaseUnitAmount;

            /**
             * 辅助单位。
             */
            @JsonProperty("supplementUnit")
            private SupplementUnitDetails supplementUnit;

            /**
             * 辅助单位换算关系。
             */
            @JsonProperty("supplementConversion")
            private String supplementConversion;

            /**
             * 辅助数量。
             */
            @JsonProperty("receiveSupplementaryUnitAmount")
            private String receiveSupplementaryUnitAmount;

            /**
             * 是否赠品。
             */
            @JsonProperty("isGift")
            private Boolean isGift;

            /**
             * 批次号。
             */
            @JsonProperty("physicalBatchNum")
            private String physicalBatchNum;

            /**
             * 生产日期。
             */
            @JsonProperty("productionDate")
            private Long productionDate;

            /**
             * 保质期(天)。
             */
            @JsonProperty("shelfLife")
            private Integer shelfLife;

            /**
             * 到期日期。
             */
            @JsonProperty("expirationDate")
            private Long expirationDate;

            /**
             * 收货仓库。
             */
            @JsonProperty("warehouseInfo")
            private WarehouseOpenDTO warehouseInfo;

            /**
             * 备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 质检次数。
             */
            @JsonProperty("qualityInspectionCount")
            private Integer qualityInspectionCount;

            /**
             * 收货图片。
             */
            @JsonProperty("imageUrls")
            private List<String> imageUrls;

            /**
             * 关联采购订单明细 ID。
             */
            @JsonProperty("purchaseDetailId")
            private String purchaseDetailId;

            /**
             * 收货地址。
             */
            @JsonProperty("orgAddress")
            private OrgAddressDTO orgAddress;

            /**
             * 物品信息。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class GoodsOpenDTO {

                /**
                 * 物品 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 物品编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 物品名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 物品分类。
                 */
                @JsonProperty("category")
                private JsonNode category;

                /**
                 * 品牌。
                 */
                @JsonProperty("brand")
                private String brand;

                /**
                 * 规格。
                 */
                @JsonProperty("spec")
                private String spec;

                /**
                 * 基准单位名称。
                 */
                @JsonProperty("baseUnit")
                private UnitOpenDTO baseUnit;

                /**
                 * 支持的单位名称列表。
                 */
                @JsonProperty("units")
                private List<UnitsItem> units;

                /**
                 * 版本号。
                 */
                @JsonProperty("version")
                private Integer version;

                /**
                 * 第三方编码。
                 */
                @JsonProperty("thirdCode")
                private String thirdCode;

                /**
                 * 基准单位名称。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitOpenDTO {

                    /**
                     * 单位 ID。
                     */
                    @JsonProperty("id")
                    private String id;

                    /**
                     * 单位名称。
                     */
                    @JsonProperty("name")
                    private String name;
                }

                /**
                 * 支持的单位名称列表。
                 */
                @Getter
                @Setter
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class UnitsItem {

                    /**
                     * 单位 ID。
                     */
                    @JsonProperty("id")
                    private String id;

                    /**
                     * 单位名称。
                     */
                    @JsonProperty("name")
                    private String name;
                }
            }

            /**
             * 采购单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UnitOpenDTO {

                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 收货单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReceiveUnitDetails {

                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 辅助单位。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SupplementUnitDetails {

                /**
                 * 单位 ID。
                 */
                @JsonProperty("id")
                private String id;

                /**
                 * 单位名称。
                 */
                @JsonProperty("name")
                private String name;
            }

            /**
             * 收货仓库。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WarehouseOpenDTO {

                /**
                 * 仓库编码。
                 */
                @JsonProperty("code")
                private String code;

                /**
                 * 仓库名称。
                 */
                @JsonProperty("name")
                private String name;

                /**
                 * 仓库 ID。
                 */
                @JsonProperty("id")
                private String id;
            }

            /**
             * 收货地址。
             */
            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OrgAddressDTO {

                /**
                 * 主联系人姓名。
                 */
                @JsonProperty("contactName")
                private String contactName;

                /**
                 * 主联系人电话。
                 */
                @JsonProperty("phone")
                private String phone;

                /**
                 * 地址信息。
                 */
                @JsonProperty("address")
                private String address;

                /**
                 * 备用联系人姓名。
                 */
                @JsonProperty("alternateContactName")
                private String alternateContactName;

                /**
                 * 备用联系人电话。
                 */
                @JsonProperty("alternateContactTelephone")
                private String alternateContactTelephone;
            }
        }
    }
}
