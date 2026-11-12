package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收菜品/门店/门店装修/配送范围的变更消息【必须】」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=2101}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_bb6e77b7-d647-47ca-a3c2-9ba57090bfeb">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreOrProductChangedMessage {

    /**
     * 创建美团「接收菜品/门店/门店装修/配送范围的变更消息【必须】」回调的业务内容。的空实例。
     */
    public StoreOrProductChangedMessage() {
    }


    /**
     * 变更类型。1:新增或修改 2:删除。
     */
    @JsonProperty("op_type")
    private Integer opType;

    /**
     * 变更的业务模块。1:菜品类接口，2:门店装修类，3:门店类，4:配送范围类。
     */
    @JsonProperty("business_module")
    private Integer businessModule;

    /**
     * 提示文案。
     */
    @JsonProperty("notice_msg")
    private String noticeMsg;

    /**
     * 变更时间戳。
     */
    @JsonProperty("utime")
    private Long utime;
}
