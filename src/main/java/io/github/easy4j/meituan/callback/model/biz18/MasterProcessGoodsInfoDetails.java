package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * MasterProcessGoodsInfoDetails，用于【供应链】组合加工单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterProcessGoodsInfoDetails {

    /**
     * 创建MasterProcessGoodsInfoDetails\uff0c\u7528\u4e8e\u3010\u4f9b\u5e94\u94fe\u3011\u7ec4\u5408\u52a0\u5de5\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public MasterProcessGoodsInfoDetails() {
    }


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
         * 创建\u57fa\u51c6\u5355\u4f4d\u3002的空实例。
         */
        public UnitOpenDTO() {
        }


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
         * 创建\u5355\u4f4d\u4fe1\u606f\u3002的空实例。
         */
        public UnitsItem() {
        }


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
