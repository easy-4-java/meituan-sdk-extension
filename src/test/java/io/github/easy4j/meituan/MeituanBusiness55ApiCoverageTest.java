package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.model.freetry.FreetryLoadActivityRestrictionRequest;
import io.github.easy4j.meituan.model.freetry.FreetryLoadCouponRequest;
import io.github.easy4j.meituan.model.freetry.FreetryPrepareVerifyRequest;
import io.github.easy4j.meituan.model.freetry.FreetryQueryActivitiesByPoiRequest;
import io.github.easy4j.meituan.model.freetry.FreetryQueryPoiCouponRequest;
import io.github.easy4j.meituan.model.freetry.FreetryVerifyCouponRequest;
import io.github.easy4j.meituan.service.MeituanFreetryService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 大众点评免费试（businessId=55）公开 API 覆盖回归测试。
 */
class MeituanBusiness55ApiCoverageTest {

    private static final Map<Class<?>, String> DOCUMENTED_REQUESTS = io.github.easy4j.meituan.TestCollections.mapOf(
            FreetryLoadActivityRestrictionRequest.class, "/freetry/open/coupon/loadActivityRestriction",
            FreetryLoadCouponRequest.class, "/freetry/open/coupon/load",
            FreetryQueryPoiCouponRequest.class, "/freetry/open/coupon/queryPoiCoupon",
            FreetryVerifyCouponRequest.class, "/freetry/open/coupon/verify",
            FreetryQueryActivitiesByPoiRequest.class, "/freetry/open/coupon/queryActivitiesByPoi",
            FreetryPrepareVerifyRequest.class, "/freetry/open/coupon/prepareVerify"
    );

    @Test
    void shouldDeclareEveryDocumentedBusiness55ApiWithRuntimeRoutingMetadata() {
        DOCUMENTED_REQUESTS.forEach((requestType, path) -> {
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);

            assertThat(apiMeta).isNotNull();
            assertThat(apiMeta.path()).isEqualTo(path);
            assertThat(apiMeta.businessId()).isEqualTo(55);
            // 官方未发布这些模型的端点元数据版本；网关公共参数 version=2 由 MeituanConfig 管理。
            assertThat(apiMeta.apiVersion()).isEmpty();
            assertThat(apiMeta.needAuth()).isTrue();
        });
    }

    @Test
    void shouldExposeEveryDocumentedBusiness55ApiFromFreetryFacade() {
        Set<Class<?>> facadeRequestTypes = io.github.easy4j.meituan.TestCollections.setOf(MeituanFreetryService.class.getDeclaredMethods()).stream()
                .filter(method -> method.getParameterCount() == 2)
                .map(method -> method.getParameterTypes()[0])
                .collect(Collectors.toSet());

        assertThat(facadeRequestTypes).containsExactlyInAnyOrderElementsOf(DOCUMENTED_REQUESTS.keySet());
        assertThat(MeituanFreetryService.class.getDeclaredMethods())
                .extracting(Method::getName)
                .containsExactlyInAnyOrder(
                        "loadActivityRestriction",
                        "loadCoupon",
                        "queryPoiCoupon",
                        "verifyCoupon",
                        "queryActivitiesByPoi",
                        "prepareVerify"
                );
    }
}
