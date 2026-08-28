package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.jmcard.cards.createOrUpdate.CreateOrUpdateRequest;
import com.meituan.sdk.model.jmcard.members.memberQuery.MemberQueryRequest;
import com.meituan.sdk.model.jmcard.members.memberUpdate.MemberUpdateRequest;

/**
 * 客满满业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanKemanmanService extends MeituanService {

    /**
     * 创建/更新会员卡模板数据。
     * <p>官方接口：{@code /jmcard/cards/create-or-update}，API：{@code create_or_update}，版本：{@code 10001}，businessId：{@code 15}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createOrUpdate(CreateOrUpdateRequest request, String tenantId);

    /**
     * 查询用户会员卡信息。
     * <p>官方接口：{@code /jmcard/members/query}，API：{@code member_query}，版本：{@code 10001}，businessId：{@code 15}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> memberQuery(MemberQueryRequest request, String tenantId);

    /**
     * 会员信息更新。
     * <p>官方接口：{@code /jmcard/members/update}，API：{@code member_update}，版本：{@code 10005}，businessId：{@code 15}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> memberUpdate(MemberUpdateRequest request, String tenantId);
}
