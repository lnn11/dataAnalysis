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
	$("#salesStartDate").val(year+'-'+Appendzero(month)+'-'+'0'+1+' '+'00:00:00');
	$("#salesEndDate").val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59')
});
function jsFile(){
	if(document.getElementById("saleData") == null){
		new_element=document.createElement("script");
		new_element.id="saleData";
		new_element.setAttribute("type","text/javascript");
		new_element.setAttribute("src","js/aiPinXuan/center/commodity/provider/saleData.js");// 在这里引入了saleData.js
		document.body.appendChild(new_element);
	}
};
jsFile();
function ajaxLoading(){
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2}); 
 }
 function ajaxLoadEnd(){
     $(".datagrid-mask").remove();
     $(".datagrid-mask-msg").remove();
}
var page = 1;var lastPage;var startTime = null;var overTime = null;page2 = page;ajaxLoading();
getSaleData(null,null,page,true);firstDate();nowDate();
loadSaleDataPic();loadPie();
ajaxLoadEnd();$(".div").show();
$("#firstPage").click(function(){
	page = 1;$("#inputPage").val(page);
	page2 = page;
	getSaleData(startTime,overTime,page,false);
	loadSaleDataPic();
});
$("#lastPage").click(function(){
	page = page-1;if(page < 1 ) {page = 1;return;};page2 = page;$("#inputPage").val(page);getSaleData(startTime,overTime,page,false);loadSaleDataPic();
});
$("#nextPage").click(function(){
	page = page+1;if(page > lastPage){page = lastPage;return;};page2 = page;$("#inputPage").val(page);getSaleData(startTime,overTime,page,false);loadSaleDataPic();
});
$("#endPage").click(function(){
	if(lastPage != 0) page = lastPage;
	page2 = page;
	$("#inputPage").val(page);
	getSaleData(startTime,overTime,page,false);
	loadSaleDataPic();
});
$("#goPage").click(function(){
	page = $("#inputPage").val();
	if(!isNaN(page)){
		page2 = page;
		if(page > lastPage) {page = lastPage;};
		if(page < 1){page = 1;};
		getSaleData(startTime,overTime,page,false);
		loadSaleDataPic();
	}else{
		alert("请正确输入数字格式！");
		page = page2;
		$("#inputPage").val(page);
	}
});

function loadPie(){
	array = [];
	if(arrayList == 0){var map = {};map.name = '暂无数据';map.value = 0;array[0] = map;}
	else{
		$(arrayList).each(function(pi,pe){
			$(pe.listC).each(function(i,e){
				var map = {};map.name = e.NAME;map.value = e.SUMMONEY;array[i] = map;
			});
		});
	}
	pieSale(array);	//饼状图数据封装到map
};
	
function firstDate(){
	startTime =  $("#salesStartDate").val();
	return startTime;
};
function nowDate(){
	overTime = $("#salesEndDate").val();
	return overTime;
};

function tongSale(){
	startTime = $("#salesStartDate").val();
	overTime = $("#salesEndDate").val();	
	if(startTime <= overTime){
		page = 1;
		getSaleData(startTime,overTime,page,true);loadSaleDataPic();loadPie();
	}
};

function loadSaleDataPic(){
	var dataName = [];
	var data = [];
	var dataMany = [];
	if(arrayList == 0){dataName=['暂无数据'];data=['暂无数据'];dataMany=['暂无数据'];$("#inputPage").val(page);lastPage = 1;$("#countPage").text(1)}
	else{
		$(arrayList).each(function(fi,fe){
		$(fe.list).each(function(i,e){
			dataName.push(e.NAME);data.push(e.SUMMONEY);dataMany.push(e.manyBi+'%');
		});
		$("#inputPage").val(page);
		lastPage = fe.totalPage;
		$("#countPage").text(lastPage);
	});}
	$("#saleTable").empty("");
	$("#saleTable").show();
	$("#saleTable").append("<tr id='sale1' align='center'><td class='td' style='width:150px;height:38px;'><div id='sdiv'><b id='sab'>供应商</b><em id='sem'>销售额</em></div></td></tr><tr id='sale2' align='center'><td class='td' >销售额（元）</td></tr><tr id='sale3' align='center'><td class='td' >占比</td></tr>");
	for(var i=0;i<data.length ;i++){
		$("#sale1").append("<td class='td' id='color'>"+dataName[i]+"</td>");
		$("#sale2").append("<td class='td' >"+data[i]+"</td>");
		$("#sale3").append("<td class='td' >"+dataMany[i]+"</td>");
	}
	barSale(data,dataName);//柱状图赋值
};
function barSale(datas,dataName) {
	var barChart = echarts.init(document.getElementById('barSale'));
	var barOption = {
		    title: {
		        text: startTime+'至'+overTime+'各供应商销售额对比分析',
		        x:'center',
		        textStyle:{
		        	color:'#595854',
		        },
		        padding:[10,5,50,5],
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName,
		            axisLabel:{
		            	interval:0,
		            	rotate:45,
		            	margin:9,
		            	textStyle:{
		            		color:"#222",
		            	},
		            }
		        }
		    ],
		    grid:[
		          {
		        	  x: 100,
			          x2: 100,
			          y2: 150,
			          top:50,
			          bottom:60,
		          }
		    ],
		    tooltip : {
		        trigger: 'axis',
//		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
//		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
//		        }
		    },
		    yAxis : [
		        {
		            type : 'value',
		            axisLabel:{formatter:'{value}'}
		        }
		    ],
		    series : [
				{
		            type:'bar',
		            barWidth: '10%',
		            data:datas
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption); 
}
function pieSale(array){
	var pieChart = echarts.init(document.getElementById('pieSale'));
	var pieOption={
		title : {
	        text: startTime+'至'+overTime+'各供应商销售额占比分析',
	        x:'center',
	        textStyle:{
	        	color:'#595854',
	        },
	        padding:[10,5,50,5],
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
	            },
	            radius:[0,'50%'],
	        }
	    ]
	 }
	 pieChart.setOption(pieOption);
}