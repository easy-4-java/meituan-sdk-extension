package io.github.easy4j.meituan;

import com.meituan.sdk.internal.exceptions.MtSdkException;
import com.meituan.sdk.internal.utils.ValidationUtil;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.OrderQueryorderRequest;
import io.github.easy4j.meituan.model.jmcard.MeituanMemberClaimRequest;
import io.github.easy4j.meituan.model.jmcard.MeituanMemberClaimUserRight;
import jakarta.validation.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Jakarta 线必须同时验证官方请求与扩展库自有嵌套 DTO。 */
class MeituanJakartaValidationTest {

    /**
     * 创建Jakarta \u7ebf\u5fc5\u987b\u540c\u65f6\u9a8c\u8bc1\u5b98\u65b9\u8bf7\u6c42\u4e0e\u6269\u5c55\u5e93\u81ea\u6709\u5d4c\u5957 DTO\u3002的空实例。
     */
    MeituanJakartaValidationTest() {
    }

    /**
     * \u539f\u59cb SDK \u7684\u5fc5\u586b\u7ea6\u675f\u8f6c\u6362\u540e\u4ecd\u5e94\u88ab Jakarta \u6821\u9a8c\u5e76\u4fdd\u7559\u5b98\u65b9\u53c2\u6570\u5f02\u5e38\u3002
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void official_request_retains_required_constraints() throws Exception {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            assertFalse(factory.getValidator().validate(new OrderQueryorderRequest()).isEmpty());
        }
        assertThrows(MtSdkException.class, () -> ValidationUtil.validate(new OrderQueryorderRequest()));
    }

    /**
     * \u6269\u5c55 DTO \u7684\u5d4c\u5957\u7ea6\u675f\u4e0d\u53ef\u56e0\u547d\u540d\u7a7a\u95f4\u4e0d\u4e00\u81f4\u88ab\u9759\u9ed8\u5ffd\u7565\u3002
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void extension_request_retains_cascaded_constraints() throws Exception {
        var request = new MeituanMemberClaimRequest();
        request.setUserRightInfo(new MeituanMemberClaimUserRight());
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var paths = factory.getValidator().validate(request).stream()
                    .map(violation -> violation.getPropertyPath().toString()).toList();
            assertTrue(paths.contains("userRightInfo.eventId"), paths.toString());
            assertTrue(paths.contains("userRightInfo.phoneNo"), paths.toString());
            assertTrue(paths.contains("userRightInfo.pureNewUser"), paths.toString());
        }
    }
}
