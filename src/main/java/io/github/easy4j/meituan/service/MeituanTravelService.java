package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.pms.accounting.addGuaranteeItem.AddGuaranteeItemRequest;
import com.meituan.sdk.model.pms.accounting.cancelGuaranteeItem.CancelGuaranteeItemRequest;
import com.meituan.sdk.model.pms.accounting.completeGuaranteeItem.CompleteGuaranteeItemRequest;
import com.meituan.sdk.model.pms.accounting.createOrderBillItem.CreateOrderBillItemRequest;
import com.meituan.sdk.model.pms.accounting.deletedGenerateAddtionnalRoomRent.DeletedGenerateAddtionnalRoomRentRequest;
import com.meituan.sdk.model.pms.accounting.getBillSummary.GetBillSummaryRequest;
import com.meituan.sdk.model.pms.accounting.getBillitems.GetBillitemsRequest;
import com.meituan.sdk.model.pms.accounting.rollback.RollbackRequest;
import com.meituan.sdk.model.pms.accounting.searchGuaranteeItems.SearchGuaranteeItemsRequest;
import com.meituan.sdk.model.pms.accounting.sellSmallWare.SellSmallWareRequest;
import com.meituan.sdk.model.pms.accounting.suspend.SuspendRequest;
import com.meituan.sdk.model.pms.coupon.checkPublishChannelCoupon.CheckPublishChannelCouponRequest;
import com.meituan.sdk.model.pms.coupon.publishChannelCoupon.PublishChannelCouponRequest;
import com.meituan.sdk.model.pms.coupon.queryChannelCouponTemplateList.QueryChannelCouponTemplateListRequest;
import com.meituan.sdk.model.pms.coupon.queryChannelCoupons.QueryChannelCouponsRequest;
import com.meituan.sdk.model.pms.data.queryJy08.QueryJy08Request;
import com.meituan.sdk.model.pms.esports.getLockScreenConfig.GetLockScreenConfigRequest;
import com.meituan.sdk.model.pms.esports.getPcRoomNumber.GetPcRoomNumberRequest;
import com.meituan.sdk.model.pms.esports.pcOpLog.PcOpLogRequest;
import com.meituan.sdk.model.pms.esports.postDevice.PostDeviceRequest;
import com.meituan.sdk.model.pms.esports.powerOnOffLog.PowerOnOffLogRequest;
import com.meituan.sdk.model.pms.esports.syncOnlineStatus.SyncOnlineStatusRequest;
import com.meituan.sdk.model.pms.esports.underageCheck.UnderageCheckRequest;
import com.meituan.sdk.model.pms.hotel.commonGetalladministrativedivisions.CommonGetalladministrativedivisionsRequest;
import com.meituan.sdk.model.pms.hotel.commonGetbusinessdate.CommonGetbusinessdateRequest;
import com.meituan.sdk.model.pms.hotel.commonGetdictionaryitems.CommonGetdictionaryitemsRequest;
import com.meituan.sdk.model.pms.hotel.commonGethotelconfig.CommonGethotelconfigRequest;
import com.meituan.sdk.model.pms.hotel.commonGetservertime.CommonGetservertimeRequest;
import com.meituan.sdk.model.pms.hotel.getCityList.GetCityListRequest;
import com.meituan.sdk.model.pms.hotel.getEbPoiInfo.GetEbPoiInfoRequest;
import com.meituan.sdk.model.pms.hotel.getHotelBuildingInfo.GetHotelBuildingInfoRequest;
import com.meituan.sdk.model.pms.hotel.getHotelInfo.GetHotelInfoRequest;
import com.meituan.sdk.model.pms.hotel.getRooms.GetRoomsRequest;
import com.meituan.sdk.model.pms.hotel.getRoomtypes.GetRoomtypesRequest;
import com.meituan.sdk.model.pms.hotel.queryChannelDirectStatus.QueryChannelDirectStatusRequest;
import com.meituan.sdk.model.pms.hotel.queryChannelGoods.QueryChannelGoodsRequest;
import com.meituan.sdk.model.pms.hotel.searchContract.SearchContractRequest;
import com.meituan.sdk.model.pms.hotel.searchHotels.SearchHotelsRequest;
import com.meituan.sdk.model.pms.hourpriceinve.getHourAvailableRooms.GetHourAvailableRoomsRequest;
import com.meituan.sdk.model.pms.hourpriceinve.getHourRoomPrice.GetHourRoomPriceRequest;
import com.meituan.sdk.model.pms.loyalty.addMemberPoint.AddMemberPointRequest;
import com.meituan.sdk.model.pms.loyalty.consumeMemberPoint.ConsumeMemberPointRequest;
import com.meituan.sdk.model.pms.loyalty.countMemberCoupon.CountMemberCouponRequest;
import com.meituan.sdk.model.pms.loyalty.getMember.GetMemberRequest;
import com.meituan.sdk.model.pms.loyalty.queryMemberGroup.QueryMemberGroupRequest;
import com.meituan.sdk.model.pms.loyalty.queryMemberPointRecord.QueryMemberPointRecordRequest;
import com.meituan.sdk.model.pms.loyalty.register.RegisterRequest;
import com.meituan.sdk.model.pms.loyalty.revokeMemberPoint.RevokeMemberPointRequest;
import com.meituan.sdk.model.pms.loyalty.updateMember.UpdateMemberRequest;
import com.meituan.sdk.model.pms.loyalty.upgradeMemberLevel.UpgradeMemberLevelRequest;
import com.meituan.sdk.model.pms.message.addGuestdemandTask.AddGuestdemandTaskRequest;
import com.meituan.sdk.model.pms.message.pushMessage.PushMessageRequest;
import com.meituan.sdk.model.pms.message.sendSms.SendSmsRequest;
import com.meituan.sdk.model.pms.priceinve.changeRoomStatus.ChangeRoomStatusRequest;
import com.meituan.sdk.model.pms.priceinve.getAvailableRooms.GetAvailableRoomsRequest;
import com.meituan.sdk.model.pms.priceinve.getRoomCount.GetRoomCountRequest;
import com.meituan.sdk.model.pms.priceinve.getRoomCountV2.GetRoomCountV2Request;
import com.meituan.sdk.model.pms.priceinve.getRoomPrice.GetRoomPriceRequest;
import com.meituan.sdk.model.pms.priceinve.getRoomStatus.GetRoomStatusRequest;
import com.meituan.sdk.model.pms.priceinve.lockRooms.LockRoomsRequest;
import com.meituan.sdk.model.pms.priceinve.priceSuggest.PriceSuggestRequest;
import com.meituan.sdk.model.pms.priceinve.queryPriceSuggestionResult.QueryPriceSuggestionResultRequest;
import com.meituan.sdk.model.pms.priceinve.unlockRooms.UnlockRoomsRequest;
import com.meituan.sdk.model.pms.priceinve.updateChannelRoomTypePrice.UpdateChannelRoomTypePriceRequest;
import com.meituan.sdk.model.pms.reservation.addCheckin.AddCheckinRequest;
import com.meituan.sdk.model.pms.reservation.addOrder.AddOrderRequest;
import com.meituan.sdk.model.pms.reservation.addOrderWithCustomPrice.AddOrderWithCustomPriceRequest;
import com.meituan.sdk.model.pms.reservation.addShareWithCustomer.AddShareWithCustomerRequest;
import com.meituan.sdk.model.pms.reservation.adddoorcardrecord.AdddoorcardrecordRequest;
import com.meituan.sdk.model.pms.reservation.cancelOrder.CancelOrderRequest;
import com.meituan.sdk.model.pms.reservation.changeOccupationDurationHourrent.ChangeOccupationDurationHourrentRequest;
import com.meituan.sdk.model.pms.reservation.changeRoom.ChangeRoomRequest;
import com.meituan.sdk.model.pms.reservation.changeStay.ChangeStayRequest;
import com.meituan.sdk.model.pms.reservation.checkout.CheckoutRequest;
import com.meituan.sdk.model.pms.reservation.dispatchOrderRoom.DispatchOrderRoomRequest;
import com.meituan.sdk.model.pms.reservation.generateAddtionnalRoomRent.GenerateAddtionnalRoomRentRequest;
import com.meituan.sdk.model.pms.reservation.queryBreakfast.QueryBreakfastRequest;
import com.meituan.sdk.model.pms.reservation.queryCheckins.QueryCheckinsRequest;
import com.meituan.sdk.model.pms.reservation.queryOrderDeletedOccupations.QueryOrderDeletedOccupationsRequest;
import com.meituan.sdk.model.pms.reservation.queryOrders.QueryOrdersRequest;
import com.meituan.sdk.model.pms.reservation.queryRoomRentSurchargeRule.QueryRoomRentSurchargeRuleRequest;
import com.meituan.sdk.model.pms.reservation.querySingleOrder.QuerySingleOrderRequest;
import com.meituan.sdk.model.pms.reservation.queryUngeneratedRoomRent.QueryUngeneratedRoomRentRequest;
import com.meituan.sdk.model.pms.reservation.searchOccupation.SearchOccupationRequest;
import com.meituan.sdk.model.pms.reservation.updateCheckinMemo.UpdateCheckinMemoRequest;
import com.meituan.sdk.model.pms.reservation.updateOrderMemo.UpdateOrderMemoRequest;
import com.meituan.sdk.model.pms.settle.onlinePay.OnlinePayRequest;
import com.meituan.sdk.model.pms.settle.onlineRefund.OnlineRefundRequest;
import com.meituan.sdk.model.pms.settle.queryPayResult.QueryPayResultRequest;
import com.meituan.sdk.model.pms.tmc.bookingCheck.BookingCheckRequest;
import com.meituan.sdk.model.pms.tmc.getPhysicalRoomtypes.GetPhysicalRoomtypesRequest;
import com.meituan.sdk.model.pms.tmc.queryHotelProducts.QueryHotelProductsRequest;
import com.meituan.sdk.model.pms.tmc.queryOrder.QueryOrderRequest;
import com.meituan.sdk.model.pms.reservation.autoDispatchRoom.AutoDispatchRoomRequest;

