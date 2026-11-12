package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
     * 创建\u7f8e\u56e2\u300c\u6279\u91cf\u67e5\u8be2\u5546\u5bb6\u56fa\u5b9a\u65f6\u95f4\u70b9\u670d\u52a1\u4eba\u5458\u5e93\u5b58\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public StaffTimeSlotInventoryQueryResult() {
    }


    /**
     * 库存结果详情 注：类型为对象类型，详见扩展参数BookStock。必填。
     */
    @JsonProperty("bookStockList")
    private List<BookStock> bookStockList;

    /**
     * 库存结果详情 注：类型为对象类型，详见扩展参数BookStock。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookStock {

        /**
         * 创建\u5e93\u5b58\u7ed3\u679c\u8be6\u60c5 \u6ce8\uff1a\u7c7b\u578b\u4e3a\u5bf9\u8c61\u7c7b\u578b\uff0c\u8be6\u89c1\u6269\u5c55\u53c2\u6570BookStock\u3002\u5fc5\u586b\u3002的空实例。
         */
        public BookStock() {
        }


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
    }
}
