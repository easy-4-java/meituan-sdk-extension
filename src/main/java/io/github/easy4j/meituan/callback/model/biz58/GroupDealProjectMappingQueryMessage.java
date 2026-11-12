package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
     * 美团团购Id列表。必填。
     */
    @JsonProperty("mtDealGroupIds")
    private List<Long> mtDealGroupIds;


    /**
     * 创建美团「团购三方项目Id关联关系查询」回调的业务内容。的空实例。
     */
    public GroupDealProjectMappingQueryMessage() {
    }
}