/**
 * 酒旅经营宝业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanTravelService extends MeituanService {

    /**
     * 新增预授权。
     * <p>官方接口：{@code /pms/accounting/addGuaranteeItem}，API：{@code add_guarantee_item}，版本：{@code 10015}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addGuaranteeItem(AddGuaranteeItemRequest request, String tenantId);

    /**
     * 取消预授权。
     * <p>官方接口：{@code /pms/accounting/cancelGuaranteeItem}，API：{@code cancel_guarantee_item}，版本：{@code 10011}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cancelGuaranteeItem(CancelGuaranteeItemRequest request, String tenantId);

    /**
     * 完成预授权。
     * <p>官方接口：{@code /pms/accounting/completeGuaranteeItem}，API：{@code complete_guarantee_item}，版本：{@code 10012}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> completeGuaranteeItem(CompleteGuaranteeItemRequest request, String tenantId);

    /**
     * 添加账务。
     * <p>官方接口：{@code /pms/accounting/createOrderBillItem}，API：{@code create_order_bill_item}，版本：{@code 10019}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createOrderBillItem(CreateOrderBillItemRequest request, String tenantId);

    /**
     * 【待下线】生成加收房费。
     * <p>官方接口：{@code /pms/accounting/generateAdditionalRoomRent}，API：{@code deleted_generate_addtionnal_room_rent}，版本：{@code 10018}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> deletedGenerateAddtionnalRoomRent(DeletedGenerateAddtionnalRoomRentRequest request, String tenantId);

    /**
     * 获取账务金额汇总。
     * <p>官方接口：{@code /pms/accounting/getBillSummary}，API：{@code get_bill_summary}，版本：{@code 10014}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getBillSummary(GetBillSummaryRequest request, String tenantId);

    /**
     * 获取账务明细。
     * <p>官方接口：{@code /pms/accounting/getBillItems}，API：{@code get_billitems}，版本：{@code 10016}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getBillitems(GetBillitemsRequest request, String tenantId);

    /**
     * 撤销入账。
     * <p>官方接口：{@code /pms/accounting/rollback}，API：{@code rollback}，版本：{@code 10017}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> rollback(RollbackRequest request, String tenantId);

    /**
     * 查询预授权。
     * <p>官方接口：{@code /pms/accounting/searchGuaranteeItems}，API：{@code search_guarantee_items}，版本：{@code 10021}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> searchGuaranteeItems(SearchGuaranteeItemsRequest request, String tenantId);

    /**
     * 商品售卖。
     * <p>官方接口：{@code /pms/accounting/sellSmallWare}，API：{@code sell_small_ware}，版本：{@code 10013}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sellSmallWare(SellSmallWareRequest request, String tenantId);

    /**
     * 挂账。
     * <p>官方接口：{@code /pms/accounting/suspend}，API：{@code suspend}，版本：{@code 10027}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> suspend(SuspendRequest request, String tenantId);

    /**
     * 检查发布渠道优惠券。
     * <p>官方接口：{@code /pms/coupon/checkForPublishChannelCoupon}，API：{@code check_publish_channel_coupon}，版本：{@code 10010}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> checkPublishChannelCoupon(CheckPublishChannelCouponRequest request, String tenantId);

    /**
     * 发布渠道优惠券。
     * <p>官方接口：{@code /pms/coupon/publishChannelCoupon}，API：{@code publish_channel_coupon}，版本：{@code 10011}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> publishChannelCoupon(PublishChannelCouponRequest request, String tenantId);

    /**
     * 查询渠道优惠券模版列表。
     * <p>官方接口：{@code /pms/coupon/queryChannelCouponTemplateList}，API：{@code query_channel_coupon_template_list}，版本：{@code 10008}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryChannelCouponTemplateList(QueryChannelCouponTemplateListRequest request, String tenantId);

    /**
     * 优惠券模板批量查询核销结果接口。
     * <p>官方接口：{@code /pms/coupon/pageQueryChannelCoupon}，API：{@code query_channel_coupons}，版本：{@code 10009}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryChannelCoupons(QueryChannelCouponsRequest request, String tenantId);

    /**
     * JY08报表接口。
     * <p>官方接口：{@code /pms/data/queryJy08Report}，API：{@code query_jy08}，版本：{@code 10001}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryJy08(QueryJy08Request request, String tenantId);

    /**
     * 获取门店锁屏配置。
     * <p>官方接口：{@code /pms/esports/getLockScreenConfig}，API：{@code get_lock_screen_config}，版本：{@code 10025}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getLockScreenConfig(GetLockScreenConfigRequest request, String tenantId);

    /**
     * 获取电竞设备所在的房间号。
     * <p>官方接口：{@code /pms/esports/getPcRoomNumber}，API：{@code get_pc_room_number}，版本：{@code 10028}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getPcRoomNumber(GetPcRoomNumberRequest request, String tenantId);

    /**
     * 记录电脑开关机日志。
     * <p>官方接口：{@code /pms/esports/pcOpLog}，API：{@code pc_op_log}，版本：{@code 10029}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pcOpLog(PcOpLogRequest request, String tenantId);

    /**
     * 电竞设备信息采集。
     * <p>官方接口：{@code /pms/esports/postDeviceInfo}，API：{@code post_device}，版本：{@code 10027}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> postDevice(PostDeviceRequest request, String tenantId);

    /**
     * 客人上下机日志同步。
     * <p>官方接口：{@code /pms/esports/powerOnOffLog}，API：{@code power_on_off_log}，版本：{@code 10024}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> powerOnOffLog(PowerOnOffLogRequest request, String tenantId);

    /**
     * 电竞设备是否在线状态同步。
     * <p>官方接口：{@code /pms/esports/syncOnlineStatus}，API：{@code sync_online_status}，版本：{@code 10026}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> syncOnlineStatus(SyncOnlineStatusRequest request, String tenantId);

    /**
     * 未成年登录电竞设备校验。
     * <p>官方接口：{@code /pms/esports/underageCheck}，API：{@code underage_check}，版本：{@code 10034}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> underageCheck(UnderageCheckRequest request, String tenantId);

    /**
     * 获取所有行政区划。
     * <p>官方接口：{@code /pms/hotel/common/getalladministrativedivisions}，API：{@code common_getalladministrativedivisions}，版本：{@code 10012}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commonGetalladministrativedivisions(CommonGetalladministrativedivisionsRequest request, String tenantId);

    /**
     * 获取酒店当前营业日。
     * <p>官方接口：{@code /pms/hotel/getbusinessdate}，API：{@code common_getbusinessdate}，版本：{@code 10020}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commonGetbusinessdate(CommonGetbusinessdateRequest request, String tenantId);

    /**
     * 获取数据字典。
     * <p>官方接口：{@code /pms/hotel/common/getdictionaryitems}，API：{@code common_getdictionaryitems}，版本：{@code 10033}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commonGetdictionaryitems(CommonGetdictionaryitemsRequest request, String tenantId);

    /**
     * 获取系统配置。
     * <p>官方接口：{@code /pms/hotel/common/gethotelconfig}，API：{@code common_gethotelconfig}，版本：{@code 10016}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commonGethotelconfig(CommonGethotelconfigRequest request, String tenantId);

    /**
     * 获取服务器时间。
     * <p>官方接口：{@code /pms/hotel/common/getservertime}，API：{@code common_getservertime}，版本：{@code 10022}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commonGetservertime(CommonGetservertimeRequest request, String tenantId);

    /**
     * 获取城市列表。
     * <p>官方接口：{@code /pms/hotel/getCityList}，API：{@code get_city_list}，版本：{@code 10015}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getCityList(GetCityListRequest request, String tenantId);

    /**
     * 获取酒店绑定美团EBPOI信息。
     * <p>官方接口：{@code /pms/hotel/getMeituanPoiInfo}，API：{@code get_eb_poi_info}，版本：{@code 10031}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getEbPoiInfo(GetEbPoiInfoRequest request, String tenantId);

    /**
     * 获取酒店楼栋楼层信息。
     * <p>官方接口：{@code /pms/hotel/getBuildingInfo}，API：{@code get_hotel_building_info}，版本：{@code 10018}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getHotelBuildingInfo(GetHotelBuildingInfoRequest request, String tenantId);

    /**
     * 获取指定酒店的基本信息。
     * <p>官方接口：{@code /pms/hotel/getHotelInfo}，API：{@code get_hotel_info}，版本：{@code 10013}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsGetHotelInfo(GetHotelInfoRequest request, String tenantId);

    /**
     * 查询酒店房间信息。
     * <p>官方接口：{@code /pms/hotel/getRooms}，API：{@code get_rooms}，版本：{@code 10019}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getRooms(GetRoomsRequest request, String tenantId);

    /**
     * 查询酒店房型信息。
     * <p>官方接口：{@code /pms/hotel/getRoomTypes}，API：{@code get_roomtypes}，版本：{@code 10030}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getRoomtypes(GetRoomtypesRequest request, String tenantId);

    /**
     * 查询门店渠道直连开通状态。
     * <p>官方接口：{@code /pms/hotel/queryChannelDirectStatus}，API：{@code query_channel_direct_status}，版本：{@code 10034}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryChannelDirectStatus(QueryChannelDirectStatusRequest request, String tenantId);

    /**
     * 查询渠道产品。
     * <p>官方接口：{@code /pms/hotel/queryChannelRoomTypes}，API：{@code query_channel_goods}，版本：{@code 10035}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryChannelGoods(QueryChannelGoodsRequest request, String tenantId);

    /**
     * 查询中介协议公司。
     * <p>官方接口：{@code /pms/hotel/searchContract}，API：{@code search_contract}，版本：{@code 10032}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> searchContract(SearchContractRequest request, String tenantId);

    /**
     * 检索酒店。
     * <p>官方接口：{@code /pms/hotel/searchHotels}，API：{@code search_hotels}，版本：{@code 10014}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> searchHotels(SearchHotelsRequest request, String tenantId);

    /**
     * 获取酒店可用房间（钟点房）。
     * <p>官方接口：{@code /pms/hourpriceinve/getHourAvailableRooms}，API：{@code get_hour_available_rooms}，版本：{@code 10002}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getHourAvailableRooms(GetHourAvailableRoomsRequest request, String tenantId);

    /**
     * 获取钟点房价格。
     * <p>官方接口：{@code /pms/hourpriceinve/getHourRoomPrice}，API：{@code get_hour_room_price}，版本：{@code 10003}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getHourRoomPrice(GetHourRoomPriceRequest request, String tenantId);

    /**
     * 会员积分发放。
     * <p>官方接口：{@code /pms/loyalty/addMemberPoint}，API：{@code add_member_point}，版本：{@code 10008}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addMemberPoint(AddMemberPointRequest request, String tenantId);

    /**
     * 会员积分消费。
     * <p>官方接口：{@code /pms/loyalty/consumeMemberPoint}，API：{@code consume_member_point}，版本：{@code 10013}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> consumeMemberPoint(ConsumeMemberPointRequest request, String tenantId);

    /**
     * 查询会员优惠券数量。
     * <p>官方接口：{@code /pms/loyalty/countMemberCoupon}，API：{@code count_member_coupon}，版本：{@code 10002}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> countMemberCoupon(CountMemberCouponRequest request, String tenantId);

    /**
     * 根据会员ID、手机号、证件号等查询会员。
     * <p>官方接口：{@code /pms/loyalty/getMember}，API：{@code get_member}，版本：{@code 10022}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getMember(GetMemberRequest request, String tenantId);

    /**
     * 查询会员群体。
     * <p>官方接口：{@code /pms/loyalty/queryGroupPeoples}，API：{@code query_member_group}，版本：{@code 10012}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryMemberGroup(QueryMemberGroupRequest request, String tenantId);

    /**
     * 查询会员积分明细。
     * <p>官方接口：{@code /pms/loyalty/queryPointRecord}，API：{@code query_member_point_record}，版本：{@code 10014}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryMemberPointRecord(QueryMemberPointRecordRequest request, String tenantId);

    /**
     * 注册会员。
     * <p>官方接口：{@code /pms/loyalty/registerMember}，API：{@code register}，版本：{@code 10007}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> register(RegisterRequest request, String tenantId);

    /**
     * 会员积分流水撤销。
     * <p>官方接口：{@code /pms/loyalty/revokeMemberPoint}，API：{@code revoke_member_point}，版本：{@code 10010}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> revokeMemberPoint(RevokeMemberPointRequest request, String tenantId);

    /**
     * 修改会员信息。
     * <p>官方接口：{@code /pms/loyalty/updateMemberInfo}，API：{@code update_member}，版本：{@code 10016}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateMember(UpdateMemberRequest request, String tenantId);

    /**
     * 会员升级。
     * <p>官方接口：{@code /pms/loyalty/upgradeMemberLevel}，API：{@code upgrade_member_level}，版本：{@code 10017}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> upgradeMemberLevel(UpgradeMemberLevelRequest request, String tenantId);

    /**
     * 新增客需消息和任务。
     * <p>官方接口：{@code /pms/message/addGuestDemandTask}，API：{@code add_guestdemand_task}，版本：{@code 10006}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addGuestdemandTask(AddGuestdemandTaskRequest request, String tenantId);

    /**
     * 向PMS推送消息提醒。
     * <p>官方接口：{@code /pms/message/pushMessage}，API：{@code push_message}，版本：{@code 10005}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pushMessage(PushMessageRequest request, String tenantId);

    /**
     * 发送短信。
     * <p>官方接口：{@code /pms/message/sendsms}，API：{@code send_sms}，版本：{@code 10011}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sendSms(SendSmsRequest request, String tenantId);

    /**
     * 修改房态。
     * <p>官方接口：{@code /pms/priceinve/changeRoomStatus}，API：{@code change_room_status}，版本：{@code 10008}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> changeRoomStatus(ChangeRoomStatusRequest request, String tenantId);

    /**
     * 获取酒店可用房间（全天房）。
     * <p>官方接口：{@code /pms/priceinve/getAvailableRooms}，API：{@code get_available_rooms}，版本：{@code 10006}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getAvailableRooms(GetAvailableRoomsRequest request, String tenantId);

    /**
     * 获取酒店房量。
     * <p>官方接口：{@code /pms/priceinve/getRoomCount}，API：{@code get_room_count}，版本：{@code 10017}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsGetRoomCount(GetRoomCountRequest request, String tenantId);

    /**
     * 获取酒店房量。
     * <p>官方接口：{@code /pms/priceinve/getRoomCountV2}，API：{@code get_room_count_v2}，版本：{@code 10016}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getRoomCountV2(GetRoomCountV2Request request, String tenantId);

    /**
     * 获取全天房价格。
     * <p>官方接口：{@code /pms/priceinve/getRoomPrice}，API：{@code get_room_price}，版本：{@code 10007}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsGetRoomPrice(GetRoomPriceRequest request, String tenantId);

    /**
     * 查询酒店房态信息。
     * <p>官方接口：{@code /pms/priceinve/getRoomStatus}，API：{@code get_room_status}，版本：{@code 10009}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getRoomStatus(GetRoomStatusRequest request, String tenantId);

    /**
     * 锁房。
     * <p>官方接口：{@code /pms/priceinve/lockRooms}，API：{@code lock_rooms}，版本：{@code 10011}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> lockRooms(LockRoomsRequest request, String tenantId);

    /**
     * 价格建议。
     * <p>官方接口：{@code /pms/priceinve/pushPriceSuggestion}，API：{@code price_suggest}，版本：{@code 10018}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> priceSuggest(PriceSuggestRequest request, String tenantId);

    /**
     * 查询智能定价建议的执行结果。
     * <p>官方接口：{@code /pms/priceinve/queryPriceSuggestionResult}，API：{@code query_price_suggestion_result}，版本：{@code 10019}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryPriceSuggestionResult(QueryPriceSuggestionResultRequest request, String tenantId);

    /**
     * 解锁房间。
     * <p>官方接口：{@code /pms/priceinve/unlockRooms}，API：{@code unlock_rooms}，版本：{@code 10010}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> unlockRooms(UnlockRoomsRequest request, String tenantId);

    /**
     * 修改渠道售卖价。
     * <p>官方接口：{@code /pms/priceinve/updateChannelRoomTypePrice}，API：{@code update_channel_room_type_price}，版本：{@code 10021}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateChannelRoomTypePrice(UpdateChannelRoomTypePriceRequest request, String tenantId);

    /**
     * 新增入住。
     * <p>官方接口：{@code /pms/reservation/addCheckin}，API：{@code add_checkin}，版本：{@code 10034}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addCheckin(AddCheckinRequest request, String tenantId);

    /**
     * 新增预订单。
     * <p>官方接口：{@code /pms/reservation/addOrder}，API：{@code add_order}，版本：{@code 10038}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsAddOrder(AddOrderRequest request, String tenantId);

    /**
     * 添加自定义价订单。
     * <p>官方接口：{@code /pms/reservation/addOrderWithCustomPrice}，API：{@code add_order_with_custom_price}，版本：{@code 10040}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addOrderWithCustomPrice(AddOrderWithCustomPriceRequest request, String tenantId);

    /**
     * 添加同住。
     * <p>官方接口：{@code /pms/reservation/addShareWithCustomer}，API：{@code add_share_with_customer}，版本：{@code 10029}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addShareWithCustomer(AddShareWithCustomerRequest request, String tenantId);

    /**
     * 添加制卡记录。
     * <p>官方接口：{@code /pms/reservation/adddoorcardrecord}，API：{@code adddoorcardrecord}，版本：{@code 10031}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adddoorcardrecord(AdddoorcardrecordRequest request, String tenantId);

    /**
     * 取消预订单。
     * <p>官方接口：{@code /pms/reservation/cancelOrder}，API：{@code cancel_order}，版本：{@code 10019}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsCancelOrder(CancelOrderRequest request, String tenantId);

    /**
     * 时租房提前入住时更新占房时间。
     * <p>官方接口：{@code /pms/reservation/changeOccupationDurationForHourRent}，API：{@code change_occupation_duration_hourrent}，版本：{@code 10042}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> changeOccupationDurationHourrent(ChangeOccupationDurationHourrentRequest request, String tenantId);

    /**
     * 换房。
     * <p>官方接口：{@code /pms/reservation/changeRoom}，API：{@code change_room}，版本：{@code 10030}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> changeRoom(ChangeRoomRequest request, String tenantId);

    /**
     * 续住或提前离店。
     * <p>官方接口：{@code /pms/reservation/changeStay}，API：{@code change_stay}，版本：{@code 10032}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> changeStay(ChangeStayRequest request, String tenantId);

    /**
     * 离店退房。
     * <p>官方接口：{@code /pms/reservation/checkout}，API：{@code checkout}，版本：{@code 10035}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> checkout(CheckoutRequest request, String tenantId);

    /**
     * 预订单排房。
     * <p>官方接口：{@code /pms/reservation/dispatchOrderRoom}，API：{@code dispatch_order_room}，版本：{@code 10022}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dispatchOrderRoom(DispatchOrderRoomRequest request, String tenantId);

    /**
     * 生成加收房费。
     * <p>官方接口：{@code /pms/reservation/generateAdditionalRoomRent}，API：{@code generate_addtionnal_room_rent}，版本：{@code 10026}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generateAddtionnalRoomRent(GenerateAddtionnalRoomRentRequest request, String tenantId);

    /**
     * 查询在住房间早餐信息。
     * <p>官方接口：{@code /pms/reservation/queryRoomBreakfastInfo}，API：{@code query_breakfast}，版本：{@code 10041}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryBreakfast(QueryBreakfastRequest request, String tenantId);

    /**
     * 查询接待单。
     * <p>官方接口：{@code /pms/reservation/queryCheckins}，API：{@code query_checkins}，版本：{@code 10047}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryCheckins(QueryCheckinsRequest request, String tenantId);

    /**
     * 查询订单已删除占房数据。
     * <p>官方接口：{@code /pms/reservation/queryOrderDeletedOccupations}，API：{@code query_order_deleted_occupations}，版本：{@code 10057}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryOrderDeletedOccupations(QueryOrderDeletedOccupationsRequest request, String tenantId);

    /**
     * 搜索预订单。
     * <p>官方接口：{@code /pms/reservation/queryOrders}，API：{@code query_orders}，版本：{@code 10056}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryOrders(QueryOrdersRequest request, String tenantId);

    /**
     * 查询接待单房费加收规则。
     * <p>官方接口：{@code /pms/reservation/queryRoomRentSurchargeRule}，API：{@code query_room_rent_surcharge_rule}，版本：{@code 10051}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryRoomRentSurchargeRule(QueryRoomRentSurchargeRuleRequest request, String tenantId);

    /**
     * 查询单个订单。
     * <p>官方接口：{@code /pms/reservation/querySingleOrder}，API：{@code query_single_order}，版本：{@code 10056}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> querySingleOrder(QuerySingleOrderRequest request, String tenantId);

    /**
     * 查询接待单是否生成过房费。
     * <p>官方接口：{@code /pms/reservation/queryUnGeneratedRoomRent}，API：{@code query_ungenerated_room_rent}，版本：{@code 10050}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryUngeneratedRoomRent(QueryUngeneratedRoomRentRequest request, String tenantId);

    /**
     * 搜索预订单占房。
     * <p>官方接口：{@code /pms/reservation/searchOccupation}，API：{@code search_occupation}，版本：{@code 10020}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> searchOccupation(SearchOccupationRequest request, String tenantId);

    /**
     * 修改接待单备注。
     * <p>官方接口：{@code /pms/reservation/updateCheckinMemo}，API：{@code update_checkin_memo}，版本：{@code 10028}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateCheckinMemo(UpdateCheckinMemoRequest request, String tenantId);

    /**
     * 更新预订单备注。
     * <p>官方接口：{@code /pms/reservation/updateOrderMemo}，API：{@code update_order_memo}，版本：{@code 10023}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateOrderMemo(UpdateOrderMemoRequest request, String tenantId);

    /**
     * 在线支付。
     * <p>官方接口：{@code /pms/settle/onlinePay}，API：{@code online_pay}，版本：{@code 10012}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> onlinePay(OnlinePayRequest request, String tenantId);

    /**
     * 在线退款。
     * <p>官方接口：{@code /pms/settle/onlineRefund}，API：{@code online_refund}，版本：{@code 10004}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> onlineRefund(OnlineRefundRequest request, String tenantId);

    /**
     * 查询在线支付结果。
     * <p>官方接口：{@code /pms/settle/queryPayResult}，API：{@code query_pay_result}，版本：{@code 10010}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryPayResult(QueryPayResultRequest request, String tenantId);

    /**
     * 新增预订。
     * <p>官方接口：{@code /pms/tmc/addOrder}，API：{@code add_order}，版本：{@code 10024}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsAddOrder(com.meituan.sdk.model.pms.tmc.addOrder.AddOrderRequest request, String tenantId);

    /**
     * 可订检查。
     * <p>官方接口：{@code /pms/tmc/bookingCheck}，API：{@code booking_check}，版本：{@code 10021}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookingCheck(BookingCheckRequest request, String tenantId);

    /**
     * 取消订单。
     * <p>官方接口：{@code /pms/tmc/cancelOrder}，API：{@code cancel_order}，版本：{@code 10023}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsCancelOrder(com.meituan.sdk.model.pms.tmc.cancelOrder.CancelOrderRequest request, String tenantId);

    /**
     * 酒店信息查询。
     * <p>官方接口：{@code /pms/tmc/getHotelInfo}，API：{@code get_hotel_info}，版本：{@code 10018}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsGetHotelInfo(com.meituan.sdk.model.pms.tmc.getHotelInfo.GetHotelInfoRequest request, String tenantId);

    /**
     * 查询酒店物理房型信息。
     * <p>官方接口：{@code /pms/tmc/getPhysicalRoomTypes}，API：{@code get_physical_roomtypes}，版本：{@code 10015}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getPhysicalRoomtypes(GetPhysicalRoomtypesRequest request, String tenantId);

    /**
     * 查询酒店库存信息。
     * <p>官方接口：{@code /pms/tmc/getRoomCount}，API：{@code get_room_count}，版本：{@code 10019}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsGetRoomCount(com.meituan.sdk.model.pms.tmc.getRoomCount.GetRoomCountRequest request, String tenantId);

    /**
     * 查询产品房价信息。
     * <p>官方接口：{@code /pms/tmc/getRoomPrice}，API：{@code get_room_price}，版本：{@code 10021}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pmsGetRoomPrice(com.meituan.sdk.model.pms.tmc.getRoomPrice.GetRoomPriceRequest request, String tenantId);

    /**
     * 获取酒店产品列表。
     * <p>官方接口：{@code /pms/tmc/queryHotelProducts}，API：{@code query_hotel_products}，版本：{@code 10025}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryHotelProducts(QueryHotelProductsRequest request, String tenantId);

    /**
     * 查询订单。
     * <p>官方接口：{@code /pms/tmc/queryOrder}，API：{@code query_order}，版本：{@code 10020}，businessId：{@code 57}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryOrder(QueryOrderRequest request, String tenantId);
    /**
     * 预订单自动排房。
     * <p>官方接口：{@code /pms/reservation/autoDispatchRoom}，API：{@code auto_dispatch_room}，版本：{@code 10058}，businessId：{@code 57}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> autoDispatchRoom(AutoDispatchRoomRequest request, String tenantId);

}
