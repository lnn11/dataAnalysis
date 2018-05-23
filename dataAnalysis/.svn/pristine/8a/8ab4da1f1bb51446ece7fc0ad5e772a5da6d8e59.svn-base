var data;
choice();
function choice() {
	if($("#dataCh").text()==1){
		data = $("[name='datas']:checked").val();
	}else if($("#dataCh").text()==3){
		data = $("[name='choice']").val();
		if(data == '满减') {
			data = $("[name='choice1']").val();
			if(data == "全部"){
				data = "满减";
			}
		}
	}else {
		data = $("[name='dataChoice']").val();
	}
}

function change() {
	data = $("[name='choice']").val();
	if(data == "满减") {
		$("#data3").show();
		data = $("[name='choice1']").val();
		if(data == "全部"){
			data = "满减";
		}
	}else{
		$("#data3").hide();
	}
}

function dataChange(){
	data = $("[name='dataChoice']").val();
	getActivityData(startTime,endTime,data,activityId);
}
getActivityData(startTime,endTime,data,activityId);

//查询
$("#btnQuery").click(function() {
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	activityId = $("#activityId").html();
	choice();
	getActivityData(startTime,endTime,data,activityId);
});

//查询全部
$("#btnQueryAll").click(function(){
	$("#startTime").val($("#start").val());
	$("#endTime").val($("#end").val());
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	activityId = $("#activityId").html();
	if($("#dataCh").text()==1) {
		$("[name='datas']").eq(0).attr("checked","checked");
		data = $("[name='datas']:checked").val();
	}else if($("#dataCh").text()==3){
		$("[name='choice'] option:first").prop("selected", 'selected');
		data = $("[name='choice']").val();
		$("#data3").hide();
	}else {
		$("[name='dataChoice'] option:first").prop("selected", 'selected');
		data = $("[name='dataChoice']").val();
	}
	getActivityData(startTime,endTime,data,activityId);
});

//导出数据
$("#export").click(function() {
	if($("#dataCh").text()==1) {
		data = $("[name='datas']:checked").val();
		if(typeof(data)=="undefined") {
			data = "";
		}
	}else if($("#dataCh").text()==3){
		data = $("[name='choice']").val();
		if(data == "满减") {
			data = $("[name='choice1']").val();
			if(data == "全部"){
				data = "满减";
			}
		}
	}else {
		data = $("[name='dataChoice']").val();
	}
	var activityName = $("#activityName").text();
	location.href = "marketing/exportExcel?startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&data="+encodeURI(encodeURI(data))+"&activityId="+$("#activityId").text()+"&sign=avtivityExport"+"&activityName="+encodeURI(encodeURI(activityName));
});

