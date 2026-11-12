package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「桌台区域变更通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810275}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_370a911c-cdeb-413e-8825-db9fb389a266">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableAreaChangedMessage {

    /**
     * 创建美团「桌台区域变更通知」回调的业务内容。的空实例。
     */
    public TableAreaChangedMessage() {
    }


    /**
     * 门店组织 ID。必填。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 操作类型 1-创建，2-删除，3-修改。必填。
     */
    @JsonProperty("operateType")
    private Integer operateType;

    /**
     * 变更区域详情。必填。
     */
    @JsonProperty("tableAreas")
    private List<TableAreaInfo> tableAreas;

    /**
     * 变更区域详情。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TableAreaInfo {

        /**
         * 创建变更区域详情。的空实例。
         */
        public TableAreaInfo() {
        }


        /**
         * 区域 ID。必填。
         */
        @JsonProperty("areaId")
        private Integer areaId;

        /**
         * 名称。必填。
         */
        @JsonProperty("name")
        private String name;
    }
}
