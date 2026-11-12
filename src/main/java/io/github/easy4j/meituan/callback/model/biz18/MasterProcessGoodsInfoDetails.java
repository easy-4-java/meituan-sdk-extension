package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * MasterProcessGoodsInfoDetails，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterProcessGoodsInfoDetails {

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
     * 创建MasterProcessGoodsInfoDetails，用于【供应链】组合加工单消息等回调的业务字段。的空实例。
     */
    public MasterProcessGoodsInfoDetails() {
    }

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

        /**
         * 创建基准单位。的空实例。
         */
        public UnitOpenDTO() {
        }
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

        /**
         * 创建单位信息。的空实例。
         */
        public UnitsItem() {
        }
    }
}
