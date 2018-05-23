// 表格 柱状图
var orderSuppName;//供应商名称
var orderSuppNUM;//订单数
var orderSuppSumIntegral;//订单总销售额
var orderSuppProp;//订单占比
var orderSuppIntegralProp;//订单总销售额占比
var orderSuppSumNum;//销量
var orderSuppSumNumProp;//销量占比

//饼状图
var orderSuppNamePie;//供应商名称
var orderSuppNumPie;//订单总数
var orderSuppSumIntegralPie;//订单总销售额
var orderSuppSumNumPie;//销量

//总销售额   总销量
var osOrderSumIntergarls;
var osSumNum;
var supplierList;
var pageSize;
var supplierJSON;
var orderCount;

//默认本月第一天的零时零分零秒
var myDate = new Date();
var year = myDate.getFullYear();
var month = myDate.getMonth()+1;
if (month<10){
    month = "0"+month;
}
var firstDay = year+"-"+month+"-"+"01 00:00:00";
$("#prevDateOrder").val(firstDay);

//默认昨天的最后一秒
var day = myDate.getDate();
if(day<10){
   day="0"+day;
}
var yesterDay = year+"-"+month+"-"+day+" "+'23:59:59';
$("#nextDateOrder").val(yesterDay);


var pageCount;//总页数
var currentPage=1;//当前页
var currentPage1 = currentPage;
supp();
fenPage();

//统计
$("#tong_orderSupplier").click(function(){
	currentPage=1;
	$("#orderTextG0").val(currentPage);
	supp();
	$("#orderPageCount").text(pageCount);
})

//共多少页
$("#orderPageCount").text(pageCount);

$("#orderTextG0").val(currentPage);

function fenPage() {
	//上一页
	$("#orderPrevPage").click(function() {
		currentPage = currentPage-1;
		if(currentPage < 1) {
			currentPage = 1;
			return;
		}
		currentPage1 = currentPage;
		$("#orderTextG0").val(currentPage1);
		page();
		fuzhi();
	})
	
	//下一页
	$("#orderNextPage").click(function() {
		currentPage = currentPage+1;
		if(currentPage > pageCount){
			currentPage = pageCount;
			return;
		};
		currentPage1 = currentPage;
		$("#orderTextG0").val(currentPage1);
		page();
		fuzhi();
	})
	//首页
	$("#orderFirstPage").click(function() {
		currentPage = 1;
		currentPage1 = currentPage;
		$("#orderTextG0").val(currentPage1);
		page();
		fuzhi();
	})
	//尾页
	$("#orderLastPage").click(function() {
		if(pageCount != 0) {
			currentPage = pageCount;
		}
		currentPage1 = currentPage;
		$("#orderTextG0").val(currentPage1);
		page();
		fuzhi();
	})

	$("#orderGo").click(function() {
		currentPage = $("#orderTextG0").val();
		if(!isNaN(currentPage)){
			currentPage1 = currentPage;
			if(currentPage1 > pageCount) {
				currentPage1 = pageCount;
			}
			if(currentPage < 1) {
				currentPage = 1;
			}
			$("#orderTextG0").val(currentPage1);
			page();
			fuzhi();
		}else{
			alert("请正确输入数字格式！");
			currentPage = currentPage1;
			$("#orderTextG0").val(currentPage);
		}
	})
}

