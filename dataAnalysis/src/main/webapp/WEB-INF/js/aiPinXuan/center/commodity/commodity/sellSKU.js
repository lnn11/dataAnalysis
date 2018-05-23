var dataName = ['1月份','2月份','3月份','4月份','5月份','6月份','7月份','8月份','9月份','10月份','11月份','12月份'];
var productSumIntegral;//订单总销售额
var productIntegralProp;//订单总销售额占比
var productSumNum;//销量
var productSumNumProp;//销量占比

//给统计年份默认值
var dateYear = new Date();
$("#productYear").val(dateYear.getFullYear());

sellSku();

$("#tong_sellSku").click(function(){
	sellSku();
})
	
function getProduct(){
	$.ajax({
		url:'product/productTotal',
		data:{productYear:$("#productYear").val()},
		dataType:"json",
		async:false,
		success:function(obj) {
			if(obj){
				orderMonth = [];
				productSumIntegral = [];
				productIntegralProp = [];
				productSumNum = [];
				productSumNumProp = [];
				$(obj).each(function(i,e){
					orderMonth.push(e.orderMonth+'月份');
					productSumIntegral.push(e.orderSumIntegral);
					productSumNum.push(e.sumNum);
					var ov = 0;
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
					productIntegralProp.push(oia);
					productSumNumProp.push(osn);
				});
			}else{
				alert("没有数据");
			}
		},
		error:function() {
			alert("error");
		}
	});
};

function sellSku(){
	getProduct();
	$("#sellSKUTable").empty("");
	$("#sellSKUTable").show();
	$("#sellSKUTable").append("<tr id='sellSKU1' align='center'><th style='width:150px;height:40px;'><div id='sdiv'><b id='sab'>月份</b><em id='sem'>销量/销售额</em></div></th></tr><tr id='sellSKU2' align='center'><td>销量</td></tr><tr id='sellSKU3' align='center'><td>销量占比</td></tr><tr id='sellSKU4' align='center'><td>销售额</td></tr><tr id='sellSKU5' align='center'><td>销售额占比</td></tr>");
	for(var i=0;i<dataName.length ;i++){
		$("#sellSKU1").append("<td id='color'>"+orderMonth[i]+"</td>");
		$("#sellSKU2").append("<td>"+productSumNum[i]+"</td>");
		$("#sellSKU3").append("<td>"+productSumNumProp[i]+"</td>");
		$("#sellSKU4").append("<td>"+productSumIntegral[i]+"</td>");
		$("#sellSKU5").append("<td>"+productIntegralProp[i]+"</td>");
	}
	
	$("#ss1").show();
	$("#ss2").show();
	
	
	//柱状图赋值
	barSellSku1(productSumNum,orderMonth);
	barSellSku2(productSumIntegral,orderMonth);
	
	//饼状图数据封装到map
	var array = [];
	for(var i=0;i<orderMonth.length;i++){
		var map = {};
		map.name = orderMonth[i];
		map.value = productSumNum[i];
		array[i] = map;
	}
	pieSellSku1(array);	
	
	var array2 = [];
	for(var i=0;i<orderMonth.length;i++){
		var map = {};
		map.name = orderMonth[i];
		map.value = productSumIntegral[i];
		array2[i] = map;
	}
	pieSellSku2(array2);
	
	function barSellSku1(datas,dataName) {
		var barChart = echarts.init(document.getElementById('barSellSku1'));
		var barOption = {
				title : {
					text: $("#productYear").val()+'年销量对比分析',
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
	function barSellSku2(datas,dataName) {
		var barChart = echarts.init(document.getElementById('barSellSku2'));
		var barOption = {
				title : {
					text: $("#productYear").val()+'年销售额对比分析',
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
	function pieSellSku1(array){
		var pieChart = echarts.init(document.getElementById('pieSellSku1'));
		var pieOption={
				title : {
					text: $("#productYear").val()+'年销量占比分析',
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
	function pieSellSku2(array2){
		var pieChart = echarts.init(document.getElementById('pieSellSku2'));
		var pieOption={
				title : {
					text: $("#productYear").val()+'年销售额占比分析',
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
	
};
