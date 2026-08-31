package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzh.analysis.pendingStoreOrder.PendingStoreOrderRequest;
import com.meituan.sdk.model.ddzh.analysis.pendingStoreSigning.PendingStoreSigningRequest;
import com.meituan.sdk.model.ddzh.common.commonGrayOperate.CommonGrayOperateRequest;
import com.meituan.sdk.model.ddzh.common.grayConfigBaseDev.GrayConfigBaseDevRequest;
import com.meituan.sdk.model.ddzh.common.grayConfigBaseSession.GrayConfigBaseSessionRequest;
import com.meituan.sdk.model.ddzh.common.grayConfigRollback.GrayConfigRollbackRequest;
import com.meituan.sdk.model.ddzh.common.grayConfigRollbackBySession.GrayConfigRollbackBySessionRequest;
import com.meituan.sdk.model.ddzh.common.grayQueryHitSessionGrayPoi.GrayQueryHitSessionGrayPoiRequest;
import com.meituan.sdk.model.ddzh.common.migrateSession.MigrateSessionRequest;
import com.meituan.sdk.model.ddzh.common.migrateTaskDetail.MigrateTaskDetailRequest;
import com.meituan.sdk.model.ddzh.common.pageQuerySession.PageQuerySessionRequest;
import com.meituan.sdk.model.ddzh.common.pageQuerySessionTokenMapping.PageQuerySessionTokenMappingRequest;
import com.meituan.sdk.model.ddzh.common.queryGrantingOpCustomer.QueryGrantingOpCustomerRequest;
import com.meituan.sdk.model.ddzh.common.transferBidToOpCustomerId.TransferBidToOpCustomerIdRequest;
import com.meituan.sdk.model.ddzh.common.transferOpCustomerIdToBid.TransferOpCustomerIdToBidRequest;
import com.meituan.sdk.model.ddzh.common.transferOpUserIdToOpenUserId.TransferOpUserIdToOpenUserIdRequest;
import com.meituan.sdk.model.ddzh.common.transferOpenShopUuidToOpPoiId.TransferOpenShopUuidToOpPoiIdRequest;
import com.meituan.sdk.model.ddzh.common.transferOpenUserIdToOpUserId.TransferOpenUserIdToOpUserIdRequest;
import com.meituan.sdk.model.ddzh.common.transferOppoiidToOpenShopUuids.TransferOppoiidToOpenShopUuidsRequest;
import com.meituan.sdk.model.ddzh.common.virtualnumQueryOpid.VirtualnumQueryOpidRequest;
import com.meituan.sdk.model.ddzh.customercenter.customercenterAddfollowup.CustomercenterAddfollowupRequest;
import com.meituan.sdk.model.ddzh.le.claimStatusCallback.ClaimStatusCallbackRequest;
import com.meituan.sdk.model.ddzh.le.insureCallback.InsureCallbackRequest;
import com.meituan.sdk.model.ddzh.le.insureCancelCallback.InsureCancelCallbackRequest;
import com.meituan.sdk.model.ddzh.merchantdata.merchantDataBooking.MerchantDataBookingRequest;
import com.meituan.sdk.model.ddzh.merchantdata.merchantDataConsumption.MerchantDataConsumptionRequest;
import com.meituan.sdk.model.ddzh.merchantdata.merchantDataDealGroupsConsumption.MerchantDataDealGroupsConsumptionRequest;
import com.meituan.sdk.model.ddzh.merchantdata.merchantDataPoitraffic.MerchantDataPoitrafficRequest;
import com.meituan.sdk.model.ddzh.merchantdata.saasTradeHistory.SaasTradeHistoryRequest;
import com.meituan.sdk.model.ddzh.poiqrcode.poiqrcodeQuerydzcoupon.PoiqrcodeQuerydzcouponRequest;
import com.meituan.sdk.model.ddzh.registration.registrationDepartmentAddEdit.RegistrationDepartmentAddEditRequest;
import com.meituan.sdk.model.ddzh.registration.registrationDepartmentDelete.RegistrationDepartmentDeleteRequest;
import com.meituan.sdk.model.ddzh.registration.registrationDepartmentDetail.RegistrationDepartmentDetailRequest;
import com.meituan.sdk.model.ddzh.registration.registrationDepartmentQuery.RegistrationDepartmentQueryRequest;
import com.meituan.sdk.model.ddzh.registration.registrationDoctorQuery.RegistrationDoctorQueryRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoDelete.TechnicianTechinfoDeleteRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoProducttbind.TechnicianTechinfoProducttbindRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoQuery.TechnicianTechinfoQueryRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoQuerytagtree.TechnicianTechinfoQuerytagtreeRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoSavenew.TechnicianTechinfoSavenewRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoScheduleconfig.TechnicianTechinfoScheduleconfigRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoSwitchonline.TechnicianTechinfoSwitchonlineRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoSycnstock.TechnicianTechinfoSycnstockRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoTechonlineSwitch.TechnicianTechinfoTechonlineSwitchRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoThirdpartyprojectBind.TechnicianTechinfoThirdpartyprojectBindRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoUgcAdd.TechnicianTechinfoUgcAddRequest;
import com.meituan.sdk.model.ddzh.technician.technicianTechinfoUpdateorderextrac.TechnicianTechinfoUpdateorderextracRequest;
import com.meituan.sdk.model.ddzh.thirdresource.addDeviceModel.AddDeviceModelRequest;
import com.meituan.sdk.model.ddzh.thirdresource.billiardTableInfoSync.BilliardTableInfoSyncRequest;
import com.meituan.sdk.model.ddzh.thirdresource.chargeDeviceStatusSync.ChargeDeviceStatusSyncRequest;
import com.meituan.sdk.model.ddzh.thirdresource.chargeStationStatusSync.ChargeStationStatusSyncRequest;
import com.meituan.sdk.model.ddzh.thirdresource.syncDeviceInfo.SyncDeviceInfoRequest;
import com.meituan.sdk.model.ddzh.thirdresource.updateDeviceInfo.UpdateDeviceInfoRequest;
import com.meituan.sdk.model.ddzh.thirdresource.updateDeviceModel.UpdateDeviceModelRequest;
import com.meituan.sdk.model.ddzh.thirdresource.updateDeviceStatus.UpdateDeviceStatusRequest;
import com.meituan.sdk.model.ddzh.thirdresource.uploadPoiPttrInfo.UploadPoiPttrInfoRequest;
import com.meituan.sdk.model.ddzh.tuangou.deviceChangeCallback.DeviceChangeCallbackRequest;
import com.meituan.sdk.model.ddzh.tuangou.payBillQuery.PayBillQueryRequest;
import com.meituan.sdk.model.ddzh.tuangou.payBillRefund.PayBillRefundRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouDealQueryshopdeal.TuangouDealQueryshopdealRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouGoodsPrepared.TuangouGoodsPreparedRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouGoodsStartPrepare.TuangouGoodsStartPrepareRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouGoodsStockSync.TuangouGoodsStockSyncRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouOrderResultCallback.TuangouOrderResultCallbackRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouProductQueryproduct.TuangouProductQueryproductRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouProductQueryproductbytype.TuangouProductQueryproductbytypeRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouProductStockQuery.TuangouProductStockQueryRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptApplyRefund.TuangouReceiptApplyRefundRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptBatchReverseconsume.TuangouReceiptBatchReverseconsumeRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptBatchconsume.TuangouReceiptBatchconsumeRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptConsume.TuangouReceiptConsumeRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptGetconsumed.TuangouReceiptGetconsumedRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptPreRefundValid.TuangouReceiptPreRefundValidRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptPrepare.TuangouReceiptPrepareRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQueryProduct.TuangouReceiptQueryProductRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQueryRefundByRefundId.TuangouReceiptQueryRefundByRefundIdRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQueryUsablerevelant.TuangouReceiptQueryUsablerevelantRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerybymobile.TuangouReceiptQuerybymobileRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerylistbydate.TuangouReceiptQuerylistbydateRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptRefundAudit.TuangouReceiptRefundAuditRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptReverseconsume.TuangouReceiptReverseconsumeRequest;
import com.meituan.sdk.model.ddzh.ugc.ugcQueryShopReview.UgcQueryShopReviewRequest;
import com.meituan.sdk.model.ddzh.ugc.ugcQuerystar.UgcQuerystarRequest;
import com.meituan.sdk.model.ddzh.yuding.addprice.AddpriceRequest;
import com.meituan.sdk.model.ddzh.yuding.applypayment.ApplypaymentRequest;
import com.meituan.sdk.model.ddzh.yuding.bookClubactivityJoin.BookClubactivityJoinRequest;
import com.meituan.sdk.model.ddzh.yuding.bookClubactivityThirdPeopleSync.BookClubactivityThirdPeopleSyncRequest;
import com.meituan.sdk.model.ddzh.yuding.bookOrderInfoUpdatedNotice.BookOrderInfoUpdatedNoticeRequest;
import com.meituan.sdk.model.ddzh.yuding.bookSelfpickupverify.BookSelfpickupverifyRequest;
import com.meituan.sdk.model.ddzh.yuding.bookStockModeUpdate.BookStockModeUpdateRequest;
import com.meituan.sdk.model.ddzh.yuding.bookUnreserveAddprice.BookUnreserveAddpriceRequest;
import com.meituan.sdk.model.ddzh.yuding.bookresultcallback.BookresultcallbackRequest;
import com.meituan.sdk.model.ddzh.yuding.changeresultcallback.ChangeresultcallbackRequest;
import com.meituan.sdk.model.ddzh.yuding.createandprepayorder.CreateandprepayorderRequest;
import com.meituan.sdk.model.ddzh.yuding.dealgroubookShopQuery.DealgroubookShopQueryRequest;
import com.meituan.sdk.model.ddzh.yuding.dealgroupProductQuery.DealgroupProductQueryRequest;
import com.meituan.sdk.model.ddzh.yuding.dealgroupRelateBooking.DealgroupRelateBookingRequest;
import com.meituan.sdk.model.ddzh.yuding.dealgroupRelateRoom.DealgroupRelateRoomRequest;
import com.meituan.sdk.model.ddzh.yuding.isvconsume.IsvconsumeRequest;
import com.meituan.sdk.model.ddzh.yuding.ktvMtroomOffline.KtvMtroomOfflineRequest;
import com.meituan.sdk.model.ddzh.yuding.ktvMtroomOperateStatus.KtvMtroomOperateStatusRequest;
import com.meituan.sdk.model.ddzh.yuding.ktvMtroomQuery.KtvMtroomQueryRequest;
import com.meituan.sdk.model.ddzh.yuding.ktvMtroomStockOperate.KtvMtroomStockOperateRequest;
import com.meituan.sdk.model.ddzh.yuding.ktvPeriodQuery.KtvPeriodQueryRequest;
import com.meituan.sdk.model.ddzh.yuding.ktvPoiStatusSync.KtvPoiStatusSyncRequest;
import com.meituan.sdk.model.ddzh.yuding.ktvRoomSync.KtvRoomSyncRequest;
import com.meituan.sdk.model.ddzh.yuding.lifereserveMerchantmodify.LifereserveMerchantmodifyRequest;
import com.meituan.sdk.model.ddzh.yuding.merchantApplyRefund.MerchantApplyRefundRequest;
import com.meituan.sdk.model.ddzh.yuding.merchantapplyMultiRefund.MerchantapplyMultiRefundRequest;
import com.meituan.sdk.model.ddzh.yuding.merchantcancelorder.MerchantcancelorderRequest;
import com.meituan.sdk.model.ddzh.yuding.personcreate.PersoncreateRequest;
import com.meituan.sdk.model.ddzh.yuding.personquery.PersonqueryRequest;
import com.meituan.sdk.model.ddzh.yuding.personunbind.PersonunbindRequest;
import com.meituan.sdk.model.ddzh.yuding.personupdate.PersonupdateRequest;
import com.meituan.sdk.model.ddzh.yuding.pricelistBookruleSync.PricelistBookruleSyncRequest;
import com.meituan.sdk.model.ddzh.yuding.pricelistLoad.PricelistLoadRequest;
import com.meituan.sdk.model.ddzh.yuding.pricelistPeriodsCreate.PricelistPeriodsCreateRequest;
import com.meituan.sdk.model.ddzh.yuding.pricelistSubmit.PricelistSubmitRequest;
import com.meituan.sdk.model.ddzh.yuding.projectMappingPush.ProjectMappingPushRequest;
import com.meituan.sdk.model.ddzh.yuding.queryBookrule.QueryBookruleRequest;
import com.meituan.sdk.model.ddzh.yuding.queryMarkuppricelist.QueryMarkuppricelistRequest;
import com.meituan.sdk.model.ddzh.yuding.queryOrder.QueryOrderRequest;
import com.meituan.sdk.model.ddzh.yuding.queryServiceman.QueryServicemanRequest;
import com.meituan.sdk.model.ddzh.yuding.queryUploadlink.QueryUploadlinkRequest;
import com.meituan.sdk.model.ddzh.yuding.queryVirtualnum.QueryVirtualnumRequest;
import com.meituan.sdk.model.ddzh.yuding.queryorderpaymentinfo.QueryorderpaymentinfoRequest;
import com.meituan.sdk.model.ddzh.yuding.refundauditresult.RefundauditresultRequest;
import com.meituan.sdk.model.ddzh.yuding.roomDelete.RoomDeleteRequest;
import com.meituan.sdk.model.ddzh.yuding.roomQuery.RoomQueryRequest;
import com.meituan.sdk.model.ddzh.yuding.roomSync.RoomSyncRequest;
import com.meituan.sdk.model.ddzh.yuding.shopRuleBooking.ShopRuleBookingRequest;
import com.meituan.sdk.model.ddzh.yuding.thirdPartyStockSync.ThirdPartyStockSyncRequest;
import com.meituan.sdk.model.ddzh.yuding.updatebookrule.UpdatebookruleRequest;
import com.meituan.sdk.model.ddzh.yuding.updateorderfulfillinfo.UpdateorderfulfillinfoRequest;
import com.meituan.sdk.model.ddzh.yuding.updatestock.UpdatestockRequest;
import com.meituan.sdk.model.ddzhkh.auth.pageQueryTokenPoiList.PageQueryTokenPoiListRequest;
import com.meituan.sdk.model.ddzhkh.auth.queryPoiMapping.QueryPoiMappingRequest;
import com.meituan.sdk.model.ddzhkh.clubactivity.clubactivityActivityParticipantsQuery.ClubactivityActivityParticipantsQueryRequest;
import com.meituan.sdk.model.ddzhkh.clubactivity.clubactivityClubActivitySync.ClubactivityClubActivitySyncRequest;
import com.meituan.sdk.model.ddzhkh.clubactivity.clubactivityClubActivitystatusUpdate.ClubactivityClubActivitystatusUpdateRequest;
import com.meituan.sdk.model.ddzhkh.clubactivity.clubactivityClubInfoSync.ClubactivityClubInfoSyncRequest;
import com.meituan.sdk.model.ddzhkh.dingdan.orderBookBatchQuery.OrderBookBatchQueryRequest;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryInfo.OrderQueryInfoRequest;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.OrderQueryorderRequest;
import com.meituan.sdk.model.ddzhkh.dingdan.orderReceiptPaymentshares.OrderReceiptPaymentsharesRequest;
import com.meituan.sdk.model.ddzhkh.dingdan.orderReserveorderquery.OrderReserveorderqueryRequest;
import com.meituan.sdk.model.ddzhkh.finance.financeDeductDetail.FinanceDeductDetailRequest;
import com.meituan.sdk.model.ddzhkh.finance.financeDndeductDetail.FinanceDndeductDetailRequest;
import com.meituan.sdk.model.ddzhkh.finance.financeDnincomeDetail.FinanceDnincomeDetailRequest;
import com.meituan.sdk.model.ddzhkh.finance.financeIncomeDetail.FinanceIncomeDetailRequest;
import com.meituan.sdk.model.ddzhkh.finance.financeOrderDetail.FinanceOrderDetailRequest;
import com.meituan.sdk.model.ddzhkh.finance.financePayplanType.FinancePayplanTypeRequest;
import com.meituan.sdk.model.ddzhkh.finance.queryPayplanInfo.QueryPayplanInfoRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveBatchReserveFee.GeneralreserveBatchReserveFeeRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveQueryphoneinfo.GeneralreserveQueryphoneinfoRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveQueryshopalltechinfo.GeneralreserveQueryshopalltechinfoRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveCancelconfirm.GeneralreserveReserveCancelconfirmRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveConfig.GeneralreserveReserveConfigRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveFee.GeneralreserveReserveFeeRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveMerchantcancel.GeneralreserveReserveMerchantcancelRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveMerchantcreateorder.GeneralreserveReserveMerchantcreateorderRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveMerchantfullfill.GeneralreserveReserveMerchantfullfillRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveMerchantmodify.GeneralreserveReserveMerchantmodifyRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveModifyconfirm.GeneralreserveReserveModifyconfirmRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveOrderconfirm.GeneralreserveReserveOrderconfirmRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReservePlan.GeneralreserveReservePlanRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveQueryconfig.GeneralreserveReserveQueryconfigRequest;
import com.meituan.sdk.model.ddzhkh.generalreserve.generalreserveReserveQueryorder.GeneralreserveReserveQueryorderRequest;
import com.meituan.sdk.model.ddzhkh.member.memberPointTotalUpdate.MemberPointTotalUpdateRequest;
import com.meituan.sdk.model.ddzhkh.member.memberPointTransactionUpdate.MemberPointTransactionUpdateRequest;
import com.meituan.sdk.model.ddzhkh.member.memberSyncOffline.MemberSyncOfflineRequest;
import com.meituan.sdk.model.ddzhkh.member.memberUpdate.MemberUpdateRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.dzopenMerchantreceiptRefundaudit.DzopenMerchantreceiptRefundauditRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.merchantreceiptDirectRefund.MerchantreceiptDirectRefundRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.merchantreceiptQueryQueryreceiptstatus.MerchantreceiptQueryQueryreceiptstatusRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.merchantreceiptQueryVerifyreceipthistory.MerchantreceiptQueryVerifyreceipthistoryRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.merchantreceiptRefundRefundcallback.MerchantreceiptRefundRefundcallbackRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.merchantreceiptReverseconsume.MerchantreceiptReverseconsumeRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.merchantreceiptSendCallback.MerchantreceiptSendCallbackRequest;
import com.meituan.sdk.model.ddzhkh.merchantreceipt.merchantreceiptVerifyVerifyreceipt.MerchantreceiptVerifyVerifyreceiptRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.submitPayment.SubmitPaymentRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeAppendPaySubmit.TradeAppendPaySubmitRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeCreateOrder.TradeCreateOrderRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeCreateOrderWithoutPrepay.TradeCreateOrderWithoutPrepayRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeDistributionFundsCallback.TradeDistributionFundsCallbackRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeOrderDataChange.TradeOrderDataChangeRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeQueryOrder.TradeQueryOrderRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeQueryPayInfo.TradeQueryPayInfoRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeQueryPayToken.TradeQueryPayTokenRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeQueryRefund.TradeQueryRefundRequest;
import com.meituan.sdk.model.ddzhkh.miniprogram.tradeRefundOrder.TradeRefundOrderRequest;
import com.meituan.sdk.model.ddzhkh.poi.poimatchList.PoimatchListRequest;
import com.meituan.sdk.model.ddzhkh.poi.poimatchTaskCreate.PoimatchTaskCreateRequest;
import com.meituan.sdk.model.ddzhkh.publichospital.publichospitalNoticeinfoChange.PublichospitalNoticeinfoChangeRequest;
import com.meituan.sdk.model.ddzhkh.publichospital.publichospitalRegistrationCancelOrder.PublichospitalRegistrationCancelOrderRequest;
import com.meituan.sdk.model.ddzhkh.publichospital.publichospitalRegistrationCreateOrder.PublichospitalRegistrationCreateOrderRequest;
import com.meituan.sdk.model.ddzhkh.publichospital.publichospitalSyncScheduleChange.PublichospitalSyncScheduleChangeRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.dealgroupBatchRelateRooms.DealgroupBatchRelateRoomsRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.imageUpload.ImageUploadRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.normalDealgroupQuery.NormalDealgroupQueryRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productCurrentOnline.ProductCurrentOnlineRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productCurrentSubmit.ProductCurrentSubmitRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupCreate.ProductDealgroupCreateRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupDrawback.ProductDealgroupDrawbackRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupOffline.ProductDealgroupOfflineRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupOnline.ProductDealgroupOnlineRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupQuery.ProductDealgroupQueryRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupSubmit.ProductDealgroupSubmitRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupUpdateShopids.ProductDealgroupUpdateShopidsRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupUpdateprice.ProductDealgroupUpdatepriceRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productDealgroupUpdatestock.ProductDealgroupUpdatestockRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productEditMutex.ProductEditMutexRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductCreate.ProductProductCreateRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductLoadproduct.ProductProductLoadproductRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductLoadproductstock.ProductProductLoadproductstockRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductOffline.ProductProductOfflineRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductOnline.ProductProductOnlineRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductSubmit.ProductProductSubmitRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductUpdate.ProductProductUpdateRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productProductUpdateProductStock.ProductProductUpdateProductStockRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productRelationshipSave.ProductRelationshipSaveRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productRelationshipStatusUpdate.ProductRelationshipStatusUpdateRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productResourceLoadresource.ProductResourceLoadresourceRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productResourceSubmit.ProductResourceSubmitRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productResourceUpdatestatus.ProductResourceUpdatestatusRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productSearchSupplyDiagnostics.ProductSearchSupplyDiagnosticsRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productShopproductsGet.ProductShopproductsGetRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productUnitedOfflineProduct.ProductUnitedOfflineProductRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productUnitedQueryProduct.ProductUnitedQueryProductRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productUnitedRevokeProduct.ProductUnitedRevokeProductRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productUnitedUpdatePrices.ProductUnitedUpdatePricesRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productUnitedUpdateShop.ProductUnitedUpdateShopRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.productUnitedUpdateStock.ProductUnitedUpdateStockRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.showeventQuery.ShoweventQueryRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.showeventQuickUpdateStock.ShoweventQuickUpdateStockRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.showeventSubmit.ShoweventSubmitRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.showeventUpdateStatus.ShoweventUpdateStatusRequest;
import com.meituan.sdk.model.ddzhkh.xcx3csmzl.createOrder.CreateOrderRequest;
import com.meituan.sdk.model.ddzhkh.xcx3csmzl.createRelationOrder.CreateRelationOrderRequest;
import com.meituan.sdk.model.ddzhkh.xcx3csmzl.installmentPay.InstallmentPayRequest;
import com.meituan.sdk.model.ddzhkh.xcx3csmzl.queryPayToken.QueryPayTokenRequest;
import com.meituan.sdk.model.ddzhkh.xcx3csmzl.refundOrder.RefundOrderRequest;
import com.meituan.sdk.model.ddzhkh.xcx3csmzl.syncOrder.SyncOrderRequest;
import com.meituan.sdk.model.ddzhkh.xcxhjhs.syncAri.SyncAriRequest;
import com.meituan.sdk.model.ddzhkh.xcxjwhs.queryInquiryOrder.QueryInquiryOrderRequest;
import com.meituan.sdk.model.ddzhkh.xcxmj.syncStatus.SyncStatusRequest;
import com.meituan.sdk.model.ddzhkh.xcxpw.prePay.PrePayRequest;
import com.meituan.sdk.model.ddzhkh.xcxpw.queryPayInfo.QueryPayInfoRequest;
import com.meituan.sdk.model.ddzhkh.xcxpw.queryRefundInfo.QueryRefundInfoRequest;
import com.meituan.sdk.model.ddzhkh.xcxwy.submitFileTransfer.SubmitFileTransferRequest;
import com.meituan.sdk.model.ddzh.chargefulfill.chargeOrderFeeSync.ChargeOrderFeeSyncRequest;
import com.meituan.sdk.model.ddzh.chargefulfill.chargeOrderFulfill.ChargeOrderFulfillRequest;
import com.meituan.sdk.model.ddzh.chargefulfill.chargeOrderInfoSync.ChargeOrderInfoSyncRequest;
import com.meituan.sdk.model.ddzh.chargefulfill.chargeReserveOrderRefund.ChargeReserveOrderRefundRequest;
import com.meituan.sdk.model.ddzh.chargefulfill.reserveOrderFeeSync.ReserveOrderFeeSyncRequest;
import com.meituan.sdk.model.ddzh.chargefulfill.startDeviceResultCallBack.StartDeviceResultCallBackRequest;
import com.meituan.sdk.model.ddzh.chargefulfill.stopDeviceResultCallBack.StopDeviceResultCallBackRequest;
import com.meituan.sdk.model.ddzh.print.printOrderInfoSync.PrintOrderInfoSyncRequest;
import com.meituan.sdk.model.ddzh.print.printOrderResultSync.PrintOrderResultSyncRequest;
import com.meituan.sdk.model.ddzh.yuding.thirdTechnicianSync.ThirdTechnicianSyncRequest;
import com.meituan.sdk.model.ddzhkh.shangpin.showeventBatchQuickUpdateStock.ShoweventBatchQuickUpdateStockRequest;
import com.meituan.sdk.model.ddzhkh.xcxbj.appendPay.AppendPayRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanRetailService;

