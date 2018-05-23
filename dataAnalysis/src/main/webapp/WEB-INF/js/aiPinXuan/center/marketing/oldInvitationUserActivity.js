var code; var value;
if(activityId == "ZHB20170524001") {
	code = "兑换码";
	value = "兑换码";
}else if(activityId == "ZHB20170909001" || activityId == "ZHB20170001016") {
	code = "其他";
	value = "null";
}
if(activityId == "ZHB20170909001") {
	$("#specialCount1").hide();
	$("#ticketCount1").hide();
	$("#pastTicketCount").hide();
	$("#pastTicketCounts").hide();
}else if(activityId == "ZHB20170001016") {
	$("#specialCount").hide();
	$("#ticketCount").hide();
	$("#channelCount").hide();
	$("#channelCounts").hide();
	$("#channelCounts").hide();
}

$("[name='channel']").append("<option value="+value+">"+code+"</option>");
if(activityId != 'ZHB20170001016') {
	getChannel();
}
var data = $("[name='channel']").val();
getOldInvitationUserActivity(startTime,endTime,data,activityId);

function channelChange() {
	data = $("[name='channel']").val();
	getOldInvitationUserActivity(startTime,endTime,data,activityId);
}

$("#btnQuery").click(function() {
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	activityId = $("#activityId").html();
	data = $("[name='channel']").val();
	getOldInvitationUserActivity(startTime,endTime,data,activityId);
})

$("#btnQueryAll").click(function(){
	$("#startTime").val($("#start").val());
	$("#endTime").val($("#end").val());
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	activityId = $("#activityId").html();
	$("[name='channel'] option:first").prop("selected", 'selected');
	data = $("[name='channel']").val();
	getOldInvitationUserActivity(startTime,endTime,data,activityId);
});

//导出数据
$("#export").click(function() {
	data = $("[name='channel']").val();
	if(typeof(data)=="undefined") {
		data = "";
	}
	var activityName = $("#activityName").text();
	location.href = "marketing/exportExcel?startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&data="+encodeURI(encodeURI(data))+"&activityId="+$("#activityId").text()+"&sign=wuChangRiceExport"+"&activityName="+encodeURI(encodeURI(activityName));
});

function showInfo(obj){
	var content="";
	if(obj.id=="proTotal"){
		content="用券购买商品价格总和";
	}else if(obj.id=="oriPice"){
		content="公式：已销售活动商品售价-已销售活动商品供货价";
	}else if(obj.id=="coups"){
		content="按照活动规则完成任务，并成功领券数量";
	}else if(obj.id=="oTotal"){
		content="活动期间,当前活动中订单完成支付的次数";
	}else if(obj.id=="payPrice"){
		content="活动期间,平台实际现金支付总金额";
	}else if(obj.id=="dis"){
		content="活动期间,输入邀请人手机号数量，排重显示";
	}else if(obj.id=="inv"){
		content="活动期间,输入邀请人手机号，并成功注册的账户数量，排重显示";
	}else if(obj.id=="cah"){
		content="活动期间，被邀请人所有首单金额的均值 </br>公式：首单金额之和/订单数量";
	}else if(obj.id=="full"){
		content="活动期间，邀请人使用满减券的数量";
	}else if(obj.id=="uSku"){
		content="活动期间，新人专区销售的sku数";
	}else if(obj.id=="uSpu"){
		content="活动期间，新人专区销售的spu数";
	}else if(obj.id=="uPayCash"){
		content="活动期间，新人专区,销售的所有活动商品现金之和";
	}else if(obj.id=="oSku"){
		content="活动期间，一元专区销售的sku数";
	}else if(obj.id=="oSpu"){
		content="活动期间，一元专区销售的spu数";
	}else if(obj.id=="oPayCash"){
		content="活动期间，一元专区,销售的所有活动商品现金之和";
	}else if(obj.id=="uCose"){
		content="公式：1元专区销售件数 * 10 /被邀请人注册数量";
	}else if(obj.id=="aCose"){
		content="公式：1元专区销售件数 * 10";
	}else if(obj.id=="rUsers"){
		content="活动期间,平台实际注册用户数量";
	}else if(obj.id=="first"){
		content="被邀请人首单人数";
	}
	$("#mydiv").html(content);
	return content;
}


function getOldInvitationUserActivity(startTime,endTime,data,activityId) {
	$.ajax({
		url:'marketing/getOldInvitationUserActivity',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			$("#coupons").html(data["coupons"]);
			$("#registUsers").html(data["registUsers"]);
			$("#orderTotal").html(data["orderTotal"]);
			$("#realPay").html(data["realPay"]);
			$("#inviteCodeNum").html(data["inviteCodeNum"]);
			$("#disInviteCodeNum").html(data["disInviteCodeNum"]);
			$("#fullcutNum").html(data["fullcutNum"]);
			$("#productTotal").html(data["productTotal"]);
			$("#profit").html(data["profit"]);
			$("#firstOrderTotal").html(data["firstOrderTotal"]);
			$("#cashDivTotal").html(data["cashDivTotal"]);
			$("#userSku").html(data["userSku"]);
			$("#userSpu").html(data["userSpu"]);
			$("#userPayCash").html(data["userPayCash"]);
			$("#oneSku").html(data["oneSku"]);
			$("#oneSpu").html(data["oneSpu"]);
			$("#onePayCash").html(data["onePayCash"]);
			$("#getUserCost").html(data["getUserCost"]);
			$("#activityCost").html(data["activityCost"]);
		},
		error:function() {
			alert("获取数据失败");
		}
	});
	if(activityId == 'ZHB20170001016') {
		$.ajax({
			url:"marketing/getCouponUser",
//			data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
			dataType:"json",
			type:"post",
			success:function(data) {
				$("#specialCounts").html(data["specialCounts"]);
				$("#ticketCountes").html(data["ticketCountes"]);
				$("#pastTicketCounts").html(data["pastTicketCountes"]);
				$("#longinCounts").html("--");
			},
			error:function() {
				alert("获取数据失败");
			}
		})
	}

}

function getChannel() {
	$.ajax({
		url:'marketing/getChannel',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			for(var i in data) {
				$("[name='channel']").append("<option value="+data[i].CHANNELID+">"+data[i].CHANNELNAME+"</option>");
			}
		},
		error:function() {
			alert("获取数据失败");
		}
	});
}