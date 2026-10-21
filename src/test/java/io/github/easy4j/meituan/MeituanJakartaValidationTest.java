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
    /** 原始 SDK 的必填约束转换后仍应被 Jakarta 校验并保留官方参数异常。 */
    @Test
    void official_request_retains_required_constraints() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            assertFalse(factory.getValidator().validate(new OrderQueryorderRequest()).isEmpty());
        }
        assertThrows(MtSdkException.class, () -> ValidationUtil.validate(new OrderQueryorderRequest()));
    }

    /** 扩展 DTO 的嵌套约束不可因命名空间不一致被静默忽略。 */
    @Test
    void extension_request_retains_cascaded_constraints() {
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