function page() {
	$.ajax({
		url:"order/getSupplierByPage",
		data:{currentPage:currentPage1,prevDateOrder:$("#prevDateOrder").val(),nextDateOrder:$("#nextDateOrder").val(),supplierLists:supplierJSON,pageSize:pageSize},
		type:'post',
		dataType:"json",
		async:false,
		success:function(obj) {
			orderSuppName = [];
			orderSuppSumIntegral = [];
			orderSuppSumNum = [];
			orderSuppIntegralProp = [];
			orderSuppSumNumProp = [];
			orderSuppNUM = [];
			orderSuppProp = [];
			if(obj) {
				currentPage = obj.currentPage;
				var orderSaleListBySupss = obj.orderSaleListBySup;
				if(orderSaleListBySupss != null&& orderSaleListBySupss !=""){
					for ( var key in orderSaleListBySupss) {
						var orlbSname = orderSaleListBySupss[key].SNAME;
						var orlbOsiss = orderSaleListBySupss[key].ORDERSUMINTEGRALS;
						var orlbSumNum = orderSaleListBySupss[key].SUMNUM;
						orderSuppName.push(orlbSname);
						orderSuppSumIntegral.push(orlbOsiss);
						orderSuppSumNum.push(orlbSumNum);
						orderSuppIntegralProp.push((orlbOsiss/osOrderSumIntergarls*100).toFixed(2)+"%");
						orderSuppSumNumProp.push((orlbSumNum/osSumNum*100).toFixed(2)+"%");
					}
				}else{
					orderSuppName = ['暂无数据'];
					orderSuppSumIntegral = ['暂无数据'];
					orderSuppSumNum = ['暂无数据'];
					orderSuppIntegralProp = ['暂无数据'];
					orderSuppSumNumProp = ['暂无数据'];
				}
				var orderListBySupss = obj.orderListBySup;
				if(orderListBySupss != null && orderListBySupss !="") {
					for (var key in orderListBySupss) {
						var olbSname = orderListBySupss[key].SNAME;
						var olbOrderNum = orderListBySupss[key].ORDERNUM;
						orderSuppNUM.push(olbOrderNum);
						orderSuppProp.push((olbOrderNum/orderCount*100).toFixed(2)+"%");
					}
				}else{
					orderSuppNUM = ['暂无数据'];
					orderSuppProp = ['暂无数据'];
				}
				table();
			}
		},
		error:function() {
			alert("error");
		}
	})
}



$(":checkbox").click(function(){ 
	if($(this).attr("checked")!=undefined) 
	{ 
		$(this).siblings().attr("checked",false);
		$(this).attr("checked",true);
	}
});


$("#pro1").click(function() {
	$("#pro1").attr("checked",true);
	supp();
});	
//按月统计
$("#month1").click(function() {
	$("#centerComm").panel({
		href:'aiPinXuan/center/commodity/order/ordersTotal'
	})
})

