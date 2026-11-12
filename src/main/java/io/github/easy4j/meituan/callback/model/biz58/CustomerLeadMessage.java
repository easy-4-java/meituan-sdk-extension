package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「推送顾客线索消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810053}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_8cd0c2b0-f10d-4226-9d47-6c6f9e336484">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerLeadMessage {

    /**
     * 顾客线索 ID。必填。
     */
    @JsonProperty("consumerId")
    private String consumerId;
    /**
     * 客资姓名（默认为""）。必填。
     */
    @JsonProperty("consumerName")
    private String consumerName;
    /**
     * 手机号展示类型 phoneShowType=0表示展示明文， 若phoneShowType=1，
     * 表示手机号不展示明文：133****1234 若phoneShowType=2，表示没有手机号。必填。
     */
    @JsonProperty("phoneShowType")
    private Integer phoneShowType;
    /**
     * 手机号。
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 微信号（默认为""）。必填。
     */
    @JsonProperty("wechat")
    private String wechat;
    /**
     * 留资平台（1为点评、2为美团 ） 注：400电话来源的客资不区分平台，留资平台为0。
     */
    @JsonProperty("platform")
    private Integer platform;
    /**
     * 门店名。
     */
    @JsonProperty("shopName")
    private String shopName;
    /**
     * 最近留资来源（一级）,枚举如下： (21, "门店电话"), (22, "在线咨询"), (23, "预约"), (24, "交易"), (25, "营销推广"), (26, "虚拟号电话"), (27, "线下录入"), (28, "直播"), (29, "营销活动"), (40, "其他");。必填。
     */
    @JsonProperty("lastLeadsFirstSource")
    private Integer lastLeadsFirstSource;
    /**
     * 留资来源-商户详情页 预约：商户详情页等 团购：团购交易，团购后预约 在线咨询：在线，离线 400电话：已接、未接。
     */
    @JsonProperty("lastLeadsSecondSource")
    private String lastLeadsSecondSource;
    /**
     * 留资三级来源。
     */
    @JsonProperty("lastLeadsThirdSource")
    private String lastLeadsThirdSource;
    /**
     * 最近留资时间,毫秒级时间戳。
     */
    @JsonProperty("lastLeadsAddTime")
    private Long lastLeadsAddTime;
    /**
     * 商家备注。
     */
    @JsonProperty("merchantRemark")
    private String merchantRemark;
    /**
     * 意向度，枚举如下： (0, ""), //有效客资 (1, "服务购买成功"), //原：高 (2, "到店"), //原：中 (3, "聊到相关服务"), //原：低 (22, "留线索"), (23, "回访-电话接通"), (24, "回访-信息确认"), (25, "回访-发现意向"), (26, "回访-高潜成交"), (27, "回访-成单客户"), (29, "微信加粉成功"), //无效客资 (4, "无效对话"), //原：无效客资 (5, "恶意/骚扰")， //原：广告骚扰 (13, "空错号")， (14, "回访-电话3次未接通")， (15, "非本人")， (16, "无意向")；。必填。
     */
    @JsonProperty("intention")
    private Integer intention;
    /**
     * 客资状态，枚举如下： (1, "待联系"), (2, "已联系"), (3, "已到店"), (4, "已交易")， (5, "客资待分配")；。必填。
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 客资扩展信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("consumerExtendInfo")
    private ConsumerExtendInfo consumerExtendInfo;
    /**
     * 跟进记录扩展信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("followUpExtendInfo")
    private FollowUpExtendInfo followUpExtendInfo;
    /**
     * 留资行为扩展信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("actionExtendInfo")
    private ActionExtendInfo actionExtendInfo;
    /**
     * k-v结构的json字符串 目前无用。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("bizExtendInfo")
    private JsonNode bizExtendInfo;

    /**
     * 创建美团「推送顾客线索消息」回调的业务内容。的空实例。
     */
    public CustomerLeadMessage() {
    }

    /**
     * 客资扩展信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConsumerExtendInfo {

        /**
         * k-v结构的json字符串 key为属性，value为属性值。例如，"用户性别":"先生","客资类型":"新客"。
         */
        @JsonProperty("attributeMap")
        private JsonNode attributeMap;


        /**
         * 创建客资扩展信息。的空实例。
         */
        public ConsumerExtendInfo() {
        }
    }

    /**
     * 跟进记录扩展信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FollowUpExtendInfo {

        /**
         * 跟进记录 ID。
         */
        @JsonProperty("followUpId")
        private Long followUpId;
        /**
         * 备注。
         */
        @JsonProperty("remark")
        private String remark;
        /**
         * 到店时间。
         */
        @JsonProperty("arriveTime")
        private Long arriveTime;
        /**
         * 客资状态，枚举如下： (1, "待联系"), (2, "已联系"), (3, "已到店"), (4, "已交易")， (5, "客资待分配")；
         */
        @JsonProperty("status")
        private Integer status;
        /**
         * 添加时间。
         */
        @JsonProperty("addTime")
        private Long addTime;
        /**
         * 更新时间。
         */
        @JsonProperty("updateTime")
        private Long updateTime;
        /**
         * k-v结构的json字符串 ，key为属性，value为属性值。
         */
        @JsonProperty("attributeMap")
        private JsonNode attributeMap;

        /**
         * 创建跟进记录扩展信息。的空实例。
         */
        public FollowUpExtendInfo() {
        }
    }

    /**
     * 留资行为扩展信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ActionExtendInfo {

        /**
         * 行为 ID。
         */
        @JsonProperty("actionId")
        private Long actionId;
        /**
         * 行为关联 ID。
         */
        @JsonProperty("referId")
        private String referId;
        /**
         * 枚举如下 (0, ""), (1, "留资"), (2, "团购订单"), (3, "泛商品订单-电商"), (4, "智能电话对应的session"), (5, "亲子线下活动"), (6, "亲子报名商家活动"), (7, "泛商品订单-课程"), (8, "预付"), (9, "团购后预约"), (10,"团购虚拟号留资"), (11,"手动添加"), (12,"预约"), (13,"次卡"), (14,"直播团购");
         */
        @JsonProperty("actionType")
        private Integer actionType;
        /**
         * 添加时间。
         */
        @JsonProperty("addTime")
        private Long addTime;
        /**
         * 更新时间。
         */
        @JsonProperty("updateTime")
        private Long updateTime;
        /**
         * k-v结构的json字符串，key为属性，value为属性值。
         */
        @JsonProperty("attributeMap")
        private JsonNode attributeMap;

        /**
         * 创建留资行为扩展信息。的空实例。
         */
        public ActionExtendInfo() {
        }
    }
}
