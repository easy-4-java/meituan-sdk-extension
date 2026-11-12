package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * DealData，用于套餐配送接单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealData {

    /**
     * 套餐 ID。
     */
    @JsonProperty("dealId")
    private String dealId;

    /**
     * 套餐名称。
     */
    @JsonProperty("dealName")
    private String dealName;

    /**
     * 券码code。
     */
    @JsonProperty("couponCodes")
    private List<String> couponCodes;

    /**
     * 当前套餐选择的规格份数。
     */
    @JsonProperty("dealCount")
    private Integer dealCount;

    /**
     * 菜单信息json。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("dealDetails")
    private List<GroupDeal> dealDetails;

    /**
     * 售卖价。
     */
    @JsonProperty("salePrice")
    private String salePrice;

    /**
     * 打包费。
     */
    @JsonProperty("packingFee")
    private String packingFee;

    /**
     * 菜单信息json。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GroupDeal {

        /**
         * 当前菜品组，若商家上单配置了菜品组，则存在该字段。
         */
        @JsonProperty("groupName")
        private String groupName;

        /**
         * 第三方套餐id,仅套餐通过三方系统上单录入时有值。
         */
        @JsonProperty("thirdProductId")
        private String thirdProductId;

        /**
         * 菜品明细。
         */
        @JsonProperty("foodDetails")
        private List<FoodDetail> foodDetails;
    }
}