function aj() {
	var prevDateOrder = $("#prevDateOrder").val();
	var nextDateOrder = $("#nextDateOrder").val();
	$.ajax({
		url:'order/orderSupplier',
		data:{prevDateOrder:prevDateOrder,nextDateOrder:nextDateOrder},
		dataType:"json",
		async:false,
		success:function(obj) {
			//刷新页面数组为空
			orderSuppName = [];
			orderSuppNUM = [];
			orderSuppSumIntegral = [];
			orderSuppProp = [];
			orderSuppIntegralProp = [];
			orderSuppSumNum = [];
			orderSuppSumNumProp = [];
			orderSuppNamePie = [];
			orderSuppNumPie = [];
			orderSuppSumIntegralPie = [];
			orderSuppSumNumPie = [];
			if(obj){
				pageCount = obj.pageCount;
				orderCount = obj.orderCount;
				currentPage = obj.currentPage;
				supplierList = obj.supplierList;
				pageSize = obj.pageSize;
				supplierJSON = obj.supplierJSON;
				
				//所有供应商销量  销售额总数
				var orderSaleCount = obj.orderSaleCount;
				if(orderSaleCount != null && orderSaleCount != ""){
					for ( var key in orderSaleCount) {
						osOrderSumIntergarls = orderSaleCount[key].ORDERSUMINTEGRALS;
						osSumNum = orderSaleCount[key].SUMNUM;
					}
				}
				//供应商订单 总数
				var orderSupplierList = obj.orderSupplierList;
				if(orderSupplierList != null && orderSupplierList != ""){
					for ( var key in orderSupplierList) {
						var osOrderNum = orderSupplierList[key].ORDERNUM;
						var oslSname = orderSupplierList[key].SNAME;
						orderSuppNamePie.push(oslSname);
						orderSuppNumPie.push(osOrderNum);
					}
				}else{
					orderSuppNamePie = ['暂无数据'];
					orderSuppNumPie = [0];
				}
				
				//供应商 销量  销售额  总数
				var orderSupplierSaleList = obj.orderSupplierSaleList;
				if(orderSupplierSaleList != null && orderSupplierSaleList != "") {
					for ( var key in orderSupplierSaleList) {
						var ossSname = orderSupplierSaleList[key].SNAME;
						var ossOrderSumIntegrals = orderSupplierSaleList[key].ORDERSUMINTEGRALS;
						var ossSumNum = orderSupplierSaleList[key].SUMNUM;
						orderSuppSumNumPie.push(ossSumNum);
						orderSuppSumIntegralPie.push(ossOrderSumIntegrals);
					}
				}else{
					orderSuppSumNumPie = [0];
					orderSuppSumIntegralPie = [0];
				}
				
				//每页数据
				var firstpageSupplier = eval(obj.firstpageSupplier);
				var orderListBySup = firstpageSupplier["orderListBySup"];
				var orderSaleListBySup = firstpageSupplier["orderSaleListBySup"];
				if(orderListBySup != null && orderListBySup != "") {
					for ( var key1 in orderListBySup) {
						var olSname = orderListBySup[key1].SNAME;
						var olOrderNum = orderListBySup[key1].ORDERNUM;
						orderSuppNUM.push(olOrderNum);
						orderSuppProp.push((olOrderNum/orderCount*100).toFixed(2)+"%");
					}
				}else{
					orderSuppNUM = ['暂无数据'];
					orderSuppProp = ['暂无数据'];
				}
				if(orderSaleListBySup != null && orderSaleListBySup != ""){
					for ( var key2 in orderSaleListBySup) {
						var osSname = orderSaleListBySup[key2].SNAME;
						var osOrderSumIntegeral = orderSaleListBySup[key2].ORDERSUMINTEGRALS;
						var oslSumNum = orderSaleListBySup[key2].SUMNUM;
						orderSuppName.push(osSname);
						orderSuppSumIntegral.push(osOrderSumIntegeral);
						orderSuppSumNum.push(oslSumNum);
						orderSuppIntegralProp.push((osOrderSumIntegeral/osOrderSumIntergarls*100).toFixed(2)+"%");
						orderSuppSumNumProp.push((oslSumNum/osSumNum*100).toFixed(2)+"%");
					}
				}else{
					orderSuppName = ['暂无数据'];
					orderSuppSumIntegral = ['暂无数据'];
					orderSuppSumNum = ['暂无数据'];
					orderSuppIntegralProp = ['暂无数据'];
					orderSuppSumNumProp = ['暂无数据'];
				}
				table();
			}
		},
		error:function() {
			alert("error");
		}
	});
}

//按供应商统计
function supp(){
		aj();
		fuzhi();
}

function table(){
	//给表格赋值
	$("#orderSupplierTable").empty("");
	$("#orderSupplierTable").show();
	$("#orderSupplierTable").append("<tr align='center' style='height:40px;'><th style='width:150px;'><div id='sdiv1'><b id='sab1'>订单</b><em id='sem1'>供应商</em></div></th><th>订单总数</th><th>订单总数占比</th><th>销量</th><th>销量占比</th><th>销售额</th><th>销售额占比</th></tr>");
	for(var i=0;i<orderSuppName.length ;i++){
		$("#orderSupplierTable").append("<tr align='center'><td id='color'>"+orderSuppName[i]+"</td><td>"+orderSuppNUM[i]+"</td><td>"+orderSuppProp[i]+"</td><td>"+orderSuppSumNum[i]+"</td><td>"+orderSuppSumNumProp[i]+"</td><td>"+orderSuppSumIntegral[i]+"</td><td>"+orderSuppIntegralProp[i]+"</td></tr>");
	}
}

