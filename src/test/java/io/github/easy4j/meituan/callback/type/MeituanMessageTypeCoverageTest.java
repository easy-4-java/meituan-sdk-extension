package io.github.easy4j.meituan.callback.type;

import io.github.easy4j.meituan.callback.CallbackUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.MeituanCallbackModels;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 校验消息枚举和解析注册表的双向覆盖及业务隔离。
 */
class MeituanMessageTypeCoverageTest {

    @Test
    void matchesEveryRegisteredIdentifierAndResolvesOnlyItsOwnBusiness() throws Exception {
        Path source = Path.of("src/main/java/io/github/easy4j/meituan/callback");
        Set<String> registered = new HashSet<>();
        var matcher = Pattern.compile("\"([0-9]+):([0-9]+)\"")
                .matcher(Files.readString(source.resolve("MeituanCallbackModels.java")));
        while (matcher.find()) {
            registered.add(matcher.group(1) + ":" + matcher.group(2));
        }
        assertThat(registered).hasSize(282);
        Set<String> enumerated = new HashSet<>();
        try (var files = Files.list(source.resolve("type"))) {
            for (Path file : files.filter(p -> p.getFileName().toString().matches("MeituanBusiness[0-9]+MessageType\\.java")).toList()) {
                Class<?> type = Class.forName("io.github.easy4j.meituan.callback.type."
                        + file.getFileName().toString().replace(".java", ""));
                assertThat(type.getMethod("fromMsgType", String.class).invoke(null, (String) null))
                        .isEqualTo(java.util.Optional.empty());
                assertThat(type.getMethod("fromMsgType", String.class).invoke(null, "unknown"))
                        .isEqualTo(java.util.Optional.empty());
                assertThat(type.getMethod("resolve", MeituanCallbackMessage.class).invoke(null, (Object) null))
                        .isEqualTo(java.util.Optional.empty());
                for (Object constant : type.getEnumConstants()) {
                    String businessId = type.getSimpleName().replace("MeituanBusiness", "").replace("MessageType", "");
                    String msgType = (String) type.getMethod("getMsgType").invoke(constant);
                    String key = businessId + ":" + msgType;
                    assertThat(enumerated.add(key)).as("unique enum for %s", key).isTrue();
                    Class<?> model = MeituanCallbackModels.find(businessId, msgType).orElseThrow();
                    var parsed = CallbackUtil.parse("businessId=" + businessId + "&msgType=" + msgType,
                            Map.of("message", Collection.class.isAssignableFrom(model) ? "[]" : "{}"));
                    assertThat(parsed.getMessage()).as(key).isInstanceOf(model);
                    assertThat((String) type.getMethod("getDisplayName").invoke(constant)).isNotBlank();
                    URI document = URI.create((String) type.getMethod("getDocumentUrl").invoke(constant));
                    assertThat(document.getHost()).isEqualTo("developer.meituan.com");
                    assertThat(type.getMethod("fromMsgType", String.class).invoke(null, msgType))
                            .isEqualTo(java.util.Optional.of(constant));
                    var callback = CallbackUtil.parse("businessId=" + businessId + "&msgType=" + msgType,
                            Map.of("message", "{}"), String.class);
                    assertThat(type.getMethod("resolve", MeituanCallbackMessage.class).invoke(null, callback))
                            .isEqualTo(java.util.Optional.of(constant));
                    var other = CallbackUtil.parse("businessId=unknown&msgType=" + msgType,
                            Map.of("message", "{}"), String.class);
                    assertThat(type.getMethod("resolve", MeituanCallbackMessage.class).invoke(null, other))
                            .isEqualTo(java.util.Optional.empty());
                }
            }
        }
        assertThat(enumerated).containsExactlyInAnyOrderElementsOf(registered);
    }
}
