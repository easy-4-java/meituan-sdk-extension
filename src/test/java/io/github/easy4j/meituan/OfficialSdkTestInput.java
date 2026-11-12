package io.github.easy4j.meituan;
import java.io.File;
/** 官方 SDK 覆盖测试的输入构件。 */
final class OfficialSdkTestInput {
    private OfficialSdkTestInput() {}
    static File jar() throws Exception {
        return new File(com.meituan.sdk.MeituanClient.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    }
}
