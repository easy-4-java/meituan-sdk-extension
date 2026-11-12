package io.github.easy4j.meituan;
import java.io.File;
/** 官方 SDK 覆盖测试的输入构件。 */
final class OfficialSdkTestInput {
    /**
     * 创建当前类的实例。
     */
    private OfficialSdkTestInput() {}
    /**
     * 返回覆盖测试所使用的官方 SDK 参考 JAR。
     *
     * @return 返回覆盖测试所使用的官方 SDK 参考 JAR的结果
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    static File jar() throws Exception {
        return new File(com.meituan.sdk.MeituanClient.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    }
}
