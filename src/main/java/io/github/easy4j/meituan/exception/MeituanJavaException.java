package io.github.easy4j.meituan.exception;

/**
 * SDK 统一运行时异常。
 * <p>用于包装官方 MtOpJavaSDK 调用异常和本 SDK 的配置错误，方便上层业务按一个异常类型处理。</p>
 */
public class MeituanJavaException extends RuntimeException {

    /**
     * 创建只包含错误信息的异常。
     *
     * @param message 错误信息
     */
    public MeituanJavaException(String message) {
        super(message);
    }

    /**
     * 创建带原始异常原因的异常。
     *
     * @param message 错误信息
     * @param cause   原始异常
     */
    public MeituanJavaException(String message, Throwable cause) {
        super(message, cause);
    }
}
