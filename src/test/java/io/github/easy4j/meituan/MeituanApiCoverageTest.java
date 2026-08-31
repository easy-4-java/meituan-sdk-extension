package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 门面覆盖度测试：扫描官方 MtOpJavaSDK jar，确保所有带 {@link ApiMeta} 元数据的
 * 可执行 Request 类都被某个 Meituan*Service 门面方法的参数类型引用。
 *
 * <p>排除规则（与生成口径一致）：</p>
 * <ul>
 *     <li>{@code com.meituan.sdk.model.corgiTest}：官方测试接口，不做生产封装；</li>
 *     <li>无 {@code @ApiMeta} 的类：官方基础/内部请求，不可通过 invokeApi 直接执行。</li>
 * </ul>
 */
class MeituanApiCoverageTest {

    /** 全部业务门面接口。 */
    private static final String[] FACADES = {
            "io.github.easy4j.meituan.service.MeituanCateringService",
            "io.github.easy4j.meituan.service.MeituanDaocanService",
            "io.github.easy4j.meituan.service.MeituanDeliveryService",
            "io.github.easy4j.meituan.service.MeituanDistributionService",
            "io.github.easy4j.meituan.service.MeituanFreetryService",
            "io.github.easy4j.meituan.service.MeituanKemanmanService",
            "io.github.easy4j.meituan.service.MeituanKuailvService",
            "io.github.easy4j.meituan.service.MeituanLiveService",
            "io.github.easy4j.meituan.service.MeituanPayService",
            "io.github.easy4j.meituan.service.MeituanRetailService",
            "io.github.easy4j.meituan.service.MeituanStoreService",
            "io.github.easy4j.meituan.service.MeituanToolsService",
            "io.github.easy4j.meituan.service.MeituanTravelService",
            "io.github.easy4j.meituan.service.MeituanWaimaiService",
    };

    @Test
    void allApiMetaRequestsAreWrappedByFacadeMethods() throws Exception {
        File jar = findOfficialSdkJar();
        List<String> uncovered = new ArrayList<>();
        int covered = 0;

        Set<String> facadeParamTypes = facadeParamTypes();
        try (JarFile jarFile = new JarFile(jar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (!name.startsWith("com/meituan/sdk/model/") || !name.endsWith("Request.class")) {
                    continue;
                }
                String className = name.replace('/', '.').replace(".class", "");
                if (className.startsWith("com.meituan.sdk.model.corgiTest")) {
                    continue;
                }
                Class<?> requestClass = Class.forName(className, false, getClass().getClassLoader());
                if (requestClass.getAnnotation(ApiMeta.class) == null) {
                    continue;
                }
                if (facadeParamTypes.contains(className)) {
                    covered++;
                } else {
                    uncovered.add(className);
                }
            }
        }
        // 健康下限：官方 SDK 应至少解析出上千个带 @ApiMeta 的 Request，
        // 防止 jar 定位失败导致的"扫到 0 个类而误过"。
        assertTrue(covered > 900,
                "官方 SDK @ApiMeta Request 覆盖数异常偏低: " + covered + "，请检查 jar 定位");
        assertTrue(uncovered.isEmpty(),
                "以下带 @ApiMeta 的官方 Request 未被任何门面封装: " + uncovered + " (已覆盖 " + covered + ")");
    }

    private Set<String> facadeParamTypes() throws Exception {
        Set<String> paramTypes = new HashSet<>();
        for (String facade : FACADES) {
            Class<?> service = Class.forName(facade, false, getClass().getClassLoader());
            for (Method method : service.getDeclaredMethods()) {
                if (method.getParameterCount() > 0) {
                    paramTypes.add(method.getParameterTypes()[0].getName());
                }
            }
        }
        return paramTypes;
    }

    private File findOfficialSdkJar() throws Exception {
        java.net.URL location = com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation();
        File file = new File(location.toURI());
        assertTrue(file.getName().endsWith(".jar"),
                "官方 SDK 应以 jar 形式存在: " + file);
        return file;
    }
}
