package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.jmcard.cards.createOrUpdate.CreateOrUpdateRequest;
import com.meituan.sdk.model.jmcard.members.memberQuery.MemberQueryRequest;
import com.meituan.sdk.model.jmcard.members.memberUpdate.MemberUpdateRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanKemanmanService;

/**
 * 客满满默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanKemanmanServiceImpl extends AbstractMeituanService implements MeituanKemanmanService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanKemanmanServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createOrUpdate(CreateOrUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> memberQuery(MemberQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> memberUpdate(MemberUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
