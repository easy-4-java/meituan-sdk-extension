package io.github.easy4j.meituan;

import java.io.File;
import java.util.Objects;

/** API 覆盖断言以固定原始 SDK 为清单基线，执行类仍来自当前扩展构件。 */
final class OfficialSdkTestInput {
    /**
     * 创建当前类的实例。
     */
    private OfficialSdkTestInput() {
    }

    /**
     * \u8fd4\u56de\u6784\u5efa\u524d\u5df2\u901a\u8fc7\u54c8\u5e0c\u6821\u9a8c\u7684\u5b98\u65b9 JAR\uff0c\u7f3a\u5c11\u914d\u7f6e\u65f6\u660e\u786e\u5931\u8d25\u3002
     *
     * @return 与请求参数对应的处理结果
     */
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
