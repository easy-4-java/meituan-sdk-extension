package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询三方可用手艺人」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_0b4bf40c-5993-4897-a086-ff6cba0ed5cd">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableTechnicianQueriedResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u4e09\u65b9\u53ef\u7528\u624b\u827a\u4eba\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public AvailableTechnicianQueriedResult() {
    }


    /**
     * 手艺人列表。必填。
     */
    @JsonProperty("techList")
    private List<Tech> techList;

    /**
     * 手艺人列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tech {

        /**
         * 创建\u624b\u827a\u4eba\u5217\u8868\u3002\u5fc5\u586b\u3002的空实例。
         */
        public Tech() {
        }


        /**
         * 手艺人ID。必填。
         */
        @JsonProperty("techId")
        private String techId;

        /**
         * 手艺人状态。0：可预约 1：已约满。必填。
         */
        @JsonProperty("techStatus")
        private Integer techStatus;
    }
}
