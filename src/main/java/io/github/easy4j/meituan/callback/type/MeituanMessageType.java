package io.github.easy4j.meituan.callback.type;

/**
 * 回调消息的统一定义，由各业务枚举集中登记。
 */
public interface MeituanMessageType {

    /**
     * 返回所属业务编号。
     *
     * @return 官方 businessId
     */
    String getBusinessId();

    /**
     * 返回业务消息编号。
     *
     * @return 官方 msgType，旧协议也可使用 invokeType
     */
    String getMsgType();

    /**
     * 返回消息名称。
     *
     * @return 官网消息名称
     */
    String getDisplayName();

    /**
     * 返回消息的官网说明地址。
     *
     * @return 完整文档 URL
     */
    String getDocumentUrl();

    /**
     * 返回业务内容的反序列化目标类型。
     *
     * @return 消息模型类；仅核实编号的消息使用 String 保留业务原文
     */
    Class<?> getMessageClass();
}
