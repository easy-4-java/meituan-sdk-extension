package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店预计备餐时间查询（非必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_dbf2bef2-55ee-4d2e-9985-7cf039ca2ff6">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreparationTimeQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u95e8\u5e97\u9884\u8ba1\u5907\u9910\u65f6\u95f4\u67e5\u8be2\uff08\u975e\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PreparationTimeQueryMessage() {
    }


    /**
     * 厂商门店 ID，批量限制500。
     */
    @JsonProperty("vendorShopIds")
    private List<String> vendorShopIds;
}
