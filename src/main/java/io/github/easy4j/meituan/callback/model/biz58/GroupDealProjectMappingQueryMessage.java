package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「团购三方项目Id关联关系查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810163}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_387e2d53-3f92-44b6-8236-ec795952b954">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDealProjectMappingQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u56e2\u8d2d\u4e09\u65b9\u9879\u76eeId\u5173\u8054\u5173\u7cfb\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public GroupDealProjectMappingQueryMessage() {
    }


    /**
     * 美团团购Id列表。必填。
     */
    @JsonProperty("mtDealGroupIds")
    private List<Long> mtDealGroupIds;
}
