package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * ProduceGoodsDetailOpenDTO，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProduceGoodsDetailOpenDTO {

    /**
     * 加工品物品。
     */
    @JsonProperty("goodsInfo")
    private GoodsOpenDTO goodsInfo;

    /**
     * 加工品主副产品标识。
     */
    @JsonProperty("isByproduct")
    private Boolean isByproduct;

    /**
     * 主产品物品信息。
     */
    @JsonProperty("masterProcessGoodsInfo")
    private MasterProcessGoodsInfoDetails masterProcessGoodsInfo;

    /**
     * 入(出)库仓库。
     */
    @JsonProperty("stockWarehouseInfo")
    private WarehouseOpenDTO stockWarehouseInfo;

    /**
     * BOM信息。
     */
    @JsonProperty("bomInfo")
    private BomOpenDTO bomInfo;

    /**
     * 生产单位。
     */
    @JsonProperty("bizUnitInfo")
    private UnitOpenDTO bizUnitInfo;

    /**
     * 生产数量。
     */
    @JsonProperty("bizAmount")
    private String bizAmount;

    /**
     * 金额（不含税）。
     */
    @JsonProperty("processMoney")
    private String processMoney;

    /**
     * 成本单价（不含税）。
     */
    @JsonProperty("stockPrice")
    private String stockPrice;

    /**
     * 原材料金额（不含税）。
     */
    @JsonProperty("materialMoney")
    private String materialMoney;

    /**
     * 人工计件工资。
     */
    @JsonProperty("laborPieceWageMoney")
    private String laborPieceWageMoney;

    /**
     * 其他成本金额。
     */
    @JsonProperty("otherStockMoney")
    private String otherStockMoney;

    /**
     * 主副产品金额分摊比例。
     */
    @JsonProperty("rate")
    private String rate;

    /**
     * 批次号。
     */
    @JsonProperty("batch")
    private String batch;

    /**
     * 生产日期。
     */
    @JsonProperty("productionDate")
    private Long productionDate;

    /**
     * 保质期天数。
     */
    @JsonProperty("qualityTime")
    private Integer qualityTime;

    /**
     * 到期日期。
     */
    @JsonProperty("expirationDate")
    private Long expirationDate;

    /**
     * 基准单位。
     */
    @JsonProperty("baseUnitOpen")
    private BaseUnitOpenDetails baseUnitOpen;

    /**
     * 基准单位数量。
     */
    @JsonProperty("baseUnitAmount")
    private String baseUnitAmount;

    /**
     * 辅助单位。
     */
    @JsonProperty("supplementaryUnitInfo")
    private SupplementaryUnitInfoDetails supplementaryUnitInfo;

    /**
     * 辅助数量。
     */
    @JsonProperty("supplementaryAmount")
    private String supplementaryAmount;

    /**
     * 备注。
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * 加工品关联原材料信息。
     */
    @JsonProperty("relationProcessMaterialGoodsDetails")
    private List<ProcessMaterialDetailOpenDTO> relationProcessMaterialGoodsDetails;

    /**
     * 加工品物品。
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
         * 物品类别。
         */
        @JsonProperty("category")
        private SimpleCategoryOpenDTO category;

        /**
         * 品牌。
         */
        @JsonProperty("brand")
        private String brand;

        /**
         * 规格型号。
         */
        @JsonProperty("spec")
        private String spec;

        /**
         * 基准单位。
         */
        @JsonProperty("baseUnit")
        private UnitOpenDTO baseUnit;

        /**
         * 单位信息。
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
         * 基准单位。
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
             * 单位编码。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 单位名称。
             */
            @JsonProperty("name")
            private String name;
        }

        /**
         * 单位信息。
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
             * 单位编码。
             */
            @JsonProperty("code")
            private String code;

            /**
             * 单位名称。
             */
            @JsonProperty("name")
            private String name;
        }
    }

    /**
     * 入(出)库仓库。
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
    }

    /**
     * 生产单位。
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
         * 单位编码。
         */
        @JsonProperty("code")
        private String code;

        /**
         * 单位名称。
         */
        @JsonProperty("name")
        private String name;
    }
}
