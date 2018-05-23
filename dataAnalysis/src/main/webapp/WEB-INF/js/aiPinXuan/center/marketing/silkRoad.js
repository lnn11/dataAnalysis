var data = $("[name='datas']:checked").val();

getSilkData(startTime,endTime,data,activityId);

$("#query").click(function () {
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	data = $("[name='datas']:checked").val();
	getSilkData(startTime,endTime,data,activityId);
});

$("#queryAll").click(function() {
	$("#startTime").val($("#start").val());
	$("#endTime").val($("#end").val());
	startTime = $("#startTime").val();
	endTime = $("#endTime").val();
	$("[name='datas']").eq(0).attr("checked","checked");
	data = $("[name='datas']:checked").val();
	getSilkData(startTime,endTime,data,activityId);
})

function getSilkData(startTime,endTime,data,activityId) {
	//活动销售SPU数  活动销售SKU总数
	$.ajax({
		url:'marketing/silkSPUSKUData',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			silkSPUSKUData(data);
		},
		error:function() {
			alert("获取数据失败");
		}
	});
	//活动主订单总数  活动子订单总数   活动参与总人数
	$.ajax({
		url:'marketing/silkOrderData',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			silkOrderData(data);
		},
		error:function() {
			alert("获取数据失败");
		}
	});
	//现金支付总金额   实际支付总积分  福利券支付总积分   活动商品总销量
	$.ajax({
		url:'marketing/silkPayData',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			silkPayData(data);
		},
		error:function() {
			alert("获取数据失败");
		}
	});
	//重复参与人数
	$.ajax({
		url:'marketing/silkRepeData',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			silkRepeData(data);
		},
		error:function() {
			alert("获取数据失败");
		}
	});
	//新增会员数
	$.ajax({
		url:'marketing/silkNewUserData',
		data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
		dataType:"json",
		type:"post",
		success:function(data) {
			$("#addUserCount").text(data.TUIID);
		},
		error:function() {
			alert("获取数据失败");
		}
	});
}

$("#export").click(function() {
	var activityName = $("#activityName").text();
	location.href = "marketing/exportExcel?startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&data="+$("[name='datas']:checked").val()+"&activityId="+$("#activityId").text()+"&sign=silk"+"&activityName="+encodeURI(encodeURI(activityName));
});

var oHead = document.getElementsByTagName('HEAD').item(0);
var oScript= document.createElement("script");
oScript.type = "text/javascript";
oScript.src="js/aiPinXuan/center/marketing/silkData.js";
oHead.appendChild(oScript);