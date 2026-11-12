package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「售卖车型库查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_caf10bff-4041-45d3-8540-0b7914bb07c3">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleModelQueryResult {

    /**
     * 业务状态码。必填。
     */
    @JsonProperty("bizCode")
    private Integer bizCode;

    /**
     * 业务错误描述。必填。
     */
    @JsonProperty("bizMessage")
    private String bizMessage;

    /**
     * 下一游标, null表示已经到最后一页。必填。
     */
    @JsonProperty("cursor")
    private Long cursor;

    /**
     * 是否还有下一页。必填。
     */
    @JsonProperty("hasMore")
    private Boolean hasMore;

    /**
     * 车型信息列表。必填。
     */
    @JsonProperty("thirdCarModels")
    private List<CarModel> thirdCarModels;

    /**
     * 车型信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CarModel {

        /**
         * 商家车型编码，商家车型唯一。必填。
         */
        @JsonProperty("thirdCarModelId")
        private String thirdCarModelId;

        /**
         * 车型全称，如"丰田卡罗拉 2024款 1.2T CVT 先锋版"。必填。
         */
        @JsonProperty("modelName")
        private String modelName;

        /**
         * 品牌名称，如"丰田"、"大众"、"宝马"。用于 C 端品牌筛选和跨供应商车型归一化匹配。必填。
         */
        @JsonProperty("brandName")
        private String brandName;

        /**
         * 车系名称，如"卡罗拉"、"朗逸"、"3系"。品牌+车系是用户认知车辆的核心维度。必填。
         */
        @JsonProperty("seriesName")
        private String seriesName;

        /**
         * 年款，如"2024"、"2023"。部分供应商可能不区分年款，如"2023款或同级别"。
         */
        @JsonProperty("modelYear")
        private String modelYear;

        /**
         * 车型分组，车型分组名称，详情见枚举 CarGroup。必填。
         */
        @JsonProperty("group")
        private List<String> group;

        /**
         * 变速箱类型：详情见变 速箱类型枚举GearBox。必填。
         */
        @JsonProperty("gearBox")
        private String gearBox;

        /**
         * 燃油类型：详情见 燃油类型枚举FuelType 。影响用户用车成本和补能方式。必填。
         */
        @JsonProperty("fuelType")
        private String fuelType;

        /**
         * 座位数，如 5、7、9。家庭出行用户通常按座位数筛选。必填。
         */
        @JsonProperty("seats")
        private Integer seats;

        /**
         * 车门数，如 2、4、5。大部分轿车/SUV 是 4 门，不传时默认按 4 门处理。必填。
         */
        @JsonProperty("doors")
        private Integer doors;

        /**
         * 排量 1.2t 1.4t，电车不填。
         */
        @JsonProperty("displacement")
        private String displacement;

        /**
         * 车型描述。
         */
        @JsonProperty("description")
        private String description;

        /**
         * 最后更新时间，格式 yyyy-MM-dd HH:mm:ss。配合入参 updatedAfter 实现增量同步。必填。
         */
        @JsonProperty("updatedAt")
        private String updatedAt;
    }
}
