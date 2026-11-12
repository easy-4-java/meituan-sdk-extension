package io.github.easy4j.meituan.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link MeituanConfig} 单元测试：覆盖默认值与 setter/getter。
 *
 * @author wandl
 */
class MeituanConfigTest {

    /**
     * 创建 单元测试：覆盖默认值与 setter/getter。的空实例。
     */
    MeituanConfigTest() {
    }


    /**
     * 验证平台配置提供默认地址、字符集和协议版本。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_have_default_server_url_charset_and_version() throws Exception {
        MeituanConfig config = new MeituanConfig();
        assertEquals("https://api-open-cater.meituan.com", config.getServerUrl());
        assertEquals("UTF-8", config.getCharset());
        assertEquals("2", config.getVersion());
        assertFalse(Boolean.FALSE.equals(config.getNeedSslCheck()),
                "默认 needSslCheck 应为 null/false，由 SDK 自身决定");
    }

    /**
     * 验证平台配置的各字段可以被显式覆盖。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_allow_overriding_all_fields() throws Exception {
        MeituanConfig config = new MeituanConfig();
        config.setServerUrl("https://staging.api.meituan.com");
        config.setCharset("GBK");
        config.setVersion("3");
        config.setConnectTimeout(3000);
        config.setReadTimeout(5000);
        config.setNeedSslCheck(true);

        assertEquals("https://staging.api.meituan.com", config.getServerUrl());
        assertEquals("GBK", config.getCharset());
        assertEquals("3", config.getVersion());
        assertEquals(Integer.valueOf(3000), config.getConnectTimeout());
        assertEquals(Integer.valueOf(5000), config.getReadTimeout());
        assertTrue(config.getNeedSslCheck());
    }
}