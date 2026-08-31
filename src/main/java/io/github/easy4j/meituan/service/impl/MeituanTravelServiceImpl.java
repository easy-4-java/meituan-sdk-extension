package io.github.easy4j.meituan.service.impl;

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
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanTravelService;

/**
 * 酒旅经营宝默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanTravelServiceImpl extends AbstractMeituanService implements MeituanTravelService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanTravelServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addGuaranteeItem(AddGuaranteeItemRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cancelGuaranteeItem(CancelGuaranteeItemRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> completeGuaranteeItem(CompleteGuaranteeItemRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createOrderBillItem(CreateOrderBillItemRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> deletedGenerateAddtionnalRoomRent(DeletedGenerateAddtionnalRoomRentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getBillSummary(GetBillSummaryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getBillitems(GetBillitemsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> rollback(RollbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> searchGuaranteeItems(SearchGuaranteeItemsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sellSmallWare(SellSmallWareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> suspend(SuspendRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> checkPublishChannelCoupon(CheckPublishChannelCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> publishChannelCoupon(PublishChannelCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryChannelCouponTemplateList(QueryChannelCouponTemplateListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryChannelCoupons(QueryChannelCouponsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryJy08(QueryJy08Request request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getLockScreenConfig(GetLockScreenConfigRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getPcRoomNumber(GetPcRoomNumberRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pcOpLog(PcOpLogRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> postDevice(PostDeviceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> powerOnOffLog(PowerOnOffLogRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> syncOnlineStatus(SyncOnlineStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> underageCheck(UnderageCheckRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commonGetalladministrativedivisions(CommonGetalladministrativedivisionsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commonGetbusinessdate(CommonGetbusinessdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commonGetdictionaryitems(CommonGetdictionaryitemsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commonGethotelconfig(CommonGethotelconfigRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commonGetservertime(CommonGetservertimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getCityList(GetCityListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getEbPoiInfo(GetEbPoiInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getHotelBuildingInfo(GetHotelBuildingInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsGetHotelInfo(GetHotelInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getRooms(GetRoomsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getRoomtypes(GetRoomtypesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryChannelDirectStatus(QueryChannelDirectStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryChannelGoods(QueryChannelGoodsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> searchContract(SearchContractRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> searchHotels(SearchHotelsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getHourAvailableRooms(GetHourAvailableRoomsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getHourRoomPrice(GetHourRoomPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addMemberPoint(AddMemberPointRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> consumeMemberPoint(ConsumeMemberPointRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> countMemberCoupon(CountMemberCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getMember(GetMemberRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryMemberGroup(QueryMemberGroupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryMemberPointRecord(QueryMemberPointRecordRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> register(RegisterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> revokeMemberPoint(RevokeMemberPointRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateMember(UpdateMemberRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> upgradeMemberLevel(UpgradeMemberLevelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addGuestdemandTask(AddGuestdemandTaskRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pushMessage(PushMessageRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sendSms(SendSmsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> changeRoomStatus(ChangeRoomStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getAvailableRooms(GetAvailableRoomsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsGetRoomCount(GetRoomCountRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getRoomCountV2(GetRoomCountV2Request request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsGetRoomPrice(GetRoomPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getRoomStatus(GetRoomStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> lockRooms(LockRoomsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> priceSuggest(PriceSuggestRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryPriceSuggestionResult(QueryPriceSuggestionResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> unlockRooms(UnlockRoomsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateChannelRoomTypePrice(UpdateChannelRoomTypePriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addCheckin(AddCheckinRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsAddOrder(AddOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addOrderWithCustomPrice(AddOrderWithCustomPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addShareWithCustomer(AddShareWithCustomerRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adddoorcardrecord(AdddoorcardrecordRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsCancelOrder(CancelOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> changeOccupationDurationHourrent(ChangeOccupationDurationHourrentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> changeRoom(ChangeRoomRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> changeStay(ChangeStayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> checkout(CheckoutRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dispatchOrderRoom(DispatchOrderRoomRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generateAddtionnalRoomRent(GenerateAddtionnalRoomRentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryBreakfast(QueryBreakfastRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryCheckins(QueryCheckinsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryOrderDeletedOccupations(QueryOrderDeletedOccupationsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryOrders(QueryOrdersRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryRoomRentSurchargeRule(QueryRoomRentSurchargeRuleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> querySingleOrder(QuerySingleOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryUngeneratedRoomRent(QueryUngeneratedRoomRentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> searchOccupation(SearchOccupationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateCheckinMemo(UpdateCheckinMemoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateOrderMemo(UpdateOrderMemoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> onlinePay(OnlinePayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> onlineRefund(OnlineRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryPayResult(QueryPayResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsAddOrder(com.meituan.sdk.model.pms.tmc.addOrder.AddOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookingCheck(BookingCheckRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsCancelOrder(com.meituan.sdk.model.pms.tmc.cancelOrder.CancelOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsGetHotelInfo(com.meituan.sdk.model.pms.tmc.getHotelInfo.GetHotelInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getPhysicalRoomtypes(GetPhysicalRoomtypesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsGetRoomCount(com.meituan.sdk.model.pms.tmc.getRoomCount.GetRoomCountRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pmsGetRoomPrice(com.meituan.sdk.model.pms.tmc.getRoomPrice.GetRoomPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryHotelProducts(QueryHotelProductsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryOrder(QueryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }
    /**
     * 预订单自动排房。
     * <p>官方接口：{@code /pms/reservation/autoDispatchRoom}，API：{@code auto_dispatch_room}，版本：{@code 10058}，businessId：{@code 57}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> autoDispatchRoom(AutoDispatchRoomRequest request, String tenantId) {
        return execute(request, tenantId);
    }

}
