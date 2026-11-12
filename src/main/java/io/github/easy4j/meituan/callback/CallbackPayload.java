package io.github.easy4j.meituan.callback;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识官网消息业务模型，供 {@link CallbackUtil} 识别消息的传输格式。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CallbackPayload {

    /**
     * 指定通用解析器读取业务内容时使用的参数名。
     *
     * @return 默认值为 {@code message}；空字符串表示直接将表单映射为业务对象
     */
    String value() default "message";
}
