getHKMacaoData(startTime,endTime)

function showInfo(obj){
	var content="";
	if(obj.id=="travelSales"){
		content="活动期间，满99、199、299的销售额（订单总额）";
	}else if(obj.id=="travelSaleSPUCount"){
		content="活动销售SPU种类总数 = 活动期间，活动商品销售的SPU种类总数";
	}else if(obj.id=="travelSaleSKUCount"){
		content="活动销售SKU种类总数 = 活动期间，活动商品销售的SKU种类总数";
	}else if(obj.id=="travelProductCount"){
		content="活动期间，满99、199、299的销售子商品总销量";
	}else if(obj.id=="travelSalesCash"){
		content="活动期间，满99、199、299且使用购卡权限的销售额（订单总额）";
	}else if(obj.id=="travelSaleSPUCash"){
		content="活动期间，满99、199、299且使用购卡权限的销售SPU种类总数";
	}else if(obj.id=="travelSaleSKUCash"){
		content="活动期间，满99、199、299且使用购卡权限的销售SKU种类总数";
	}else if(obj.id=="travelSaleCash"){
		content="活动期间，满99、199、299且使用购卡权限的的销售子商品总销量";
	}else if(obj.id=="travelOrderMainCount"){
		content="活动期间，满99、199、299的活动主订单总数";
	}else if(obj.id=="travelOrderCount"){
		content="活动期间，满99、199、299的活动子订单总数";
	}else if(obj.id=="travelOrderMainCash"){
		content="活动期间，满99、199、299且使用购卡权限主订单总数";
	}else if(obj.id=="travelOrderCash"){
		content="活动期间，满99、199、299且使用购卡权限子订单总数";
	}else if(obj.id=="travelCashCount"){
		content="活动期间，活动期间，满99、199、299现金支付总额";
	}else if(obj.id=="travelCash"){
		content="活动期间，满99、199、299且使用购卡权限现金支付总额";
	}else if(obj.id=="travelPointCount"){
		content="活动期间，满99、199、299实际支付总积分";
	}else if(obj.id=="travelPoint"){
		content="活动期间，满99、199、299且使用购卡权限的实际支付总积分";
	}else if(obj.id=="travelGiftPointCount"){
		content="活动期间，满99、199、299福利券实际支付总积分";
	}else if(obj.id=="travelPrice"){
		content="客单价=销售额/活动订单总数";
	}else if(obj.id=="travelPriceCash"){
		content="现金满额客单价=现金满额销售/现金满额订单总数";
	}else if(obj.id=="travelUserCounts"){
		content="活动期间，参加99、199、299满额活动的总人数";
	}else if(obj.id=="travelRepeUserCounts"){
		content="参与活动两次以上的人，去重数据";
	}else if(obj.id=="travelNewUserCounts"){
		content="活动期间新增的会员人数";
	}else if(obj.id=="travelGiftPoint"){
		content="活动期间，满99、199、299且使用购卡权限的实际支付总积分";
	}
	$("#mydiv").html(content);
	return content;
	
}
$("#btnQuery").click(function() {
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	getHKMacaoData($("#startTime").val(),$("#endTime").val());
})

$("#btnQueryAll").click(function(){
	$("#startTime").val($("#start").val().substr(0,19));
	$("#endTime").val($("#end").val().substr(0,19));
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	getHKMacaoData(startTime,endTime);
});

$("#export").click(function(){
	var activityName = $("#activityName").text();
	location.href = "marketing/exportExcel?startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&activityId="+"&sign=HkMacao"+"&activityName="+encodeURI(encodeURI(activityName));
});

function getHKMacaoData(startTime,endTime){
	$.ajax({
		type:"post",
		url:"marketing/getHKMacaoData",
		data:{"startTime":startTime,"endTime":endTime},
		dataType:"json",
		success:function(data){			
			loadCountData(data);
		},
		error:function(){alert("网络开小差,请刷新重试!");}
	});
}

