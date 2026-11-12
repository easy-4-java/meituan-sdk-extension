package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「实时订单推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810235}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_afe8750e-5e11-496e-b0d7-6ac300bbecd8">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RealtimeOrderMessage {

    /**
     * 云端订单 ID，全局唯一。
     */
    @JsonProperty("id")
    private Long id;

    /**
     * 美团智能版POS支持离线经营，离线情况下POS会首先生成一个本地localId，同步到云端后即生成上面orderBase.id。
     */
    @JsonProperty("localId")
    private String localId;

    /**
     * 订单展示号（不保证唯一）。
     */
    @JsonProperty("orderNo")
    private String orderNo;

    /**
     * 门店 ID。
     */
    @JsonProperty("poiId")
    private Integer poiId;

    /**
     * 100-已创建、200-已下单、300-已结账、400-反结账、500-已退单、 600-已取消、700-部分退款；
     *  外卖特有：1000-已同步、1100-已接单、1125-待出餐、1150-待配送、1200-配送中、1300-已送达、1400-已完成、1500-已取消。
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 0-未退单, 1-退单中, 2-已退单, 3-退单部分失败；
     *  4-已取消, 11-用户申请退单, 12-商家拒绝用户退单请求, 14-商家主动退单, 21-用户申请取消订单, 22-商家同意用户取消申请, 23-商家拒绝用户取消请求。
     */
    @JsonProperty("refundStatus")
    private Integer refundStatus;

    /**
     * 1-快餐、2-正餐、3-美团外卖、4-饿了么外卖、5-收款、6-台卡虚拟订单、7-零售、8-团购虚拟订单、9-宴会、10-自助餐、11-自营外卖、12-自提外卖、13-交易单、14-抖音外卖。
     */
    @JsonProperty("businessType")
    private Integer businessType;

    /**
     * 100-青春版（美团收银）、200-轻收银、300-零售收银、600-智能版、800-小店收银。
     */
    @JsonProperty("businessLine")
    private Integer businessLine;

    /**
     * 100-堂食、200-外带（整单打包）、300-外卖、400-部分外卖（部分打包）。
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * -1-未知类型、1-POS、2-服务生APP、3-用户自助点餐、4-轻收银APP、5-windowspos、6-轻收银V1、7-轻收银HD、9-金融POS、10-零售、11-ios服务生APP、12-新大陆N850、13-小蓝盒、14-智能支付台卡、15-新大陆N550、16-旺POS、17-新大陆N900、18-新大陆N910、19-酷比魔方Pad、21-美团外卖、22-饿了么外卖、23-预点餐、24-排队点餐、25-点菜宝、26-pad点餐、27-自营外卖、28-自提外卖、29-第三方小程序、30-小店自营外卖、32-抖音外卖、33, "前台码支付订单"、34, "美团自提在线点"、35, "美团团购配送"。
     */
    @JsonProperty("source")
    private Integer source;

    /**
     * 首次下单时间。
     */
    @JsonProperty("orderTime")
    private Long orderTime;

    /**
     * 首次结账时间。
     */
    @JsonProperty("checkoutTime")
    private Long checkoutTime;

    /**
     * 退单/退款时间。
     */
    @JsonProperty("refundTime")
    private Long refundTime;
}
