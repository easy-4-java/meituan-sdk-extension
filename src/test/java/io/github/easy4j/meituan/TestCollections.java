package io.github.easy4j.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试使用的 Java 8 集合工厂，保持三条发布分支共享同一套测试源码。
 */
public final class TestCollections {

    private TestCollections() {
    }

    /** 创建保持参数顺序的可变列表。 */
    @SafeVarargs
    public static <T> List<T> listOf(T... values) {
        return new ArrayList<T>(Arrays.asList(values));
    }

    /** 创建保持参数顺序的可变集合。 */
    @SafeVarargs
    public static <T> Set<T> setOf(T... values) {
        return new LinkedHashSet<T>(Arrays.asList(values));
    }

    /**
     * 按 key、value 交替参数创建保持顺序的可变映射。
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> mapOf(Object... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new IllegalArgumentException("keyValues length must be even");
        }
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (int index = 0; index < keyValues.length; index += 2) {
            result.put((K) keyValues[index], (V) keyValues[index + 1]);
        }
        return result;
    }
}
