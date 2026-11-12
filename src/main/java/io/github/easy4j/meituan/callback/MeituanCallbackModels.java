package io.github.easy4j.meituan.callback;

import io.github.easy4j.meituan.callback.type.MeituanBusiness1MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness2MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness3MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness7MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness15MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness16MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness18MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness19MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness27MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness31MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness46MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness49MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness51MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness52MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness55MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness58MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness59MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness61MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness63MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness71MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness77MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness79MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness86MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness87MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness92MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness94MessageType;
import io.github.easy4j.meituan.callback.type.MeituanBusiness1000MessageType;
import io.github.easy4j.meituan.callback.type.MeituanMessageType;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 从业务消息枚举建立只读模型索引，供 {@link CallbackUtil} 自动解析。
 * <p>新增业务需要接入该业务的枚举目录；业务内新增回调只需添加枚举项。</p>
 */
public final class MeituanCallbackModels {

    /**
     * 从业务枚举构建的只读消息定义索引。
     */
    private static final Map<String, MeituanMessageType> TYPES = Stream.<MeituanMessageType[]>of(
                    MeituanBusiness1MessageType.values(),
                    MeituanBusiness2MessageType.values(),
                    MeituanBusiness3MessageType.values(),
                    MeituanBusiness7MessageType.values(),
                    MeituanBusiness15MessageType.values(),
                    MeituanBusiness16MessageType.values(),
                    MeituanBusiness18MessageType.values(),
                    MeituanBusiness19MessageType.values(),
                    MeituanBusiness27MessageType.values(),
                    MeituanBusiness31MessageType.values(),
                    MeituanBusiness46MessageType.values(),
                    MeituanBusiness49MessageType.values(),
                    MeituanBusiness51MessageType.values(),
                    MeituanBusiness52MessageType.values(),
                    MeituanBusiness55MessageType.values(),
                    MeituanBusiness58MessageType.values(),
                    MeituanBusiness59MessageType.values(),
                    MeituanBusiness61MessageType.values(),
                    MeituanBusiness63MessageType.values(),
                    MeituanBusiness71MessageType.values(),
                    MeituanBusiness77MessageType.values(),
                    MeituanBusiness79MessageType.values(),
                    MeituanBusiness86MessageType.values(),
                    MeituanBusiness87MessageType.values(),
                    MeituanBusiness92MessageType.values(),
                    MeituanBusiness94MessageType.values(),
                    MeituanBusiness1000MessageType.values()
            )
            .flatMap(Arrays::stream)
            .collect(Collectors.toUnmodifiableMap(
                    type -> type.getBusinessId() + ":" + type.getMsgType(), Function.identity()));

    /**
     * 创建当前类的实例。
     */
    private MeituanCallbackModels() {
    }

    /**
     * 根据业务编号和消息编号查询业务模型。
     * @param businessId 官方业务编号
     * @param msgType 消息类型编号，旧协议也可使用 invokeType
     * @return 模型类；仅核实编号的消息返回 String；未登记或参数为 null 时为空
     */
    public static Optional<Class<?>> find(String businessId, String msgType) {
        if (Objects.isNull(businessId) || Objects.isNull(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(TYPES.get(businessId + ":" + msgType))
                .map(MeituanMessageType::getMessageClass);
    }

    /**
     * 获取全部已登记消息定义。
     * @return 包含编号、名称、文档地址和模型类的只读消息集合，遍历顺序未指定
     */
    public static Collection<MeituanMessageType> all() {
        return TYPES.values();
    }
}
