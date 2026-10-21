package io.github.easy4j.meituan;

import java.io.File;
import java.util.Objects;

/** API 覆盖断言以固定原始 SDK 为清单基线，执行类仍来自当前扩展构件。 */
final class OfficialSdkTestInput {
    private OfficialSdkTestInput() {
    }

    /** 返回构建前已通过哈希校验的官方 JAR，缺少配置时明确失败。 */
    static File jar() {
        String location = System.getProperty("meituan.sdk.reference");
        if (Objects.isNull(location) || location.isBlank()) {
            throw new IllegalStateException("必须指定已校验的 meituan.sdk.reference");
        }
        File jar = new File(location);
        if (!jar.isFile()) {
            throw new IllegalStateException("官方 SDK 参考 JAR 不存在");
        }
        return jar;
    }
}
