package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「品牌提供取消订单」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_c2d61f12-5312-4717-8fef-1d4cbba36709">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandOrderCancelResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u54c1\u724c\u63d0\u4f9b\u53d6\u6d88\u8ba2\u5355\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public BrandOrderCancelResult() {
    }


    /**
     * 品牌方先在本地处理订单，再返回处理结果。
     * 用户主动取消（operationType=10）时，1 表示同意取消，2 表示不可取消；
     * 超时强制取消（operationType=20）时，1 表示同意取消，3 表示立即接单。
     * 查无订单应同意取消并记录；立即接单时须返回 confirmParameters。
     */
    @JsonProperty("resultType")
    private Integer resultType;

    /**
     * resultType ==2（不可取消）的时候可传，3（立刻接单）的时候必传，传递接单参数。
     */
    @JsonProperty("confirmParameters")
    private ConfirmParameters confirmParameters;

    /**
     * resultType ==2（不可取消）的时候可传，3（立刻接单）的时候必传，传递接单参数。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConfirmParameters {

        /**
         * 创建resultType ==2\uff08\u4e0d\u53ef\u53d6\u6d88\uff09\u7684\u65f6\u5019\u53ef\u4f20\uff0c3\uff08\u7acb\u523b\u63a5\u5355\uff09\u7684\u65f6\u5019\u5fc5\u4f20\uff0c\u4f20\u9012\u63a5\u5355\u53c2\u6570\u3002的空实例。
         */
        public ConfirmParameters() {
        }


        /**
         * (必传）用户预计取餐时间； （举例）假设用户10:00下单，如果10分钟（该时间依赖门店出单效率与积压订单数量）后可取餐，则需传递的预计取餐时间为10:10； （重点提示）用户依赖取餐时间到店，如若传错需要重新进行技术对接。
         */
        @JsonProperty("takeTime")
        private Long takeTime;

        /**
         * 商家生成取餐号时必填。
         */
        @JsonProperty("takeCode")
        private String takeCode;
    }
}