//加载数据
function getActivityData (startTime,endTime,data,activityId) {
	$.ajax({
		type:"post",
		url:"marketing/getActivitySpuSku",
		data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
		dataType:"json",
		success:function(data){
			getActivitySpuSku(data);
		},
		error:function(data){alert("网络开小差,请刷新重试!");}
	});
	$.ajax({
		type:"post",
		url:"marketing/getActivityTotal",
		data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
		dataType:"json",
		success:function(data){			
			getActivityTotal(data);
		},
		error:function(data){alert("网络开小差,请刷新重试!");}
	});
	$.ajax({
		type:"post",
		url:"marketing/getActivityUserTotal",
		data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
		dataType:"json",
		success:function(data){
			getActivityUserTotal(data);
		},
		error:function(){alert("网络开小差,请刷新重试!");}
	});
	$.ajax({
		type:"post",
		url:"marketing/getActivityUserRepeat",
		data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
		dataType:"json",
		success:function(data){		
			getActivityUserRepeat(data);
		},
		error:function(){alert("网络开小差,请刷新重试!");}
	});
	$.ajax({
		type:"post",
		url:"marketing/getActivityUserAdd",
		data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
		dataType:"json",
		success:function(data){			
			getActivityUserAdd(data);
		},
		error:function(){alert("网络开小差,请刷新重试!");}
	});
	if(startTime > "2017-08-02 00:00:00") {
		$.ajax({
			url:"marketing/getActivityUserCount",
			data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
			dataType:"json",
			type:"post",
			success:function(data) {
				getActivityUserCount(data);
			},
			error:function(){alert("网络开小差,请刷新重试!");}
		})
		if(activityId == 'ZHB20170904001' || activityId == 'ZHB20170721001') {
			$.ajax({
				url:"marketing/getParticipationData",
				data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
				dataType:"json",
				type:"post",
				success:function(data) {
					getParticipationData(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
			$.ajax({
				url:"marketing/getPrizeData",
				data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
				dataType:"json",
				type:"post",
				success:function(data) {
					getPrizeData(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
			$.ajax({
				url:"marketing/getEnjoyData",
				data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
				dataType:"json",
				type:"post",
				success:function(data) {
					getEnjoyData(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
			$.ajax({
				url:"marketing/getExpendIntegral",
				data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
				dataType:"json",
				type:"post",
				success:function(data) {
					getExpendIntegral(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
			$.ajax({
				url:"marketing/getThanksCount",
				data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
				dataType:"json",
				type:"post",
				success:function(data) {
					getThanksCount(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
		}
		if(activityId == 'ZHB20170904001') {
			//优惠券
			$.ajax({
				url:"marketing/getCoupon",
				data:{"startTime":startTime,"endTime":endTime},
				dataType:"json",
				type:"post",
				success:function(data) {
					getCoupon(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
			//中奖详情
			$.ajax({
				url:"marketing/getPrizeCount",
				data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
				dataType:"json",
				type:"post",
				success:function(data) {
					getPrizeInterger(data);
					getOtherCount(data);
					getPrizeCount(data)
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
		}
		if(activityId == 'ZHB20170721001') {
			$.ajax({
				url:"marketing/getPrizeInterger",
				data:{"startTime":startTime,"endTime":endTime},
				dataType:"json",
				type:"post",
				success:function(data) {
					getPrizeInterger(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
			$.ajax({
				url:"marketing/getOtherCount",
				data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
				dataType:"json",
				type:"post",
				success:function(data) {
					getOtherCount(data);
				},
				error:function(){alert("网络开小差,请刷新重试!");}
			})
		}
	}
}

function getActivitySpuSku(data) {
	$("#saleSpuTotal").html(data["saleSpuTotal"]);
	$("#saleSpuAppTotal").html(data["saleSpuAppTotal"]);
	$("#saleSpuWebChatTotal").html(data["saleSpuWebChatTotal"]);
	$("#saleSpuMicroTotal").html(data["saleSpuMicroTotal"]);
	$("#saleSpuMTotal").html(data["saleSpuMTotal"]);
	
	$("#saleSkuTotal").html(data["saleSkuTotal"]);
	$("#saleSkuAppTotal").html(data["saleSkuAppTotal"]);
	$("#saleSkuWebChatTotal").html(data["saleSkuWebChatTotal"]);
	$("#saleSkuMicroTotal").html(data["saleSkuMicroTotal"]);
	$("#saleSkuMTotal").html(data["saleSkuMTotal"]);
}

function getActivityTotal(data) {
	$("#saleProductTotal").html(data["saleProductTotal"]);
	$("#saleProductAppTotal").html(data["saleProductAppTotal"]);
	$("#saleProductWebChatTotal").html(data["saleProductWebChatTotal"]);
	$("#saleProductMicroTotal").html(data["saleProductMicroTotal"]);
	$("#saleProductMTotal").html(data["saleProductMTotal"]);
	
	$("#saleMainOrderTotal").html(data["saleMainOrderTotal"]);
	$("#saleMainOrderAppTotal").html(data["saleMainOrderAppTotal"]);
	$("#saleMainOrderWebChatTotal").html(data["saleMainOrderWebChatTotal"]);
	$("#saleMainOrderMicroTotal").html(data["saleMainOrderMicroTotal"]);
	$("#saleMainOrderMTotal").html(data["saleMainOrderMTotal"]);
	
	$("#saleSubOrderTotal").html(data["saleSubOrderTotal"]);
	$("#saleSubOrderAppTotal").html(data["saleSubOrderAppTotal"]);
	$("#saleSubOrderWebChatTotal").html(data["saleSubOrderWebChatTotal"]);
	$("#saleSubOrderMicroTotal").html(data["saleSubOrderMicroTotal"]);
	$("#saleSubOrderMTotal").html(data["saleSubOrderMTotal"]);
	
	$("#saleCashTotalSub").html(data["saleCashTotalSub"]);
	$("#saleCashTotalAppSub").html(data["saleCashTotalAppSub"]);
	$("#saleCashTotalWebChatSub").html(data["saleCashTotalWebChatSub"]);
	$("#saleCashTotalMicroSub").html(data["saleCashTotalMicroSub"]);
	$("#saleCashTotalMSub").html(data["saleCashTotalMSub"]);
	
	$("#actualPayPointTotal").html(data["actualPayPointTotal"]);
	$("#actualPayPointAppTotal").html(data["actualPayPointAppTotal"]);
	$("#actualPayPointWebChatTotal").html(data["actualPayPointWebChatTotal"]);
	$("#actualPayPointMicroTotal").html(data["actualPayPointMicroTotal"]);
	$("#actualPayPointMTotal").html(data["actualPayPointMTotal"]);
	
	$("#specialCashTotal").html(data["specialCashTotal"]);
	$("#specialCashAppTotal").html(data["specialCashAppTotal"]);
	$("#specialCashWebChatTotal").html(data["specialCashWebChatTotal"]);
	$("#specialCashMicroTotal").html(data["specialCashMicroTotal"]);
	$("#specialCashMTotal").html(data["specialCashMTotal"]);
}

function getActivityUserTotal(data) {
	$("#enjoyUserCount").html(data["travelUserCount"]);
	$("#enjoyUserAppCount").html(data["travelUserCountAPP"]);
	$("#enjoyUserMicroMallCount").html(data["travelUserCountMicroMall"]);
	$("#enjoyUserMicroCount").html(data["travelUserCountMicro"]);
	$("#enjoyUserMCount").html(data["travelUserCountM"]);
}

function getActivityUserRepeat (data) {
	$("#repeatUserCount").html(data["travelRepeUserCount"]);
	$("#repeatUserAppCount").html(data["travelRepeUserCountAPP"]);
	$("#repeatUserMicroMallCount").html(data["travelRepeUserCountMicroMall"]);
	$("#repeatUserMicroCount").html(data["travelRepeUserCountMicro"]);
	$("#repeatUserMCount").html(data["travelRepeUserCountM"]);
} 

function getActivityUserAdd (data) {
	$("#addUserCount").html(data["USERTOTAL"]);
}
//拉新会员数
function getActivityUserCount(data){
	$("#activityTotals").html(data["activityTotals"]);
	$("#activityMicroMallTotal").html(data["activityMicroMallTotal"]);
	$("#activityMTotal").html(data["activityMTotal"]);
}
//参与数据
function getParticipationData(data) {
	$("#participationDataTimes").html(data["PARTICIPATIONDATATIMES"]);
	$("#participationDataNumber").html(data["PARTICIPATIONDATANUMBER"]);
}
//中奖数据
function getPrizeData(data) {
	$("#prizeDataTimes").html(data["PRIZEDATATIMES"]);
	$("#prizeDataNumber").html(data["PRIZEDATANUMBER"]);
}
//分享数据
function getEnjoyData(data) {
	$("#enjoyDataTimes").html(data["ENJOYDATATIMES"]);
}
//大转盘消耗积分
function getExpendIntegral(data) {
	$("#expendIntegral").html(data["EXPENDINTEGRAL"]);
}
//（谢谢） 人次  人数
function getThanksCount(data) {
	$("#thanksCountTimes").html(data["THANKSCOUNTTIMES"]);
	$("#thanksCountNumber").html(data["THANKSCOUNTNUMBER"]);
}
//积分的奖励值  人次  人数
function getPrizeInterger(data) {
	$("#thirtyCount").html(data["thirtyCount"]);
	$("#hundredCount").html(data["hundredCount"]);
	$("#twoHundredCount").html(data["twoHundredCount"]);
	$("#FiveHundredCount").html(data["FiveHundredCount"]);
	
	$("#thirtyCountTimes").html(data["thirtyCountTimes"]);
	$("#hundredCountTimes").html(data["hundredCountTimes"]);
	$("#twoHundredCountTimes").html(data["twoHundredCountTimes"]);
	$("#FiveHundredCountTimes").html(data["FiveHundredCountTimes"]);
	
	$("#thirtyCountNumber").html(data["thirtyCountNumber"]);
	$("#hundredCountNumber").html(data["hundredCountNumber"]);
	$("#twoHundredCountNumber").html(data["twoHundredCountNumber"]);
	$("#FiveHundredCountNumber").html(data["FiveHundredCountNumber"]);
}
//非谢谢 非积分  奖励值  人次 人数
function getOtherCount(data) {
	$("#weileCount").html(data["weileCount"]);
	$("#summerCount").html(data["summerCount"]);
	$("#iPadCount").html(data["iPadCount"]);
	
	$("#weileCountTimes").html(data["weileCountTimes"]);
	$("#summerCountTimes").html(data["summerCountTimes"]);
	$("#iPadCountTimes").html(data["iPadCountTimes"]);
	
	$("#weileCountNumber").html(data["weileCountNumber"]);
	$("#summerCountNumber").html(data["summerCountNumber"]);
	$("#iPadCountNumber").html(data["iPadCountNumber"]);
}
//优惠券
function getCoupon(data) {
	$("#couponGrantCounts").html(data["couponGrantCounts"]);
	$("#couponGrantUserCounts").html(data["couponGrantUserCounts"]);
	$("#couponUseCounts").html(data["couponUseCounts"]);
	$("#couponUseUserCounts").html(data["couponUseUserCounts"]);
	$("#couponPastCounts").html(data["couponPastCounts"]);
	$("#couponPastUserCounts").html(data["couponPastUserCounts"]);
}
function getPrizeCount(data){
	$("#fiftyCount").html(data["fiftyCount"]);
	$("#fiftyCountTimes").html(data["fiftyCountTimes"]);
	$("#fiftyCountNumber").html(data["fiftyCountNumber"]);
	
	$("#OneThousandCount").html(data["OneThousandCount"]);
	$("#OneThousandCountTimes").html(data["OneThousandCountTimes"]);
	$("#OneThousandCountNumber").html(data["OneThousandCountNumber"]);
}