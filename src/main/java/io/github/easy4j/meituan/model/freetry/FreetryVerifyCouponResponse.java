package io.github.easy4j.meituan.model.freetry;

import lombok.Data;

/**
 * 免费试执行验券响应。
 */
@Data
public class FreetryVerifyCouponResponse {

    /** 创建验券响应。 */
    public FreetryVerifyCouponResponse() {
    }

    /** 验券结果码。 */
    private Integer verifyResultCode;

    /** 验券结果说明。 */
    private String verifyResult;
}