function loadCountData(data){	
	$("#saleTotal").html(data['saleTotal']);
	$("#saleAppTotal").html(data['saleAppTotal']);
	$("#saleWebChatTotal").html(data['saleWebChatTotal']);
	$("#saleMicroTotal").html(data['saleMicroTotal']);
	
	$("#saleSpuTotal").html(data['saleSpuTotal']);
	$("#saleSpuAppTotal").html(data['saleSpuAppTotal']);
	$("#saleSpuWebChatTotal").html(data['saleSpuWebChatTotal']);
	$("#saleSpuMicroTotal").html(data['saleSpuMicroTotal']);
	
	$("#saleSkuTotal").html(data['saleSkuTotal']);
	$("#saleSkuAppTotal").html(data['saleSkuAppTotal']);
	$("#saleSkuWebChatTotal").html(data['saleSkuWebChatTotal']);
	$("#saleSkuMicroTotal").html(data['saleSkuMicroTotal']);
	
	$("#productTotal").html(data['productTotal']);
	$("#productAppTotal").html(data['productAppTotal']);
	$("#productWebChatTotal").html(data['productWebChatTotal']);
	$("#productMicroTotal").html(data['productMicroTotal']);
	
	//现金满额销售额
	$("#saleCashTotal").html(data['saleCashTotal']);
	$("#saleCashAppTotal").html(data['saleCashAppTotal']);
	$("#saleCashWebChatTotal").html(data['saleCashWebChatTotal']);
	$("#saleCashMicroTotal").html(data['saleCashMicroTotal']);
	
	//现金满额销售SPU
	$("#saleSpuCashTotal").html(data['saleSpuCashTotal']);
	$("#saleSpuCashAppTotal").html(data['saleSpuCashAppTotal']);
	$("#saleSpuCashWebChatTotal").html(data['saleSpuCashWebChatTotal']);
	$("#saleSpuCashMicroTotal").html(data['saleSpuCashMicroTotal']);
	
	//现金满额销售SKU
	$("#saleSkuCashTotal").html(data['saleSkuCashTotal']);
	$("#saleSkuCashAppTotal").html(data['saleSkuCashAppTotal']);
	$("#saleSkuCashWebChatTotal").html(data['saleSkuCashWebChatTotal']);
	$("#saleSkuCashMicroTotal").html(data['saleSkuCashMicroTotal']);
	
	//现金满额总销量
	$("#saleCashTotalSub").html(data['saleCashTotalSub']);
	$("#saleCashTotalAppSub").html(data['saleCashTotalAppSub']);
	$("#saleCashTotalWebChatSub").html(data['saleCashTotalWebChatSub']);
	$("#saleCashTotalMicroSub").html(data['saleCashTotalMicroSub']);
	
	//活动订单总数
	$("#orderMainTotal").html(data['orderMainTotal']);
	$("#orderMainAppTotal").html(data['orderMainAppTotal']);
	$("#orderMainWebChatTotal").html(data['orderMainWebChatTotal']);
	$("#orderMainMicroTotal").html(data['orderMainMicroTotal']);
	
	//活动子订单总数
	$("#orderSubTotal").html(data['orderSubTotal']);
	$("#orderSubAppTotal").html(data['orderSubAppTotal']);
	$("#orderSubWebChatTotal").html(data['orderSubWebChatTotal']);
	$("#orderSubMicroTotal").html(data['orderSubMicroTotal']);
	
	//现金满额订单总数
	$("#orderMainCashTotal").html(data['orderMainCashTotal']);
	$("#orderMainCashAppTotal").html(data['orderMainCashAppTotal']);
	$("#orderMainCashWebChatTotal").html(data['orderMainCashWebChatTotal']);
	$("#orderMainCashMicroTotal").html(data['orderMainCashMicroTotal']);
	
	//现金满额子订单总数
	$("#orderSubCashTotal").html(data['orderSubCashTotal']);
	$("#orderSubCashAppTotal").html(data['orderSubCashAppTotal']);
	$("#orderSubCashWebChatTotal").html(data['orderSubCashWebChatTotal']);
	$("#orderSubCashMircoTotal").html(data['orderSubCashMircoTotal']);
	
	//现金支付总金额
	$("#payTotal").html(data['payTotal']);
	$("#payTotalApp").html(data['payTotalApp']);
	$("#payTotalWebChat").html(data['payTotalWebChat']);
	$("#payTotalMicro").html(data['payTotalMicro']);
	
	//现金满额现金支付总金额
	$("#buyCardPayTotal").html(data['buyCardPayTotal']);
	$("#buyCardPayTotalApp").html(data['buyCardPayTotalApp']);
	$("#buyCardPayTotalWebChat").html(data['buyCardPayTotalWebChat']);
	$("#buyCardPayTotalMicro").html(data['buyCardPayTotalMicro']);
	
	//实际支付总积分
	$("#actualPayTotalPoint").html(data['actualPayTotalPoint']);
	$("#actualPayTotalPointApp").html(data['actualPayTotalPointApp']);
	$("#actualPayTotalPointWebChat").html(data['actualPayTotalPointWebChat']);
	$("#actualPayTotalPointMicro").html(data['actualPayTotalPointMicro']);
	
	//福利券支付总积分
	$("#specialPointTotal").html(data['specialPointTotal']);
	$("#specialPointAppTotal").html(data['specialPointAppTotal']);
	$("#specialPointWebChatTotal").html(data['specialPointWebChatTotal']);
	$("#specialPointMicroTotal").html(data['specialPointMicroTotal']);
	
	//现金满额实际支付总积分
	$("#buyCardPayTotalPoint").html(data['buyCardPayTotalPoint']);
	$("#buyCardPayTotalPointApp").html(data['buyCardPayTotalPointApp']);
	$("#buyCardPayTotalPointWebChat").html(data['buyCardPayTotalPointWebChat']);
	$("#buyCardPayTotalPointMicro").html(data['buyCardPayTotalPointMicro']);
	
	//现金满额褔利券支付总积分
	$("#buyCardSpecialTotal").html(data['buyCardSpecialTotal']);
	$("#buyCardSpecialAppTotal").html(data['buyCardSpecialAppTotal']);
	$("#buyCardSpecialWebChatTotal").html(data['buyCardSpecialWebChatTotal']);
	$("#buyCardSpecialMicroTotal").html(data['buyCardSpecialMicroTotal']);
	
	//计算客单价
	$("#custSingleTotal").html(data['custSingleTotal']);
	$("#custSingleAppTotal").html(data['custSingleAppTotal']);
	$("#custSingleWebChatTotal").html(data['custSingleWebChatTotal']);
	$("#custSingleMicroTotal").html(data['custSingleMicroTotal']);
	
	//现金满额客单价
	$("#cashSingle").html(data['cashSingle']);
	$("#cashSingleApp").html(data['cashSingleApp']);
	$("#cashSingleWebChat").html(data['cashSingleWebChat']);
	$("#cashSingleMicro").html(data['cashSingleMicro']);
	
	//活动参与总人数
	$("#travelUserCount").html(data['travelUserCount']);
	$("#travelUserCountAPP").html(data['travelUserCountAPP']);
	$("#travelUserCountMicroMall").html(data['travelUserCountMicroMall']);
	$("#travelUserCountMicro").html(data['travelUserCountMicro']);
	
	//重复参与人数
	$("#travelRepeUserCount").html(data['travelRepeUserCount']);
	$("#travelRepeUserCountAPP").html(data['travelRepeUserCountAPP']);
	$("#travelRepeUserCountMicroMall").html(data['travelRepeUserCountMicroMall']);
	$("#travelRepeUserCountMicro").html(data['travelRepeUserCountMicro']);
	
	//新增会员数
	$("#travelNewUserCount").html(data['travelNewUserCount']);
}