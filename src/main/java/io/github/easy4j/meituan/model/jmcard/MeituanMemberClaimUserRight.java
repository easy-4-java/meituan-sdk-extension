package io.github.easy4j.meituan.model.jmcard;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 领取美团会员权益所需的用户权益信息。
 */
@Getter
@Setter
public class MeituanMemberClaimUserRight {

    /** 创建空的用户权益领取信息。 */
    public MeituanMemberClaimUserRight() {
    }

    /** 领取事件 ID，同时作为幂等键。 */
    @NotNull(message = "eventId不能为空")
    @SerializedName("eventId")
    private Long eventId;

    /** 用户注册手机号，按官方协议传递明文数据。 */
    @NotBlank(message = "phoneNo不能为空")
    @SerializedName("phoneNo")
    private String phoneNo;

    /** 申请的美团会员体验卡等级，本期支持 L5、L6。 */
    @NotBlank(message = "applyLevel不能为空")
    @SerializedName("applyLevel")
    private String applyLevel;

    /** 品牌方会员 ID。 */
    @NotBlank(message = "brandMemberId不能为空")
    @SerializedName("brandMemberId")
    private String brandMemberId;

    /** 未领取体验卡前的品牌会员等级。 */
    @Valid
    @NotNull(message = "brandOriginLevel不能为空")
    @SerializedName("brandOriginLevel")
    private MeituanMemberLevel brandOriginLevel;

    /** 品牌方实际展示的会员等级。 */
    @Valid
    @NotNull(message = "brandLevel不能为空")
    @SerializedName("brandLevel")
    private MeituanMemberLevel brandLevel;

    /** 用户姓名。 */
    @NotBlank(message = "name不能为空")
    @SerializedName("name")
    private String name;

    /** 性别，男为 MALE、女为 FEMALE。 */
    @NotBlank(message = "gender不能为空")
    @SerializedName("gender")
    private String gender;

    /** 充值余额，单位为分。 */
    @SerializedName("balance")
    private Long balance;

    /** 用户积分。 */
    @SerializedName("point")
    private String point;

    /** 用户消费金额，单位为分。 */
    @SerializedName("gmv")
    private Long gmv;

    /** JSON 字符串格式的扩展信息。 */
    @SerializedName("extMap")
    private String extMap;

    /** 是否为品牌纯新用户。 */
    @NotNull(message = "isPureNewUser不能为空")
    @SerializedName("isPureNewUser")
    private Boolean pureNewUser;
}
