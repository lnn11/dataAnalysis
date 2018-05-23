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
getWuChangRiceData(startTime,endTime,data,activityId);

function channelChange() {
	data = $("[name='channel']").val();
	getWuChangRiceData(startTime,endTime,data,activityId);
}

$("#btnQuery").click(function() {
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	activityId = $("#activityId").html();
	data = $("[name='channel']").val();
	getWuChangRiceData(startTime,endTime,data,activityId);
})

$("#btnQueryAll").click(function(){
	$("#startTime").val($("#start").val());
	$("#endTime").val($("#end").val());
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	activityId = $("#activityId").html();
	$("[name='channel'] option:first").prop("selected", 'selected');
	data = $("[name='channel']").val();
	getWuChangRiceData(startTime,endTime,data,activityId);
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
	if(obj.id=="channelCount") {
		content="当前位置显示此次活动，铺放的渠道数量";
	}else if(obj.id=="ticketCount") {
		content="渠道注册成功用户实际领取券兑换码的数量";
	}else if(obj.id=="registerUser") {
		content="渠道实际注册用户数量";
	}else if(obj.id=="buyCount") {
		content="渠道完成支付的次数";
	}else if(obj.id=="payMoney") {
		content="渠道实际现金支付总金额";
	}else if(obj.id=="ticketUV") {
		content="显示渠道领券页面（引导新用户注册的页面）的独立访问人数";
	}else if(obj.id=="ticketPV") {
		content="渠道领券页面（引导新用户注册的页面）总访问量";
	}else if(obj.id=="activePV") {
		content="渠道活动宣传首页的总访问量";
	}else if(obj.id=="activeUV") {
		content="渠道活动宣传首页的独立访问人数";
	}else if(obj.id=="orderPV") {
		content="渠道活动提交订单页面总访问量";
	}else if(obj.id=="specialCount") {
		content="活动期间，直接获取购买特权及使用兑换码获取购买特权用户的数量";
	}else if(obj.id=="channelChange") {
		content="渠道实际注册用户数量/活动展示页PV";
	}else if(obj.id=="redeemCodePV") {
		content="该渠道兑换码页面总访问量";
	}else if(obj.id=="redeemCodeOrderPV") {
		content="兑换码提交订单页面总访问量";
	}else if(obj.id=="longinCount") {
		content="活动期间，去注册按钮的点击次数";
	}else if(obj.id=="specialCount1") {
		content="活动期间，发放优惠券的数量";
	}else if(obj.id=="ticketCount1") {
		content="优惠券已使用的数量";
	}else if(obj.id=="pastTicketCount") {
		content="优惠券已过期的数量";
	}
	$("#mydiv").html(content);
	return content;
}


function getWuChangRiceData(startTime,endTime,data,activityId) {
	$.ajax({
		url:'marketing/getWuChangRiceData',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			$("#channelCounts").html(data["channelCount"]);
			$("#ticketCounts").html(data["ticketCount"]);
			$("#registerUsers").html(data["registerUser"]);
			$("#buyCounts").html(data["buyNum"]);
			$("#payMoneys").html(data["payCash"]);
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
	if(activityId == 'ZHB20170909001') {
		$.ajax({
			url:"marketing/getRedeemCode",
			data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
			dataType:"json",
			type:"post",
			success:function(data) {
				$("#specialCounts").html(data["specialCounts"]);
				$("#ticketCountes").html(data["ticketCountes"]);
				$("#longinCounts").html(data["longinCounts"]);
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