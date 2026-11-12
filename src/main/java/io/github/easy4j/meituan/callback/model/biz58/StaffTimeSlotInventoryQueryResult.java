package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「批量查询商家固定时间点服务人员库存」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_e1f3eacf-c538-4357-abeb-d95de1ad1db4">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffTimeSlotInventoryQueryResult {

    /**
     * 库存结果详情 注：类型为对象类型，详见扩展参数BookStock。必填。
     */
    @JsonProperty("bookStockList")
    private List<BookStock> bookStockList;


    /**
     * 创建美团「批量查询商家固定时间点服务人员库存」回调的业务响应。的空实例。
     */
    public StaffTimeSlotInventoryQueryResult() {
    }

    /**
     * 库存结果详情 注：类型为对象类型，详见扩展参数BookStock。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookStock {

        /**
         * 开始时间点，格式内容与请求参数保持一致。必填。
         */
        @JsonProperty("begin")
        private String begin;
        /**
         * 结束时间点，格式内容与请求参数保持一致。
         */
        @JsonProperty("end")
        private String end;
        /**
         * 库存剩余量,0-表示无库存 大于0表示有库存，无限库存返回999。必填。
         */
        @JsonProperty("remainCount")
        private Integer remainCount;
        /**
         * 可服务人员id，在美团侧通过接口生成的服务人员id 系统指派时为空。
         */
        @JsonProperty("serviceTechId")
        private String serviceTechId;

        /**
         * 创建库存结果详情 注：类型为对象类型，详见扩展参数BookStock。必填。的空实例。
         */
        public BookStock() {
        }
    }
}
