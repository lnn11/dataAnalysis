function ajaxLoading(){
	    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
	    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
}
function ajaxLoadEnd(){
    $(".datagrid-mask").remove();
    $(".datagrid-mask-msg").remove();
}
//ajaxLoading();
getPVHits(null,null);
loadMemberData("","");
loadSupplierCount("","");
loadSaleProduct("","");
loadSaleEdProduct("","");
loadOrderNumber("","");
getAreadyPaidOrder("","");
getAreadySaled("","");
getOnSaleProduct("","");
getRechargeOrder("","");
getRechargeOrderDetail("","");
getRechargeSale("","");
//ajaxLoadEnd();
function Appendzero(obj)  
{  
	if(obj<10) return "0" +""+ obj;  
	else return obj;  
}
$(function(){
	var time = new Date();
	var month = time.getMonth()+1;
	var day = time.getDate();
	var year = time.getFullYear();
	var hours=time.getHours();
	var minutes=time.getMinutes();
	var seconds=time.getSeconds();
	$("#flatStartDate").val(year+'-'+Appendzero(month)+'-'+'0'+1+' '+'00:00:00');
	$("#flatEndDate").val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59')
	
});
function firstDate(){
	startTime = year+'-'+Appendzero(month)+'-'+'0'+1;
	return startTime;
};
function nowDate(){
	overTime = year+'-'+Appendzero(month)+'-'+Appendzero(day);
	return overTime;
};
/**点击统计调用函数*/
function tongCount(){
	var startTime = $("#flatStartDate").val(); var overTime = $("#flatEndDate").val();
	if(startTime == ''){
		$("#flatStartDate").val(year+'-'+Appendzero(month)+'-'+'0'+1+' '+'00:00:00');
		startTime = firstDate();
	}
	if(overTime == ''){
		$("#flatEndDate").val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59')
		overTime = nowDate();
	}
	if(startTime <= overTime){
		ajaxLoading();
		getPVHits(startTime,overTime);
		loadMemberData(startTime,overTime);
		loadSupplierCount(startTime,overTime);
		loadSaleProduct(startTime,overTime);
		loadSaleEdProduct(startTime,overTime);
		loadOrderNumber(startTime,overTime);
		getAreadyPaidOrder(startTime,overTime);
		getAreadySaled(startTime,overTime);
		getOnSaleProduct(startTime,overTime);
		getRechargeOrder(startTime,overTime);
		getRechargeOrderDetail(startTime,overTime);
		getRechargeSale(startTime,overTime);
		ajaxLoadEnd();
	}else{alert("开始时间要小于等于结束时间,请重新输入！")}
};

/**
 * 获取PV数
 */
function getPVHits(startTime,endTime){	
	$.ajax({
		type:'post',
		url:'userInfo/getPV',
		data:{"startTime":startTime,"endTime":endTime},
		dataType:'json',
		success:function(count){
			$("#pvSpan").html(count+"人次");
		}
	});
}

