package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * ProcessMaterialDetailOpenDTO，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessMaterialDetailOpenDTO {

    /**
     * 原材料信息。
     */
    @JsonProperty("goodsInfo")
    private GoodsOpenDTO goodsInfo;

    /**
     * 出(入)库仓库。
     */
    @JsonProperty("stockWarehouseInfo")
    private WarehouseOpenDTO stockWarehouseInfo;

    /**
     * 投料单位。
     */
    @JsonProperty("bizUnitInfo")
    private UnitOpenDTO bizUnitInfo;

    /**
     * 理论用量。
     */
    @JsonProperty("theoreticalAmount")
    private String theoreticalAmount;

    /**
     * 实际用量。
     */
    @JsonProperty("realBizUnitAmount")
    private String realBizUnitAmount;

    /**
     * 成本单价（不含税）。
     */
    @JsonProperty("stockPrice")
    private String stockPrice;

    /**
     * 成本金额（不含税）。
     */
    @JsonProperty("stockMoney")
    private String stockMoney;

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
    @JsonProperty("baseUnitInfo")
    private BaseUnitInfoDetails baseUnitInfo;

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
     * (拆分加工才有)产成品金额比例。
     */
    @JsonProperty("splitRate")
    private String splitRate;

    /**
     * (拆分加工才有)其他成本。
     */
    @JsonProperty("otherStockMoney")
    private String otherStockMoney;

    /**
     * 备注。
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * 原材料信息。
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
     * 出(入)库仓库。
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
     * 投料单位。
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
