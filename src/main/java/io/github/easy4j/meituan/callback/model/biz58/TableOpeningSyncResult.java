package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开台信息同步」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_25f138ce-eeb0-42c2-8f7e-df65447aeaa1">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableOpeningSyncResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u5f00\u53f0\u4fe1\u606f\u540c\u6b65\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public TableOpeningSyncResult() {
    }


    /**
     * 开台是否成功：true-成功、false-失败。必填。
     */
    @JsonProperty("success")
    private Boolean success;
}
