package io.github.easy4j.meituan.callback;


import cn.hutool.core.util.StrUtil;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 美团回调 SHA-1 签名与验签工具。
 *
 * <p>签名源串为 {@code signKey + 按 key 字典序拼接 key/value}；
 * {@code sign}、{@code signature}、null value 和空字符串 value 不参与计算。</p>
 */
public final class MeituanCallbackSigner {

    /**
     * 小写十六进制编码的字符表。
     */
    private static final char[] HEX = "0123456789abcdef".toCharArray();

    /**
     * 创建当前类的实例。
     */
    private MeituanCallbackSigner() {
    }

    /**
     * 计算回调参数签名。
     *
     * @param signKey 应用签名密钥
     * @param parameters 回调参数
     * @return SHA-1 小写十六进制签名
     * @throws IllegalArgumentException 当签名密钥为空白时
     * @throws NullPointerException 当参数映射为 {@code null} 时
     */
    public static String sign(String signKey, Map<String, String> parameters) {
        if (StrUtil.isBlank(signKey)) {
            throw new IllegalArgumentException("signKey must not be blank");
        }
        Objects.requireNonNull(parameters, "parameters must not be null");

        Map<String, String> sortedParameters = new TreeMap<>();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            if (Objects.isNull(entry.getKey()) || Objects.isNull(entry.getValue()) || entry.getValue().isEmpty()) {
                continue;
            }
            if ("sign".equalsIgnoreCase(entry.getKey()) || "signature".equalsIgnoreCase(entry.getKey())) {
                continue;
            }
            sortedParameters.put(entry.getKey(), entry.getValue());
        }

        StringBuilder source = new StringBuilder(signKey);
        sortedParameters.forEach((key, value) -> source.append(key).append(value));
        return sha1Hex(source.toString());
    }

    /**
     * 使用常量时间字节比较验证回调签名。
     *
     * @param signKey 应用签名密钥
     * @param parameters 回调参数
     * @param clientSign 平台下发签名
     * @return 签名有效时返回 true
     */
    public static boolean verify(String signKey, Map<String, String> parameters, String clientSign) {
        if (StrUtil.isBlank(signKey) || StrUtil.isBlank(clientSign) || Objects.isNull(parameters)) {
            return false;
        }
        byte[] expected = sign(signKey, parameters).getBytes(StandardCharsets.US_ASCII);
        byte[] actual = clientSign.toLowerCase(Locale.ROOT).getBytes(StandardCharsets.US_ASCII);
        return MessageDigest.isEqual(expected, actual);
    }

    /**
     * 将签名原文计算为小写 SHA-1 十六进制摘要。
     *
     * @param source 待计算摘要的签名文本
     * @return 将签名原文计算为小写 SHA-1 十六进制摘要的结果
     */
    private static String sha1Hex(String source) {
        try {
            byte[] hash = MessageDigest.getInstance("SHA-1")
                    .digest(source.getBytes(StandardCharsets.UTF_8));
            char[] encoded = new char[hash.length * 2];
            for (int index = 0; index < hash.length; index++) {
                int value = hash[index] & 0xff;
                encoded[index * 2] = HEX[value >>> 4];
                encoded[index * 2 + 1] = HEX[value & 0x0f];
            }
            return new String(encoded);
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("SHA-1 algorithm is unavailable", exception);
        }
    }
}
