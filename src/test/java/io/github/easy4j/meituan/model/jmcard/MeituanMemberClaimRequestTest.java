package io.github.easy4j.meituan.model.jmcard;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.internal.exceptions.MtSdkException;
import com.meituan.sdk.internal.utils.ValidationUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 领取美团会员权益请求与响应协议测试。
 */
class MeituanMemberClaimRequestTest {

    @Test
    void shouldValidateRequiredFieldsInsideUserRightInfo() {
        MeituanMemberClaimRequest request = new MeituanMemberClaimRequest();
        request.setUserRightInfo(new MeituanMemberClaimUserRight());

        assertThatThrownBy(() -> ValidationUtil.validate(request))
                .isInstanceOf(MtSdkException.class)
                .hasMessageContaining("eventId不能为空")
                .hasMessageContaining("phoneNo不能为空")
                .hasMessageContaining("isPureNewUser不能为空");
    }

    @Test
    void shouldCascadeValidationIntoBothMemberLevels() {
        MeituanMemberClaimUserRight userRight = new MeituanMemberClaimUserRight();
        userRight.setBrandOriginLevel(new MeituanMemberLevel());
        userRight.setBrandLevel(new MeituanMemberLevel());

        MeituanMemberClaimRequest request = new MeituanMemberClaimRequest();
        request.setUserRightInfo(userRight);

        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            assertThat(validatorFactory.getValidator().validate(request))
                    .extracting(violation -> violation.getPropertyPath().toString())
                    .contains("userRightInfo.brandOriginLevel.brandLevel", "userRightInfo.brandLevel.brandLevel");
        }
    }

    @Test
    void shouldSerializeOfficialClaimFieldsAndDeserializeResponse() {
        MeituanMemberLevel originLevel = new MeituanMemberLevel();
        originLevel.setBrandLevel("L5");
        originLevel.setLevelBeginTime(1_772_452_017L);
        originLevel.setLevelEndTime(1_772_452_029L);

        MeituanMemberLevel actualLevel = new MeituanMemberLevel();
        actualLevel.setBrandLevel("L6");

        MeituanMemberClaimUserRight userRight = new MeituanMemberClaimUserRight();
        userRight.setEventId(123L);
        userRight.setPhoneNo("13000000000");
        userRight.setApplyLevel("L6");
        userRight.setBrandMemberId("member-1");
        userRight.setBrandOriginLevel(originLevel);
        userRight.setBrandLevel(actualLevel);
        userRight.setName("Tom");
        userRight.setGender("MALE");
        userRight.setBalance(10_000L);
        userRight.setPoint("888");
        userRight.setGmv(10_000L);
        userRight.setExtMap("{}");
        userRight.setPureNewUser(true);

        MeituanMemberClaimRequest request = new MeituanMemberClaimRequest();
        request.setUserRightInfo(userRight);

        String json = request.serializeToJson();
        JsonObject serialized = JsonParser.parseString(json).getAsJsonObject().getAsJsonObject("userRightInfo");

        assertThat(serialized.get("eventId").getAsLong()).isEqualTo(123L);
        assertThat(serialized.get("phoneNo").getAsString()).isEqualTo("13000000000");
        assertThat(serialized.get("applyLevel").getAsString()).isEqualTo("L6");
        assertThat(serialized.get("brandMemberId").getAsString()).isEqualTo("member-1");
        assertThat(serialized.getAsJsonObject("brandOriginLevel").get("brandLevel").getAsString()).isEqualTo("L5");
        assertThat(serialized.getAsJsonObject("brandOriginLevel").get("levelBeginTime").getAsLong())
                .isEqualTo(1_772_452_017L);
        assertThat(serialized.getAsJsonObject("brandOriginLevel").get("levelEndTime").getAsLong())
                .isEqualTo(1_772_452_029L);
        assertThat(serialized.getAsJsonObject("brandLevel").get("brandLevel").getAsString()).isEqualTo("L6");
        assertThat(serialized.get("name").getAsString()).isEqualTo("Tom");
        assertThat(serialized.get("gender").getAsString()).isEqualTo("MALE");
        assertThat(serialized.get("balance").getAsLong()).isEqualTo(10_000L);
        assertThat(serialized.get("point").getAsString()).isEqualTo("888");
        assertThat(serialized.get("gmv").getAsLong()).isEqualTo(10_000L);
        assertThat(serialized.get("extMap").getAsString()).isEqualTo("{}");
        assertThat(serialized.get("isPureNewUser").getAsBoolean()).isTrue();

        assertThat(request.toString()).doesNotContain("13000000000", "Tom", "member-1");
        assertThat(userRight.toString()).doesNotContain("13000000000", "Tom", "member-1");

        MeituanResponse<MeituanMemberClaimResponse> response = request.deserializeResponse(
                "{\"code\":\"OP_SUCCESS\",\"msg\":\"成功\",\"traceId\":\"trace-15\","
                        + "\"data\":{\"resultCode\":200,\"errMsg\":\"\",\"mtLevel\":{"
                        + "\"mtLevel\":\"L6\",\"levelBeginTime\":1000,\"levelEndTime\":2000}}}"
        );

        assertThat(response.getData().getResultCode()).isEqualTo(200);
        assertThat(response.getData().getErrMsg()).isEmpty();
        assertThat(response.getData().getMtLevel().getMtLevel()).isEqualTo("L6");
        assertThat(response.getData().getMtLevel().getLevelBeginTime()).isEqualTo(1000L);
        assertThat(response.getData().getMtLevel().getLevelEndTime()).isEqualTo(2000L);
    }
}