/**获取会员总数函数*/
function loadMemberData(startTime,overTime){
	var toUrl = "userInfo/memberCount";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startTime":startTime,"overTime":overTime},
		dataType:"json",
		async:true,
		success:function(memberData){
			if(null != memberData){
				$(memberData).each(function(i,e){
					$("#member").text(e.member3);
					$("#authentication").text(e.member2);
					$("#activation").text(e.member1);
					$("#register").text(e.member0);
				});
			}else{$("#member").text(0);};
		},
		error:function(){alert("获取会员总数失败！");},
	});
};
/**获取供应商总数函数*/
function loadSupplierCount(startTime,overTime){
	var toUrl = "supplier/getSupplierCountNum";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startTime":startTime,"overTime":overTime},
		dataType:"json",
		async:false,
		success:function(supplierData){
			if(null != supplierData){
				$("#supplier").text(supplierData);
			}else{$("#supplier").text(0);};
		},
		error:function(){alert("获取供应商总数失败！");},
	});
};
/**获取在售子商品函数*/
function loadSaleProduct(startTime,overTime){
	var toUrl = "product/getProductDetailCount";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startTime":startTime,"overTime":overTime},
		dataType:"json",
		async:false,
		success:function(productData){
			if(null != productData){
				$("#inTheSaleOf").text(productData);
			}else{$("#inTheSaleOf").text(0);};
		},
		error:function(){alert("获取在售子商品失败！");},
	});
};
/**获取上架SKU函数*/
function loadSaleEdProduct(startTime,overTime){
	var toUrl = "product/getProductDetailCountEd";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startTime":startTime,"overTime":overTime},
		dataType:"json",
		async:false,
		success:function(productEdData){
			if(null != productEdData){
				$("#inTheSaleOfEd").text(productEdData);
			}else{$("#inTheSaleOfEd").text(0);};
		},
		error:function(){alert("获取上架过的子商品失败！");},
	});
};
/**获取订单函数*/
function loadOrderNumber(startTime,overTime){
	var toUrl = "order/getOrderNumber";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startTime":startTime,"overTime":overTime},
		dataType:"json",
		success:function(returnedOrderData){
			if(null != returnedOrderData){
				$(returnedOrderData).each(function(keys,values){
					$("#alreadyShippedOrder").text(values.order1);
					$("#receivedGoodsOrder").text(values.order2);
					$("#returnedOrder").text(values.order3);
					$("#beenCanceledOrder").text(values.order4);
					$("#orderCount").text(values.order5);
				});
			}else{$("#returnedOrder").text(0);};
		},
		error:function(){alert("获取已退货订单失败！");},
	});
};
/**获取已售出商品总件数*/
function getAreadySaled(startTime,overTime){
	var toUrl = "order/getAreadySaled";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startTime":startTime,"overTime":overTime},
		dataType:"json",
		async:false,
		success:function(areadySaledData){
			if(null != areadySaledData){
				$("#areadySaledData").text(areadySaledData);
			}else{$("#areadySaledData").text(0);};
		},
		error:function(){alert("获取已退货订单失败！");},
	});
};
/**总体销售业绩指标*/
function getAreadyPaidOrder(startTime,overTime){
	var toUrl = "order/getAreadyPaidOrder";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startTime":startTime,"overTime":overTime},
		dataType:"json",
		async:false,
		success:function(areadyPaidOrder){
			if(null != areadyPaidOrder){
				$(areadyPaidOrder).each(function(i,e){
					$("#productSalesVolumes").text(e.productMoney);
					$("#areadyPaidCostData").text(e.costmoney);
					$("#areadyPaidGrossProfit").text(e.grossprofit);
					$("#actualPaidSalesIntegral").text(e.actualintegral);
					$("#actualPaidSalesMoney").text(e.paidmoney);
					$("#actualPaidSalesVolumes").text(e.actualEndMoney);
					$("#activitySalesMoney").text(e.activitEndMoney);
				});
			}else{$("#productSalesVolumes").text(0.00);};
		},
		error:function(){alert("获取商品总价失败！");},
	});
};
/**在售商品SPU*/
function getOnSaleProduct(startTime,overTime){
	var toUrl = "operate/getProductSPU";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startDate":startTime,"endDate":overTime},
		dataType:"json",
		async:false,
		success:function(data){
			if(null != data){
				$(data).each(function(i,e){
					$("#onSaleProduct").text(e.onSaleProductNum);/*在售商品SPU总数*/
					$("#saledProduct").text(e.saledProductNum);/*商品SPU总数*/
				});
			}else{
				$("#onSaleProduct").text(0);
				$("#saledProduct").text(0);
			};
		},
		error:function(){alert("获取在售商品SPU失败！");},
	});
};
/**充值类指标*/
function getRechargeOrder(startTime,overTime){
	var toUrl = "operate/getRechargeOrderNum";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startDate":startTime,"endDate":overTime},
		dataType:"json",
		async:false,
		success:function(data){
			if(null != data){
				$(data).each(function(i,e){
					$("#rechargeOrder").text(e.rechargeOrderNum);
					$("#phoneOrder").text(e.phoneOrderNum);
					$("#flowOrder").text(e.flowOrderNum);
					$("#fuelOrder").text(e.fuelCardOrderNum);
				});
			}else{
				$("#rechargeOrder").text(0);
				$("#phoneOrder").text(0);
				$("#flowOrder").text(0);
				$("#fuelOrder").text(0);
			};
		},
		error:function(){alert("获取充值类指标失败！");},
	});
};
/**充值类指标明细*/
function getRechargeOrderDetail(startTime,overTime){
	var toUrl = "operate/getRechargeOrderNumByStatus";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startDate":startTime,"endDate":overTime},
		dataType:"json",
		async:false,
		success:function(data){
			if(null != data){
				$(data).each(function(i,e){
					$(e.phone).each(function(pi,pv){
						$("#lapsedPhoneOrder").text(pv.LAPSEDORDERNUM);
						$("#cancelPhoneOrder").text(pv.CANCELORDERNUM);
						$("#completedPhoneOrder").text(pv.COMPLETEDORDERNUM);
						$("#payPhoneOrder").text(pv.PAYORDERNUM);
					});
					$(e.flow).each(function(fi,fv){
						$("#lapsedFlowOrder").text(fv.LAPSEDORDERNUM);
						$("#cancelFlowOrder").text(fv.CANCELORDERNUM);
						$("#completedFlowOrder").text(fv.COMPLETEDORDERNUM);
						$("#payFlowOrder").text(fv.PAYORDERNUM);
					});
					$(e.fuelCard).each(function(fci,fcv){
						$("#payFuelOrder").text(fcv.PAYORDERNUM);
						$("#completedFuelOrder").text(fcv.COMPLETEDORDERNUM);
						$("#cancelFuelOrder").text(fcv.CANCELORDERNUM);
						$("#lapsedFuelOrder").text(fcv.LAPSEDORDERNUM);
					});
				});
			}else{
				$("#lapsedPhoneOrder").text(0);
				$("#cancelPhoneOrder").text(0);
				$("#completedPhoneOrder").text(0);
				$("#payPhoneOrder").text(0);
				$("#lapsedFlowOrder").text(0);
				$("#cancelFlowOrder").text(0);
				$("#completedFlowOrder").text(0);
				$("#payFlowOrder").text(0);
				$("#payFuelOrder").text(0);
				$("#completedFuelOrder").text(0);
				$("#cancelFuelOrder").text(0);
				$("#lapsedFuelOrder").text(0);
			};
		},
		error:function(){alert("获取充值类指标明细失败！");},
	});
};
/**充值销量指标*/
function getRechargeSale(startTime,overTime){
	var toUrl = "operate/getRechargeSaleIndex";
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"startDate":startTime,"endDate":overTime},
		dataType:"json",
		async:false,
		success:function(data){
			if(null != data){
				$(data).each(function(i,e){
					$(e.phoneSaleMoney).each(function(phi,phv){
						$("#phoneSaleMoney").text(phv.CHARGEMONEY);
						$("#phoneCostMoney").text(phv.COSTMONEY);
						$("#phoneGrossProfit").text(phv.GROSSPROFIT);
					});
					$(e.flowSaleMoney).each(function(fi,fv){
						$("#flowSaleMoney").text(fv.CHARGEMONEY);
						$("#flowCostMoney").text(fv.COSTMONEY);
						$("#flowGrossProfitr").text(fv.GROSSPROFIT);
					});
					$(e.fuelCardSaleMoney).each(function(fci,fcv){
						$("#fuelCardSaleMoney").text(fcv.CHARGEMONEY);
						$("#fuelCardCostMoney").text(fcv.COSTMONEY);
						$("#fuelCardflowGrossProfitr").text(fcv.GROSSPROFIT);
					});
				});
			}else{
				$("#phoneSaleMoney").text(0.00);
				$("#phoneCostMoney").text(0.00);
				$("#phoneGrossProfit").text(0.00);
				$("#flowSaleMoney").text(0.00);
				$("#flowCostMoney").text(0.00);
				$("#flowGrossProfitr").text(0.00);
				$("#fuelCardSaleMoney").text(0.00);
				$("#fuelCardCostMoney").text(0.00);
				$("#fuelCardflowGrossProfitr").text(0.00);
			};
		},
		error:function(){alert("获取充值销量指标失败！");}
	});
};