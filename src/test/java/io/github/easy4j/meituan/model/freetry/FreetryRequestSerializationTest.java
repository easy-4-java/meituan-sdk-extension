package io.github.easy4j.meituan.model.freetry;

import com.meituan.sdk.MeituanResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 大众点评免费试请求序列化与响应反序列化测试。
 */
class FreetryRequestSerializationTest {

    @Test
    void shouldSerializeDocumentedRequestFields() {
        FreetryLoadActivityRestrictionRequest restrictionRequest = new FreetryLoadActivityRestrictionRequest();
        restrictionRequest.setActivityId(1000L);
        FreetryQueryPoiCouponRequest queryRequest = new FreetryQueryPoiCouponRequest();
        queryRequest.setDate("2026-09-23");
        queryRequest.setActivityId(1000L);
        queryRequest.setPage(1);
        queryRequest.setPageSize(20);
        FreetryVerifyCouponRequest verifyRequest = new FreetryVerifyCouponRequest();
        verifyRequest.setCouponCode("7700567083569");
        verifyRequest.setIdempotent("verify-order-1000");

        assertThat(restrictionRequest.serializeToJson()).isEqualTo("{\"activityId\":1000}");
        assertThat(queryRequest.serializeToJson()).contains(
                "\"date\":\"2026-09-23\"",
                "\"activityId\":1000",
                "\"page\":1",
                "\"pageSize\":20"
        );
        assertThat(verifyRequest.serializeToJson()).isEqualTo(
                "{\"couponCode\":\"7700567083569\",\"idempotent\":\"verify-order-1000\"}"
        );
    }

    @Test
    void shouldDeserializeDirectAndWrappedBusinessResponses() {
        FreetryPrepareVerifyRequest prepareRequest = new FreetryPrepareVerifyRequest();
        MeituanResponse<FreetryPrepareVerifyResponse> prepareResponse = prepareRequest.deserializeResponse(
                "{\"code\":\"OP_SUCCESS\",\"data\":{" +
                        "\"activityId\":1000,\"activityTitle\":\"免费试活动\"," +
                        "\"activityQuota\":10,\"activityProjectName\":\"项目\"," +
                        "\"couponStatusCode\":1,\"couponStatus\":\"可核销\"}}"
        );
        FreetryLoadActivityRestrictionRequest restrictionRequest = new FreetryLoadActivityRestrictionRequest();
        MeituanResponse<FreetryLoadActivityRestrictionResponse> restrictionResponse =
                restrictionRequest.deserializeResponse(
                        "{\"code\":\"OP_SUCCESS\",\"data\":{" +
                                "\"code\":0,\"status\":true,\"msg\":\"success\",\"data\":{" +
                                "\"unusableDays\":\"周一\",\"usableDailyPeriod\":\"10:00-20:00\"}}}"
                );

        assertThat(prepareResponse.getData().getActivityId()).isEqualTo(1000L);
        assertThat(prepareResponse.getData().getCouponStatus()).isEqualTo("可核销");
        assertThat(restrictionResponse.getData().getStatus()).isTrue();
        assertThat(restrictionResponse.getData().getData().getUnusableDays()).isEqualTo("周一");
    }

    @Test
    void shouldDeserializeEveryDocumentedNestedResponseWithoutLosingLongPrecision() {
        MeituanResponse<FreetryLoadCouponResponse> loadResponse = new FreetryLoadCouponRequest()
                .deserializeResponse("{\"code\":\"OP_SUCCESS\",\"data\":{" +
                        "\"code\":200,\"status\":true,\"msg\":\"success\",\"data\":{" +
                        "\"coupon\":{\"couponCode\":\"1234567890123\",\"couponStatus\":\"已核销\"," +
                        "\"verifyTime\":9223372036854775806,\"activityId\":9223372036854775807," +
                        "\"activityTitle\":\"肯德基单人套餐\",\"userPhoneTail\":\"9527\"}," +
                        "\"activity\":{\"activityId\":9223372036854775807," +
                        "\"activityTitle\":\"肯德基单人套餐\",\"projectName\":\"双人套餐\"," +
                        "\"branchQuota\":20,\"applyBeginTime\":100," +
                        "\"applyEndTime\":200,\"receptionBeginTime\":300," +
                        "\"receptionEndTime\":400,\"activityContent\":\"体验内容\"," +
                        "\"activityValue\":\"1000\"}}}}"
                );
        MeituanResponse<FreetryQueryPoiCouponResponse> historyResponse = new FreetryQueryPoiCouponRequest()
                .deserializeResponse("{\"code\":\"OP_SUCCESS\",\"data\":{" +
                        "\"code\":200,\"status\":true,\"msg\":\"success\",\"data\":{" +
                        "\"totalCnt\":1,\"couponList\":[{\"couponCode\":\"1234567890123\"," +
                        "\"verifyTime\":9223372036854775806,\"activityId\":9223372036854775807," +
                        "\"activityTitle\":\"肯德基单人套餐\"}]}}}"
                );
        MeituanResponse<FreetryQueryActivitiesByPoiResponse> activitiesResponse =
                new FreetryQueryActivitiesByPoiRequest()
                        .deserializeResponse("{\"code\":\"OP_SUCCESS\",\"data\":{" +
                                "\"code\":200,\"status\":true,\"msg\":\"success\",\"data\":{" +
                                "\"activityList\":[{\"activityId\":9223372036854775807," +
                                "\"activityTitle\":\"肯德基单人套餐\",\"projectName\":\"双人套餐\"," +
                                "\"branchQuota\":100,\"applyBeginTime\":100," +
                                "\"applyEndTime\":200,\"receptionBeginTime\":300," +
                                "\"receptionEndTime\":400,\"activityContent\":\"体验内容\"," +
                                "\"activityValue\":\"1000\"}]}}}"
                        );

        assertThat(loadResponse.getData().getData().getCoupon().getActivityId()).isEqualTo(Long.MAX_VALUE);
        assertThat(loadResponse.getData().getData().getActivity().getProjectName()).isEqualTo("双人套餐");
        assertThat(historyResponse.getData().getData().getTotalCnt()).isEqualTo(1);
        assertThat(historyResponse.getData().getData().getCouponList()).singleElement()
                .extracting(FreetryCouponData::getVerifyTime)
                .isEqualTo(Long.MAX_VALUE - 1);
        assertThat(activitiesResponse.getData().getData().getActivityList()).singleElement()
                .extracting(FreetryActivityData::getActivityId)
                .isEqualTo(Long.MAX_VALUE);
    }
}
