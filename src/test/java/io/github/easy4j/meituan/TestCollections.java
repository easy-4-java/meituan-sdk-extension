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

    /**
     * 创建当前类的实例。
     */
    private TestCollections() {
    }

    /**
     * \u521b\u5efa\u4fdd\u6301\u53c2\u6570\u987a\u5e8f\u7684\u53ef\u53d8\u5217\u8868\u3002
     *
     * @param <T> 本次调用使用的业务数据类型
     * @param values 构造测试列表或集合的元素
     * @return 与请求参数对应的处理结果
     */
    @SafeVarargs
    public static <T> List<T> listOf(T... values) {
        return new ArrayList<T>(Arrays.asList(values));
    }

    /**
     * \u521b\u5efa\u4fdd\u6301\u53c2\u6570\u987a\u5e8f\u7684\u53ef\u53d8\u96c6\u5408\u3002
     *
     * @param <T> 本次调用使用的业务数据类型
     * @param values 构造测试列表或集合的元素
     * @return 与请求参数对应的处理结果
     */
    @SafeVarargs
    public static <T> Set<T> setOf(T... values) {
        return new LinkedHashSet<T>(Arrays.asList(values));
    }

    /**
     * 按 key、value 交替参数创建保持顺序的可变映射。
     * @param <K> 本次调用使用的业务数据类型
     * @param <V> 本次调用使用的业务数据类型
     * @param keyValues 按键和值交替排列的测试参数，元素数量应为偶数
     * @return 与请求参数对应的处理结果
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
