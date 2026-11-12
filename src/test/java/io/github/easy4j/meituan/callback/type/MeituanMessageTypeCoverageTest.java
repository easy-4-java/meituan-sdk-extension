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
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 校验消息枚举和解析注册表的双向覆盖及业务隔离。
 */
class MeituanMessageTypeCoverageTest {

    @Test
    void matchesEveryRegisteredIdentifierAndResolvesOnlyItsOwnBusiness() throws Exception {
        Path source = Path.of("src/main/java/io/github/easy4j/meituan/callback");
        Set<String> registered = new HashSet<>();
        for (MeituanMessageType type : MeituanCallbackModels.all()) {
            assertThat(registered.add(type.getBusinessId() + ":" + type.getMsgType())).isTrue();
            assertThat(MeituanCallbackModels.find(type.getBusinessId(), type.getMsgType()))
                    .contains(type.getMessageClass());
        }
        assertThat(registered).hasSizeGreaterThanOrEqualTo(282);
        Set<String> enumerated = new HashSet<>();
        try (var files = Files.list(source.resolve("type"))) {
            for (Path file : files.filter(p -> p.getFileName().toString().matches("MeituanBusiness[0-9]+MessageType\\.java")).toList()) {
                Class<?> type = Class.forName("io.github.easy4j.meituan.callback.type."
                        + file.getFileName().toString().replace(".java", ""));
                assertThat(type.getMethod("fromMsgType", String.class).invoke(null, (String) null))
                        .isEqualTo(Optional.empty());
                assertThat(type.getMethod("fromMsgType", String.class).invoke(null, "unknown"))
                        .isEqualTo(Optional.empty());
                assertThat(type.getMethod("resolve", MeituanCallbackMessage.class).invoke(null, (Object) null))
                        .isEqualTo(Optional.empty());
                for (Object constant : type.getEnumConstants()) {
                    MeituanMessageType definition = (MeituanMessageType) constant;
                    assertThat(MeituanCallbackModels.all()).contains(definition);
                    String businessId = type.getSimpleName().replace("MeituanBusiness", "").replace("MessageType", "");
                    String msgType = (String) type.getMethod("getMsgType").invoke(constant);
                    assertThat(definition.getBusinessId()).isEqualTo(businessId);
                    assertThat(definition.getMsgType()).isEqualTo(msgType);
                    String key = businessId + ":" + msgType;
                    assertThat(enumerated.add(key)).as("unique enum for %s", key).isTrue();
                    Class<?> model = MeituanCallbackModels.find(businessId, msgType).orElseThrow();
                    assertThat(model).isEqualTo(definition.getMessageClass());
                    var parsed = CallbackUtil.parse("businessId=" + businessId + "&msgType=" + msgType,
                            Map.of("message", Collection.class.isAssignableFrom(model) ? "[]" : "{}"));
                    assertThat(parsed.getMessage()).as(key).isInstanceOf(model);
                    assertThat((String) type.getMethod("getDisplayName").invoke(constant)).isNotBlank();
                    URI document = URI.create((String) type.getMethod("getDocumentUrl").invoke(constant));
                    assertThat(document.getHost()).isEqualTo("developer.meituan.com");
                    assertThat(type.getMethod("fromMsgType", String.class).invoke(null, msgType))
                            .isEqualTo(Optional.of(constant));
                    var callback = CallbackUtil.parse("businessId=" + businessId + "&msgType=" + msgType,
                            Map.of("message", "{}"), String.class);
                    assertThat(type.getMethod("resolve", MeituanCallbackMessage.class).invoke(null, callback))
                            .isEqualTo(Optional.of(constant));
                    var other = CallbackUtil.parse("businessId=unknown&msgType=" + msgType,
                            Map.of("message", "{}"), String.class);
                    assertThat(type.getMethod("resolve", MeituanCallbackMessage.class).invoke(null, other))
                            .isEqualTo(Optional.empty());
                }
            }
        }
        assertThat(enumerated).containsExactlyInAnyOrderElementsOf(registered);
        assertThatThrownBy(() -> MeituanCallbackModels.all().clear())
                .isInstanceOf(UnsupportedOperationException.class);
        assertThat(MeituanCallbackModels.find(null, "1")).isEmpty();
        assertThat(MeituanCallbackModels.find("1", null)).isEmpty();
        assertThat(MeituanCallbackModels.find("unknown", "unknown")).isEmpty();
    }
}
