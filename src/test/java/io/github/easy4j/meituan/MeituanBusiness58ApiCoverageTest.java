package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.service.MeituanRetailService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 开发者 119358 的服务零售（businessId=58）有文档 API 覆盖回归测试。
 */
class MeituanBusiness58ApiCoverageTest {

    private static final Set<String> DOCUMENTED_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/ddzh/tuangou/receipt/prepare",
            "/ddzh/tuangou/product/queryproductbytype",
            "/ddzh/tuangou/product/queryproduct",
            "/ddzh/tuangou/receipt/querybymobile",
            "/ddzh/tuangou/receipt/consume",
            "/ddzh/tuangou/deal/queryshopdeal",
            "/ddzh/tuangou/receipt/getconsumed",
            "/ddzh/tuangou/receipt/reverseconsume",
            "/ddzh/tuangou/receipt/querylistbydate",
            "/ddzh/tuangou/receipt/queryproduct",
            "/ddzh/tuangou/receipt/batchconsume",
            "/ddzh/tuangou/apply/refund",
            "/ddzh/tuangou/query/refund/info",
            "/ddzh/tuangou/refund/audit",
            "/ddzh/tuangou/pre/refund/valid",
            "/ddzh/tuangou/receipt/batch/reverseconsume",
            "/ddzh/tuangou/goods/startprepare",
            "/ddzh/tuangou/goods/prepared",
            "/ddzh/tuangou/order/result/callback",
            "/ddzh/tuangou/product/stockquery",
            "/ddzh/tuangou/goods/stock/sync",
            "/ddzh/tuangou/receipt/queryrelevantusable",
            "/ddzh/tuangou/paybill/query",
            "/ddzh/tuangou/paybill/refund"
    );

    @Test
    void shouldWrapEveryDocumentedBusiness58ApiInRetailFacade() throws Exception {
        Map<String, Class<?>> requestsByPath = documentedRequestsByPath();
        Set<Class<?>> facadeRequestTypes = new HashSet<>();
        for (Method method : MeituanRetailService.class.getDeclaredMethods()) {
            if (method.getParameterCount() > 0) {
                facadeRequestTypes.add(method.getParameterTypes()[0]);
            }
        }

        assertThat(requestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(DOCUMENTED_API_PATHS);
        assertThat(facadeRequestTypes).containsAll(requestsByPath.values());
    }

    private Map<String, Class<?>> documentedRequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = new File(com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation().toURI());
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectDocumentedRequest(entries.nextElement(), requestsByPath);
            }
        }
        return requestsByPath;
    }

    private void collectDocumentedRequest(JarEntry entry, Map<String, Class<?>> requestsByPath) {
        String name = entry.getName();
        if (!name.startsWith("com/meituan/sdk/model/") || !name.endsWith("Request.class")) {
            return;
        }
        try {
            Class<?> requestClass = Class.forName(name.replace('/', '.').replace(".class", ""),
                    false, getClass().getClassLoader());
            ApiMeta apiMeta = requestClass.getAnnotation(ApiMeta.class);
            if (Objects.nonNull(apiMeta)
                    && apiMeta.businessId() == 58
                    && DOCUMENTED_API_PATHS.contains(apiMeta.path())) {
                requestsByPath.put(apiMeta.path(), requestClass);
            }
        } catch (LinkageError | ClassNotFoundException ignored) {
            // 与全量覆盖测试一致：仅处理当前类路径能够加载的官方 Request。
        }
    }
}
