var dataName = ['1月份','2月份','3月份','4月份','5月份','6月份','7月份','8月份','9月份','10月份','11月份','12月份'];
var orderMonth;
var ORDERNUM;//订单数
var orderSumIntegral;//订单总销售额
var orderProp;//订单占比
var orderIntegralProp;//订单总销售额占比
var orderSumNum;//销量
var orderSumNumProp;//销量占比

//给统计年份默认值
var dateYear = new Date();
$("#orderYear").val(dateYear.getFullYear());

mon();

$("#tong_orderTotal").click(function(){
	mon();
})

function aj() {
	$.ajax({
		url:'order/orderTotal',
		data:{orderYear:$("#orderYear").val()},
		dataType:"json",
		async:false,
		success:function(obj) {
			if(obj){
				orderMonth = [];
				ORDERNUM = [];
				orderSumIntegral = [];
				orderProp = [];
				orderIntegralProp = [];
				orderSumNum = [];
				orderSumNumProp = [];
				$(obj).each(function(i,e){
					ORDERNUM.push(e.orderNum);
					orderMonth.push(e.orderMonth+'月份');
					orderSumIntegral.push(e.orderSumIntegral);
					orderSumNum.push(e.sumNum);
					var ov = 0;
					if(e.orderProp==0) {
						ov = 0;
					}else{
						ov = e.orderProp+'%';
					}
					var oia = 0;
					if(e.orderIntegralProp==0) {
						oia = 0;
					}else{
						oia = e.orderIntegralProp+'%';
					}
					var osn = 0;
					if(e.sumNumProp==0) {
						osn = 0;
					}else{
						osn = e.sumNumProp+'%';
					}
					orderProp.push(ov);
					orderIntegralProp.push(oia);
					orderSumNumProp.push(osn);
				});
			}else{
				alert("没有数据");
			}
		},
		error:function() {
			alert("error");
		}
	});
}

//按月统计
function mon(){
		aj();
		$("#orderTotalTable").empty("");
		$("#orderTotalTable").show();
		$("#orderTotalTable").append("<tr id='orderTotal1'><th style='width:150px;height:40px;'><div id='sdiv'><b id='sab'>月份</b><em id='sem'>订单</em></div></th></tr><tr id='orderTotal2'><td>订单总数</td></tr><tr id='orderTotal3'><td>订单总数占比</td></tr><tr id='orderTotal4'><td>销量（件）</td></tr><tr id='orderTotal5'><td>销量占比</td></tr><tr id='orderTotal6'><td>销售额（元）</td></tr><tr id='orderTotal7'><td>销售额占比</td></tr>");
		for(var i=0;i<ORDERNUM.length ;i++){
				$("#orderTotal1").append("<td id='color'>"+orderMonth[i]+"</td>");
				$("#orderTotal2").append("<td>"+ORDERNUM[i]+"</td>");
				$("#orderTotal3").append("<td>"+orderProp[i]+"</td>");
				$("#orderTotal4").append("<td>"+orderSumNum[i]+"</td>");
				$("#orderTotal5").append("<td>"+orderSumNumProp[i]+"</td>");
				$("#orderTotal6").append("<td>"+orderSumIntegral[i]+"</td>");
				$("#orderTotal7").append("<td>"+orderIntegralProp[i]+"</td>");
		}
		$("#o1").show();
		$("#o2").show();
		$("#o3").show();
		
		$("#barOrder1").empty("");
		$("#barOrder2").empty("");
		$("#barOrder3").empty("");
		$("#pieOrder1").empty("");
		$("#pieOrder2").empty("");
		$("#pieOrder3").empty("");
		
		//柱状图赋值
		barOrder1(ORDERNUM,orderMonth);
		barOrder2(orderSumNum,orderMonth);
		barOrder3(orderSumIntegral,orderMonth);
		
		//饼状图数据封装到map
		var array1 = [];
		for(var i=0;i<orderMonth.length;i++){
			var map = {};
			map.name = orderMonth[i];
			map.value = ORDERNUM[i];
			array1[i] = map;
		}
		pieOrder1(array1);
		
		var array2 = [];
		for(var i=0;i<orderMonth.length;i++){
			var map = {};
			map.name = orderMonth[i];
			map.value = orderSumNum[i];
			array2[i] = map;
		}
		pieOrder2(array2);
		
		var array3 = [];
		for(var i=0;i<orderMonth.length;i++){
			var map = {};
			map.name = orderMonth[i];
			map.value = orderSumIntegral[i];
			array3[i] = map;
		}
		pieOrder3(array3);
}



$(":checkbox").click(function(){
	if($(this).attr("checked")!=undefined)
	{
		$(this).siblings().attr("checked",false);
		$(this).attr("checked",true);
	}
});


$("#month").click(function() {
	$("#month").attr("checked",true);
	mon();
});
//按供应商统计
$("#pro").click(function() {
	$("#centerComm").panel({
		href:'aiPinXuan/center/commodity/order/orderSupplier'
	})
})

	
function barOrder1(datas,dataName) {
	var barChart = echarts.init(document.getElementById('barOrder1'));
	var barOption = {
		    title : {
		        text: $("#orderYear").val()+'年各月份订单总数对比分析',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName
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
		            data:datas
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption);
}
function barOrder2(datas,dataName) {
	var barChart = echarts.init(document.getElementById('barOrder2'));
	var barOption = {
		    title : {
		        text: $("#orderYear").val()+'年各月份销量对比分析',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName
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
		            data:datas
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption);
}
function barOrder3(datas,dataName) {
	var barChart = echarts.init(document.getElementById('barOrder3'));
	var barOption = {
		    title : {
		        text: $("#orderYear").val()+'年各月份订单销售额对比分析',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName
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
		            data:datas
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption);
}
function pieOrder1(array){
	var pieChart = echarts.init(document.getElementById('pieOrder1'));
	var pieOption={
		title : {
	        text: $("#orderYear").val()+'年各月份订单总数占比分析',
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
function pieOrder2(array){
	var pieChart = echarts.init(document.getElementById('pieOrder2'));
	var pieOption={
		title : {
	        text: $("#orderYear").val()+'年各月份订单销量占比分析',
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
function pieOrder3(array){
	var pieChart = echarts.init(document.getElementById('pieOrder3'));
	var pieOption={
		title : {
	        text: $("#orderYear").val()+'年各月份订单销售额占比分析',
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