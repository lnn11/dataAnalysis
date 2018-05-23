function Appendzero(obj)
{  
		if(obj<10) {
			return "0" +""+ obj; 
		}
		else {
			return obj;  
		}
};
$(function(){
	var time = new Date();
	var month = time.getMonth()+1;
	var day = time.getDate();
	var year = time.getFullYear();
	$("#xiaoStartDate").val(year+'-'+Appendzero(month)+'-'+'0'+1+' '+'00:00:00');
	$("#xiaoEndDate").val(year+'-'+Appendzero(month)+'-'+Appendzero(day)+' 23:59:59')
});
function jsFile(){
	if(document.getElementById("xiaoData") == null){
		new_element=document.createElement("script");
		new_element.id="xiaoData";
		new_element.setAttribute("type","text/javascript");
		new_element.setAttribute("src","js/aiPinXuan/center/commodity/provider/xiaoData.js");// 在这里引入了xiaoData.js
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
var page = 1;var lastPage;var startTime = null;var overTime = null;
page2 = page;
ajaxLoading();
getData(null,null,page,true);firstDate();nowDate();
loadDataPic();loadPie();
ajaxLoadEnd();
$(".div").show();
$("#firstPage").click(function(){
	page = 1;$("#inputPage").val(page);
	page2 = page;
	getData(startTime,overTime,page,false);
	loadDataPic();
});
$("#lastPage").click(function(){
	page = page-1;if(page < 1 ) {page = 1;return;};page2 = page;$("#inputPage").val(page);getData(startTime,overTime,page,false);loadDataPic();
});
$("#nextPage").click(function(){	
	page = page+1;if(page > lastPage){page = lastPage;return;};page2 = page;$("#inputPage").val(page);getData(startTime,overTime,page,false);loadDataPic();
});
$("#endPage").click(function(){
	if(lastPage != 0) page = lastPage;
	page2 = page;
	$("#inputPage").val(page);
	getData(startTime,overTime,page,false);
	loadDataPic();
});
$("#goPage").click(function(){
	page = $("#inputPage").val();
	if(!isNaN(page)){
		page2 = page;
		if(page > lastPage) {page = lastPage;};
		if(page < 1){page = 1;};
		getData(startTime,overTime,page,false);
		loadDataPic();
	}else{
		alert("请正确输入数字格式！");
		page = page2;
		$("#inputPage").val(page);
	}
});
function firstDate(){
	startTime = $("#xiaoStartDate").val();
	return startTime;
};
function nowDate(){
	overTime = $("#xiaoEndDate").val();
	return overTime;
};
function tong(){
	startTime = $("#xiaoStartDate").val();
	overTime = $("#xiaoEndDate").val();	
	if(startTime <= overTime){
		page = 1;
		getData(startTime,overTime,page,true);loadDataPic();loadPie();
	}
};
function loadDataPic(){
	var dataName = [];
	var data = [];
	var dataMany = [];
	if(arrayList == 0){dataName=['暂无数据'];data=['暂无数据'];dataMany=['暂无数据'];$("#inputPage").val(page);lastPage = 1;$("#countPage").text(1)}
	else{
		$(arrayList).each(function(fi,fe){
		$(fe.list).each(function(i,e){
			dataName.push(e.NAME);data.push(e.SUMNUM);dataMany.push(e.manyBi+'%');
		});
		$("#inputPage").val(page);
		lastPage = fe.totalPage;
		$("#countPage").text(lastPage);
	});}
	$("#t").empty("");
	$("#t").show();
	$("#t").append("<tr id='t1' align='center'><td class='td' style='width:150px;height:38px;'><div id='sdiv'><b id='sab'>供应商</b><em id='sem'>销量</em></div></td></tr><tr id='t2' align='center'><td class='td'>销量(件)</td></tr><tr id='t3' align='center'><td class='td'>占比</td></tr>");
	for(var i=0;i<data.length ;i++){
		$("#t1").append("<td class='td' id='color'>"+dataName[i]+"</td>");
		$("#t2").append("<td class='td'>"+data[i]+"</td>");
		$("#t3").append("<td class='td'>"+dataMany[i]+"</td>");
	}
	bar(data,dataName);//柱状图赋值
};
function loadPie(){
	array = [];
	if(arrayList == 0){var map = {};map.name = '暂无数据';map.value = 0;array[0] = map;}
	else{
		$(arrayList).each(function(pi,pe){
			$(pe.list1).each(function(i,e){
				var map = {};map.name = e.NAME;map.value = e.SUMNUM;array[i] = map;
			});
		});
	}
	pie(array);	//饼状图数据封装到map
};
function bar(datas,dataName) {
	var barChart = echarts.init(document.getElementById('bar'));
	var barOption = {
		    title: {
		        text: startTime+'至'+overTime+'各供应商销售量对比分析',
		        x:'center',
		    },
		    tooltip : {
		        trigger: 'axis',
//		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
//		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
//		        }
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
			          bottom:90,
		          }
		    ],		    
		    yAxis : [
		        {
		            type : 'value',
		            axisLabel:{formatter:'{value}'},
		        }
		    ],
		    series : [
				{
		            type:'bar',
		            barWidth: '10%',
		            data:datas,
		        }
		    ]
		};
	// 为echarts对象加载数据 
	barChart.setOption(barOption); 
};
function pie(array){
	var pieChart = echarts.init(document.getElementById('pie'));
	var pieOption={
		title : {
	        text: startTime+'至'+overTime+'各供应商销售量占比分析',
	        x:'center',
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)",
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
	                    shadowColor: 'rgba(0, 0, 0, 0.5)',
	                }
	            },
	            radius:[0,'50%'],
	        }
	    ]
	 }
	 pieChart.setOption(pieOption);
};