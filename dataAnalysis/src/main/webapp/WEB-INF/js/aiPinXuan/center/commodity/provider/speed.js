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
	$("#speedStartDate").val(year+'-'+Appendzero(month)+'-'+'0'+1+' '+'00:00:00');
	$("#speedEndDate").val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59');
});
function jsFile(){
	if(document.getElementById("speedData") == null){
		new_element=document.createElement("script");
		new_element.id="speedData";
		new_element.setAttribute("type","text/javascript");
		new_element.setAttribute("src","js/aiPinXuan/center/commodity/provider/speedData.js");// 在这里引入了speedData.js
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
getSupplierSpeedData(null,null,page,true);
firstDate();nowDate();loadSpeedDataPic();loadSpeedPie();
ajaxLoadEnd();$(".div").show();
$("#firstPage").click(function(){
	page = 1;$("#inputPage").val(page);
	page2 = page;
	getSupplierSpeedData(startTime,overTime,page,false);
	loadSpeedDataPic();
});
$("#lastPage").click(function(){
	page = page-1;if(page < 1 ) {page = 1;return;};page2 = page;$("#inputPage").val(page);getSupplierSpeedData(startTime,overTime,page,false);loadSpeedDataPic();
});
$("#nextPage").click(function(){
	page = page+1;if(page > lastPage){page = lastPage;return;};page2 = page;
	getSupplierSpeedData(startTime,overTime,page,false);loadSpeedDataPic();$("#inputPage").val(page);
});
$("#endPage").click(function(){
	if(lastPage != 0) page = lastPage;
	page2 = page;
	$("#inputPage").val(page);
	getSupplierSpeedData(startTime,overTime,page,false);
	loadSpeedDataPic();
});
$("#goPage").click(function(){
	page = $("#inputPage").val();
	if(!isNaN(page)){
		page2 = page;
		if(page > lastPage) {page = lastPage;};
		if(page < 1){page = 1;};
		getSupplierSpeedData(startTime,overTime,page,false);
		loadSpeedDataPic();
	}else{
		alert("请正确输入数字格式！");
		page = page2;
		$("#inputPage").val(page);
	}
});

function firstDate(){
	startTime = $("#speedStartDate").val();
	return startTime;
};
function nowDate(){
	overTime = $("#speedEndDate").val();
	return overTime;
};
function tongSpeed(){
	startTime = $("#speedStartDate").val();
	overTime = $("#speedEndDate").val();	
	if(startTime <= overTime){
		page = 1;
		getSupplierSpeedData(startTime,overTime,page,true);loadSpeedDataPic();loadSpeedPie();
	}
};
function loadSpeedDataPic(){
	var supplierName = [];
	var supplierOneOrderCount = [];
	var supplierOneSalesVolues = [];
	var supplierTwoOrderCount = [];
	var supplierTwoSalesVolues = [];
	var supplierThreeOrderCount = [];
	var supplierThreeSalesVolues = [];
	var supplierFourOrderCount = [];
	var supplierFourSalesVolues = [];
	$(arrayList).each(function(fi,fe){
		if(fe.list1 == 0 && fe.list2 == 0 && fe.list3 == 0 && fe.list4 == 0){
			supplierName=['暂无数据'];supplierOneOrderCount=['暂无数据'];supplierOneSalesVolues=['暂无数据'];
			supplierTwoOrderCount=['暂无数据'];supplierTwoSalesVolues=['暂无数据'];supplierThreeOrderCount=['暂无数据'];supplierThreeSalesVolues=['暂无数据'];
			supplierFourOrderCount=['暂无数据'];supplierFourSalesVolues=['暂无数据'];$("#inputPage").val(page);lastPage = 1;$("#countPage").text(1);$("#inputPage").val(1);
		}else{
			if(fe.list1.length == 0){supplierOneOrderCount.push(0);supplierOneSalesVolues.push(0);}else{
			$(fe.list1).each(function(i,e){
				supplierName.push(e.NAME);supplierOneOrderCount.push(e.ORDERNUM);supplierOneSalesVolues.push(e.SUMMONEY);
			});};
			if(fe.list2.length == 0){supplierTwoOrderCount.push(0);supplierTwoSalesVolues.push(0);}else{
			$(fe.list2).each(function(i,e){
				if(supplierName.length == 0){supplierName.push(e.NAME);};
				supplierTwoOrderCount.push(e.ORDERNUM);supplierTwoSalesVolues.push(e.SUMMONEY);
			});};
			if(fe.list3.length == 0){supplierThreeOrderCount.push(0);supplierThreeSalesVolues.push(0);}else{
			$(fe.list3).each(function(i,e){
				if(supplierName.length == 0){supplierName.push(e.NAME);};
				supplierThreeOrderCount.push(e.ORDERNUM);supplierThreeSalesVolues.push(e.SUMMONEY);
			});};
			if(fe.list4.length == 0){supplierFourOrderCount.push(0);supplierFourSalesVolues.push(0);}else{
			$(fe.list4).each(function(i,e){
				if(supplierName.length == 0){supplierName.push(e.NAME);};
				supplierFourOrderCount.push(e.ORDERNUM);supplierFourSalesVolues.push(e.SUMMONEY);
			});};
			$("#inputPage").val(page);
			lastPage = fe.totalPage;
			$("#countPage").text(lastPage);
		};
	});
	var tr1="<tr style='height:30px;width:200px;'>" +
			"<td class='tdspeed' rowspan='2' style='width:30px;'>" +
			"<div class='outSide'>" +
			"<b id='topB'>供应商</b>" +
			"<em id='bottomB'>发货速度</em></div></td>";
	var td2="<td class='tdspeed' colspan='2'>1个工作日内发货</td>";
	var td3="<td class='tdspeed' colspan='2'>1-2个工作日内发货</td>";
	var td4="<td class='tdspeed' colspan='2' >2-3个工作日内发货</td>";
	var td5="<td class='tdspeed' colspan='2' >超过3个工作日发货</td></tr>";
	var tr2="<tr style='height:35px;'><td class='tdspeed' id='supplierOneOrderCount' >订单总量</td><td class='tdspeed' id='supplierOneSalesVolues' >销售额</td><td class='tdspeed' id='supplierTwoOrderCount' >订单总量</td><td class='tdspeed' id='supplierTwoSalesVolues' >销售额</td>"+
		"<td class='tdspeed' id='supplierThreeOrderCount' >订单总量</td><td class='tdspeed' id='supplierThreeSalesVolues' >销售额</td><td class='tdspeed' id='supplierFourOrderCount' >订单总量</td><td class='tdspeed' id='supplierFourSalesVolues' >销售额</td></tr>";			
	$("#speedTable").empty("");
	$("#speedTable").show();
	$("#speedTable").append(tr1+td2+td3+td4+td5);
	$("#speedTable").append(tr2);
	for(var i=0;i<supplierName.length ;i++){
		$("#speedTable").append("<tr><td class='tdspeed' id='color'>"+supplierName[i]+"</td>"+"<td class='tdspeed' >"+supplierOneOrderCount[i]+"</td>"+"<td class='tdspeed' >"+supplierOneSalesVolues[i]+"</td>"+
				"<td class='tdspeed' >"+supplierTwoOrderCount[i]+"</td>"+"<td class='tdspeed' >"+supplierTwoSalesVolues[i]+"</td>"+"<td class='tdspeed' >"+supplierThreeOrderCount[i]+"</td>"+
				"<td class='tdspeed' >"+supplierThreeSalesVolues[i]+"</td>"+"<td class='tdspeed' >"+supplierFourOrderCount[i]+"</td>"+"<td class='tdspeed' >"+supplierFourSalesVolues[i]+"</td></tr>");
	};
	//柱状图赋值
	barSpeed(supplierOneOrderCount,supplierTwoOrderCount,supplierThreeOrderCount,supplierFourOrderCount,supplierName);
};

function loadSpeedPie(){
	array1 = [];array2 = [];array3 = [];array4 = [];
	$(arrayList).each(function(pi,pe){
		if(pe.list11 == 0 && pe.list22 == 0 && pe.list33 == 0 && pe.list44 == 0){
			var map = {};map.name = '暂无数据';map.value = 0;array1[0] = map;array2[0] = map;array3[0] = map;array4[0] = map;
		}else{
			if(pe.list11.length == 0){var map = {};map.name = '暂无数据';map.value = 0;array1[pi] = map;}else{
			$(pe.list11).each(function(oi,oe){
				var map = {};map.name = oe.NAME;map.value = oe.ORDERNUM;array1[oi] = map;
			});};
			
			if(pe.list22.length == 0){var map = {};map.name = '暂无数据';map.value = 0;array2[pi] = map;}else{
			$(pe.list22).each(function(ti,te){
				var map = {};map.name = te.NAME;map.value = te.ORDERNUM;array2[ti] = map;
			});};
			
			if(pe.list33.length == 0){var map = {};map.name = '暂无数据';map.value = 0;array3[pi] = map;}else{
			$(pe.list33).each(function(hi,he){
				var map = {};map.name = he.NAME;map.value = he.ORDERNUM;array3[hi] = map;
			});};
			
			if(pe.list44.length == 0){var map = {};map.name = '暂无数据';map.value = 0;array4[pi] = map;}else{
			$(pe.list44).each(function(fi,fe){
				var map = {};map.name = fe.NAME;map.value = fe.ORDERNUM;array4[fi] = map;
			});};
		};
	});
	pieSpeed1(array1);	//饼状图数据封装到map
	pieSpeed2(array2);
	pieSpeed3(array3);
	pieSpeed4(array4);
	$("#sp1").show();
	$("#sp2").show();
};
function barSpeed(orderCount1,orderCount2,orderCount3,orderCount4,dataName) {
	var barChart = echarts.init(document.getElementById('barSpeed'));
	var barOption = {
		    title : {
		        text: startTime+'至'+overTime+'各供应商发货速度对比分析',
		        x:'center',
		        textStyle:{
		        	color:'#595854',
		        },
		        padding:[10,5,50,5],
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : dataName,
		        }
		    ],
		    grid:[
		          {
		        	  x: 100,
			          x2: 100,
			          y2: 150,
			          top:50,
			          bottom:40,
		          }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'1个工作日内发货  订单总数',
		            type:'bar',
		            barWidth: '10%',
		            data:orderCount1,
		            barMinHeight:5,
		        },
		        {
		            name:'1-2个工作如内发货  订单总数',
		            type:'bar',
		            barWidth: '10%',
		            data:orderCount2,
		            barMinHeight:5,
		        },
		        {
		            name:'2-3个工作日内发货  订单总数',
		            type:'bar',
		            barWidth: '10%',
		            data:orderCount3,
		            barMinHeight:5,
		        },
		        {
		            name:'超过3个工作日发货  订单总数',
		            type:'bar',
		            barWidth: '10%',
		            data:orderCount4,
		            barMinHeight:5,
		        },
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption); 
}
function pieSpeed1(array){
	var pieChart = echarts.init(document.getElementById('pieSpeed1'));
	var pieOption={
		title : {
	        text: startTime+'至'+overTime+'期间各供应商1个工作日内发货订单占比分析',
	        x:'center',
	        textStyle:{
	        	color:'#595854',
	        },
	        padding:[20,5,20,5],
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
function pieSpeed2(array){
	var pieChart = echarts.init(document.getElementById('pieSpeed2'));
	var pieOption={
		title : {
	        text: startTime+'至'+overTime+'期间各供应商1-2个工作日内发货订单占比分析',
	        x:'center',
	        textStyle:{
	        	color:'#595854',
	        },
	        padding:[20,5,20,5],
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
function pieSpeed3(array){
	var pieChart = echarts.init(document.getElementById('pieSpeed3'));
	var pieOption={
		title : {
	        text: startTime+'至'+overTime+'期间各供应商2-3个工作日内发货订单占比分析',
	        x:'center',
	        textStyle:{
	        	color:'#595854',
	        },
	        padding:[20,5,20,5],
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
function pieSpeed4(array){
	var pieChart = echarts.init(document.getElementById('pieSpeed4'));
	var pieOption={
		title : {
	        text: startTime+'至'+overTime+'期间各供应商超过3个工作日发货订单占比分析',
	        x:'center',
	        textStyle:{
	        	color:'#595854',
	        },
	        padding:[20,5,20,5],
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