package io.github.easy4j.meituan.service;

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

/**
 * 服务零售业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanRetailService extends MeituanService {

    /**
     * 待上单接口。
     * <p>官方接口：{@code /ddzh/analysis/pending/storeOrder}，API：{@code pending_store_order}，版本：{@code 10005}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pendingStoreOrder(PendingStoreOrderRequest request, String tenantId);

    /**
     * 待新签门店。
     * <p>官方接口：{@code /ddzh/analysis/pending/store/signing}，API：{@code pending_store_signing}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pendingStoreSigning(PendingStoreSigningRequest request, String tenantId);

    /**
     * 服务零售自定义灰度。
     * <p>官方接口：{@code /ddzh/common/virtualnum/gray/create}，API：{@code common_gray_operate}，版本：{@code 10005}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commonGrayOperate(CommonGrayOperateRequest request, String tenantId);

    /**
     * 流量灰度配置（指定开发者）。
     * <p>官方接口：{@code /ddzh/common/gray/configByDev}，API：{@code gray_config_base_dev}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> grayConfigBaseDev(GrayConfigBaseDevRequest request, String tenantId);

    /**
     * 流量灰度配置（指定开发者和session）。
     * <p>官方接口：{@code /ddzh/common/gray/configBySession}，API：{@code gray_config_base_session}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> grayConfigBaseSession(GrayConfigBaseSessionRequest request, String tenantId);

    /**
     * 回滚灰度配置（指定开发者回滚）。
     * <p>官方接口：{@code /ddzh/common/gray/rollback}，API：{@code gray_config_rollback}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> grayConfigRollback(GrayConfigRollbackRequest request, String tenantId);

    /**
     * 回滚灰度配置（指定开发者和session）。
     * <p>官方接口：{@code /ddzh/common/gray/rollbackBySession}，API：{@code gray_config_rollback_by_session}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> grayConfigRollbackBySession(GrayConfigRollbackBySessionRequest request, String tenantId);

    /**
     * 查询命中session灰度的门店。
     * <p>官方接口：{@code /ddzh/common/gray/queryHitSessionGrayPoi}，API：{@code gray_query_hit_session_gray_poi}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> grayQueryHitSessionGrayPoi(GrayQueryHitSessionGrayPoiRequest request, String tenantId);

    /**
     * 迁移原北极星session。
     * <p>官方接口：{@code /ddzh/common/datamigration/migrateSession}，API：{@code migrate_session}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> migrateSession(MigrateSessionRequest request, String tenantId);

    /**
     * 查询已迁移session明细。
     * <p>官方接口：{@code /ddzh/common/datamigration/migrationTaskDetail}，API：{@code migrate_task_detail}，版本：{@code 10001}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> migrateTaskDetail(MigrateTaskDetailRequest request, String tenantId);

    /**
     * 查询原北极星有效session。
     * <p>官方接口：{@code /ddzh/common/datamigration/session/query}，API：{@code page_query_session}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pageQuerySession(PageQuerySessionRequest request, String tenantId);

    /**
     * 查询已迁移原北极星session和合作中心token的映射关系。
     * <p>官方接口：{@code /ddzh/common/datamigration/session/pageQuerySessionTokenMapping}，API：{@code page_query_session_token_mapping}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pageQuerySessionTokenMapping(PageQuerySessionTokenMappingRequest request, String tenantId);

    /**
     * 查询授权操作客户。
     * <p>官方接口：{@code /ddzh/common/authorization/grantingOpCustomer/query}，API：{@code query_granting_op_customer}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryGrantingOpCustomer(QueryGrantingOpCustomerRequest request, String tenantId);

    /**
     * 原北极星加密客户id转换为合作中心加密客户id。
     * <p>官方接口：{@code /ddzh/common/transfer/bidToOpCustomerId}，API：{@code transfer_bid_to_op_customer_id}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> transferBidToOpCustomerId(TransferBidToOpCustomerIdRequest request, String tenantId);

    /**
     * 合作中心加密客户id转换为原北极星加密客户id。
     * <p>官方接口：{@code /ddzh/common/transfer/opCustomerIdToBid}，API：{@code transfer_op_customer_id_to_bid}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> transferOpCustomerIdToBid(TransferOpCustomerIdToBidRequest request, String tenantId);

    /**
     * 合作中心opUserId转换为原北极星openUserId。
     * <p>官方接口：{@code /ddzh/common/transfer/opUserIdToOpenUserId}，API：{@code transfer_op_user_id_to_open_user_id}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> transferOpUserIdToOpenUserId(TransferOpUserIdToOpenUserIdRequest request, String tenantId);

    /**
     * open_shop_uuid转换为op_poi_id。
     * <p>官方接口：{@code /ddzh/common/transfer/openShopUuidToOpPoiId}，API：{@code transfer_open_shop_uuid_to_op_poi_id}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> transferOpenShopUuidToOpPoiId(TransferOpenShopUuidToOpPoiIdRequest request, String tenantId);

    /**
     * 原北极星openUserId转合作中心opUserId。
     * <p>官方接口：{@code /ddzh/common/transfer/openUserIdToOpUserId}，API：{@code transfer_open_user_id_to_op_user_id}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> transferOpenUserIdToOpUserId(TransferOpenUserIdToOpUserIdRequest request, String tenantId);

    /**
     * op_poi_id转换为open_shop_uuid。
     * <p>官方接口：{@code /ddzh/common/transfer/OpPoiIdToOpenShopUuid}，API：{@code transfer_oppoiid_to_open_shop_uuids}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> transferOppoiidToOpenShopUuids(TransferOppoiidToOpenShopUuidsRequest request, String tenantId);

    /**
     * 根据手机号查询对应混淆后ID(隐私号相关)。
     * <p>官方接口：{@code /ddzh/common/virtualnum/query/opid}，API：{@code virtualnum_query_opid}，版本：{@code 10005}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> virtualnumQueryOpid(VirtualnumQueryOpidRequest request, String tenantId);

    /**
     * 添加客资跟进信息接口。
     * <p>官方接口：{@code /ddzh/customercenter/addfollowup}，API：{@code customercenter_addfollowup}，版本：{@code 10001}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> customercenterAddfollowup(CustomercenterAddfollowupRequest request, String tenantId);

    /**
     * 理赔状态回调接口。
     * <p>官方接口：{@code /ddzh/le/insurance/claim/status/callback}，API：{@code claim_status_callback}，版本：{@code 10013}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> claimStatusCallback(ClaimStatusCallbackRequest request, String tenantId);

    /**
     * 投保回调接口。
     * <p>官方接口：{@code /ddzh/le/insurance/insure/callback}，API：{@code insure_callback}，版本：{@code 10015}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> insureCallback(InsureCallbackRequest request, String tenantId);

    /**
     * 退保回调接口。
     * <p>官方接口：{@code /ddzh/le/insurance/insure/cancel/callback}，API：{@code insure_cancel_callback}，版本：{@code 10011}，businessId：{@code 58}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> insureCancelCallback(InsureCancelCallbackRequest request, String tenantId);

    /**
     * 预约数。
     * <p>官方接口：{@code /ddzh/merchantdata/book}，API：{@code merchant_data_booking}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantDataBooking(MerchantDataBookingRequest request, String tenantId);

    /**
     * 消费数据。
     * <p>官方接口：{@code /ddzh/merchantdata/consumption}，API：{@code merchant_data_consumption}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantDataConsumption(MerchantDataConsumptionRequest request, String tenantId);

    /**
     * 团单消费详情。
     * <p>官方接口：{@code /ddzh/merchantdata/dealgroups}，API：{@code merchant_data_deal_groups_consumption}，版本：{@code 10006}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantDataDealGroupsConsumption(MerchantDataDealGroupsConsumptionRequest request, String tenantId);

    /**
     * 获取门店流量数据。
     * <p>官方接口：{@code /ddzh/merchantdata/poitraffic}，API：{@code merchant_data_poitraffic}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantDataPoitraffic(MerchantDataPoitrafficRequest request, String tenantId);

    /**
     * 三方交易流水信息推送。
     * <p>官方接口：{@code /ddzh/merchantdata/trade/histrory}，API：{@code saas_trade_history}，版本：{@code 10009}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> saasTradeHistory(SaasTradeHistoryRequest request, String tenantId);

    /**
     * 获取门店优惠码。
     * <p>官方接口：{@code /ddzh/poiqrcode/querydzcoupon}，API：{@code poiqrcode_querydzcoupon}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poiqrcodeQuerydzcoupon(PoiqrcodeQuerydzcouponRequest request, String tenantId);

    /**
     * 医院挂号-新增&更新科室。
     * <p>官方接口：{@code /ddzh/registration/department/addOrEdit}，API：{@code registration_department_add_edit}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> registrationDepartmentAddEdit(RegistrationDepartmentAddEditRequest request, String tenantId);

    /**
     * 医院挂号-删除科室。
     * <p>官方接口：{@code /ddzh/registration/department/delete}，API：{@code registration_department_delete}，版本：{@code 10003}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> registrationDepartmentDelete(RegistrationDepartmentDeleteRequest request, String tenantId);

    /**
     * 医院挂号-查询科室详情。
     * <p>官方接口：{@code /ddzh/registration/department/detail}，API：{@code registration_department_detail}，版本：{@code 10006}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> registrationDepartmentDetail(RegistrationDepartmentDetailRequest request, String tenantId);

    /**
     * 医院挂号-查询科室信息。
     * <p>官方接口：{@code /ddzh/registration/department/query}，API：{@code registration_department_query}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> registrationDepartmentQuery(RegistrationDepartmentQueryRequest request, String tenantId);

    /**
     * 分页查询门店开店宝医生。
     * <p>官方接口：{@code /ddzh/registration/doctor/query}，API：{@code registration_doctor_query}，版本：{@code 10005}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> registrationDoctorQuery(RegistrationDoctorQueryRequest request, String tenantId);

    /**
     * 手艺人信息删除。
     * <p>官方接口：{@code /ddzh/technician/techInfo/delete}，API：{@code technician_techinfo_delete}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoDelete(TechnicianTechinfoDeleteRequest request, String tenantId);

    /**
     * 手艺人人货绑定。
     * <p>官方接口：{@code /ddzh/technician/techinfo/productbind}，API：{@code technician_techinfo_producttbind}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoProducttbind(TechnicianTechinfoProducttbindRequest request, String tenantId);

    /**
     * 手艺人信息查询。
     * <p>官方接口：{@code /ddzh/technician/techInfo/query}，API：{@code technician_techinfo_query}，版本：{@code 10008}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoQuery(TechnicianTechinfoQueryRequest request, String tenantId);

    /**
     * 查询手艺人服务项目/岗位。
     * <p>官方接口：{@code /ddzh/technician/techInfo/querytagtree}，API：{@code technician_techinfo_querytagtree}，版本：{@code 10014}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoQuerytagtree(TechnicianTechinfoQuerytagtreeRequest request, String tenantId);

    /**
     * 手艺人信息同步。
     * <p>官方接口：{@code /ddzh/technician/techInfo/savenew}，API：{@code technician_techinfo_savenew}，版本：{@code 10015}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoSavenew(TechnicianTechinfoSavenewRequest request, String tenantId);

    /**
     * 手艺人排班计划配置。
     * <p>官方接口：{@code /ddzh/technician/techinfo/scheduleconfig}，API：{@code technician_techinfo_scheduleconfig}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoScheduleconfig(TechnicianTechinfoScheduleconfigRequest request, String tenantId);

    /**
     * 手艺人上下线同步。
     * <p>官方接口：{@code /ddzh/technician/techInfo/switchonline}，API：{@code technician_techinfo_switchonline}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoSwitchonline(TechnicianTechinfoSwitchonlineRequest request, String tenantId);

    /**
     * 手艺人库存同步。
     * <p>官方接口：{@code /ddzh/technician/techInfo/syncstock}，API：{@code technician_techinfo_sycnstock}，版本：{@code 10009}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoSycnstock(TechnicianTechinfoSycnstockRequest request, String tenantId);

    /**
     * （三嫂）手艺人上下线。
     * <p>官方接口：{@code /ddzh/technician/techOnline/switch}，API：{@code technician_techinfo_techonline_switch}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoTechonlineSwitch(TechnicianTechinfoTechonlineSwitchRequest request, String tenantId);

    /**
     * 手艺人三方项目绑定接口。
     * <p>官方接口：{@code /ddzh/technician/techinfo/thirdPartyProjectbind}，API：{@code technician_techinfo_thirdpartyproject_bind}，版本：{@code 10010}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoThirdpartyprojectBind(TechnicianTechinfoThirdpartyprojectBindRequest request, String tenantId);

    /**
     * （三嫂）手艺人评价信息同步。
     * <p>官方接口：{@code /ddzh/technician/techUgc/add}，API：{@code technician_techinfo_ugc_add}，版本：{@code 10001}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoUgcAdd(TechnicianTechinfoUgcAddRequest request, String tenantId);

    /**
     * 手艺人订单扩展信息修改。
     * <p>官方接口：{@code /ddzh/technician/techinfo/updateorderextrac}，API：{@code technician_techinfo_updateorderextrac}，版本：{@code 10004}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> technicianTechinfoUpdateorderextrac(TechnicianTechinfoUpdateorderextracRequest request, String tenantId);

    /**
     * 新增设备型号信息。
     * <p>官方接口：{@code /ddzh/thirdresource/adddevicemodel}，API：{@code add_device_model}，版本：{@code 10030}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addDeviceModel(AddDeviceModelRequest request, String tenantId);

    /**
     * 球桌数据变更同步。
     * <p>官方接口：{@code /ddzh/thirdresource/billiard/tableInfo/sync}，API：{@code billiard_table_info_sync}，版本：{@code 10037}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> billiardTableInfoSync(BilliardTableInfoSyncRequest request, String tenantId);

    /**
     * 充电站设备状态同步。
     * <p>官方接口：{@code /ddzh/thirdresource/device/status/sync}，API：{@code charge_device_status_sync}，版本：{@code 10035}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> chargeDeviceStatusSync(ChargeDeviceStatusSyncRequest request, String tenantId);

    /**
     * 充电站点状态同步。
     * <p>官方接口：{@code /ddzh/thirdresource/station/status/sync}，API：{@code charge_station_status_sync}，版本：{@code 10035}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> chargeStationStatusSync(ChargeStationStatusSyncRequest request, String tenantId);

    /**
     * 同步门店下设备信息接口。
     * <p>官方接口：{@code /ddzh/thirdresource/syncdeviceinfo}，API：{@code sync_device_info}，版本：{@code 10026}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> syncDeviceInfo(SyncDeviceInfoRequest request, String tenantId);

    /**
     * 更新单个门店下变更的设备信息接口。
     * <p>官方接口：{@code /ddzh/thirdresource/updatedeviceinfo}，API：{@code update_device_info}，版本：{@code 10027}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateDeviceInfo(UpdateDeviceInfoRequest request, String tenantId);

    /**
     * 更新设备型号信息。
     * <p>官方接口：{@code /ddzh/thirdresource/updatedevicemodel}，API：{@code update_device_model}，版本：{@code 10028}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateDeviceModel(UpdateDeviceModelRequest request, String tenantId);

    /**
     * 更新单个门店下指定设备状态。
     * <p>官方接口：{@code /ddzh/thirdresource/updatedevicestatus}，API：{@code update_device_status}，版本：{@code 10029}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateDeviceStatus(UpdateDeviceStatusRequest request, String tenantId);

    /**
     * 上传门店扩展信息。
     * <p>官方接口：{@code /ddzh/thirdresource/uploadpoiattrinfo}，API：{@code upload_poi_pttr_info}，版本：{@code 10031}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> uploadPoiPttrInfo(UploadPoiPttrInfoRequest request, String tenantId);

    /**
     * 设备启动/操作的结果回调。
     * <p>官方接口：{@code /ddzh/tuangou/device/change/callback}，API：{@code device_change_callback}，版本：{@code 10087}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> deviceChangeCallback(DeviceChangeCallbackRequest request, String tenantId);

    /**
     * 买单订单查询。
     * <p>官方接口：{@code /ddzh/tuangou/paybill/query}，API：{@code pay_bill_query}，版本：{@code 10105}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> payBillQuery(PayBillQueryRequest request, String tenantId);

    /**
     * 买单订单退款。
     * <p>官方接口：{@code /ddzh/tuangou/paybill/refund}，API：{@code pay_bill_refund}，版本：{@code 10102}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> payBillRefund(PayBillRefundRequest request, String tenantId);

    /**
     * 获取团购信息。
     * <p>官方接口：{@code /ddzh/tuangou/deal/queryshopdeal}，API：{@code tuangou_deal_queryshopdeal}，版本：{@code 10087}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouDealQueryshopdeal(TuangouDealQueryshopdealRequest request, String tenantId);

    /**
     * 团购商家备货完成。
     * <p>官方接口：{@code /ddzh/tuangou/goods/prepared}，API：{@code tuangou_goods_prepared}，版本：{@code 10096}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouGoodsPrepared(TuangouGoodsPreparedRequest request, String tenantId);

    /**
     * 团购商家开始备货。
     * <p>官方接口：{@code /ddzh/tuangou/goods/startprepare}，API：{@code tuangou_goods_start_prepare}，版本：{@code 10096}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouGoodsStartPrepare(TuangouGoodsStartPrepareRequest request, String tenantId);

    /**
     * 商品库存批量同步。
     * <p>官方接口：{@code /ddzh/tuangou/goods/stock/sync}，API：{@code tuangou_goods_stock_sync}，版本：{@code 10095}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouGoodsStockSync(TuangouGoodsStockSyncRequest request, String tenantId);

    /**
     * 团购商家接单结果回调。
     * <p>官方接口：{@code /ddzh/tuangou/order/result/callback}，API：{@code tuangou_order_result_callback}，版本：{@code 10096}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouOrderResultCallback(TuangouOrderResultCallbackRequest request, String tenantId);

    /**
     * 查询门店消费码商品信息。
     * <p>官方接口：{@code /ddzh/tuangou/product/queryproduct}，API：{@code tuangou_product_queryproduct}，版本：{@code 10087}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouProductQueryproduct(TuangouProductQueryproductRequest request, String tenantId);

    /**
     * 按商品类型查询门店商品信息。
     * <p>官方接口：{@code /ddzh/tuangou/product/queryproductbytype}，API：{@code tuangou_product_queryproductbytype}，版本：{@code 10090}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouProductQueryproductbytype(TuangouProductQueryproductbytypeRequest request, String tenantId);

    /**
     * 团购商品库存查询。
     * <p>官方接口：{@code /ddzh/tuangou/product/stockquery}，API：{@code tuangou_product_stock_query}，版本：{@code 10094}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouProductStockQuery(TuangouProductStockQueryRequest request, String tenantId);

    /**
     * 团购退款申请。
     * <p>官方接口：{@code /ddzh/tuangou/apply/refund}，API：{@code tuangou_receipt_apply_refund}，版本：{@code 10091}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptApplyRefund(TuangouReceiptApplyRefundRequest request, String tenantId);

    /**
     * 批量撤销验券。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/batch/reverseconsume}，API：{@code tuangou_receipt_batch_reverseconsume}，版本：{@code 10092}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptBatchReverseconsume(TuangouReceiptBatchReverseconsumeRequest request, String tenantId);

    /**
     * 次卡批量验券。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/batchconsume}，API：{@code tuangou_receipt_batchconsume}，版本：{@code 10103}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptBatchconsume(TuangouReceiptBatchconsumeRequest request, String tenantId);

    /**
     * 验券。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/consume}，API：{@code tuangou_receipt_consume}，版本：{@code 10100}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptConsume(TuangouReceiptConsumeRequest request, String tenantId);

    /**
     * 查询已验券信息。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/getconsumed}，API：{@code tuangou_receipt_getconsumed}，版本：{@code 10087}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptGetconsumed(TuangouReceiptGetconsumedRequest request, String tenantId);

    /**
     * 团购退款预校验。
     * <p>官方接口：{@code /ddzh/tuangou/pre/refund/valid}，API：{@code tuangou_receipt_pre_refund_valid}，版本：{@code 10091}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptPreRefundValid(TuangouReceiptPreRefundValidRequest request, String tenantId);

    /**
     * 输码验券校验。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/prepare}，API：{@code tuangou_receipt_prepare}，版本：{@code 10098}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptPrepare(TuangouReceiptPrepareRequest request, String tenantId);

    /**
     * 查询标品信息。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/queryproduct}，API：{@code tuangou_receipt_query_product}，版本：{@code 10087}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptQueryProduct(TuangouReceiptQueryProductRequest request, String tenantId);

    /**
     * 团购退款信息查询。
     * <p>官方接口：{@code /ddzh/tuangou/query/refund/info}，API：{@code tuangou_receipt_query_refund_by_refund_id}，版本：{@code 10091}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptQueryRefundByRefundId(TuangouReceiptQueryRefundByRefundIdRequest request, String tenantId);

    /**
     * 券关联订单可用券码查询。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/queryrelevantusable}，API：{@code tuangou_receipt_query_usablerevelant}，版本：{@code 10097}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptQueryUsablerevelant(TuangouReceiptQueryUsablerevelantRequest request, String tenantId);

    /**
     * 手机号查询可用团购券。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/querybymobile}，API：{@code tuangou_receipt_querybymobile}，版本：{@code 10050}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptQuerybymobile(TuangouReceiptQuerybymobileRequest request, String tenantId);

    /**
     * 验券记录。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/querylistbydate}，API：{@code tuangou_receipt_querylistbydate}，版本：{@code 10087}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptQuerylistbydate(TuangouReceiptQuerylistbydateRequest request, String tenantId);

    /**
     * 团购退款审核。
     * <p>官方接口：{@code /ddzh/tuangou/refund/audit}，API：{@code tuangou_receipt_refund_audit}，版本：{@code 10091}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptRefundAudit(TuangouReceiptRefundAuditRequest request, String tenantId);

    /**
     * 撤销验券。
     * <p>官方接口：{@code /ddzh/tuangou/receipt/reverseconsume}，API：{@code tuangou_receipt_reverseconsume}，版本：{@code 10087}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tuangouReceiptReverseconsume(TuangouReceiptReverseconsumeRequest request, String tenantId);

    /**
     * 单一门店查询评论数据。
     * <p>官方接口：{@code /ddzh/ugc/queryshopreview}，API：{@code ugc_query_shop_review}，版本：{@code 10007}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ugcQueryShopReview(UgcQueryShopReviewRequest request, String tenantId);

    /**
     * 查询门店星级和单项分。
     * <p>官方接口：{@code /ddzh/ugc/querystar}，API：{@code ugc_querystar}，版本：{@code 10005}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ugcQuerystar(UgcQuerystarRequest request, String tenantId);

    /**
     * 发起补价。
     * <p>官方接口：{@code /ddzh/yuding/addprice}，API：{@code addprice}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> addprice(AddpriceRequest request, String tenantId);

    /**
     * 预支付。
     * <p>官方接口：{@code /ddzh/yuding/applypayment}，API：{@code applypayment}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> applypayment(ApplypaymentRequest request, String tenantId);

    /**
     * 俱乐部拼场活动美团侧参与接口。
     * <p>官方接口：{@code /ddzh/yuding/clubactivity/join}，API：{@code book_clubactivity_join}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookClubactivityJoin(BookClubactivityJoinRequest request, String tenantId);

    /**
     * 俱乐部拼场活动三方侧人数同步接口。
     * <p>官方接口：{@code /ddzh/yuding/clubactivity/thirdpeople/sync}，API：{@code book_clubactivity_third_people_sync}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookClubactivityThirdPeopleSync(BookClubactivityThirdPeopleSyncRequest request, String tenantId);

    /**
     * 预订三方订单信息修改通知。
     * <p>官方接口：{@code /ddzh/yuding/bookorderinfoupdatednotice}，API：{@code book_order_info_updated_notice}，版本：{@code 10047}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookOrderInfoUpdatedNotice(BookOrderInfoUpdatedNoticeRequest request, String tenantId);

    /**
     * 自提码核销。
     * <p>官方接口：{@code /ddzh/yuding/selfpickupverify}，API：{@code book_selfpickupverify}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookSelfpickupverify(BookSelfpickupverifyRequest request, String tenantId);

    /**
     * 预定库存模式变更同步。
     * <p>官方接口：{@code /ddzh/yuding/stock/mode/update}，API：{@code book_stock_mode_update}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookStockModeUpdate(BookStockModeUpdateRequest request, String tenantId);

    /**
     * 未预约尾款订单发起补价接口。
     * <p>官方接口：{@code /ddzh/yuding/unreserve/addprice}，API：{@code book_unreserve_addprice}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookUnreserveAddprice(BookUnreserveAddpriceRequest request, String tenantId);

    /**
     * 预订结果回调。
     * <p>官方接口：{@code /ddzh/yuding/bookresultcallback}，API：{@code bookresultcallback}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bookresultcallback(BookresultcallbackRequest request, String tenantId);

    /**
     * 改约结果回调。
     * <p>官方接口：{@code /ddzh/yuding/changeresultcallback}，API：{@code changeresultcallback}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> changeresultcallback(ChangeresultcallbackRequest request, String tenantId);

    /**
     * 下单并预支付。
     * <p>官方接口：{@code /ddzh/yuding/createandprepayorder}，API：{@code createandprepayorder}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createandprepayorder(CreateandprepayorderRequest request, String tenantId);

    /**
     * 一品多态门店信息查询。
     * <p>官方接口：{@code /ddzh/yuding/dealgroupbook/shopinfoquery}，API：{@code dealgroubook_shop_query}，版本：{@code 10058}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dealgroubookShopQuery(DealgroubookShopQueryRequest request, String tenantId);

    /**
     * 分页查询门店下的所有团购商品。
     * <p>官方接口：{@code /ddzh/yuding/resource/dealgroup/product/query}，API：{@code dealgroup_product_query}，版本：{@code 10051}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dealgroupProductQuery(DealgroupProductQueryRequest request, String tenantId);

    /**
     * 推送团购可订信息。
     * <p>官方接口：{@code /ddzh/yuding/resource/dealgroup/relate/booking}，API：{@code dealgroup_relate_booking}，版本：{@code 10071}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dealgroupRelateBooking(DealgroupRelateBookingRequest request, String tenantId);

    /**
     * 推送团购商品关联包型包间。
     * <p>官方接口：{@code /ddzh/yuding/resource/dealgroup/relate/room}，API：{@code dealgroup_relate_room}，版本：{@code 10046}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dealgroupRelateRoom(DealgroupRelateRoomRequest request, String tenantId);

    /**
     * 用户到店核销。
     * <p>官方接口：{@code /ddzh/yuding/isvconsume}，API：{@code isvconsume}，版本：{@code 10057}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> isvconsume(IsvconsumeRequest request, String tenantId);

    /**
     * ktv一键下线套餐（将某天某时段内价格低于阈值的套餐下线）。
     * <p>官方接口：{@code /ddzh/yuding/ktv/mtroom/offline}，API：{@code ktv_mtroom_offline}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ktvMtroomOffline(KtvMtroomOfflineRequest request, String tenantId);

    /**
     * 三方调用本接口用于将某时段下某房型设置为手动接单或满房。
     * <p>官方接口：{@code /ddzh/yuding/ktv/mtroom/operateStatus}，API：{@code ktv_mtroom_operate_status}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ktvMtroomOperateStatus(KtvMtroomOperateStatusRequest request, String tenantId);

    /**
     * ktv美团房型数据查询。
     * <p>官方接口：{@code /ddzh/yuding/ktv/mtroom/query}，API：{@code ktv_mtroom_query}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ktvMtroomQuery(KtvMtroomQueryRequest request, String tenantId);

    /**
     * 三方房型实时库存同步。
     * <p>官方接口：{@code /ddzh/yuding/ktv/mtroom/stock/operate}，API：{@code ktv_mtroom_stock_operate}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ktvMtroomStockOperate(KtvMtroomStockOperateRequest request, String tenantId);

    /**
     * ktv美团时段数据查询。
     * <p>官方接口：{@code /ddzh/yuding/ktv/period/query}，API：{@code ktv_period_query}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ktvPeriodQuery(KtvPeriodQueryRequest request, String tenantId);

    /**
     * ktv悦享商户身份同步。
     * <p>官方接口：{@code /ddzh/yuding/ktv/poiStatus/sync}，API：{@code ktv_poi_status_sync}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ktvPoiStatusSync(KtvPoiStatusSyncRequest request, String tenantId);

    /**
     * ktv三方房型数据同步。
     * <p>官方接口：{@code /ddzh/yuding/ktv/room/sync}，API：{@code ktv_room_sync}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ktvRoomSync(KtvRoomSyncRequest request, String tenantId);

    /**
     * 商家改约。
     * <p>官方接口：{@code /ddzh/yuding/lifereserve/merchantmodify}，API：{@code lifereserve_merchantmodify}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> lifereserveMerchantmodify(LifereserveMerchantmodifyRequest request, String tenantId);

    /**
     * 商家主动申请退款(支持部分退)。
     * <p>官方接口：{@code /ddzh/yuding/merchantapply/refund}，API：{@code merchant_apply_refund}，版本：{@code 10067}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantApplyRefund(MerchantApplyRefundRequest request, String tenantId);

    /**
     * 续时场景商家主动取消。
     * <p>官方接口：{@code /ddzh/yuding/merchantapply/multirefund}，API：{@code merchantapply_multi_refund}，版本：{@code 10055}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantapplyMultiRefund(MerchantapplyMultiRefundRequest request, String tenantId);

    /**
     * 商家取消订单。
     * <p>官方接口：{@code /ddzh/yuding/merchantcancelorder}，API：{@code merchantcancelorder}，版本：{@code 10063}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantcancelorder(MerchantcancelorderRequest request, String tenantId);

    /**
     * 创建服务人员。
     * <p>官方接口：{@code /ddzh/yuding/person/create}，API：{@code personcreate}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> personcreate(PersoncreateRequest request, String tenantId);

    /**
     * 查询绑定在门店下的服务人员信息。
     * <p>官方接口：{@code /ddzh/yuding/person/query}，API：{@code personquery}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> personquery(PersonqueryRequest request, String tenantId);

    /**
     * 解绑服务人员与门店关系。
     * <p>官方接口：{@code /ddzh/yuding/person/unbind}，API：{@code personunbind}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> personunbind(PersonunbindRequest request, String tenantId);

    /**
     * 修改服务人员信息。
     * <p>官方接口：{@code /ddzh/yuding/person/update}，API：{@code personupdate}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> personupdate(PersonupdateRequest request, String tenantId);

    /**
     * 价目表商品预定规则同步。
     * <p>官方接口：{@code /ddzh/yuding/pricelist/bookrule/sync}，API：{@code pricelist_bookrule_sync}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pricelistBookruleSync(PricelistBookruleSyncRequest request, String tenantId);

    /**
     * 价目表商品加载查询接口。
     * <p>官方接口：{@code /ddzh/yuding/pricelist/load}，API：{@code pricelist_load}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pricelistLoad(PricelistLoadRequest request, String tenantId);

    /**
     * 创建价目表商品时段资源。
     * <p>官方接口：{@code /ddzh/yuding/pricePeriods/create}，API：{@code pricelist_periods_create}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pricelistPeriodsCreate(PricelistPeriodsCreateRequest request, String tenantId);

    /**
     * 价目表商品创建提交/编辑接口。
     * <p>官方接口：{@code /ddzh/yuding/pricelist/submit}，API：{@code pricelist_submit}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pricelistSubmit(PricelistSubmitRequest request, String tenantId);

    /**
     * 团购-三方项目Id关联关系推送。
     * <p>官方接口：{@code /ddzh/yuding/resource/productmapping}，API：{@code project_mapping_push}，版本：{@code 10064}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> projectMappingPush(ProjectMappingPushRequest request, String tenantId);

    /**
     * 查询预订规则。
     * <p>官方接口：{@code /ddzh/yuding/query/bookrule}，API：{@code query_bookrule}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryBookrule(QueryBookruleRequest request, String tenantId);

    /**
     * 获取加价价目表。
     * <p>官方接口：{@code /ddzh/yuding/query/markuppricelist}，API：{@code query_markuppricelist}，版本：{@code 10001}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryMarkuppricelist(QueryMarkuppricelistRequest request, String tenantId);

    /**
     * 查询订单信息。
     * <p>官方接口：{@code /ddzh/yuding/query/order}，API：{@code query_order}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhQueryOrder(QueryOrderRequest request, String tenantId);

    /**
     * 查询服务人员信息。
     * <p>官方接口：{@code /ddzh/yuding/query/serviceman}，API：{@code query_serviceman}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryServiceman(QueryServicemanRequest request, String tenantId);

    /**
     * 获取授权上传链接。
     * <p>官方接口：{@code /ddzh/yuding/query/uploadlink}，API：{@code query_uploadlink}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryUploadlink(QueryUploadlinkRequest request, String tenantId);

    /**
     * 获取手机虚拟号。
     * <p>官方接口：{@code /ddzh/yuding/query/virtualnum}，API：{@code query_virtualnum}，版本：{@code 10068}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryVirtualnum(QueryVirtualnumRequest request, String tenantId);

    /**
     * 查询支付结果。
     * <p>官方接口：{@code /ddzh/yuding/queryorderpaymentinfo}，API：{@code queryorderpaymentinfo}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryorderpaymentinfo(QueryorderpaymentinfoRequest request, String tenantId);

    /**
     * 取消预订审核结果回调。
     * <p>官方接口：{@code /ddzh/yuding/refundauditresult}，API：{@code refundauditresult}，版本：{@code 10065}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> refundauditresult(RefundauditresultRequest request, String tenantId);

    /**
     * 删除包型。
     * <p>官方接口：{@code /ddzh/yuding/resource/room/delete}，API：{@code room_delete}，版本：{@code 10046}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> roomDelete(RoomDeleteRequest request, String tenantId);

    /**
     * 查询美团包型包间相关信息。
     * <p>官方接口：{@code /ddzh/yuding/resource/room/query}，API：{@code room_query}，版本：{@code 10050}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> roomQuery(RoomQueryRequest request, String tenantId);

    /**
     * 包型包间推送。
     * <p>官方接口：{@code /ddzh/yuding/resource/room/sync}，API：{@code room_sync}，版本：{@code 10070}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> roomSync(RoomSyncRequest request, String tenantId);

    /**
     * 推送门店预订规则。
     * <p>官方接口：{@code /ddzh/yuding/resource/shoprule/booking}，API：{@code shop_rule_booking}，版本：{@code 10052}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shopRuleBooking(ShopRuleBookingRequest request, String tenantId);

    /**
     * 场馆实时库存同步。
     * <p>官方接口：{@code /ddzh/yuding/thirdParty/stockSync}，API：{@code third_party_stock_sync}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> thirdPartyStockSync(ThirdPartyStockSyncRequest request, String tenantId);

    /**
     * 三方门店推送预订规则至平台。
     * <p>官方接口：{@code /ddzh/yuding/updatebookrule}，API：{@code updatebookrule}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updatebookrule(UpdatebookruleRequest request, String tenantId);

    /**
     * 更新订单履约信息。
     * <p>官方接口：{@code /ddzh/yuding/updateorderfulfillinfo}，API：{@code updateorderfulfillinfo}，版本：{@code 10053}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updateorderfulfillinfo(UpdateorderfulfillinfoRequest request, String tenantId);

    /**
     * 更新三方库存。
     * <p>官方接口：{@code /ddzh/yuding/updatestock}，API：{@code updatestock}，版本：{@code 10061}，businessId：{@code 58}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updatestock(UpdatestockRequest request, String tenantId);

    /**
     * 适用门店查询。
     * <p>官方接口：{@code /ddzhkh/auth/token/pageQueryPoiList}，API：{@code page_query_token_poi_list}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> pageQueryTokenPoiList(PageQueryTokenPoiListRequest request, String tenantId);

    /**
     * 对应客户门店ID映射关系。
     * <p>官方接口：{@code /ddzhkh/auth/token/queryPoiMapping}，API：{@code query_poi_mapping}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryPoiMapping(QueryPoiMappingRequest request, String tenantId);

    /**
     * 俱乐部活动参与人查询。
     * <p>官方接口：{@code /ddzhkh/clubactivity/activity/participants/query}，API：{@code clubactivity_activity_participants_query}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> clubactivityActivityParticipantsQuery(ClubactivityActivityParticipantsQueryRequest request, String tenantId);

    /**
     * 俱乐部活动同步。
     * <p>官方接口：{@code /ddzhkh/clubactivity/club/activity/sync}，API：{@code clubactivity_club_activity_sync}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> clubactivityClubActivitySync(ClubactivityClubActivitySyncRequest request, String tenantId);

    /**
     * 俱乐部活动状态更新。
     * <p>官方接口：{@code /ddzhkh/clubactivity/club/activitystatus/update}，API：{@code clubactivity_club_activitystatus_update}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> clubactivityClubActivitystatusUpdate(ClubactivityClubActivitystatusUpdateRequest request, String tenantId);

    /**
     * 俱乐部信息同步接口。
     * <p>官方接口：{@code /ddzhkh/clubactivity/club/info/sync}，API：{@code clubactivity_club_info_sync}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> clubactivityClubInfoSync(ClubactivityClubInfoSyncRequest request, String tenantId);

    /**
     * 订单批量查询(新)。
     * <p>官方接口：{@code /ddzhkh/dingdan/bookorder/batchquery}，API：{@code order_book_batch_query}，版本：{@code 10026}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderBookBatchQuery(OrderBookBatchQueryRequest request, String tenantId);

    /**
     * 订单及券码状态查询。
     * <p>官方接口：{@code /ddzhkh/dingdan/query/info}，API：{@code order_query_info}，版本：{@code 10035}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderQueryInfo(OrderQueryInfoRequest request, String tenantId);

    /**
     * 订单批量查询。
     * <p>官方接口：{@code /ddzhkh/dingdan/queryorder}，API：{@code order_queryorder}，版本：{@code 10025}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderQueryorder(OrderQueryorderRequest request, String tenantId);

    /**
     * 订单券码分摊金额查询。
     * <p>官方接口：{@code /ddzhkh/dingdan/receipt/paymentshares}，API：{@code order_receipt_paymentshares}，版本：{@code 10033}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderReceiptPaymentshares(OrderReceiptPaymentsharesRequest request, String tenantId);

    /**
     * 上门预约订单信息查询。
     * <p>官方接口：{@code /ddzhkh/dingdan/reserveorderquery}，API：{@code order_reserveorderquery}，版本：{@code 10027}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderReserveorderquery(OrderReserveorderqueryRequest request, String tenantId);

    /**
     * 账期对应调整明细。
     * <p>官方接口：{@code /ddzhkh/finance/deduct/detail}，API：{@code finance_deduct_detail}，版本：{@code 10007}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> financeDeductDetail(FinanceDeductDetailRequest request, String tenantId);

    /**
     * 滚动账期-查询账期调整明细。
     * <p>官方接口：{@code /ddzhkh/finance/dnDeduct/detail}，API：{@code finance_dndeduct_detail}，版本：{@code 10016}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> financeDndeductDetail(FinanceDndeductDetailRequest request, String tenantId);

    /**
     * 滚动账期-查询账期收入明细。
     * <p>官方接口：{@code /ddzhkh/finance/dnIncome/detail}，API：{@code finance_dnincome_detail}，版本：{@code 10015}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> financeDnincomeDetail(FinanceDnincomeDetailRequest request, String tenantId);

    /**
     * 查询账期收入明细。
     * <p>官方接口：{@code /ddzhkh/finance/income/detail}，API：{@code finance_income_detail}，版本：{@code 10007}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> financeIncomeDetail(FinanceIncomeDetailRequest request, String tenantId);

    /**
     * 查询券详情接口。
     * <p>官方接口：{@code /ddzhkh/finance/order/detail}，API：{@code finance_order_detail}，版本：{@code 10018}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> financeOrderDetail(FinanceOrderDetailRequest request, String tenantId);

    /**
     * 查询商户是否滚动账期结算。
     * <p>官方接口：{@code /ddzhkh/finance/payplan/type}，API：{@code finance_payplan_type}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> financePayplanType(FinancePayplanTypeRequest request, String tenantId);

    /**
     * 查询账期信息。
     * <p>官方接口：{@code /ddzhkh/finance/query/payplan}，API：{@code query_payplan_info}，版本：{@code 10011}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryPayplanInfo(QueryPayplanInfoRequest request, String tenantId);

    /**
     * 批量挂号费设置。
     * <p>官方接口：{@code /ddzhkh/generalreserve/batch/reserve/fee}，API：{@code generalreserve_batch_reserve_fee}，版本：{@code 10023}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveBatchReserveFee(GeneralreserveBatchReserveFeeRequest request, String tenantId);

    /**
     * 查询订单对应手机号信息。
     * <p>官方接口：{@code /ddzhkh/generalreserve/queryphoneinfo}，API：{@code generalreserve_queryphoneinfo}，版本：{@code 10019}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveQueryphoneinfo(GeneralreserveQueryphoneinfoRequest request, String tenantId);

    /**
     * 获取商户下的手艺人。
     * <p>官方接口：{@code /ddzhkh/generalreserve/queryshopalltechinfo}，API：{@code generalreserve_queryshopalltechinfo}，版本：{@code 10015}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveQueryshopalltechinfo(GeneralreserveQueryshopalltechinfoRequest request, String tenantId);

    /**
     * 取消回调接口-取消结果确认。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/cancelconfirm}，API：{@code generalreserve_reserve_cancelconfirm}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveCancelconfirm(GeneralreserveReserveCancelconfirmRequest request, String tenantId);

    /**
     * 更新预约配置。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/config}，API：{@code generalreserve_reserve_config}，版本：{@code 10026}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveConfig(GeneralreserveReserveConfigRequest request, String tenantId);

    /**
     * 挂号费设置。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/fee}，API：{@code generalreserve_reserve_fee}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveFee(GeneralreserveReserveFeeRequest request, String tenantId);

    /**
     * 商家取消。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/merchantcancel}，API：{@code generalreserve_reserve_merchantcancel}，版本：{@code 10018}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveMerchantcancel(GeneralreserveReserveMerchantcancelRequest request, String tenantId);

    /**
     * 商家创单。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/merchantcreateorder}，API：{@code generalreserve_reserve_merchantcreateorder}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveMerchantcreateorder(GeneralreserveReserveMerchantcreateorderRequest request, String tenantId);

    /**
     * 商家履约。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/merchantfullfill}，API：{@code generalreserve_reserve_merchantfullfill}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveMerchantfullfill(GeneralreserveReserveMerchantfullfillRequest request, String tenantId);

    /**
     * 商家改约。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/merchantmodify}，API：{@code generalreserve_reserve_merchantmodify}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveMerchantmodify(GeneralreserveReserveMerchantmodifyRequest request, String tenantId);

    /**
     * 改约回调接口-改约结果确认。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/modifyconfirm}，API：{@code generalreserve_reserve_modifyconfirm}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveModifyconfirm(GeneralreserveReserveModifyconfirmRequest request, String tenantId);

    /**
     * 创单回调接口-接单结果确认。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/orderconfirm}，API：{@code generalreserve_reserve_orderconfirm}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveOrderconfirm(GeneralreserveReserveOrderconfirmRequest request, String tenantId);

    /**
     * 预约库存相关信息变更。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/plan}，API：{@code generalreserve_reserve_plan}，版本：{@code 10028}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReservePlan(GeneralreserveReservePlanRequest request, String tenantId);

    /**
     * 查询预约配置。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/queryconfig}，API：{@code generalreserve_reserve_queryconfig}，版本：{@code 10022}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveQueryconfig(GeneralreserveReserveQueryconfigRequest request, String tenantId);

    /**
     * 预约单查询。
     * <p>官方接口：{@code /ddzhkh/generalreserve/reserve/queryorder}，API：{@code generalreserve_reserve_queryorder}，版本：{@code 10021}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> generalreserveReserveQueryorder(GeneralreserveReserveQueryorderRequest request, String tenantId);

    /**
     * 会员积分总数更新。
     * <p>官方接口：{@code /ddzhkh/member/point/total/update}，API：{@code member_point_total_update}，版本：{@code 10018}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> memberPointTotalUpdate(MemberPointTotalUpdateRequest request, String tenantId);

    /**
     * 更新积分事务。
     * <p>官方接口：{@code /ddzhkh/member/point/transaction/update}，API：{@code member_point_transaction_update}，版本：{@code 10019}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> memberPointTransactionUpdate(MemberPointTransactionUpdateRequest request, String tenantId);

    /**
     * 线下会员信息同步。
     * <p>官方接口：{@code /ddzhkh/member/sync/offline}，API：{@code member_sync_offline}，版本：{@code 10017}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> memberSyncOffline(MemberSyncOfflineRequest request, String tenantId);

    /**
     * 会员信息更新接口。
     * <p>官方接口：{@code /ddzhkh/member/update}，API：{@code member_update}，版本：{@code 10016}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> memberUpdate(MemberUpdateRequest request, String tenantId);

    /**
     * 非规则退审核接口。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/refundaudit}，API：{@code dzopen_merchantreceipt_refundaudit}，版本：{@code 10026}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dzopenMerchantreceiptRefundaudit(DzopenMerchantreceiptRefundauditRequest request, String tenantId);

    /**
     * 商家券已消费券码商家退款（商家发起）。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/direct/refund}，API：{@code merchantreceipt_direct_refund}，版本：{@code 10014}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantreceiptDirectRefund(MerchantreceiptDirectRefundRequest request, String tenantId);

    /**
     * 商家券查询券状态。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/query/queryreceiptstatus}，API：{@code merchantreceipt_query_queryreceiptstatus}，版本：{@code 10027}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantreceiptQueryQueryreceiptstatus(MerchantreceiptQueryQueryreceiptstatusRequest request, String tenantId);

    /**
     * 商家券查询验券历史。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/query/verifyreceipthistory}，API：{@code merchantreceipt_query_verifyreceipthistory}，版本：{@code 10025}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantreceiptQueryVerifyreceipthistory(MerchantreceiptQueryVerifyreceipthistoryRequest request, String tenantId);

    /**
     * 商家券退券回调。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/refund/refundcallback}，API：{@code merchantreceipt_refund_refundcallback}，版本：{@code 10023}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantreceiptRefundRefundcallback(MerchantreceiptRefundRefundcallbackRequest request, String tenantId);

    /**
     * 商家券撤销验券。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/reverseconsume}，API：{@code merchantreceipt_reverseconsume}，版本：{@code 10028}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantreceiptReverseconsume(MerchantreceiptReverseconsumeRequest request, String tenantId);

    /**
     * 商家券发券异步回调。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/send/callback}，API：{@code merchantreceipt_send_callback}，版本：{@code 10030}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantreceiptSendCallback(MerchantreceiptSendCallbackRequest request, String tenantId);

    /**
     * 商家券验券。
     * <p>官方接口：{@code /ddzhkh/merchantreceipt/verify/verifyreceipt}，API：{@code merchantreceipt_verify_verifyreceipt}，版本：{@code 10024}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> merchantreceiptVerifyVerifyreceipt(MerchantreceiptVerifyVerifyreceiptRequest request, String tenantId);

    /**
     * 预支付。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/submit_payment}，API：{@code submit_payment}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> submitPayment(SubmitPaymentRequest request, String tenantId);

    /**
     * 追加支付。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/append_pay_submit}，API：{@code trade_append_pay_submit}，版本：{@code 10013}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeAppendPaySubmit(TradeAppendPaySubmitRequest request, String tenantId);

    /**
     * 下单（包含预支付）。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/create_order}，API：{@code trade_create_order}，版本：{@code 10017}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeCreateOrder(TradeCreateOrderRequest request, String tenantId);

    /**
     * 下单（不包含预支付）。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/create_order_without_prepay}，API：{@code trade_create_order_without_prepay}，版本：{@code 10014}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeCreateOrderWithoutPrepay(TradeCreateOrderWithoutPrepayRequest request, String tenantId);

    /**
     * 外部资金回流。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/distribution_funds_callback}，API：{@code trade_distribution_funds_callback}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeDistributionFundsCallback(TradeDistributionFundsCallbackRequest request, String tenantId);

    /**
     * 订单数据同步。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/order_data_change}，API：{@code trade_order_data_change}，版本：{@code 10018}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeOrderDataChange(TradeOrderDataChangeRequest request, String tenantId);

    /**
     * 订单查询。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trip/miniprogram/trade/query_order}，API：{@code trade_query_order}，版本：{@code 10005}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeQueryOrder(TradeQueryOrderRequest request, String tenantId);

    /**
     * 支付结果查询。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/query_pay_info}，API：{@code trade_query_pay_info}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeQueryPayInfo(TradeQueryPayInfoRequest request, String tenantId);

    /**
     * 查询支付token。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/query_pay_token}，API：{@code trade_query_pay_token}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeQueryPayToken(TradeQueryPayTokenRequest request, String tenantId);

    /**
     * 退款查询。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/query_refund}，API：{@code trade_query_refund}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeQueryRefund(TradeQueryRefundRequest request, String tenantId);

    /**
     * 退款申请。
     * <p>官方接口：{@code /ddzhkh/miniprogram/trade/refund_order}，API：{@code trade_refund_order}，版本：{@code 10016}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> tradeRefundOrder(TradeRefundOrderRequest request, String tenantId);

    /**
     * 查询POI匹配列表。
     * <p>官方接口：{@code /ddzhkh/poi/poimatch/list}，API：{@code poimatch_list}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poimatchList(PoimatchListRequest request, String tenantId);

    /**
     * 创建poi匹配任务。
     * <p>官方接口：{@code /ddzhkh/poi/poimatch/task/create}，API：{@code poimatch_task_create}，版本：{@code 10001}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poimatchTaskCreate(PoimatchTaskCreateRequest request, String tenantId);

    /**
     * 医院、科室变更同步。
     * <p>官方接口：{@code /ddzhkh/publichospital/noticeinfo/change}，API：{@code publichospital_noticeinfo_change}，版本：{@code 10015}，businessId：{@code 59}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> publichospitalNoticeinfoChange(PublichospitalNoticeinfoChangeRequest request, String tenantId);

    /**
     * 公立医院挂号-取消订单。
     * <p>官方接口：{@code /ddzhkh/publichospital/registration/cancelOrder}，API：{@code publichospital_registration_cancel_order}，版本：{@code 10017}，businessId：{@code 59}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> publichospitalRegistrationCancelOrder(PublichospitalRegistrationCancelOrderRequest request, String tenantId);

    /**
     * 公立医院挂号-创建订单。
     * <p>官方接口：{@code /ddzhkh/publichospital/registration/createOrder}，API：{@code publichospital_registration_create_order}，版本：{@code 10016}，businessId：{@code 59}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> publichospitalRegistrationCreateOrder(PublichospitalRegistrationCreateOrderRequest request, String tenantId);

    /**
     * 排班变更通知。
     * <p>官方接口：{@code /ddzhkh/publichospital/schedule/changes}，API：{@code publichospital_sync_schedule_change}，版本：{@code 10014}，businessId：{@code 59}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> publichospitalSyncScheduleChange(PublichospitalSyncScheduleChangeRequest request, String tenantId);

    /**
     * 批量推送团购关联包型包间。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/relate/rooms}，API：{@code dealgroup_batch_relate_rooms}，版本：{@code 10174}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dealgroupBatchRelateRooms(DealgroupBatchRelateRoomsRequest request, String tenantId);

    /**
     * 图片上传。
     * <p>官方接口：{@code /ddzhkh/shangpin/image/upload}，API：{@code image_upload}，版本：{@code 10102}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageUpload(ImageUploadRequest request, String tenantId);

    /**
     * 查正式团单。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/normal/query}，API：{@code normal_dealgroup_query}，版本：{@code 10178}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> normalDealgroupQuery(NormalDealgroupQueryRequest request, String tenantId);

    /**
     * 上线商品。
     * <p>官方接口：{@code /ddzhkh/shangpin/current/online}，API：{@code product_current_online}，版本：{@code 10198}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productCurrentOnline(ProductCurrentOnlineRequest request, String tenantId);

    /**
     * 提交商品。
     * <p>官方接口：{@code /ddzhkh/shangpin/current/submit}，API：{@code product_current_submit}，版本：{@code 10198}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productCurrentSubmit(ProductCurrentSubmitRequest request, String tenantId);

    /**
     * 创建团单。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/create}，API：{@code product_dealgroup_create}，版本：{@code 10192}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupCreate(ProductDealgroupCreateRequest request, String tenantId);

    /**
     * 撤回审核。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/drawback}，API：{@code product_dealgroup_drawback}，版本：{@code 10194}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupDrawback(ProductDealgroupDrawbackRequest request, String tenantId);

    /**
     * 下架团单。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/offline}，API：{@code product_dealgroup_offline}，版本：{@code 10194}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupOffline(ProductDealgroupOfflineRequest request, String tenantId);

    /**
     * 上架团单。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/online}，API：{@code product_dealgroup_online}，版本：{@code 10194}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupOnline(ProductDealgroupOnlineRequest request, String tenantId);

    /**
     * 查询团单。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/query}，API：{@code product_dealgroup_query}，版本：{@code 10190}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupQuery(ProductDealgroupQueryRequest request, String tenantId);

    /**
     * 提交团单。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/submit}，API：{@code product_dealgroup_submit}，版本：{@code 10192}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupSubmit(ProductDealgroupSubmitRequest request, String tenantId);

    /**
     * 修改团单适用门店。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/updateshopids}，API：{@code product_dealgroup_update_shopids}，版本：{@code 10194}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupUpdateShopids(ProductDealgroupUpdateShopidsRequest request, String tenantId);

    /**
     * 修改团单价格。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/updateprice}，API：{@code product_dealgroup_updateprice}，版本：{@code 10194}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupUpdateprice(ProductDealgroupUpdatepriceRequest request, String tenantId);

    /**
     * 修改团单库存。
     * <p>官方接口：{@code /ddzhkh/shangpin/dealgroup/updatestock}，API：{@code product_dealgroup_updatestock}，版本：{@code 10194}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productDealgroupUpdatestock(ProductDealgroupUpdatestockRequest request, String tenantId);

    /**
     * 新增搭配项目互斥关系。
     * <p>官方接口：{@code /ddzhkh/shangpin/edit/mutex}，API：{@code product_edit_mutex}，版本：{@code 10118}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productEditMutex(ProductEditMutexRequest request, String tenantId);

    /**
     * 新增商品。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/create}，API：{@code product_product_create}，版本：{@code 10136}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductCreate(ProductProductCreateRequest request, String tenantId);

    /**
     * 查询商品信息。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/loadproduct}，API：{@code product_product_loadproduct}，版本：{@code 10177}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductLoadproduct(ProductProductLoadproductRequest request, String tenantId);

    /**
     * 查询商品库存信息。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/loadproductstock}，API：{@code product_product_loadproductstock}，版本：{@code 10117}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductLoadproductstock(ProductProductLoadproductstockRequest request, String tenantId);

    /**
     * 商品下架。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/offline}，API：{@code product_product_offline}，版本：{@code 10124}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductOffline(ProductProductOfflineRequest request, String tenantId);

    /**
     * 商品恢复上架接口。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/online}，API：{@code product_product_online}，版本：{@code 10005}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductOnline(ProductProductOnlineRequest request, String tenantId);

    /**
     * 提交商品。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/submit}，API：{@code product_product_submit}，版本：{@code 10123}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductSubmit(ProductProductSubmitRequest request, String tenantId);

    /**
     * 更新商品。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/update}，API：{@code product_product_update}，版本：{@code 10133}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductUpdate(ProductProductUpdateRequest request, String tenantId);

    /**
     * 更新商品库存。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/updateproductstock}，API：{@code product_product_update_product_stock}，版本：{@code 10122}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productProductUpdateProductStock(ProductProductUpdateProductStockRequest request, String tenantId);

    /**
     * 保存(新建/编辑) 关联关系。
     * <p>官方接口：{@code /ddzhkh/shangpin/relationship/save}，API：{@code product_relationship_save}，版本：{@code 10111}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productRelationshipSave(ProductRelationshipSaveRequest request, String tenantId);

    /**
     * （体检加项）开启/关闭/删除 关联关系。
     * <p>官方接口：{@code /ddzhkh/shangpin/relationship/status/update}，API：{@code product_relationship_status_update}，版本：{@code 10116}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productRelationshipStatusUpdate(ProductRelationshipStatusUpdateRequest request, String tenantId);

    /**
     * 加载单个资源详情。
     * <p>官方接口：{@code /ddzhkh/shangpin/resource/loadresource}，API：{@code product_resource_loadresource}，版本：{@code 10115}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productResourceLoadresource(ProductResourceLoadresourceRequest request, String tenantId);

    /**
     * 创建/编辑提交套餐。
     * <p>官方接口：{@code /ddzhkh/shangpin/resource/submit}，API：{@code product_resource_submit}，版本：{@code 10114}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productResourceSubmit(ProductResourceSubmitRequest request, String tenantId);

    /**
     * 上线、下线、删除套餐。
     * <p>官方接口：{@code /ddzhkh/shangpin/resource/updatestatus}，API：{@code product_resource_updatestatus}，版本：{@code 10113}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productResourceUpdatestatus(ProductResourceUpdatestatusRequest request, String tenantId);

    /**
     * 商品优化推荐。
     * <p>官方接口：{@code /ddzhkh/shangpin/product/search/supply/diagnostics}，API：{@code product_search_supply_diagnostics}，版本：{@code 10103}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productSearchSupplyDiagnostics(ProductSearchSupplyDiagnosticsRequest request, String tenantId);

    /**
     * 店铺商品查询。
     * <p>官方接口：{@code /ddzhkh/shangpin/shopProducts/get}，API：{@code product_shopproducts_get}，版本：{@code 10125}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productShopproductsGet(ProductShopproductsGetRequest request, String tenantId);

    /**
     * 将商品状态修改为下线。
     * <p>官方接口：{@code /ddzhkh/shangpin/united/offline/product}，API：{@code product_united_offline_product}，版本：{@code 10172}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUnitedOfflineProduct(ProductUnitedOfflineProductRequest request, String tenantId);

    /**
     * 查询通用商品。
     * <p>官方接口：{@code /ddzhkh/shangpin/united/query/product}，API：{@code product_united_query_product}，版本：{@code 10197}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUnitedQueryProduct(ProductUnitedQueryProductRequest request, String tenantId);

    /**
     * 撤回商品当前流程。
     * <p>官方接口：{@code /ddzhkh/shangpin/united/revoke/product}，API：{@code product_united_revoke_product}，版本：{@code 10108}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUnitedRevokeProduct(ProductUnitedRevokeProductRequest request, String tenantId);

    /**
     * 商品快速改价（通用）。
     * <p>官方接口：{@code /ddzhkh/shangpin/united/update/prices}，API：{@code product_united_update_prices}，版本：{@code 10105}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUnitedUpdatePrices(ProductUnitedUpdatePricesRequest request, String tenantId);

    /**
     * 商品快速改门店（通用）。
     * <p>官方接口：{@code /ddzhkh/shangpin/united/update/shops}，API：{@code product_united_update_shop}，版本：{@code 10107}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUnitedUpdateShop(ProductUnitedUpdateShopRequest request, String tenantId);

    /**
     * 商品快速改库存（通用）。
     * <p>官方接口：{@code /ddzhkh/shangpin/united/update/stocks}，API：{@code product_united_update_stock}，版本：{@code 10186}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productUnitedUpdateStock(ProductUnitedUpdateStockRequest request, String tenantId);

    /**
     * 查询演出项目。
     * <p>官方接口：{@code /ddzhkh/shangpin/showevent/query}，API：{@code showevent_query}，版本：{@code 10180}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> showeventQuery(ShoweventQueryRequest request, String tenantId);

    /**
     * 演出项目快速改库存。
     * <p>官方接口：{@code /ddzhkh/shangpin/showevent/quick/update/stock}，API：{@code showevent_quick_update_stock}，版本：{@code 10187}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> showeventQuickUpdateStock(ShoweventQuickUpdateStockRequest request, String tenantId);

    /**
     * 提交演出项目（异步）。
     * <p>官方接口：{@code /ddzhkh/shangpin/showevent/submit}，API：{@code showevent_submit}，版本：{@code 10185}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> showeventSubmit(ShoweventSubmitRequest request, String tenantId);

    /**
     * 修改演出项目状态。
     * <p>官方接口：{@code /ddzhkh/shangpin/showevent/updatestatus}，API：{@code showevent_update_status}，版本：{@code 10182}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> showeventUpdateStatus(ShoweventUpdateStatusRequest request, String tenantId);

    /**
     * 租赁品下单接口。
     * <p>官方接口：{@code /ddzhkh/xcx3csmzl/create_order}，API：{@code create_order}，版本：{@code 10026}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateOrder(CreateOrderRequest request, String tenantId);

    /**
     * 创建关联订单。
     * <p>官方接口：{@code /ddzhkh/xcx3csmzl/create_relation_order}，API：{@code create_relation_order}，版本：{@code 10025}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateRelationOrder(CreateRelationOrderRequest request, String tenantId);

    /**
     * 分期支付。
     * <p>官方接口：{@code /ddzhkh/xcx3csmzl/installment_pay}，API：{@code installment_pay}，版本：{@code 10023}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhInstallmentPay(InstallmentPayRequest request, String tenantId);

    /**
     * 查询支付token。
     * <p>官方接口：{@code /ddzhkh/xcx3csmzl/query_pay_token}，API：{@code query_pay_token}，版本：{@code 10019}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhQueryPayToken(QueryPayTokenRequest request, String tenantId);

    /**
     * 申请退款接口。
     * <p>官方接口：{@code /ddzhkh/xcx3csmzl/refund_order}，API：{@code refund_order}，版本：{@code 10022}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhRefundOrder(RefundOrderRequest request, String tenantId);

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcx3csmzl/sync_status}，API：{@code sync_order}，版本：{@code 10021}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhSyncOrder(SyncOrderRequest request, String tenantId);

    /**
     * 下单并支付。
     * <p>官方接口：{@code /ddzhkh/xcxcw/create_order}，API：{@code create_order}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxcw.createOrder.CreateOrderRequest request, String tenantId);

    /**
     * 查询支付token。
     * <p>官方接口：{@code /ddzhkh/xcxcw/query_pay_token}，API：{@code query_pay_token}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhQueryPayToken(com.meituan.sdk.model.ddzhkh.xcxcw.queryPayToken.QueryPayTokenRequest request, String tenantId);

    /**
     * 申请退款接口。
     * <p>官方接口：{@code /ddzhkh/xcxcw/refund_order}，API：{@code refund_order}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxcw.refundOrder.RefundOrderRequest request, String tenantId);

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcxcw/sync_status}，API：{@code sync_order}，版本：{@code 10001}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxcw.syncOrder.SyncOrderRequest request, String tenantId);

    /**
     * 黄金回收同步价格。
     * <p>官方接口：{@code /ddzhkh/xcxhjhs/sync_ari}，API：{@code sync_ari}，版本：{@code 10001}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhSyncAri(SyncAriRequest request, String tenantId);

    /**
     * 回收-获取询价单数据接口。
     * <p>官方接口：{@code /ddzhkh/xcxjwhs/query/inquiryOrder/inf}，API：{@code query_inquiry_order}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryInquiryOrder(QueryInquiryOrderRequest request, String tenantId);

    /**
     * 旧物回收同步价格。
     * <p>官方接口：{@code /ddzhkh/xcxjwhs/sync_ari}，API：{@code sync_ari}，版本：{@code 10001}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhSyncAri(com.meituan.sdk.model.ddzhkh.xcxjwhs.syncAri.SyncAriRequest request, String tenantId);

    /**
     * 下单并支付。
     * <p>官方接口：{@code /ddzhkh/xcxmj/create_order}，API：{@code create_order}，版本：{@code 10001}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxmj.createOrder.CreateOrderRequest request, String tenantId);

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcxmj/sync_status}，API：{@code sync_status}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> syncStatus(SyncStatusRequest request, String tenantId);

    /**
     * 下单不支付。
     * <p>官方接口：{@code /ddzhkh/xcxpw/create_order}，API：{@code create_order}，版本：{@code 10020}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxpw.createOrder.CreateOrderRequest request, String tenantId);

    /**
     * 预支付。
     * <p>官方接口：{@code /ddzhkh/xcxpw/pre_pay}，API：{@code pre_pay}，版本：{@code 10019}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> prePay(PrePayRequest request, String tenantId);

    /**
     * 订单查询。
     * <p>官方接口：{@code /ddzhkh/xcxpw/query_order}，API：{@code query_order}，版本：{@code 10024}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhQueryOrder(com.meituan.sdk.model.ddzhkh.xcxpw.queryOrder.QueryOrderRequest request, String tenantId);

    /**
     * 支付结果查询。
     * <p>官方接口：{@code /ddzhkh/xcxpw/query_pay_info}，API：{@code query_pay_info}，版本：{@code 10023}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryPayInfo(QueryPayInfoRequest request, String tenantId);

    /**
     * 查询支付token。
     * <p>官方接口：{@code /ddzhkh/xcxpw/query_pay_token}，API：{@code query_pay_token}，版本：{@code 10018}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhQueryPayToken(com.meituan.sdk.model.ddzhkh.xcxpw.queryPayToken.QueryPayTokenRequest request, String tenantId);

    /**
     * 查询退款结果。
     * <p>官方接口：{@code /ddzhkh/xcxpw/query_refund_info}，API：{@code query_refund_info}，版本：{@code 10025}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryRefundInfo(QueryRefundInfoRequest request, String tenantId);

    /**
     * 退款申请。
     * <p>官方接口：{@code /ddzhkh/xcxpw/refund_order}，API：{@code refund_order}，版本：{@code 10022}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxpw.refundOrder.RefundOrderRequest request, String tenantId);

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcxpw/sync_order}，API：{@code sync_order}，版本：{@code 10026}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxpw.syncOrder.SyncOrderRequest request, String tenantId);

    /**
     * 下单并支付。
     * <p>官方接口：{@code /ddzhkh/xcxwy/create_order}，API：{@code create_order}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxwy.createOrder.CreateOrderRequest request, String tenantId);

    /**
     * 申请退款接口。
     * <p>官方接口：{@code /ddzhkh/xcxwy/refund_order}，API：{@code refund_order}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxwy.refundOrder.RefundOrderRequest request, String tenantId);

    /**
     * 推送送审文件接口。
     * <p>官方接口：{@code /ddzhkh/xcxwy/submit/file/transfer}，API：{@code submit_file_transfer}，版本：{@code 10006}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> submitFileTransfer(SubmitFileTransferRequest request, String tenantId);

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcxwy/sync_status}，API：{@code sync_order}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxwy.syncOrder.SyncOrderRequest request, String tenantId);

    /**
     * 租赁品下单接口。
     * <p>官方接口：{@code /ddzhkh/xcxzc/create_order}，API：{@code create_order}，版本：{@code 10005}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateOrder(com.meituan.sdk.model.ddzhkh.xcxzc.createOrder.CreateOrderRequest request, String tenantId);

    /**
     * 创建关联订单。
     * <p>官方接口：{@code /ddzhkh/xcxzc/create_relation_order}，API：{@code create_relation_order}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhCreateRelationOrder(com.meituan.sdk.model.ddzhkh.xcxzc.createRelationOrder.CreateRelationOrderRequest request, String tenantId);

    /**
     * 分期支付。
     * <p>官方接口：{@code /ddzhkh/xcxzc/installment_pay}，API：{@code installment_pay}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhInstallmentPay(com.meituan.sdk.model.ddzhkh.xcxzc.installmentPay.InstallmentPayRequest request, String tenantId);

    /**
     * 查询支付token。
     * <p>官方接口：{@code /ddzhkh/xcxzc/query_pay_token}，API：{@code query_pay_token}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhQueryPayToken(com.meituan.sdk.model.ddzhkh.xcxzc.queryPayToken.QueryPayTokenRequest request, String tenantId);

    /**
     * 申请退款接口。
     * <p>官方接口：{@code /ddzhkh/xcxzc/refund_order}，API：{@code refund_order}，版本：{@code 10001}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhRefundOrder(com.meituan.sdk.model.ddzhkh.xcxzc.refundOrder.RefundOrderRequest request, String tenantId);

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcxzc/sync_order}，API：{@code sync_order}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhSyncOrder(com.meituan.sdk.model.ddzhkh.xcxzc.syncOrder.SyncOrderRequest request, String tenantId);
    /**
     * 充电订单费用信息同步。
     * <p>官方接口：{@code /ddzh/chargefulfill/orderfee/sync}，API：{@code charge_order_fee_sync}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> chargeOrderFeeSync(ChargeOrderFeeSyncRequest request, String tenantId);

    /**
     * 充电订单履约。
     * <p>官方接口：{@code /ddzh/chargefulfill/order/fulfill}，API：{@code charge_order_fulfill}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> chargeOrderFulfill(ChargeOrderFulfillRequest request, String tenantId);

    /**
     * 充电订单信息同步。
     * <p>官方接口：{@code /ddzh/chargefulfill/orderinfo/sync}，API：{@code charge_order_info_sync}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> chargeOrderInfoSync(ChargeOrderInfoSyncRequest request, String tenantId);

    /**
     * 充电占位费订单退款。
     * <p>官方接口：{@code /ddzh/chargefulfill/reservefee/refund}，API：{@code charge_reserve_order_refund}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> chargeReserveOrderRefund(ChargeReserveOrderRefundRequest request, String tenantId);

    /**
     * 充电占位费订单同步。
     * <p>官方接口：{@code /ddzh/chargefulfill/reservefee/sync}，API：{@code reserve_order_fee_sync}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> reserveOrderFeeSync(ReserveOrderFeeSyncRequest request, String tenantId);

    /**
     * 启动充电设备结果回调。
     * <p>官方接口：{@code /ddzh/chargefulfill/startresult/callback}，API：{@code start_device_result_call_back}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> startDeviceResultCallBack(StartDeviceResultCallBackRequest request, String tenantId);

    /**
     * 停止充电设备结果回调。
     * <p>官方接口：{@code /ddzh/chargefulfill/stopresult/callback}，API：{@code stop_device_result_call_back}，版本：{@code 10000}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> stopDeviceResultCallBack(StopDeviceResultCallBackRequest request, String tenantId);

    /**
     * 文印订单信息及状态同步。
     * <p>官方接口：{@code /ddzh/print/orderinfo/sync}，API：{@code print_order_info_sync}，版本：{@code 10003}，businessId：{@code 58}，需要授权：{@code false}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> printOrderInfoSync(PrintOrderInfoSyncRequest request, String tenantId);

    /**
     * 文印订单接单结果同步。
     * <p>官方接口：{@code /ddzh/print/orderresult/sync}，API：{@code print_order_result_sync}，版本：{@code 10002}，businessId：{@code 58}，需要授权：{@code false}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> printOrderResultSync(PrintOrderResultSyncRequest request, String tenantId);

    /**
     * 三方手艺人信息同步。
     * <p>官方接口：{@code /ddzh/yuding/resource/third-technician/sync}，API：{@code third_technician_sync}，版本：{@code 10084}，businessId：{@code 58}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> thirdTechnicianSync(ThirdTechnicianSyncRequest request, String tenantId);

    /**
     * 演出项目批量快速改库存。
     * <p>官方接口：{@code /ddzhkh/shangpin/showevent/batch/quick/update/stock}，API：{@code showevent_batch_quick_update_stock}，版本：{@code 10211}，businessId：{@code 59}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> showeventBatchQuickUpdateStock(ShoweventBatchQuickUpdateStockRequest request, String tenantId);

    /**
     * 追加支付。
     * <p>官方接口：{@code /ddzhkh/xcxbj/append_pay}，API：{@code append_pay}，版本：{@code 10000}，businessId：{@code 59}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> appendPay(AppendPayRequest request, String tenantId);

    /**
     * 下单不支付。
     * <p>官方接口：{@code /ddzhkh/xcxbj/create_order}，API：{@code create_order}，版本：{@code 10002}，businessId：{@code 59}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> createOrder(com.meituan.sdk.model.ddzhkh.xcxbj.createOrder.CreateOrderRequest request, String tenantId);

    /**
     * 申请退款接口。
     * <p>官方接口：{@code /ddzhkh/xcxbj/refund_order}，API：{@code refund_order}，版本：{@code 10003}，businessId：{@code 59}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> refundOrder(com.meituan.sdk.model.ddzhkh.xcxbj.refundOrder.RefundOrderRequest request, String tenantId);

    /**
     * 订单同步。
     * <p>官方接口：{@code /ddzhkh/xcxbj/sync_status}，API：{@code sync_order}，版本：{@code 10004}，businessId：{@code 59}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> syncOrder(com.meituan.sdk.model.ddzhkh.xcxbj.syncOrder.SyncOrderRequest request, String tenantId);

    /**
     * 订单查询。
     * <p>官方接口：{@code /ddzhkh/xcxzc/query_order}，API：{@code query_order}，版本：{@code 10006}，businessId：{@code 59}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryOrder(com.meituan.sdk.model.ddzhkh.xcxzc.queryOrder.QueryOrderRequest request, String tenantId);

    /**
     * 查询退款结果。
     * <p>官方接口：{@code /ddzhkh/xcxzc/query_refund_info}，API：{@code query_refund_info}，版本：{@code 10007}，businessId：{@code 59}，需要授权：{@code true}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> ddzhkhQueryRefundInfo(com.meituan.sdk.model.ddzhkh.xcxzc.queryRefundInfo.QueryRefundInfoRequest request, String tenantId);

}
