function silkSPUSKUData(data) {
	var silkSPUSKUData = data.silkSPUSKUData;
	var silkSPUSKUDataAPP = data.silkSPUSKUDataAPP;
	var silkSPUSKUDataMicroMall = data.silkSPUSKUDataMicroMall;
	var silkSPUSKUDataMicro = data.silkSPUSKUDataMicro;
	var silkSPUSKUDataM = data.silkSPUSKUDataM;
	$("#saleSpuTotal").text(silkSPUSKUData.PRODUCTID);
	$("#saleSkuTotal").text(silkSPUSKUData.PRODUCTDETAILID);
	$("#saleSpuAppTotal").text(silkSPUSKUDataAPP.PRODUCTID);
	$("#saleSkuAppTotal").text(silkSPUSKUDataAPP.PRODUCTDETAILID);
	$("#saleSpuWebChatTotal").text(silkSPUSKUDataMicroMall.PRODUCTID);
	$("#saleSkuWebChatTotal").text(silkSPUSKUDataMicroMall.PRODUCTDETAILID);
	$("#saleSpuMicroTotal").text(silkSPUSKUDataMicro.PRODUCTID);
	$("#saleSkuMicroTotal").text(silkSPUSKUDataMicro.PRODUCTDETAILID);
	$("#saleSpuMTotal").text(silkSPUSKUDataM.PRODUCTID);
	$("#saleSkuMTotal").text(silkSPUSKUDataM.PRODUCTDETAILID);
}

function silkOrderData(data){
	var silkOrderData = data.silkOrderData;
	var silkOrderDataAPP = data.silkOrderDataAPP;
	var silkOrderDataMicroMall = data.silkOrderDataMicroMall;
	var silkOrderDataMicro = data.silkOrderDataMicro;
	var siklOrderDataM = data.siklOrderDataM;
	$("#saleMainOrderTotal").text(silkOrderData.ORDERNOMAIN);
	$("#saleSubOrderTotal").text(silkOrderData.ORDERNO);
	$("#enjoyUserCount").text(silkOrderData.USERID);
	$("#saleMainOrderAppTotal").text(silkOrderDataAPP.ORDERNOMAIN);
	$("#saleSubOrderAppTotal").text(silkOrderDataAPP.ORDERNO);
	$("#enjoyUserAppCount").text(silkOrderDataAPP.USERID);
	$("#saleMainOrderWebChatTotal").text(silkOrderDataMicroMall.ORDERNOMAIN);
	$("#saleSubOrderWebChatTotal").text(silkOrderDataMicroMall.ORDERNO);
	$("#enjoyUserMicroMallCount").text(silkOrderDataMicroMall.USERID);
	$("#saleMainOrderMicroTotal").text(silkOrderDataMicro.ORDERNOMAIN);
	$("#saleSubOrderMicroTotal").text(silkOrderDataMicro.ORDERNO);
	$("#enjoyUserMicroCount").text(silkOrderDataMicro.USERID);
	$("#saleMainOrderMTotal").text(siklOrderDataM.ORDERNOMAIN);
	$("#saleSubOrderMTotal").text(siklOrderDataM.ORDERNO);
	$("#enjoyUserMCount").text(siklOrderDataM.USERID);
}

function silkPayData(data){
	var silkPayData = data.silkPayData;
	var silkPayDataAPP = data.silkPayDataAPP;
	var silkPayDataMicroMall = data.silkPayDataMicroMall;
	var silkPayDataMicro = data.silkPayDataMicro;
	var silkPayDataM = data.silkPayDataM;
	$("#saleCashTotalSub").text(silkPayData.PAYCASH);
	$("#actualPayPointTotal").text(silkPayData.PAYPOINTS);
	$("#specialCashTotal").text(silkPayData.SPECIALPOINTS);
	$("#saleProductTotal").text(silkPayData.BUYNUM);
	$("#saleCashTotalAppSub").text(silkPayDataAPP.PAYCASH);
	$("#actualPayPointAppTotal").text(silkPayDataAPP.PAYPOINTS);
	$("#specialCashAppTotal").text(silkPayDataAPP.SPECIALPOINTS);
	$("#saleProductAppTotal").text(silkPayDataAPP.BUYNUM);
	$("#saleCashTotalWebChatSub").text(silkPayDataMicroMall.PAYCASH);
	$("#actualPayPointWebChatTotal").text(silkPayDataMicroMall.PAYPOINTS);
	$("#specialCashWebChatTotal").text(silkPayDataMicroMall.SPECIALPOINTS);
	$("#saleProductWebChatTotal").text(silkPayDataMicroMall.BUYNUM);
	$("#saleCashTotalMicroSub").text(silkPayDataMicro.PAYCASH);
	$("#actualPayPointMicroTotal").text(silkPayDataMicro.PAYPOINTS);
	$("#specialCashMicroTotal").text(silkPayDataMicro.SPECIALPOINTS);
	$("#saleProductMicroTotal").text(silkPayDataMicro.BUYNUM);
	
	$("#saleCashTotalMSub").text(silkPayDataM.PAYCASH);
	$("#actualPayPointMTotal").text(silkPayDataM.PAYPOINTS);
	$("#specialCashMTotal").text(silkPayDataM.SPECIALPOINTS);
	$("#saleProductMTotal").text(silkPayDataM.BUYNUM);
}

function silkRepeData(data){
	var silkRepeData = data.silkRepeData;
	var silkRepeDataAPP = data.silkRepeDataAPP;
	var silkRepeDataMicroMall = data.silkRepeDataMicroMall;
	var silkRepeDataMicro = data.silkRepeDataMicro;
	var silkRepeDataM = data.silkRepeDataM;
	$("#repeatUserCount").text(silkRepeData.USERNUM);
	$("#repeatUserAppCount").text(silkRepeDataAPP.USERNUM);
	$("#repeatUserMicroMallCount").text(silkRepeDataMicroMall.USERNUM);
	$("#repeatUserMicroCount").text(silkRepeDataMicro.USERNUM);
	$("#repeatUserMCount").text(silkRepeDataM.USERNUM);
}