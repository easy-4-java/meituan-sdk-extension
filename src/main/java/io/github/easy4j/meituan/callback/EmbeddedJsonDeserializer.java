package io.github.easy4j.meituan.callback;

import cn.hutool.core.util.StrUtil;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;

/**
 * 将美团对象或数组字段中的 JSON 字符串按字段的实际 Java 类型读取。
 */
public final class EmbeddedJsonDeserializer extends ValueDeserializer<Object> {

    /**
     * 当前属性声明的目标类型，包含集合元素类型。由 Jackson 在属性绑定时确定。
     */
    private final JavaType fieldType;

    /**
     * 创建供 Jackson 实例化的反序列化器。
     */
    public EmbeddedJsonDeserializer() {
        this(null);
    }

    /**
     * 创建绑定指定字段类型的内嵌 JSON 反序列化器。
     *
     * @param fieldType 字段声明的目标类型及集合元素类型
     */
    private EmbeddedJsonDeserializer(JavaType fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * 按字段目标类型解包内嵌 JSON，并限制连续解包层数。
     *
     * @param parser  定位在业务字段上的 JSON 解析器
     * @param context 当前 JSON 反序列化上下文
     * @param type    声明的目标类型
     * @param depth   当前内嵌 JSON 解包层数
     * @return 按字段目标类型解包内嵌 JSON，并限制连续解包层数的结果
     */
    private static Object read(JsonParser parser, DeserializationContext context, JavaType type, int depth) {
        if (parser.hasToken(JsonToken.VALUE_STRING) && depth < 3) {
            String json = parser.getString();
            if (StrUtil.isEmpty(json) && type.isContainerType()) {
                return null;
            }
            try (JsonParser nested = context.createParser(json)) {
                nested.nextToken();
                return read(nested, context, type, depth + 1);
            }
        }
        return context.readValue(parser, type);
    }

    /**
     * 为当前属性绑定目标类型，以便按声明的对象或集合类型解码。
     *
     * @param context  Jackson 的反序列化上下文
     * @param property 声明了内嵌 JSON 的属性
     * @return 绑定该属性类型的反序列化器
     */
    @Override
    public ValueDeserializer<?> createContextual(DeserializationContext context, BeanProperty property) {
        return new EmbeddedJsonDeserializer(property.getType());
    }

    // 部分示例对同一字段连续编码两次。限制解包层数，同时支持平台直接推送 JSON 对象。

    /**
     * 将 JSON 值或经过字符串编码的 JSON 读为当前属性的类型。
     *
     * @param parser  定位在属性值上的解析器
     * @param context Jackson 的反序列化上下文
     * @return 解码后的属性值；容器字段收到空字符串时返回 {@code null}
     */
    @Override
    public Object deserialize(JsonParser parser, DeserializationContext context) {
        return read(parser, context, fieldType, 0);
    }
}