function fuzhi() {
	$("#os1").show();
	$("#os2").show();
	$("#os3").show();
	
	$("#barOrderSupplier1").empty("");
	$("#barOrderSupplier2").empty("");
	$("#barOrderSupplier3").empty("");
	$("#pieOrderSupplier1").empty("");
	$("#pieOrderSupplier2").empty("");
	$("#pieOrderSupplier3").empty("");
	
	//柱状图赋值
	barOrderSupplier1(orderSuppNUM,orderSuppName);
	barOrderSupplier2(orderSuppSumNum,orderSuppName);
	barOrderSupplier3(orderSuppSumIntegral,orderSuppName);
	
	//饼状图数据封装到map
	var array1 = [];
	for(var i=0;i<orderSuppNamePie.length;i++){
		var map = {};
		map.name = orderSuppNamePie[i];
		map.value = orderSuppNumPie[i];
		array1[i] = map;
	}
	pieOrderSupplier1(array1);
	
	var array2 = [];
	for(var i=0;i<orderSuppNamePie.length;i++){
		var map = {};
		map.name = orderSuppNamePie[i];
		map.value = orderSuppSumNumPie[i];
		array2[i] = map;
	}
	pieOrderSupplier2(array2);
	
	var array3 = [];
	for(var i=0;i<orderSuppNamePie.length;i++){
		var map = {};
		map.name = orderSuppNamePie[i];
		map.value = orderSuppSumIntegralPie[i];
		array3[i] = map;
	}
	pieOrderSupplier3(array3);
}
	
function barOrderSupplier1(datas,dataName) {
	var barChart = echarts.init(document.getElementById('barOrderSupplier1'));
	var barOption = {
		    title : {
		        text: $("#prevDateOrder").val()+'至'+$("#nextDateOrder").val()+'各供应商订单总数对比分析',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName,
		            axisLabel:{
		            	interval:0,
		            	rotate:20,
		            	margin:9,
		            	textStyle:{
		            		color:"#222",
		            	},
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            type:'bar',
		            data:datas,
		            barWidth : 40
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption);
}
function barOrderSupplier2(datas,dataName) {
	var barChart = echarts.init(document.getElementById('barOrderSupplier2'));
	var barOption = {
		    title : {
		        text: $("#prevDateOrder").val()+'至'+$("#nextDateOrder").val()+'各供应商销量对比分析',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName,
		            axisLabel:{
		            	interval:0,
		            	rotate:20,
		            	margin:9,
		            	textStyle:{
		            		color:"#222",
		            	},
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            type:'bar',
		            data:datas,
		            barWidth : 40
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption);
}
function barOrderSupplier3(datas,dataName) {
	var barChart = echarts.init(document.getElementById('barOrderSupplier3'));
	var barOption = {
		    title : {
		        text: $("#prevDateOrder").val()+'至'+$("#nextDateOrder").val()+'各供应商销售额对比分析',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName,
		            axisLabel:{
		            	interval:0,
		            	rotate:20,
		            	margin:9,
		            	textStyle:{
		            		color:"#222",
		            	},
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            type:'bar',
		            data:datas,
		            barWidth : 40
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption); 
}
function pieOrderSupplier1(array){
	var pieChart = echarts.init(document.getElementById('pieOrderSupplier1'));
	var pieOption={
		title : {
	        text: $("#prevDateOrder").val()+'至'+$("#nextDateOrder").val()+'各供应商订单总数占比分析',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:array,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	 }
	 pieChart.setOption(pieOption);
}
function pieOrderSupplier2(array){
	var pieChart = echarts.init(document.getElementById('pieOrderSupplier2'));
	var pieOption={
		title : {
	        text: $("#prevDateOrder").val()+'至'+$("#nextDateOrder").val()+'各供应商销量占比分析',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:array,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	 }
	 pieChart.setOption(pieOption);
}
function pieOrderSupplier3(array){
	var pieChart = echarts.init(document.getElementById('pieOrderSupplier3'));
	var pieOption={
		title : {
	        text: $("#prevDateOrder").val()+'至'+$("#nextDateOrder").val()+'各供应商销售额占比分析',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:array,
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	 }
	 pieChart.setOption(pieOption);
}