package io.github.easy4j.meituan.utils;

import java.util.Objects;

/**
 * 极简字符串工具。
 * <p>仅保留核心模块所需的少量判断，避免核心模块引入 Spring 依赖。</p>
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * 判断字符串是否有实际内容（非 null 且包含非空白字符）。
     *
     * @param str 待检查字符串
     * @return 有实际内容时返回 true
     */
    public static boolean hasText(String str) {
        if (Objects.isNull(str)) {
            return false;
        }
        return !str.trim().isEmpty();
    }
}