/**
 * 服务零售默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanRetailServiceImpl extends AbstractMeituanService implements MeituanRetailService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanRetailServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pendingStoreOrder(PendingStoreOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pendingStoreSigning(PendingStoreSigningRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commonGrayOperate(CommonGrayOperateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> grayConfigBaseDev(GrayConfigBaseDevRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> grayConfigBaseSession(GrayConfigBaseSessionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> grayConfigRollback(GrayConfigRollbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> grayConfigRollbackBySession(GrayConfigRollbackBySessionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> grayQueryHitSessionGrayPoi(GrayQueryHitSessionGrayPoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> migrateSession(MigrateSessionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> migrateTaskDetail(MigrateTaskDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pageQuerySession(PageQuerySessionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pageQuerySessionTokenMapping(PageQuerySessionTokenMappingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryGrantingOpCustomer(QueryGrantingOpCustomerRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> transferBidToOpCustomerId(TransferBidToOpCustomerIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> transferOpCustomerIdToBid(TransferOpCustomerIdToBidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> transferOpUserIdToOpenUserId(TransferOpUserIdToOpenUserIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> transferOpenShopUuidToOpPoiId(TransferOpenShopUuidToOpPoiIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> transferOpenUserIdToOpUserId(TransferOpenUserIdToOpUserIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> transferOppoiidToOpenShopUuids(TransferOppoiidToOpenShopUuidsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> virtualnumQueryOpid(VirtualnumQueryOpidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> customercenterAddfollowup(CustomercenterAddfollowupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> claimStatusCallback(ClaimStatusCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> insureCallback(InsureCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> insureCancelCallback(InsureCancelCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantDataBooking(MerchantDataBookingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantDataConsumption(MerchantDataConsumptionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantDataDealGroupsConsumption(MerchantDataDealGroupsConsumptionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantDataPoitraffic(MerchantDataPoitrafficRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> saasTradeHistory(SaasTradeHistoryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poiqrcodeQuerydzcoupon(PoiqrcodeQuerydzcouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> registrationDepartmentAddEdit(RegistrationDepartmentAddEditRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> registrationDepartmentDelete(RegistrationDepartmentDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> registrationDepartmentDetail(RegistrationDepartmentDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> registrationDepartmentQuery(RegistrationDepartmentQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> registrationDoctorQuery(RegistrationDoctorQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoDelete(TechnicianTechinfoDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoProducttbind(TechnicianTechinfoProducttbindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoQuery(TechnicianTechinfoQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoQuerytagtree(TechnicianTechinfoQuerytagtreeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoSavenew(TechnicianTechinfoSavenewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoScheduleconfig(TechnicianTechinfoScheduleconfigRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoSwitchonline(TechnicianTechinfoSwitchonlineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoSycnstock(TechnicianTechinfoSycnstockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoTechonlineSwitch(TechnicianTechinfoTechonlineSwitchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoThirdpartyprojectBind(TechnicianTechinfoThirdpartyprojectBindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoUgcAdd(TechnicianTechinfoUgcAddRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> technicianTechinfoUpdateorderextrac(TechnicianTechinfoUpdateorderextracRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addDeviceModel(AddDeviceModelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> billiardTableInfoSync(BilliardTableInfoSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> chargeDeviceStatusSync(ChargeDeviceStatusSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> chargeStationStatusSync(ChargeStationStatusSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> syncDeviceInfo(SyncDeviceInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateDeviceInfo(UpdateDeviceInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateDeviceModel(UpdateDeviceModelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateDeviceStatus(UpdateDeviceStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> uploadPoiPttrInfo(UploadPoiPttrInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> deviceChangeCallback(DeviceChangeCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> payBillQuery(PayBillQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> payBillRefund(PayBillRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouDealQueryshopdeal(TuangouDealQueryshopdealRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouGoodsPrepared(TuangouGoodsPreparedRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouGoodsStartPrepare(TuangouGoodsStartPrepareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouGoodsStockSync(TuangouGoodsStockSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouOrderResultCallback(TuangouOrderResultCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouProductQueryproduct(TuangouProductQueryproductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouProductQueryproductbytype(TuangouProductQueryproductbytypeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouProductStockQuery(TuangouProductStockQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptApplyRefund(TuangouReceiptApplyRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptBatchReverseconsume(TuangouReceiptBatchReverseconsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptBatchconsume(TuangouReceiptBatchconsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptConsume(TuangouReceiptConsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptGetconsumed(TuangouReceiptGetconsumedRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptPreRefundValid(TuangouReceiptPreRefundValidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptPrepare(TuangouReceiptPrepareRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptQueryProduct(TuangouReceiptQueryProductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptQueryRefundByRefundId(TuangouReceiptQueryRefundByRefundIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptQueryUsablerevelant(TuangouReceiptQueryUsablerevelantRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptQuerybymobile(TuangouReceiptQuerybymobileRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptQuerylistbydate(TuangouReceiptQuerylistbydateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptRefundAudit(TuangouReceiptRefundAuditRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tuangouReceiptReverseconsume(TuangouReceiptReverseconsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ugcQueryShopReview(UgcQueryShopReviewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ugcQuerystar(UgcQuerystarRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> addprice(AddpriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> applypayment(ApplypaymentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookClubactivityJoin(BookClubactivityJoinRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookClubactivityThirdPeopleSync(BookClubactivityThirdPeopleSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookOrderInfoUpdatedNotice(BookOrderInfoUpdatedNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookSelfpickupverify(BookSelfpickupverifyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookStockModeUpdate(BookStockModeUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookUnreserveAddprice(BookUnreserveAddpriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bookresultcallback(BookresultcallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> changeresultcallback(ChangeresultcallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createandprepayorder(CreateandprepayorderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dealgroubookShopQuery(DealgroubookShopQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dealgroupProductQuery(DealgroupProductQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dealgroupRelateBooking(DealgroupRelateBookingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dealgroupRelateRoom(DealgroupRelateRoomRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> isvconsume(IsvconsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ktvMtroomOffline(KtvMtroomOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ktvMtroomOperateStatus(KtvMtroomOperateStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ktvMtroomQuery(KtvMtroomQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ktvMtroomStockOperate(KtvMtroomStockOperateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ktvPeriodQuery(KtvPeriodQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ktvPoiStatusSync(KtvPoiStatusSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ktvRoomSync(KtvRoomSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> lifereserveMerchantmodify(LifereserveMerchantmodifyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantApplyRefund(MerchantApplyRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantapplyMultiRefund(MerchantapplyMultiRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantcancelorder(MerchantcancelorderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> personcreate(PersoncreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> personquery(PersonqueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> personunbind(PersonunbindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> personupdate(PersonupdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pricelistBookruleSync(PricelistBookruleSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pricelistLoad(PricelistLoadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pricelistPeriodsCreate(PricelistPeriodsCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pricelistSubmit(PricelistSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> projectMappingPush(ProjectMappingPushRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryBookrule(QueryBookruleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryMarkuppricelist(QueryMarkuppricelistRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhQueryOrder(QueryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryServiceman(QueryServicemanRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryUploadlink(QueryUploadlinkRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryVirtualnum(QueryVirtualnumRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryorderpaymentinfo(QueryorderpaymentinfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> refundauditresult(RefundauditresultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> roomDelete(RoomDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> roomQuery(RoomQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> roomSync(RoomSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shopRuleBooking(ShopRuleBookingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> thirdPartyStockSync(ThirdPartyStockSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updatebookrule(UpdatebookruleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updateorderfulfillinfo(UpdateorderfulfillinfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updatestock(UpdatestockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> pageQueryTokenPoiList(PageQueryTokenPoiListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryPoiMapping(QueryPoiMappingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> clubactivityActivityParticipantsQuery(ClubactivityActivityParticipantsQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> clubactivityClubActivitySync(ClubactivityClubActivitySyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> clubactivityClubActivitystatusUpdate(ClubactivityClubActivitystatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> clubactivityClubInfoSync(ClubactivityClubInfoSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderBookBatchQuery(OrderBookBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderQueryInfo(OrderQueryInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderQueryorder(OrderQueryorderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderReceiptPaymentshares(OrderReceiptPaymentsharesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderReserveorderquery(OrderReserveorderqueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> financeDeductDetail(FinanceDeductDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> financeDndeductDetail(FinanceDndeductDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> financeDnincomeDetail(FinanceDnincomeDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> financeIncomeDetail(FinanceIncomeDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> financeOrderDetail(FinanceOrderDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> financePayplanType(FinancePayplanTypeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryPayplanInfo(QueryPayplanInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveBatchReserveFee(GeneralreserveBatchReserveFeeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveQueryphoneinfo(GeneralreserveQueryphoneinfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveQueryshopalltechinfo(GeneralreserveQueryshopalltechinfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveCancelconfirm(GeneralreserveReserveCancelconfirmRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveConfig(GeneralreserveReserveConfigRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveFee(GeneralreserveReserveFeeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveMerchantcancel(GeneralreserveReserveMerchantcancelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveMerchantcreateorder(GeneralreserveReserveMerchantcreateorderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveMerchantfullfill(GeneralreserveReserveMerchantfullfillRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveMerchantmodify(GeneralreserveReserveMerchantmodifyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveModifyconfirm(GeneralreserveReserveModifyconfirmRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveOrderconfirm(GeneralreserveReserveOrderconfirmRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReservePlan(GeneralreserveReservePlanRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveQueryconfig(GeneralreserveReserveQueryconfigRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> generalreserveReserveQueryorder(GeneralreserveReserveQueryorderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> memberPointTotalUpdate(MemberPointTotalUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> memberPointTransactionUpdate(MemberPointTransactionUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> memberSyncOffline(MemberSyncOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> memberUpdate(MemberUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dzopenMerchantreceiptRefundaudit(DzopenMerchantreceiptRefundauditRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantreceiptDirectRefund(MerchantreceiptDirectRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantreceiptQueryQueryreceiptstatus(MerchantreceiptQueryQueryreceiptstatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantreceiptQueryVerifyreceipthistory(MerchantreceiptQueryVerifyreceipthistoryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantreceiptRefundRefundcallback(MerchantreceiptRefundRefundcallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantreceiptReverseconsume(MerchantreceiptReverseconsumeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantreceiptSendCallback(MerchantreceiptSendCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> merchantreceiptVerifyVerifyreceipt(MerchantreceiptVerifyVerifyreceiptRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> submitPayment(SubmitPaymentRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeAppendPaySubmit(TradeAppendPaySubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeCreateOrder(TradeCreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeCreateOrderWithoutPrepay(TradeCreateOrderWithoutPrepayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeDistributionFundsCallback(TradeDistributionFundsCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeOrderDataChange(TradeOrderDataChangeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeQueryOrder(TradeQueryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeQueryPayInfo(TradeQueryPayInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeQueryPayToken(TradeQueryPayTokenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeQueryRefund(TradeQueryRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> tradeRefundOrder(TradeRefundOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poimatchList(PoimatchListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poimatchTaskCreate(PoimatchTaskCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> publichospitalNoticeinfoChange(PublichospitalNoticeinfoChangeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> publichospitalRegistrationCancelOrder(PublichospitalRegistrationCancelOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> publichospitalRegistrationCreateOrder(PublichospitalRegistrationCreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> publichospitalSyncScheduleChange(PublichospitalSyncScheduleChangeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dealgroupBatchRelateRooms(DealgroupBatchRelateRoomsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageUpload(ImageUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> normalDealgroupQuery(NormalDealgroupQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productCurrentOnline(ProductCurrentOnlineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productCurrentSubmit(ProductCurrentSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupCreate(ProductDealgroupCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupDrawback(ProductDealgroupDrawbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupOffline(ProductDealgroupOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupOnline(ProductDealgroupOnlineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupQuery(ProductDealgroupQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupSubmit(ProductDealgroupSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupUpdateShopids(ProductDealgroupUpdateShopidsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupUpdateprice(ProductDealgroupUpdatepriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productDealgroupUpdatestock(ProductDealgroupUpdatestockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productEditMutex(ProductEditMutexRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductCreate(ProductProductCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductLoadproduct(ProductProductLoadproductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductLoadproductstock(ProductProductLoadproductstockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductOffline(ProductProductOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductOnline(ProductProductOnlineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductSubmit(ProductProductSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductUpdate(ProductProductUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productProductUpdateProductStock(ProductProductUpdateProductStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productRelationshipSave(ProductRelationshipSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productRelationshipStatusUpdate(ProductRelationshipStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productResourceLoadresource(ProductResourceLoadresourceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productResourceSubmit(ProductResourceSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productResourceUpdatestatus(ProductResourceUpdatestatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productSearchSupplyDiagnostics(ProductSearchSupplyDiagnosticsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productShopproductsGet(ProductShopproductsGetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productUnitedOfflineProduct(ProductUnitedOfflineProductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productUnitedQueryProduct(ProductUnitedQueryProductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productUnitedRevokeProduct(ProductUnitedRevokeProductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productUnitedUpdatePrices(ProductUnitedUpdatePricesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productUnitedUpdateShop(ProductUnitedUpdateShopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productUnitedUpdateStock(ProductUnitedUpdateStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> showeventQuery(ShoweventQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> showeventQuickUpdateStock(ShoweventQuickUpdateStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> showeventSubmit(ShoweventSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> showeventUpdateStatus(ShoweventUpdateStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateOrder(CreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateRelationOrder(CreateRelationOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhInstallmentPay(InstallmentPayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhQueryPayToken(QueryPayTokenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhRefundOrder(RefundOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhSyncOrder(SyncOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxcw.createOrder.CreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhQueryPayToken(com.meituan.sdk.model.ddzhkh.xcxcw.queryPayToken.QueryPayTokenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxcw.refundOrder.RefundOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxcw.syncOrder.SyncOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhSyncAri(SyncAriRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryInquiryOrder(QueryInquiryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhSyncAri(com.meituan.sdk.model.ddzhkh.xcxjwhs.syncAri.SyncAriRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxmj.createOrder.CreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> syncStatus(SyncStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxpw.createOrder.CreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> prePay(PrePayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhQueryOrder(com.meituan.sdk.model.ddzhkh.xcxpw.queryOrder.QueryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryPayInfo(QueryPayInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhQueryPayToken(com.meituan.sdk.model.ddzhkh.xcxpw.queryPayToken.QueryPayTokenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryRefundInfo(QueryRefundInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxpw.refundOrder.RefundOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxpw.syncOrder.SyncOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxwy.createOrder.CreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxwy.refundOrder.RefundOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> submitFileTransfer(SubmitFileTransferRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxwy.syncOrder.SyncOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxzc.createOrder.CreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhCreateRelationOrder(com.meituan.sdk.model.ddzhkh.xcxzc.createRelationOrder.CreateRelationOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhInstallmentPay(com.meituan.sdk.model.ddzhkh.xcxzc.installmentPay.InstallmentPayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhQueryPayToken(com.meituan.sdk.model.ddzhkh.xcxzc.queryPayToken.QueryPayTokenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxzc.refundOrder.RefundOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxzc.syncOrder.SyncOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }
    /**
     * 充电订单费用信息同步。
     * <p>官方接口：{@code /ddzh/chargefulfill/orderfee/sync}，API：{@code charge_order_fee_sync}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> chargeOrderFeeSync(ChargeOrderFeeSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 充电订单履约。
     * <p>官方接口：{@code /ddzh/chargefulfill/order/fulfill}，API：{@code charge_order_fulfill}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> chargeOrderFulfill(ChargeOrderFulfillRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 充电订单信息同步。
     * <p>官方接口：{@code /ddzh/chargefulfill/orderinfo/sync}，API：{@code charge_order_info_sync}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> chargeOrderInfoSync(ChargeOrderInfoSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 充电占位费订单退款。
     * <p>官方接口：{@code /ddzh/chargefulfill/reservefee/refund}，API：{@code charge_reserve_order_refund}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> chargeReserveOrderRefund(ChargeReserveOrderRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 充电占位费订单同步。
     * <p>官方接口：{@code /ddzh/chargefulfill/reservefee/sync}，API：{@code reserve_order_fee_sync}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> reserveOrderFeeSync(ReserveOrderFeeSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 启动充电设备结果回调。
     * <p>官方接口：{@code /ddzh/chargefulfill/startresult/callback}，API：{@code start_device_result_call_back}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> startDeviceResultCallBack(StartDeviceResultCallBackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 停止充电设备结果回调。
     * <p>官方接口：{@code /ddzh/chargefulfill/stopresult/callback}，API：{@code stop_device_result_call_back}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> stopDeviceResultCallBack(StopDeviceResultCallBackRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 文印订单信息及状态同步。
     * <p>官方接口：{@code /ddzh/print/orderinfo/sync}，API：{@code print_order_info_sync}，版本：{@code 10003}，businessId：{@code 58}，需要授权：{@code false}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> printOrderInfoSync(PrintOrderInfoSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 文印订单接单结果同步。
     * <p>官方接口：{@code /ddzh/print/orderresult/sync}，API：{@code print_order_result_sync}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code false}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> printOrderResultSync(PrintOrderResultSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 三方手艺人信息同步。
     * <p>官方接口：{@code /ddzh/yuding/resource/third-technician/sync}，API：{@code third_technician_sync}，版本：{@code 10084}，businessId：{@code 58}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> thirdTechnicianSync(ThirdTechnicianSyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 演出项目批量快速改库存。
     * <p>官方接口：{@code /ddzhkh/shangpin/showevent/batch/quick/update/stock}，API：{@code showevent_batch_quick_update_stock}，版本：{@code 10211}，businessId：{@code 59}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> showeventBatchQuickUpdateStock(ShoweventBatchQuickUpdateStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 追加支付。
     * <p>官方接口：{@code /ddzhkh/xcxbj/append_pay}，API：{@code append_pay}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> appendPay(AppendPayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 下单不支付。
     * <p>官方接口：{@code /ddzhkh/xcxbj/create_order}，API：{@code create_order}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> createOrder(com.meituan.sdk.model.ddzhkh.xcxbj.createOrder.CreateOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 申请退款接口。
     * <p>官方接口：{@code /ddzhkh/xcxbj/refund_order}，API：{@code refund_order}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> refundOrder(com.meituan.sdk.model.ddzhkh.xcxbj.refundOrder.RefundOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcxbj/sync_status}，API：{@code sync_order}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> syncOrder(com.meituan.sdk.model.ddzhkh.xcxbj.syncOrder.SyncOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 订单查询。
     * <p>官方接口：{@code /ddzhkh/xcxzc/query_order}，API：{@code query_order}，版本：{@code 10006}，businessId：{@code 59}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryOrder(com.meituan.sdk.model.ddzhkh.xcxzc.queryOrder.QueryOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * 查询退款结果。
     * <p>官方接口：{@code /ddzhkh/xcxzc/query_refund_info}，API：{@code query_refund_info}，版本：{@code 10007}，businessId：{@code 59}，需要授权：{@code true}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> ddzhkhQueryRefundInfo(com.meituan.sdk.model.ddzhkh.xcxzc.queryRefundInfo.QueryRefundInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

}
