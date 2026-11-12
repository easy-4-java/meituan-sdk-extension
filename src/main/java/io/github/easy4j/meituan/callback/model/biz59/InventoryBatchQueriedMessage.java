package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「批量查询库存」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910079}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_a2c86c6b-dfe3-40da-b7c8-7383a6c8edc2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryBatchQueriedMessage {

    /**
     * 主体信息。必填。
     */
    @JsonProperty("resvSubjectMapList")
    private List<ResvSubjectMapListItem> resvSubjectMapList;
    /**
     * 主体类型：1.门店 2.门店+项目 3 门店+科室 4 门店+科室+医生。必填。
     */
    @JsonProperty("subjectType")
    private Integer subjectType;
    /**
     * 库存查询开始日期，例如2023-05-01。必填。
     */
    @JsonProperty("startDate")
    private String startDate;
    /**
     * 库存查询结束日期，例如2023-05-01。必填。
     */
    @JsonProperty("endDate")
    private String endDate;
    /**
     * 库存间隔（单位为5分钟的整数倍） 体检业务： 无需传该字段 丽人业务： 如果是间隔30分钟就传30，传5的整数倍即可。
     */
    @JsonProperty("timeSlot")
    private Integer timeSlot;
    /**
     * 是否仅查询库存可用状态，true-不查询具体可用时段和可用库存量。
     */
    @JsonProperty("onlyAvailableStatus")
    private Boolean onlyAvailableStatus;
    /**
     * 扩展字段。
     */
    @JsonProperty("extraMap")
    private ExtraMapDetails extraMap;

    /**
     * 创建美团「批量查询库存」回调的业务内容。的空实例。
     */
    public InventoryBatchQueriedMessage() {
    }

    /**
     * 主体信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResvSubjectMapListItem {

        /**
         * 美团门店 ID 混淆值。必填。
         */
        @JsonProperty("opPoiId")
        private String opPoiId;
        /**
         * 科室 ID。
         */
        @JsonProperty("departmentId")
        private String departmentId;
        /**
         * 医生 ID。
         */
        @JsonProperty("technicianId")
        private String technicianId;
        /**
         * 点评门店 ID。
         */
        @JsonProperty("dpShopId")
        private Long dpShopId;

        /**
         * 创建主体信息。的空实例。
         */
        public ResvSubjectMapListItem() {
        }
    }

    /**
     * 扩展字段。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtraMapDetails {

        /**
         * 美团门店 ID 混淆值。必填。
         */
        @JsonProperty("opPoiId")
        private String opPoiId;
        /**
         * 科室 ID。
         */
        @JsonProperty("departmentId")
        private String departmentId;
        /**
         * 医生 ID。
         */
        @JsonProperty("technicianId")
        private String technicianId;
        /**
         * 点评门店 ID。
         */
        @JsonProperty("dpShopId")
        private Long dpShopId;

        /**
         * 创建扩展字段。的空实例。
         */
        public ExtraMapDetails() {
        }
    }
}
