package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ProduceProcessDetailOpenDTO，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProduceProcessDetailOpenDTO {

    /**
     * 组合加工单号。必填。
     */
    @JsonProperty("orderSn")
    private String orderSn;
    /**
     * 上游单号。
     */
    @JsonProperty("sourceOrderSns")
    private List<String> sourceOrderSns;
    /**
     * 机构。
     */
    @JsonProperty("orgInfo")
    private OrgOpenDTO orgInfo;
    /**
     * 生产日期（时间戳）。
     */
    @JsonProperty("bizTime")
    private Long bizTime;
    /**
     * 加工间。
     */
    @JsonProperty("warehouseInfo")
    private WarehouseOpenDTO warehouseInfo;
    /**
     * 成品入库仓库。
     */
    @JsonProperty("stockInWarehousesInfos")
    private List<StockInWarehousesInfosItem> stockInWarehousesInfos;
    /**
     * 关联出库单。
     */
    @JsonProperty("relationStockOutSns")
    private List<String> relationStockOutSns;
    /**
     * 关联入库单。
     */
    @JsonProperty("relationStockInSns")
    private List<String> relationStockInSns;
    /**
     * 总金额。
     */
    @JsonProperty("money")
    private String money;
    /**
     * 单据状态。
     */
    @JsonProperty("status")
    private PairDTO status;
    /**
     * 加工品明细数。
     */
    @JsonProperty("processGoodsCount")
    private Integer processGoodsCount;
    /**
     * 原材料明细数。
     */
    @JsonProperty("materialCount")
    private Integer materialCount;
    /**
     * 加工品名称。
     */
    @JsonProperty("fishGoodsNames")
    private List<String> fishGoodsNames;
    /**
     * 创建日期（时间戳）。
     */
    @JsonProperty("createdTime")
    private Long createdTime;
    /**
     * 打印状态。
     */
    @JsonProperty("printStatus")
    private PrintStatusDetails printStatus;
    /**
     * 创建人。
     */
    @JsonProperty("creator")
    private UserOpenDTO creator;
    /**
     * 备注。
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 删除状态。
     */
    @JsonProperty("deleteStatus")
    private Integer deleteStatus;
    /**
     * 加工品信息列表。
     */
    @JsonProperty("processGoodsDetails")
    private List<ProduceGoodsDetailOpenDTO> processGoodsDetails;
    /**
     * 版本号。
     */
    @JsonProperty("version")
    private Integer version;

    /**
     * 创建ProduceProcessDetailOpenDTO，用于【供应链】组合加工单消息等回调的业务字段。的空实例。
     */
    public ProduceProcessDetailOpenDTO() {
    }

    /**
     * 机构。
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
         * 机构根节点 ID。
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

        /**
         * 创建机构。的空实例。
         */
        public OrgOpenDTO() {
        }
    }

    /**
     * 加工间。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WarehouseOpenDTO {

        /**
         * 仓库 ID。
         */
        @JsonProperty("id")
        private String id;
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
         * 创建加工间。的空实例。
         */
        public WarehouseOpenDTO() {
        }
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
         * 员工账号(废弃)。
         */
        @JsonProperty("name")
        private String name;
        /**
         * 真实名称。
         */
        @JsonProperty("realName")
        private String realName;
        /**
         * 员工账号。
         */
        @JsonProperty("userName")
        private String userName;
        /**
         * 员工编码。
         */
        @JsonProperty("staffCode")
        private String staffCode;
        /**
         * 员工手机号。
         */
        @JsonProperty("phone")
        private String phone;
        /**
         * 账号创建类型。
         */
        @JsonProperty("createType")
        private Integer createType;

        /**
         * 创建创建人。的空实例。
         */
        public UserOpenDTO() {
        }
    }
}
