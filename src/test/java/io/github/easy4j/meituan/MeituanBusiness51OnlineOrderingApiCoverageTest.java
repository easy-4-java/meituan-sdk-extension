package io.github.easy4j.meituan;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.service.MeituanCateringService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店餐饮在线点（businessId=51）公开 API 覆盖回归测试。
 */
class MeituanBusiness51OnlineOrderingApiCoverageTest {

    private static final Set<String> DOCUMENTED_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/foodmop/pay/tuangou/trade/queryByPage",
            "/foodmop/market/tuangou/deal/sku/mapping",
            "/foodmop/order/diancannew/order/pushNotice",
            "/foodmop/order/diancannew/order/fullFillNotice",
            "/foodmop/order/refund",
            "/foodmop/order/refundNotice",
            "/foodmop/order/diancannew/order/finish",
            "/foodmop/order/orderChangeNotice",
            "/foodmop/order/diancannew/order/queryOrder",
            "/foodmop/order/diancannew/order/queryOrderDownloadUrl",
            "/foodmop/sku/saleattr/create",
            "/foodmop/sku/premium/create",
            "/foodmop/sku/create",
            "/foodmop/sku/updateSkuPrice",
            "/foodmop/sku/customrule/create",
            "/foodmop/sku/shopmenu/create",
            "/foodmop/sku/update",
            "/foodmop/sku/updateSpuShelfStatus",
            "/foodmop/sku/shelf/premium/update",
            "/foodmop/sku/diancannew/shelf/saleattr/update",
            "/foodmop/sku/uploadPicture",
            "/foodmop/sku/batchUpdateSkuStock",
            "/foodmop/sku/queryVendorSpu",
            "/foodmop/sku/queryShopMenu",
            "/foodmop/sku/queryVendorSpuPool",
            "/foodmop/sku/saleattr/queryAll",
            "/foodmop/sku/premium/queryAll",
            "/foodmop/sku/batchUpdateSkuPrice",
            "/foodmop/sku/saleattr/query",
            "/foodmop/sku/premium/query",
            "/foodmop/sku/customrule/query",
            "/foodmop/sku/shelf/premium/query",
            "/foodmop/sku/shelf/saleattr/query",
            "/foodmop/sku/queryByShop",
            "/foodmop/sku/batchQuerySkuPrice",
            "/foodmop/sku/combo/create",
            "/foodmop/sku/combo/price/update",
            "/foodmop/shop/status/update",
            "/foodmop/shop/serve/status/update",
            "/foodmop/shop/reserve/config/update",
            "/foodmop/shop/queryByPage",
            "/foodmop/shop/queryShops",
            "/foodmop/shop/tag/push",
            "/foodmop/shop/tag/bind",
            "/foodmop/shop/tag/query",
            "/foodmop/shop/relation/bind",
            "/foodmop/shop/relation/unbind",
            "/foodmop/shop/baseInfo/query",
            "/foodmop/shop/customization/update",
            "/foodmop/shop/orProduct/unbound/query"
    );

    private static final Set<String> OFFICIAL_SDK_EXTRA_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/foodmop/sku/shopmenu/createSpecial",
            "/foodmop/sku/shopmenu/deleteSpecial"
    );

    @Test
    void shouldExposeEveryOfficialFoodmopRequestAndEveryDocumentedApi() throws Exception {
        Map<String, Class<?>> officialRequestsByPath = officialFoodmopRequestsByPath();
        Set<String> expectedOfficialPaths = new java.util.HashSet<>(DOCUMENTED_API_PATHS);
        expectedOfficialPaths.addAll(OFFICIAL_SDK_EXTRA_PATHS);

        assertThat(officialRequestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(expectedOfficialPaths);
        assertThat(DOCUMENTED_API_PATHS).isSubsetOf(officialRequestsByPath.keySet());

        Set<Class<?>> facadeRequestTypes = Arrays.stream(MeituanCateringService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 2)
                .map(method -> method.getParameterTypes()[0])
                .filter(type -> type.getPackage().getName().startsWith("com.meituan.sdk.model.foodmop."))
                .collect(Collectors.toSet());

        assertThat(facadeRequestTypes).containsExactlyInAnyOrderElementsOf(officialRequestsByPath.values());
        for (Class<?> requestType : facadeRequestTypes) {
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            assertThat(apiMeta.businessId()).as("businessId for %s", apiMeta.path()).isEqualTo(51);
            assertThat(apiMeta.needAuth()).as("needAuth for %s", apiMeta.path()).isTrue();
        }
    }

    private Map<String, Class<?>> officialFoodmopRequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = new File(com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation().toURI());
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectFoodmopRequest(entries.nextElement(), requestsByPath);
            }
        }
        return requestsByPath;
    }

    private void collectFoodmopRequest(JarEntry entry, Map<String, Class<?>> requestsByPath) {
        String name = entry.getName();
        if (!name.startsWith("com/meituan/sdk/model/foodmop/") || !name.endsWith("Request.class")) {
            return;
        }
        try {
            Class<?> requestType = Class.forName(
                    name.replace('/', '.').replace(".class", ""),
                    false,
                    getClass().getClassLoader());
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            if (Objects.nonNull(apiMeta)
                    && apiMeta.businessId() == 51
                    && MeituanRequest.class.isAssignableFrom(requestType)) {
                requestsByPath.put(apiMeta.path(), requestType);
            }
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("无法加载官方在线点 Request: " + name, exception);
        }
    }
}
